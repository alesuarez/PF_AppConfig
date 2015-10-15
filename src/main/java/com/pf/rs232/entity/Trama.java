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

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the command
     */
    public String getCommand() {
        return command;
    }

    /**
     * @param command the command to set
     */
    public void setCommand(String command) {
        this.command = command;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the payload
     */
    public String getPayload() {
        return payload;
    }

    /**
     * @param payload the payload to set
     */
    public void setPayload(String payload) {
        this.payload = payload;
    }

    /**
     * @return the lrc
     */
    public int getLrc() {
        return lrc;
    }

    /**
     * @param lrc the lrc to set
     */
    public void setLrc(int lrc) {
        this.lrc = lrc;
    }
     
}
