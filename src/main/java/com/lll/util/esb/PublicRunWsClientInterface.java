/***
 *
 *  author ningtn
 */

package com.lll.util.esb;

import java.util.ArrayList;

public interface PublicRunWsClientInterface {
 
	@SuppressWarnings("rawtypes")
	public ArrayList invokESBServer(String serverPath, String[] param,int transFlag);

		 
}
