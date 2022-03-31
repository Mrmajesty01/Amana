package com.majestyinc.amana;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



public class RegisterActivity extends AppCompatActivity {


    EditText name,username,email;

    TextView signin,forgot;
    Button login;
    String nam,un,mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        login = findViewById(R.id.btnLogin);

        signin = findViewById(R.id.gotoRegister);

        name = findViewById(R.id.Name);
        username = findViewById(R.id.userId);
        email = findViewById(R.id.Email);
        forgot = findViewById(R.id.forgotPassword);
        String number = "08054062271";




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//             Intent intent  = new Intent(RegisterActivity.this,MainActivity.class);
//                startActivity(intent);

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

                StrictMode.setThreadPolicy(policy);

                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                MediaType mediaType = MediaType.parse("application/json");
                JSONObject data = new JSONObject();
                try {

                    data.put("customer reference", username.getText().toString());
                    data.put("name", name.getText().toString());
                    data.put("email", email.getText().toString());
                    data.put("mobile number",number);
                }
                catch (Exception e) {
                    Log.e("JSON ERROR",e.getMessage().toString());

                }

                RequestBody body = RequestBody.create(mediaType,data.toString());

                    Log.e("REQUEST", "BODY CREATED");
                    Request request = new Request.Builder()
                            .url("https://fsi.ng/v2/api/woven/vnubans/create_customer")
                            .method("POST", body)
                            .addHeader("Content-Type", "application/json")
                            .addHeader("api_secret", "vb_ls_bfac75fe54a952841971b6918d06aeb2659523dc92d6")
                            .addHeader("sandbox-key", "KYJFTVZjbctxMNSiY7auEIaDxSLZoRvA1633185367")
                            .build();

                try {
                    Response response = client.newCall(request).execute();
                    Log.e("REQUEST", "SERVER GOT RESPONSE");
                    Log.e("REQUEST",response.body().toString());
                }
                catch (IOException e) {
                    e.printStackTrace();
                    Log.e("REQUEST", e.getMessage().toString());
                }


            }
        });

      signin.setOnClickListener(new View.OnClickListener() {
           @Override
     public void onClick(View v) {
               Intent sign = new Intent(RegisterActivity.this, LoginActivity.class);
             startActivity(sign);
    }

      });

    }


}
