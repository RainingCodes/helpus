package dduwcom.mobile.helpus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Help_List#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Help_List extends Fragment{

    private HelpAdapter helpAdapter;
    private ListView listView;
    HelpDataManager helpDataManager;
    final int REQ_CODE = 100;
    FloatingActionButton btn_add;

    public static Help_List newInstance() {
        // Required empty public constructor
        return new Help_List();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        helpDataManager = new HelpDataManager();
        ArrayList<HelpData> helpDataList = helpDataManager.getHelpDataList();
        Context context = getActivity().getBaseContext();


        helpAdapter = new HelpAdapter(context, R.layout.help_list, helpDataList);
        View v = inflater.inflate(R.layout.fragment_help_list, container, false);

        listView = v.findViewById(R.id.customListView);
        listView.setAdapter((ListAdapter) helpAdapter);
        btn_add = v.findViewById(R.id.addBtn);


        //클릭하면 대화상자
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HelpDialog helpDialog = new HelpDialog(context);
                helpDialog.callFunction(position);
                helpAdapter.notifyDataSetChanged();
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddActivity.class);
                startActivityForResult(intent, REQ_CODE);
            }
        });



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help_list, container, false);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
                    Toast.makeText(this.getContext(), "도움 요청 취소", Toast.LENGTH_SHORT).show();
                }
                helpAdapter.notifyDataSetChanged();
                break;
        }
    }


}