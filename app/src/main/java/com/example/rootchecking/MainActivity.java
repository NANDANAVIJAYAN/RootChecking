package com.example.rootchecking;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity
{

    private TextView mText;
    public Button mBtn;

    public String[] binaryPaths= {
            "/data/local/",
            "/data/local/bin/",
            "/data/local/xbin/",
            "/sbin/",
            "/su/bin/",
            "/system/bin/",
            "/system/bin/.ext/",
            "/system/bin/failsafe/",
            "/system/sd/xbin/",
            "/system/usr/we-need-root/",
            "/system/xbin/",
            "/system/app/Superuser.apk",
            "/cache",
            "/data",
            "/dev"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText = findViewById(R.id.textView);
        mBtn = findViewById(R.id.btn);



    }
    private void checkForBinary(String filename)
    {
        for (String path : binaryPaths)
        {
            File f = new File(path, filename);
            boolean fileExists = f.exists();
            if (fileExists)
            {
                mText.setText(R.string.text1);

            }
            else
            {
                mText.setText(R.string.text2);


            }
        }
    }

    private void checkForSuBinary()
    {
        checkForBinary("su");
    }

    private void checkForBusyBoxBinary() {
        checkForBinary("busybox");
    }

    public void checkRoot(View view)
    {
        checkForSuBinary();
        checkForBusyBoxBinary();
    }
}