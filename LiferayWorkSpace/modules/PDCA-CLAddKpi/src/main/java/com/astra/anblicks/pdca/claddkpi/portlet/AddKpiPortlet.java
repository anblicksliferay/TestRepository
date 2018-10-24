package com.astra.anblicks.pdca.claddkpi.portlet;




import com.astra.anblicks.pdca.claddkpi.dto.CompanyDataByUserDto;
import com.astra.anblicks.pdca.claddkpi.services.sql.PdcaMySqlConnection;
import com.astra.anblicks.pdca.claddkpi.services.sql.PdcaSqlQueries;
import com.astra.anblicks.pdca.claddkpi.utils.CLACalculations;

/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.astra.anblicks.pdca.model.achivementFormula;
import com.astra.anblicks.pdca.model.cla_kpi;
import com.astra.anblicks.pdca.model.kpi;
import com.astra.anblicks.pdca.model.pdca_AdminSettings;
import com.astra.anblicks.pdca.model.period;
import com.astra.anblicks.pdca.model.tradingProfit;
import com.astra.anblicks.pdca.service.achivementFormulaLocalServiceUtil;
import com.astra.anblicks.pdca.service.cla_kpiLocalServiceUtil;
import com.astra.anblicks.pdca.service.kpiLocalServiceUtil;
import com.astra.anblicks.pdca.service.pdca_AdminSettingsLocalServiceUtil;
import com.astra.anblicks.pdca.service.periodLocalServiceUtil;
import com.astra.anblicks.pdca.service.tradingProfitLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
			"com.liferay.portlet.display-category=AstraPDCA",
			"com.liferay.portlet.instanceable=true",
			"javax.portlet.display-name=PDCA-Add-Kpi",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class AddKpiPortlet extends MVCPortlet {
	
	
	public static Connection conn = PdcaMySqlConnection.getConnection();
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
	    
	   
		 ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		 
		 PermissionChecker permissionChecker =
				    themeDisplay.getPermissionChecker();
		/* logger.info( themeDisplay.getUser().getUserId());
		 DynamicQuery dq=company_userLocalServiceUtil.dynamicQuery();
		 dq.add(PropertyFactoryUtil.forName("Pdca_userId").eq(themeDisplay.getUser().getUserId()));
			List<company_user> userCompanysList=company_userLocalServiceUtil.dynamicQuery(dq);
			JSONObject json   = JSONFactoryUtil.createJSONObject();          
          if(userCompanysList.size()>0){for(company_user val:userCompanysList){
        	  logger.info("user defined"+val.getCompanyId());
          }}
           DynamicQuery dqModule=pdca_AdminSettingsLocalServiceUtil.dynamicQuery();
           dqModule.add(PropertyFactoryUtil.forName("moduleId").eq(1l));
           List<pdca_AdminSettings> moduleList=pdca_AdminSettingsLocalServiceUtil.dynamicQuery(dqModule);
	    	JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

           if(moduleList.size()>0){
        	   json.put("CLA", true);
        	   json.put("period", moduleList.get(0).getPeriodId());
        	   json.put("year", moduleList.get(0).getYear());
        	   for(pdca_AdminSettings val:moduleList){ 
        		   logger.info("main"+val.getCompanyId());
        		   for(company_user usercompanyModel:userCompanysList){
        			   if(val.getCompanyId()==usercompanyModel.getCompanyId()){
        			    	jsonArray.put(val.getCompanyId());
        				 
        				   
        			   }
        	          }
        	   }
        	   json.put("companyList", jsonArray);
           }
           else{
        	   json.put("CLA", false);
        	   json.put("period","");
        	   json.put("year", "");
        	   json.put("companyList", "[]");
           }
           logger.info(json);*/
          // System.out.println("cccc"+list);
	/*	 renderRequest.setAttribute("isAdmin", permissionChecker.isOmniadmin());
			super.doView(renderRequest, renderResponse);*/
		 
		
		renderRequest.setAttribute("isAdmin", permissionChecker.isOmniadmin());
		super.doView(renderRequest, renderResponse);
	}

	
	 public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException
  {
				    String cmd = ParamUtil.getString(resourceRequest, "cmd");
				    if (cmd.equalsIgnoreCase("add")) {
					 try {
						 ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
						 kpi _kpi = kpiLocalServiceUtil.createkpi(CounterLocalServiceUtil.increment());
						  _kpi.setCompanyId(Long.parseLong(resourceRequest.getParameter("company")));
						 _kpi.setTypeId(Long.parseLong(resourceRequest.getParameter("type")));
						 _kpi.setWeight( Long.parseLong(resourceRequest.getParameter("weight")));
						 _kpi.setTarget(Long.parseLong(resourceRequest.getParameter("target")));
						 _kpi.setYear(Long.parseLong(resourceRequest.getParameter("year")));
						 _kpi.setItemDescriptionName(resourceRequest.getParameter("item"));
						 _kpi.setUnit(resourceRequest.getParameter("unit"));
						 _kpi.setAchivementFormulaId(Long.parseLong(resourceRequest.getParameter("achivementformula"))); 
						 //_kpi.setCompanyId(themeDisplay.getCompanyId());  Here should insert site
						 _kpi.setUserId(themeDisplay.getUser().getUserId());
						 _kpi.setItemDescriptionValue(ParamUtil.getString(resourceRequest, "_ItemDescNonTradng"));
						 _kpi.setUserName(themeDisplay.getUser().getFullName());
						 _kpi.setCreateDate(new Date());
						 _kpi.setModifiedDate(new Date());
						 kpi addkpi = kpiLocalServiceUtil.addkpi(_kpi);
						 if(resourceRequest.getParameter("item").equals("1")){
							 createTradeProfitObjectsBasedOnPeriods(addkpi);
						 }
						 createcla_kpiObjectsBasedOnPeriod(addkpi);
						  JSONObject json = JSONFactoryUtil.createJSONObject();
						  json.put("sucess", "added");
		        		 writeJSON(resourceRequest, resourceResponse,json);
					} catch (Exception e) {
						 logger.error(e);
						    JSONObject json = JSONFactoryUtil.createJSONObject();
					        json.put("error", "error");
					        writeJSON(resourceRequest, resourceResponse, json);			
					}
				    }
				    else if(cmd.equalsIgnoreCase("update")){
				    	
							 
							try {
								kpi	kpi_ = kpiLocalServiceUtil.getkpi(Long.parseLong(resourceRequest.getParameter("kpiid")));
								period period_ = periodLocalServiceUtil.getperiod(Long.parseLong(resourceRequest.getParameter("peridId")));
								cla_kpi cla_kpi = getCla_Kpi(kpi_,period_);
								cla_kpi.setYtd(Long.parseLong(resourceRequest.getParameter("ytd")));
								cla_kpi.setClaPoint(Double.parseDouble(resourceRequest.getParameter("clapoint")));
								cla_kpi.setOl(Double.parseDouble(resourceRequest.getParameter("ol")));
								cla_kpi.setAchivement(Double.parseDouble(resourceRequest.getParameter("achivement")));
								cla_kpi.setPeroidInput(ParamUtil.getString(resourceRequest, "_Tradingperiod"));
								cla_kpiLocalServiceUtil.updatecla_kpi(cla_kpi);					
								 JSONObject json = JSONFactoryUtil.createJSONObject();
								  json.put("sucess", "updated");
								  writeJSON(resourceRequest, resourceResponse, json);
							} catch (NumberFormatException | PortalException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								 JSONObject json = JSONFactoryUtil.createJSONObject();
							     json.put("error", "error");
							     writeJSON(resourceRequest, resourceResponse, json);	
							}
						
				    	
				    }
		else if(cmd.equalsIgnoreCase("getachievementformula")){
						try {
							DynamicQuery formualsDQ = achivementFormulaLocalServiceUtil.dynamicQuery();
					    	formualsDQ.add(PropertyFactoryUtil.forName("itemDescriptionId").eq(Long.parseLong(resourceRequest.getParameter("item")) ));
							List<achivementFormula> achivementFormulaList=achivementFormulaLocalServiceUtil.dynamicQuery(formualsDQ);
							if(achivementFormulaList.size()>0){
								JSONObject json = JSONFactoryUtil.createJSONObject();
							    JSONArray jsonData = JSONFactoryUtil.createJSONArray();
							    for (achivementFormula afmodel_ : achivementFormulaList)
							    {
									try {
										jsonData.put(achievementTOJSON(afmodel_));
										
									} catch (Exception e) {
										 JSONObject jsonerror = JSONFactoryUtil.createJSONObject();
										 jsonerror.put("error", "error");
									        writeJSON(resourceRequest, resourceResponse, jsonerror);		
										e.printStackTrace();
									}
							    }
							    json.put("kpi_Data", jsonData);
							
							writeJSON(resourceRequest, resourceResponse,json);
							
							}	
							
						} catch (Exception e) {
							 JSONObject json = JSONFactoryUtil.createJSONObject();
						     json.put("error", "error");
						     writeJSON(resourceRequest, resourceResponse, json);	
						}
				
							 }
				    
		else if(cmd.equalsIgnoreCase("loadData")){
			
			try {
				kpi kpiMode_=kpiLocalServiceUtil.getkpi(Long.parseLong(resourceRequest.getParameter("kpiid"))); 
				JSONObject json   = JSONFactoryUtil.createJSONObject();          
		    	   json.put("kpiId", kpiMode_.getKpiId());
				    json.put("company", kpiMode_.getCompanyId());
				    json.put("type",kpiMode_.getTypeId());
				    json.put("weight", kpiMode_.getWeight());
				    json.put("target", kpiMode_.getTarget());
				    json.put("year",  kpiMode_.getYear());
				    json.put("itemDec",  kpiMode_.getItemDescriptionName());
				    json.put("ItemDescNonTradng",  kpiMode_.getItemDescriptionValue());
				    json.put("unit",  kpiMode_.getUnit());
				    json.put("achivementformula", kpiMode_.getAchivementFormulaId());
				    if(!resourceRequest.getParameter("periodId").equals("0")){
				    period period_ = periodLocalServiceUtil.getperiod(Long.parseLong(resourceRequest.getParameter("periodId")));
				    cla_kpi cla_kpi = getCla_Kpi(kpiMode_,period_);
					json.put("ytd", cla_kpi.getYtd());
					json.put("clapoint", cla_kpi.getClaPoint());
					json.put("ol", cla_kpi.getOl());
					json.put("achivement", cla_kpi.getAchivement());
					json.put("TradingperiodText", cla_kpi.getPeroidInput());
					}
					
				    json.put("Onloadachivementformula", onloadDropdownAF( kpiMode_.getItemDescriptionName()));
				   
				  /*  json.put("period",  period);
				    if(!claKpiList.isEmpty()){
				    json.put("CLAPoint",  claKpiList.get(0).getClaPoint());
				    json.put("Achivement",  claKpiList.get(0).getAchivement());
				    json.put("YTD",  claKpiList.get(0).getYtd());
				    json.put("OL1FY", claKpiList.get(0).getOl());
				    json.put("OL2FY", claKpiList.get(0).getOl());
				    json.put("OLAdj", claKpiList.get(0).getOl());
				    json.put("OL3FY", claKpiList.get(0).getOl());
				    json.put("OLFY",  claKpiList.get(0).getOl());
				    }
				    else {
				            json.put("CLAPoint",  "CLAPoint");
						    json.put("Achivement", "Achivement" );
						    json.put("YTD",  "YTD");
						    json.put("OL1FY", "OL1FY");
						    json.put("OL2FY", "OL2FY");
						    json.put("OLAdj", "OLAdj");
						    json.put("OL3FY", "OL3FY");
						    json.put("OLFY",  "OLFY");
				    	
				    }*/
				       writeJSON(resourceRequest, resourceResponse, json);
		       		  //  return json;	
			} catch (Exception e) {
				e.printStackTrace();
				logger.info(e);
				 JSONObject json = JSONFactoryUtil.createJSONObject();
			     json.put("error", "error");
			     writeJSON(resourceRequest, resourceResponse, json);	
			}
			
		}
else if(cmd.equalsIgnoreCase("amount")){
			
			logger.info(resourceRequest.getParameter("newvalue"));
			
			try {
				tradingProfit tradingProfit_=tradingProfitLocalServiceUtil.gettradingProfit(Long.parseLong(resourceRequest.getParameter("tradingProfitId")));
				switch (Integer.parseInt(resourceRequest.getParameter("titleId"))) {
				case 1:
					tradingProfit_.setNpat(Long.parseLong(resourceRequest.getParameter("newvalue")));
					break;
					
					case 2:
					tradingProfit_.setNetForex(Long.parseLong(resourceRequest.getParameter("newvalue")));
					break;
					
					case 3:
						tradingProfit_.setPpeDispos(Long.parseLong(resourceRequest.getParameter("newvalue")));

						break;
					case 4:
						tradingProfit_.setRevalutionOnPropertyInvestment(Long.parseLong(resourceRequest.getParameter("newvalue")));
						
						break;
					case 5:
						tradingProfit_.setInvestment(Long.parseLong(resourceRequest.getParameter("newvalue")));
						break;
					case 6:
						tradingProfit_.setTaxExpense(Long.parseLong(resourceRequest.getParameter("newvalue")));
						
						break;
					case 7:
						tradingProfit_.setImpairmentOnAsset(Long.parseLong(resourceRequest.getParameter("newvalue")));
						break;
					case 8:
						tradingProfit_.setOthers(Long.parseLong(resourceRequest.getParameter("newvalue")));
						break;
				default:
					break;
				}
				tradingProfit_ = tradingProfitLocalServiceUtil.updatetradingProfit(tradingProfit_);
				double tradingprofitsum = gettradingprofitsum(tradingProfit_);
				tradingProfit_.setTotalSum(tradingprofitsum);
				tradingProfitLocalServiceUtil.updatetradingProfit(tradingProfit_);
				 JSONObject json = JSONFactoryUtil.createJSONObject();
			     json.put("key", "amount");
			     json.put("TradingProfitSum",tradingprofitsum);
			     writeJSON(resourceRequest, resourceResponse, json);	
			} catch (NumberFormatException | PortalException e) {
				 JSONObject json = JSONFactoryUtil.createJSONObject();
			     json.put("error", "error");
			     writeJSON(resourceRequest, resourceResponse, json);				
			     logger.error(e);
			}
			
		}
		else if(cmd.equalsIgnoreCase("notes")){
			logger.info(resourceRequest.getParameter("newvalue"));
			
			try {
				tradingProfit tradingProfit_=tradingProfitLocalServiceUtil.gettradingProfit(Long.parseLong(resourceRequest.getParameter("tradingProfitId")));
				switch (Integer.parseInt(resourceRequest.getParameter("titleId"))) {
				case 1:
					tradingProfit_.setNotes_Npat(resourceRequest.getParameter("newvalue"));
					break;
					
					case 2:
					tradingProfit_.setNotes_NetForex(resourceRequest.getParameter("newvalue"));
					break;
					
					case 3:
						tradingProfit_.setNotes_ppeDispos(resourceRequest.getParameter("newvalue"));

						break;
					case 4:
						tradingProfit_.setNotes_RevalutiononPI(resourceRequest.getParameter("newvalue"));
						
						break;
					case 5:
						tradingProfit_.setNotes_Investment(resourceRequest.getParameter("newvalue"));
						break;
					case 6:
						tradingProfit_.setNotes_taxExpenses(resourceRequest.getParameter("newvalue"));
						
						break;
					case 7:
						tradingProfit_.setNotes_impartmentOnAsset(resourceRequest.getParameter("newvalue"));
						break;
					case 8:
						tradingProfit_.setNotes_others(resourceRequest.getParameter("newvalue"));
						break;
				default:
					break;
				}
				tradingProfit_ = tradingProfitLocalServiceUtil.updatetradingProfit(tradingProfit_);
				 JSONObject json = JSONFactoryUtil.createJSONObject();
			     json.put("key", "notes");
			     writeJSON(resourceRequest, resourceResponse, json);	
			} catch (NumberFormatException | PortalException e) {
				 JSONObject json = JSONFactoryUtil.createJSONObject();
			     json.put("error", "error");
			     writeJSON(resourceRequest, resourceResponse, json);				
			     logger.error(e);
			}

		}
		else if(cmd.equalsIgnoreCase("cal")) {

			try {
				String calculationData = CLACalculations.getClaCalculations(Long.parseLong(resourceRequest.getParameter("kpiid")), Long.parseLong(resourceRequest.getParameter("peridId")),StringPool.BLANK,"tradingProfit");
				 writeJSON(resourceRequest, resourceResponse, JSONFactoryUtil.createJSONObject(calculationData));
			} catch (NumberFormatException | PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(cmd.equalsIgnoreCase("nontradingprofit")) {
			try {
				String calculationData = CLACalculations.getClaCalculations(Long.parseLong(resourceRequest.getParameter("kpiid")), Long.parseLong(resourceRequest.getParameter("peridId")),resourceRequest.getParameter("olinput"),"nontradingProfit");
				writeJSON(resourceRequest, resourceResponse, JSONFactoryUtil.createJSONObject(calculationData));
			} catch (NumberFormatException | PortalException e) {
				// TODO: handle exception
			}
		}
	    else if(cmd.equalsIgnoreCase("onloadAdminSettings")){
	    	 ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
	    	try {
	    		JSONArray jsonArray=JSONFactoryUtil.createJSONArray();
		    	JSONObject json=JSONFactoryUtil.createJSONObject();
	    	  	List<CompanyDataByUserDto>  list_=PdcaSqlQueries.getCompanyDataBasedOnModuleId_UserId(conn, themeDisplay.getUser().getUserId(), 1l);
	    	  	pdca_AdminSettings getadminsettingModuleData = getadminsettingModuleData(1l);
	   	    	 if(list_.size()>0){
	   	   		 for(CompanyDataByUserDto model:list_){
	   	   			 JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
	   	   			 jsonObject.put("year",getadminsettingModuleData.getYear());
	   	   			 jsonObject.put("period", getadminsettingModuleData.getPeriodId());
	   	   			 jsonObject.put("companyId", model.getCompanyId());
	   	   			 jsonObject.put("companyName", model.getCompanyName());
	   	   			 jsonArray.put(jsonObject);
	   	   		 }
	   	   		 
	   	   	json.put("settingData", jsonArray);
	   	   		 
	   	   		 writeJSON(resourceRequest, resourceResponse, json);
	   	   	 } 					
			} catch (Exception e) {
				logger.error(e);
				   JSONObject json = JSONFactoryUtil.createJSONObject();
			        json.put("error", "storeDefault Unsuccessful");
			        writeJSON(resourceRequest, resourceResponse, json);
			}
	    }
 }
	 
	 
	 
 private double gettradingprofitsum(tradingProfit getTradingProfitObject) {
		 
		 double tradingProfit = getTradingProfitObject.getNpat() + getTradingProfitObject.getNetForex()
					+ getTradingProfitObject.getPpeDispos() + getTradingProfitObject.getRevalutionOnPropertyInvestment()
							+ getTradingProfitObject.getInvestment() + getTradingProfitObject.getTaxExpense()
							+ getTradingProfitObject.getImpairmentOnAsset()+getTradingProfitObject.getOthers();
			
			return tradingProfit;
		
	}
	

	  private pdca_AdminSettings getadminsettingModuleData(long moduleId) {
		  
		  DynamicQuery dynamicQuery=pdca_AdminSettingsLocalServiceUtil.dynamicQuery();
		  dynamicQuery.add(PropertyFactoryUtil.forName("moduleId").eq(moduleId));
		  List<pdca_AdminSettings> list_AdminSettings=pdca_AdminSettingsLocalServiceUtil.dynamicQuery(dynamicQuery);
		  
		  return list_AdminSettings.get(0);
			
		}

	 
	 private cla_kpi getCla_Kpi(kpi kpi_, period period_) {
		 
		 DynamicQuery dynamicQueryForCla_kpi = cla_kpiLocalServiceUtil.dynamicQuery();
		 dynamicQueryForCla_kpi.add(PropertyFactoryUtil.forName("kpiId").eq(kpi_.getKpiId()) );
			Criterion reqcriterion = RestrictionsFactoryUtil.eq("periodId",period_.getPeriodId());
			dynamicQueryForCla_kpi.add(reqcriterion);
			List <cla_kpi> cla_kpi = cla_kpiLocalServiceUtil.dynamicQuery(dynamicQueryForCla_kpi);
			return cla_kpi.get(0);
		
		
	}


	


	private void createcla_kpiObjectsBasedOnPeriod(kpi addkpi) {
		List<period> getperiods = periodLocalServiceUtil.getperiods(0, periodLocalServiceUtil.getperiodsCount());
		for(period p : getperiods) {
			cla_kpi cla_kpi = cla_kpiLocalServiceUtil.createcla_kpi(CounterLocalServiceUtil.increment());
			cla_kpi.setKpiId(addkpi.getKpiId());
			cla_kpi.setPeriodId(p.getPeriodId());
			cla_kpi.setYtd(0);
			cla_kpi.setOl(0.00);
			cla_kpi.setClaPoint(0.00);
			cla_kpi.setAchivement(0.00);
			cla_kpiLocalServiceUtil.addcla_kpi(cla_kpi);
		}
		
	}


	private void createTradeProfitObjectsBasedOnPeriods(kpi addkpi) {
		List<period> getperiods = periodLocalServiceUtil.getperiods(0, periodLocalServiceUtil.getperiodsCount());
		for(period p : getperiods) {
			tradingProfit tradingProfit = tradingProfitLocalServiceUtil.createtradingProfit(CounterLocalServiceUtil.increment());
			tradingProfit.setPeriodId(p.getPeriodId());
			tradingProfit.setCompanyId(addkpi.getCompanyId());
			tradingProfit.setYear(addkpi.getYear());
			tradingProfit.setNpat(0.00);
			tradingProfit.setNetForex(0.00);
			tradingProfit.setPpeDispos(0.00);
			tradingProfit.setRevalutionOnPropertyInvestment(0.00);
			tradingProfit.setInvestment(0.00);
			tradingProfit.setTaxExpense(0.00);
			tradingProfit.setImpairmentOnAsset(0.00);
			tradingProfit.setOthers(0.00);
			tradingProfitLocalServiceUtil.addtradingProfit(tradingProfit);
		}
		
	}


	public static JSONObject achievementTOJSON(achivementFormula achivementFormula_) throws PortalException 
	  {
	           JSONObject json   = JSONFactoryUtil.createJSONObject();          
	    	   json.put("achievemedId", achivementFormula_.getAchivementFormulaId());
			   json.put("achievementFormulaName", achivementFormula_.getAchivementFormula());	     
	       		    return json;	
	  }
	 
	 
	 public  static JSONArray onloadDropdownAF( String val){
		 
		    DynamicQuery formualsDQ = achivementFormulaLocalServiceUtil.dynamicQuery();
	    	formualsDQ.add(PropertyFactoryUtil.forName("itemDescriptionId").eq(Long.parseLong(val)));
			List<achivementFormula> achivementFormulaList=achivementFormulaLocalServiceUtil.dynamicQuery(formualsDQ);
			JSONArray jsonData = JSONFactoryUtil.createJSONArray();
			JSONObject json  =null;
			if(achivementFormulaList.size()>0){
				   
			    for (achivementFormula afmodel_ : achivementFormulaList)
			    {	 json   = JSONFactoryUtil.createJSONObject();          
					    	   json.put("achievemedId", afmodel_.getAchivementFormulaId());
							   json.put("achievementFormulaName", afmodel_.getAchivementFormula());	   
								jsonData.put(json);

					}
			    
			}
			return jsonData;
			}

	
	 public static boolean restricTradingProfit(ResourceRequest resourceRequest){
		 boolean isUserHaveTradingProfit=false;
		 ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
 	       DynamicQuery dynamicQuery_kpi = kpiLocalServiceUtil.dynamicQuery();
Criterion criterion = null;
/*criterion = RestrictionsFactoryUtil.eq("companyId", ParamUtil.getLong(resourceRequest, "company"));
criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("year", ParamUtil.getLong(resourceRequest, "year")));
criterion = RestrictionsFactoryUtil.and(criterion,"userId",themeDisplay.getUser().getUserId());
criterion = RestrictionsFactoryUtil.and(criterion,"itemDescriptionName",1l);*/
dynamicQuery_kpi.add(criterion);

List <kpi> list_kpis = kpiLocalServiceUtil.dynamicQuery(dynamicQuery_kpi);

if(list_kpis.size() == 1) {
return true;
}
else {
return false;
}
		// return isUserHaveTradingProfit;
	 }
	 
	 
		private static Log logger = LogFactoryUtil.getLog(AddKpiPortlet.class.getName());

}
