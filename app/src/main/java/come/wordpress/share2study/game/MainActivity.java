package come.wordpress.share2study.game;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView txtScore;
    private ImageButton imgButtonPlay;
    private CheckBox cb1, cb2, cb3;
    private SeekBar sb1, sb2, sb3;
    private int score = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        txtScore.setText(score + "");
        chooseCheckBox();
        final CountDownTimer countDownTimer = new CountDownTimer(60000, 300) {
            Random random = new Random();

            @Override
            public void onTick(long l) {
                int value1 = random.nextInt(5);
                sb1.setProgress(sb1.getProgress() + value1);
                int value2 = random.nextInt(5);
                sb2.setProgress(sb2.getProgress() + value2);

                int value3 = random.nextInt(5);
                sb3.setProgress(sb3.getProgress() + value3);

                if (sb1.getProgress() >= 100) {
                    this.cancel();
                    if (cb1.isChecked()) {
                        score += 10;
                    } else {
                        score -= 5;
                    }

                    txtScore.setText(score + "");
                    enableCheckBox();
                }
                if (sb2.getProgress() >= 100) {
                    this.cancel();
                    if (cb2.isChecked()) {
                        score += 10;
                    } else {
                        score -= 5;
                    }

                    txtScore.setText(score + "");
                    enableCheckBox();
                }
                if (sb3.getProgress() >= 100) {
                    this.cancel();
                    if (cb3.isChecked()) {
                        score += 10;
                    } else {
                        score -= 5;
                    }

                    txtScore.setText(score + "");
                    enableCheckBox();
                }
            }

            @Override
            public void onFinish() {

            }
        };
        imgButtonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb1.isChecked() || cb2.isChecked() || cb3.isChecked()) {
                    sb1.setProgress(0);
                    sb2.setProgress(0);
                    sb3.setProgress(0);

                    countDownTimer.start();
                    disableCheckBox();
                    disableSeekBar();
                } else {
                    Toast.makeText(MainActivity.this, "chon truoc khi choi", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void anhXa() {
        txtScore = (TextView) findViewById(R.id.txtScore);
        imgButtonPlay = (ImageButton) findViewById(R.id.imgButtonPlay);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        sb1 = (SeekBar) findViewById(R.id.sb1);
        sb2 = (SeekBar) findViewById(R.id.sb2);
        sb3 = (SeekBar) findViewById(R.id.sb3);
    }

    public void chooseCheckBox() {
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cb2.setEnabled(false);
                    cb3.setEnabled(false);
                } else {
                    cb2.setEnabled(true);
                    cb3.setEnabled(true);
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cb1.setEnabled(false);
                    cb3.setEnabled(false);
                } else {
                    cb1.setEnabled(true);
                    cb3.setEnabled(true);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    cb2.setEnabled(false);
                    cb1.setEnabled(false);
                } else {
                    cb2.setEnabled(true);
                    cb1.setEnabled(true);
                }
            }
        });
    }

    public void enableCheckBox() {
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }

    public void disableCheckBox() {
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }

    public void disableSeekBar() {
        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);
    }
    public void enableSeekBar() {
        sb1.setEnabled(true);
        sb2.setEnabled(true);
        sb3.setEnabled(true);
    }
}
