package dduwcom.mobile.helpus;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final int REQ_CODE = 100;

    private HelpAdapter helpAdapter;
    private ListView listView;
    private String TAG = "MainActivity";
    HelpDataManager helpDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helpDataManager = new HelpDataManager();
        ArrayList<HelpData> helpDataList = helpDataManager.getHelpDataList();

        helpAdapter = new HelpAdapter(this, R.layout.help_list, helpDataList);
        listView = findViewById(R.id.customListView);
        listView.setAdapter((ListAdapter) helpAdapter);

        //클릭하면 대화상자
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, helpDataList.get(position).getLocation(), Toast.LENGTH_SHORT).show();
//                Log.d(TAG, "dmddmd");
//                HelpDialog helpDialog = new HelpDialog(MainActivity.this);
//
//                helpDialog.callFunction(position);
            }
        });
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.addBtn:
                //도움 요청 입력하는 창으로 넘어가기
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, REQ_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

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