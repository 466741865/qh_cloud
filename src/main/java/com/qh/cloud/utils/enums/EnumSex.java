package com.qh.cloud.utils.enums;

/**
 * 性别 枚举类
 * @author QingHang
 * @date 2017年1月11日
 */
public enum EnumSex {
	MAN("男",0),
	WOMAN("女",1);
	
	private String name;
	
	private int code;
	
	private EnumSex(String name,int code){
		this.name = name;
		this.code = code;
	}
	
	public static int getCode(String name){
		for (EnumSex sex : EnumSex.values()) {
			if(name.equals(sex.getCode())){
				return sex.getCode();
			}
		}
		return 0;
	}
	
	public static String getName(int code){
		for (EnumSex sex : EnumSex.values()) {
			if(code == sex.getCode()){
				return sex.getName();
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}
