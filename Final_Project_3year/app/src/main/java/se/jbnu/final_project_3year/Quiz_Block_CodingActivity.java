package se.jbnu.final_project_3year;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Quiz_Block_CodingActivity extends AppCompatActivity {
    Toolbar toolbar;
    private boolean Quiz_Check=false;
    Button buttonCheckQuiz,button_block_1, button_block_2, button_block_3, button_block_4, button_block_5, button_block_6, button_block_7, button_block_8, button_block_9;
    Button button_answer_1, button_answer_2, button_answer_3, button_answer_4, button_answer_5, button_answer_6, button_answer_7, button_answer_8, button_answer_9;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_block_coding);

        // 툴바와 다이얼로그 추가
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Dialog dialogcorrect = new Dialog(this);
        Dialog dialogwrong = new Dialog(this);
        dialogcorrect.setContentView(R.layout.activity_dialog_correct);
        dialogwrong.setContentView(R.layout.activity_dialog_wrong);

        // 버튼과 아이디 연결
        buttonCheckQuiz = findViewById(R.id.buttonCheckQuiz);
        button_block_1 = findViewById(R.id.button_block_1);
        button_block_2 = findViewById(R.id.button_block_2);
        button_block_3 = findViewById(R.id.button_block_3);
        button_block_4 = findViewById(R.id.button_block_4);
        button_block_5 = findViewById(R.id.button_block_5);
        button_block_6 = findViewById(R.id.button_block_6);
        button_block_7 = findViewById(R.id.button_block_7);
        button_block_8 = findViewById(R.id.button_block_8);
        button_block_9 = findViewById(R.id.button_block_9);



        button_answer_1 = findViewById(R.id.button_answer_1_system);
        button_answer_2 = findViewById(R.id.button_answer_2_out);
        button_answer_3 = findViewById(R.id.button_answer_3_println);
        button_answer_4 = findViewById(R.id.button_answer_4_main);
        button_answer_5 = findViewById(R.id.button_answer_5_string);
        button_answer_6 = findViewById(R.id.button_answer_6_public);
        button_answer_7 = findViewById(R.id.button_answer_7_static);
        button_answer_8 = findViewById(R.id.button_answer_8_void);
        button_answer_9 = findViewById(R.id.button_answer_9_helloworld);

        Button button_back_all = findViewById(R.id.button_back_all);


        Button imageButtonSubmit = (Button) dialogcorrect.findViewById(R.id.buttonSubmit);
        Button imageButtonSubmit2 = (Button) dialogwrong.findViewById(R.id.buttonSubmit2);

        // 버튼에 태그 추가
        button_answer_1.setTag("system.");
        button_answer_2.setTag("out.");
        button_answer_3.setTag("println");
        button_answer_4.setTag("main");
        button_answer_5.setTag("(String[] args)");
        button_answer_6.setTag("public");
        button_answer_7.setTag("static");
        button_answer_8.setTag("void");
        button_answer_9.setTag("(\"hello world!\");");


        // 리니어 레이아웃에 태그 추가
        findViewById(R.id.answer_layout_1).setTag("answer_layout_1");
        findViewById(R.id.answer_layout_2).setTag("answer_layout_2");
        findViewById(R.id.answer_layout_3).setTag("answer_layout_3");
        findViewById(R.id.answer_layout_4).setTag("answer_layout_4");
        findViewById(R.id.answer_layout_5).setTag("answer_layout_5");
        findViewById(R.id.answer_layout_6).setTag("answer_layout_6");
        findViewById(R.id.answer_layout_7).setTag("answer_layout_7");
        findViewById(R.id.answer_layout_8).setTag("answer_layout_8");
        findViewById(R.id.answer_layout_9).setTag("answer_layout_9");

        // 답이 적힌 버튼에 대해 롱클릭 리스너 추가
        button_answer_1.setOnLongClickListener(new LongClickListener());
        button_answer_2.setOnLongClickListener(new LongClickListener());
        button_answer_3.setOnLongClickListener(new LongClickListener());
        button_answer_4.setOnLongClickListener(new LongClickListener());
        button_answer_5.setOnLongClickListener(new LongClickListener());
        button_answer_6.setOnLongClickListener(new LongClickListener());
        button_answer_7.setOnLongClickListener(new LongClickListener());
        button_answer_8.setOnLongClickListener(new LongClickListener());
        button_answer_9.setOnLongClickListener(new LongClickListener());

        // 빈칸 레이아웃에 드래그 리스너 추가
        findViewById(R.id.answer_layout_1).setOnDragListener(new DragListener());
        findViewById(R.id.answer_layout_2).setOnDragListener(new DragListener());
        findViewById(R.id.answer_layout_3).setOnDragListener(new DragListener());
        findViewById(R.id.answer_layout_4).setOnDragListener(new DragListener());
        findViewById(R.id.answer_layout_5).setOnDragListener(new DragListener());
        findViewById(R.id.answer_layout_6).setOnDragListener(new DragListener());
        findViewById(R.id.answer_layout_7).setOnDragListener(new DragListener());
        findViewById(R.id.answer_layout_8).setOnDragListener(new DragListener());
        findViewById(R.id.answer_layout_9).setOnDragListener(new DragListener());

        // 다이얼로그 처리
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
                Intent intent = new Intent(getApplicationContext(), Quiz_Block_CodingActivity.class);
                startActivity(intent);
            }
        });

        // 정답 버튼 클릭시
        buttonCheckQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quiz_Check = check_quiz();
                saveKeyValue("recent_quiz_history", Fragment_Progress.BC[0]);

                if(Quiz_Check){
                    if(checkFirst(Fragment_Progress.check_BC[0])){
                        // Fragment_Progress.progress_Block_Value+=10;
                        saveKeyValue(Fragment_Progress.check_BC[0], "true");

                    }

                    dialogcorrect.show();
                    dialogcorrect.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                } else{
                    dialogwrong.show();
                    dialogwrong.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                }
            }
        });

        // 모두 되돌리기 버튼  클릭시
        button_back_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 빈칸 버튼 답 초기화
                button_block_1.setText("1");  button_block_1.setTextSize(12);
                button_block_2.setText("2");  button_block_2.setTextSize(12);
                button_block_3.setText("3");  button_block_3.setTextSize(12);
                button_block_4.setText("4");  button_block_4.setTextSize(12);
                button_block_5.setText("5");  button_block_5.setTextSize(12);
                button_block_6.setText("6");  button_block_6.setTextSize(12);
                button_block_7.setText("7");  button_block_7.setTextSize(12);
                button_block_8.setText("8");  button_block_8.setTextSize(12);
                button_block_9.setText("9");  button_block_9.setTextSize(12);

                button_answer_1.setVisibility(View.VISIBLE);
                button_answer_2.setVisibility(View.VISIBLE);
                button_answer_3.setVisibility(View.VISIBLE);
                button_answer_4.setVisibility(View.VISIBLE);
                button_answer_5.setVisibility(View.VISIBLE);
                button_answer_6.setVisibility(View.VISIBLE);
                button_answer_7.setVisibility(View.VISIBLE);
                button_answer_8.setVisibility(View.VISIBLE);
                button_answer_9.setVisibility(View.VISIBLE);

            }
        });
    }


    public boolean check_quiz(){
        if( button_block_1.getText().toString().equals(button_answer_6.getText().toString())
                && button_block_2.getText().toString().equals(button_answer_7.getText().toString())
                && button_block_3.getText().toString().equals(button_answer_8.getText().toString())
                && button_block_4.getText().toString().equals(button_answer_4.getText().toString())
                && button_block_5.getText().toString().equals(button_answer_5.getText().toString())
                && button_block_6.getText().toString().equals(button_answer_1.getText().toString())
                && button_block_7.getText().toString().equals(button_answer_2.getText().toString())
                && button_block_8.getText().toString().equals(button_answer_3.getText().toString())
                && button_block_9.getText().toString().equals(button_answer_9.getText().toString())) {
            return true;
        } else return false;
    }

    private final class LongClickListener implements
            View.OnLongClickListener {

        public boolean onLongClick(View view) {

            // 태그 생성
            ClipData.Item item = new ClipData.Item(
                    (CharSequence) view.getTag());

            String[] mimeTypes = { ClipDescription.MIMETYPE_TEXT_PLAIN };
            ClipData data = new ClipData(view.getTag().toString(),
                    mimeTypes, item);
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(
                    view);

            view.startDrag(data, // data to be dragged
                    shadowBuilder, // drag shadow
                    view, // 드래그 드랍할  Vew
                    0 // 필요없은 플래그
            );

            view.setVisibility(View.INVISIBLE);
            return true;
        }
    }

    class DragListener implements View.OnDragListener {
        Drawable normalShape = getResources().getDrawable(
                R.color.teal_700);
        Drawable targetShape = getResources().getDrawable(
                R.color.purple_200);

        public boolean onDrag(View v, DragEvent event) {

            // 이벤트 시작
            switch (event.getAction()) {
                // 이미지를 드래그 시작될때
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d("DragClickListener", "ACTION_DRAG_STARTED");
                    break;

                // 드래그한 이미지를 옮길려는 지역으로 들어왔을때
                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d("DragClickListener", "ACTION_DRAG_ENTERED");
                    // 이미지가 들어왔다는 것을 알려주기 위해 배경이미지 변경
                    // v.setBackground(targetShape);
                    break;

                // 드래그한 이미지가 영역을 빠져 나갈때
                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d("DragClickListener", "ACTION_DRAG_EXITED");
                    // v.setBackground(normalShape);
                    break;

                // 이미지를 드래그해서 드랍시켰을때
                case DragEvent.ACTION_DROP:
                    Log.d("DragClickListener", "ACTION_DROP"+"  "+v.getTag());
                    View view = (View) event.getLocalState();
                    String answer = ((View) event.getLocalState()).getTag().toString();
                    Log.d("DragClickListener",((View) event.getLocalState()).getTag().toString() );

                    if (v == findViewById(R.id.answer_layout_1)) {
                        button_block_1.setText(answer);
                        button_block_1.setTextSize(10);
                    }else if (v == findViewById(R.id.answer_layout_2)) {
                        button_block_2.setText(answer);
                        button_block_2.setTextSize(10);
                    }else if (v == findViewById(R.id.answer_layout_3)) {
                        button_block_3.setText(answer);
                        button_block_3.setTextSize(10);
                    } else if (v == findViewById(R.id.answer_layout_4)) {
                        button_block_4.setText(answer);
                        button_block_4.setTextSize(10);
                    }else if (v == findViewById(R.id.answer_layout_5)) {
                        button_block_5.setText(answer);
                        button_block_5.setTextSize(10);
                    } else if (v == findViewById(R.id.answer_layout_6)) {
                        button_block_6.setText(answer);
                        button_block_6.setTextSize(10);
                    }else if (v == findViewById(R.id.answer_layout_7)) {
                        button_block_7.setText(answer);
                        button_block_7.setTextSize(10);
                    }else if (v == findViewById(R.id.answer_layout_8)) {
                        button_block_8.setText(answer);
                        button_block_8.setTextSize(10);
                    }else if (v == findViewById(R.id.answer_layout_9)) {
                        button_block_9.setText(answer);
                        button_block_9.setTextSize(10);
                    }
                    else {
                        view.setVisibility(View.VISIBLE);
                        Context context = getApplicationContext();
                        Toast.makeText(context,
                                "이미지를 다른 지역에 드랍할수 없습니다.",
                                Toast.LENGTH_LONG).show();
                        break;
                    }
                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d("DragClickListener", "ACTION_DRAG_ENDED");
                    // v.setBackground(normalShape); // go back to normal shape
                default:
                    break;
            }
            return true;
        }
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