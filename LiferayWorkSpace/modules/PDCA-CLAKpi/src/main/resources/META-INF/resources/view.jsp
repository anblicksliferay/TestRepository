<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.astra.anblicks.pdca.service.AstraPdca_CompanyDataLocalServiceUtil"%>
<%@page import="com.astra.anblicks.pdca.model.AstraPdca_CompanyData"%>
<%@page import="com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.security.permission.PermissionChecker"%>
<%@page import="java.util.List"%>
<%@page import="com.astra.anblicks.pdca.service.companyLocalServiceUtil"%>
<%@page import="com.astra.anblicks.pdca.model.company"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ include file="/init.jsp" %>

<portlet:resourceURL var="listURL"/>
<portlet:actionURL var="deleteProfile" name="deleteProfile"/>
<portlet:actionURL var="editProfile" name="editProfile"/>
<portlet:actionURL var="addKpi" name="addKpi"/>



<portlet:actionURL var="getfile" name="getfile"/>
<%
String kpidevData= (String) request.getAttribute("update_kpi_json");
Boolean isAdmin= (Boolean) request.getAttribute("isAdmin");

%>
<form name="deleteForm" id="deleteForm" action="<%=deleteProfile.toString() %>" method="post" name="update">
	<input type="hidden" id="<portlet:namespace/>userid" name="<portlet:namespace/>userid"/>
</form>
<form name="editForm" id="editForm" action="<%=editProfile.toString() %>" method="post" name="update">
	<input type="hidden" id="<portlet:namespace/>editid" name="<portlet:namespace/>editid"/>
</form>
<div id="confirmDelete_Admin" style="background-color:#ffffff;  height: 15px; display: none;">
				<p style="margin: -9px 0 10px;" >Confirm Delete</p>
			</div> 

 	  <form class="form-horizontal" >
  <div class="row generalInfoborder" > 
  <div class="col-md-6"> 
  <div class="form-group">
    <label class="control-label col-sm-4" for="companyName">Company Name: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"> 
	
<select class="form-control getTableDataOnchage company_adminshowHide"  id="company_"> 

<option value="">Select Company</option>

<% if(isAdmin){
List<AstraPdca_CompanyData> companyList_=AstraPdca_CompanyDataLocalServiceUtil.getAstraPdca_CompanyDatas(0, AstraPdca_CompanyDataLocalServiceUtil.getAstraPdca_CompanyDatasCount());
for( AstraPdca_CompanyData val:companyList_){%>
<option value="<%=val.getCompanyId()%>"><%=val.getCompanyName() %></option>
	
	<%}}else{ 
	} %>
</select>
    </div>
    
  </div>

  

  </div> 
    <div class="col-md-6"> 
  <div class="form-group">
    <label class="control-label col-sm-4" for="companyName">Year: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"> 
	<select class="form-control  getTableDataOnchage year_adminshowHide" id="year_"> 
 <option value="">Select Year</option>
 <% if(isAdmin){ %>
         <option value="2018">2018</option>
         <option value="2017">2017</option>
          <option value="2016">2016</option>
           <option value="2015">2015</option>
            <option value="2014">2014</option>
            <%} else { %>
            
            <%} %>
            </select>
    </div>
    
  </div>

    </div>
  
  
   
  </div>
	<div class="row">
	 <div class="col-md-6">
	  <div class="col-md-3">
	 <button type="button" class="btn btn-info" onclick="getTableonButton();">SHOW</button>
	 </div></div>
	 <div class="col-md-6">
	
 <div class="col-md-4">
	 </div>
	
	 	
 <div class="col-md-3" >
	<a  href="/group/astrapdca/addkpi" id="addKPI" class="btn btn-info ">Add New Data </a>
	 </div>
	  <div class="col-md-3">
	 <button type="button" class="btn btn-info"  id="downoladbuton" onclick="getdownloadURL('pdfdownload');">Download As PDF</button>
	 </div>
	 </div>
	</div>
</form>



<div class="row" style="padding-top: 15px;">
 <ul class="nav nav-tabs">
    <li class="active dev"><a data-toggle="tab" href="#home" onclick="drawDataTable('0');">Development</a></li>
    <li class="dev"><a data-toggle="tab" href="#menu1" onclick="drawDataTable('1');" id="ol1" >  &nbsp;&nbsp; &nbsp;OL 1 &nbsp;&nbsp; &nbsp;  </a></li>
    <li class="dev"><a data-toggle="tab" href="#menu2" onclick="drawDataTable('2');"  id="ol2">  &nbsp;&nbsp; &nbsp;OL 2 &nbsp; &nbsp; &nbsp; </a></li>
    <li class="dev" ><a data-toggle="tab" href="#menu3" onclick="drawDataTable('3');"  id="oladj"> &nbsp; &nbsp; OL Adjusted &nbsp; &nbsp;</a></li>
    <li class="dev" ><a data-toggle="tab" href="#menu3" onclick="drawDataTable('4');"  id="ol3" >  &nbsp; &nbsp; &nbsp;OL 3 &nbsp; &nbsp; &nbsp; </a></li>
    <li class="dev" ><a data-toggle="tab" href="#menu3" onclick="drawDataTable('5');"  id="fy"> &nbsp; &nbsp; &nbsp; Full Year &nbsp; &nbsp; &nbsp; </a></li>
   
  </ul>


 <table class="devDataTablePhycial" class="table-responsive  table-bordered table-hover" cellspacing="0" width="100%">
			  <thead>
		        <tr>
		        <!-- Dev columns -->
		            <th>Type</th>
		            <th>Item Des</th>
		            <th>Unit</th>
		            <th>Target</th>
		            <th>Weight</th>
		            <th>Achivement Formula</th>
		             <th>YTD</th>
		             <th>OL 1 FY</th>
		             <th>OL 2 FY</th>
		             <th>OL Adj.</th>
		              <th>OL3 FY</th>
		              <th>OL FY</th>
		              <th>Achivement</th>
		              <th>CLA Point</th>
		             <th></th>
		        </tr>
</table>
</div>
<script>
var kpidevJson=<%=kpidevData%>;
var devDataGrid=null;

	  devDataGrid = $('.devDataTablePhycial').DataTable( {
		  initComplete : function() {
		        $("#DataTables_Table_0_filter").detach().appendTo('.new-buttons-area');
		        $(".dt-buttons").detach().appendTo('.new-search-area');
		             
		    }, 
		    dom: 'lBfrtip',
		  // "showNEntries" : false,
		   "bInfo" : false,
		    buttons: [
        	  { className:'button',
                  extend: 'print',
                  exportOptions: {
                	  columns: [0, 1, 2, 3, 4,5, 6]
                  }
              },
            { className:'button',
                extend: 'copyHtml5',
                exportOptions: {
                    columns: [0, 1, 2, 3, 4,5]
                }
            },
            { className:'button',
                extend: 'csvHtml5',

                	 exportOptions: {
                         columns: [ 0, 1, 2, 3, 4,5 ,6,7]
                     }
            },
            {   className:'button',
                extend: 'pdfHtml5',
                exportOptions: {
                    columns: [ 0, 1, 2, 3, 4,5 ,6,7]
                }
            }
          
        ],
		  searching: false,
		   "bLengthChange": false,
		  order: [[0, 'desc'] ],
		  "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50,100, "All"]],  
        orderCellsTop: true,
        data:[], 
	    columns: [
		{ data: "type" },
		{ data: "itemDec" },
		{ data: "unit"},
		{ data: "target" },
		{ data: "weight" },
		{ data: "achivementformula" },
		{ data: "YTD" },
		{ data: "OL1FY" },
		{ data: "OL2FY" },
		{ data: "OLAdj" },
		{ data: "OL3FY" },
		{ data: "OLFY" },
		{ data: "Achivement" },
		{ data: "CLAPoint" },
		{	
			title:			'',
			orderable:		true,
			data:			null, //editbutton  deleteButton
		defaultContent:
			'<span class=" glyphicon glyphicon-edit editbutton" style="cursor: pointer;"> </span>   <span class="glyphicon glyphicon-trash deleteButton" style="cursor: pointer;"></span>'
		}
		],
		
		columnDefs: [{
			targets: 0,
			type: "type"},
		
			{targets: 1,
				type: "itemDec"},
				
				{   targets: 2,
					type: "unit"
				},
					{
						targets: 3,
						type: "target"
						},
						{   targets: 4,
							type: "weight"
							},
							
							{   targets: 5,
								type: "achivementformula" 
								},
								{   targets: 6,
									type: "YTD" 
									},
									{   targets: 7,
										type: "OL1FY" 
										},
										{   targets: 8,
											type: "OL2FY" 
											},
						
						
						
								
						{   targets: 9,
											type: "OLAdj" 
											},
						
						
							{   targets: 10,
											type: "OL3FY" 
											},
						
							{   targets: 11,
											type: "OLFY" 
											},
										{   targets: 12,
											type: "Achivement" 
											},
											{   targets: 13,
												type: "CLAPoint" 
												},
												
							{   targets: 14,
									type: "" ,
									 "searchable": false,
									 'sortable': false,
									 "orderable": false
									}
		]
    
	});	
	    devDataGrid.column(6).visible(false);
	    devDataGrid.column(7).visible(false); //1
	    devDataGrid.column(8).visible(false); //2
	    devDataGrid.column(9).visible(false);//adj
	    devDataGrid.column(10).visible(false);// 3
	    devDataGrid.column(11).visible(false);// fy
	    devDataGrid.column(12).visible(false);
	    devDataGrid.column(13).visible(false);
	  $('.devDataTablePhycial').addClass("table-bordered");
	  $('.devDataTablePhycial tbody').on( 'click', '.editbutton', function () {
	        var data = devDataGrid.row( $(this).parents('tr') ).data();
	        console.log("edit");
	        console.log(data);
	        $('#<portlet:namespace/>editid').val(data.kpiId);
		  location.href="/group/astrapdca/addkpi?kpiId=".concat(data.kpiId)+"&Period=".concat(data.period)+"&companyId=not yet defined in table&type="+data.type;

	    } );
     $('.devDataTablePhycial tbody').on( 'click', '.deleteButton', function () {
	   var data = devDataGrid.row( $(this).parents('tr') ).data();
	   console.log("deleteButton");
		        console.log(data);	 
		    	$('#<portlet:namespace/>userid').val(data.kpiId);
		         console.log("opening dialog"); 
		    	$( "#confirmDelete_Admin" ).dialog( "open" );
		});
     $("#confirmDelete_Admin").dialog({
 		height:'130',
 		width:'250',
 		modal: true,
 		autoOpen: false,
 		draggable: false,
 	buttons: {
 		"Delete": function() {
 			$( this ).dialog( "close" );
 			$('#deleteForm').submit();
 		},
 		"Cancel": function() {
 			$( this ).dialog( "close" );
 		},
 	}
 	});

    // $('.getTableDataOnchage').change(function(){
    	var companyId;
    	var year;
    	 function getTableonButton(){
    		 companyId=$("#company_").val();
    		 year=$("#year_").val();
    	 $.ajax({  
    			url : '<%=listURL.toString()%>',
    			data : {
    					<portlet:namespace />cmd: 'getTableDataOnchage',
    					<portlet:namespace />company:$("#company_").val(),
    					<portlet:namespace />year:$("#year_").val(),
    						},
    			type : "POST",
    			dataType : "json",
    			success : function(data) { 
    			console.log(data);
    				var editDeleteFlag=data.kpi_Data[0].editDeleteFlag;
    				console.log(editDeleteFlag);
    				devDataGrid.column(5).visible(true);
    			devDataGrid.column(6).visible(false);
    			devDataGrid.column(7).visible(false); //1
    		    devDataGrid.column(8).visible(false); //2
    		    devDataGrid.column(9).visible(false);//adj
    		    devDataGrid.column(10).visible(false);// 3
    		    devDataGrid.column(11).visible(false);// fy
    		    devDataGrid.column(12).visible(false);
    		    devDataGrid.column(13).visible(false);
    		    
    		    if(editDeleteFlag){ devDataGrid.column(14).visible(true);}
    		    else{ devDataGrid.column(14).visible(false);}
    				           var data = data.kpi_Data;
    					       devDataGrid.clear();	
    					       devDataGrid.rows.add(data).draw();
    					       devDataGrid.draw();
    			    
    				
    			},	
    			error : function(response) {
    				console.log("Error seen for updateValues");
    				$("#<portlet:namespace />warning").show();
    			}
    		});
    	 }
   //  });
/*     	 var companyId;
     	var year; */
function drawDataTable(val) {

     		var cmd = 'list';
	$.ajax({  
		url : '<%=listURL.toString()%>',
		data : {
				<portlet:namespace />cmd: cmd,
				<portlet:namespace />period: val,
				<portlet:namespace />company: companyId,
				<portlet:namespace />year: year,
					},
		type : "POST",
		dataType : "json",
		success : function(data) { 
	
	console.log(data);
			var periodString=data.kpi_Data[0].period;
			var editDeleteFlag=data.kpi_Data[0].editDeleteFlag;
			console.log(editDeleteFlag);
			if(periodString == 0)
    	{
				$("#addKPI").show();
				$("#downoladbuton").show();
	
		devDataGrid.column(5).visible(true);
		devDataGrid.column(6).visible(false);
		devDataGrid.column(7).visible(false); //1
	    devDataGrid.column(8).visible(false); //2
	    devDataGrid.column(9).visible(false);//adj
	    devDataGrid.column(10).visible(false);// 3
	    devDataGrid.column(11).visible(false);// fy
	    devDataGrid.column(12).visible(false);
	    devDataGrid.column(13).visible(false);
	    if(editDeleteFlag){ devDataGrid.column(14).visible(true);}
	    else{ devDataGrid.column(14).visible(false);}
			           var data = data.kpi_Data;
				       devDataGrid.clear();	
				       devDataGrid.rows.add(data).draw();
				       devDataGrid.draw();
		    
		}
			
			if(periodString=="1")
			{
				
				$("#addKPI").hide();
				$("#downoladbuton").hide();
				devDataGrid.column(5).visible(false);
				devDataGrid.column(6).visible(true);
			devDataGrid.column(7).visible(true); //1
		    devDataGrid.column(8).visible(false); //2
		    devDataGrid.column(9).visible(false);//adj
		    devDataGrid.column(10).visible(false);// 3
		    devDataGrid.column(11).visible(false);// fy
		    devDataGrid.column(12).visible(true);
		    devDataGrid.column(13).visible(true);
		    if(editDeleteFlag){ devDataGrid.column(14).visible(true);}
		    else{ devDataGrid.column(14).visible(false);}
			    	var data = data.kpi_Data;
			       devDataGrid.clear();	
			       devDataGrid.rows.add(data).draw();
			       devDataGrid.draw();
			    
			}
			if(periodString=="2")
			{$("#downoladbuton").hide();
				$("#addKPI").hide();
				devDataGrid.column(5).visible(false);
			devDataGrid.column(6).visible(true);
			devDataGrid.column(7).visible(false); //1
		    devDataGrid.column(8).visible(true); //2
		    devDataGrid.column(9).visible(false);//adj
		    devDataGrid.column(10).visible(false);// 3
		    devDataGrid.column(11).visible(false);// fy
		    devDataGrid.column(12).visible(true);
		    devDataGrid.column(13).visible(true);
		    if(editDeleteFlag){ devDataGrid.column(14).visible(true);}
		    else{ devDataGrid.column(14).visible(false);}
			    	var data = data.kpi_Data;
			       devDataGrid.clear();	
			       devDataGrid.rows.add(data).draw();
			       devDataGrid.draw();
			    
			}
			if(periodString=="3")
			{$("#downoladbuton").hide();
				$("#addKPI").hide();
				devDataGrid.column(5).visible(false);
			devDataGrid.column(6).visible(true);
			devDataGrid.column(7).visible(false); //1
		    devDataGrid.column(8).visible(false); //2
		    devDataGrid.column(9).visible(true);//adj
		    devDataGrid.column(10).visible(false);// 3
		    devDataGrid.column(11).visible(false);// fy
		    devDataGrid.column(12).visible(true);
		    devDataGrid.column(13).visible(true);
		    if(editDeleteFlag){ devDataGrid.column(14).visible(true);}
		    else{ devDataGrid.column(14).visible(false);}
			    	var data = data.kpi_Data;
			       devDataGrid.clear();	
			       devDataGrid.rows.add(data).draw();
			       devDataGrid.draw();
			    
			}
			if(periodString=="4")
			{$("#downoladbuton").hide();
				$("#addKPI").hide();
				devDataGrid.column(5).visible(false);
			devDataGrid.column(6).visible(true);
			devDataGrid.column(7).visible(false); //1
		    devDataGrid.column(8).visible(false); //2
		    devDataGrid.column(9).visible(false);//adj
		    devDataGrid.column(10).visible(true);// 3
		    devDataGrid.column(11).visible(false);// fy
		    devDataGrid.column(12).visible(true);
		    devDataGrid.column(13).visible(true);
		    if(editDeleteFlag){ devDataGrid.column(14).visible(true);}
		    else{ devDataGrid.column(14).visible(false);}
			    	var data = data.kpi_Data;
			       devDataGrid.clear();	
			       devDataGrid.rows.add(data).draw();
			       devDataGrid.draw();
			    
			}
			if(periodString=="5")
			{$("#downoladbuton").hide();
				$("#addKPI").hide();
				devDataGrid.column(5).visible(false);
			devDataGrid.column(6).visible(true);
			devDataGrid.column(7).visible(false); //1
		    devDataGrid.column(8).visible(false); //2
		    devDataGrid.column(9).visible(false);//adj
		    devDataGrid.column(10).visible(false);// 3
		    devDataGrid.column(11).visible(true);// fy
		    devDataGrid.column(12).visible(true);
		    devDataGrid.column(13).visible(true);
		    if(editDeleteFlag){ devDataGrid.column(14).visible(true);}
		    else{ devDataGrid.column(14).visible(false);}
			    	var data = data.kpi_Data;
			       devDataGrid.clear();	
			       devDataGrid.rows.add(data).draw();
			       devDataGrid.draw();
			    
			}
			
		},	
		error : function(response) {
			console.log("Error seen for updateValues");
			$("#<portlet:namespace />warning").show();
		}
	});
} ;

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
				
			        	$("#year_").empty(); 
				         $('#year_').append($("<option></option>") .attr("value","").text("Select Year"));
				           var   option = $('<option />').val(data.settingData[0].year).text(data.settingData[0].year);
				         $("#year_").append(option);
				
				$("#company_").empty(); 
				  $('#company_').append($("<option></option>") .attr("value","").text("Select Company"));
				  $.each(data.settingData,function(key,value)
				         {
				           var   option = $('<option />').val(value.companyId).text(value.companyName);
				        $("#company_").append(option);
				        
				         }); 
				  $("#ol1").hide();
				  $("#ol2").hide();
				  $("#oladj").hide();
				  $("#ol3").hide();
				  $("#fy").hide();
				  if(data.settingData[0].period==1){
					  $("#ol1").show();
				  }
					if(data.settingData[0].period==2){
						 $("#ol2").show();			  
									  }
					if(data.settingData[0].period==3){
						 $("#oladj").show();
					}
					if(data.settingData[0].period==4){
						$("#ol3").show();
					}
					if(data.settingData[0].period==5){
						$("#fy").show(); 
					}
		},	
		error : function(response) {
			console.log("Error seen for initializeAdminsettings");
		},
		
	});
}

function getdownloadURL(val) {
	$.ajax({  
		url : '<%=listURL.toString()%>',
		data : {
				<portlet:namespace />cmd: val,
				<portlet:namespace />company:$("#company_").val(),
				<portlet:namespace />year:$("#year_").val(),
					},
		type : "POST",
		dataType : "json",
		success : function(data) { 
			console.log(data);
			if(data.success == "success"){
				window.open(data.link, '_blank');
			}
		},
		error : function(response) {
			console.log("Error seen for updateValues");
			$("#<portlet:namespace />warning").show();
		}
	});
	
};


</script>

<style>

.new-search-area{
margin-left: 1015px;
    width: 18%;
}
</style>
