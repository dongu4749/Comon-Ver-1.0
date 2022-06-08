package se.jbnu.final_project_3year;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Survey4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey4);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Survey_Recommend.recommend_Value = 0;
        Button imageButtonWeb = (Button) findViewById(R.id.buttonWeb);
        Button imageButtonImbaded = (Button) findViewById(R.id.buttonImbaded);
        Button imageButtonData = (Button) findViewById(R.id.buttonData);
        Button imageButtonSkip = (Button) findViewById(R.id.buttonSkip);
        Button imageButtonApp = (Button) findViewById(R.id.buttonApp);
        Button imageButtonAI = (Button) findViewById(R.id.buttonAI);
        Button imageButtonEtc = (Button) findViewById(R.id.buttonEtc);
        imageButtonAI.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Survey_Recommend.recommend_Value = 1;
                Intent intent = new Intent(getApplicationContext(), Survey5.class);
                startActivity(intent);
            }
        });
        imageButtonData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Survey_Recommend.recommend_Value = 2;
                Intent intent = new Intent(getApplicationContext(), Survey5.class);
                startActivity(intent);
            }
        });
        imageButtonApp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Survey_Recommend.recommend_Value = 3;
                Intent intent = new Intent(getApplicationContext(), Survey5.class);
                startActivity(intent);
            }
        });
        imageButtonWeb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Survey_Recommend.recommend_Value = 4;
                Intent intent = new Intent(getApplicationContext(), Survey5.class);
                startActivity(intent);
            }
        });
        imageButtonImbaded.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Survey_Recommend.recommend_Value = 5;
                Intent intent = new Intent(getApplicationContext(), Survey5.class);
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

        imageButtonEtc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Survey5.class);
                startActivity(intent);
            }
        });

    }
}