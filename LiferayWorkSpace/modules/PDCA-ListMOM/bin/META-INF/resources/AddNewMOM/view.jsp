<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.astra.anblicks.pdca.service.AstraPdca_CompanyDataLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.astra.anblicks.pdca.model.AstraPdca_CompanyData"%>
<%@ include file="/AddNewMOM/init.jsp" %>


<%
String meetingId="";
if( PortalUtil.getOriginalServletRequest(request).getParameter("meetingId") != null){
	meetingId=PortalUtil.getOriginalServletRequest(request).getParameter("meetingId");
}
%>

<div class="row">  <div class="col-md-12"><h4>Minutes of Meeting - Add New MOM</h4></div> </div>
  <form class="form-horizontal" >
  <div class="row generalInfoborder" > 
  <div class="col-md-6"> 
  <div class="form-group">
    <label class="control-label col-sm-4" for="company" >Meeting Date: <span class="mandatatory">*</span></label>
    <div class="col-sm-6">
       <div class='input-group date'>
                   	<input  class="form-control" type="text" id="meetingdate" name="meetingdate"   />
                 
                       
                  
                </div>	  
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-4" for="companyName">Type: <span class="mandatatory">*</span></label>
    <div class="col-sm-4"> 
     
<select id="type" class="form-control">
<option value=""> Select Type</option>
<option value="corporate"> Corporate</option>
<option value="monthly"> Monthly</option>
<option value="financial">Financial </option>
<option value="project">Project </option>
</select>
    </div>
    
      <div class="col-sm-2"> 
     
<input  class="form-control" type="number" id="typeid" min="1" style="width: 50px;"/>
    </div>
  </div>
  <div class="form-group"> 
        <label class="control-label col-sm-4" for="GroupName">Group Name: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"> 
      <input type="text" class="form-control" id="GroupName" placeholder="Enter Group Name ">
    </div>
  </div>

  <div class="form-group"> 
        <label class="control-label col-sm-4" for="CompanyName">Company Name: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"> 
          
<select id="copmanyName" class="form-control">
<option value=""> Company Name</option>
<%List<AstraPdca_CompanyData> list=AstraPdca_CompanyDataLocalServiceUtil.getAstraPdca_CompanyDatas(0, AstraPdca_CompanyDataLocalServiceUtil.getAstraPdca_CompanyDatasCount());
  for(AstraPdca_CompanyData val:list){ %>
	 <option value="<%=val.getCompanyId()%>"><%=val.getCompanyName()%></option> 
  <%}%>
</select>
    </div>
  </div>

  </div> 
    <div class="col-md-6"> 
  <div class="form-group">
    <label class="control-label col-sm-4" for="company">Time: <span class="mandatatory">*</span></label>
    <div class="col-sm-4">
      <input type="text" class="form-control" id="time" placeholder="Enter Time">
    </div>
    <div class="col-sm-2">
		    
		<select id="ampm" class="form-control">
		<option value="am"> AM</option>
		<option value="pm">PM</option>
		</select >
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-sm-4" for="performance">Performance: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"> 
      <input type="text" class="form-control" id="performance" placeholder="Enter Performance">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label col-sm-4" for="Participants">Participants: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"> 
      <input type="text" class="form-control" id="participants" placeholder="Enter Participants">
    </div>
  </div>
  
  
    <div class="form-group">
    <label class="control-label col-sm-4" for="Participants">Place: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"> 
      <input type="text" class="form-control" id="place" placeholder="Enter Place">
    </div>
  </div>
  </div>
    </div>
	
	
<div class="row generalInfoborder" > 

 <div class="row" style="display: none" id="addpdDIv"> 
 <div class="col-md-5"> 
      <div class="form-group">
    <label class="control-label col-sm-4" for="Participants">Point Discussion: <span class="mandatatory">*</span></label>
    <div class="col-sm-5"> 
      <input type="text" class="form-control pdnotes " id="pintdis" placeholder="Enter Point Discussion" >
    </div>
  </div>
    </div>
    <div class="col-md-5"> 
      <div class="form-group">
    <label class="control-label col-sm-4" for="Participants">Notes: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"> 
       <input type="text" class="form-control pdnotes " id="notes" placeholder="Enter  Notes"> 
 <!--   <textarea   class="form-control" id="notes" placeholder="Enter Place">
</textarea> -->
    </div>
  </div>
    </div>
    
    <div class="col-md-2"> 
    
    <%if(meetingId==""){ %> <button type="button" class="btn btn-default btn-sm" onclick="addpointdis()">Save </button>
    <%}else{ %>
    <button type="button" class="btn btn-default btn-sm" onclick="addpontsInDB()">Save </button>
    <% }%>
    </div>
    </div>
  <div class="col-md-12"> 
  
	 <div class="col-md-12">  <button type="button" class="btn btn-default btn-sm" onclick="showaddponts();">
          <span class="glyphicon glyphicon-plus"></span> Add New Point
        </button> 
        </div>
	   

    </div>
  </div>
 
	
</form>

<div class="row" style="display: none;" id="datTableId">

 <table class="ModaltradingprofitDataGrid_" class="table-responsive  table-bordered table-hover" cellspacing="0" width="100%">
			  <thead>
		        <tr>
		            <th>Point Discussion</th>
		            <th>Notes</th>
		  
		            
		        </tr>
</table>

</div>
<div class="row" style="padding-top:10px;">
<div class="col-md-12"> 

<div class="col-md-8">

</div>
<div class="col-md-4">
<div class="col-md-6">
<%if(meetingId==""){ %>
<button type="button" class="btn btn-info" onclick="saveMOM('addMOM')">Save</button>
<%}else{ %>
<button type="button" class="btn btn-info" onclick="saveMOM('updateMOM')">Update</button>

<%} %>
</div>
<div class="col-md-6">

<a  href="/group/astrapdca/list-mom" class="btn btn-info ">Cancel</a>

</div>
</div>

</div>

</div>


<style>
.mandatatory{
color:red
}
input#meetingdate{
      background-image: url(https://image.flaticon.com/icons/png/128/42/42446.png);
    background-size: 22px 26px;
    background-repeat: no-repeat;
    text-indent: 20px;
    background-position-x: right;
    width: 288px;
     cursor: pointer;
}

.generalInfoborder{

    padding-top: 10px;}
	
	.clasingnOffSeprating{

    padding-top: 15px;
	padding-bottom: 15px;
	padding-left: 15px;
	padding-right: 15px;
	
	}
</style>


  <script type="text/javascript">
  
  var ModaltradingprofitDataGrid=null;
  var meetingId ="<%=meetingId%>";

  ModaltradingprofitDataGrid = $('.ModaltradingprofitDataGrid_').DataTable( {
  		    "showNEntries" : false,
  		    "bInfo" : false,
  		     searching: false,
  		    "bLengthChange": false,
  		    "bPaginate": false,
  		    "ordering": false,
          data:[], 
  	    columns: [
  		 {data: "pintdis" ,className:	'pointdiscussion',},
  		{data: "notes" , className:	'notes',}],
  		columnDefs: [{targets: 0, type: "pintdis"},
  			{   targets: 1,type: "notes"}
  		  ]
     	});
  $('.ModaltradingprofitDataGrid_').addClass("table-bordered");
var pdId;
  if(meetingId !=""){
	  $('.ModaltradingprofitDataGrid_ tbody').on( 'click', '.pointdiscussion', function () {
		    var data = ModaltradingprofitDataGrid.row( $(this).parents('tr') ).data();
		    console.log("editamount" +data);
		    var dd=JSON.stringify(data);
		   var jsonParsedData=JSON.parse(dd);
		   console.log(jsonParsedData.pdId);
		    newInput(this,data,'amount');
		} );
	  
  }
  
  
  function closeInput(elm,data,type) {
	    var value = $(elm).find('input').val();
	    //alert(value);
	    console.log(value);
	    $(elm).empty().text(value);
	if(type=='notes'){
	//	savingTradingAmountNotes(type,data ,value);
	}else if(type=='amount'){
	//	savingTradingAmountNotes(type,data,value);
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

  function showaddponts(){
	  $("#addpdDIv").show();
	  
  }
  jsonObj = [];
  function addpointdis(){ 
             item = {}
             item["id"]=  Math.floor((Math.random() * 100) + 1);
	        item ["pintdis"] = $("#pintdis").val();
	        item ["notes"] = $("#notes").val();
	        jsonObj.push(item);
	        console.log(jsonObj);
	       ModaltradingprofitDataGrid.clear();	
	       ModaltradingprofitDataGrid.rows.add(jsonObj).draw();
	       ModaltradingprofitDataGrid.draw();
	       $("#datTableId").show();
	       $("#addpdDIv").hide();
	       $("#pintdis").val('');
	       $("#notes").val('');
  }
  var dateFormat = "mm/dd/yy",
	from = $( "#meetingdate" )
		.datepick({
		showOn: "button",
	buttonImage: "<%=request.getContextPath()%>/images/calendar.gif",
	buttonImageOnly: true,	
		});
  
 function saveMOM(val){
	 var data ={meetingdate: $("#meetingdate").val(),type:$("#type").val(),typeId: $("#typeid").val(),groupName: $("#GroupName").val(),companyId:$("#copmanyName").val(),
			time:$("#time").val(),ampm: $("#ampm").val(),performance: $("#performance").val(),participants: $("#participants").val(), place:$("#place").val(),
			pointDis:JSON.stringify(jsonObj),meetingId: meetingId};
	 console.log(data);
	 
		$.ajax({  
			url : '<%=listURL.toString()%>',
			data : {
					<portlet:namespace />cmd: val,
					<portlet:namespace />addmom: JSON.stringify(data),	
						},
			type : "POST",
			dataType : "json",
			success : function(data) { 
					console.log(data);
					if(data.sucess=="added"){
						 location.href = '/group/astrapdca/list-mom';	
					}
			},	
			error : function(response) {
				console.log("Error seen for updateValues");
				$("#<portlet:namespace />warning").show();
			}
		});
 }
 
 
 if(meetingId!=""){
	initializeMyNotifications();
	}
	function initializeMyNotifications(){
		console.log("meetingId-----" +meetingId);
		var val="loadData"
			$.ajax({  
				url : '<%=listURL.toString()%>',
				data : {
						<portlet:namespace />cmd: val,
						<portlet:namespace />meetingId: meetingId,		
							},
				type : "POST",
				dataType : "json",
				success : function(data) { 
						console.log(data);
						$("#meetingdate").val(data.meetingdate);
						$("#type").val(data.momType);
						$("#typeid").val(data.momTypeId);
						$("#GroupName").val(data.group);
						$("#copmanyName").val(data.companyId);
						$("#time").val(data.fromTime);
						$("#ampm").val(data.ampm);
						$("#performance").val(data.performanace);
						$("#participants").val(data.participants);
						$("#place").val(data.place);
					       ModaltradingprofitDataGrid.clear();	
					       ModaltradingprofitDataGrid.rows.add(data.pointDis).draw();
					       ModaltradingprofitDataGrid.draw();
					       $("#datTableId").show();
					if(data.sucess=="added"){
					}
				},	
				error : function(response) {
					console.log("Error seen for updateValues");
					$("#<portlet:namespace />warning").show();
				}
			});
		
	}
	
	function addpontsInDB(){
		$("#datTableId").show();
		
		var data={meetingId:meetingId ,pointDis:$("#pintdis").val(),notes:$("#notes").val()};
		 console.log(data);
		 
			$.ajax({  
				url : '<%=listURL.toString()%>',
				data : {
						<portlet:namespace />cmd: 'piontDiscussionAdd',
						<portlet:namespace />createPointDis: JSON.stringify(data),	
							},
				type : "POST",
				dataType : "json",
				success : function(data) { 
						console.log(data);
						 ModaltradingprofitDataGrid.clear();	
					       ModaltradingprofitDataGrid.rows.add(data.pointDis).draw();
					       ModaltradingprofitDataGrid.draw();
					       $("#addpdDIv").hide();
					       $("#pintdis").val('');
					       $("#notes").val('');
						if(data.sucess=="added"){
						//	 location.href = '/group/astrapdca/list-mom';	
						}
				},	
				error : function(response) {
					console.log("Error seen for updateValues");
					$("#<portlet:namespace />warning").show();
				}
			});
		
	}
        </script>