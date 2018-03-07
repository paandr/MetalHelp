package com.gmail.gorbaserver.metalhelp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gmail.gorbaserver.metalhelp.classes.DBMetal;

import static com.gmail.gorbaserver.metalhelp.classes.Helper.writeToLog;

public class MainActivity extends AppCompatActivity {

    private DBMetal dbMetal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbMetal = new DBMetal(this);



        try {
            dbMetal.open();
        } catch (Exception e) {
            writeToLog(e.getMessage()+"---"+e.getLocalizedMessage());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbMetal.close();
    }

    public void onClickButton(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnTableTheory:
                startActivity(new Intent(this, TableTheoryActivity.class));
                break;
            case R.id.btnCalculator:
                startActivity(new Intent(this, CalculatorActivity.class));
                break;
            case R.id.btnOperation:
                startActivity(new Intent(this, OperationActivity.class));
                break;
            default:
                break;
        }
    }
}
