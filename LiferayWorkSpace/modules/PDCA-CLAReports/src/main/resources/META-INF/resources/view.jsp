<%@ include file="/init.jsp" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>


<form class="form-horizontal" >
  <div class="row generalInfoborder" > 
  <div class="col-md-6"> 
  <div class="form-group">
    <label class="control-label col-sm-4" for="companyName">Report Type: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"> 
	<select  class="form-control" id="<portlet:namespace/>report" name="<portlet:namespace/>report" required="required">
         <option value="0">Select Report</option>
         <option value="1">Trading Profit Breakdown</option>
         <option value="2">Full Year</option>
         <option value="3">Corporate Planning</option>
         <option value="4">Executive Management</option>
         <option value="5">Performance & Reward Management</option>
</select>
    </div>
    
  </div>
  <div class="form-group">
    <label class="control-label col-sm-4" for="companyName">Year: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"> 
	
<select class="form-control"  id="<portlet:namespace/>period" name="<portlet:namespace/>period" required="required">
         <option value="0">Select Period</option>
         <option value="1">OL1 Achivement</option>
         <option value="2">OL2 Achivement</option>
         <option value="3">OL2 Adj. Achivement</option>
         <option value="4">OL3 Achivement</option>
         <option value="5">FY Achivement</option>
</select>
    </div>
    
  </div>


  

  </div> 
    <div class="col-md-6"> 
  <div class="form-group">
    <label class="control-label col-sm-4" for="companyName">Notes: <span class="mandatatory">*</span></label>
    <div class="col-sm-6"> 
	<select  class="form-control" id="<portlet:namespace/>year" name="<portlet:namespace/>year" required="required">
         <option value="0">Select Year</option>
         <option value="2017">2017</option>
         <option value="2018">2018</option>
</select>
    </div>
    
  </div>

    </div>
  
  
   
  </div>
	<div class="row">
	 <div class="col-md-6">
	  <div class="col-md-3">
	 <button type="button" class="btn btn-info" onclick="getreporturl();">SHOW</button>
	 </div></div>
	 <div class="col-md-6">
	

	 </div>
	</div>
</form>


<script>
function getreporturl(){
	$.ajax({
	    url : '<%=ResourceUrl.toString()%>',
	    data : {
	    	<portlet:namespace />reportId: $("#<portlet:namespace />report").val(),
	    	<portlet:namespace />periodId: $("#<portlet:namespace />period").val(),
	    	<portlet:namespace />year: $("#<portlet:namespace />year").val()
	    },
	      type : "POST",
	      dataType: "json",
	    success : function(data) {
	        console.log(data);
	        window.open(data.URL, '_blank');
	    },
	    error : function(response) {
	       console.log("Error seen for loadDivisonDepName");
	        $('#img').hide();
	    }
	});
	}
</script>