package oranjeblauwgeel.stanrothstegge.minorgeschiedenis;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;

public class Overhoorscherm extends AppCompatActivity {
    TextView question; //De vraag die beantwoord moet worden.
    FlexboxLayout possibleAnswers; //De mogelijke antwoorden op de vraag.
    FlexboxLayout currentGivenAnswer; //Het huidige geselecteerde antwoord.
    RelativeLayout layout;
    Button menu;
    Button proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overhoorscherm);
        //init elements
        question = findViewById(R.id.questionTextview);
        currentGivenAnswer = findViewById(R.id.flexbox);
        possibleAnswers = findViewById(R.id.flexboxMultipleChoice);
        layout = findViewById(R.id.questionlayout);
        menu = findViewById(R.id.menuButton);
        proceed = findViewById(R.id.proceedButton);

        GradientDrawable menuStyling = (GradientDrawable) getDrawable(R.drawable.menu_shape);
        menu.setBackground(menuStyling);
        proceed.setBackground(menuStyling);
            GradientDrawable questionBack = (GradientDrawable) getDrawable(R.drawable.question_shape);
        layout.setBackground(questionBack);
        question.setTextColor(Color.WHITE);

        //TODO vragen importeren vanuit een csv
        question.setText("In welk land was de staatsvorm na de Eerste Wereldoorlog nog hetzelfde als voor die oorlog?\n" +
                "\n");

        VoegAntwoordToe("Duitsland", getResources().getColor(R.color.colorAnswer));
        VoegAntwoordToe("FR", getResources().getColor(R.color.colorAnswer2));
        VoegAntwoordToe("Engeland", getResources().getColor(R.color.colorAnswer3));
        VoegAntwoordToe("De", getResources().getColor(R.color.colorAnswer));
        VoegAntwoordToe("Duitsland", getResources().getColor(R.color.colorAnswer));
        VoegAntwoordToe("FR", getResources().getColor(R.color.colorAnswer2));





    }

    /**
     *
     * @param antwoordGedeelte de tekst van de meerkeuze optie.
     * @param kleur kleur van de button.
     */
    private void VoegAntwoordToe(final String antwoordGedeelte, int kleur) {
        final Button antwoordOptieButton = new Button(getApplicationContext());
        //Drawable wordt gebruikt voor de vorm van de button.
        GradientDrawable background = (GradientDrawable) getDrawable(R.drawable.my_shape);
        //Buttons hebben verschillende kleuren.
        background.setColor(kleur);
        //Set vorm van button
        antwoordOptieButton.setBackground(background);
        //Geef het antwoord weer
        antwoordOptieButton.setText(antwoordGedeelte);
        antwoordOptieButton.setTextColor(Color.WHITE);
        /**
         * Implementeer On-Click
         * 1.Gebruiker selecteert een antwoord uit het Multi-Choice venster:
         * -> Swap button naar het 'Huidige Antwoord' venster.
         * 2.Gebruiker Anuleert antwoord:
         * -> Button wordt terug gezet in Multi-Choice venster.
         */
        antwoordOptieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getParent() == currentGivenAnswer){                    //Remove answer
                    currentGivenAnswer.removeView(antwoordOptieButton);
                    possibleAnswers.addView(antwoordOptieButton);
                } else if(v.getParent() == possibleAnswers){                //Add answer
                    possibleAnswers.removeView(antwoordOptieButton);
                    currentGivenAnswer.addView(antwoordOptieButton);
                }

            }
        });
        //Voeg button toe aan Flexbox
        possibleAnswers.addView(antwoordOptieButton);
    }



}

