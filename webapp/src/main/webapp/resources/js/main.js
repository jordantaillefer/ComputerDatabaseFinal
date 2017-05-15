$(document).on("click",".sortCol", function() {
  $(this).children("a")[0].click()
})


$(".button-edit-computer").on("click", function() {
	console.log($(this))
	 
	$(location).attr('href', "editComputer?id="+$(this).attr("id"))
})


