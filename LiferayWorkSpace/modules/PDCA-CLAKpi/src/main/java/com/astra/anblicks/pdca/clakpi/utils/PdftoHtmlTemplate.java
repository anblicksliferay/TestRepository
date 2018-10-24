package com.astra.anblicks.pdca.clakpi.utils;

import java.util.Date;
import java.util.List;

import com.astra.anblicks.pdca.model.AstraPdca_CompanyData;
import com.astra.anblicks.pdca.model.kpi;
import com.astra.anblicks.pdca.service.AstraPdca_CompanyDataLocalServiceUtil;
import com.astra.anblicks.pdca.service.achivementFormulaLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

public class PdftoHtmlTemplate {

	public static String getClaPdfToHtmlTemplate(long companyId, List<kpi> list_kpis) throws PortalException {
		
			AstraPdca_CompanyData astraPdca_CompanyData = AstraPdca_CompanyDataLocalServiceUtil.getAstraPdca_CompanyData(companyId);
			
			kpi kpiobject = null;
			
			for(kpi _kpi: list_kpis) {
				if(_kpi.getItemDescriptionName().equals("1")){
					kpiobject = _kpi;
					break;
				}
			}
		
		
		
		 StringBuilder sb = new StringBuilder();
		 sb.append("<div style=\"float:none; margin:0 auto; text-align:center;\">");
		 sb.append("<h2>"+astraPdca_CompanyData.getCompanyName()+"</h2>");
         sb.append("<h3>"+astraPdca_CompanyData.getGroupName()+"</h3>");
         sb.append("<h4>Company Key Performance Indicator</h4>");
		 sb.append("<table style=\"width:100%;\">");
         sb.append("<tr>");
	     sb.append("<th>S.No</th>");
	     sb.append("<th>Item Description</th>");
	     sb.append("<th>Weight</th>");
	     sb.append("<th>Unit</th>");
	     sb.append("<th>Target</th>");
	     sb.append("<th>Achivement Formula</th>");
		 sb.append("</tr>");
  sb.append("<tr id=\"financial\">");
    sb.append("<th colspan=\"6\" style=\"text-align:left !important;\">FINANCIAL</th>");
   sb.append("</tr>");
   sb.append("<tr>");
    sb.append("<td>1</td>");
    sb.append("<td>TradingProfit</td>");
    sb.append("<td>"+kpiobject.getWeight()+"</td>");
	sb.append("<td>"+kpiobject.getUnit()+"</td>");
    sb.append("<td>"+kpiobject.getTarget()+"</td>");
    sb.append("<td>"+achivementFormulaLocalServiceUtil.getachivementFormula(kpiobject.getAchivementFormulaId()).getAchivementFormula()+"</td>");
   sb.append("</tr>");
   sb.append("<tr id=\"strategies\">");
     sb.append("<th colspan=\"6\" style=\"text-align:left !important;\">STRATEGIES</th>");
   sb.append("</tr>");
   int indexer = 1;
   for(kpi _kpi: list_kpis) {
	   if(_kpi.getItemDescriptionName().equals("2")){
		   
   sb.append("<tr>");
    sb.append("<td>"+indexer+"</td>");
    sb.append("<td>NonTradingProfit</td>");
    sb.append("<td>"+_kpi.getWeight()+"</td>");
	sb.append("<td>"+_kpi.getUnit()+"</td>");
    sb.append("<td>"+_kpi.getTarget()+"</td>");
    sb.append("<td>"+achivementFormulaLocalServiceUtil.getachivementFormula(_kpi.getAchivementFormulaId()).getAchivementFormula()+"</td>");
   sb.append("</tr>");
   indexer++;
	   }
   }
 sb.append("</table>");

 sb.append("<h4>Jagarta,"+new Date()+"</h4>");
 
 sb.append("<br/><br/>");
sb.append("<table style=\"width:100%; border: 0 !important;\">");
sb.append("<tr>");
sb.append("<td style=\"border: 0 !important; width:33%;\"><p>"+astraPdca_CompanyData.getLEFTUP()+"<br/>"+astraPdca_CompanyData.getLEFTUPTITLE()+"<br/>"+astraPdca_CompanyData.getLEFTUPCOMPANY()+"</p></td>");
sb.append("<td style=\"border: 0 !important; width:33%;\"><p>"+astraPdca_CompanyData.getMIDUP()+"<br/>"+astraPdca_CompanyData.getMIDUPTITLE()+"<br/>"+astraPdca_CompanyData.getMIDUPCOMPANY()+"</p></td>");
sb.append("<td style=\"border: 0 !important; width:33%;\"><p>"+astraPdca_CompanyData.getRIGHTUP()+"<br/>"+astraPdca_CompanyData.getRIGHTUPTITLE()+"<br/>"+astraPdca_CompanyData.getRIGHTUPCOMPANY()+"</p></td>");
sb.append("</tr>");
sb.append("</table>");
sb.append("<br/><br/><br/>");
sb.append("<table style=\"width:100%; border: 0 !important;\">");
sb.append("<tr>");
sb.append("<td style=\"border: 0 !important; width:33%;\"><p>"+astraPdca_CompanyData.getLEFTBOTTOM()+"<br/>"+astraPdca_CompanyData.getLEFTBOTTOMTITLE()+"<br/>"+astraPdca_CompanyData.getLEFTBOTTOMCOMPANY()+"</p></td>");
sb.append("<td style=\"border: 0 !important; width:33%;\"><p>"+astraPdca_CompanyData.getMIDBOTTOM()+"<br/>"+astraPdca_CompanyData.getMIDBOTTOMTITLE()+"<br/>"+astraPdca_CompanyData.getMIDBOTTOMCOMPANY()+"</p></td>");
sb.append("<td style=\"border: 0 !important; width:33%;\"><p>"+astraPdca_CompanyData.getRIGHTBOTTOM()+"<br/>"+astraPdca_CompanyData.getRIGHTBOTTOMTITLE()+"<br/>"+astraPdca_CompanyData.getRIGHTBOTTOMCOMPANY()+"</p></td>");
sb.append("</tr>");
sb.append("</table>");
sb.append("</div>");
		 
		 return sb.toString();
		 		
		
	}
	
	

}
