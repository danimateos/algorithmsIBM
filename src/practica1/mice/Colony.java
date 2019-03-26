/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.mice;

import java.util.ArrayList;

/**
 *
 * @author dani
 */
public class Colony {

    private String code, caretaker;
    private int daysInHouse;
    private ArrayList<Mouse> mice;

    public Colony(String code, String caretaker, int daysInHouse) {
        this.code = code;
        this.caretaker = caretaker;
        this.daysInHouse = daysInHouse;
    }

    public void add(Mouse mouse) {
        // TODO: check existing references before adding        
        mice.add(mouse);
    }

    public String[] getReferenceCodes() {
        String[] codes = new String[mice.size()];
        for (int i = 0; i < mice.size(); i++) {
            codes[i] = mice.get(i).getReference();
        }

        return codes;
    }

    public void remove(String code) {
        for (int i = 0; i < mice.size(); i++) {
            if (mice.get(i).getReference() == code) {
                mice.remove(i);
                break; // Only remove once, or we might go out of bounds.
            }
        }
    }

    public void modify(String code, Mouse mouse) {
        remove(code);
        mice.add(mouse);
    }

    public void showDetails(String code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCode() {
        return code;
    }

    public String getCaretaker() {
        return caretaker;
    }

    public int getDaysInHouse() {
        return daysInHouse;
    }

    public ArrayList<Mouse> getMice() {
        return mice;
    }
    
   
}
