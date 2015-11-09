/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pf.rs232.service;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author sebastian.suarez
 */
public class SerialPortReader implements SerialPortEventListener{
    
    static private SerialPort serialPort;
    static private  JTextArea jTextArea;
    
    public SerialPortReader(SerialPort serialPort,JTextArea jTextArea){
        SerialPortReader.serialPort=serialPort;
        SerialPortReader.jTextArea=jTextArea;
    }
    public void serialEvent(SerialPortEvent event) {
            if(event.isRXCHAR() && event.getEventValue() > 0){//Check bytes count in the input buffer
                    //Read data, if 10 bytes available 
                    try {
                        byte buffer[] = serialPort.readBytes(1);
                        jTextArea.append(new String(buffer, "UTF-8"));
                    } catch (SerialPortException ex) {
                        System.out.println(ex);
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(SerialPortReader.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
            }
            else if(event.isCTS()){//If CTS line has changed state
                if(event.getEventValue() == 1){//If line is ON
                    System.out.println("CTS - ON");
                }
                else {
                    System.out.println("CTS - OFF");
                }
            }
            else if(event.isDSR()){///If DSR line has changed state
                if(event.getEventValue() == 1) {//If line is ON
                    System.out.println("DSR - ON");
                }
                else {
                    System.out.println("DSR - OFF");
                }
            }
        }

    
}
