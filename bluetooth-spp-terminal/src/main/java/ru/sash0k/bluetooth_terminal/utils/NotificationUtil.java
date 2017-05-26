package ru.sash0k.bluetooth_terminal.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;

import ru.sash0k.bluetooth_terminal.R;
import ru.sash0k.bluetooth_terminal.activity.DeviceControlActivity;

public class NotificationUtil {
    public static final int NOTIFICATION_ID = 10;

    public static void createNotification(Context context) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_alarm)
                        .setContentTitle("Необходим полив!")
                        .setContentText("Уровень влажности почвы меньше 10%!");
        Intent resultIntent = new Intent(context, DeviceControlActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(DeviceControlActivity.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
    }
}
