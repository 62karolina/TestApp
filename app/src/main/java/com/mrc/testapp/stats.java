package com.mrc.testapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * Created by Каролина on 19.06.2016.
 */
public class stats extends DialogFragment {

    int i;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Статистика")
                .setMessage("Покормите кота!")
                .setPositiveButton("ОК, иду на кухню", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Закрываем окно
                        dialog.cancel();
                    }
                });
        return builder.create();
    }

}
