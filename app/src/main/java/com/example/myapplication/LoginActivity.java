package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private final String apiURL = "http://localhost:8080/android/login.php";
    private RequestQueue queue;
    private String Email;
    private String uId;
    private String Password;
    private EditText etEmail;
    private EditText etPassword;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Gson gson = new Gson();
    private JSONObject responceJsonObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

        if (sharedPreferences.getString("Email", "") != null) {
            etEmail.setText(sharedPreferences.getString("Email", ""));
            etPassword.setText(sharedPreferences.getString("Password", ""));
        }
    }

    public void login(View view) throws JSONException {
        Email = etEmail.getText().toString();
        Password = etPassword.getText().toString();

        if (validateInputs()) {
            validateLogin();
        }
    }

    public void signup(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    private boolean validateInputs() {
        if (Email.isEmpty()) {
            etEmail.setError("This field can not be blank");
            etEmail.requestFocus();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            etEmail.setError("Enter valid email address");
            etEmail.requestFocus();
            return false;
        } else if (Password.isEmpty()) {
            etPassword.setError("This field can not be blank");
            etPassword.requestFocus();
            return false;
        }
        return true;
    }

    private void validateLogin() {
        queue= Volley.newRequestQueue(LoginActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, apiURL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    responceJsonObject = new JSONObject(response);
                    if (responceJsonObject.has("user")) {
                        if (!responceJsonObject.isNull("user")) {
                            JSONObject responceJsonObject2 = responceJsonObject.getJSONObject("user");
                            uId = responceJsonObject2.getString("uId");
                            loginIsValid();
                        } else {
                            etPassword.setText("");
                            Toast.makeText(LoginActivity.this,
                                    "No Such User Exists", Toast.LENGTH_LONG).show();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Email", Email);
                params.put("Password", Password);
                return params;
            }

            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

        };
        queue.add(request);
    }

    private void loginIsValid() throws JSONException {

        Intent intent = new Intent(LoginActivity.this, WelcomActivity.class);
        startActivity(intent);
    }
}