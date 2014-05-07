package com.example.kroeber;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;

public class BluetoothActivity extends Activity {

	public static OutputStream mmOutputStream;;
    public InputStream mmInputStream;
    public static BluetoothAdapter myBlueToothAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Connect to Arduino
		BluetoothDevice arduinoDevice = null;
		myBlueToothAdapter = BluetoothAdapter.getDefaultAdapter();
		
        Set<BluetoothDevice> pairedDevices = myBlueToothAdapter.getBondedDevices();
        if(pairedDevices.size() > 0)
        {
            for(BluetoothDevice device : pairedDevices)
            {
                if(device.getName().equals("SMiRF-5EDB"))
                {
                    arduinoDevice = device;
                    break;
                }
            }
        }
        
        UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb"); //Standard SerialPortService ID
        BluetoothSocket mmSocket;
		try {
			mmSocket = arduinoDevice.createRfcommSocketToServiceRecord(uuid);
	        mmSocket.connect();
	        mmOutputStream = mmSocket.getOutputStream();
	        mmInputStream = mmSocket.getInputStream();
		}
        catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Intent startMain = new Intent(this, MainActivity.class);
        startActivity(startMain);
        
	}
	
	
	public static OutputStream getOutputStream() {
		return mmOutputStream;
	}


	public static BluetoothAdapter getBTAdapater() {
		// TODO Auto-generated method stub
		return myBlueToothAdapter;
	}
	
}
