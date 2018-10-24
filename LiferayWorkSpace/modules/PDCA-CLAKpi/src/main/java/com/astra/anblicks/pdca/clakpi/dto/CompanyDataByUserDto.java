package com.astra.anblicks.pdca.clakpi.dto;

public class CompanyDataByUserDto {
	
	private long userId;
	private long companyId;
	private String CompanyName;
	private long settings_Id;
	private long year;
	private long periodId;
	private long moduleId;
	private String flag;
	
	public CompanyDataByUserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public long getYear() {
		return year;
	}
	public void setYear(long year) {
		this.year = year;
	}
	public long getPeriodId() {
		return periodId;
	}
	public void setPeriodId(long periodId) {
		this.periodId = periodId;
	}
	public long getModuleId() {
		return moduleId;
	}
	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public long getSettings_Id() {
		return settings_Id;
	}
	public void setSettings_Id(long settings_Id) {
		this.settings_Id = settings_Id;
	}
	public CompanyDataByUserDto(long userId, long companyId, String companyName, long settings_Id, long year,
			long periodId, long moduleId, String flag) {
		super();
		this.userId = userId;
		this.companyId = companyId;
		CompanyName = companyName;
		this.settings_Id = settings_Id;
		this.year = year;
		this.periodId = periodId;
		this.moduleId = moduleId;
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "CompanyDataByUserDto [userId=" + userId + ", companyId=" + companyId + ", CompanyName=" + CompanyName
				+ ", settings_Id=" + settings_Id + ", year=" + year + ", periodId=" + periodId + ", moduleId="
				+ moduleId + ", flag=" + flag + "]";
	}
	
	
	

	

}
