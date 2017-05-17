

$('#filled-in-box').val(false);

$('#enable').click(function(){
	if( $('#filled-in-box').val() == "true" ){
		$('#filled-in-box').val("false");
	} 
	else if( $('#filled-in-box').val() == "false" ){
		$('#filled-in-box').val("true");
	} 
})

