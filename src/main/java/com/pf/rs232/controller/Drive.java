/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pf.rs232.controller;


import com.pf.rs232.service.SerialPortReader;
import jssc.*;


/**
 *
 * @author sebastian.suarez
 */

public class Drive {
    SerialPort serialPort = null;
    public String[] getPort() {
        return SerialPortList.getPortNames();
    }
    public boolean setPort(String comSelected, int baudRate) {
        serialPort = new SerialPort(comSelected);
        try {
                serialPort.openPort();//Open port
                serialPort.setParams(baudRate, 8, 1, 0);//Set params
                int mask = SerialPort.MASK_RXCHAR + SerialPort.MASK_CTS + SerialPort.MASK_DSR;//Prepare mask
                serialPort.setEventsMask(mask);//Set mask
                serialPort.addEventListener(new SerialPortReader(serialPort));//Add SerialPortEventListener
                return true;
        }
        catch (SerialPortException ex) {
           System.out.printf("problema al abrir "+comSelected);
           return false;
        }
    }
    public void sendData() {
        if (serialPort != null) {
            try {
               serialPort.writeInt(84);
            } catch (SerialPortException ex) {
                System.out.println("There are an error on writing string to port т: " + ex);
            }
        }
    }
    
    public void sendCommand(String payload) {
        
    }
    public String getData() {
        return null;
    }
    
}
