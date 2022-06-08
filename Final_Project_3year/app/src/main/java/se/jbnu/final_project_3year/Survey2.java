package se.jbnu.final_project_3year;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Survey2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey2);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Button imageButtonYes = (Button) findViewById(R.id.buttonYes);
        Button imageButtonNo = (Button) findViewById(R.id.buttonNo);
        Button imageButtonSkip = (Button) findViewById(R.id.buttonSkip);

        imageButtonYes.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Survey_Recommend.recommend_Language = true;
                Intent intent = new Intent(getApplicationContext(), Survey3.class);
                startActivity(intent);
            }
        });
        imageButtonNo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Survey_Recommend.recommend_Language = false;
                Intent intent = new Intent(getApplicationContext(), Survey4.class);
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