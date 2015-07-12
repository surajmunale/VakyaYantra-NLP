/**
 * Author : Pushkaraj Lahankar
 */


function ajaxSyncRequest(outputId, reqURL)
	{
	
	$.ajax({
        type: 'GET',
        url: reqURL + "?data=" + encodeURIComponent(document.getElementById("inputTextArea").value),
        success: function(data){
        	document.getElementById(outputId).value = data;
        },
		error: function(data){
			alert("please refresh and try");
			
		}
    });
}
	
	function ajaxAudioRequest(inputId, reqURL)
	{
		$.ajax({
	        type: 'GET',
	        url: reqURL + "?data=" + encodeURIComponent(document.getElementById("inputTextArea").value),
	        success: function(data){
	        	document.getElementById(outputId).value = data;
	        },
			error: function(data){
				alert("please refresh and try");
				
			}
	    });
	
	}

function clearTextArea(){
	
	document.getElementById("inputTextArea").value="";
	
}


function onloadFunction(){
	
	showKeyboard ();

}

function showArtha(){
	
	
	
	var visibility = document.getElementById("showArthaArea").style.visibility;
	if(visibility == 'hidden'){
		ajaxSyncRequest('showArthaArea','get-artha');
		document.getElementById("showArthaArea").style.boxShadow= '10px 10px 5px #888888';	
		document.getElementById("showArthaArea").style.visibility= 'visible';
		document.getElementById("showArthaButton").src="images/artha_open.png"
		document.getElementById("showArthaButton").style.boxShadow= '10px 10px 5px #888888';	
	}else{
		document.getElementById("showArthaArea").style.visibility= 'hidden';
		document.getElementById("showArthaArea").style.boxShadow= '0px 0px 0px #000000';
		document.getElementById("showArthaButton").src="images/artha.png";
		document.getElementById("showArthaButton").style.boxShadow= '0px 0px 0px #000000';
	}
	
	
		
}

function showSamanartha(){
	
	
	
	var visibility = document.getElementById("showSamanArthaArea").style.visibility;
	if(visibility == 'hidden'){
		ajaxSyncRequest('showSamanArthaArea', 'get-samanartha');
		document.getElementById("showSamanArthaArea").style.boxShadow= '10px 10px 5px #888888';	
		document.getElementById("showSamanArthaArea").style.visibility= 'visible';
		document.getElementById("showSamanArthaButton").src="images/samanartha_open.png"
		document.getElementById("showSamanArthaButton").style.boxShadow= '10px 10px 5px #888888';
	}
		
	else{
		document.getElementById("showSamanArthaArea").style.visibility= 'hidden';
		document.getElementById("showSamanArthaArea").style.boxShadow= '0px 0px 0px #000000';
		document.getElementById("showSamanArthaButton").src="images/samanartha.png"
		document.getElementById("showSamanArthaButton").style.boxShadow= '0px 0px 0px #000000';
	}	
}

function showSandhiJoin(){
	
	
	
	var visibility = document.getElementById("showSandhiJoinArea").style.visibility;
	if(visibility == 'hidden'){
		ajaxSyncRequest('showSandhiJoinArea', 'get-sandhi-join');
		document.getElementById("showSandhiJoinArea").style.boxShadow= '10px 10px 5px #888888';	
		document.getElementById("showSandhiJoinArea").style.visibility= 'visible';
		document.getElementById("showSandhiJoinButton").src="images/sandhijoin_open.png"
		document.getElementById("showSandhiJoinButton").style.boxShadow= '10px 10px 5px #888888';
	}
		
	else{
		document.getElementById("showSandhiJoinArea").style.boxShadow= '0px 0px 0px #000000';
		document.getElementById("showSandhiJoinArea").style.visibility= 'hidden';
		document.getElementById("showSandhiJoinButton").src="images/sandhijoin.png"
		document.getElementById("showSandhiJoinButton").style.boxShadow= '0px 0px 0px #000000';
	}
		
	
}

function showSandhiVigraha(){
	
	
	
	var visibility = document.getElementById("showSandhiVigrahaArea").style.visibility;
	if(visibility == 'hidden'){
		ajaxSyncRequest('showSandhiVigrahaArea','get-sandhiviched');
		document.getElementById("showSandhiVigrahaArea").style.boxShadow= '10px 10px 5px #888888';	
		document.getElementById("showSandhiVigrahaArea").style.visibility= 'visible';
		document.getElementById("showSandhiVigrahaButton").src="images/sandhivigraha_open.png"
		document.getElementById("showSandhiVigrahaButton").style.boxShadow= '10px 10px 5px #888888';
	}
		
	else{
		document.getElementById("showSandhiVigrahaArea").style.visibility= 'hidden';
		document.getElementById("showSandhiVigrahaArea").style.boxShadow= '0px 0px 0px #000000';
		document.getElementById("showSandhiVigrahaButton").src="images/sandhivigraha.png"
		document.getElementById("showSandhiVigrahaButton").style.boxShadow= '0px 0px 0px #000000';
	}
		
	
}

function showSamasa(){
	
	
	
	var visibility = document.getElementById("showSamasaArea").style.visibility;
	if(visibility == 'hidden'){
		ajaxSyncRequest('showSamasaArea', 'get-samasa');
		document.getElementById("showSamasaArea").style.boxShadow= '10px 10px 5px #888888';	
		document.getElementById("showSamasaArea").style.visibility= 'visible';
		document.getElementById("showSamasaButton").src="images/samasa_open.png"
		document.getElementById("showSamasaButton").style.boxShadow= '10px 10px 5px #888888';
	}
		
	else{
		document.getElementById("showSamasaArea").style.visibility= 'hidden';
		document.getElementById("showSamasaArea").style.boxShadow= '0px 0px 0px #000000';
		document.getElementById("showSamasaButton").src="images/samasa.png"
		document.getElementById("showSamasaButton").style.boxShadow= '0px 0px 0px #000000';
	}
		
	
}

function showVrutta(){
	
	
	
	var visibility = document.getElementById("showVruttaArea").style.visibility;
	if(visibility == 'hidden'){
		ajaxSyncRequest('showVruttaArea', 'get-vrutta');
		document.getElementById("showVruttaArea").style.boxShadow= '10px 10px 5px #888888';	
		document.getElementById("showVruttaArea").style.visibility= 'visible';
		document.getElementById("showVruttaButton").src="images/Vrutta_open.png"
		document.getElementById("showVruttaButton").style.boxShadow= '10px 10px 5px #888888';
	}
		
	else{
		document.getElementById("showVruttaArea").style.visibility= 'hidden';
		document.getElementById("showVruttaArea").style.boxShadow= '0px 0px 0px #000000';
		document.getElementById("showVruttaButton").src="images/Vrutta.png"
		document.getElementById("showVruttaButton").style.boxShadow= '0px 0px 0px #000000';
	}
		
	
	
}