function validation() {
	var a = document.forms["mymenu"]["txtName"].value;
	if(a == "") {
		alert("Name is required");
		return false;
	}
	if((a.length < 2) || (a.length > 65)) {
		alert("The name should have 2 to 65 characters");
		document.forms["mymenu"]["txtName"].select();
		return false;
	}
	if(/[^a-zA-Z]/.test(a)) {
		alert("Name should be in alphabets");
		return false;
	}
	
	var b = document.forms["mymenu"]["txtPrice"].value;
	if(b == "") {
		alert("Price is required");
		document.forms["mymenu"]["txtPrice"].focus();
		return false;
	}
	
	if(/[^0-9]/.test(b)) {
		alert("Price has to be a number");
		return false;
	}
		
	var c = document.forms["mymenu"]["launch"].value;
	if(c == "") {
		alert("Date of launch is required");
		document.forms["mymenu"]["launch"].focus();
		return false;
	}
		
	var d = document.forms["mymenu"]["category"].value;
	if(d == "") {
		alert("Category is required");
		return flase;
	}
	alert("Details submitted successfully");
}
			

	