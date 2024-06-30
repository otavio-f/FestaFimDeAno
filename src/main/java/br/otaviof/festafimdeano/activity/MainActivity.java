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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    private static final Calendar CALENDAR = Calendar.getInstance();

    private final ViewHolder mViewHolder = new ViewHolder();
    private Preferences mPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mPreferences = new Preferences(this);

        this.mViewHolder.today = findViewById(R.id.text_today);
        this.mViewHolder.daysLeft = findViewById(R.id.text_days_left);

        this.mViewHolder.confirm = findViewById(R.id.button_confirm);
        int confirmTextId;
        if(!this.mPreferences.getAttendIsSet())
            confirmTextId = R.string.not_confirmed;
        else
            confirmTextId = this.mPreferences.getAttend()? R.string.going: R.string.not_going;
        this.mViewHolder.confirm.setText(getString(confirmTextId));

        this.mViewHolder.confirm.setOnClickListener(this);
        this.mViewHolder.today.setText(DATE_FORMAT.format(CALENDAR.getTime()));
        String daysLeft = String.format(Locale.US, "%d %s", getDaysLeft(), getString(R.string.days));
        this.mViewHolder.daysLeft.setText(daysLeft);
    }

    private int getDaysLeft() {
        int today = CALENDAR.get(Calendar.DAY_OF_YEAR);
        int max = CALENDAR.getActualMaximum(Calendar.DAY_OF_YEAR);
        return max-today;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_confirm) {
            Intent intent = new Intent(this, DetailsActivity.class);
            startActivity(intent);
        }
    }

    private static class ViewHolder {
        TextView today;
        TextView daysLeft;
        Button confirm;
    }
}