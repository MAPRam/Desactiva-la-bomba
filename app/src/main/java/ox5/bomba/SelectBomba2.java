package ox5.bomba;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

/**
 * Created by Ox5 on 09/06/2016.
 */
public class SelectBomba2 extends AppCompatActivity {
    public Button regresar1;
    public Button car;
    public Button caz;
    public Button caa;
    public int x=0;
    private TextView muestra;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectbomba2);


        muestra = (TextView)findViewById(R.id.muestratext);
        muestra.setText("0:03:00");

        final CounterClass timer = new CounterClass(10000,1000);///////////////////////////////////
        timer.start();




        regresar1=(Button)findViewById(R.id.Regresar1);
        regresar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent atras1 = new Intent(SelectBomba2.this,Menu.class);
                startActivity(atras1);
                timer.cancel();
            }
        });
        /*car=(Button)findViewById(R.id.cablero);
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent romper = new Intent(SelectBomba.this, Menu.class);
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
            }
        });
        caa=(Button)findViewById(R.id.cableaz);
        caa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent romper1 = new Intent(SelectBomba.this,Menu.class);
                caa.setBackgroundResource(R.drawable.cableroto);
                x=1;
                Menu.bandera = 1;
            }

        });
        caz=(Button)findViewById(R.id.cableam);
        caz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent romper = new Intent(SelectBomba.this, Menu.class);
                if(x==2){
                    caa.setBackgroundResource(R.drawable.cableroto);
                    Menu.bandera=1;
                }
                else{
                    car.setBackgroundResource(R.drawable.cableroto);
                    Intent atras = new Intent(SelectBomba.this,Menu.class);
                    Menu.bandera=1;
                    startActivity(atras);
                }
            }
        });*/







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

            System.out.println(hms);
            muestra.setText(hms);

        }

        @Override
        public void onFinish() {


            Intent next = new Intent(SelectBomba2.this,perdio.class);
            startActivity(next);

        }
    }



}