package com.lll.security.service.Impl;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import com.lll.util.EncodeUtils;


/** 
* @description 加入自定义加密输入的密码方法,与数据库或接口密码做匹配的方法
* @date 20130905 
*/
public class passWordEncoderImpl implements PasswordEncoder{

	@Override
	public String encodePassword(String inputPassWord, Object salt)
			throws DataAccessException {
		String resultPass = null;
		// 将明文转为密文的方法
		String sysConfigProv = System.getProperty("PROV");
		if("LOCAL".equals(sysConfigProv)){
			resultPass = EncodeUtils.getMd5PasswordEncoder(inputPassWord, null);
		}
		else if("HLJ".equals(sysConfigProv)){
			resultPass = inputPassWord;
		}
		else if("JL".equals(sysConfigProv)){
			resultPass = inputPassWord;
		}
		else if("SX".equals(sysConfigProv)){
			resultPass = inputPassWord;
		}
		else if("AH".equals(sysConfigProv)){
			resultPass = inputPassWord;
		}
		return resultPass;
	}

	@Override
	public boolean isPasswordValid(String dbPassWord, String inputPassWord, Object salt)
			throws DataAccessException {
		// 判断密码是否有效方法
		inputPassWord = encodePassword(inputPassWord,null);
		String SYS_VALIDATE_PASSWORD = System.getProperty("SYS_VALIDATE_PASSWORD");
		if("FALSE".equals(SYS_VALIDATE_PASSWORD)){
			System.out.println("==============do not need second validate in passWordEncoderImpl===========");
			return true;
		}else{
			return dbPassWord.equals(inputPassWord);
		}
	}

}
