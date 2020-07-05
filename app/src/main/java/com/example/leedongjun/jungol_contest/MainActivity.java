package com.example.leedongjun.jungol_contest;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView1 = (ImageView) findViewById(R.id.exercise);
        ImageView imageView2 = (ImageView) findViewById(R.id.bluetooth);
        ImageView imageView3 = (ImageView) findViewById(R.id.advise);
        Button Button1 = (Button) findViewById(R.id.emergency);


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, exercise.class);
                startActivity(intent);
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent1 = new Intent(MainActivity.this, bluetooth.class);
                startActivity(intent1);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent2 = new Intent(MainActivity.this, advise.class);
                startActivity(intent2);
            }
        });

        Button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                /**
                 * 사용자의 OS Version이 마쉬멜로우 이상인지
                 */
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    // 사용자 단말기의 권한 중 "전화걸기" 권한이 허용 되어 있는지 체크
                    int permissionResult = checkSelfPermission(Manifest.permission.CALL_PHONE);

                    if (permissionResult == PackageManager.PERMISSION_DENIED) {
                        // 권한 없음
                        if (shouldShowRequestPermissionRationale(Manifest.permission.CALL_PHONE)) {
                            // 권한을 한번이라도 거부한 적 있는지 검사
                            // 있다면 true 리턴 || 없다면 false 리턴
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("권한 필요")
                                    .setMessage("기능을 사용하기 위해 단말기의 '전화걸기' 권한이 필요합니다")
                                    .setPositiveButton("네", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                                            }
                                        }
                                    })
                                    .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Toast.makeText(MainActivity.this, "기능 취소", Toast.LENGTH_SHORT).show();
                                        }
                                    }).create().show();
                        } else {
                            // 권한 거부한 적 없음 CALL_PHONE 권한을 요청
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                        }
                    } else {
                        // 권한 존재
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-4615-6192")); //원래 애플리케이션은 119전화
                        startActivity(intent);
                    }
                } else {
                    // 마쉬멜로 이전 버전이라면
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-4615-6192"));//원래 애플리케이션은 119전화
                    startActivity(intent);
                }
            }

        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1000) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // 요청한 권한 허용 시
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-4615-6192"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "권한 요청 거부", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
