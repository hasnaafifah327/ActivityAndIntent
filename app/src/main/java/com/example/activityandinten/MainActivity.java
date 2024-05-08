package com.example.activityandinten;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText noTelephone;
    private EditText alamat;
    private android.widget.Toast Toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noTelephone=(EditText)findViewById(R.id.noTelephone);
        alamat=(EditText)findViewById(R.id.alamat);
    }

    public void kirimSMS(View view) {
        Uri uri =Uri.parse("smsto:"+noTelephone.getText().toString());
        Intent sendSMS = new Intent(Intent.ACTION_SENDTO, uri);
        sendSMS.putExtra("sms_body", "ini latihanku"); //put extra sebagai transfer data antar activiti, aplikasi inten ke aplikasi pesan
        if(sendSMS.resolveActivity(getPackageManager()) !=null){
            startActivity(sendSMS);
        }
    }

    public void cariAlamat(View view) {
        String alamatInput = alamat.getText().toString();
        Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=" + alamatInput));
            startActivity(mapIntent);
    }
}
