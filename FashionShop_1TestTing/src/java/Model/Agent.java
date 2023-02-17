/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author win
 */
public class Agent {
    int agentId;
    String agentName;
    private Size size;

    public Agent() {
    }

    public Agent(int agentId, String agentName) {
        this.agentId = agentId;
        this.agentName = agentName;
    }

    public Agent(int agentId, String agentName, Size size) {
        this.agentId = agentId;
        this.agentName = agentName;
        this.size = size;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Agent{" + "agentId=" + agentId + ", agentName=" + agentName + ", size=" + size + '}';
    }

   
    
}

