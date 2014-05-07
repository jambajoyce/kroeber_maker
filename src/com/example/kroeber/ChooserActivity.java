package com.example.kroeber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.SeekBar;
import java.util.Hashtable;

public class ChooserActivity extends Activity {
	Configuration config;
    SeekBar freqSeek;
    SeekBar heightSeek;
    Hashtable<String, Configuration> user_config = MainActivity.getHashtable();
    String name;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chooser);
		Intent i = getIntent();
		config = (Configuration)i.getSerializableExtra("Config");
        name = config.getName();
        user_config.put(name, config);
		Toast.makeText(ChooserActivity.this, config.name, Toast.LENGTH_LONG).show();
        final Button red1 = (Button) findViewById(R.id.button_red1);
        final Button red2 = (Button) findViewById(R.id.button_red2);
        final Button red3 = (Button) findViewById(R.id.button_red3);
        final Button red4 = (Button) findViewById(R.id.button_red4);
        final Button red5 = (Button) findViewById(R.id.button_red5);
        final Button green1 = (Button) findViewById(R.id.button_green1);
        final Button green2 = (Button) findViewById(R.id.button_green2);
        final Button green3 = (Button) findViewById(R.id.button_green3);
        final Button green4 = (Button) findViewById(R.id.button_green4);
        final Button green5 = (Button) findViewById(R.id.button_green5);
        final Button blue1 = (Button) findViewById(R.id.button_blue1);
        final Button blue2 = (Button) findViewById(R.id.button_blue2);
        final Button blue3 = (Button) findViewById(R.id.button_blue3);
        final Button blue4 = (Button) findViewById(R.id.button_blue4);
        final Button blue5 = (Button) findViewById(R.id.button_blue5);
        final Button white = (Button) findViewById(R.id.button_white);
        final Button flash = (Button) findViewById(R.id.button_flash);
        final Button fade = (Button) findViewById(R.id.button_fade);
        final Button strobe = (Button) findViewById(R.id.button_strobe);
        final Button smooth = (Button) findViewById(R.id.button_smooth);
        freqSeek = (SeekBar) findViewById(R.id.freqSeekBar);
        freqSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                config.frequency = seekBar.getProgress();
            }
        });
        heightSeek = (SeekBar) findViewById(R.id.heightSeekBar);
        heightSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                config.height = seekBar.getProgress();
            }
        });
	}

    protected void red1Click() {
        config.color = 0;
    }

    protected void green1Click() {
        config.color = 1;
    }

    protected void blue1Click() {
        config.color = 2;
    }


    protected void whiteClick() {
        config.color = 3;
    }

    protected void red2Click() {
        config.color = 4;
    }

    protected void green2Click() {
        config.color = 5;
    }

    protected void blue2Click() {
        config.color = 6;
    }

    protected void flashClick() {
        config.color = 7;
    }

    protected void red3Click() {
        config.color = 8;
    }

    protected void green3Click() {
        config.color = 9;
    }

    protected void blue3Click() {
        config.color = 10;
    }

    protected void strobeClick() {
        config.color = 11;
    }

    protected void red4Click() {
        config.color = 12;
    }

    protected void green4Click() {
        config.color = 13;
    }

    protected void blue4Click() {
        config.color = 14;
    }

    protected void fadeClick() {
        config.color = 15;
    }

    protected void red5Click() {
        config.color = 16;
    }

    protected void green5Click() {
        config.color = 17;
    }

    protected void blue5Click() {
        config.color = 18;
    }

    protected void smooth5Click() {
        config.color = 19;
    }


}
