package com.example.cookingapp;

import static com.example.cookingapp.R.id.verifyBtn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OTP extends AppCompatActivity {
    EditText cCode,phoneNumber,MAOTP;
    Button sendOTPtn,verifyBtn,resendOTPtn;
    String userPhoneNumber,verifycationId;
    PhoneAuthProvider.ForceResendingToken token;
    FirebaseAuth fAuth;
    PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        cCode = findViewById(R.id.cCode);
        phoneNumber = findViewById(R.id.phoneNumber);
        MAOTP = findViewById(R.id.MAOTP);

        sendOTPtn = findViewById(R.id.sendOTPtn);
        verifyBtn = findViewById(R.id.verifyBtn);
        resendOTPtn = findViewById(R.id.resendOTPtn);
        resendOTPtn.setEnabled(false);

        fAuth = FirebaseAuth.getInstance();

        sendOTPtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cCode.getText().toString().isEmpty()){
                    cCode.setError("Lỗi");
                    return;
                }
                if (phoneNumber.getText().toString().isEmpty()){
                    phoneNumber.setError("ABC");
                    return;
                }
                userPhoneNumber = ""+cCode.getText().toString()+phoneNumber.getText().toString();
                verifyPhoneNumber(userPhoneNumber);
                Toast.makeText(OTP.this,userPhoneNumber, Toast.LENGTH_SHORT).show();
            }
        });

        verifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (MAOTP.getText().toString().isEmpty()){
                    MAOTP.setError("Nhập Mã OTP");
                    return;
                }

                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verifycationId,MAOTP.getText().toString());
                authenticatteUser(credential);
            }
        });

        callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                authenticatteUser(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                Toast.makeText(OTP.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                verifycationId = s;
                token = forceResendingToken;

                cCode.setVisibility(View.GONE);
                phoneNumber.setVisibility(View.GONE);
                sendOTPtn.setVisibility(View.GONE);


                MAOTP.setVisibility(View.VISIBLE);
                verifyBtn.setVisibility(View.VISIBLE);
                resendOTPtn.setVisibility(View.VISIBLE);
                resendOTPtn.setEnabled(false);

            }

            @Override
            public void onCodeAutoRetrievalTimeOut(@NonNull String s) {
                super.onCodeAutoRetrievalTimeOut(s);
                resendOTPtn.setEnabled(true);

            }
        };




    }
    public void verifyPhoneNumber(String phoneNum){

        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(fAuth)
                .setActivity(this)
                .setPhoneNumber(phoneNum)
                .setTimeout(60L, TimeUnit.SECONDS)
                .setCallbacks(callbacks)
                .build();

        PhoneAuthProvider.verifyPhoneNumber(options);


    }
    public void authenticatteUser(PhoneAuthCredential credential){
        fAuth.signInWithCredential(credential).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(OTP.this, "Succes", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),OTP2.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(OTP.this,e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (FirebaseAuth.getInstance().getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(),OTP2.class));
            finish();
        }
    }
}