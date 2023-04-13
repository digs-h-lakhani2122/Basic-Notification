package coatocl.exaatocl.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int NOTIFICATION_ID = 100;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel nc =new NotificationChannel("My Notification","My notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager nmn =getSystemService(NotificationManager.class);
            nmn.createNotificationChannel(nc);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,"My Notification");
                builder.setContentTitle("ALERT!");
                builder.setContentText("Successful ......");
                builder.setSmallIcon(R.drawable.ic_warning_black_24dp);
                builder.setAutoCancel(true);

                NotificationManagerCompat nm = NotificationManagerCompat.from(MainActivity.this);
                nm.notify(1,builder.build());
//                notification();
                Toast.makeText(MainActivity.this, "NOTIFICATION", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

//    private void notification()
//    {
//        NotificationManager nm=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        NotificationCompat.Builder builder=new NotificationCompat.Builder(this).setSmallIcon(R.drawable.ic_android_black_24dp)
//                .setContentTitle("WARNING!").setContentText("Testing for Notification drawer") .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
//        nm.notify(NOTIFICATION_ID,builder.build());
//    }
    
//    private void notification()
//    {
//        NotificationCompat.Builder notification = new NotificationCompat.Builder(this,"TEST_ID")
//                .setSmallIcon(R.mipmap.ic_launcher)
////                .setLargeIcon(R.mipmap.ic_launcher)
//                .setContentTitle("Title")
//                .setContentText("Text")
////                .setStyle(new NotificationCompat.BigPictureStyle()
////                        .bigPicture(imgUrl)
////                        .bigLargeIcon(null))
//                .setPriority(NotificationCompat.PRIORITY_HIGH)
////                .setContentIntent(pendingIntent)
//                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
//
//        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            notification.setSmallIcon(R.mipmap.ic_launcher);
//            notification.setColor(getResources().getColor(R.color.colorPrimary));
//        } else {
//            notification.setSmallIcon(R.mipmap.ic_launcher);
//        }
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(getApplicationContext());
//
////        int m = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
//        notificationManager.notify(NOTIFICATION_ID,notification.build());
//    }
//}
