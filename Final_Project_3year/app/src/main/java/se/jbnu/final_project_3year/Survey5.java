package se.jbnu.final_project_3year;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Survey5 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey5);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Button imageButtonCoding = (Button) findViewById(R.id.buttonCoding);
        Button imageButtonStudy = (Button) findViewById(R.id.buttonStudy);
        Button imageButtonSkip = (Button) findViewById(R.id.buttonSkip);
        imageButtonCoding.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Survey_Recommend.learning_Style = true;
                Intent intent = new Intent(getApplicationContext(), Survey_Recommend.class);
                startActivity(intent);
            }
        });
        imageButtonStudy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Survey_Recommend.learning_Style = false;
                Intent intent = new Intent(getApplicationContext(), Survey_Recommend.class);
                startActivity(intent);
            }
        });
        imageButtonSkip.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}