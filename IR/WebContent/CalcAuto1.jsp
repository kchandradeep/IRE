<%@ page import = "java.util.*"  language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculate Auto Insurance Premium</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</head>
<body>
<% 
		session = request.getSession(false);
		Object[] arr = (Object[])session.getAttribute("arr");
		
		
		
		%>
<div style = "height:100px"></div>
	<div class = "container" style="border-style: solid ; border-color:grey; border-width :5px"><center>
		<h1 class="text-primary"><u>Calculate Auto Insurance Premium</u></h1><br/></center>
		<h4>Vehicle Model :<u><% out.println(arr[0]); %></u></h4><br/>
		<h4>Base Premium :<u><% out.println(arr[1]); %></u></h4><br/>
		
	
	<form name = "premium" method = "post" action = "Calc">
	<table class="table table-bordered">
    <thead>
      <tr>
        <th>Factor</th>
        <th>Option</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>What is the vehicle type?</td>
        <td><select name = "vehicleType" style="width:100px"><option>Petrol</option>
        								<option>Diesel</option>
        </select></td>     
      </tr>
      <tr>
        <td>Is there any proof of earlier insurance?</td>
        <td><select name="proof" style="width:100px"><option>yes</option>
        								<option>no</option>
        </select></td>     
      </tr>
      <tr>
        <td>What's the driver's class?</td>
        <td><select name="dClass" style="width:100px"><option>transport</option>
        								<option>NonTransport</option>
        </select></td>
      </tr>
      <tr>
        <td>Does the vehicle have airbags and advanced safety features?</td>
        <td><select name = "safety" style="width:100px"><option>yes</option>
        								<option>no</option>
        </select>
        								
        </td>     
      </tr>
      <tr>
        <td>Does the vehicle have an anti-theft alarm?</td>
        <td><select name="antiTheft" style="width:100px"><option>yes</option>
        								<option>no</option>
        </select></td>     
      </tr>
      <tr>
        <td>Does the driver have traffic violation history?</td>
        <td><select name="violation"style="width:100px"><option>yes</option>
        								<option>no</option></select>
        </td>     
      </tr>
      <tr>
        <td>What is the policy term?</td>
        <td><select name="policy" style="width:100px"><option>LongTerm</option>
        <option>ShortTerm</option>
        </select></td>     
      </tr>
    </tbody>
  </table>	
	<br/>
	
	
	<center><button style='margin-right:180px' type = "submit"  class = "btn btn-outline-dark" name = "premium" value = "submit">Submit</button>
	<button  style='margin-right:180px'type="reset" class="btn btn-outline-dark">Clear</button>
	<a href="Welcome.jsp" class="btn btn-outline-dark">Cancel</a><br/><br/></center>
	</form>
	</div>
	
<div style = "height :100px"></div>
</body>
</html>