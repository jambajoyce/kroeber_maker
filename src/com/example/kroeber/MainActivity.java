package com.example.kroeber;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.UUID;

import android.os.Bundle;
import android.os.ParcelUuid;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
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
    private BluetoothAdapter myBlueToothAdapter;
    //private static final UUID MY_UUID = UUID.fromString("0000110E-0000-1000-8000-00805F9B34FB");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBlueToothAdapter = BluetoothAdapter.getDefaultAdapter();
        //final ListView Deviceslist = (ListView) findViewById(R.id.listView1);
        final Spinner spinner = (Spinner) findViewById(R.id.spin);
        final Button scanb = (Button) findViewById(R.id.button1);
        btArrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1);
        //Deviceslist.setAdapter(btArrayAdapter);

        //Turn on Bluetooth
        if (myBlueToothAdapter==null)
            Toast.makeText(MainActivity.this, "Your device does not support Bluetooth", Toast.LENGTH_LONG).show();
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
	
        spinner.setAdapter(btArrayAdapter);

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
                if ((device.getName() != null) && (device.getName().length() > 0)) {
	                btArrayAdapter.add(device.getName() + "\n" + device.getAddress());
	                btArrayAdapter.notifyDataSetChanged();
	                //Change below to submitted selection
                }
            }
            //spinner.setAdapter(btArrayAdapter);
        }};
        
   /* private void pairDevice(BluetoothDevice device) {
        try {
            Log.d("pairDevice()", "Start Pairing...");
            Method m = device.getClass().getMethod("createBond", (Class[]) null);
            m.invoke(device, (Object[]) null);
            Log.d("pairDevice()", "Pairing finished.");
        } catch (Exception e) {
            Log.e("pairDevice()", e.getMessage());
        }
        Set<BluetoothDevice> pairedDevices = myBlueToothAdapter.getBondedDevices();
        for(BluetoothDevice bt : pairedDevices) {
        	Log.d("Connecting",device.getName());
            BluetoothSocket mSocket=null;
            try {
                mSocket = device.createInsecureRfcommSocketToServiceRecord(MY_UUID);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                Log.d("Connecting","socket not created");
                e1.printStackTrace();
            }
            try{
                mSocket.connect();
            }
            catch(IOException e){
                try {
                    mSocket.close();
                    Log.d("Connecting","Cannot connect");
                } catch (IOException e1) {
                    Log.d("Connecting","Socket not closed");
                    e1.printStackTrace();
                }
            }
        } 
    } */
}
