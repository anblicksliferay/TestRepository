package com.astra.anblicks.pdca.services.sql;

import com.liferay.portal.kernel.util.PropsUtil;

public class PdcaSqlConstants {
	
	protected static String _driver 	= PropsUtil.get("jdbc.pdca.driverClassName");
	protected static String _url 		= PropsUtil.get("jdbc.pdca.url");
	protected static String _username 	= PropsUtil.get("jdbc.pdca.username");
	protected static String _password 	= PropsUtil.get("jdbc.pdca.password");

}
