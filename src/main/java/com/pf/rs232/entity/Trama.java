/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pf.rs232.entity;

/**
 *
 * @author laptop
 */
public class Trama {
    private String address;
    private String command;
    private String payload;
    private String lrc;
    Trama(String address, String command, String payload) {
        this.address = address;
        this.command = command;
        this.payload = payload;
    }
    private String getLRC() {
        lrc = "";
        String paquete = new StringBuilder().append(address)
                            .append(command).append(payload).toString();
        
        for(int i=0; i < paquete.length();i++) {
             
        }
        return ": |";
    }
}
