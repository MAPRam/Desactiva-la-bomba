package ox5.bomba;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.OutputStreamWriter;

public class Menu extends AppCompatActivity {

    static int global=0;
     int flag=0;
    MediaPlayer mediaPlayer;
    public Button play;
    public Button settings;
    public Button score;
    public Button salir;
    static int bandera = 0;
    TextView textView;
    String texto=null;
    /*SelectBomba x;*/
    /*Animation transparencia;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        mediaPlayer = new MediaPlayer();

        play_mp();

        if (global==1)
        {
            stop_mp();

        }
        else
        {

        }






        play = (Button) findViewById(R.id.juga);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (bandera == 0) {
                    Intent seleccionbomba = new Intent(Menu.this, SelectBomba.class);
                stop_mp();
                startActivity(seleccionbomba);
                //}
               /* if (bandera == 1) {
                    Intent seleccionbomba = new Intent(Menu.this, SelectBomba2.class);
                        //crear(view);
                    startActivity(seleccionbomba);

                }*/
            }
        });

        settings = (Button) findViewById(R.id.ajustes);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ajus = new Intent(Menu.this, Ajustes.class);
                stop_mp();
                    startActivity(ajus);
            }
        });

        score = (Button) findViewById(R.id.puntaje);
        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sco = new Intent(Menu.this, Puntaje.class);
                /*try {
                    BufferedReader lee = new BufferedReader(new InputStreamReader(openFileInput("score.txt")));
                    texto = lee.readLine();*/
                    //if(texto==null){
                        crear(v);
                        startActivity(sco);
                stop_mp();
                    //}
                //}
                /*catch (IOException e) {
                    startActivity(sco);
                }*/
            }
        });

        salir = (Button) findViewById(R.id.salir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                stop_mp();
                startActivity(intent);

            }
        });
    }

    private void play_mp()
    {
        Thread playThread = new Thread()
        {
            public void run()
            {
                if(flag==0) {
                    mediaPlayer = mediaPlayer.create(Menu.this, R.raw.menu);
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                    flag=1;
                }
                else
                {
                    mediaPlayer.stop();
                    flag=0;
                }
            }
        };
        playThread.start();
    }

    private void stop_mp()
    {
        mediaPlayer.stop();
        flag=0;
    }



    private void crear(View view){
        try {
            File f=new File("score.txt");
            boolean x= f.exists();
            if(x==false){
                OutputStreamWriter fout = new OutputStreamWriter(openFileOutput("score.txt",MODE_PRIVATE));
                fout.write("Posición            Nombre            Nivel            Tiempo\n" +
                        "1°            Player1            3            2:00\n" +
                        "2°            ñññññññ            2            3:00\n" +
                        "3°            Player3            1            1:50");//////////esto va en score////
                fout.close();
                    /*Log.e("Fichero","Archivo SSSSSIII CREADO");*/
            }
            else{
            }
        }

            catch(Exception ex){
            }
        }
    }

