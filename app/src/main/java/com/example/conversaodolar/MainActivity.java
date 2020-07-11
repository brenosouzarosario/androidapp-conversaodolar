package com.example.conversaodolar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private sObjetosTela soObjetosTela = new sObjetosTela();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ligacao entre o JAVA e o arq XML
        this.soObjetosTela.edtValorDolar = findViewById(R.id.edtValorDolar);
        this.soObjetosTela.btnConverter = findViewById(R.id.btnConverter);
        this.soObjetosTela.edtValorReal=findViewById(R.id.edtValorReal);
        limparCampos();
    }

    private static class sObjetosTela{
        //Criando objetos utilizados no arq XML
        EditText edtValorReal;
        Button btnConverter;
        EditText edtValorDolar;
    }

    private void limparCampos(){
        this.soObjetosTela.edtValorDolar.setText("");
        this.soObjetosTela.edtValorReal.setText("");

    }

    public void converter(View view) {
        //Capturar o texto do edtValoReal
        String valor = this.soObjetosTela.edtValorReal.getText().toString();
        //Veririfcar se o valor é igual a zero se for exibir uma mensagem na tela
        if("".equals(valor)){
            Toast.makeText(this,
                    this.getString(R.string.informe_valor),
                    Toast.LENGTH_LONG).show();
        }else{
            //Converter o valor em Double
            Double valorReal = Double.valueOf(valor);
            //Converter Real para Dolar
            Double valorDolar = (valorReal/5.0);
            this.soObjetosTela.edtValorDolar.setText(String.format("%.2f",(valorDolar)));
        }
    }

}
