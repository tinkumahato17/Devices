package in.santiniketan.devices;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class output_devices_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_devices_);

        Button btnmonitor = findViewById(R.id.btn_monitor);
        Button btnprinter = findViewById(R.id.btn_printer);
        Button btnaudio = findViewById(R.id.btn_audio_speakers);
        Button btnheadphones = findViewById(R.id.btn_headphones);
        Button btnprojector = findViewById(R.id.btn_projector);
        Button btnsound = findViewById(R.id.btn_sound_card);
        Button btnvideo = findViewById(R.id.btn_video_card);
        btnvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startvideo();
            }
        });
        btnsound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startsound();
            }
        });
        btnprojector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startprojector();
            }
        });
        btnheadphones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startheadphones();
            }
        });
        btnaudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startaudio();
            }
        });
        btnprinter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startprinter();
            }
        });
        btnmonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startmonitor();
            }
        });
    }
    private void startmonitor(){

        Intent intent = new Intent(this, monitorActivity.class);
        startActivity(intent);
    }
    private void startprinter(){
        Intent intent = new Intent(this, printerActivity.class);
        startActivity(intent);
    }
    private void startaudio(){
        Intent intent = new Intent(this, audio_speakers_Activity.class);
        startActivity(intent);
    }
    private void startheadphones(){
        Intent intent = new Intent(this, headphonesActivity.class);
        startActivity(intent);
    }
    private void startprojector(){
        Intent intent = new Intent(this, projectorActivity.class);
        startActivity(intent);
    }
    private void startsound(){
        Intent intent = new Intent(this, sound_card_Activity.class);
        startActivity(intent);
    }
    private void startvideo(){
        Intent intent = new Intent(this, video_card_Activity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.shear:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String sharebody = "Your body here";
                String sharesubject = "Your subject here";
                sharingIntent.putExtra(Intent.EXTRA_TEXT, sharebody);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, sharesubject);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                return  true;
            case R.id.about:
                Toast.makeText(this, "This application is created by TINKU MAHATO", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
