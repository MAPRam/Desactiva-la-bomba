package ox5.bomba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
*/
/**
 * Created by Ox5 on 16/06/2016.
 */

/*class EscribirFichero{
    public static void main(String[] args) throws IOException{
        String ruta ="/Local/Almacenamiento_Interno/storage/emulated/0/Android/data/archivo.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("El fichero de texto ya esta creado.");
        }
        else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Acabo de crear el fichero de texto");
        }
    }
}*/

public class Puntaje extends AppCompatActivity {
    public Button regresar;
    /*public Button leermemoria;*/
    TextView textView;
    TextView textView1;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.puntaje);
        regresar = (Button) findViewById(R.id.Regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent atras = new Intent(Puntaje.this, Menu.class);
                startActivity(atras);
            }
        });

        textView = (TextView)findViewById(R.id.texto);
        textView1 = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        /*leermemoria = (Button) findViewById(R.id.interna);
        leermemoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {*/
                try {
                    BufferedReader lee = new BufferedReader(new InputStreamReader(openFileInput("score.txt")));
                    String texto = lee.readLine();
                    textView.setText(texto);
                    if(texto!=null){
                        /*while(lee.readLine()!=null){*/
                            texto=lee.readLine();
                            textView1.setText(texto);
                            texto=lee.readLine();
                            textView2.setText(texto);
                            texto=lee.readLine();
                            textView3.setText(texto);
                        /*}*/
                    }
                    else{
                    }
                    lee.close();
                    /*Log.e("Fichero","Archivo ssSSSssssSsSsiiiii encontrado");*/
                }
                catch (IOException e) {
                    /*finish();
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);*/
                    /*Log.e("Fichero","Archivo NNOOOOOOOOOOOOOOOOOO encontrado");*/
                    }
                /*}
            });*/
        }
    }
