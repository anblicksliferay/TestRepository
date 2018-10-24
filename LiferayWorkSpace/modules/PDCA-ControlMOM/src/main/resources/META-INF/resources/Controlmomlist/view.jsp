<%@ include file="/Controlmomlist/init.jsp" %>

<%
String conrolMOMs= (String) request.getAttribute("conrolMOMs");
%>



<div class="row">

		<table class="ControlMOMDataGridClass_ table table-bordered" style="width: 100%">
    <thead>
      <tr><th></th>
         <th>Type</th>
        <th >Point Of Discussion</th>
        <th>Notes</th>
        <th>FollowUp</th>
        <th>Status</th>
      </tr>
   </thead>
   
  </table>
</div>
<script>
var controlMOMs=<%=conrolMOMs%>;
console.log(controlMOMs);

var ControlMOMTableObj=null;

ControlMOMTableObj = $('.ControlMOMDataGridClass_').DataTable( {
	 dom: 'lBfrtip',
	   "bInfo" : true,
	  searching: true,
	   "bLengthChange": true,
	  order: [[0, 'desc'] ],
	  "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50,100, "All"]],  
        data:controlMOMs, 
	    columns: [{	
			title:			'',
			orderable:		true,
			data:			null, //editbutton  deleteButton
		defaultContent:
			'<span class=" glyphicon glyphicon-edit editbutton" style="cursor: pointer;"> </span>'
		},
	              {data:"type"},
		{ data: "pointofDis" },
		{ data: "notes"},
		{data:"followUp"},
		{data:"status"}
		],
		columnDefs: [
{   targets: 0,
	type: "" ,
	 "searchable": false,
	 'sortable': false,
	 "orderable": false
	},
		             {targets:1,type:"type"},
		             {targets: 2,type: "pointofDis"},
		         	{targets: 3,type: "notes"},
		         	{targets:4,type:"followUp"},
		         	{targets:5,type:"status"}
		]
    
	});	 
$('.ControlMOMDataGridClass_ tbody').on( 'click', '.editbutton', function () {
    var data = ControlMOMTableObj.row( $(this).parents('tr') ).data();
    console.log("edit");
    console.log(data);
  location.href="/group/astrapdca/update-control-mom?ControlMOMId=".concat(data.ControlMOMId)+"&pdId=".concat(data.pdId)+"&type=".concat(data.type)+"&notes="+data.notes+"&dispoint=".concat(data.pointofDis)+
		  "&followUP=".concat(data.followUp)+"&status=".concat(data.status);

} );
</script> 