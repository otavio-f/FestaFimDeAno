package br.otaviof.festafimdeano.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;

import br.otaviof.festafimdeano.R;
import br.otaviof.festafimdeano.data.Preferences;

/** Classe responsável pela interface de comfirmação
 * @author otavio-f
 * @version 1
 */
public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private final ViewHolder mViewHolder = new ViewHolder();
    private Preferences mPreferences;

    /**
     * Executa a criação dessa Intent e sua interface
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        this.mPreferences = new Preferences(this);
        this.mViewHolder.willAttend = findViewById(R.id.check_attend);
        this.mViewHolder.willAttend.setOnClickListener(this);
        this.mViewHolder.willAttend.setChecked(this.mPreferences.getAttend());
    }

    /**
     * Processa eventos de clique
     * @param v O elemento clicado
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.check_attend) {
            boolean state = this.mViewHolder.willAttend.isChecked();
            this.mPreferences.setAttend(state);
        }
    }

    /**
     * Classe que contém os elementos da interface
     */
    private static class ViewHolder {
        /** Marcador que indica se o usuário irá comparecer **/
        CheckBox willAttend;
    }
}