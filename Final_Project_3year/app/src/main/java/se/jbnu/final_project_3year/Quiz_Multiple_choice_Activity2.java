package se.jbnu.final_project_3year;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Quiz_Multiple_choice_Activity2 extends AppCompatActivity {
    private boolean Quiz_Check=false;
    private boolean selected = false;
    Toolbar toolbar;
    boolean multiple_check2 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_multiple_choice_quiz2);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Dialog dialogcorrect = new Dialog(this);
        Dialog dialogwrong = new Dialog(this);
        dialogcorrect.setContentView(R.layout.activity_dialog_correct);
        dialogwrong.setContentView(R.layout.activity_dialog_wrong);

        Button imageButtonQuizint = (Button) findViewById(R.id.buttonintQuiz);
        Button imageButtonQuizlonglong = (Button) findViewById(R.id.buttonlonglongQuiz);
        Button imageButtonQuizdouble = (Button) findViewById(R.id.buttondoubleQuiz);
        Button imageButtonQuizchar = (Button) findViewById(R.id.buttoncharQuiz);
        Button imageButtonCheckQuiz2 = (Button) findViewById(R.id.buttonCheckQuiz2);
        Button imageButtonSubmit = (Button) dialogcorrect.findViewById(R.id.buttonSubmit);
        Button imageButtonSubmit2 = (Button) dialogwrong.findViewById(R.id.buttonSubmit2);
        imageButtonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Multiple_choice_Activity3.class);
                startActivity(intent);
            }
        });
        imageButtonSubmit2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Multiple_choice_Activity2.class);
                startActivity(intent);
            }
        });
        imageButtonQuizint.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Quiz_Check=false;
                if(selected ==false) {
                    imageButtonQuizint.setSelected(true);
                    selected = true;
                    imageButtonQuizlonglong.setEnabled(false);
                    imageButtonQuizdouble.setEnabled(false);
                    imageButtonQuizchar.setEnabled(false);
                }else{
                    imageButtonQuizint.setSelected(false);
                    selected = false;
                    imageButtonQuizlonglong.setEnabled(true);
                    imageButtonQuizdouble.setEnabled(true);
                    imageButtonQuizchar.setEnabled(true);
                }
            }
        });
        imageButtonQuizlonglong.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Quiz_Check=false;
                if(selected ==false) {
                    imageButtonQuizlonglong.setSelected(true);
                    selected = true;
                    imageButtonQuizint.setEnabled(false);
                    imageButtonQuizdouble.setEnabled(false);
                    imageButtonQuizchar.setEnabled(false);
                }else{
                    imageButtonQuizlonglong.setSelected(false);
                    selected = false;
                    imageButtonQuizint.setEnabled(true);
                    imageButtonQuizdouble.setEnabled(true);
                    imageButtonQuizchar.setEnabled(true);

                }
            }
        });
        imageButtonQuizdouble.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                if(selected ==false) {
                    imageButtonQuizdouble.setSelected(true);
                    selected = true;
                    Quiz_Check=true;
                    imageButtonQuizint.setEnabled(false);
                    imageButtonQuizlonglong.setEnabled(false);
                    imageButtonQuizchar.setEnabled(false);

                }else{
                    imageButtonQuizdouble.setSelected(false);
                    imageButtonQuizint.setEnabled(true);
                    imageButtonQuizlonglong.setEnabled(true);
                    imageButtonQuizchar.setEnabled(true);
                    selected = false;
                    Quiz_Check=false;
                }
            }
        });
        imageButtonQuizchar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Quiz_Check=false;

                if(selected ==false) {
                    imageButtonQuizchar.setSelected(true);
                    imageButtonQuizint.setEnabled(false);
                    imageButtonQuizlonglong.setEnabled(false);
                    imageButtonQuizdouble.setEnabled(false);
                    selected = true;
                }else{
                    imageButtonQuizchar.setSelected(false);
                    imageButtonQuizint.setEnabled(true);
                    imageButtonQuizlonglong.setEnabled(true);
                    imageButtonQuizdouble.setEnabled(true);
                    selected = false;
                }
            }
        });
        imageButtonCheckQuiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveKeyValue("recent_quiz_history", Fragment_Progress.MUL[1]);

                if(Quiz_Check==true) {
                    if(checkFirst(Fragment_Progress.check_MUL[1])){
                        // Fragment_Progress.progress_Block_Value+=10;
                        saveKeyValue(Fragment_Progress.check_MUL[1], "true");
                    }

                    multiple_check2 = true;
                    dialogcorrect.show();
                    dialogcorrect.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
                else {
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