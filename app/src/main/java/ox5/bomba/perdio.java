package ox5.bomba;

import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class perdio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdio);


        regresiva();

        VideoView videoView = (VideoView) findViewById(R.id.video);
        Uri path = Uri.parse("android.resource://ox5.bomba/" + R.raw.brd);
        //Uri path = Uri.parse("android.resource://com.example.prueba.audio/" + R.raw.brd);


        videoView.setVideoURI(path);
        videoView.start();



    }

    public void regresiva()
    {
        new CountDownTimer(11000,1000)
        {

            @Override
            public void onTick(long millisUntilFinished)
            {


            }
            @Override
            public void onFinish()
            {
                Intent next = new Intent(perdio.this,Menu.class);
                startActivity(next);

            }
        }.start();
    }




}
