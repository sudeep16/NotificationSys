package com.user.notificationsys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button notifyButton1, notifyButton2;
    private NotificationManagerCompat notificationManagerCompat;
    int counter = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        CreateChannel channel = new CreateChannel(this);
        channel.createChannel();

        notifyButton1 = findViewById(R.id.button1);
        notifyButton2 = findViewById(R.id.button2);

        notifyButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification();
            }
        });
        notifyButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotification2();
            }
        });
    }

    private void DisplayNotification(){

        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_warning_black_24dp)
                .setContentTitle("Warning Message")
                .setContentText("This is Warning Message")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(counter, notification);
        counter++;
    }

    private void DisplayNotification2(){
        Notification notification = new NotificationCompat.Builder(this, CreateChannel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_mms_black_24dp)
                .setContentTitle("Normal Notification")
                .setContentText("This is Message")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(counter, notification);
        counter++;
    }

}
