package com.example.leedongjun.jungol_contest;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class exercise extends Activity implements SensorEventListener {

    public static int cnt = 0;

    private TextView tView;
    private Button resetBtn;

    private long lastTime;
    private float speed;
    private float lastX;
    private float lastY;
    private float lastZ;
    private float x, y, z;

    private static final int SHAKE_THRESHOLD = 800;
    private static final int DATA_X = SensorManager.DATA_X;
    private static final int DATA_Y = SensorManager.DATA_Y;
    private static final int DATA_Z = SensorManager.DATA_Z;

    private SensorManager sensorManager;
    private Sensor accelerormeterSensor;
    private Handler mHandler;
    private long curTime = System.currentTimeMillis();
    Calendar cal = Calendar.getInstance();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.exercise);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerormeterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        TextView alarm = (TextView) findViewById(R.id.alarmBtn);
        tView = (TextView) findViewById(R.id.cntView);
        TextView textView = (TextView) findViewById(R.id.cntView);



        tView.setText(cnt + "회");

        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationManager notificationManager= (NotificationManager)exercise.this.getSystemService(exercise.this.NOTIFICATION_SERVICE);
                Intent intent1 = new Intent(exercise.this.getApplicationContext(),exercise.class); //인텐트 생성.

                Notification.Builder builder = new Notification.Builder(getApplicationContext());
                intent1.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP);

                PendingIntent pendingNotificationIntent = PendingIntent.getActivity( exercise.this,0, intent1,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setSmallIcon(R.drawable.appicon).setTicker("운동").setWhen(System.currentTimeMillis())
                        .setNumber(1).setContentTitle(">운=동<").setContentText("3시간 후 운동하세요!")
                        .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE).setContentIntent(pendingNotificationIntent).setAutoCancel(true).setOngoing(true);
                notificationManager.notify(1, builder.build()); // Notification send
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnt *= 0;
                tView.setText(cnt + "회");
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        if (accelerormeterSensor != null)
            sensorManager.registerListener(this, accelerormeterSensor,
                    SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (sensorManager != null)
            sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            long currentTime = System.currentTimeMillis();
            long gabOfTime = (currentTime - lastTime);
            if (gabOfTime > 100) {
                lastTime = currentTime;
                x = event.values[SensorManager.DATA_X];
                y = event.values[SensorManager.DATA_Y];
                z = event.values[SensorManager.DATA_Z];

                speed = Math.abs(x + y + z - lastX - lastY - lastZ) / gabOfTime * 10000;

                if (speed > SHAKE_THRESHOLD) {
                    tView.setText(++cnt + "회");
                }

                lastX = event.values[DATA_X];
                lastY = event.values[DATA_Y];
                lastZ = event.values[DATA_Z];
            }
        }
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}