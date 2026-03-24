package sp.senai.br.parouimpar_pietroalves;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioButton even, odd, zeroFinger, oneFinger, twoFinger, threeFinger, fourFinger, fiveFinger;
    TextView youPointer, alanPointer, resultsPlayer, resultsAlan, vencedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        even = findViewById(R.id.even);
        odd = findViewById(R.id.odd);
        zeroFinger = findViewById(R.id.zeroFinger);
        oneFinger = findViewById(R.id.oneFinger);
        twoFinger = findViewById(R.id.twoFinger);
        threeFinger = findViewById(R.id.threeFinger);
        fourFinger = findViewById(R.id.fourFinger);
        fiveFinger = findViewById(R.id.fiveFinger);
        youPointer = findViewById(R.id.youPointer);
        alanPointer = findViewById(R.id.alanPointer);
        resultsPlayer = findViewById(R.id.resultsPlayer);
        resultsAlan = findViewById(R.id.resultsAlan);
        vencedor = findViewById(R.id.vencedor);
        odd.setChecked(true);
        zeroFinger.setChecked(true);
    }
    int winsPlayer = 0;
    int winsAlan = 0;
    public void jogar(View v){

        boolean isEven;
        int escolhaJ = 0;
        int escolhaAlan = 1+(int)(Math.random()*5);
        boolean winner;

        if (even.isChecked()){
            isEven = true;
        }else{
            isEven = false;
        }
        if(zeroFinger.isChecked()){
            escolhaJ = 0;
        } else if(oneFinger.isChecked()){
            escolhaJ = 1;
        } else if(twoFinger.isChecked()){
            escolhaJ = 2;
        } else if(threeFinger.isChecked()){
            escolhaJ = 3;
        } else if(fourFinger.isChecked()){
            escolhaJ = 4;
        } else if(fiveFinger.isChecked()){
            escolhaJ= 5;
        }
        int soma = escolhaJ + escolhaAlan;
        if(isEven){
            if(soma % 2 == 0){
                winner = true;
                winsPlayer++;
                youPointer.setBackgroundColor(Color.parseColor("#2ddb21"));
                alanPointer.setBackgroundColor((Color.parseColor("#e03528")));
                resultsPlayer.setBackgroundColor(Color.parseColor("#edb0ff"));
                resultsAlan.setBackgroundColor(Color.parseColor("#ffffff"));

            }else{
                winner = false;
                winsAlan++;
                alanPointer.setBackgroundColor((Color.parseColor("#2ddb21")));
                youPointer.setBackgroundColor(Color.parseColor("#e03528"));
                resultsAlan.setBackgroundColor(Color.parseColor("#edb0ff"));
                resultsPlayer.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        }
        if(!isEven){
            if(soma % 2 == 0){
                winner = false;
                winsAlan++;
                alanPointer.setBackgroundColor(Color.parseColor("#2ddb21"));
                youPointer.setBackgroundColor(Color.parseColor("#e03528"));
                resultsAlan.setBackgroundColor(Color.parseColor("#edb0ff"));
                resultsPlayer.setBackgroundColor(Color.parseColor("#ffffff"));
            }else{
                winner = true;
                winsPlayer++;
                youPointer.setBackgroundColor(Color.parseColor("#2ddb21"));
                alanPointer.setBackgroundColor((Color.parseColor("#e03528")));
                resultsPlayer.setBackgroundColor(Color.parseColor("#edb0ff"));
                resultsAlan.setBackgroundColor(Color.parseColor("#ffffff"));
            }
        }
        resultsPlayer.setText("Você: "+ winsPlayer);
        resultsAlan.setText("Robô: "+ winsAlan);
        vencedor.setText("Resultado: " + soma);
    }
    public void limpar(View v){
        winsAlan = 0;
        winsPlayer = 0;
        resultsPlayer.setText("Você: "+ winsPlayer);
        resultsAlan.setText("Robô: "+ winsAlan);
    }
}