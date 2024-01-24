package com.example.learning;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG ="MainActivity";
    private static final String KEY_INDEX = "index";
    private static final int REQUEST_CODE_CHEAT = 0;
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mCheatButton;
    private TextView mQuestionTextview;

    private Question[] mQuestionBank =new Question[]{
            new Question(R.string.question_africas,false),
            new Question(R.string.question_Amaricas,true),
            new Question(R.string.question_asia,true),
            new Question(R.string.question_oceans,true),
            new Question(R.string.question_australia,false)
    };
    private  int mCurrentIndex = 0;
    private boolean mIsCheater;

    private void updateQuestion(){
//        Log.d(TAG,"Updating question text",new Exception());
        int question=mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextview.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if (mIsCheater){
            messageResId=R.string.judgment_toast;
        }else {
            if (userPressedTrue == answerIsTrue){
                messageResId =R.string.correct_toast;
            }else{
                messageResId =R.string.incorrect_toast;
        }

        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreat(Bundle) called");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            mCurrentIndex =savedInstanceState.getInt(KEY_INDEX,0);
        }

        mQuestionTextview=(TextView) findViewById(R.id.question_text_View);

//        int question=mQuestionBank[mCurrentIndex].getTextResId();
//        mQuestionTextview.setText(question);
        updateQuestion();

        mCheatButton = (Button)findViewById(R.id.cheat_btn);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start cheatact
//                Intent intent = new Intent(MainActivity.this, CheatActivity.class);
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
                Intent intent = CheatActivity.newIntent(MainActivity.this,answerIsTrue);
//                startActivity(intent);
                startActivityForResult(intent,REQUEST_CODE_CHEAT);
            }
        });

        mNextButton =(Button) findViewById(R.id.next_btn);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex =(mCurrentIndex + 1)%mQuestionBank.length;
//                int question = mQuestionBank[mCurrentIndex].getTextResId();
//                mQuestionTextview.setText(question);
                mIsCheater =false;
                updateQuestion();
            }
        });



        mTrueButton =(Button) findViewById(R.id.true_btn);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
//                Toast.makeText(MainActivity.this,
//                        R.string.correct_toast,
//                        Toast.LENGTH_SHORT).show();
            }
        });
        mFalseButton =(Button) findViewById(R.id.false_btn);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
//                Toast.makeText(MainActivity.this,
//                        R.string.incorrect_toast,
//                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_CODE_CHEAT) {
            if (data == null) {
                return;
            }
            mIsCheater = CheatActivity.wasAnswerShown(data);
        }
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"onStart() called");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"onResume() called");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"onStop() called");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy() called");
    }
}
