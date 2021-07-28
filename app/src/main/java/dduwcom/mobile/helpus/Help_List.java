package dduwcom.mobile.helpus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment help_list.
     */
    // TODO: Rename and change types and number of parameters

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
        Context context = getContext();

        helpAdapter = new HelpAdapter(context, R.layout.help_list, helpDataList);
        View v = inflater.inflate(R.layout.fragment_help_list, container, false);

        출처: https://swalloow.tistory.com/87 [MyCloud]
        listView = v.findViewById(R.id.customListView);
        listView.setAdapter((ListAdapter) helpAdapter);


        //클릭하면 대화상자
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                HelpDialog helpDialog = new HelpDialog(context);
                helpDialog.callFunction(position);
                helpAdapter.notifyDataSetChanged();
            }
        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help_list, container, false);
    }




}