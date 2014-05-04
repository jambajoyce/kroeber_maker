package com.example.kroeber;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity {

    private  ArrayAdapter<String> btArrayAdapter;
    private Spinner spinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final BluetoothAdapter myBlueToothAdapter = BluetoothAdapter.getDefaultAdapter();
        final ListView Deviceslist = (ListView) findViewById(R.id.listView1);
        final Spinner spinner = (Spinner) findViewById(R.id.spin);
        final Button scanb = (Button) findViewById(R.id.button1);
        btArrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1);
        Deviceslist.setAdapter(btArrayAdapter);

        //Turn on Bluetooth
        if (myBlueToothAdapter==null)
            Toast.makeText(MainActivity.this, "Your device doesnot support Bluetooth", Toast.LENGTH_LONG).show();
        else if (!myBlueToothAdapter.isEnabled()) {
            Intent BtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(BtIntent, 0);
            Toast.makeText(MainActivity.this, "Turning on Bluetooth", Toast.LENGTH_LONG).show();
        }
        //scan
        scanb.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                btArrayAdapter.clear();
                myBlueToothAdapter.startDiscovery();
                Toast.makeText(MainActivity.this, "Scanning Devices", Toast.LENGTH_LONG).show();

            }
        });

        registerReceiver(FoundReceiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;

    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        unregisterReceiver(FoundReceiver);
    }

    private final BroadcastReceiver FoundReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            String action = intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                btArrayAdapter.add(device.getName() + "\n" + device.getAddress());
                btArrayAdapter.notifyDataSetChanged();

            }
            spinner.setAdapter(btArrayAdapter);
        }};





}
