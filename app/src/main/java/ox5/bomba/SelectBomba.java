package ox5.bomba;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ox5 on 09/06/2016.
 */
public class SelectBomba extends AppCompatActivity {

    int flag2=0;
    MediaPlayer mediaPlayer;
    public Button regresar;
    public Button car;
    public Button caz;
    public Button caa;
    public int x=0;
    static int flag=0;
    private TextView muestra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectbomba);

        //////////////////////////////////////////////////////////////////////////////////////////
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        mediaPlayer = new MediaPlayer();
        play_mp();
        Menu.global=1;



        Spinner spinner = (Spinner) findViewById(R.id.ins);
        String[] valores = {"Instrucciónes",
                "   ",
                "       CABLES",
                "SI EXISTEN CABLES:",
                "1) Si tu primer cable es blanco, corta el último cable. ",
                "2) Si tienes un cable azul, córtalo.",
                "3) Si tu segundo cable es naranja, corta el último cable.",
                "4) Si ya cortaste un cable azul, y tienes en la bomba un cable amarillo",
                "       entonces corta el cable amarillo",
                "5) Si tu primer cable es amarillo, corta el cable verde después de cortar",
                "       el cable azul.",
                "6) Si tienes un cable color rojo y ya cortaste un amarillo, corta éste cable rojo.",
                "7) De lo contrario, si hay más de un cable azul, corte el último cable azul."
        };


        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                //Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // vacio

            }
        });





        muestra = (TextView)findViewById(R.id.muestratext);
        //muestra.setText("0:03:00");

        final CounterClass timer = new CounterClass(70000,1000);
        timer.start();




        regresar=(Button)findViewById(R.id.Regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent atras = new Intent(SelectBomba.this,Menu.class);
                startActivity(atras);
                flag=0;
                stop_mp();
                timer.cancel();
            }
        });

     ////////////////////////////////////////////////////////////////////////////////////////////////



        caz=(Button)findViewById(R.id.cableaz);
        caz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag==0)
                {
                    // Intent romper = new Intent(SelectBomba.this, Menu.class);
                    //if(x==2){
                    caz.setBackgroundResource(R.drawable.cableroto);
                    //  Menu.bandera=1;
                    //}
                    //else{
                    //  caz.setBackgroundResource(R.drawable.cableroto);
                    // Intent atras = new Intent(SelectBomba.this,Menu.class);
                    //Menu.bandera=1;
                    // startActivity(atras);
                    //}
                    flag = 1;
                    //timer.cancel();
                }
                else
                {
                    timer.cancel();
                    flag=0;
                    stop_mp();
                    Intent next = new Intent(SelectBomba.this,perdio.class);
                    startActivity(next);
                }
            }
        });






        caa=(Button)findViewById(R.id.cableam);
        caa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag==1)
                {
                    // Intent romper1 = new Intent(SelectBomba.this,Menu.class);
                    caa.setBackgroundResource(R.drawable.cableroto);
                    x = 1;
                    //Menu.bandera = 1;
                    flag = 2;
                    //timer.cancel();
                }
                else
                {
                    timer.cancel();
                    flag=0;
                    stop_mp();
                    Intent next = new Intent(SelectBomba.this,perdio.class);
                    startActivity(next);
                }
            }
        });



        car=(Button)findViewById(R.id.cablero);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag==2) {
                    // Intent romper = new Intent(SelectBomba.this, Menu.class);
                    //if(x==1){
                    car.setBackgroundResource(R.drawable.cableroto);
                    //  Menu.bandera=1;
                    x = 2;
                    //}
                    //else{
                    // car.setBackgroundResource(R.drawable.cableroto);
                    //  Intent atras = new Intent(SelectBomba.this,Menu.class);
                    //   Menu.bandera=1;
                    //     startActivity(atras);
                    // }
                    flag=0;
                    stop_mp();
                    timer.cancel();
                    Intent nx = new Intent(SelectBomba.this,gana.class);
                    startActivity(nx);
                }
                else
                {
                    timer.cancel();
                    flag=0;
                    stop_mp();
                    Intent next = new Intent(SelectBomba.this,perdio.class);
                    startActivity(next);
                }
            }
        });


     ///////////////////////////////////////////////////////////////////////////////////////////////
        /*

        car=(Button)findViewById(R.id.cablero);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent romper = new Intent(SelectBomba.this, Menu.class);
                if(x==1){
                car.setBackgroundResource(R.drawable.cableroto);
                    Menu.bandera=1;
                    x=2;
                }
                else{
                    car.setBackgroundResource(R.drawable.cableroto);
                    Intent atras = new Intent(SelectBomba.this,Menu.class);
                    Menu.bandera=1;
                    startActivity(atras);
                }

                timer.cancel();
                }
            });


        caa=(Button)findViewById(R.id.cableam);
        caa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent romper1 = new Intent(SelectBomba.this,Menu.class);
                    caa.setBackgroundResource(R.drawable.cableroto);
                    x=1;
                    Menu.bandera = 1;
                flag=2;
                //timer.cancel();
            }

        });

        caz=(Button)findViewById(R.id.cableaz);
        caz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent romper = new Intent(SelectBomba.this, Menu.class);
                if(x==2){
                    caz.setBackgroundResource(R.drawable.cableroto);
                    Menu.bandera=1;
                }
                else{
                    caz.setBackgroundResource(R.drawable.cableroto);
                    Intent atras = new Intent(SelectBomba.this,Menu.class);
                    Menu.bandera=1;
                    startActivity(atras);
                }
                flag=1;
                //timer.cancel();
            }
        });

        */
        ///////////////////////////////////////////////////////////////////////////////////

    }

    private void play_mp()
    {
        Thread playThread = new Thread()
        {
            public void run()
            {
                if(flag2==0) {
                    mediaPlayer = mediaPlayer.create(SelectBomba.this, R.raw.jug);
                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                    flag2=1;
                }
                else
                {
                    mediaPlayer.stop();
                    flag2=0;
                }
            }
        };
        playThread.start();
    }

    private void stop_mp()
    {
        mediaPlayer.stop();
        flag2=0;
    }





    public class CounterClass extends CountDownTimer {

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished)
        {
            long millis = millisUntilFinished;

            String hms = String.format("%02d:%02d", //TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));

           // System.out.println(hms);
            muestra.setText(hms);

        }

        @Override
        public void onFinish() {

            stop_mp();
            Intent next = new Intent(SelectBomba.this,perdio.class);
            startActivity(next);

        }
    }



}
