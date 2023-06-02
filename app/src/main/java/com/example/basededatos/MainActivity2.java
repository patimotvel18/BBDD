package com.example.basededatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.basededatos.db.DbContacto;

public class MainActivity2 extends AppCompatActivity {

    EditText txtNombre, txtApellido, txtNum;
    Button btnGuarda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    txtNombre = findViewById(R.id.txtNombre);
    txtApellido = findViewById(R.id.txtApellido);
    txtNum = findViewById(R.id.txtNum);
    btnGuarda = findViewById(R.id.btnGuarda);

    btnGuarda.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
                DbContacto dbContacto = new DbContacto(MainActivity2.this);
                long id = dbContacto.insertacontacto(txtNombre.getText().toString(),txtApellido.getText().toString(),txtNum.getText().toString());

                if (id > 0){
                    Toast.makeText(MainActivity2.this,"Registro guardado", Toast.LENGTH_LONG).show();
                    limpiar();
                }else{
                    Toast.makeText(MainActivity2.this,"Error al guardar", Toast.LENGTH_LONG).show();
                }
        }
    });
    }
    private void limpiar(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtNum.setText("");
    }
}