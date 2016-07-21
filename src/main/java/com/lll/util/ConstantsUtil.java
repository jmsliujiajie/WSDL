package com.lll.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
/**
 */
public class ConstantsUtil {
    
    // configuration file location
    private static final String APPLY_CONFIG_FILE_NAME = "applyConstants";
    private static final String TRANSFER_CONFIG_FILE_NAME = "transferConstants";
    private static final String MACHINE_CONFIG_FILE_NAME = "machineStuffConstants";
    private static final String BASE_CONFIG_FILE_NAME = "baseConstants";
    
    // constant variables
    private static final Map<String, String> applyConstants;
    private static final Map<String, String> transferConstants;
    private static final Map<String, String> machineStuffConstants;
    private static final Map<String, String> baseConstants;
    
    /***************************************************************/
    public static final String BP_TRANSFER_TEMPLATE_NAME = "BP_TRANSFER_TEMPLATE_NAME";
    
    static {
        applyConstants = new HashMap<String, String>();
        transferConstants = new HashMap<String, String>();
        machineStuffConstants = new HashMap<String, String>();
        baseConstants = new HashMap<String, String>();
        try{
            ResourceBundle bundleApply = ResourceBundle.getBundle(APPLY_CONFIG_FILE_NAME);
            Enumeration<String> enApply =  bundleApply.getKeys();
            while(enApply.hasMoreElements()){
                String key = enApply.nextElement();
                applyConstants.put(key, bundleApply.getString(key));
            }
            
            ResourceBundle bundleTransfer = ResourceBundle.getBundle(TRANSFER_CONFIG_FILE_NAME);
            Enumeration<String> en =  bundleTransfer.getKeys();
            while(en.hasMoreElements()){
                String key = en.nextElement();
                transferConstants.put(key, bundleTransfer.getString(key));
            }
            
            ResourceBundle bundleMachine = ResourceBundle.getBundle(MACHINE_CONFIG_FILE_NAME);
            Enumeration<String> enMachine =  bundleMachine.getKeys();
            while(enMachine.hasMoreElements()){
                String key = enMachine.nextElement();
                machineStuffConstants.put(key, bundleMachine.getString(key));
            }
            
            ResourceBundle bundleBase = ResourceBundle.getBundle(BASE_CONFIG_FILE_NAME);
            Enumeration<String> enBase =  bundleBase.getKeys();
            while(enBase.hasMoreElements()){
                String key = enBase.nextElement();
                baseConstants.put(key, bundleBase.getString(key));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private ConstantsUtil(){}
    
    public static String getApplyConstant (String key){
        return applyConstants.get(key);
    }
    public static String getTransferConstant (String key){
        return transferConstants.get(key);
    }
    public static String getMachineConstant (String key){
        return machineStuffConstants.get(key);
    }
    public static String getBaseConstant (String key){
        return baseConstants.get(key);
    }
}
