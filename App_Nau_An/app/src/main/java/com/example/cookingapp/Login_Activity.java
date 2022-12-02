package com.example.cookingapp;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Login_Activity extends AppCompatActivity {
    PhoneAuthProvider.ForceResendingToken mResendToken;
    private String mVerificationId;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText edtuser = findViewById(R.id.user);
        EditText edtpass =findViewById(R.id.pass);
        Button btnlg = findViewById(R.id.btnlogin);
        Button btnVerifyPhoneNumber = findViewById(R.id.btnVerifyPhoneNumber);
        ImageView backbtn = findViewById(R.id.backbtn);
        mAuth = FirebaseAuth.getInstance();




        btnVerifyPhoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strPhone = edtuser.getText().toString().trim();
                sendVerificationCode(strPhone);
            }
        });
        

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_Activity.this,MainActivity.class));
            }
        });
        btnlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Login_Activity.this,Menu_Activity.class));
            }
        });





    }
     private void sendVerificationCode(String number) {
     PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mAuth) .setPhoneNumber(number)
    .setTimeout(60L, TimeUnit.SECONDS)
     .setActivity(this) .setCallbacks(mCallbacks)
   .build(); PhoneAuthProvider.verifyPhoneNumber(options);
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override public void onVerificationCompleted(PhoneAuthCredential credential) {

            Log.d(TAG, "onVerificationCompleted:" + credential);
            verifyCode(credential.getSmsCode());
        }
            @Override public void onVerificationFailed(FirebaseException e) {
            Log.w(TAG, "onVerificationFailed", e); if (e instanceof FirebaseAuthInvalidCredentialsException) {
           Toast.makeText(getApplicationContext(), "Request fail", Toast.LENGTH_SHORT).show();
           } else if (e instanceof FirebaseTooManyRequestsException) {
            Toast.makeText(getApplicationContext(), "Quota không đủ", Toast.LENGTH_SHORT).show();
          }
            } @Override public void onCodeSent(@NonNull String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken token) {
            Log.d(TAG, "onCodeSent:" + verificationId);
            Toast.makeText(getApplicationContext(), "Đã gửi OTP", Toast.LENGTH_SHORT).show();
            mVerificationId = verificationId; mResendToken = token; }
             };


    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);
        signInWithPhoneAuthCredential(credential);
    }
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential) .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override public void onComplete(@NonNull Task<AuthResult> task) { if (task.isSuccessful()) {
                Log.d(TAG, "signInWithCredential:success"); FirebaseUser user = task.getResult().getUser();
                Toast.makeText(getApplicationContext(), "Thành công" + user.getUid(), Toast.LENGTH_SHORT).show();
            } else { Log.w(TAG, "signInWithCredential:failure", task.getException());
                if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                    Toast.makeText(getApplicationContext(), "lỗi", Toast.LENGTH_SHORT).show();
                }
            }
            }
        });
    }
}
