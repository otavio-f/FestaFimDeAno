package br.otaviof.festafimdeano.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import br.otaviof.festafimdeano.R;
import br.otaviof.festafimdeano.data.Preferences;

/** Classe da interface principal do aplicativo
 * @author otavio-f
 * @version 1
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /** Formato da data no padrão brasileiro **/
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    /** Calendário atual **/
    private static final Calendar CALENDAR = Calendar.getInstance();

    private final ViewHolder mViewHolder = new ViewHolder();
    private Preferences mPreferences;

    /**
     * Executa a criação da aplicação e sua interface gráfica
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mPreferences = new Preferences(this);

        this.mViewHolder.today = findViewById(R.id.text_today);
        this.mViewHolder.daysLeft = findViewById(R.id.text_days_left);

        this.mViewHolder.confirm = findViewById(R.id.button_confirm);

        this.mViewHolder.confirm.setOnClickListener(this);
        this.mViewHolder.today.setText(DATE_FORMAT.format(CALENDAR.getTime()));
        String daysLeft = String.format(Locale.US, "%d %s", getDaysLeft(), getString(R.string.days));
        this.mViewHolder.daysLeft.setText(daysLeft);
    }

    /**
     * Executa o resumo da aplicação a ser colocada em primeiro plano novamente
     */
    @Override
    protected void onResume() {
        super.onResume();

        int confirmTextId;
        if(!this.mPreferences.getAttendIsSet())
            confirmTextId = R.string.not_confirmed;
        else
            confirmTextId = this.mPreferences.getAttend() ? R.string.going : R.string.not_going;
        this.mViewHolder.confirm.setText(getString(confirmTextId));
    }

    /**
     * Calcula a quantidade de dias restantes até o final do ano
     * @return A quantidade de dias até 31 de dezembro do ano atual
     */
    private int getDaysLeft() {
        int today = CALENDAR.get(Calendar.DAY_OF_YEAR);
        int max = CALENDAR.getActualMaximum(Calendar.DAY_OF_YEAR);
        return max-today;
    }

    /**
     * Processa o evento de clique
     * @param v O elemento que foi clicado na interface
     */
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_confirm) {
            Intent intent = new Intent(this, DetailsActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Classe que contém os elementos da interface dessa aplicação
     */
    private static class ViewHolder {
        /** O dia, mês e ano de hoje **/
        TextView today;
        /** A quantidade de dias restantes para o final do ano **/
        TextView daysLeft;
        /** Botão que leva para a tela de confirmação de presença **/
        Button confirm;
    }
}