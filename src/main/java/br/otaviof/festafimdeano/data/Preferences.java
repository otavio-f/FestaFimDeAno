package br.otaviof.festafimdeano.data;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    private static final String ATTEND_KEY = "presença";
    private static final String ATTEND_SET_KEY = "presença confirmada";

    private final SharedPreferences mSharedPreferences;
    public Preferences(Context context) {
        this.mSharedPreferences = context.getSharedPreferences("FestaFimDeAno", Context.MODE_PRIVATE);
    }

    public void setAttend(boolean state) {
        SharedPreferences.Editor editor = this.mSharedPreferences.edit();
        editor.putBoolean(ATTEND_KEY, state);
        editor.putBoolean(ATTEND_SET_KEY, true);
        editor.apply();
    }

    public boolean getAttend() {
        return this.mSharedPreferences.getBoolean(ATTEND_KEY, false);
    }
    public boolean getAttendIsSet() {
        return this.mSharedPreferences.getBoolean(ATTEND_SET_KEY, false);
    }
}
