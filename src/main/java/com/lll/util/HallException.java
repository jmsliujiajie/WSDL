package com.lll.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;


/**
 */
public class HallException extends DataAccessException {
    private static final long serialVersionUID = 1L;
    
    protected final transient Log log = LogFactory.getLog(HallException.class);
    
    public static final String TRANSFER = "transfer"; 
    
    private String retCode;
    private String retMsg;

    public HallException(String message, Throwable cause) {
        super(message, cause);
    }

    public HallException(String message) {
        super(message);
    }

    /**
     * @param message
     * @param retCode
     * @param retMsg
     */
    public HallException(String message, String retCode, String type) {
        super(message);
        log.info(message);
        
        this.retCode = retCode;
        if("apply".equals(type)){
        	this.retMsg = ConstantsUtil.getApplyConstant(retCode);
        }else if("transfer".equals(type)){
        	this.retMsg = ConstantsUtil.getTransferConstant(retCode);
        }else if("machineStuff".equals(type)){
        	this.retMsg = ConstantsUtil.getMachineConstant(retCode);
        }else if("base".equals(type)){
        	this.retMsg = ConstantsUtil.getBaseConstant(retCode);
        }
    }
    
    

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}
