package com.example.denis.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Carrinho extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);


        Button bnt_salva = (Button)findViewById(R.id.btnEnviar);

//------------------------------------------------------------
        Bundle args = getIntent().getExtras();
        String resultado = args.getString("compra");
        final TextView txt_resultado = (TextView)findViewById(R.id.txtcompra);
        txt_resultado.setText(resultado);
//------------------------------------------------------------
        final ArrayList<Mercadoria> mercadorias = new ArrayList<>();
        final ListView lista = (ListView)findViewById(R.id.lstequipes);
        final ArrayAdapter adapter = new MercadoriaAdapter(this, R.layout.linha2,mercadorias);
        //lista.setAdapter(adapter);

//-----------------------------------------------------------
        final Spinner spnCategorias = (Spinner)findViewById(R.id.spnCategoria);
        String[] categoria = {"Frios", "Vegetais", "Limpeza", "Higiene"};
        final ArrayAdapter adapterlist = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, categoria);
        adapterlist.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnCategorias.setAdapter(adapterlist);
//-----------------------------------------------------------
        bnt_salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CheckBox Perecivel = (CheckBox) findViewById(R.id.chkperecivel);
                boolean checkPerecivel = Perecivel.isChecked();

                if(checkPerecivel)
                    alert("perecivel");
                else
                    alert("Não perecivel");

                TextView txtQuantidade = (TextView) findViewById(R.id.txtQnt);
                TextView txtnome = (TextView) findViewById(R.id.edtcompra);
                //String Nome = txt_resultado.getText().toString();
                String Quantidade = txtQuantidade.getText().toString();
                String Nome = txtnome.getText().toString();
                String Categoria = spnCategorias.getSelectedItem().toString();


                Mercadoria p = new Mercadoria(Nome, Quantidade, Categoria);
                mercadorias.add(p);
                lista.setAdapter(adapter);

            }
        });

    }
    private void alert(String msg)
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

}
