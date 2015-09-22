/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pf.rs232.controller;


import jssc.*;


/**
 *
 * @author sebastian.suarez
 */

public class Drive {
    
    public String[] getPort() {
        return SerialPortList.getPortNames();
    }
    public String setPort(String comSelected, int baudRate) {
        SerialPort serialPort = new SerialPort(comSelected);
        
        
        try {
                serialPort.openPort();//Open port
                serialPort.setParams(baudRate, 8, 1, 0);//Set params
                int mask = SerialPort.MASK_RXCHAR + SerialPort.MASK_CTS + SerialPort.MASK_DSR;//Prepare mask
                serialPort.setEventsMask(mask);//Set mask
                serialPort.addEventListener(new SerialPortReader());//Add SerialPortEventListener
        }
        catch (SerialPortException ex) {
           return ex.getMessage();
        }
        return "Exito";
    }
    
}
