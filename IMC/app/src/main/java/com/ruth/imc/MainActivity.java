package com.ruth.imc;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.icu.text.DecimalFormat;

public class MainActivity extends AppCompatActivity  {

    private EditText editPeso;
    private EditText editAltura;
    private TextView textResultado;
    private Button  btCalcular;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        textResultado = findViewById(R.id.textResultado);
        btCalcular = findViewById(R.id.btCalcular);
        
        btCalcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
            
                try{
                    
                    Double peso = Double.parseDouble(editPeso.getText().toString());
                    Double altura = Double.parseDouble(editAltura.getText().toString());
                    Double imc = peso/(altura*altura);
                    
                    if(imc <= 18.4){
                        textResultado.setText("*ABAIXO DO PESO*\nPara chegar no seu peso ideal ai vai algumas dicas:\nConsuma alimentos ricos em proteinas. Aposte nas *gorduras boas*. Aumente o consumo de pães, massas, mandioca e cereais (optando sempre por produtos integrais) e consuma frutas mais caloricas, como ameixa preta, abacate, banana, caqui, manga e etc.\nhaaa....e beba bastante agua ˆˆ)\nO seu IMC é de " + new DecimalFormat(".##").format(imc));
                    }else if(imc >= 18.5 && imc <= 24.99){
                        textResultado.setText("*PESO IDEAL*\nPara manter o peso ideal ai vai algumas dicas:\nFaça exercícios de força (musculação) e aeróbicos com a ingestão de uma dieta rica em alimentos fontes de proteína para garantir a manutenção e o ganho de massa magra que naturalmente começa a reduzir a partir dos 40 anos.\nhaaa....e beba bastante agua ˆˆ)\n IMC de " + new DecimalFormat(".##").format(imc));
                    }else if(imc >= 25 && imc <= 29.99){
                        textResultado.setText("*ACIMA DO PESO*\nPara ajudar a emagrecer ai vai algumas dicas:\nInicie as refeições com um prato grande de saladas,(folhas e legumes cozidos). Pratique atividades físicas e não fique mais do que 4 horas sem se alimentar.\nhaaa....e beba bastante agua ˆˆ)\nIMC de " + new DecimalFormat(".##").format(imc));
                    }else if(imc >= 30 && imc <= 34.99){
                        textResultado.setText("*OBESIDADE GRAU I*\nPara ajudar a emagrecer ai vai algumas dicas:\nConsuma mais fibras, como: verduras, legumes, frutas, grãos e cereais. Eles saciam por mais tempo e evitam que você chegue à próxima refeição com muita fome.\nhaaa....e beba bastante agua ˆˆ)\nIMC de " + new DecimalFormat(".##").format(imc));
                    }else if(imc >= 35 && imc <= 39.99){
                        textResultado.setText("*OBESIDADE GRAU II (severa)*\nPara ajudar a emagrecer ai vai algumas dicas:\nMudanças no estilo de vida, tais como: alimentação balanceada, atividades físicas e uma boa saúde emocional tendem a serem eficazes. A cirurgia bariátrica pode ser uma opção caso os tratamentos convencionais não funcionem.\n**Consulte o seu médico**\nIMC de " + new DecimalFormat(".##").format(imc));
                    }else if(imc > 40){
                        textResultado.setText("*OBESIDADE GRAU III (mórbida)*\nPara ajudar a emagrecer ai vai algumas dicas:\nMudanças no estilo de vida, tais como: alimentação balanceada, atividades físicas e uma boa saúde emocional tendem a serem eficazes. A cirurgia bariátrica pode ser uma opção caso os tratamentos convencionais não funcionem.\n**Consulte o seu médico** IMC de " + new DecimalFormat(".##").format(imc));
                    }

                }catch(Exception e){
                    textResultado.setText("Por favor informe o peso e a altura acima ↑ para realizar o calculo.");
                }
            }
        });
    }
}

