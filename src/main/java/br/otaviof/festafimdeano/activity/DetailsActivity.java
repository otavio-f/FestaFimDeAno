package br.otaviof.festafimdeano.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;

import br.otaviof.festafimdeano.R;
import br.otaviof.festafimdeano.data.Preferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {
    private final ViewHolder mViewHolder = new ViewHolder();
    private Preferences mPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        this.mPreferences = new Preferences(this);
        this.mViewHolder.willAttend = findViewById(R.id.check_attend);
        this.mViewHolder.willAttend.setOnClickListener(this);
        this.mViewHolder.willAttend.setChecked(this.mPreferences.getAttend());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.check_attend) {
            boolean state = this.mViewHolder.willAttend.isChecked();
            this.mPreferences.setAttend(state);
        }
    }

    private static class ViewHolder {
        CheckBox willAttend;
    }
}