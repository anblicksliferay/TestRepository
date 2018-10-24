package com.astra.anblicks.pdca.dto;

public class ReportForTpDto {
	
	private int rowindex;
	private String companyName;
	private double npat;
	private double netforex;
	private double ppedispos;
	private double revalutiononPi;
	private double investment;
	private double taxExpenses;
	private double impairmentonAsset;
	private double Others;
	private double total;
	private double tradingprofit;
	
	public ReportForTpDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportForTpDto(int rowindex, String companyName, double npat, double netforex, double ppedispos,
			double revalutiononPi, double investment, double taxExpenses, double impairmentonAsset, double others,
			double total, double tradingprofit) {
		super();
		this.rowindex = rowindex;
		this.companyName = companyName;
		this.npat = npat;
		this.netforex = netforex;
		this.ppedispos = ppedispos;
		this.revalutiononPi = revalutiononPi;
		this.investment = investment;
		this.taxExpenses = taxExpenses;
		this.impairmentonAsset = impairmentonAsset;
		Others = others;
		this.total = total;
		this.tradingprofit = tradingprofit;
	}

	public int getRowindex() {
		return rowindex;
	}

	public void setRowindex(int rowindex) {
		this.rowindex = rowindex;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getNpat() {
		return npat;
	}

	public void setNpat(double npat) {
		this.npat = npat;
	}

	public double getNetforex() {
		return netforex;
	}

	public void setNetforex(double netforex) {
		this.netforex = netforex;
	}

	public double getPpedispos() {
		return ppedispos;
	}

	public void setPpedispos(double ppedispos) {
		this.ppedispos = ppedispos;
	}

	public double getRevalutiononPi() {
		return revalutiononPi;
	}

	public void setRevalutiononPi(double revalutiononPi) {
		this.revalutiononPi = revalutiononPi;
	}

	public double getInvestment() {
		return investment;
	}

	public void setInvestment(double investment) {
		this.investment = investment;
	}

	public double getTaxExpenses() {
		return taxExpenses;
	}

	public void setTaxExpenses(double taxExpenses) {
		this.taxExpenses = taxExpenses;
	}

	public double getImpairmentonAsset() {
		return impairmentonAsset;
	}

	public void setImpairmentonAsset(double impairmentonAsset) {
		this.impairmentonAsset = impairmentonAsset;
	}

	public double getOthers() {
		return Others;
	}

	public void setOthers(double others) {
		Others = others;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTradingprofit() {
		return tradingprofit;
	}

	public void setTradingprofit(double tradingprofit) {
		this.tradingprofit = tradingprofit;
	}

	@Override
	public String toString() {
		return "ReportForTpDto [rowindex=" + rowindex + ", companyName=" + companyName + ", npat=" + npat
				+ ", netforex=" + netforex + ", ppedispos=" + ppedispos + ", revalutiononPi=" + revalutiononPi
				+ ", investment=" + investment + ", taxExpenses=" + taxExpenses + ", impairmentonAsset="
				+ impairmentonAsset + ", Others=" + Others + ", total=" + total + ", tradingprofit=" + tradingprofit
				+ "]";
	}
	
	

}
