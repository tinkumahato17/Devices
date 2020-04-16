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

public class input_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_);
        Button btnmouse = findViewById(R.id.btn_mouse);
        Button btnkeyboard = findViewById(R.id.btn_keyboard);
        Button btnmicrophone = findViewById(R.id.btn_microphone);
        Button btntouch = findViewById(R.id.btn_touch_screen);
        Button btnjoystick = findViewById(R.id.btn_joystick);
        Button btnscanner = findViewById(R.id.btn_optical_scanner);
        btnscanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startscanner();
            }
        });
        btnjoystick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startjoystick();
            }
        });
        btntouch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starttouch();
            }
        });
        btnmicrophone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startmicrophone();
            }
        });
        btnkeyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startkeyboard();
            }
        });
        btnmouse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startmouse();
            }
        });

    }
    private void startmouse(){
        Intent intent =new Intent(this, mouseActivity.class);
        startActivity(intent);
    }
    private void startkeyboard(){
        Intent intent = new Intent(this, KeyboardActivity.class);
        startActivity(intent);
    }
    private void startmicrophone(){
        Intent intent = new Intent(this, MicrophoneActivity.class);
        startActivity(intent);
    }
    private void starttouch(){
        Intent intent = new Intent(this, touch_screenActivity.class);
        startActivity(intent);
    }
    private void startjoystick() {
        Intent intent = new Intent(this, joystickActivity.class);
        startActivity(intent);
    }
    private void startscanner(){
        Intent intent = new Intent(this, ScannerActivity.class);
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
                return true;


            case R.id.about:
                Toast.makeText(this, "This application is created by TINKU MAHATO", Toast.LENGTH_LONG).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
