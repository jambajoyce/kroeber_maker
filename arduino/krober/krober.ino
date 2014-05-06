//Author: Felix Li
//Description: All the necessary Arduino code to run operation Krober. 

#include "Constants.h"
#include "IRCommands.h"
// The setup() method runs once, when the sketch starts 
void setup()   {                
  // initialize the IR digital pin as an output:
  pinMode(IRledPin, OUTPUT);      
 
  Serial.begin(9600);
}
 
void loop()                     
{
  Serial.println("Turning On");
  
  /*
  int timeToSwitch = micros();   
  digitalWrite(IRledPin, HIGH);  // this takes about 3 microseconds to happen
  int diff = micros() - timeToSwitch;
  Serial.println(String(diff));
  */
  
  turnOn(); 
  delay(5000);  // wait one minute (60 seconds * 1000 milliseconds)
  turnOff();
  delay(5000);  // wait one minute (60 seconds * 1000 milliseconds)
  
}




