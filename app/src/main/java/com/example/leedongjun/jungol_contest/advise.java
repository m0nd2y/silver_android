package com.example.leedongjun.jungol_contest;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class advise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advise);


        TextView textView1 = (TextView) findViewById(R.id.call1);
        TextView textView2 = (TextView) findViewById(R.id.call2);
        TextView textView3 = (TextView) findViewById(R.id.call3);
        TextView textView4 = (TextView) findViewById(R.id.call4);

        textView1.setOnClickListener(new View.OnClickListener() {
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
                            AlertDialog.Builder dialog = new AlertDialog.Builder(advise.this);
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
                                            Toast.makeText(advise.this, "기능 취소", Toast.LENGTH_SHORT).show();
                                        }
                                    }).create().show();
                        } else {
                            // 권한 거부한 적 없음 CALL_PHONE 권한을 요청
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                        }
                    } else {
                        // 권한 존재
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-723-9988"));
                        startActivity(intent);
                    }
                } else {
                    // 마쉬멜로 이전 버전이라면
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-723-9988"));
                    startActivity(intent);
                }
            }

        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { /**
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
                            AlertDialog.Builder dialog = new AlertDialog.Builder(advise.this);
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
                                            Toast.makeText(advise.this, "기능 취소", Toast.LENGTH_SHORT).show();
                                        }
                                    }).create().show();
                        } else {
                            // 권한 거부한 적 없음 CALL_PHONE 권한을 요청
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                        }
                    } else {
                        // 권한 존재
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-763-9195"));
                        startActivity(intent);
                    }
                } else {
                    // 마쉬멜로 이전 버전이라면
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-763-9195"));
                    startActivity(intent);
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { /**
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
                            AlertDialog.Builder dialog = new AlertDialog.Builder(advise.this);
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
                                            Toast.makeText(advise.this, "기능 취소", Toast.LENGTH_SHORT).show();
                                        }
                                    }).create().show();
                        } else {
                            // 권한 거부한 적 없음 CALL_PHONE 권한을 요청
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                        }
                    } else {
                        // 권한 존재
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:1577-0199"));
                        startActivity(intent);
                    }
                } else {
                    // 마쉬멜로 이전 버전이라면
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:1577-0199"));
                    startActivity(intent);
                }
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { /**
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
                            AlertDialog.Builder dialog = new AlertDialog.Builder(advise.this);
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
                                            Toast.makeText(advise.this, "기능 취소", Toast.LENGTH_SHORT).show();
                                        }
                                    }).create().show();
                        } else {
                            // 권한 거부한 적 없음 CALL_PHONE 권한을 요청
                            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
                        }
                    } else {
                        // 권한 존재
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:031-390-7633"));
                        startActivity(intent);
                    }
                } else {
                    // 마쉬멜로 이전 버전이라면
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:031-390-7633"));
                    startActivity(intent);
                }
            }
        });
    }

}
