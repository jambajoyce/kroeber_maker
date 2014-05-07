package com.example.kroeber;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class ChooserActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chooser);
		Intent i = getIntent();
		Configuration config = (Configuration)i.getSerializableExtra("Config");
		Toast.makeText(ChooserActivity.this, config.name, Toast.LENGTH_LONG).show();
		
	}

}
