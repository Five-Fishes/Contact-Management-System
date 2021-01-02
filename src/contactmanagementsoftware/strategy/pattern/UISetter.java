/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware.strategy.pattern;

import contactmanagementsoftware.MUI;

/**
 *
 * @author luxianze
 * 
 * - The MUI class instance will be passed into this class instance
 * - The setUI implementation will define the detailed look based on the current selection type
 */
public abstract class UISetter {
    protected MUI muiInstance;
    
    public UISetter(MUI muiInstance){
        this.muiInstance = muiInstance;
    };
    
    public abstract void setUI();
}
