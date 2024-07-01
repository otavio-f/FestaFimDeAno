package br.otaviof.festafimdeano.data;

import android.content.Context;
import android.content.SharedPreferences;

/** Classe que media a persistência de preferências do aplicativo
 * @author otavio-f
 * @version 1
 */
public class Preferences {
    /** Chave para a persistência da presença **/
    private static final String ATTEND_KEY = "presença";
    /** Chave para a persistência da presença confirmada ou não confirmada **/
    private static final String ATTEND_SET_KEY = "presença confirmada";

    private final SharedPreferences mSharedPreferences;

    /**
     * Construtor
     * @param context O contexto do aplicativo
     */
    public Preferences(Context context) {
        this.mSharedPreferences = context.getSharedPreferences("FestaFimDeAno", Context.MODE_PRIVATE);
    }

    /**
     * Altera o a confirmação de presença
     * @param state O estado da confirmação de presença a ser salvo
     */
    public void setAttend(boolean state) {
        SharedPreferences.Editor editor = this.mSharedPreferences.edit();
        editor.putBoolean(ATTEND_KEY, state);
        editor.putBoolean(ATTEND_SET_KEY, true);
        editor.apply();
    }

    /**
     * Recupera a confirmação de presença
     * @return true ou false indicando se o usuário confirma ou não a presença
     */
    public boolean getAttend() {
        return this.mSharedPreferences.getBoolean(ATTEND_KEY, false);
    }

    /**
     * Recupera a se a confirmação de presença foi alterada
     * @return true se a confirmação de presença foi alterada, ou false se a presença ainda não foi confirmada pelo usuário
     */
    public boolean getAttendIsSet() {
        return this.mSharedPreferences.getBoolean(ATTEND_SET_KEY, false);
    }
}
