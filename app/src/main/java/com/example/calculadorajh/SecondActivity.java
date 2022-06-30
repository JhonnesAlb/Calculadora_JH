package com.example.calculadorajh;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

//A cotação usada no código é referente ao dia 24/06/2022 ás 22:00.

public class SecondActivity extends AppCompatActivity {

    EditText et_digNumb;
    Button bt_convert;
    TextView tv_resultConv;
    String cotacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        vincularComponentes();
        criarListeners();
    }


    public void voltarTela(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void onRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.rb_USD:
                if (checked) {
                        cotacao = "5.24";
                }
                    break;

            case R.id.rb_EUR:
                if (checked)
                        cotacao = "5.54";
                    break;

            case R.id.rb_GBP:
                if (checked)
                        cotacao = "6.43";
                    break;

            case R.id.rb_JPY:
                if (checked)
                        cotacao = "0.039";
                    break;

        }
    }


    private void vincularComponentes() {

        et_digNumb = findViewById(R.id.et_digNumb);

        bt_convert = findViewById(R.id.bt_convert);

        tv_resultConv = findViewById(R.id.tv_resultConv);
    }


    private void criarListeners() {

        bt_convert.setOnClickListener(evt -> converter());

    }


    public void converter() {
        String numero1String = et_digNumb.getText().toString();
        String numero2String = cotacao;
        if (numero1String.isEmpty()) {
            Toast.makeText(this, "Digite um valor em Reais.",
                    Toast.LENGTH_LONG).show();
            return;
        }


        double numero1 = Double.parseDouble(numero1String);
        double numero2 = Double.parseDouble(numero2String);

        double resultado = numero1 / numero2;

        double resultadoArredondar = resultado;
        BigDecimal resultadoFinal = new BigDecimal(resultadoArredondar).setScale(2, RoundingMode.HALF_EVEN);

        tv_resultConv.setText(String.valueOf(resultadoFinal));
    }

}