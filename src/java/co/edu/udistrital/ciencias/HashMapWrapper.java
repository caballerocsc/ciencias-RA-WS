/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udistrital.ciencias;

import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class HashMapWrapper {

    private HashMap<Integer, Integer> basketMap;

    public HashMapWrapper(HashMap<Integer, Integer> basketMap) {
        this.setBasketMap(basketMap);
    }

    public HashMap<Integer, Integer> getBasketMap() {
        return basketMap;
    }

    public void setBasketMap(HashMap<Integer, Integer> basketMap) {
        this.basketMap = basketMap;
    }
    
}
