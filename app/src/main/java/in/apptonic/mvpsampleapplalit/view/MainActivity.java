package in.apptonic.mvpsampleapplalit.view;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import in.apptonic.mvpsampleapplalit.R;
import in.apptonic.mvpsampleapplalit.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    private MainPresenter presenter;
    private TextView myTextView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        myTextView = findViewById(R.id.myTextView);
        EditText username = findViewById(R.id.username);
        EditText email = findViewById(R.id.email);
        initProgressBar();

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.updateName(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                hideProgressBar();

            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.updateEmail(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                hideProgressBar();
            }
        });

    }


    private void initProgressBar() {

        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleSmall);
        progressBar.setIndeterminate(true);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Resources.getSystem().getDisplayMetrics().widthPixels, 250);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addContentView(progressBar, params);
        showProgressbar();

    }


    @Override
    public void updateUserInfoTextView(String info) {
        myTextView.setText(info);

    }

    @Override
    public void showProgressbar() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);

    }
}
