package com.example.kroeber;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.Hashtable;

import android.os.Bundle;
import android.os.ParcelUuid;
import android.os.Parcelable;
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

    private ArrayAdapter<String> btArrayAdapter;
    private Spinner spinner;
    private BluetoothAdapter myBlueToothAdapter;
    private OutputStream mmOutputStream;
    private static Hashtable user_config = new Hashtable();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        //myBlueToothAdapter = BluetoothAdapter.getDefaultAdapter();
		
		myBlueToothAdapter = BluetoothActivity.getBTAdapater();
	    mmOutputStream = BluetoothActivity.getOutputStream();
		
        final Spinner spinner = (Spinner) findViewById(R.id.spin);
        final Button scanb = (Button) findViewById(R.id.button1);
        final Button next = (Button) findViewById(R.id.button2);
        btArrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1);
        
        final Configuration config = new Configuration();
    
        final Context context = this;
        
        Timer timer = new Timer();
        
        BluetoothDevice arduinoDevice = null;
        
        //Turn on Bluetooth
        if (myBlueToothAdapter==null)
            Toast.makeText(MainActivity.this, "Your device does not support Bluetooth", Toast.LENGTH_LONG).show();
        else if (!myBlueToothAdapter.isEnabled()) {
            Intent BtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(BtIntent, 0);
            Toast.makeText(MainActivity.this, "Turning on Bluetooth", Toast.LENGTH_LONG).show();
        }
  /*
        //Continuously scan
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                // TODO do your thing
            	myBlueToothAdapter.startDiscovery();
            	registerReceiver(ContFoundReceiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));
            	
            }
        }, 0, 10000);
        */

        
        //scan
        scanb.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
                btArrayAdapter.clear();
                myBlueToothAdapter.startDiscovery();
                Toast.makeText(MainActivity.this, "Scanning Devices", Toast.LENGTH_LONG).show();
                registerReceiver(FoundReceiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));
                spinner.setAdapter(btArrayAdapter);
            }
        });

        //registerReceiver(FoundReceiver, new IntentFilter(BluetoothDevice.ACTION_FOUND));
	
        //spinner.setAdapter(btArrayAdapter);
        
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        	   public void onItemSelected(AdapterView<?> parent, View v, int pos, long id) {
        	      String selectedItem = parent.getItemAtPosition(pos).toString();
        	      // make insertion into database
        	      config.name = selectedItem;
        	   }

        	   public void onNothingSelected(AdapterView<?> parent) {

        	   }
        	});

        next.setOnClickListener(new OnClickListener()
        {
            public void onClick(View v)
            {
            	Intent startChooser = new Intent(context, ChooserActivity.class);
            	startChooser.putExtra("Config", config);
            	startActivity(startChooser);
            }
        });

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
        //unregisterReceiver(ContFoundReceiver);
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
                }
            }
        }};
        
    private final BroadcastReceiver ContFoundReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            String action = intent.getAction();
            if(BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device2 = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                if ((device2.getName() != null) && (device2.getName().length() > 0)) {
	                if (user_config.containsKey(device2.getName() + "\n" + device2.getAddress())) {
	                	Configuration activeConfig = (Configuration) user_config.get(device2.getName() + "\n" + device2.getAddress());
                		System.out.println(device2.getName() + "\n" + device2.getAddress());
                		System.out.println("Frequency: " + activeConfig.frequency);
                		System.out.println("Height: " + activeConfig.height);
                		System.out.println("Color: " + activeConfig.color);
	                 	char msg = '0';
	                 	//byte [] msgBuffer = msg.getBytes();
	                	try {
	                		mmOutputStream.write('0');
	                		mmOutputStream.write('a');
	                		
	                		//msg += 'n';
	                		/*
	                		mmOutputStream.write(msg);
							msg = activeConfig.color;
							//msgBuffer = msg.getBytes();
							//msg += 'n';
							mmOutputStream.write(msg);
							msg = activeConfig.height;
							//msgBuffer = msg.getBytes();
							//msg += 'n';
							mmOutputStream.write(msg);
							msg = activeConfig.frequency;
							//msgBuffer = msg.getBytes();
							//msg += 'n';
							mmOutputStream.write(msg);
							//msg = 70;
							//mmOutputStream.write(msg);
							 * */
							 
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                }
                }
            }
        }};

    static Hashtable<String, Configuration> getHashtable() {
        return user_config;
    }
        
}
