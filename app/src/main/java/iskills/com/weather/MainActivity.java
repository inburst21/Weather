package iskills.com.weather;

import android.os.Bundle;

import butterknife.ButterKnife;
import dagger.android.DaggerActivity;

public class MainActivity extends DaggerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
}
