<%@page import="com.astra.anblicks.pdca.service.AstraPdca_CompanyDataLocalServiceUtil"%>
<%@page import="com.astra.anblicks.pdca.model.AstraPdca_CompanyData"%>
<%@ include file="/init.jsp" %>
<%@page import="com.astra.anblicks.pdca.claddkpi.utils.AddKpiJsonUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.astra.anblicks.pdca.service.kpiLocalServiceUtil"%>
<%@page import="com.astra.anblicks.pdca.model.kpi"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.astra.anblicks.pdca.service.itemDescriptionLocalServiceUtil"%>
<%@page import="com.astra.anblicks.pdca.model.itemDescription"%>
<%@page import="com.astra.anblicks.pdca.service.typeLocalServiceUtil"%>
<%@page import="com.astra.anblicks.pdca.model.type"%>
<%@page import="com.astra.anblicks.pdca.service.companyLocalServiceUtil"%>
<%@page import="com.astra.anblicks.pdca.model.company"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%
kpi kpi_ =null;
String kpiid="";
String tradingProftData="";
String periodId="";
String type="";
if( PortalUtil.getOriginalServletRequest(request).getParameter("kpiId") != null){
 kpi_=kpiLocalServiceUtil.getkpi(Long.parseLong( PortalUtil.getOriginalServletRequest(request).getParameter("kpiId")));
 kpiid=PortalUtil.getOriginalServletRequest(request).getParameter("kpiId");
  periodId=PortalUtil.getOriginalServletRequest(request).getParameter("Period");
  if(Long.parseLong(periodId)!=0l && type!="Financial" ){
  tradingProftData= AddKpiJsonUtil.tradingProfitJson(Long.parseLong(periodId),kpi_.getCompanyId(),kpi_.getYear());
}}

Boolean isAdmin= (Boolean) request.getAttribute("isAdmin");
%>


<div class="row" style="background-color:#f7f9f9;"> 

<div class="col-md-6">
<div class="col-md-12"> 
<div  class="col-md-4" > <label>Company:</label></div>

<div  >
<select id="company" name="company" required="required" class="allinputs">
        <option value="">Select Company</option>

<% if(isAdmin){
List<AstraPdca_CompanyData> companyList_=AstraPdca_CompanyDataLocalServiceUtil.getAstraPdca_CompanyDatas(0, AstraPdca_CompanyDataLocalServiceUtil.getAstraPdca_CompanyDatasCount());
for( AstraPdca_CompanyData val_:companyList_){%>
<option value="<%=val_.getCompanyId()%>"><%=val_.getCompanyName() %></option>

	<% }}%>
 </select>
</div>
</div>

<div class="col-md-12" style="padding-top: 10px;"> 
<div  class="col-md-4" > <label>Type:   </label></div>
<div><select id="type" name="type" required="required" class="allinputs">
       <option value="">Select Type</option>
        <%List<type> typeList=typeLocalServiceUtil.gettypes(0, typeLocalServiceUtil.gettypesCount()); if(typeList.size()>0){
        	for(type val:typeList){ 
 %>
         	  <option value="<%=val.getTypeId()%>"><%=val.getTypeName() %></option>
        <%}} %>
 </select> </div>
 </div>
 <div class="col-md-12" style="padding-top:10px">
 <div class="col-md-4">
<label>Weight(%):</label> </div> 
<div class="col-md-8" >
<input class="allinputs" style="margin-left: -14px;" type="text" id="weight" name="weight" required="required"/>
</div>
</div>

 <div class="col-md-12" style="padding-top:10px">
 <div class="col-md-4">

<label>Target:</label>
</div>
<div class="col-md-8" >
<input  class="allinputs" style="margin-left: -14px;"  type="text" id="target" name="target" required="required"/></div>
</div>
</div>


<div class="col-md-6"> 
<div  class="col-md-12">
<div class="col-md-4"> 
<label>Year: </label></div>
<div class="col-md-8">
<select  class="allinputs" id="year" name="year" required="required">
<option value="">Select year</option>
       <% if(isAdmin){ %>
         <option value="2018">2018</option>
         <option value="2017">2017</option>
          <option value="2016">2016</option>
           <option value="2015">2015</option>
            <option value="2014">2014</option>
            <%} else { %>
            <option value="2018" >2018</option>
            <%} %>
            
 </select>
</div></div>

<div style="padding-top:10px;"  class="col-md-12" > 
<div  class="col-md-4"> 
<label>Item Description:</label>
</div>
<div class="col-md-4">
<select class="allinputs"  id="item" name="item"  required="required" style="width:120px">
         <option value="">Select Item</option>
          <%List<itemDescription> itemDesList=itemDescriptionLocalServiceUtil.getitemDescriptions(0, itemDescriptionLocalServiceUtil.getitemDescriptionsCount());if(itemDesList.size()>0){
        	  for(itemDescription val:itemDesList){%>
        	   <option value="<%=val.getItemDescriptionId()%>"><%=val.getItemDescriptionName() %></option>
          <%} }%>
            </select>
            
            
</div>
<div  class="col-md-4" style="display: none;" id="_ItemDescNonTradngDiv">
<input type="text"  style="width:120px" id="_ItemDescNonTradng" name="_ItemDescNonTradng" /></div>
</div>

<div   style="padding-top:10px;" class="col-md-12"  > 
<div  class="col-md-4">
<label>Unit: </label>
</div>
<div class="col-md-8"> <input  class="allinputs" type="text" id="unit" name="unit" required="required"/></div>

                                 </div>
<div   style="padding-top:10px;" class="col-md-12"  > 
<div class="col-md-4" >

<label>Achivement Formula: </label></div>
<div class="col-md-8">
<select class="allinputs"  style="display: none;" id="achivementformula" name="achivementformula" required="required">
                                 </select>
                                 </div>
              </div>                   
</div>
</div>


<div class="row"  id="ytdoladiv_" style=" display:none;  margin-top: 13px;background-color: #dfe5df;">
<div class="col-md-6">
<div class="col-md-12" style="padding-top:10px;" >
 <div class="col-md-4"> Period:</div>
 <div > <input  class="allinputs" type="text" id="_Tradingperiod" name="_Tradingperiod" required="required"/></div>
 
</div>

<div class="col-md-12" style="padding-top:10px;" >
 <div class="col-md-4"> OL:</div>
 <div > <input style="width:100px"  id="nontradingInput" type="text"  required="required" onblur="nontradingprofitInput('nontradingprofit');"/>
  <button type="button" class="btn btn-info tradingproft_"  onclick="editTradingProfit();">Edit Trading Profit</button>
 </div>  
 
</div>
<div class="col-md-12" style="padding-top:10px;" >
 <div class="col-md-4"> CLA Point:</div>
 <div> <input  class="allinputs"  type="text" id="_clapoint" name="_clapoint" required="required"/></div>
 
</div>
</div>

<div class="col-md-6">
<div class="col-md-12" style="padding-top:10px;"  style="padding-top:10px;" >
 <div class="col-md-4"> YTD:</div>
 <div class="col-md-8" > <input  class="allinputs"  type="text" id="_ytd" name="_ytd" required="required"/></div>
 
</div>

<div class="col-md-12" style="padding-top:10px;" >
 <div class="col-md-4"> Achievement:</div>
 <div class="col-md-8" > <input class="allinputs"  type="text" id="_achievement" name="_achievement" required="required"/></div>  
 
</div>

</div>
</div>

<div class="row" style="margin-top: 15px; ">
<div class="col-md-6">
<div class="col-md-3">

<%if(kpiid==""){ %>
<button type="button"   class="btn btn-info" onclick="addkpi('add');">Save</button>
<%}else{ %> <button type="button"   class="btn btn-info" onclick="updatekpi('update');">Update</button> <%} %>
</div>
<div class="col-md-3"> <a  href="/group/astrapdca" class="btn btn-warning" >Cancel </a></div>
</div>
</div>


<script>
$("#type").on('change',function(){
	console.log("AS");
	if($("#type").val()=='2'){
		$("#_ItemDescNonTradngDiv").show();
		$("#item").val('2');
		var cmd = 'getachievementformula';
		$.ajax({  
			url : '<%=listURL.toString()%>',
			data : {
					<portlet:namespace />cmd: cmd,
					<portlet:namespace />item:'2',				
						},
			type : "POST",
			dataType : "json",
			success : function(data) { 
					console.log(data);
				      $("#achivementformula").empty(); 
					  $('#achivementformula').append($("<option></option>") .attr("value","").text("Select Forumla"));
					  $.each(data.kpi_Data,function(key,value)
					         {
					           var   option = $('<option />').val(value.achievemedId).text(value.achievementFormulaName);
					        $("#achivementformula").append(option);
					         }); 
					  $("#achivementformula").show();
			
			},	
			error : function(response) {
				console.log("Error seen for updateValues");
				$("#<portlet:namespace />warning").show();
			}
		});
	}
	else{
		$("#_ItemDescNonTradngDiv").hide();
		$("#item").val('');
		 $("#achivementformula").hide();
	}
	
});

$("#item").on('change',function(){
	var cmd = 'getachievementformula';
	$.ajax({  
		url : '<%=listURL.toString()%>',
		data : {
				<portlet:namespace />cmd: cmd,
				<portlet:namespace />item: $("#item").val(),				
					},
		type : "POST",
		dataType : "json",
		success : function(data) { 
				console.log(data);
			      $("#achivementformula").empty(); 
				  $('#achivementformula').append($("<option></option>") .attr("value","").text("Select Forumla"));
				  $.each(data.kpi_Data,function(key,value)
				         {
				           var   option = $('<option />').val(value.achievemedId).text(value.achievementFormulaName);
				        $("#achivementformula").append(option);
				         }); 
				  $("#achivementformula").show();
		
		},	
		error : function(response) {
			console.log("Error seen for updateValues");
			$("#<portlet:namespace />warning").show();
		}
	});
      });

function addkpi(val) { 
	$.ajax({  
		url : '<%=listURL.toString()%>',
		data : {
				<portlet:namespace />cmd: val,
				<portlet:namespace />company: $("#company").val(),		
				<portlet:namespace />type: $("#type").val(),		
				<portlet:namespace />weight: $("#weight").val(),		
				<portlet:namespace />target: $("#target").val(),		
				<portlet:namespace />year: $("#year").val(),		
				<portlet:namespace />item: $("#item").val(),	
				<portlet:namespace />_ItemDescNonTradng: $("#_ItemDescNonTradng").val(),
				<portlet:namespace />unit: $("#unit").val(),				
				<portlet:namespace />achivementformula: $("#achivementformula").val(),	
					},
		type : "POST",
		dataType : "json",
		success : function(data) { 
				console.log(data);
			if(data.sucess=="added"){
				 window.location.href = 'update-kpi';	
			}
		},	
		error : function(response) {
			console.log("Error seen for updateValues");
			$("#<portlet:namespace />warning").show();
		}
	});
} ;

var kpiids ="<%=kpiid%>";

var periodIdHide ="<%=periodId%>";
function updatekpi(val) { 
	
	$.ajax({  
		url : '<%=listURL.toString()%>',
		data : {
				<portlet:namespace />cmd: val,
				<portlet:namespace />kpiid: kpiids,	
				<portlet:namespace />peridId: periodIdHide,
				<portlet:namespace />_Tradingperiod: $("#_Tradingperiod").val(),		
				<portlet:namespace />ol: $("#nontradingInput").val(),		
				<portlet:namespace />clapoint: $("#_clapoint").val(),		
				<portlet:namespace />ytd: $("#_ytd").val(),		
				<portlet:namespace />achivement: $("#_achievement").val(),				
					},
		type : "POST",
		dataType : "json",
		success : function(data) { 
				console.log(data);
			if(data.sucess=="updated"){
				 window.location.href = 'update-kpi';	
			}
		},	
		error : function(response) {
			console.log("Error seen for updateValues");
		},
	});
} ;

if(kpiids!=""){
	//$("#ytdoladiv_").show();
initializeMyNotifications();
}
function initializeMyNotifications(){
	var kpiid ="<%=kpiid%>";
	
	var val="loadData"
	if(kpiid!=null){
		$.ajax({  
			url : '<%=listURL.toString()%>',
			data : {
					<portlet:namespace />cmd: val,
					<portlet:namespace />kpiid: kpiid,		
					<portlet:namespace />periodId: periodIdHide,	
						},
			type : "POST",
			dataType : "json",
			success : function(data) { 
					console.log(data);
					$("#company").val(data.company);
					$("#type").val(data.type);
					$("#weight").val(data.weight);
					$("#target").val(data.target);
					$("#year").val(data.year);
					$("#unit").val(data.unit);
					$("#item").val(data.itemDec);
					if(data.itemDec==2){
						$(".tradingproft_").hide();
					}else{$("#nontradingInput").prop('disabled', true);}
					
					$("#_Tradingperiod").val(data.TradingperiodText);
					$("#_ytd").val(data.ytd);
					$("#nontradingInput").val(data.ol);
					$("#_clapoint").val(data.clapoint);
					$("#_achievement").val(data.achivement);
					$("#_clapoint").prop('disabled', true);
					$("#_achievement").prop('disabled', true);
					
					$("#achivementformula").empty(); 
					  $('#achivementformula').append($("<option></option>") .attr("value","").text("Select Forumla"));
					  $.each(data.Onloadachivementformula,function(key,value)
					         {
					           var   option = $('<option />').val(value.achievemedId).text(value.achievementFormulaName);
					        $("#achivementformula").append(option);
					        
					         }); 
					  $("#achivementformula").show();
						$("#achivementformula").val(data.achivementformula);
						if(data.type==2){
						$("#_ItemDescNonTradngDiv").show();
						$("#_ItemDescNonTradng").val(data.ItemDescNonTradng);}
						
				
			},	
			error : function(response) {
				console.log("Error seen for updateValues");
				$("#<portlet:namespace />warning").show();
			}
		});
	}
}

function editTradingProfit(){
	$('#SelectAssociate').modal({ backdrop: 'static',
        keyboard: true, 
        show: true});
}
var periodIdHide ="<%=periodId%>";
console.log(periodIdHide);
$("#_Tradingperiod").prop('disabled', true);
if(periodIdHide==1){
	$("#_Tradingperiod").val('OL 1 FY');
}
if(periodIdHide==2){
	$("#_Tradingperiod").val('OL 2 FY');
}
if(periodIdHide==3){
	$("#_Tradingperiod").val('OL Adj.');
}
if(periodIdHide==4){
	$("#_Tradingperiod").val('OL 3 FY');
}
if(periodIdHide==5){
	$("#_Tradingperiod").val('Full Year');
}
if(periodIdHide!=0){

$("#target").prop('disabled', true);
$("#unit").prop('disabled', true);
$("#weight").prop('disabled', true);
$("#achivementformula").prop('disabled', true);
$( "#achivementformula" ).addClass("disabledDropdown");
$("#company").prop('disabled', true);
$("#type").prop('disabled', true);
$("#year").prop('disabled', true);
$("#item").prop('disabled', true);
$("#_ItemDescNonTradng").prop('disabled', true);
$( "#company" ).addClass("disabledDropdown");
$( "#type" ).addClass("disabledDropdown");
$( "#year" ).addClass("disabledDropdown");
$( "#item" ).addClass("disabledDropdown");
$("#ytdoladiv_").show();

}
if(periodIdHide==0){
	$("#ytdoladiv_").hide();
}



function nontradingprofitInput(val) {
	$.ajax({  
		url : '<%=listURL.toString()%>',
		data : {
				<portlet:namespace />cmd: val,
				<portlet:namespace />kpiid: kpiids,	
				<portlet:namespace />peridId: periodIdHide,
				<portlet:namespace />olinput: $("#nontradingInput").val(),
					},
		type : "POST",
		dataType : "json",
		success : function(data) { 
				console.log(data);		
			    $("#_achievement").val(data.OL_Achivement);		
				$("#_clapoint").val(data.Cla_Point);	
				
		},	
		error : function(response) {
			console.log("Error seen for updateValues");
			$("#<portlet:namespace />warning").show();
		}
	});
};


var isadmin= <%=isAdmin%>;
if(!isadmin){
	initializeAdminsettings();
}

function initializeAdminsettings(){
	$.ajax({  
		url : '<%=listURL.toString()%>',
		data : {
				<portlet:namespace />cmd: 'onloadAdminSettings',
					},
		type : "POST",
		dataType : "json",
		success : function(data) { 
				console.log(data.settingData);
				
			        	$("#year").empty(); 
				         $('#year').append($("<option></option>") .attr("value","").text("Select Year"));
				           var   option = $('<option />').val(data.settingData[0].year).text(data.settingData[0].year);
				         $("#year").append(option);
				
				$("#company").empty(); 
				  $('#company').append($("<option></option>") .attr("value","").text("Select Company"));
				  $.each(data.settingData,function(key,value)
				         {
				           var   option = $('<option />').val(value.companyId).text(value.companyName);
				        $("#company").append(option);
				        
				         }); 
		
		},	
		error : function(response) {
			console.log("Error seen for initializeAdminsettings");
		},
		
	});
}
</script>

<style>
.olainputcss{
style="width:100px;" }
.allinputs{
    width: 250px;
}

.edittradingprofit_position{
    padding-top: 70px;
    margin-left: 270px;}
    .disabledDropdown{
        background-color: #ebebe4;
    }
    .edittradingInput{
width: 250px;    }
    .modal-body {
    max-height: calc(100vh - 250px);
    overflow-y: auto;
}
</style>

<!-- All modal popup UI -->

<div class="modal fade edittradingprofit_position" id="SelectAssociate" style="  width: 70%; display:none;">
	<div class="modal-dialog" style=" width: 70%;">
	
			<div class="modal-content">
				<div class="modal-header">
						<div class="row">
						<div class="col-md-11">
						<h4 class="modal-title" >Update Trading Profit</h4>
						 </div>
						 <div class="col-md-1">  	<span data-dismiss="modal" style="cursor: pointer;" >x</span></div>
						</div>  	
						
				</div>
				<div class="modal-body">
					
					<table class="ModaltradingprofitDataGrid_ table table-bordered" style="width: 100%">
    <thead>
      <tr>
        <th style="width: 20%">Description</th>
        <th style="width: 10%">Amount</th>
        <th>Notes</th>
      </tr>
   </thead>
   
  </table>
				</div>
				<div class="modal-footer">
				<div class="row">
				<div class="col-md-10" style="  background-color: #c4d7f3;  height: 40px;    font-weight: bold;">
				<div class="col-md-6">Total Trading Profit </div>
				<div class="col-md-6 _TpSum" id="_TpSum">0</div>
				</div>
				<div class="col-md-2"> 
<button type="button" class="btn btn-primary"  data-dismiss="modal" onclick="calculation('cal')">Save</button>
</div>
</div>
      </div>
			</div>
	</div>
</div>

<script>

/* Trading profit table design */
 var tradingProftData= <%=tradingProftData%>;
 console.log(tradingProftData);

var ModaltradingprofitDataGrid=null;

ModaltradingprofitDataGrid = $('.ModaltradingprofitDataGrid_').DataTable( {
		    "showNEntries" : false,
		    "bInfo" : false,
		     searching: false,
		    "bLengthChange": false,
		    "bPaginate": false,
		    "ordering": false,
        data:tradingProftData, 
	    columns: [
		{ data: "title" },
		{ data: "amount",
		className:	'editamount',},
		{ data: "notes",
			className:	'editnotes',},
		],
		
		columnDefs: [{
			targets: 0,
			type: "title"},
		
			{targets: 1,
				type: "amount"},
				
				{   targets: 2,
					type: "notes"
				}
			
		]
    
	});	 
$("table td").dblclick(function () {
 //   newInput(this);
console.log("asdasdf");
});

var tradingproftid;
var periodId;
var titleId;
$('.ModaltradingprofitDataGrid_ tbody').on( 'click', '.editamount', function () {
    var data = ModaltradingprofitDataGrid.row( $(this).parents('tr') ).data();
   // console.log("editamount");
    
    tradingProfitId=data.tradingProfitId;
    periodId=data.period;
    titleId=data.titleId;
    newInput(this,data,'amount');
} );
$('.ModaltradingprofitDataGrid_ tbody').on( 'click', '.editnotes', function () {
    var data = ModaltradingprofitDataGrid.row( $(this).parents('tr') ).data();
   // console.log("editnotes");
   // console.log(data.amount);
    tradingproftid=data.tradingProfitId;
    periodId=data.period;
    titleId=data.titleId;
    newInput(this,data,'notes');

} );

function closeInput(elm,data,type) {
    var value = $(elm).find('input').val();
    //alert(value);
   // console.log(value);
    $(elm).empty().text(value);
if(type=='notes'){
	savingTradingAmountNotes(type,data ,value);
}else if(type=='amount'){
	savingTradingAmountNotes(type,data,value);
}
    $(elm).bind("dblclick", function () {
        newInput(elm);
    });
}  
        
function newInput(elm,data,type) {
    $(elm).unbind('dblclick');

    var value = $(elm).text();
    $(elm).empty();
    
    $("<input>")
        .attr('type', 'text')
        .val(value)
        .blur(function() {
            closeInput(elm,data,type);
        })
        .appendTo($(elm))
        .focus();
}

function calculation(val){
	
	$.ajax({  
		url : '<%=listURL.toString()%>',
		data : {
				<portlet:namespace />cmd: val,
				<portlet:namespace />kpiid: kpiids,	
				<portlet:namespace />peridId: periodIdHide,	
					},
		type : "POST",
		dataType : "json",
		success : function(data) { 
				console.log(data);
				$("#nontradingInput").val(data.OLFY);		
			    $("#_achievement").val(data.OL_Achivement);		
				$("#_clapoint").val(data.Cla_Point);	
				
		},	
		error : function(response) {
			console.log("Error seen for updateValues");
			$("#<portlet:namespace />warning").show();
		}
	});
} ;

function savingTradingAmountNotes(type,data,newvalue){
	console.log("type-->>>>>>"+type);
	console.log("newvalue-->>"+newvalue);
	
		$.ajax({  
			url : '<%=listURL.toString()%>',
			data : {
					<portlet:namespace />cmd: type,
					<portlet:namespace />newvalue: newvalue,	
					<portlet:namespace />periodId: periodId,	
					<portlet:namespace />titleId: titleId,	
					<portlet:namespace />tradingProfitId: tradingProfitId,	
						},
			type : "POST",
			dataType : "json",
			success : function(data) { 
					console.log(data);
			},	
			error : function(response) {
				console.log("Error seen for updateValues");
				$("#<portlet:namespace />warning").show();
			}
		});
	} ;
	
	function savingTradingAmountNotes(type,data,newvalue){
		console.log("type-->>>>>>"+type);
		console.log("newvalue-->>"+newvalue);
		
			$.ajax({  
				url : '<%=listURL.toString()%>',
				data : {
						<portlet:namespace />cmd: type,
						<portlet:namespace />newvalue: newvalue,	
						<portlet:namespace />periodId: periodId,	
						<portlet:namespace />titleId: titleId,	
						<portlet:namespace />tradingProfitId: tradingProfitId,	
							},
				type : "POST",
				dataType : "json",
				success : function(data) { 
						console.log(data);
						if(data.key == "amount"){
						$('div._TpSum').text(data.TradingProfitSum);
						}
				},	
				error : function(response) {
					console.log("Error seen for updateValues");
					$("#<portlet:namespace />warning").show();
				}
			});
		} ;
		


</script>