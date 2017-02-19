package ox5.bomba;

import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class gana extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gana);

        regresiva();

        VideoView videoViewa = (VideoView) findViewById(R.id.videoa);
        Uri vid = Uri.parse("android.resource://ox5.bomba/" + R.raw.ggg);
        //Uri path = Uri.parse("android.resource://com.example.prueba.audio/" + R.raw.brd);


        videoViewa.setVideoURI(vid);
        videoViewa.start();



    }

    public void regresiva()
    {
        new CountDownTimer(18000,1000)
        {

            @Override
            public void onTick(long millisUntilFinished)
            {


            }
            @Override
            public void onFinish()
            {
                Intent ne = new Intent(gana.this,Menu.class);
                startActivity(ne);

            }
        }.start();
    }





}

