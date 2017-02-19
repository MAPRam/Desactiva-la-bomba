package ox5.bomba;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

/**
 * Created by Ox5 on 16/06/2016.
 */
public class Ajustes extends AppCompatActivity {
    public Button regresar;
    private SeekBar volumeSeekbar = null;
    AudioManager audioManager;


    int flag=0;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajustes);


        Menu.global=1;
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        mediaPlayer = new MediaPlayer();

        play_mp();

        setContentView(R.layout.ajustes);
        initControls();



        regresar=(Button)findViewById(R.id.Regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent atras = new Intent(Ajustes.this,Menu.class);
                stop_mp();
                startActivity(atras);


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
                    mediaPlayer = mediaPlayer.create(Ajustes.this, R.raw.menu);
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






    private void initControls() {
        try {
            volumeSeekbar = (SeekBar) findViewById(R.id.seekBar);
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            volumeSeekbar.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            volumeSeekbar.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC));


            volumeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onStopTrackingTouch(SeekBar arg0) {
                }

                @Override
                public void onStartTrackingTouch(SeekBar arg0) {
                }

                @Override
                public void onProgressChanged(SeekBar arg0, int progress, boolean arg2) {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                            progress, 0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
