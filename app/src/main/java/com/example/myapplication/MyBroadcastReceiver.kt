package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // Aquí puedes manejar la notificación, por ejemplo, mostrar una notificación
        // usando NotificationManager
        showNotification(context, "¡Nueva notificación!", "Contenido de la notificación.")
    }
}
