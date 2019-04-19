package oranjeblauwgeel.stanrothstegge.minorgeschiedenis;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;

import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;

public class Overhoorscherm extends AppCompatActivity {
    TextView question;
    FlexboxLayout possibleAnswers;
    FlexboxLayout currentGivenAnswer;

    int background;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overhoorscherm);

        question = findViewById(R.id.questionTextview);
        currentGivenAnswer = findViewById(R.id.flexbox);
        possibleAnswers = findViewById(R.id.flexboxMultipleChoice);


        question.setText("In welk land was de staatsvorm na de Eerste Wereldoorlog nog hetzelfde als voor die oorlog?\n" +
                "\n");

        VoegAntwoordToe("Duitsland", getResources().getColor(R.color.colorAnswer));
        VoegAntwoordToe("FR", getResources().getColor(R.color.colorAnswer2));
        VoegAntwoordToe("Engeland", getResources().getColor(R.color.colorAnswer3));
        VoegAntwoordToe("De", getResources().getColor(R.color.colorAnswer));
        VoegAntwoordToe("Duitsland", getResources().getColor(R.color.colorAnswer));
        VoegAntwoordToe("FR", getResources().getColor(R.color.colorAnswer2));




    }


    private void VoegAntwoordToe(final String naam, int kleur) {
        final Button txt1 = new Button(getApplicationContext());

        GradientDrawable background = (GradientDrawable) getDrawable(R.drawable.my_shape);
        background.setColor(kleur);

        txt1.setBackground(background);
        txt1.setText(naam);
        txt1.setTextColor(Color.WHITE);

        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getParent() == currentGivenAnswer){
                    currentGivenAnswer.removeView(txt1);
                    possibleAnswers.addView(txt1);
                } else if(v.getParent() == possibleAnswers){
                    possibleAnswers.removeView(txt1);
                    currentGivenAnswer.addView(txt1);
                }

            }
        });
      // container.addView(txt1);
        possibleAnswers.addView(txt1);
        FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) txt1.getLayoutParams();
        layoutParams.width = LinearLayout.LayoutParams.WRAP_CONTENT;

        txt1.setLayoutParams(layoutParams);
    }



}

