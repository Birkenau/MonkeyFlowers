


function checkEmail(inputtxt){
	
	var email = /^\w([\.-]?\w)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	
	if(inputtxt.match(email)){
		return true;
	}
	return false;
}

function checkUsername(inputtxt){
	
	var username = /^[a-zA-Z0-9]+$/;
	

	if(inputtxt.match(username)){
		return true;
	}
	return false;
}

function checkPassword(inputtxt){
	
	var error="Manca ";
	var reg=/[A-Z]/g;
	
	if(!inputtxt.match(reg)){
		
		var error = error + "-Lettera Maiuscola-";
	}

	reg=/[a-z]+/g;

	if(!inputtxt.match(reg)){
		
		var error = error +"-Lettera Minuscola-";
	}

	reg=/[0-9]/g;
if(!inputtxt.match(reg)){
	
	var error = error +"-Numero 0a9-";;
}

if(error=="Manca "){
	  
	  $("#errorNpsw").hide(600);
	  $("#successNpsw").show(600);
	return true;
}else{
	$("#errorNpsw").empty();
	  $("#errorNpsw").append(error);
	  $("#errorNpsw").show(600);
	  $("#successNpsw").hide(600);
	  
	
	return false;
}
}

$(document).ready(function() {



    $("#modelconfermDati").click(function(){
        var nome =$("#mNome").attr("placeholder");
        var cognome  =$("#mCognome").attr("placeholder");
        var email  =$("#mEmail").attr("placeholder");
        
        var mNome =$("#mNome").val();
        var mCognome =$("#mCognome").val();
        var mEmail =$("#mEmail").val();
        var error = false;
        var mod =false;
        $("#modal .modal-body").empty();
        $("#modalError .modal-body").empty();
        $("#modal .modal-body").append("<h3> sicuro di voler modificare : </h3>");
      
        if(nome!=mNome){
        	
        	
            $("#modal .modal-body").append("<h3> Nome:"+nome+" -->"+mNome+"  </h3>");
            
            mod =true;

        }
        if(cognome!=mCognome){
            $("#modal .modal-body").append("<h3> cognome:"+cognome+" -->"+mCognome+"  </h3>");
            
            mod =true;
        }
        if(email!=mEmail){
        	if(!checkEmail(mEmail))
        		{
        		
        		$("#modalError .modal-body").append("<h3 > Errore  E-mail:"+email+" non puo essere modificata in "+mEmail+"  </h3>");
        		error=true;
        		}else{
        			$("#modal .modal-body").append("<h3> E-mail:"+email+" -->"+mEmail+"  </h3>");
        			
        			mod =true;
        		}
            

        }
        
        
        if (error)
        	 $("#modalError").modal('show');
        else if(mod){
        	$("#modal").modal('show');	
        }
        
        
        
        
        
        console.log(nome+cognome+email+" modifica in "+mNome+cognome+email);
        
        
       });

    $("#confermaModifica").click(function(){
    	
    	var Nome =$("#mNome").val();
        var Cognome =$("#mCognome").val();
        var Email =$("#mEmail").val();
    	
    	
        console.log("wee modificame");
    	
    	 $.ajax({
    		 url: "AMU",
    		 
    		 type:"post",
    		  data: "action=modificaDati"+"&nome=" + Nome + "&cognome=" + Cognome+ "&eMail=" +Email ,
    		  success: function(data){
    			  
    			  $("#modalError .modal-body").append(data);
    		  },
    		  error: function(textStatus,errorThrown){
    			  console.log(textStatus,errorThrown);
    		  }
    		  
    		 
    		 
    		 	
   	  });
       	
    	 $("#modal").modal("hide")
    	 $("#modalError").modal('show');
    	 
    	 
    	
    })
    
    
     $("#btnModificaPsw").click(function(){
    	
    	var psw =$("#PasswordAttuale").val();
        var Npsw =$("#NuovaPassword").val();
        var Cpsw =$("#ConfermaNuovaPassword").val();
    	console.log(psw+Npsw+Cpsw);
    	 var valid=false;
         
     	if(checkPassword(Npsw)){
     		console.log("OK");
     		valid=true;
     	}
     	
     	if(!Npsw==Cpsw)
     		{
     		valid=false;
     		
     		}
    	if(!valid)
    		return;
    	
    	 $.ajax({
    		 url: "AMU",
    		 
    		 type:"post",
    		  data: "action=cambiaPassword"+"&psw=" + psw + "&Npsw=" + Npsw ,
    		  success: function(data){
    			  $("#modalError .modal-body").empty();
    			  $("#modalError .modal-body").append(data);
    			  $("#modalError").modal('show');
    		  },
    		  error: function(textStatus,errorThrown){
    			  console.log(textStatus,errorThrown);
    		  }
    		  
    		 
    		 
    		 	
   	  });
    		
       
    	
    	
    })
    
     
     $("#btnModificaUsername").click(function(){
    	
    	var psw =$("#UsernamePassword").val();
        var Username =$("#Username").val();
       
    	
    	 
         
    	
    	 $.ajax({
    		 url: "AMU",
    		 
    		 type:"post",
    		  data: "action=cambiaUsername"+"&psw=" + psw + "&Username=" + Username ,
    		  success: function(data){
    			  $("#modalError .modal-body").empty();
    			  $("#modalError .modal-body").append(data);
    			  $("#modalError").modal('show');
    		  },
    		  error: function(textStatus,errorThrown){
    			  console.log(textStatus,errorThrown);
    		  }
    		  
    		 
    		 
    		 	
   	  });
    		
       
    	
    	
    })
    
});


    


