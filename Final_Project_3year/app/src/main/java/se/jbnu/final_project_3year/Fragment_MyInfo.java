package se.jbnu.final_project_3year;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_MyInfo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_MyInfo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_MyInfo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_MyInfo newInstance(String param1, String param2) {
        Fragment_MyInfo fragment = new Fragment_MyInfo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu, menu);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_myinfo, container, false);
        Toolbar myToolbar = (Toolbar) v.findViewById(R.id.my_toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(myToolbar);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView textview_email = (TextView) v.findViewById(R.id.textViewEmail);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        textview_email.setText(user.getEmail());
        Button imageButtonNotice = (Button) v.findViewById(R.id.button_Notice);
        Button imageButtonQna= (Button) v.findViewById(R.id.button_Qna);
        imageButtonNotice.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ((HomeActivity)getActivity()).replaceFragment(NoticeFragment.newInstance());
            }
        });
        imageButtonQna.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ((HomeActivity)getActivity()).replaceFragment(QuestionFragment.newInstance());
            }
        });
        return v;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                ((HomeActivity)getActivity()).replaceFragment(SettingFragment.newInstance());
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
