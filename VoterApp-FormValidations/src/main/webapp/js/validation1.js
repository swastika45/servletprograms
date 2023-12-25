

function  validate(frm){
	
	  alert("Client side form validations are done");
	// empty the existing error messages
	 document.getElementById("pnameErr").innerHTML="";
	 document.getElementById("pageErr").innerHTML="";
	  document.getElementById("paddrsErr").innerHTML="";
	 
	 //  change the  hidden box value to   "enabled" indicating wheather client side  form validations are done
	  frm.vstatus.value="enabled";
	  
	
	//read  the form data
	let  name=frm.pname.value;
	let  age=frm.page.value;
	let addrs=frm.paddrs.value;
	
	//write the client side form validations logics
	   let vflag=true;
	   
	   if(name==""){  //required rule on name
		   document.getElementById("pnameErr").innerHTML="<b>Person name is required </b>";
		   vflag=false;
	   }
	   else if(name.length<5){  // minlength rule on name
		 document.getElementById("pnameErr").innerHTML="<b>Person name should contain min of 5 letters </b>";
		  vflag=false;
	  }
	  
	  if(age==""){  // required rule in age
		  document.getElementById("pageErr").innerHTML="<b>Person age is required </b>";
		   vflag=false;
	  }
	  else if(isNaN(age)){  // numeric vlaue rule on age
		document.getElementById("pageErr").innerHTML="<b>Person age must be numeric value </b>";
		vflag=false;
	 }
	 else if(age<=0 || age>=126){  // range rule on age
		document.getElementById("pageErr").innerHTML="<b>Person age must be there 1 through 125 </b>";
		vflag=false;
	}
	
	 if(addrs==""){
		document.getElementById("paddrsErr").innerHTML="<b>Person address is required</b>";
		vflag=false;
	}
	
	
	
	 return   vflag;
	
}