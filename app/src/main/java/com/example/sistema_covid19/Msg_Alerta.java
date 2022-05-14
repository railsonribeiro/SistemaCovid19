package com.example.sistema_covid19;

import android.app.Activity;
import android.app.AlertDialog;

public class Msg_Alerta{
    public static void alert_dialog(String msg,Activity act){
        AlertDialog.Builder alert_padrao= new AlertDialog.Builder(act);
        alert_padrao.setMessage(msg);
        alert_padrao.setNeutralButton("OK", null);
        alert_padrao.show();
    }
}
