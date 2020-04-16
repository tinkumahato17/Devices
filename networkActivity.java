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

public class networkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        Button btnrouters = findViewById(R.id.btn_router);
        Button btnbridge = findViewById(R.id.btn_bridge);
        Button btnhub = findViewById(R.id.btn_hub);
        Button btnrepeaters = findViewById(R.id.btn_Repeater);
        Button btnswitch = findViewById(R.id.btn_switch);
        Button btngateway = findViewById(R.id.btn_gateway);
        btngateway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startgateway();
            }
        });
        btnswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startswitch();
            }
        });
        btnrepeaters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startrepeaters();
            }
        });

        btnhub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                starthub();
            }
        });

        btnbridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startbridge();
            }
        });
        btnrouters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startrouters();
            }
        });
    }
    private void startrouters(){

        Intent intent = new Intent(networkActivity.this, routersActivity.class);
        startActivity(intent);
    }
    private  void startbridge(){

        Intent intent = new Intent(networkActivity.this, bridgeActivity.class);
        startActivity(intent);
    }
    private void starthub(){
        Intent intent = new Intent(networkActivity.this, hubActivity.class);
        startActivity(intent);
    }
    private void startrepeaters(){
        Intent intent = new Intent(networkActivity.this, repeatersActivity.class);
        startActivity(intent);
    }
    private void  startswitch(){

        Intent intent = new Intent(networkActivity.this, switshActivity.class);
        startActivity(intent);

    }
    private void startgateway(){
        Intent intent = new Intent(networkActivity.this, gatewayActivity.class);
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
