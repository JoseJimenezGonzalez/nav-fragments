package com.example.myapplication

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.navigation.NavDeepLinkBuilder

fun showNotification(context: Context?, title: String, content: String) {
    val notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    // Verificar la versión de Android para la creación de canales
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channel = NotificationChannel("default", "Channel name", NotificationManager.IMPORTANCE_DEFAULT)
        notificationManager.createNotificationChannel(channel)
    }

    // Intent para abrir el fragmento deseado cuando se toca la notificación
    val pendingIntent = NavDeepLinkBuilder(context)
        .setGraph(R.navigation.nav_graph) // Reemplaza con tu gráfico de navegación
        .setDestination(R.id.fourthFragment) // Reemplaza con el fragmento de destino
        .createPendingIntent()

    val builder = NotificationCompat.Builder(context, "default")
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setContentTitle(title)
        .setContentText(content)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)

    notificationManager.notify(1, builder.build())
}