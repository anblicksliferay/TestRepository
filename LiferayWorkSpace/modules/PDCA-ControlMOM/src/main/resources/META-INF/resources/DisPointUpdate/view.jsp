<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="/DisPointUpdate/init.jsp" %>
<%
String pdId="";
String ControlMOMId="";
String type="";
String notes="";
String status="";
String disPoint="";
String followUP="";
if( PortalUtil.getOriginalServletRequest(request).getParameter("pdId") != null){
	pdId=PortalUtil.getOriginalServletRequest(request).getParameter("pdId");
	ControlMOMId=PortalUtil.getOriginalServletRequest(request).getParameter("ControlMOMId");
	type=PortalUtil.getOriginalServletRequest(request).getParameter("type");
	notes=PortalUtil.getOriginalServletRequest(request).getParameter("notes");
	status=PortalUtil.getOriginalServletRequest(request).getParameter("status");
	disPoint=PortalUtil.getOriginalServletRequest(request).getParameter("dispoint");
	followUP=PortalUtil.getOriginalServletRequest(request).getParameter("followUP");
}


%>


<form class="form-horizontal" >
  <div class="row generalInfoborder" > 
  <div class="col-md-6"> 
  <div class="form-group">
    <label class="control-label col-sm-4" for="companyName">Type: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"> 
	<input  class="form-control" type="text" id="momType" name="momType"  disabled  />
    </div>
    
  </div>
  <div class="form-group">
    <label class="control-label col-sm-4" for="companyName">Point Of Discussion: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"> 
	<input  class="form-control" type="text" id="pointofDis" name="pointofDis"  disabled  />
    </div>
    
  </div>
  <div class="form-group"> 
        <label class="control-label col-sm-4" for="GroupName">Follow Up: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"> 
      <input type="text" class="form-control" id="followUP"  name="followUP" placeholder="Enter Follow Up ">
    </div>
  </div>

  

  </div> 
    <div class="col-md-6"> 
  <div class="form-group">
    <label class="control-label col-sm-4" for="companyName">Notes: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"> 
	<input  class="form-control" type="text" id="notes" name="notes"  disabled  />
    </div>
    
  </div>
    
  <div class="form-group">
    <div class="col-sm-2"> 
   <input type="radio" class="form-control"   name="status" value="good"> Good 
    </div>
    <div class="col-sm-2"> 
      <input type="radio"  class="form-control"  name="status" value="average"> Average
    </div>
    <div class="col-sm-2"> 
   <input type="radio" class="form-control"   name="status" value="poor"> Poor
    </div>
  </div>

  
    </div>
  
  
   
  </div>
	<div class="row">
	 <div class="col-md-6"></div>
	 <div class="col-md-6">
	 <div class="col-md-3">
	 <button type="button" class="btn btn-info" onclick="updateControlMOM();">Save</button>
	 </div>
	 <div class="col-md-3">
	 <button type="button" class="btn btn-info">Cancel</button>
	 </div>
	 </div>
	</div>
</form>

<script>


var pdId="<%=pdId%>";
var ControlMOMId= "<%=ControlMOMId%>";
var type="<%=type%>";
var notes= "<%=notes%>";
var status= "<%=status%>";
var disPoint= "<%=disPoint%>";
var followUp= "<%=followUP%>";
$("#momType").val(type);
$("#pointofDis").val(disPoint);
$("#followUP").val(followUp);
$("#notes").val(notes);
$("input[name=status][value=" +status+"]").prop('checked', 'checked');
function updateControlMOM(){
	
	   var statusValue = $("input[name='status']:checked").val();
	   var data={followUp:$("#followUP").val(),status:statusValue, pdId:pdId,ControlMOMId:ControlMOMId};
	   console.log(data);
		$.ajax({  
			url : '<%=listURL.toString()%>',
			data : {
					<portlet:namespace />cmd: "updateControlMOM",
					<portlet:namespace />updateControlMOMData: JSON.stringify(data),	
	
						},
			type : "POST",
			dataType : "json",
			success : function(data) { 
					console.log(data);
					location.href="/group/astrapdca/control-mom"
			},	
			error : function(response) {
				console.log("Error seen for updateValues");
				$("#<portlet:namespace />warning").show();
			}
		});

}
</script>
