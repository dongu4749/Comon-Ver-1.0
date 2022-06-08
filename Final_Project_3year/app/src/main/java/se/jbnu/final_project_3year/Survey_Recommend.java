package se.jbnu.final_project_3year;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Survey_Recommend extends AppCompatActivity {

    public static boolean recommend_Language = false;
    public static boolean learning_Style = false;
    public static boolean procedure_Language = false;
    public static boolean object_Language = false;
    public static boolean None = false;
    public static int recommend_Value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_recommend);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Button imageButtonNext = (Button) findViewById(R.id.buttonNext);
        TextView learning_Block = (TextView) findViewById(R.id.textViewBlock);
        TextView learning_Blank = (TextView) findViewById(R.id.textViewBlank);
        TextView Python = (TextView) findViewById(R.id.textViewPython);
        TextView rPython = (TextView) findViewById(R.id.textViewrPython);
        TextView javakotlinCShop = (TextView) findViewById(R.id.textViewjavakotlinCShop);
        TextView HtmlJavaScriptCShop = (TextView) findViewById(R.id.textViewHtmlJavaScriptCShop);
        TextView C = (TextView) findViewById(R.id.textViewC);
        TextView CPlus = (TextView) findViewById(R.id.textViewCPlus);
        TextView CShop = (TextView) findViewById(R.id.textViewCShop);
        TextView CCPlus = (TextView) findViewById(R.id.textViewCCPlus);

        if(learning_Style == true)
        {
            learning_Block.setVisibility(View.VISIBLE);
        }
        else
            learning_Blank.setVisibility(View.VISIBLE);

        if(recommend_Language == true) {
            if (procedure_Language == true) {
                switch (recommend_Value) {
                    case 1:
                        Python.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        rPython.setVisibility((View.VISIBLE));
                        break;
                    case 3:
                        javakotlinCShop.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        HtmlJavaScriptCShop.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        C.setVisibility(View.VISIBLE);
                        break;
                }
            }
            if (object_Language == true) {
                switch (recommend_Value) {
                    case 1:
                        Python.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        Python.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        javakotlinCShop.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        CShop.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        CPlus.setVisibility(View.VISIBLE);
                        break;
                }
            }
            if (None == true) {
                switch (recommend_Value) {
                    case 1:
                        Python.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        rPython.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        javakotlinCShop.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        HtmlJavaScriptCShop.setVisibility(View.VISIBLE);
                        break;
                    case 5:
                        CCPlus.setVisibility(View.VISIBLE);
                        break;
                }
            }
        }
        imageButtonNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}