<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ include file ="../includes/header.jsp" %>   

<div class="container mt-5">
	<h2>Board Write</h2>
	 <form action="insert" method="post" name="frm">
	     <div class="mb-3 mt-3">
	      <label for="userid">Writer:</label>
	      <input type="text" class="form-control" id="userid" placeholder="Enter userid">
	    </div>
	    
	   <div class="mb-3 mt-3">
	      <label for="subject">Title:</label>
	      <input type="text" class="form-control" id="subject" placeholder="Enter subject" name="subject">
	    </div>
    
	    <div class="mb-3">
	      <label for="email">Email:</label>
	      <input type="email" class="form-control" id="email" placeholder="Enter email" 
	      name="email">
	    </div>
	    <div class="mb-3">
	     <label for="content">content:</label>
			  <textarea class="form-control" id="content" name="content" 
			   placeholder="Content goes here" rows=5></textarea>
	   </div>   
	    
     <div  class="mt-3">
    	<button type="submit" class="btn btn-primary">Submit</button>
    </div>
  </form>
</div>

</body>
</html>