package com.example.imcuezo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText edtPeso, edtAltura, edtImc, edtSituacao;
    CheckBox chkIdade;
    RadioButton rbFeminino, rbMasculino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPeso = (EditText) findViewById(R.id.editTextPeso);
        edtAltura = (EditText) findViewById(R.id.editTextAltura);
        edtImc = (EditText) findViewById(R.id.editTextImc);
        edtSituacao = (EditText) findViewById(R.id.editTextSituacao);
        chkIdade = (CheckBox) findViewById(R.id.checkBoxIdade);
        rbFeminino = (RadioButton) findViewById(R.id.radioButtonFeminino);
        rbMasculino = (RadioButton) findViewById(R.id.radioButtonMasculino);

    }

    public void calcularImc(View v) {
        double peso, altura, imc;
        int idade, sexo;
        String situacao;

        //ENTRADA
        peso = Double.parseDouble(edtPeso.getText().toString());
        altura = Double.parseDouble(edtAltura.getText().toString());

        // Idade = 1 > 15 anos e idade = 2 <= 15 anos
        if(chkIdade.isChecked()) {
            idade = 1;
        } else {
            idade = 2;
        }
        //Sexo = 1 se for feminino e sexo = 2 se for masculino
        if(rbFeminino.isChecked()) {
            sexo = 1;
        } else {
            sexo = 2;
        }

        //PROCESSAMENTO
        imc = peso / Math.pow(altura, 2);

        if(idade == 1) {

            //Tabela feminina
            if(sexo == 1) {

                if(imc < 19.1) {
                    situacao = "Abaixo do Peso.";
                } else if (imc < 25.8) {
                    situacao = "Peso Normal.";
                } else if (imc < 27.3) {
                    situacao = "Pouco Acima do Peso.";
                } else if (imc < 32.3) {
                    situacao = "Acima do Peso.";
                } else {
                    situacao = "Obesa.";
                }

             //Tabela masculina
            } else {

                if(imc < 20.7) {
                    situacao = "Abaixo do Peso.";
                } else if (imc < 26.4) {
                    situacao = "Peso Normal.";
                } else if (imc < 27.8) {
                    situacao = "Pouco Acima do Peso.";
                } else if (imc < 31.1) {
                    situacao = "Acima do Peso.";
                } else {
                    situacao = "Obesa.";
                }
            }

        } else {
            situacao = "<= 15 anos. NÃO verificar!";
        }

        //SAÍDA
        edtImc.setText(String.format("%.2f", imc));
        edtSituacao.setText(situacao);

    }

}