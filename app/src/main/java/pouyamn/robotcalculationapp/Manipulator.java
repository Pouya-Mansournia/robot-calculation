package pouyamn.robotcalculationapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Manipulator extends AppCompatActivity {

    TextView angularvolicity, calctorque;
    EditText Tm, Nm, Rw, Rv, Mi, Da, Te;
    Button Calc_BTN;

    Double TM;
    Double NM;
    Double RW;
    Double RV;
    Double MI;
    Double DA;
    Double TE;

    float TORQUE, ANGULARVOLICITY, SIN = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manipulator);
        init();

        Calc_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Snum1 = Tm.getText().toString();
                TM = Double.valueOf(Snum1);
                String Snum2 = Nm.getText().toString();
                NM = Double.valueOf(Snum2);
                String Snum3 = Rw.getText().toString();
                RW = Double.valueOf(Snum3);
//                String Snum4 = Rv.getText().toString();
//                RV = Double.valueOf(Snum4);
//                String Snum5 = Mi.getText().toString();
//                MI = Double.valueOf(Snum5);
//                String Snum6 = Da.getText().toString();
//                DA = Double.valueOf(Snum6);
//                String Snum7 = Te.getText().toString();
//                TE = Double.valueOf(Snum7);


                TORQUE = (float) (((TM*RW)+(0.5*TM*NM))*0.0980665);


                angularvolicity.setText(String.format("Torque : "+"%.2f"+" N.m", TORQUE));
//                angularvolicity.setText(String.format("Angular Velocity : "+"%.4f"+" RPM", ANGULARVOLICITY));


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


        Tm = (EditText) findViewById(R.id.ET0);
        Nm = (EditText) findViewById(R.id.ET1);
        Rw = (EditText) findViewById(R.id.ET2);
        Rv = (EditText) findViewById(R.id.ET3);
        Mi = (EditText) findViewById(R.id.ET4);
        Da = (EditText) findViewById(R.id.ET5);
        Te = (EditText) findViewById(R.id.ET6);


        Calc_BTN = (Button) findViewById(R.id.button_Calct);
        angularvolicity = (TextView) findViewById(R.id.TV12);
        calctorque = (TextView) findViewById(R.id.TV13);

    }
    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
