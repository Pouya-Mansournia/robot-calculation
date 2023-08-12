package pouyamn.robotcalculationapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ElectronicSection extends AppCompatActivity {

    TextView totalpower, maximumcurent, totalpack;
    EditText Sv, Mt, Av, Do, Nm;
    Button Calc_BTN;

    Double SV;
    Double MT;
    Double AV;
    Double DO;
    Double NM;


    float TOTALPOWER, MAXICURRENT, TOTALPACK = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronic);
        init();


        Calc_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Snum1 = Sv.getText().toString();
                SV = Double.valueOf(Snum1);
                String Snum2 = Mt.getText().toString();
                MT = Double.valueOf(Snum2);
                String Snum3 = Av.getText().toString();
                AV = Double.valueOf(Snum3);
                String Snum4 = Do.getText().toString();
                DO = Double.valueOf(Snum4);
                String Snum5 = Nm.getText().toString();
                NM = Double.valueOf(Snum5);


                MAXICURRENT = (float) (((MT * (AV * 0.1047))) / (SV));
                TOTALPOWER = (float) ((MAXICURRENT) * (SV));
                TOTALPACK = (float) (MAXICURRENT * (DO / 60) * NM);


                totalpower.setText(String.format("Total Power : " + "%.2f" + " W ", TOTALPOWER));
                maximumcurent.setText(String.format("Maximum Current : " + "%.2f" + " A ", MAXICURRENT));
                totalpack.setText(String.format("Battery Pack : " + "%.2f" + " Ah ", TOTALPACK));

            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_Mechanic) {
            Intent open_activity = new Intent("android.intent.action.MECHANICSECTION");
            startActivity(open_activity);
        }
        if (id == R.id.action_Electronic) {
            Intent open_activity = new Intent("android.intent.action.ELECTRONICSECTION");
            startActivity(open_activity);
        }
        if (id == R.id.action_Manipulator) {
            Intent open_activity = new Intent("android.intent.action.MANIPULATOR");
            startActivity(open_activity);
        }
        if (id == R.id.action_Aboutus) {
            Intent open_activity = new Intent("android.intent.action.ABOUTUS");
            startActivity(open_activity);
        }
        if (id == R.id.action_logout) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void init() {


        Sv = (EditText) findViewById(R.id.ET0);
        Mt = (EditText) findViewById(R.id.ET1);
        Av = (EditText) findViewById(R.id.ET2);
        Do = (EditText) findViewById(R.id.ET3);
        Nm = (EditText) findViewById(R.id.ET4);


        Calc_BTN = (Button) findViewById(R.id.button_Calct);
        totalpower = (TextView) findViewById(R.id.TV12);
        totalpack = (TextView) findViewById(R.id.TV14);
        maximumcurent = (TextView) findViewById(R.id.TV13);


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}

