package dduwcom.mobile.helpus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

    public static Help_List newInstance() {
        // Required empty public constructor
        return new Help_List();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View v = inflater.inflate(R.layout.fragment_help_list, container, false);


        listView = v.findViewById(R.id.customListView);
        listView.setAdapter((ListAdapter) helpAdapter);


        //클릭하면 대화상자
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HelpDialog helpDialog = new HelpDialog(getActivity());
                helpDialog.callFunction(position);
                helpAdapter.notifyDataSetChanged();
            }
        });



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_help_list, container, false);
    }



}