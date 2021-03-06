// This sketch will send out a Nikon D50 trigger signal (probably works with most Nikons)
// See the full tutorial at http://www.ladyada.net/learn/sensors/ir.html
// this code is public domain, please enjoy!
 
int IRledPin =  13;    // LED connected to digital pin 13
 
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
 
// This procedure sends a 38KHz pulse to the IRledPin 
// for a certain # of microseconds. We'll use this whenever we need to send codes
void pulseIR(long microsecs) {
  // we'll count down from the number of microseconds we are told to wait
 
  cli();  // this turns off any background interrupts
 
  while (microsecs > 0) {
    // 38 kHz is about 13 microseconds high and 13 microseconds low
   digitalWrite(IRledPin, HIGH);  // this takes about 3 microseconds to happen
   delayMicroseconds(8);         // hang out for 10 microseconds, you can also change this to 9 if its not working
   digitalWrite(IRledPin, LOW);   // this also takes about 3 microseconds
   delayMicroseconds(8);         // hang out for 10 microseconds, you can also change this to 9 if its not working
 
   // so 26 microseconds altogether
   microsecs -= 26;
  }
 
  sei();  // this turns them back on
}

void turnOff() {
  pulseIR(9300);
  delayMicroseconds(4200);
  pulseIR(780);
  delayMicroseconds(340);
  pulseIR(760);
  delayMicroseconds(360);
  pulseIR(740);
  delayMicroseconds(420);
  pulseIR(660);
  delayMicroseconds(460);
  pulseIR(640);
  delayMicroseconds(460);
  pulseIR(660);
  delayMicroseconds(460);
  pulseIR(660);
  delayMicroseconds(480);
  pulseIR(620);
  delayMicroseconds(460);
  pulseIR(640);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(1640);
  pulseIR(600);
  delayMicroseconds(1620);
  pulseIR(600);
  delayMicroseconds(1660);
  pulseIR(560);
  delayMicroseconds(1660);
  pulseIR(560);
  delayMicroseconds(1680);
  pulseIR(540);
  delayMicroseconds(1700);
  pulseIR(520);
  delayMicroseconds(1700);
  pulseIR(560);
  delayMicroseconds(580);
  pulseIR(520);
  delayMicroseconds(1700);
  pulseIR(540);
  delayMicroseconds(1680);
  pulseIR(560);
  delayMicroseconds(580);
  pulseIR(540);
  delayMicroseconds(580);
  pulseIR(520);
  delayMicroseconds(560);
  pulseIR(560);
  delayMicroseconds(580);
  pulseIR(560);
  delayMicroseconds(560);
  pulseIR(520);
  delayMicroseconds(1700);
  pulseIR(560);
  delayMicroseconds(560);
  pulseIR(540);
  delayMicroseconds(560);
  pulseIR(560);
  delayMicroseconds(1700);
  pulseIR(520);
  delayMicroseconds(1700);
  pulseIR(560);
  delayMicroseconds(1660);
  pulseIR(560);
  delayMicroseconds(1680);
  pulseIR(540);
  delayMicroseconds(1700);
  pulseIR(560);
  delay(39);
  pulseIR(8960);
  delayMicroseconds(2240);
  pulseIR(560);
  delay(30);
  pulseIR(9000);
  delayMicroseconds(2200);
  pulseIR(600);

}


void turnOn() {
  pulseIR(9160);
  delayMicroseconds(4200);
  pulseIR(800);
  delayMicroseconds(320);
  pulseIR(780);
  delayMicroseconds(340);
  pulseIR(740);
  delayMicroseconds(340);
  pulseIR(780);
  delayMicroseconds(360);
  pulseIR(700);
  delayMicroseconds(440);
  pulseIR(640);
  delayMicroseconds(460);
  pulseIR(660);
  delayMicroseconds(460);
  pulseIR(660);
  delayMicroseconds(460);
  pulseIR(620);
  delayMicroseconds(1600);
  pulseIR(620);
  delayMicroseconds(1600);
  pulseIR(620);
  delayMicroseconds(1620);
  pulseIR(600);
  delayMicroseconds(1600);
  pulseIR(620);
  delayMicroseconds(1620);
  pulseIR(580);
  delayMicroseconds(1660);
  pulseIR(540);
  delayMicroseconds(1680);
  pulseIR(560);
  delayMicroseconds(1660);
  pulseIR(560);
  delayMicroseconds(1680);
  pulseIR(540);
  delayMicroseconds(1680);
  pulseIR(540);
  delayMicroseconds(1680);
  pulseIR(540);
  delayMicroseconds(580);
  pulseIR(540);
  delayMicroseconds(580);
  pulseIR(520);
  delayMicroseconds(560);
  pulseIR(560);
  delayMicroseconds(560);
  pulseIR(540);
  delayMicroseconds(580);
  pulseIR(540);
  delayMicroseconds(540);
  pulseIR(560);
  delayMicroseconds(560);
  pulseIR(540);
  delayMicroseconds(580);
  pulseIR(540);
  delayMicroseconds(1680);
  pulseIR(540);
  delayMicroseconds(1680);
  pulseIR(560);
  delayMicroseconds(1680);
  pulseIR(540);
  delayMicroseconds(1680);
  pulseIR(560);
  delayMicroseconds(1660);
  pulseIR(560);
  delay(40);
  pulseIR(8960);
  delayMicroseconds(2220);
  pulseIR(560);
  delay(30);
  pulseIR(8960);
  delayMicroseconds(2240);
  pulseIR(560); 
} 

void red() {
  pulseIR(9200);
  delayMicroseconds(4160);
  pulseIR(800);
  delayMicroseconds(320);
  pulseIR(760);
  delayMicroseconds(380);
  pulseIR(680);
  delayMicroseconds(420);
  pulseIR(680);
  delayMicroseconds(440);
  pulseIR(680);
  delayMicroseconds(440);
  pulseIR(640);
  delayMicroseconds(440);
  pulseIR(660);
  delayMicroseconds(460);
  pulseIR(660);
  delayMicroseconds(460);
  pulseIR(620);
  delayMicroseconds(1600);
  pulseIR(620);
  delayMicroseconds(1580);
  pulseIR(620);
  delayMicroseconds(1620);
  pulseIR(580);
  delayMicroseconds(1620);
  pulseIR(600);
  delayMicroseconds(1620);
  pulseIR(580);
  delayMicroseconds(1660);
  pulseIR(540);
  delayMicroseconds(1680);
  pulseIR(560);
  delayMicroseconds(1660);
  pulseIR(540);
  delayMicroseconds(1680);
  pulseIR(540);
  delayMicroseconds(540);
  pulseIR(580);
  delayMicroseconds(540);
  pulseIR(560);
  delayMicroseconds(1660);
  pulseIR(560);
  delayMicroseconds(540);
  pulseIR(560);
  delayMicroseconds(560);
  pulseIR(560);
  delayMicroseconds(520);
  pulseIR(580);
  delayMicroseconds(540);
  pulseIR(560);
  delayMicroseconds(560);
  pulseIR(560);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(520);
  pulseIR(580);
  delayMicroseconds(1660);
  pulseIR(560);
  delayMicroseconds(1660);
  pulseIR(540);
  delayMicroseconds(1660);
  pulseIR(560);
  delayMicroseconds(1660);
  pulseIR(560);
  delay(39);
  pulseIR(8960);
  delayMicroseconds(2200);
  pulseIR(560);
}

void green() {
  pulseIR(9200);
  delayMicroseconds(4160);
  pulseIR(800);
  delayMicroseconds(320);
  pulseIR(760);
  delayMicroseconds(360);
  pulseIR(720);
  delayMicroseconds(380);
  pulseIR(700);
  delayMicroseconds(420);
  pulseIR(680);
  delayMicroseconds(440);
  pulseIR(660);
  delayMicroseconds(440);
  pulseIR(660);
  delayMicroseconds(440);
  pulseIR(660);
  delayMicroseconds(460);
  pulseIR(620);
  delayMicroseconds(1580);
  pulseIR(660);
  delayMicroseconds(1560);
  pulseIR(640);
  delayMicroseconds(1600);
  pulseIR(580);
  delayMicroseconds(1620);
  pulseIR(600);
  delayMicroseconds(1620);
  pulseIR(600);
  delayMicroseconds(1640);
  pulseIR(560);
  delayMicroseconds(1660);
  pulseIR(560);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(540);
  pulseIR(560);
  delayMicroseconds(560);
  pulseIR(540);
  delayMicroseconds(540);
  pulseIR(580);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(520);
  pulseIR(580);
  delayMicroseconds(540);
  pulseIR(580);
  delayMicroseconds(540);
  pulseIR(560);
  delayMicroseconds(520);
  pulseIR(580);
  delayMicroseconds(1660);
  pulseIR(560);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(520);
  pulseIR(580);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(1620);
  pulseIR(600);
  delay(39);
  pulseIR(8940);
  delayMicroseconds(2200);
  pulseIR(600);
}

void blue() {
  pulseIR(9200);
  delayMicroseconds(4160);
  pulseIR(820);
  delayMicroseconds(300);
  pulseIR(760);
  delayMicroseconds(360);
  pulseIR(740);
  delayMicroseconds(360);
  pulseIR(700);
  delayMicroseconds(420);
  pulseIR(680);
  delayMicroseconds(440);
  pulseIR(660);
  delayMicroseconds(420);
  pulseIR(680);
  delayMicroseconds(440);
  pulseIR(680);
  delayMicroseconds(440);
  pulseIR(640);
  delayMicroseconds(1560);
  pulseIR(660);
  delayMicroseconds(1560);
  pulseIR(640);
  delayMicroseconds(1600);
  pulseIR(600);
  delayMicroseconds(1600);
  pulseIR(620);
  delayMicroseconds(1600);
  pulseIR(620);
  delayMicroseconds(1620);
  pulseIR(580);
  delayMicroseconds(1640);
  pulseIR(560);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(540);
  pulseIR(560);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(540);
  pulseIR(560);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(540);
  pulseIR(560);
  delayMicroseconds(540);
  pulseIR(560);
  delayMicroseconds(540);
  pulseIR(580);
  delayMicroseconds(520);
  pulseIR(560);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(540);
  pulseIR(580);
  delayMicroseconds(1620);
  pulseIR(580);
  delayMicroseconds(540);
  pulseIR(560);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(1620);
  pulseIR(580);
  delay(39);
  pulseIR(8920);
  delayMicroseconds(2200);
  pulseIR(580);

}

void white() {
  pulseIR(9180);
  delayMicroseconds(4200);
  pulseIR(780);
  delayMicroseconds(340);
  pulseIR(760);
  delayMicroseconds(380);
  pulseIR(700);
  delayMicroseconds(400);
  pulseIR(680);
  delayMicroseconds(460);
  pulseIR(660);
  delayMicroseconds(460);
  pulseIR(620);
  delayMicroseconds(460);
  pulseIR(660);
  delayMicroseconds(480);
  pulseIR(640);
  delayMicroseconds(480);
  pulseIR(600);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(1640);
  pulseIR(580);
  delayMicroseconds(1660);
  pulseIR(540);
  delayMicroseconds(1680);
  pulseIR(560);
  delayMicroseconds(1640);
  pulseIR(560);
  delayMicroseconds(1700);
  pulseIR(520);
  delayMicroseconds(1700);
  pulseIR(540);
  delayMicroseconds(1660);
  pulseIR(560);
  delayMicroseconds(1680);
  pulseIR(540);
  delayMicroseconds(1680);
  pulseIR(540);
  delayMicroseconds(580);
  pulseIR(520);
  delayMicroseconds(1700);
  pulseIR(560);
  delayMicroseconds(560);
  pulseIR(520);
  delayMicroseconds(560);
  pulseIR(560);
  delayMicroseconds(560);
  pulseIR(560);
  delayMicroseconds(560);
  pulseIR(540);
  delayMicroseconds(540);
  pulseIR(560);
  delayMicroseconds(580);
  pulseIR(540);
  delayMicroseconds(1660);
  pulseIR(560);
  delayMicroseconds(560);
  pulseIR(560);
  delayMicroseconds(1660);
  pulseIR(560);
  delayMicroseconds(1680);
  pulseIR(540);
  delayMicroseconds(1680);
  pulseIR(560);
  delayMicroseconds(1660);
  pulseIR(560);
  delay(39);
  pulseIR(8940);
  delayMicroseconds(2240);
  pulseIR(560);

}



