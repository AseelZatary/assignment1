package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    EditText edtFirstName;
    EditText edtLastName;
    EditText edtEmail;
    EditText edtPhoneNumber;
    EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setupViews();
    }

    private void setupViews() {
        edtFirstName = findViewById(R.id.name);
        edtLastName = findViewById(R.id.last);
        edtEmail = findViewById(R.id.email);
        edtPhoneNumber = findViewById(R.id.num);
        edtPassword = findViewById(R.id.pass);

    }
    String FirstName;
    String LastName;
    String Email;
    String PhoneNumber;
    String Password;

    public void btnSignUp(View view) {
        FirstName = edtFirstName.getText().toString();
        LastName = edtLastName.getText().toString();
        Email = edtEmail.getText().toString();
        PhoneNumber = edtPhoneNumber.getText().toString();
        Password = edtPassword.getText().toString();
        if (validateInputs()) {
            addUsers(FirstName, LastName, Email, PhoneNumber, Password);
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    private boolean validateInputs() {
        if (Email.isEmpty()) {
            edtEmail.setError("This field can not be blank");
            edtEmail.requestFocus();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
            edtEmail.setError("Enter valid email address");
            edtEmail.requestFocus();
            return false;
        } else if (Password.isEmpty()) {
            edtPassword.setError("This field can not be blank");
            edtPassword.requestFocus();
            return false;
        }
        else if (PhoneNumber.isEmpty()) {
            edtPhoneNumber.setError("This field can not be blank");
            edtPhoneNumber.requestFocus();
            return false;
        }
        else if (LastName.isEmpty()) {
            edtLastName.setError("This field can not be blank");
            edtLastName.requestFocus();
            return false;
        }
        else if (FirstName.isEmpty()) {
            edtFirstName.setError("This field can not be blank");
            edtFirstName.requestFocus();
            return false;
        }
        return true;
    }

    private void addUsers(String FirstName,String LastName,String Email,String PhoneNumber,String Password) {
        String url = "http://localhost:8080/android/signup.php";
        RequestQueue queue = Volley.newRequestQueue(SignUpActivity.this);
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("TAG", "RESPONSE IS " + response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    // on below line we are displaying a success toast message.
                    Toast.makeText(SignUpActivity.this,
                            jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                    Toast.makeText(SignUpActivity.this,
                            "Now You Can Log In With Your New Account", Toast.LENGTH_LONG).show();
                } catch ( JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(SignUpActivity.this,
                        "Fail Sign Up = " + error, Toast.LENGTH_LONG).show();

            }
        }) {
            @Override
            public String getBodyContentType() {
                // as we are passing data in the form of url encoded
                // so we are passing the content type below
                return "application/x-www-form-urlencoded; charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() {

                // below line we are creating a map for storing
                // our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our
                // key and value pair to our parameters.
                params.put("FirstName", FirstName);
                params.put("LastName", LastName);
                params.put("Email", Email);
                params.put("PhoneNumber", PhoneNumber);
                params.put("Password", Password);

                // at last we are returning our params.
                return params;
            }
        };
        // below line is to make
        // a json object request.
        queue.add(request);
    }


    public void btnOnClickBack(View view) {
        Intent intent = new Intent(SignUpActivity.this, WelcomActivity.class);
        startActivity(intent);
    }
}