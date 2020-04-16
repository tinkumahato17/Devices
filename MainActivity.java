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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnnetwork = findViewById(R.id.btn_networking_devices);
        Button btninput = findViewById(R.id.btn_input_devices);
        Button btnoutput = findViewById(R.id.btn_output_devices);
        btnoutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startoutput();
            }
        });
        btninput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startinput();
            }
        });
        btnnetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startnetwork();
            }
        });
    }

    private void startnetwork() {
        Intent intent = new Intent(MainActivity.this, networkActivity.class);
        startActivity(intent);
    }
    private void startinput(){

        Intent intent = new Intent(this, input_Activity.class);
        startActivity(intent);
    }
    private  void startoutput(){
        Intent intent = new Intent(this, output_devices_Activity.class);
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
                String sharebody = "Updating";
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
