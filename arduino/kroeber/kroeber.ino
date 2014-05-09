//Author: Felix Li
//Description: All the necessary Arduino code to run operation Krober. 

#include "Constants.h"
#include "IRCommands.h"
#include <SoftwareSerial.h>

//initialize Bluetooth
SoftwareSerial Bluetooth(RX, TX);

//State Machine for Bluetooth protocol
int state = LISTENING;
//Pointer to current configuration 
CurrentConfig configuration;
//for burst/frequency calculation 
long lastBurst = 0;
long burstRate = 0;
long burstDelay = 0;

long currentTime = 0;

//fp = function pointer
void repeatCommand(void (*fp)(void), int numTimes) {
  for (int i = 0; i< numTimes; i++) {
    (*fp)();
  }  
}

//Initialize the configuration 
void initializeConfig() {
  configuration.color = DEFAULT_COLOR;
  configuration.height = DEFAULT_HEIGHT;
  configuration.burst = DEFAULT_BURST;  
}


void printConfiguration() {
  Serial.println("Color: \t" + String(configuration.color));  
  Serial.println("Height: \t" + String(configuration.height));  
  Serial.println("Frequency: \t" + String(configuration.burst));  
}

void updateLight(int color) {
  switch (color) {
    
    case RED: {
      repeatCommand(&red, REPEAT);
      break; 
    } 
    
    case GREEN: {
      repeatCommand(&green, REPEAT);
      break;     
    }
    
    
    case BLUE: {
      repeatCommand(&blue, REPEAT);
      break;          
    }
    
    case WHITE: {
      repeatCommand(&white, REPEAT);
      break;          
    }    
    
     
    case RED2: {
      repeatCommand(&red2, REPEAT);
      break; 
    } 
    
    case GREEN2: {
      repeatCommand(&green2, REPEAT);
      break;     
    }
    
    
    case BLUE2: {
      repeatCommand(&blue2, REPEAT);
      break;          
    }
    
    case FLASH: {
      repeatCommand(&flash, REPEAT);
      break;          
    }    
    
     
    case RED3: {
      repeatCommand(&red3, REPEAT);
      break; 
    } 
    
    case GREEN3: {
      repeatCommand(&green3, REPEAT);
      break;     
    }
    
    
    case BLUE3: {
      repeatCommand(&blue3, REPEAT);
      break;          
    }
    
    case STROBE: {
      repeatCommand(&strobe, REPEAT);
      break;          
    }    
    
     
    case RED4: {
      repeatCommand(&red4, REPEAT);
      break; 
    } 
    
    case GREEN4: {
      repeatCommand(&green4, REPEAT);
      break;     
    }
    
    
    case BLUE4: {
      repeatCommand(&blue4, REPEAT);
      break;          
    }
    
    case FADE: {
      repeatCommand(&fade, REPEAT);
      break;          
    }    
    
     
    case RED5: {
      repeatCommand(&red5, REPEAT);
      break; 
    } 
    
    case GREEN5: {
      repeatCommand(&green5, REPEAT);
      break;     
    }
    
    
    case BLUE5: {
      repeatCommand(&blue5, REPEAT);
      break;          
    }
    
    case SMOOTH: {
      repeatCommand(&smooth, REPEAT);
      break;          
    }    
    
  } //end switch color
}

void updateHeight(int height) {
  analogWrite(HeightPWM, height);
}

void updateBurst(int burst) {
 if (burst == 0) {
   burstRate = 0;  
 } else {
   burstRate = MAX_BURSTS/burst + 1000;
 }
}

void run() {
  long diff = millis() - lastBurst;  
  if (lastBurst + burstRate > millis()) {
    analogWrite(HeightPWM, configuration.height);
    lastBurst = millis();      
    delay(100);
  } else {
    analogWrite(HeightPWM, 0);  
  }
}

void change() {
  int height = random(100, 255);
  configuration.height = height;
  int color = random(0, 20);
  configuration.color = color;
  int burst = random(0, 5);
  configuration.burst = 0;
  updateHardware();
 }
 
//update the hardware according to the current configuration 
void updateHardware() {
  updateLight(configuration.color);
  updateHeight(configuration.height);
  updateBurst(configuration.burst);  
}

// The setup() method runs once, when the sketch starts 
void setup()   {                
  // initialize the IR digital pin as an output:
  Bluetooth.begin(115200);
  pinMode(IRledPin, OUTPUT);      
  Serial.begin(9600);
  initializeConfig();
   updateHardware();
}
 
void loop()                     
{
  //repeatCommand(&red, REPEAT);
  //Serial.println("main");
  //listen to bluetooth
    /*
    //Serial.println("Received!");
    int integerValue = 0;
    while(1) {
      char incomingByte = (char) Bluetooth.read();
      if (incomingByte == 'n') break;   // exit the while(1), we're done receiving
      if (incomingByte == -1) continue;  // if no characters are in the buffer read() returns -1
      Serial.println(incomingByte - 48);    
      integerValue *= 10;  // shift left 1 decimal place
      // convert ASCII to integer, add, and shift left 1 decimal place
      integerValue = ((incomingByte - 48) + integerValue);
    }
    Serial.println(integerValue);   // Do something with the value
  
  */
 
  if (millis() > currentTime + 5000) {
    change();
    currentTime = millis();
    printConfiguration();
  }
  
    
  if (Bluetooth.available() > 0) {
    
    change();
  }
    /*
    //Serial.println("State" + String(state));
    switch(state) {
      case LISTENING: {
          if (intRead == START_COMMAND) {
            state = COLOR;
          }
        break;  
      } 
      
      case COLOR: {
        configuration.color = intRead;
        state =  HEIGHT;
        break;
      }
      
      case HEIGHT: {
        int adjusted = map(intRead, 0, 255, 100, 255);
        configuration.height = adjusted;
        state = BURST;
        break;
      }
      
      case BURST: {
        configuration.burst = intRead;
        //Bluetooth.print(ACK); //send acknowledgement 
        state = LISTENING;
        updateHardware(); // updates the Hardware
        printConfiguration();
        break;
      }
    } //end switch
    */
    
  
 // printConfiguration();

  
  //updateBurst();
  
  
  
  /*
  for (int i = 0; i < 256; i+=10) {
    analogWrite(HeightPWM, i);  
    Serial.println(i);
    delay(1000);
  }
  */
  //run();
  
  /*
  Serial.println("Turning On");
  repeatCommand(&red, REPEAT);

  repeatCommand(&green, REPEAT);
  repeatCommand(&blue, REPEAT);
  repeatCommand(&red2, REPEAT);
  repeatCommand(&green2, REPEAT);
  repeatCommand(&blue2, REPEAT);
  repeatCommand(&red3, REPEAT);  
  repeatCommand(&green3, REPEAT);
  repeatCommand(&blue3, REPEAT);
  repeatCommand(&red4, REPEAT);
  repeatCommand(&green4, REPEAT);
  repeatCommand(&blue4, REPEAT); 
  repeatCommand(&red5, REPEAT);
  repeatCommand(&green5, REPEAT);
  repeatCommand(&blue5, REPEAT);   
  */
}




