package com.example.kroeber;

import android.app.Activity;
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
        name = config.getName();
        user_config.put(name, config);
		Toast.makeText(ChooserActivity.this, config.name, Toast.LENGTH_LONG).show();
        final Button red1 = (Button) findViewById(R.id.button_red1);
        red1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 0;
            }
        });

        final Button red2 = (Button) findViewById(R.id.button_red2);
        red2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 1;
            }
        });

        final Button red3 = (Button) findViewById(R.id.button_red3);
        red3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 2;
            }
        });

        final Button red4 = (Button) findViewById(R.id.button_red4);
        red4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 3;
            }
        });

        final Button red5 = (Button) findViewById(R.id.button_red5);
        red5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 4;
            }
        });

        final Button green1 = (Button) findViewById(R.id.button_green1);
        green1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 5;
            }
        });

        final Button green2 = (Button) findViewById(R.id.button_green2);
        green2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 6;
            }
        });

        final Button green3 = (Button) findViewById(R.id.button_green3);
        green3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 7;
            }
        });

        final Button green4 = (Button) findViewById(R.id.button_green4);
        green4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 8;
            }
        });


        final Button green5 = (Button) findViewById(R.id.button_green5);
        green5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 9;
            }
        });


        final Button blue1 = (Button) findViewById(R.id.button_blue1);
        blue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 10;
            }
        });

        final Button blue2 = (Button) findViewById(R.id.button_blue2);
        blue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 11;
            }
        });

        final Button blue3 = (Button) findViewById(R.id.button_blue3);
        blue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 12;
            }
        });

        final Button blue4 = (Button) findViewById(R.id.button_blue4);
        blue4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 13;
            }
        });

        final Button blue5 = (Button) findViewById(R.id.button_blue5);
        blue5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 14;
            }
        });

        final Button white = (Button) findViewById(R.id.button_white);
        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 15;
            }
        });

        final Button flash = (Button) findViewById(R.id.button_flash);
        flash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 16;
            }
        });


        final Button fade = (Button) findViewById(R.id.button_fade);
        fade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 17;
            }
        });

        final Button strobe = (Button) findViewById(R.id.button_strobe);
        strobe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 18;
            }
        });

        final Button smooth = (Button) findViewById(R.id.button_smooth);
        smooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                config.color = 19;
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
    protected void submitConfigs(View v) {
        Intent startMain = new Intent(this, MainActivity.class);
        startActivity(startMain);
    }

}
