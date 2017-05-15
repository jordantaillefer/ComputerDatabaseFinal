  $(document).ready(function() {
    $('select').material_select();
  });
  
  $('.datepicker').pickadate({
	    selectMonths: true, // Creates a dropdown to control month
	    selectYears: 17, // Creates a dropdown of 15 years to control year
	    format: 'yyyy-mm-dd'  
	  });