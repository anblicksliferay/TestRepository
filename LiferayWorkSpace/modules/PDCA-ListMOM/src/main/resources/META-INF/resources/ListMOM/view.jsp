
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.astra.anblicks.pdca.service.AstraPdca_CompanyDataLocalServiceUtil"%>
<%@page import="com.astra.anblicks.pdca.model.AstraPdca_CompanyData"%>
<%@page import="java.util.List"%>
<%@ include file="/ListMOM/init.jsp" %>
<%
String listMOMData= (String) request.getAttribute("ListMOMData");
%>

  <form class="form-horizontal" >
  <div class="row generalInfoborder" > 
  <div class="col-md-6"> 
  <div class="form-group"> 
        <label class="control-label col-sm-4" for="CompanyName">Company: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"  class="companychosen_"> 
          
<!-- <select id="copmanyName" class="form-control">
 -->
 <select id="copmanyName" data-placeholder="Choose a Company" class="company_chosen_select"  style="height: 300px: width:500px;" tabindex="4">
 
<%List<AstraPdca_CompanyData> list=AstraPdca_CompanyDataLocalServiceUtil.getAstraPdca_CompanyDatas(0, AstraPdca_CompanyDataLocalServiceUtil.getAstraPdca_CompanyDatasCount());
  for(AstraPdca_CompanyData val:list){ %>
	 <option value="<%=val.getCompanyId()%>"><%=val.getCompanyName()%></option> 
  <%}%>
</select>
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
 </div> 
   </div>
	<div class="row">
	<div class="col-md-6" >
	<button type="button" class="btn btn-info">Show</button>
	</div>
	<div class="col-md-6" >
<a  href="/group/astrapdca/add-new-mom" class="btn btn-info ">Add New MOM </a>
	</div>
	
	</div>
</form>

<div class="row">

 <table class="devDataTablePhycial" class="table-responsive  table-bordered table-hover" cellspacing="0" width="100%">
			  <thead>
		        <tr>
		              <th style="width:7%"></th>
		              <th style="width:11%">Meeting Type </th>
		              <th style="width:20%">Company Name</th>
		                 <th style="width:12%">Group Name</th>
		              <th style="width:50%">Point Of Discussion With Notes</th>
		           
		        </tr>
</table>
</div>

<script>

var listMOMdata= <%=listMOMData%>;
//console.log(listMOMdata);


var devDataGrid=null;

	  devDataGrid = $('.devDataTablePhycial').DataTable( {
		  
		    dom: 'lBfrtip',
		  // "showNEntries" : false,
	
		   searching: false,
		   "bLengthChange": false,
		  order: [[0, 'desc'] ],
		  "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50,100, "All"]],  
        orderCellsTop: true,
        data:listMOMdata.listmom, 
	    columns: [
		{	
			title:			'',
			orderable:		true,
			data:			null, //editbutton  deleteButton
		defaultContent:
'<span class=" glyphicon glyphicon-edit editbutton" style="cursor: pointer;"> </span>   <span class="glyphicon glyphicon-trash deleteButton" style="cursor: pointer;">  </span><span class="glyphicon glyphicon-share shareMOM" style="cursor: pointer;"> </span>'
		
		},
		{data:"MeegtigType"},
		{data:"CompanyName"},
		{data:"Group"},
		{ data: "pointDis",
			  render: function (data, type, row) { 
				   			        var content = '<table class="insidetable">';
			             content += '<thead><tr>';
			             content += '</tr></thead><tbody>';
			             content += '<th>Point Of Discussoion</th>';
			             content += '<th >Notes</th>';
			             $.each(row.pointDis, function(i, item) {
			             content += '<tr data-id="' + item.pdId + '">'; 
			             content += '<td>' + item.PonintDiscussionName + '</td>';
			             content += '<td>' + item.notes + '</td>';
			             content += '</tr>';
			            });
			             content += '</tbody></table>';
	                 return content;	
			  },
		}
		],
		
		columnDefs: [{   targets: 0,
			type: "" ,
			 "searchable": false,
			 'sortable': false,
			 "orderable": false
			},
		{targets:1,type:"MeegtigType" },
		{targets:2,type:"CompanyName"},
		{targets:3,type:"Group"},
			{targets: 4,
				type: "pointDis"}
				
				
												
							
		]
    
	});	
	  var pdID;
	  var meetingId;
	  $('.devDataTablePhycial').addClass("table-bordered");
	  $('.insidetable').addClass("table-bordered");
	  $('.devDataTablePhycial tbody').on( 'click', '.shareMOM', function () {
		     var data = devDataGrid.row( $(this).parents('tr') ).data();
	        console.log("share"+ data.pdId_);
	        pdID=data.pdId_;
	        meetingId=data.MOMId;
	        var data1 = data.pointDis;
	        ModaltradingprofitDataGrid.clear();	
	        ModaltradingprofitDataGrid.rows.add(data1).draw();
	        ModaltradingprofitDataGrid.draw();
	 
	        $('#SelectAssociate').modal({ backdrop: 'static',
	            keyboard: true, 
	            show: true});
	       

	      //  $('#<portlet:namespace/>editid').val(data.kpiId);
		//  location.href="/group/astrapdca/addkpi?kpiId=".concat(data.kpiId)+"&Period=".concat(data.period)+"&companyId=not yet defined in table&type="+data.type;

	    } );
	//  $('.email_chosen_select', this).chosen();

	 // $(".email_chosen_select").chosen({width: "100%"});
	//  jQuery(".email_chosen_select").data("placeholder","Select Frameworks...").chosen({search_contains:true});
   
	  $('.devDataTablePhycial tbody').on( 'click', '.editbutton', function () {
	        var data = devDataGrid.row( $(this).parents('tr') ).data();
	        console.log("edit button");
	        console.log(data);
		  location.href="/group/astrapdca/add-new-mom?meetingId=".concat(data.MOMId)+"&Period=454qqq@#k56s5d&companyId=not yet defined in table&type=liferywindowstate";

	    } );
</script>

<!-- All modal popup UI -->

<div class="modal fade edittradingprofit_position" id="SelectAssociate" style="  width: 70%; display:none;">
	<div class="modal-dialog" style=" width: 70%;">
	
			<div class="modal-content">
				<div class="modal-header">
						<div class="row">
						<div class="col-md-11">
						<h4 class="modal-title" >Share MOM</h4>
						 </div>
						 <div class="col-md-1">  	<span data-dismiss="modal" style="cursor: pointer;" >x</span></div>
						</div>  	
						
				</div>
				
				
				 <form class="form-horizontal" >
			  <div class="row generalInfoborder" > 
			  <div class="col-md-12"> 
			  
			    <div class="form-group">
    <label class="control-label col-sm-4" for="company" >To: <span class="mandatatory">*</span></label>
    <div class="col-sm-6">
       <div class='input-group '  class="companychosen_">
                 <!--    <input type='text' class="form-control"  name="toEmail" id="toEmail"/> -->
                 
                 
                  <select id="toEmail"  class="form-contrl email_chosen_select"  data-placeholder="Choose a Email"   multiple   style="width: 200px;"  tabindex="5" >
 
<%List<User> userList=UserLocalServiceUtil.getUsers(0, UserLocalServiceUtil.getUsersCount());
  for(User val:userList){ %>
	 <option value="<%=val.getUserId()%>"><%=val.getEmailAddress()%></option> 
  <%}%>
</select>
             
             </div>	  
    </div>
  </div>
    <div class="form-group">
    <label class="control-label col-sm-4" for="company" >Subject: <span class="mandatatory">*</span></label>
    <div class="col-sm-6">
       <div class='input-group'>
                    <input type='text' class="form-control"  name="Subject" id="Subject"/>
                  
                </div>	  
    </div>
  </div>
  
      <div class="form-group">
    <label class="control-label col-sm-4" for="company" >Body: <span class="mandatatory">*</span></label>
    <div class="col-sm-6">
       <div class='input-group'>
                    <!-- <input type='text' class="form-control"  name="Subject" id="Subject"/> -->
                    <textarea rows="2" cols="30" class="from-control" id="body" name="body"></textarea>
                  
                </div>	  
    </div>
  </div>
			  </div>
			  </div>
			  </form>
				<div class="modal-body">
					
					<table class="ModaltradingprofitDataGrid_ table table-bordered" style="width: 100%">
    <thead>
      <tr>
        <th style="width: 20%">Point Of Discussion</th>
        <th>Notes</th>
      </tr>
   </thead>
   
  </table>
				</div>
				<div class="modal-footer">
				<div class="row">
				<div class="col-md-10">
				<div class="col-md-6"> <div class="col-md-2"> 
<button type="button" class="btn btn-primary"   onclick="sendEmailwithattachment()">Send</button>
</div></div>
				<div class="col-md-6"> </div>
				</div>
				<div class="col-md-2"> 
<button type="button" class="btn btn-primary"   onclick="addAttachment()">Add Attachment</button>
</div>
</div>
      </div>
			</div>
	</div>
</div>

<style>
.edittradingprofit_position{
    padding-top: 70px;
    margin-left: 270px;}
        .modal-body {
    max-height: calc(100vh - 438px);
    overflow-y: auto;
}
.chosen-container {
                                     max-height: 65px;
                                 }
</style>

<script>
$(".company_chosen_select").chosen({width: "100%"});
 $(".email_chosen_select").chosen({width: "100%"});

var ModaltradingprofitDataGrid=null;

ModaltradingprofitDataGrid = $('.ModaltradingprofitDataGrid_').DataTable( {
		    "showNEntries" : false,
		    "bInfo" : false,
		     searching: false,
		    "bLengthChange": false,
		    "bPaginate": false,
		    "ordering": false,
        data:[], 
	    columns: [
		{ data: "PonintDiscussionName" },
		{ data: "notes"},
		],
		columnDefs: [
		             {targets: 0,type: "PonintDiscussionName"},
		         	{targets: 1,type: "notes"},
		]
    
	});	 
	function sendEmailwithattachment(){
		 var data ={meetingId:meetingId,toEmals: $("#toEmail").val(),subject:$("#Subject").val(),body: $("#body").val(),emailattachment:"",pdId:pdID};
			 console.log(data);
			 
				$.ajax({  
					url : '<%=listURL.toString()%>',
					data : {
							<portlet:namespace />cmd: 'ShareMOM',
							<portlet:namespace />shareMOMData: JSON.stringify(data),	
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
</script>