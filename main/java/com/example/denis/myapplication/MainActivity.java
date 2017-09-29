package com.example.denis.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button bnt_salva = (Button)findViewById(R.id.facul_btnEnviar);//definindo botão


        bnt_salva.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {  //Estrutura do botão

                TextView compra = (TextView)findViewById(R.id.editText);
                String tipodecompra = compra.getText().toString();
                Intent intent = new Intent(getContext(), Carrinho.class);
                Bundle params = new Bundle();
                params.putString("compra", tipodecompra);
                intent.putExtras(params);
                startActivity(intent);
            }
        });

    }
    private Context getContext()
    {
        return this;
    }

}
