///On load

var nameisok = false;
var diisok = true;
var ddisok = true;
var companyisok = true;

$(document).ready(function(){

	$('#submit').prop('disabled', true);


	$('#computerName').change(function(){

		if(!$('#name').val().match("^[a-zA-Z0-9 -._]+$")) {
			$('#name').parent().addClass('has-error');
			nameisok = false;
			allisright();
		}else {

			$('#name').parent().removeClass('has-error');
			$('#name').parent().addClass('has-success');
			nameisok = true;
			allisright();
		}


	});

	$('#introduced').change(function(){
		if($('#introduced').val().match("^[0-9]{4}-[0-1][0-9]-[0-3][0-9]$") || $('#introduced').val()=="") {

			$('#introduced').parent().removeClass('has-error');
			$('#introduced').parent().addClass('has-success');
			diisok = true;
			allisright();

		}else {
			$('#introduced').parent().addClass('has-error');
			diisok=false;
			allisright();
		}


	});

	$('#discontinued').change(function(){
		if($('#discontinued').val().match("^[0-9]{4}-[0-1][0-9]-[0-3][0-9]$") || $('#discontinued').val()=="") {

			$('#discontinued').parent().removeClass('has-error');
			$('#discontinued').parent().addClass('has-success');
			ddisok = true;
			allisright();

		}else {
			$('#discontinued').parent().addClass('has-error');
			ddisok=false;
			allisright();
		}

	});

	$('#companyId').change(function(){
		if($('#companyId').val().match("^[0-9]+$") || $('#companyId').val()==0) {

			$('#companyId').parent().removeClass('has-error');
			$('#companyId').parent().addClass('has-success');
			company = true;
			allisright();

		}else {
			$('#companyId').parent().addClass('has-error');
			company=false;
			allisright();
		}


	});


	});

var allisright = function(){

	if(nameisok && diisok && ddisok && companyisok) {
		if($('#discontinued').val()!="") {
			if($('#introduced').val()!="") {
				if( new Date($('#introduced').val()) < new Date($('#discontinued').val())) {
					$('#submit').prop('disabled', false);
					$('#introduced').parent().removeClass('has-error');
					$('#introduced').parent().addClass('has-success');
					$('#discontinued').parent().removeClass('has-error');
					$('#discontinued').parent().addClass('has-success');
				}else {
					$('#submit').prop('disabled', true);
					$('#introduced').parent().addClass('has-error');
					$('#discontinued').parent().addClass('has-error');
				}
			}else{
				$('#submit').prop('disabled', true);
			}	
		}else{
			$('#submit').prop('disabled', false);
			$('#introduced').parent().removeClass('has-error');
			$('#introduced').parent().addClass('has-success');
			$('#discontinued').parent().removeClass('has-error');
			$('#discontinued').parent().addClass('has-success');
		}
	}else{
		$('#submit').prop('disabled', true);
	}	
}

