package se.jbnu.final_project_3year;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Progress#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Progress extends Fragment {
    // 문제 유형 별 문제의 개수
    public static int num_BC=1;
    public static int num_MUL=3;
    public static int num_SUB=3;
    // 문제 유형 별 현재 맞춘 개수
    public static int curr_num_BC=0;
    public static int curr_num_MUL=0;
    public static int curr_num_SUB=0;
    // 문제 유형 별 포인트 값
    public static int point_BC=10;
    public static int point_MUL=10;
    public static int point_SUB=10;

    // 문제 유형 별 누적 포인트 값
    public static int curr_point_BC = 0;
    public static int curr_point_MUL = 0;
    public static int curr_point_SUB = 0;
    // 문제 유형별 진행률
    public static int per_BC=0;
    public static int per_MUL=0;
    public static int per_SUB=0;

    public static String [] BC = {"quiz_type_1_block_coding_num_1"};
    public static String [] MUL = {"quiz_type_2_choice_num_1", "quiz_type_2_choice_num_2", "quiz_type_2_choice_num_3"};
    public static String [] SUB = {"quiz_type_3_write_num_1", "quiz_type_3_write_num_2", "quiz_type_3_write_num_3"};

    public static String [] check_BC = {"progress_Block_Value_Check_num_1"};
    public static String [] check_MUL = {"progress_Multiple_Value_Check_num_1", "progress_Multiple_Value_Check_num_2", "progress_Multiple_Value_Check_num_3"};
    public static String [] check_SUB = {"progress_Subject_Value_Check_num_1", "qprogress_Subject_Value_Check_num_2", "progress_Subject_Value_Check_num_3"};
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static int progress_Multiple_Value=0;
    public static int progress_Short_Value=0;
    public static int progress_Block_Value=0;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_Progress() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CodingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Progress newInstance(String param1, String param2) {
        Fragment_Progress fragment = new Fragment_Progress();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_progress, container, false);

        Toolbar myToolbar = (Toolbar) v.findViewById(R.id.my_toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(myToolbar);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

        FloatingActionButton floatingActionButton = v.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new FABClickListener());


        updateScore();


        ProgressBar progressBarBlock = v.findViewById(R.id.progressBarBlock);
        progressBarBlock.setProgress(per_BC);
        ProgressBar progressBarSubject = v.findViewById(R.id.progressBarSubject);
        progressBarSubject.setProgress(per_SUB);
        ProgressBar progressBarMultiple = v.findViewById(R.id.progressBarMultiple);
        progressBarMultiple.setProgress(per_MUL);

        String str = Integer.toString(per_MUL)+"%";

        TextView textViewMultiplePercentage = v.findViewById(R.id.textViewMultiplePercentage);
        textViewMultiplePercentage.setText(str);

        str = Integer.toString(per_SUB)+"%";
        TextView textViewSubjectPercentage = v.findViewById(R.id.textViewSubjectPercentage);
        textViewSubjectPercentage.setText(str);

        str = Integer.toString(per_BC)+"%";
        TextView textViewBlockPercentage = v.findViewById(R.id.textViewBlockPercentage);
        textViewBlockPercentage.setText(str);
        return v;
        // Inflate the layout for this fragment
    }
    class FABClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            // FAB Click 이벤트 처리 구간
            Intent intent = new Intent(getActivity().getApplicationContext(), CodingActivity.class);
            startActivity(intent);
        }
    }
    public void saveKeyValue(String key, String value){
        //  SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(key, MODE_PRIVATE);    // test 이름의 기본모드 설정
        SharedPreferences.Editor editor= sharedPreferences.edit(); //sharedPreferences를 제어할 editor를 선언
        editor.putString(key,value); // key,value 형식으로 저장
        editor.commit();    //최종 커밋. 커밋을 해야 저장이 된다.
    }

    public String getValue(String key){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(key, MODE_PRIVATE);    // test 이름의 기본모드 설정, 만약 test key값이 있다면 해당 값을 불러옴.
        String str_Block = sharedPreferences.getString(key,"false");
        return str_Block;
    }
    // 해당 문제를 단 1회도 풀지 않았을 경우 1을 true 리턴
    public boolean checkFirst(String str){
        Log.d("CHECK_FIRST_STR", str);
        Log.d("CHECK_FIRST",getValue(str));
        Log.d("CHECK_FIRST_RESULT", Boolean.toString(getValue(str).equals("false")));

        return getValue(str).equals("false");
    }
    // 문제 유형별로 맞춘 문제의 개수를 계산
    public void checkRightNumofQuiz(){
        for(int i=0; i< num_BC; i++){
            if(curr_num_BC < num_BC)
                if(!checkFirst(check_BC[i])) curr_num_BC++;
        }
        for(int i=0; i< num_MUL; i++){
            if(curr_num_MUL < num_MUL)
                if(!checkFirst(check_MUL[i])) curr_num_MUL++;
        }
        for(int i=0; i< num_SUB; i++){
            if(curr_num_SUB < num_SUB)
                if(!checkFirst(check_SUB[i])) curr_num_SUB++;
        }
        Log.d("CHECK_CURR",Integer.toString(curr_num_BC) );
        Log.d("CHECK_CURR",Integer.toString(curr_num_SUB) );
        Log.d("CHECK_CURR",Integer.toString(curr_num_MUL) );
    }
    // 문제 유형별로 점수를 계산 - 필요한가 싶음...
    public void calculateScore() {
        curr_point_BC = curr_num_BC * point_BC;
        curr_point_MUL = curr_num_MUL * point_MUL;
        curr_point_SUB =  curr_num_SUB * point_SUB;

        Log.d("CHECK_CURR_POINT",Integer.toString(curr_point_BC) );
        Log.d("CHECK_CURR_POINT",Integer.toString(curr_point_SUB) );
        Log.d("CHECK_CURR_POINT",Integer.toString(curr_point_MUL) );
    }


    public void updateScore(){
        Log.d("UPDATE_SCORE", Integer.toString(per_MUL));
        checkRightNumofQuiz();
        Log.d("UPDATE_SCORE", Integer.toString(per_MUL));
        calculateScore();
        Log.d("UPDATE_SCORE", Integer.toString(per_MUL));
        calculatePercentage();

        Log.d("UPDATE_SCORE", Integer.toString(per_MUL));
    }

    public static void calculatePercentage(){
        float target = (float) (curr_num_MUL*100) / (float) num_MUL;
        per_MUL = (int) target;
//        double d = (double) curr_num_MUL;
//        Log.d("CHECK_Percentage", Double.toString(d));
//        d*=100;
//        Log.d("CHECK_Percentage", Double.toString(d));
//        d/=num_MUL;
//        Log.d("CHECK_Percentage", Double.toString(d));

        Log.d("CHECK_Percentage",Float.toString(target) );

        target = curr_num_SUB * 100/ (float)num_SUB;
        per_SUB = (int) target;
        Log.d("CHECK_Percentage",Float.toString(target) );

        target = curr_num_BC * 100/ (float)num_BC;
        per_BC = (int) target;
        Log.d("CHECK_Percentage",Float.toString(target) );
    }
}
