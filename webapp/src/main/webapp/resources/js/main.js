$(document).on("click",".sortCol", function() {
  $(this).children("a")[0].click()
})


$(".button-edit-computer").on("click", function() {
	console.log($(this))
	 
	$(location).attr('href', "editComputer?id="+$(this).attr("id"))
})

$("#button-add-computer").on("click", () => {
	 
	$(location).attr('href', "addComputer")
})
$(document).on("click","#button-delete-computer", function() {
	if(!$(".delete-checkbox-panel").hasClass("selected")){
		$(".delete-checkbox-panel").addClass("selected")
	} else {
		$(".delete-checkbox-panel").removeClass("selected")
		
	}
})
