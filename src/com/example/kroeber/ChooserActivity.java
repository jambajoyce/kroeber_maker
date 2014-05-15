package com.example.kroeber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.SeekBar;
import java.util.Hashtable;
import android.view.View;

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
        //name = config.getName();
        config.setName("Felix");
        name = config.getName();
		Toast.makeText(ChooserActivity.this, config.name, Toast.LENGTH_LONG).show();
        final Button red1 = (Button) findViewById(R.id.button_red1);
        red1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = '0';
                Toast.makeText(ChooserActivity.this, "Red selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button red2 = (Button) findViewById(R.id.button_red2);
        red2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = '1';
                Toast.makeText(ChooserActivity.this, "Bright Orange selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button red3 = (Button) findViewById(R.id.button_red3);
        red3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = '2';
                Toast.makeText(ChooserActivity.this, "Orange selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button red4 = (Button) findViewById(R.id.button_red4);
        red4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = '3';
                Toast.makeText(ChooserActivity.this, "Peach selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button red5 = (Button) findViewById(R.id.button_red5);
        red5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = '4';
                Toast.makeText(ChooserActivity.this, "Yellow selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button green1 = (Button) findViewById(R.id.button_green1);
        green1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = '5';
                Toast.makeText(ChooserActivity.this, "Green selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button green2 = (Button) findViewById(R.id.button_green2);
        green2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = '6';
                Toast.makeText(ChooserActivity.this, "Seafoam Green selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button green3 = (Button) findViewById(R.id.button_green3);
        green3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = '7';
                Toast.makeText(ChooserActivity.this, "Turquoise selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button green4 = (Button) findViewById(R.id.button_green4);
        green4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = '8';
                Toast.makeText(ChooserActivity.this, "Teal selected", Toast.LENGTH_LONG).show();
            }
        });


        final Button green5 = (Button) findViewById(R.id.button_green5);
        green5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = '9';
                Toast.makeText(ChooserActivity.this, "Royal Blue selected", Toast.LENGTH_LONG).show();
            }
        });


        final Button blue1 = (Button) findViewById(R.id.button_blue1);
        blue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 'a';
                Toast.makeText(ChooserActivity.this, "Blue selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button blue2 = (Button) findViewById(R.id.button_blue2);
        blue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 'b';
                Toast.makeText(ChooserActivity.this, "Dodger Blue selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button blue3 = (Button) findViewById(R.id.button_blue3);
        blue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 'c';
                Toast.makeText(ChooserActivity.this, "Indigo selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button blue4 = (Button) findViewById(R.id.button_blue4);
        blue4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 'd';
                Toast.makeText(ChooserActivity.this, "Purple selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button blue5 = (Button) findViewById(R.id.button_blue5);
        blue5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 'e';
                Toast.makeText(ChooserActivity.this, "Light Purple selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button white = (Button) findViewById(R.id.button_white);
        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 'f';
                Toast.makeText(ChooserActivity.this, "White selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button flash = (Button) findViewById(R.id.button_flash);
        flash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 'g';
                Toast.makeText(ChooserActivity.this, "Flash selected", Toast.LENGTH_LONG).show();
            }
        });


        final Button fade = (Button) findViewById(R.id.button_fade);
        fade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 'h';
                Toast.makeText(ChooserActivity.this, "Fade selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button strobe = (Button) findViewById(R.id.button_strobe);
        strobe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 'i';
                Toast.makeText(ChooserActivity.this, "Strobe selected", Toast.LENGTH_LONG).show();
            }
        });

        final Button smooth = (Button) findViewById(R.id.button_smooth);
        smooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 'j';
                Toast.makeText(ChooserActivity.this, "Smooth selected", Toast.LENGTH_LONG).show();
            }
        });

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
                config.frequency = (char) seekBar.getProgress();
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
                config.height = (char) seekBar.getProgress();
            }
        });
        final Context context = this;
        final Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_config.put(name, config);
                Intent startMain = new Intent(context, MainActivity.class);
                startActivity(startMain);
            }

        });

	}
/**
    protected void red1Click(View v) {
        config.color = 0;
    }

    protected void green1Click(View v) {
        config.color = 1;
    }

    protected void blue1Click(View v) {
        config.color = 2;
    }


    protected void whiteClick(View v) {
        config.color = 3;
    }

    protected void red2Click(View v) {
        config.color = 4;
    }

    protected void green2Click(View v) {
        config.color = 5;
    }

    protected void blue2Click(View v) {
        config.color = 6;
    }

    protected void flashClick(View v) {
        config.color = 7;
    }

    protected void red3Click(View v) {
        config.color = 8;
    }

    protected void green3Click(View v) {
        config.color = 9;
    }

    protected void blue3Click(View v) {
        config.color = 10;
    }

    protected void strobeClick(View v) {
        config.color = 11;
    }

    protected void red4Click(View v) {
        config.color = 12;
    }

    protected void green4Click(View v) {
        config.color = 13;
    }

    protected void blue4Click(View v) {
        config.color = 14;
    }

    protected void fadeClick(View v) {
        config.color = 15;
    }

    protected void red5Click(View v) {
        config.color = 16;
    }

    protected void green5Click(View v) {
        config.color = 17;
    }

    protected void blue5Click(View v) {
        config.color = 18;
    }

    protected void smoothClick(View v) {
        config.color = 19;
    }
*/


}
