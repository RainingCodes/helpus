package dduwcom.mobile.helpus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Menstruation#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Menstruation extends Fragment {
    private HelpAdapter helpAdapter;
    private ListView listView;
    HelpDataManager helpDataManager;

    public Menstruation() {
        // Required empty public constructor
    }

    public static Menstruation newInstance() {
        return  new Menstruation();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menstruation, container, false);
    }
}