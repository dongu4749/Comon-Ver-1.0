package se.jbnu.final_project_3year;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Quiz_Short_Answer_Activity extends AppCompatActivity {
    private boolean Quiz_Check=false;
    boolean short_check = false;
    Toolbar toolbar;
    String answer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_short_answer);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Dialog dialogcorrect = new Dialog(this);
        Dialog dialogwrong = new Dialog(this);
        dialogcorrect.setContentView(R.layout.activity_dialog_correct);
        dialogwrong.setContentView(R.layout.activity_dialog_wrong);

        EditText quiz_short = (EditText) findViewById(R.id.edittext_JavaQuiz_short_answer);
        Button imageButtonQuizC = (Button) findViewById(R.id.buttonCheckQuiz_short_answer);

        Button imageButtonSubmit = (Button) dialogcorrect.findViewById(R.id.buttonSubmit);
        Button imageButtonSubmit2 = (Button) dialogwrong.findViewById(R.id.buttonSubmit2);

        imageButtonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Short_Answer_Activity2.class);
                startActivity(intent);
            }
        });
        imageButtonSubmit2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Short_Answer_Activity.class);
                startActivity(intent);
            }
        });

        imageButtonQuizC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveKeyValue("recent_quiz_history", Fragment_Progress.SUB[0]);
                answer = quiz_short.getText().toString().trim();
                Quiz_Check = (answer.equals("클래스") || answer.equals("Class") || answer.equals("class"));

                if(Quiz_Check){
                    if(checkFirst(Fragment_Progress.check_SUB[0])){
                        // Fragment_Progress.progress_Short_Value += 10;
                        saveKeyValue(Fragment_Progress.check_SUB[0], "true");
                    }
                    short_check = true;
                    dialogcorrect.show();
                    dialogcorrect.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                } else{
                    dialogwrong.show();
                    dialogwrong.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
            }
        });


    }
    public void saveKeyValue(String key, String value){
        SharedPreferences sharedPreferences = getSharedPreferences(key, MODE_PRIVATE);    // test 이름의 기본모드 설정
        SharedPreferences.Editor editor= sharedPreferences.edit(); //sharedPreferences를 제어할 editor를 선언
        editor.putString(key,value); // key,value 형식으로 저장
        editor.commit();    //최종 커밋. 커밋을 해야 저장이 된다.
    }
    public String getValue(String key){
        SharedPreferences sharedPreferences= getSharedPreferences(key, Context.MODE_PRIVATE);    // test 이름의 기본모드 설정, 만약 test key값이 있다면 해당 값을 불러옴.
        String value = sharedPreferences.getString(key,"false");
        return value;
    }
    public boolean checkFirst(String str){
        return getValue(str).equals("false");
    }
}
