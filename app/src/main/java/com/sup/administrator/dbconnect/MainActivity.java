package com.sup.administrator.dbconnect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText e1,e2,e3,e4;
    Button b;
    String s1,s2,s3,s4;
    dbconnect dbc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.name);
        e2=(EditText)findViewById(R.id.roll);
        e3=(EditText)findViewById(R.id.adno);
        e4=(EditText)findViewById(R.id.col);
        dbc=new dbconnect(this);
        dbc.getWritableDatabase();
        b=(Button)findViewById(R.id.sub);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                Log.d("name",s1);
                Log.d("roll no",s2);
                Log.d("adno",s3);
                Log.d("college",s4);
                boolean status=dbc.insert(s1,s2,s3,s4);
                if(status==true)
                {
                    Toast.makeText(getApplicationContext(),"successfull",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
