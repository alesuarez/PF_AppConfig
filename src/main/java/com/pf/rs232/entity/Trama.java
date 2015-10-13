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
    private String data;
    private String payload;
    private int lrc;
    public Trama(String address, String command, String data) {
        this.address = address;
        this.command = command;
        this.data = data;
        this.lrc = 0;
        this.payload = new StringBuilder().append(address)
                            .append(command).append(data).toString();
        for(int i=0; i < payload.length(); i++) {
            lrc = lrc ^ payload.codePointAt(i);
        }
    }
    
    public int LRC() {
        return lrc;
    }
    public String getPayload() {
        return this.payload;
    }
}
