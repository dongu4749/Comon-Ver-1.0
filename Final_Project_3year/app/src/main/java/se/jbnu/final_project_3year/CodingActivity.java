package se.jbnu.final_project_3year;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class CodingActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coding);

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 왼쪽 상단 버튼 만들기
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id==R.id.Quiz_Button){
                    Intent intent=new Intent(CodingActivity.this, Quiz_Multiple_choice_Activity.class);
                    startActivity(intent);
                }
                else if(id==R.id.Go_Home){
                    Intent intent=new Intent(CodingActivity.this,HomeActivity.class);
                    startActivity(intent);
                }else if(id==R.id.Quiz_typing){
                    Intent intent=new Intent(CodingActivity.this, Quiz_Short_Answer_Activity.class);
                    startActivity(intent);
                }else if(id==R.id.Quiz_Block){
                    Intent intent=new Intent(CodingActivity.this, Quiz_Block_CodingActivity.class);
                    startActivity(intent);
                }

                return true;
            }
        });
        if(getValue("recent_quiz_history")!= null) {
            String target_activity = getValue("recent_quiz_history");
            Intent intent;
            startActivity(getRecentQuizActivity(target_activity));
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case android.R.id.home: {
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    public void onBackPressed() { //뒤로가기 했을 때
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public String getValue(String key){
        SharedPreferences sharedPreferences= this.getSharedPreferences(key, MODE_PRIVATE);    // test 이름의 기본모드 설정, 만약 test key값이 있다면 해당 값을 불러옴.
        String value = sharedPreferences.getString(key,"");
        Log.d("SHARED_ID", value);
        return value;
    }

    public Intent getRecentQuizActivity(String str){
        Intent intent=null;
        switch (str){
            case "quiz_type_2_choice_num_1":
                intent = new Intent(this, Quiz_Multiple_choice_Activity.class);
                startActivity(intent);
                break;
            case "quiz_type_2_choice_num_2":
                intent = new Intent(this, Quiz_Multiple_choice_Activity2.class);
                startActivity(intent);
                break;
            case "quiz_type_2_choice_num_3":
                intent = new Intent(this, Quiz_Multiple_choice_Activity3.class);
                startActivity(intent);
                break;
            case  "quiz_type_3_write_num_1":
                intent = new Intent(this, Quiz_Short_Answer_Activity.class);
                startActivity(intent);
                break;
            case  "quiz_type_3_write_num_2":
                intent = new Intent(this, Quiz_Short_Answer_Activity2.class);
                startActivity(intent);
                break;
            case  "quiz_type_3_write_num_3":
                intent = new Intent(this, Quiz_Short_Answer_Activity3.class);
                startActivity(intent);
                break;
            case "quiz_type_1_block_coding_num_1":
                intent = new Intent(this, Quiz_Block_CodingActivity.class);
                startActivity(intent);
                break;
            default:
                intent = new Intent(this, Quiz_Multiple_choice_Activity.class);
                startActivity(intent);
                break;

        }
        return intent;
    }


}










