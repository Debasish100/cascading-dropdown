<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

     
     
     
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dropdown</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.js"></script>
</head>
<body>
<%-- <form:form  modelAttribute="country" method="post" autocomplete="off" id="myform">

<div class="form-group row">
				<label for="staticEmail" class="col-lg-2 col-md-3 col-form-label">Country
					Name 
				</label>
				<div class="col-lg-4 col-md-6">
					<form:select path="cid" id="cid" name="cid"
						class="browser-default form-control">
						<option value="0">Select</option>
						<form:options items="${clist}" itemValue="cid" name="cid" 
							itemLabel="name" />
							
					</form:select>
				</div>
			</div>
			 --%>
			
			
			
			
			<label for="staticEmail" class=" col-md-1 control-label">Country:<span
							class="text-danger"></span></label>
						<div class="col-md-2">
							<select name="distId" id="distId"
								class=" form-control">
								<option value="0">Select</option>
								<c:forEach items="${clist}" var="vo">
									
									<option value="${vo.cid}">${vo.countryname}</option>
								</c:forEach>
							</select>
						</div>
						
						
						<label for="staticEmail" class="col-md-1 control-label">STATE:</label>
						<div class="col-md-2">
							<select name="townId" id="townId"
								class="form-control">
								<option value="0">Select</option>
								<%-- <c:forEach items="${state}" var="vo">
									
									
								</c:forEach> --%>
							</select>
						</div> 
						
						
						 <div class="form-group row">
		    <label for="inputName" class="col-xl-2 col-lg-3 col-md-3 col-form-label">Upload a file<span class="text-danger">*</span></label>
		    <div class="col-xl-3 col-lg-7 col-md-2">		    
		      <input  type="file" class="form-control" id="uploadKey1" onchange="return fileValidation();" accept=".pdf"/> 
		     	&nbsp;&nbsp;<span class="star">upload only .pdf <br> (Max. allowed upload size is 2 MB) </span>
 		     </div>
		  </div>
						
						
						
						
						
						
						
						
						
						
						
						<script>
 

						/* $(document).ready(function(){
							  $("#distId").change(function(){
								  var id=$(this).find("option:selected").val();
									alert(id);
								  // alert($(this).find("option:selected").text());
							   // alert("The text has been changed.");
								  
							  });
							});  */
 
 

						
  $(document).ready(function(){
    $('#distId').change(function(){
		var cname=$(this).find("option:selected").text();
		alert(cname);
	   alert($(this).find("option:selected").text());
		
		 $.ajax({
				url:"listofState",
				method:'POST',
				dataType : 'json',
				
				data:{
					"cname":cname
				},
				success:function(response){
					console.log(response);
					//alert(response);
				   var html = '<option value="0">Select</option>';
				   for (var i = 0; i <  response.length; i++) {
						var jsonTemp=response[i]
						
					
					html += '<option value="'+jsonTemp.sid+'">'+jsonTemp.sname+'</option>';
					
					}
					
					//var html = '<option val="1">test</option><option val="2">test2</option>';
					html += '</option>';
					//$('#townId').html(html);
					//console.log(html);
					$("#townId").empty().append(html);
		             },
				error:function(error){
					console.log(error);
				}
	});
	});   
 });  



 </script>
<%-- </form:form>
 --%>
<script type="text/javascript">




function fileValidation(){
  //alert("hi");
   var fileInput = document.getElementById('uploadKey1');
	    var filePath = fileInput.value;
  // alert(filePath);
   var allowedExtensions = /(\.pdf)$/;
   var fileSize = document.getElementById('uploadKey1').files[0].size;
		//alert(fileSize);
   if(!allowedExtensions.exec(filePath)){
       alert('Please upload file having extensions .pdf only.');
       fileInput.value = '';
       return false;
   } 
     if (fileSize > 2097152) // 2 mb for bytes.
   {
    	//alert(fileSize);
       alert("File size must be under 2mb.");
       fileInput.value = '';
       return false;
   }  
    return true;
}      







</script>
</body>
</html>