package com.lll.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.ui.Model;

/**
 * @description 常量单元类
 * 
 */
public class Constants {
	
	public static final String OK = "OK";
	public static final String FAIL = "FAIL";
	
	//信息发布表，月表表名
	public static final String IMS_INFOPUBLIS = "IMS_INFOPUBLIS";
	
	/* 资源分类最上级节点 */
	public static final Long RES_CATEGORY_ROOTID = 0L;
	/* 资源分类有效标志 */
	public static final String RES_CATEGORY_USE_STATUS = "1";
	/* 资源分类无效标志 */
	public static final String RES_CATEGORY_UNUSE_STATUS = "0";
	/* 初始化的资源分类标志 */
	public static final String RES_CATEGORY_INITIALIZE = "1";
	/* 非初始化的资源分类标志 */
	public static final String RES_CATEGORY_UNINITIALIZE = "0";
	/* 是叶子节点 */
	public static final String RES_CATEGORY_ISLEAF = "Y";
	/* 不是叶子节点 */
	public static final String RES_CATEGORY_ISNOTLEAF = "N";
	/* 设备属性大类编码 */
	public static final String BIG_ATTR_CODE_MACHINE = "1";
	/* 物品属性大类编码 */
	public static final String BIG_ATTR_CODE_STAFF = "2";
	/* 备用金属性大类编码 */
	public static final String BIG_ATTR_CODE_MONEY = "3";
	/* 票据属性大类编码 */
	public static final String BIG_ATTR_CODE_BILL = "4";
	/* 营业款属性大类编码 */
	public static final String BIG_ATTR_CODE_BUS_MONEY = "5";
	/* 枚举类型 */
	public static final String SELECT_TYPE = "1";
	/* 多值类型 */
	public static final String MUTI_TYPE = "2";
	/* 文本类型 */
	public static final String INPUT_TYPE = "3";
	/* 必填属性 */
	public static final String ATTR_MUST = "1";
	/* 非必填属性 */
	public static final String ATTR_NOT_MUST = "0";
	/* 资源分类编码head */
	public static final String RES_CATEGORY_CODE_HEAD = "CA";
	/* 分类属性编码head */
	public static final String RES_CATEGORY_ATTR_CODE_HEAD = "AT";
	/* 分类属性值编码head */
	public static final String RES_CATEGORY_ATTR_VALUE_CODE_HEAD = "VA";
	/* 物品编码head */
	public static final String RES_STUFF_CODE_HEAD = "ST";
	/* 备用金编码head */
	public static final String RES_PETTY_CASH_CODE_HEAD = "PE";
	/* 文本属性值系统数据 */
	public static final Long RES_INPUT_ATTR_ID = 1L;
	/* 设备库存状态可用 */
	public static final String RES_MACHINE_STCOK_USE = "1";
	/* 设备库存状态不可用 */
	public static final String RES_MACHINE_STCOK_UN_USE = "0";
	/* 设备物品状态有效 */
	public static final String RES_MACHINE_STATUS_USE = "1";
	/* 设备物品状态无效 */
	public static final String RES_MACHINE_STATUS_UN_USE = "0";
	/* 设备物品状态废弃 */
	public static final String RES_MACHINE_STATUS_ABABDON = "2";

	/* 物品入库标识 */
	public static final String STCOK_STUFF_IN = "1";
	/* 物品出库标识 */
	public static final String STCOK_STUFF_OUT = "2";

	/* 物品信息归属方 */
	public static final String RES_CRM = "CRM";
	public static final String RES_BASD = "BASD";

	/*
	 * 树形结构常量定义 给接口用的树: 1.资源分类树 opFlag = a 2.设备分类树 opFlag = b 3.物品分类树 opFlag = c
	 * 4.备用金分类树 opFlag = d 5.营业款分类树 opFlag = e 6.票据分类树 opFlag = f 给设备物品管理用的树：
	 * 1.资源分类树 opFlag = g 2.设备分类树 opFlag = h 3.物品分类树(包括票据分类) opFlag = i
	 * 4.备用金分类树(包括营业款分类) opFlag = j 注意：设备物品管理时,1.物品登记
	 * 时查询物品分类和票据分类;2.备用金登记时,查询备用金分类和营业款分类
	 */
	public static final String OPFLAG_CATEGORY_I = "a";
	public static final String OPFLAG_MACHINE_I = "b";
	public static final String OPFLAG_STUFF_I = "c";
	public static final String OPFLAG_PETTY_CASH_I = "d";
	public static final String OPFLAG_BUS_MONEY_I = "e";
	public static final String OPFLAG_BILL_I = "f";
	// public static final String OPFLAG_SBM_C = "k";

	public static final String OPFLAG_CATEGORY_C = "g";
	public static final String OPFLAG_MACHINE_C = "h";
	public static final String OPFLAG_STUFF_C = "i";
	public static final String OPFLAG_PETTY_CASH_C = "j";

	/**
	 * OPCODE和OPNAME部分
	 */
	/**
	 * 资源分类配置部分 start --------------------
	 * */
	/* 资源分类管理(入口) */
	/**
	 * 资源分类管理(入口)
	 */
	public static final String OPCODE_CATEGORY_MANAGE = "g998";
	public static final String OPNAME_CATEGORY_MANAGE = "资源分类管理";
	// 添加资源分类
	/**
	 * 添加资源分类
	 */
	public static final String OPCODE_CATEGORY_ADD = "g998Add";
	public static final String OPNAME_CATEGORY_ADD = "添加资源分类";
	// 查询资源分类
	/**
	 * 查询资源分类
	 */
	public static final String OPCODE_CATEGORY_SEL = "g997";
	public static final String OPNAME_CATEGORY_SEL = "查询资源分类";
	// 修改资源分类
	/**
	 * 修改资源分类
	 */
	public static final String OPCODE_CATEGORY_EDIT = "g998Edit";
	public static final String OPNAME_CATEGORY_EDIT = "修改资源分类";
	// 删除资源分类
	/**
	 * 删除资源分类
	 */
	public static final String OPCODE_CATEGORY_DEL = "g998Del";
	public static final String OPNAME_CATEGORY_DEL = "删除资源分类";

	/* 资源分类属性配置(入口) */
	/**
	 * 资源分类属性配置(入口)
	 */
	public static final String OPCODE_ATTR_MANAGE = "g996";
	public static final String OPNAME_ATTR_MANAGE = "资源分类属性配置";

	/**
	 * 添加属性
	 */
	public static final String OPCODE_ATTR_ADD = "g996Add";
	public static final String OPNAME_ATTR_ADD = "添加属性";

	/**
	 * 资源分类关联属性操作
	 */
	public static final String OPCODE_ATTR_CONNET = "g996Con";
	public static final String OPNAME_ATTR_CONNET = "资源分类关联属性";

	/**
	 * 修改分类属性
	 */
	public static final String OPCODE_ATTR_EDIT = "g996Edit";
	public static final String OPNAME_ATTR_EDIT = "分类属性修改";

	/**
	 * 删除分类属性
	 */
	public static final String OPCODE_ATTR_DEL = "g996Del";
	public static final String OPNAME_ATTR_DEL = "分类属性删除";

	/**
	 * 添加属性值
	 */
	public static final String OPCODE_ATTR_VAL_ADD = "g996Vadd";
	public static final String OPNAME_ATTR_VAL_ADD = "属性值添加";
	// 修改属性值
	/**
	 * 修改属性值
	 */
	public static final String OPCODE_ATTR_VAL_EDIT = "g996Vedit";
	public static final String OPNAME_ATTR_VAL_EDIT = "属性值修改";
	
	/** 
	* 删除属性值
	*/
	public static final String OPCODE_ATTR_VAL_DEL = "g996Vdel";
	public static final String OPNAME_ATTR_VAL_DEL = "属性值删除";

	/**
	 * 资源分类配置部分 end -------------------------
	 * */

	/**
	 * 设备信息管理部分 start -----------------------
	 * */

	/* 设备信息管理(入口) */
	/**
	 * 设备信息管理(入口)
	 */
	public static final String OPCODE_MACHINE_MANAGE = "g990";
	public static final String OPNAME_MACHINE_MANAGE = "设备信息管理";
	// 设备资料查询
	/**
	 * 设备资料查询
	 */
	public static final String OPCODE_MACHINE_SEL = "g990Sel";
	public static final String OPNAME_MACHINE_SEL = "设备资料查询";
	// 设备资料新增
	/**
	 * 设备资料新增
	 */
	public static final String OPCODE_MACHINE_ADD = "g990Add";
	public static final String OPNAME_MACHINE_ADD = "设备资料新增";
	// 设备资料删除
	/**
	 * 设备资料删除
	 */
	public static final String OPCODE_MACHINE_DEL = "g990Del";
	public static final String OPNAME_MACHINE_DEL = "设备资料删除";
	// 设备资料修改
	/**
	 * 设备资料修改
	 */
	public static final String OPCODE_MACHINE_EDIT = "g990Edit";
	public static final String OPNAME_MACHINE_EDIT = "设备资料修改";
	/* 设备归属信息配置(入口) */
	/**
	 * 设备归属信息配置(入口)
	 */
	public static final String OPCODE_MACHINE_OWN = "g990Own";
	public static final String OPNAME_MACHINE_OWN = "设备归属信息配置";
	// 设备归属信息新增
	/**
	 * 设备归属信息新增
	 */
	public static final String OPCODE_MACHINE_OWN_ADD = "g991OwnAdd";
	public static final String OPNAME_MACHINE_OWN_ADD = "设备归属信息新增";
	// 设备归属信息修改
	/**
	 * 设备归属信息修改
	 */
	public static final String OPCODE_MACHINE_OWN_EDIT = "g991OwnEdit";
	public static final String OPNAME_MACHINE_OWN_DEIT = "设备归属信息修改";

	/* 设备维护信息管理(入口) */
	/**
	 * 设备维护信息管理(入口)
	 */
	public static final String OPCODE_MACHINE_FIX_MANAGE = "g991";
	public static final String OPNAME_MACHINE_FIX_MANAGE = "设备维护信息管理";
	// 设备维护信息新增
	/**
	 * 设备维护信息新增
	 */
	public static final String OPCODE_MACHINE_FIX_ADD = "g991Add";
	public static final String OPNAME_MACHINE_FIX_ADD = "设备维护信息新增";
	// 设备维护信息查询
	/**
	 * 设备维护信息查询
	 */
	public static final String OPCODE_MACHINE_FIX_SEL = "g991Sel";
	public static final String OPNAME_MACHINE_FIX_SEL = "设备维护信息查询";
	// 设备维护信息修改
	/**
	 * 设备维护信息修改
	 */
	public static final String OPCODE_MACHINE_FIX_EDIT = "g991Edit";
	public static final String OPNAME_MACHINE_FIX_EDIT = "设备维护信息修改";
	// 设备维护信息删除
	/**
	 * 设备维护信息删除
	 */
	public static final String OPCODE_MACHINE_FIX_DEL = "g991Del";
	public static final String OPNAME_MACHINE_FIX_DEL = "设备维护信息删除";
	/**
	 * 设备信息管理部分 end -------------------------
	 * */

	/**
	 * 物品信息管理部分 start -------------------------
	 * */

	/* 物品信息管理(入口) */
	/**
	 * 物品信息管理(入口)
	 */
	public static final String OPCODE_STUFF_MANAGE = "g992";
	public static final String OPNAME_STUFF_MANAGE = "物品信息管理";
	// 物品信息新增
	/**
	 * 物品信息新增
	 */
	public static final String OPCODE_STUFF_ADD = "g992Add";
	public static final String OPNAME_STUFF_ADD = "物品信息新增";
	// 物品信息查询
	/**
	 * 物品信息查询
	 */
	public static final String OPCODE_STUFF_SEL = "g992Sel";
	public static final String OPNAME_STUFF_SEL = "物品信息查询";
	// 物品信息修改
	/**
	 * 物品信息修改
	 */
	public static final String OPCODE_STUFF_EDIT = "g992Edit";
	public static final String OPNAME_STUFF_EDIT = "物品信息修改";
	// 物品信息删除
	/**
	 * 物品信息删除
	 */
	public static final String OPCODE_STUFF_DEL = "g992Del";
	public static final String OPNAME_STUFF_DEL = "物品信息删除";

	/* 物品库存管理(入口) */
	/**
	 * 物品库存管理(入口)
	 */
	public static final String OPCODE_STUFF_STCOK = "g993";
	public static final String OPNAME_STUFF_STCOK = "物品库存管理";
	// 物品入库
	/**
	 * 物品入库
	 */
	public static final String OPCODE_STUFF_IN = "g993In";
	public static final String OPNAME_STUFF_IN = "物品信息入库";
	// 物品出库
	/**
	 * 物品出库
	 */
	public static final String OPCODE_STUFF_OUT = "g993Out";
	public static final String OPNAME_STUFF_OUT = "物品信息出库";

	/**
	 * 物品信息管理部分 end -------------------------
	 * */
	/**
	 * 备用金信息管理部分 start -------------------------
	 * */
	/* 备用金信息管理(入口) */
	/**
	 * 备用金信息管理(入口)
	 */
	public static final String OPCODE_PETTY_CASH_MANAGE = "g994";
	public static final String OPNAME_PETTY_CASH_MANAGE = "备用金信息管理";
	// 备用金信息新增
	/**
	 * 备用金信息新增
	 */
	public static final String OPCODE_PETTY_CASH_ADD = "g994Add";
	public static final String OPNAME_PETTY_CASH_ADD = "备用金信息新增";
	// 备用金信息查询
	/**
	 * 备用金信息查询
	 */
	public static final String OPCODE_PETTY_CASH_SEL = "g994Sel";
	public static final String OPNAME_PETTY_CASH_SEL = "备用金信息查询";
	// 备用金信息修改
	/**
	 * 备用金信息修改
	 */
	public static final String OPCODE_PETTY_CASH_EDIT = "g994Edit";
	public static final String OPNAME_PETTY_CASH_EDIT = "备用金信息修改";
	// 备用金信息删除
	/**
	 * 备用金信息删除
	 */
	public static final String OPCODE_PETTY_CASH_DEL = "g994Del";
	public static final String OPNAME_PETTY_CASH_DEL = "备用金信息删除";
	/* 备用金库存管理(入口) */
	/**
	 * 备用金库存管理(入口)
	 */
	public static final String OPCODE_PETTY_CASH_STCOK = "g995";
	public static final String OPNAME_PETTY_CASH_STCOK = "备用金库存管理";
	// 备用金入库
	/**
	 * 备用金入库
	 */
	public static final String OPCODE_PETTY_CASH_IN = "g995In";
	public static final String OPNAME_PETTY_CASH_IN = "备用金入库";
	// 备用金出库
	/**
	 * 备用金出库
	 */
	public static final String OPCODE_PETTY_CASH_OUT = "g995Out";
	public static final String OPNAME_PETTY_CASH_OUT = "备用金出库";

	/**
	 * 备用金信息管理部分 end -------------------------
	 * */

	// 物品库存调整
	public static final String OPCODE_ADJUST_STUFF_IN = "i012In";
	public static final String OPCODE_ADJUST_STUFF_OUT = "i012Out";
	// 营业款库存调整
	public static final String OPCODE_ADJUST_PETTY_CASH_IN = "i011In";
	public static final String OPCODE_ADJUST_PETTY_CASH_OUT = "i011Out";
	// 申领物品库存出库
	public static final String OPCODE_APPLY_STUFF = "g986";
	// 申领备用金库存出库
	public static final String OPCODE_APPLY_CASH = "g984";

	// 交接物品入库
	public static final String OPCODE_BPTRANSFER_STUFF = "i006Stuff";
	// 交接营业款入库
	public static final String OPCODE_BPTRANSFER_CASH = "i006Cash";
	
	//发送短息
	public static final String SEND_MESSAGE_URL = "SEND_MESSAGE_URL";
	//移动学园下发短信通知
	public static final String SEMINARY_UPLOAD_SENDSMS = "移动学园";
	
	
	//开始（从配置文件中获取短息发送路径）
	
		// configuration file location
	    private static final String CONFIG_FILE_NAME = "constants";
	    
	    // constant variables
	    private static final Map<String, String> constants;
		static {
	        constants = new HashMap<String, String>();
	        try{
	            ResourceBundle bundle = ResourceBundle.getBundle(CONFIG_FILE_NAME);
	            Enumeration<String> en =  bundle.getKeys();
	            while(en.hasMoreElements()){
	                String key = en.nextElement();
	                constants.put(key, bundle.getString(key));
	            }
	        }catch(Exception ex){
	            ex.printStackTrace();
	        }
	    }
	
	    public static String getConstant (String key){
	        return constants.get(key);
	    }
	

	
	//----标志ESB等平台调用服务端，不需要加密、解密操作标志
	public static final String ESB = "ESB";


	/**
	 * @description 公共的常量放入model方法
	 * @date 2013-8-27
	 * @param model
	 */
	public static void init(Model model) {
		/* 属性类别 枚举类型 多值类型 文本类型 */
		model.addAttribute("selectType", Constants.SELECT_TYPE);
		model.addAttribute("mutiType", Constants.MUTI_TYPE);
		model.addAttribute("inputType", Constants.INPUT_TYPE);
		/* 属性是否必填 */
		model.addAttribute("attrMust", Constants.ATTR_MUST);
		model.addAttribute("attrNotMust", Constants.ATTR_NOT_MUST);
		/* 资源分类有效标志 */
		model.addAttribute("useStatus", Constants.RES_CATEGORY_USE_STATUS);
		model.addAttribute("unUseStatus", Constants.RES_CATEGORY_UNUSE_STATUS);
		/* 资源分类初始化标志 */
		model.addAttribute("initialize", Constants.RES_CATEGORY_INITIALIZE);
		model.addAttribute("unInitialize", Constants.RES_CATEGORY_UNINITIALIZE);
		/* 资源分类是否叶子节点 */
		model.addAttribute("isLeaf", Constants.RES_CATEGORY_ISLEAF);
		model.addAttribute("isNotLeaf", Constants.RES_CATEGORY_ISNOTLEAF);

		/* 默认的文本属性ID */
		model.addAttribute("defaultInputAttrId", Constants.RES_INPUT_ATTR_ID);
		/* 设备信息是否有效库存 */
		model.addAttribute("useStcok", Constants.RES_MACHINE_STCOK_USE);
		model.addAttribute("unUseStcok", Constants.RES_MACHINE_STCOK_UN_USE);
		/* 设备物品信息是否有效(物品、设备、备用金共有状态) */
		model.addAttribute("useMachine", Constants.RES_MACHINE_STATUS_USE);
		model.addAttribute("unUseMachine", Constants.RES_MACHINE_STATUS_UN_USE);
		model.addAttribute("abandonMachine",
				Constants.RES_MACHINE_STATUS_ABABDON);
		/* 各种树形结构的常量 */
		model.addAttribute("opflagCategoryI", Constants.OPFLAG_CATEGORY_I);
		model.addAttribute("opflagMachineI", Constants.OPFLAG_MACHINE_I);
		model.addAttribute("opflagStuffI", Constants.OPFLAG_STUFF_I);
		model.addAttribute("opflagPettyCashI", Constants.OPFLAG_PETTY_CASH_I);
		model.addAttribute("opflagBusMoneyI", Constants.OPFLAG_BUS_MONEY_I);
		model.addAttribute("opflagBillI", Constants.OPFLAG_BILL_I);
		model.addAttribute("opflagCategoryC", Constants.OPFLAG_CATEGORY_C);
		model.addAttribute("opflagMachineC", Constants.OPFLAG_MACHINE_C);
		model.addAttribute("opflagStuffC", Constants.OPFLAG_STUFF_C);
		model.addAttribute("opflagPettyCashC", Constants.OPFLAG_PETTY_CASH_C);
		/* 各种属性大类编码 */
		model.addAttribute("bigAttrCodeMachine",
				Constants.BIG_ATTR_CODE_MACHINE);
		model.addAttribute("bigAttrCodeStuff", Constants.BIG_ATTR_CODE_STAFF);
		model.addAttribute("bigAttrCodePettyCash",
				Constants.BIG_ATTR_CODE_MONEY);
		model.addAttribute("bigAttrCodeBill", Constants.BIG_ATTR_CODE_BILL);
		model.addAttribute("bigAttrCodeBusMoney",
				Constants.BIG_ATTR_CODE_BUS_MONEY);
		/* 物品出入库标识 */
		model.addAttribute("stcokStuffIn", Constants.STCOK_STUFF_IN);
		model.addAttribute("stcokStuffOut", Constants.STCOK_STUFF_OUT);
		/* opCode和opName部分 */

		model.addAttribute("opCodeCategoryManage",
				Constants.OPCODE_CATEGORY_MANAGE);
		model.addAttribute("opNameCategoryManage",
				Constants.OPNAME_CATEGORY_MANAGE);
		model.addAttribute("opCodeCategoryAdd", Constants.OPCODE_CATEGORY_ADD);
		model.addAttribute("opNameCategoryAdd", Constants.OPNAME_CATEGORY_ADD);
		model.addAttribute("opCodeCategorySel", Constants.OPCODE_CATEGORY_SEL);
		model.addAttribute("opNameCategorySel", Constants.OPNAME_CATEGORY_SEL);
		model.addAttribute("opCodeCategoryEdit", Constants.OPCODE_CATEGORY_EDIT);
		model.addAttribute("opNameCategoryEdit", Constants.OPNAME_CATEGORY_EDIT);
		model.addAttribute("opCodeCategoryDel", Constants.OPCODE_CATEGORY_DEL);
		model.addAttribute("opNameCategoryDel", Constants.OPNAME_CATEGORY_DEL);

		model.addAttribute("opCodeAttrManage", Constants.OPCODE_ATTR_MANAGE);
		model.addAttribute("opNameAttrManage", Constants.OPNAME_ATTR_MANAGE);
		model.addAttribute("opCodeAttrAdd", Constants.OPCODE_ATTR_ADD);
		model.addAttribute("opNameAttrAdd", Constants.OPNAME_ATTR_ADD);
		model.addAttribute("opCodeAttrConnet", Constants.OPCODE_ATTR_CONNET);
		model.addAttribute("opNameAttrConnet", Constants.OPNAME_ATTR_CONNET);
		model.addAttribute("opCodeAttrEdit", Constants.OPCODE_ATTR_EDIT);
		model.addAttribute("opNameAttrEdit", Constants.OPNAME_ATTR_EDIT);
		model.addAttribute("opCodeAttrDel", Constants.OPCODE_ATTR_DEL);
		model.addAttribute("opNameAttrDel", Constants.OPNAME_ATTR_DEL);
		model.addAttribute("opCodeAttrValAdd", Constants.OPCODE_ATTR_VAL_ADD);
		model.addAttribute("opNameAttrValAdd", Constants.OPNAME_ATTR_VAL_ADD);
		model.addAttribute("opCodeAttrValEdit", Constants.OPCODE_ATTR_VAL_EDIT);
		model.addAttribute("opNameAttrValEdit", Constants.OPNAME_ATTR_VAL_EDIT);

		model.addAttribute("opCodeMachineManage",
				Constants.OPCODE_MACHINE_MANAGE);
		model.addAttribute("opNameMachineManage",
				Constants.OPNAME_MACHINE_MANAGE);
		model.addAttribute("opCodeMachineSel", Constants.OPCODE_MACHINE_SEL);
		model.addAttribute("opNameMachineSel", Constants.OPNAME_MACHINE_SEL);
		model.addAttribute("opCodeMachineAdd", Constants.OPCODE_MACHINE_ADD);
		model.addAttribute("opNameMachineAdd", Constants.OPNAME_MACHINE_ADD);
		model.addAttribute("opCodeMachineDel", Constants.OPCODE_MACHINE_DEL);
		model.addAttribute("opNameMachineDel", Constants.OPNAME_MACHINE_DEL);
		model.addAttribute("opCodeMachineEdit", Constants.OPCODE_MACHINE_EDIT);
		model.addAttribute("opNameMachineEdit", Constants.OPNAME_MACHINE_EDIT);
		model.addAttribute("opCodeMachineOwn", Constants.OPCODE_MACHINE_OWN);
		model.addAttribute("opNameMachineOwn", Constants.OPNAME_MACHINE_OWN);
		model.addAttribute("opCodeMachineOwnAdd",
				Constants.OPCODE_MACHINE_OWN_ADD);
		model.addAttribute("opNameMachineOwnAdd",
				Constants.OPNAME_MACHINE_OWN_ADD);
		model.addAttribute("opCodeMachineOwnEdit",
				Constants.OPCODE_MACHINE_OWN_EDIT);
		model.addAttribute("opNameMachineOwnDeit",
				Constants.OPNAME_MACHINE_OWN_DEIT);
		model.addAttribute("opCodeMachineFixManage",
				Constants.OPCODE_MACHINE_FIX_MANAGE);
		model.addAttribute("opNameMachineFixManage",
				Constants.OPNAME_MACHINE_FIX_MANAGE);
		model.addAttribute("opCodeMachineFixAdd",
				Constants.OPCODE_MACHINE_FIX_ADD);
		model.addAttribute("opNameMachineFixAdd",
				Constants.OPNAME_MACHINE_FIX_ADD);
		model.addAttribute("opCodeMachineFixSel",
				Constants.OPCODE_MACHINE_FIX_SEL);
		model.addAttribute("opNameMachineFixSel",
				Constants.OPNAME_MACHINE_FIX_SEL);
		model.addAttribute("opCodeMachineFixEdit",
				Constants.OPCODE_MACHINE_FIX_EDIT);
		model.addAttribute("opNameMachineFixEdit",
				Constants.OPNAME_MACHINE_FIX_EDIT);
		model.addAttribute("opCodeMachineFixDel",
				Constants.OPCODE_MACHINE_FIX_DEL);
		model.addAttribute("opNameMachineFixDel",
				Constants.OPNAME_MACHINE_FIX_DEL);

		model.addAttribute("opCodeStuffManage", Constants.OPCODE_STUFF_MANAGE);
		model.addAttribute("opNameStuffManage", Constants.OPNAME_STUFF_MANAGE);
		model.addAttribute("opCodeStuffAdd", Constants.OPCODE_STUFF_ADD);
		model.addAttribute("opNameStuffAdd", Constants.OPNAME_STUFF_ADD);
		model.addAttribute("opCodeStuffSel", Constants.OPCODE_STUFF_SEL);
		model.addAttribute("opNameStuffSel", Constants.OPNAME_STUFF_SEL);
		model.addAttribute("opCodeStuffEdit", Constants.OPCODE_STUFF_EDIT);
		model.addAttribute("opNameStuffEdit", Constants.OPNAME_STUFF_EDIT);
		model.addAttribute("opCodeStuffDel", Constants.OPCODE_STUFF_DEL);
		model.addAttribute("opNameStuffDel", Constants.OPNAME_STUFF_DEL);
		model.addAttribute("opCodeStuffStcok", Constants.OPCODE_STUFF_STCOK);
		model.addAttribute("opNameStuffStcok", Constants.OPNAME_STUFF_STCOK);
		model.addAttribute("opCodeStuffIn", Constants.OPCODE_STUFF_IN);
		model.addAttribute("opNameStuffIn", Constants.OPNAME_STUFF_IN);
		model.addAttribute("opCodeStuffOut", Constants.OPCODE_STUFF_OUT);
		model.addAttribute("opNameStuffOut", Constants.OPNAME_STUFF_OUT);

		model.addAttribute("opCodePettyCashManage",
				Constants.OPCODE_PETTY_CASH_MANAGE);
		model.addAttribute("opNamePettyCashManage",
				Constants.OPNAME_PETTY_CASH_MANAGE);
		model.addAttribute("opCodePettyCashAdd",
				Constants.OPCODE_PETTY_CASH_ADD);
		model.addAttribute("opNamePettyCashAdd",
				Constants.OPNAME_PETTY_CASH_ADD);
		model.addAttribute("opCodePettyCashSel",
				Constants.OPCODE_PETTY_CASH_SEL);
		model.addAttribute("opNamePettyCashSel",
				Constants.OPNAME_PETTY_CASH_SEL);
		model.addAttribute("opCodePettyCashEdit",
				Constants.OPCODE_PETTY_CASH_EDIT);
		model.addAttribute("opNamePettyCashEdit",
				Constants.OPNAME_PETTY_CASH_EDIT);
		model.addAttribute("opCodePettyCashDel",
				Constants.OPCODE_PETTY_CASH_DEL);
		model.addAttribute("opNamePettyCashDel",
				Constants.OPNAME_PETTY_CASH_DEL);
		model.addAttribute("opCodePettyCashStcok",
				Constants.OPCODE_PETTY_CASH_STCOK);
		model.addAttribute("opNamePettyCashStcok",
				Constants.OPNAME_PETTY_CASH_STCOK);
		model.addAttribute("opCodePettyCashIn", Constants.OPCODE_PETTY_CASH_IN);
		model.addAttribute("opNamePettyCashIn", Constants.OPNAME_PETTY_CASH_IN);
		model.addAttribute("opCodePettyCashOut",
				Constants.OPCODE_PETTY_CASH_OUT);
		model.addAttribute("opNamePettyCashOut",
				Constants.OPNAME_PETTY_CASH_OUT);

	}

	/**
	 * @description 抛出异常公共方法
	 * @date 2013-9-29
	 * @param e
	 * @param retCode
	 * @param retMsg
	 */
	public static void throwsException(Exception e, String retCode,
			String retType) {
		throw new HallException(e.toString(), retCode, retType);
	}

}
