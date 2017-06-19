package com.ench.v7ench.fitnfinenew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Fitness_home extends AppCompatActivity {

    EditText Enumber;
    String Smobile_number;
    ImageButton Isubmit_buton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Enumber=(EditText) findViewById(R.id.emobile_number);
        Isubmit_buton=(ImageButton) findViewById(R.id.isubmit_button);
        Isubmit_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Smobile_number = Enumber.getText().toString();
                if (Smobile_number.length() > 9) {
                    insertme_fit(Smobile_number);

                } else {
                    Toast.makeText(getApplicationContext(), "Enter Valid Mobile Number ", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    public void insertme_fit(final String smobile_number) {
        StringRequest stringRequest =new StringRequest(Request.Method.POST, MyApp_Url.SIGN_IN_FIT, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jObj = new JSONObject(response);
                    boolean exits = jObj.getBoolean("exits");
                    if (exits)
                    {
                        JSONObject user = jObj.getJSONObject("users");
                        String mobile_number = user.getString("mobile_number");
                        Intent intent=new Intent(Fitness_home.this,MySchedule.class);
                        startActivity(intent);
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "SERVER BUSY", Toast.LENGTH_SHORT).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> para = new HashMap<String,String>();
                para.put("mobile_number",smobile_number);
                return para;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest);
    }


}
