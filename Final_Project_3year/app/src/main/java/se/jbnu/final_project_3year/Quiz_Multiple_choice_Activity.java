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

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Quiz_Multiple_choice_Activity extends AppCompatActivity {
    private boolean Quiz_Check=false;
    private boolean selected = false;
    Toolbar toolbar;
    boolean multiple_check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_multiple_choice_quiz);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        Dialog dialogcorrect = new Dialog(this);
        Dialog dialogwrong = new Dialog(this);
        dialogcorrect.setContentView(R.layout.activity_dialog_correct);
        dialogwrong.setContentView(R.layout.activity_dialog_wrong);



        Button imageButtonQuizJava = (Button) findViewById(R.id.buttonJavaQuiz);
        Button imageButtonQuizCplus = (Button) findViewById(R.id.buttonCplusQuiz);
        Button imageButtonQuizC = (Button) findViewById(R.id.buttonCQuiz);
        Button imageButtonQuizPython = (Button) findViewById(R.id.buttonPythonQuiz);
        Button imageButtonCheckQuiz = (Button) findViewById(R.id.buttonCheckQuiz);
        Button imageButtonSubmit = (Button) dialogcorrect.findViewById(R.id.buttonSubmit);
        Button imageButtonSubmit2 = (Button) dialogwrong.findViewById(R.id.buttonSubmit2);
        imageButtonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Multiple_choice_Activity2.class);
                startActivity(intent);
            }
        });
        imageButtonSubmit2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Multiple_choice_Activity.class);
                startActivity(intent);
            }
        });
        imageButtonQuizJava.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Quiz_Check=false;
                if(selected ==false) {
                    imageButtonQuizJava.setSelected(true);
                    selected = true;
                    imageButtonQuizCplus.setEnabled(false);
                    imageButtonQuizC.setEnabled(false);
                    imageButtonQuizPython.setEnabled(false);
                }else{
                    imageButtonQuizJava.setSelected(false);
                    selected = false;
                    imageButtonQuizCplus.setEnabled(true);
                    imageButtonQuizC.setEnabled(true);
                    imageButtonQuizPython.setEnabled(true);
                }
            }
        });
        imageButtonQuizCplus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Quiz_Check=false;

                if(selected ==false) {
                    imageButtonQuizCplus.setSelected(true);
                    selected = true;
                    imageButtonQuizJava.setEnabled(false);
                    imageButtonQuizC.setEnabled(false);
                    imageButtonQuizPython.setEnabled(false);
                }else{
                    imageButtonQuizCplus.setSelected(false);
                    imageButtonQuizJava.setEnabled(true);
                    imageButtonQuizC.setEnabled(true);
                    imageButtonQuizPython.setEnabled(true);
                    selected = false;
                }
            }
        });
        imageButtonQuizC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                if(selected ==false) {
                    imageButtonQuizC.setSelected(true);
                    selected = true;
                    Quiz_Check=true;
                    imageButtonQuizJava.setEnabled(false);
                    imageButtonQuizCplus.setEnabled(false);
                    imageButtonQuizPython.setEnabled(false);
                }else{
                    imageButtonQuizC.setSelected(false);
                    imageButtonQuizJava.setEnabled(true);
                    imageButtonQuizCplus.setEnabled(true);
                    imageButtonQuizPython.setEnabled(true);
                    selected = false;
                    Quiz_Check=false;
                }
            }
        });
        imageButtonQuizPython.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Quiz_Check=false;

                if(selected ==false) {
                    imageButtonQuizPython.setSelected(true);
                    imageButtonQuizJava.setEnabled(false);
                    imageButtonQuizCplus.setEnabled(false);
                    imageButtonQuizC.setEnabled(false);
                    selected = true;
                }else{
                    imageButtonQuizPython.setSelected(false);
                    imageButtonQuizJava.setEnabled(true);
                    imageButtonQuizCplus.setEnabled(true);
                    imageButtonQuizC.setEnabled(true);
                    selected = false;
                }
            }
        });
        imageButtonCheckQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveKeyValue("recent_quiz_history", Fragment_Progress.MUL[0]);

                if(Quiz_Check==true) {
                    if(checkFirst(Fragment_Progress.check_MUL[0])){
                        // Fragment_Progress.progress_Block_Value+=10;
                        saveKeyValue(Fragment_Progress.check_MUL[0], "true");

                    }
                    multiple_check = true;
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