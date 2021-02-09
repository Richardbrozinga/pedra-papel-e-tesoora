package com.example.pedrapapaeletesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        this.opcaoSelecionada("papel");

    }
    public void selecionadoTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada (String opcaoSelecionada) {

        ImageView imagemComputador = findViewById(R.id.imagemComputador);
        TextView textoResulatdo = findViewById(R.id.textResultado);


        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcoesApp = opcoes[ numero ];

        switch (opcoesApp){

            case "pedra":
                imagemComputador.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                imagemComputador.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imagemComputador.setImageResource(R.drawable.tesoura);
                break;

        }

        if (
                (opcoesApp == "tesoura" && opcaoSelecionada =="papel") ||
                (opcoesApp == "papel" && opcaoSelecionada == "pedra") ||
                (opcoesApp == "pedra" && opcaoSelecionada == "tesoura")
        ) {  //app ganhador
          textoResulatdo.setText("Você perdeu :(");
        }
        else if (
                        (opcaoSelecionada == "tesoura" && opcoesApp =="papel") ||
                        (opcaoSelecionada == "papel" && opcoesApp == "pedra") ||
                        (opcaoSelecionada == "pedra" && opcoesApp  == "tesoura")
        ){ // usuario ganhador

           textoResulatdo.setText("Você ganhou :)");
        }

        else {  //empate
            textoResulatdo.setText("Empatamos! :)");
        }

        System.out.println("Item selecionado: " + opcoesApp);

    }
}