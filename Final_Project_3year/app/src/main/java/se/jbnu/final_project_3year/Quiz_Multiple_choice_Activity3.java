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

public class Quiz_Multiple_choice_Activity3 extends AppCompatActivity {
    private boolean Quiz_Check=false;
    private boolean selected = false;
    Toolbar toolbar;
    boolean multiple_check3 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_multiple_choice_quiz3);
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Dialog dialogcorrect = new Dialog(this);
        Dialog dialogwrong = new Dialog(this);
        dialogcorrect.setContentView(R.layout.activity_dialog_correct);
        dialogwrong.setContentView(R.layout.activity_dialog_wrong);

        Button imageButtonQuizfloat = (Button) findViewById(R.id.buttonfloatQuiz);
        Button imageButtonQuizstr = (Button) findViewById(R.id.buttonstrQuiz);
        Button imageButtonQuizboolean= (Button) findViewById(R.id.buttonbooleanQuiz);
        Button imageButtonQuizint = (Button) findViewById(R.id.buttonintQuiz);
        Button imageButtonCheckQuiz3 = (Button) findViewById(R.id.buttonCheckQuiz3);
        Button imageButtonSubmit = (Button) dialogcorrect.findViewById(R.id.buttonSubmit);
        Button imageButtonSubmit2 = (Button) dialogwrong.findViewById(R.id.buttonSubmit2);
        imageButtonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(intent);
            }
        });
        imageButtonSubmit2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Quiz_Multiple_choice_Activity3.class);
                startActivity(intent);
            }
        });
        imageButtonQuizfloat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Quiz_Check=false;
                if(selected ==false) {
                    imageButtonQuizfloat.setSelected(true);
                    selected = true;
                    imageButtonQuizstr.setEnabled(false);
                    imageButtonQuizboolean.setEnabled(false);
                    imageButtonQuizint.setEnabled(false);
                }else{
                    imageButtonQuizfloat.setSelected(false);
                    selected = false;
                    imageButtonQuizstr.setEnabled(true);
                    imageButtonQuizboolean.setEnabled(true);
                    imageButtonQuizint.setEnabled(true);
                }
            }
        });
        imageButtonQuizstr.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Quiz_Check=false;
                if(selected ==false) {
                    imageButtonQuizstr.setSelected(true);
                    selected = true;
                    imageButtonQuizfloat.setEnabled(false);
                    imageButtonQuizboolean.setEnabled(false);
                    imageButtonQuizint.setEnabled(false);
                }else{
                    imageButtonQuizstr.setSelected(false);
                    selected = false;
                    imageButtonQuizfloat.setEnabled(true);
                    imageButtonQuizboolean.setEnabled(true);
                    imageButtonQuizint.setEnabled(true);

                }
            }
        });
        imageButtonQuizboolean.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                if(selected ==false) {

                    selected = true;
                    Quiz_Check=true;
                    imageButtonQuizboolean.setSelected(true);

                    imageButtonQuizfloat.setEnabled(false);
                    imageButtonQuizstr.setEnabled(false);
                    imageButtonQuizint.setEnabled(false);
                }else{
                    imageButtonQuizboolean.setSelected(false);

                    imageButtonQuizfloat.setEnabled(true);
                    imageButtonQuizstr.setEnabled(true);
                    imageButtonQuizint.setEnabled(true);
                    selected = false;
                    Quiz_Check=false;
                }
            }
        });
        imageButtonQuizint.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Quiz_Check=false;

                if(selected ==false) {
                    imageButtonQuizint.setSelected(true);
                    selected = true;
                    imageButtonQuizfloat.setEnabled(false);
                    imageButtonQuizboolean.setEnabled(false);
                    imageButtonQuizstr.setEnabled(false);
                    selected = true;
                }else{
                    imageButtonQuizint.setSelected(false);
                    selected = false;
                    imageButtonQuizfloat.setEnabled(true);
                    imageButtonQuizboolean.setEnabled(true);
                    imageButtonQuizstr.setEnabled(true);

                }
            }
        });
        imageButtonCheckQuiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveKeyValue("recent_quiz_history", Fragment_Progress.MUL[2]);
                if(Quiz_Check==true) {
                    if(checkFirst(Fragment_Progress.check_MUL[2])){
                        // Fragment_Progress.progress_Block_Value+=10;
                        saveKeyValue(Fragment_Progress.check_MUL[2], "true");
                    }
                    multiple_check3 = true;
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