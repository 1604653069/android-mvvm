package com.hong.library.mvvm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FylToast {
    private static Toast mToast;
    private static FylToast fylToast;
    private static View v;
    private static TextView textView;

    private FylToast(Context context, CharSequence text, int duration) {
        v = LayoutInflater.from(context).inflate(R.layout.fyl_toast, null);
        textView = v.findViewById(R.id.textToast);
        textView.setText(text);
        mToast = new Toast(context);
        mToast.setDuration(duration);
        mToast.setView(v);
    }

    public static FylToast makeText(Context context, CharSequence text, int duration) {
        if (fylToast == null)
            fylToast = new FylToast(context, text, duration);
        else
            return fylToast;
        return fylToast;
    }

    public void show() {
        if (mToast != null) {
            mToast.show();
        }
    }

    public void setGravity(int gravity, int xOffset, int yOffset) {
        if (mToast != null) {
            mToast.setGravity(gravity, xOffset, yOffset);
        }
    }

    public void setMessage(String message) {
        textView.setText(message);
        mToast.setView(v);
    }
}