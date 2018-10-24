package com.astra.anblicks.pdca.claddkpi.services.sql;

import com.astra.anblicks.pdca.claddkpi.dto.CompanyDataByUserDto;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class PdcaSqlQueries {
	
public static List<CompanyDataByUserDto> getCompanyDataBasedOnModuleId_UserId(Connection conn,long userId,long moduleId) {
		
        QueryRunner queryRunner = new QueryRunner();
        
        List<CompanyDataByUserDto> userListByCompanies_ModuleId = new ArrayList<CompanyDataByUserDto>();

        ResultSetHandler<List<CompanyDataByUserDto>> resultHandler = new BeanListHandler<CompanyDataByUserDto>(CompanyDataByUserDto.class);
        try {
        	if(conn!=null){
        	 String sql = "SELECT cu.Pdca_userId as userId,cu.companyId,cd.CompanyName, ads.settings_Id,ads.year,ads.periodId,ads.moduleId,IF(ads.settings_Id is null, 'false', 'true') as flag from pdca_astrapdca_companydata cd, pdca_company_user cu LEFT OUTER JOIN pdca_pdca_adminsettings ads on cu.companyId = ads.companyId and ads.moduleId = ? where cu.Pdca_userId = ?  and cd.companyId=cu.companyId group by cu.Pdca_userId,cu.companyId order by cu.companyId";
        	 userListByCompanies_ModuleId = queryRunner.query(conn,sql,resultHandler,moduleId,userId);

              
        	}
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		
       return userListByCompanies_ModuleId;
	}
	
	private static Log logger = LogFactoryUtil.getLog(PdcaSqlQueries.class.getName());


}
