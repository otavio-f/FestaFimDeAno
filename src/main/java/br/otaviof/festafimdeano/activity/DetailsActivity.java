package br.otaviof.festafimdeano.activity;

import android.os.Bundle;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;

import br.otaviof.festafimdeano.R;

public class DetailsActivity extends AppCompatActivity {
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        this.mViewHolder.willAttend = findViewById(R.id.check_attend);
    }

    private static class ViewHolder {
        CheckBox willAttend;
    }
}