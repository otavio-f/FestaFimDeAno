package br.otaviof.festafimdeano.data;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {
    private SharedPreferences mSharedPreferences;
    public Preferences(Context context) {
        this.mSharedPreferences = context.getSharedPreferences("FestaFimDeAno", Context.MODE_PRIVATE);
    }
}
