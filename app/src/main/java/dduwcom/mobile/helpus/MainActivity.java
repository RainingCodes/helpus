package dduwcom.mobile.helpus;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private HelpAdapter helpAdapter;
    HelpDataManager helpDataManager;
    private String TAG = "MainActivity";
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    final int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        Fragment fragment1 = new Help_List();
        fragmentTransaction.replace(R.id.container, fragment1);
        fragmentTransaction.commitNow();

        BottomNavigationView navView = findViewById(R.id.bottomNavigationView);
        navView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                            Fragment fragment;
                            switch (item.getItemId()) {
                                case R.id.help:
                                    fragment = fragment1;
                                    break;

                                default:
                                    fragment = fragment1;
                                    break;
                            }
                            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                        return true;
                    }
                }
        );


    }

    public void onClick(View v) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivityForResult(intent, REQ_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        helpDataManager = new HelpDataManager();
        ArrayList<HelpData> helpDataList = helpDataManager.getHelpDataList();
        helpAdapter = new HelpAdapter(this, helpDataList);

        switch (requestCode){
            case REQ_CODE:
                if(resultCode == RESULT_OK){
                    //도움 등록시
                    HelpData newData = (HelpData) data.getSerializableExtra("data");
                    helpDataManager.addHelpData(newData);
                }
                else{
                    //도움 등록 취소시
                    Toast.makeText(MainActivity.this, "도움 요청 취소", Toast.LENGTH_SHORT).show();
                }
                helpAdapter.notifyDataSetChanged();
                break;
        }
    }


}