//package com.example.criminalintent;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//
//import java.util.UUID;
//
//public class CrimeActivity extends SingleFragmentActivity {
//
//    private static final String EXTAR_CRIME_ID =
//            "com.example.criminalintent.crime_id";
//
//    public static Intent newIntent(Context packageContext, UUID crimeID){
//        Intent intent =new Intent(packageContext ,CrimeActivity.class);
//        intent.putExtra(EXTAR_CRIME_ID,crimeID);
//        return intent;
//    }
//
//
//
//    @Override
//    protected Fragment creareFragment() {
//
////        return new CrimeFragment();
//        UUID crimeID =(UUID) getIntent().getSerializableExtra(EXTAR_CRIME_ID);
//        return CrimeFragment.newInstance(crimeID);
//    }
//
//
//}