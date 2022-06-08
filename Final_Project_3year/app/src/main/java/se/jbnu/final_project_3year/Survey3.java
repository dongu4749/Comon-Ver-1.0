package se.jbnu.final_project_3year;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Survey3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey3);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Button imageButtonJava = (Button) findViewById(R.id.buttonJava);
        Button imageButtonC = (Button) findViewById(R.id.buttonC);
        Button imageButtonNothing = (Button) findViewById(R.id.buttonNothing);
        Button imageButtonSkip = (Button) findViewById(R.id.buttonSkip);

        imageButtonC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Survey_Recommend.procedure_Language = true;
                Intent intent = new Intent(getApplicationContext(), Survey4.class);
                startActivity(intent);
            }
        });
        imageButtonJava.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Survey_Recommend.object_Language = true;
                Intent intent = new Intent(getApplicationContext(), Survey4.class);
                startActivity(intent);
            }
        });
        imageButtonNothing.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Survey_Recommend.None = true;
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