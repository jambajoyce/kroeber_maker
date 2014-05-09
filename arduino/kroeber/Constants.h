#ifndef CONSTANTS_H
#define CONSTANTS_H

//Pin layout 
#define IRledPin 13    // LED connected to digital pin 13
#define HeightPWM 11 //serves as PWM that changes up the power fed to pump 
#define TX 5
#define RX 6


//How often to resend IR commands
#define REPEAT 5

//State Machine for Bluetooth Protocol 
#define LISTENING 0
#define COLOR 1
#define HEIGHT 2
#define BURST 3

#define START_COMMAND 0
#define ACK 70

//Burst 
#define MAX_BURSTS 5


//The remote control colors
#define RED 0
#define GREEN 1
#define BLUE 2
#define WHITE 3
#define RED2 4
#define GREEN2 5
#define BLUE2 6
#define FLASH 7
#define RED3 8
#define GREEN3 9
#define BLUE3 10
#define STROBE 11
#define RED4 12
#define GREEN4 13
#define BLUE4 14
#define FADE 15
#define RED5 16
#define GREEN5 17
#define BLUE5 18
#define SMOOTH 19

//Default configuration (when there is no one present
#define DEFAULT_COLOR RED
#define DEFAULT_HEIGHT 255
#define DEFAULT_BURST 5



class CurrentConfig {
  public:
    int color;
    int height;
    int burst;  
};

#endif
