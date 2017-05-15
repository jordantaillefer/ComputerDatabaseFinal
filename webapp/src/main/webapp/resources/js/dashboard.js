//On load
$(function() {
    // Default: hide edit mode
    $(".editMode").hide();
    
    // Click on "selectall" box
    $("#selectall").click(function () {
        $('.cb').prop('checked', this.checked);
    });

    // Click on a checkbox
    $(".cb").click(function() {
        if ($(".cb").length == $(".cb:checked").length) {
            $("#selectall").prop("checked", true);
        } else {
            $("#selectall").prop("checked", false);
        }
    });

});


// Function setCheckboxValues
(function ( $ ) {

    $.fn.setCheckboxValues = function(formFieldName, checkboxFieldName) {

        var str = $('.is-checked input').map(function() {
            return this.value;
        }).get().join();
        console.log(str)
        
        $(this).attr('value',str);
        
        return this;
    };

}( jQuery ));


// Function delete selected: Asks for confirmation to delete selected computers, then submits it to the deleteForm
(function ( $ ) {
    $.fn.deleteSelected = function() {
        if (confirm("Are you sure you want to delete the selected computers?")) { 
            $('#deleteForm input[name=selection]').setCheckboxValues('selection','cb');
            $('#deleteForm').submit();
        }
    };
}( jQuery ));



//Event handling
//Onkeydown
$(document).keydown(function(e) {

    switch (e.keyCode) {
        //DEL key
        case 46:
            if($(".editMode").is(":visible") && $(".cb:checked").length != 0) {
                $.fn.deleteSelected();
            }   
            break;
        //E key (CTRL+E will switch to edit mode)
        case 69:
            if(e.ctrlKey) {
                $.fn.toggleEditMode();
            }
            break;
    }
});


$("#button-add-computer").on("click", () => {
	 
	$(location).attr('href', "addComputer")
})

$("#button-open-delete").on("click" , function() {
	if(!$(this).hasClass("selected")){

		$(this).addClass(" red selected")
		$(".dashboard-fab-check-all").addClass("selected")
		$(".dashboard-fab-delete").addClass("selected")
		$(".open-clear ").fadeIn("fast")
		$(".dashboard-fab-delete ").fadeIn()
		$(".dashboard-fab-check-all ").fadeIn()
		$(".open-delete ").fadeOut("fast")
		$(".delete-checkbox-panel").fadeIn("fast")
		$(".delete-checkbox-panel").addClass("selected")
	} else {
		$(this).removeClass("red selected")
		$(".dashboard-fab-check-all").removeClass("selected")
		$(".dashboard-fab-delete").removeClass("selected")
		$(".open-delete ").fadeIn("fast")
		$(".dashboard-fab-delete ").fadeOut()
		$(".dashboard-fab-check-all ").fadeOut()
		$(".open-clear ").fadeOut("fast")
		
		$(".delete-checkbox-panel").fadeOut("fast")
		$(".delete-checkbox-panel").removeClass("selected")
	}
})

$("#button-check-all").on("click",function () {
	if(!$(this).hasClass("selected")){
		 $('.cb').addClass("is-checked")
		    $(this).addClass("selected")
	} else {
		$('.cb').removeClass("is-checked")
	    $(this).removeClass("selected")
	}
   
})
