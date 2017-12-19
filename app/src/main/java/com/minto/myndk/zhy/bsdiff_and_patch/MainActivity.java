package com.minto.myndk.zhy.bsdiff_and_patch;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.minto.myndk.R;
import com.minto.myndk.zhy.utils.ApkExtract;
import com.minto.myndk.zhy.utils.BsPatch;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private Button mBtnPatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mBtnPatch = (Button) findViewById(R.id.id_btn_patch);
        mBtnPatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if (ContextCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
//                } else {
//                }
                    doBspatch();

            }
        });

    }

    private void doBspatch() {
        final File destApk = new File(Environment.getExternalStorageDirectory(), "workHIDB30-1.0.4.apk");
        final File patch = new File(Environment.getExternalStorageDirectory(), "workHIDB.patch");
        final File oldApk = new File(Environment.getExternalStorageDirectory(), "workHIDB30-1.0.1.apk");

        Log.e("hongyang", "patch = " + patch.exists() + " , " + patch.getAbsolutePath());

//        BsPatch.patch(ApkExtract.extract(this),
//                destApk.getAbsolutePath(),
//                patch.getAbsolutePath());
        BsPatch.patch(oldApk.getAbsolutePath(),
                destApk.getAbsolutePath(),
                patch.getAbsolutePath());
        //http://192.168.0.10:8080/td_mobile/mingtu/message/html/message.html?&JSESSIONID=MTIwNTENzcwODQyOTIwMTINQ&roles=80001,900001001,100001003,80005&pid=7925537880936959142&pname=督查室&loginHead=
        Log.e("destApk-----", destApk.getAbsolutePath() + " , 目标文件生成结果为---" + destApk.exists());

        if (destApk.exists())
            ApkExtract.install(this, destApk.getAbsolutePath());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 2) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                doBspatch();
            }
        }
    }
}
