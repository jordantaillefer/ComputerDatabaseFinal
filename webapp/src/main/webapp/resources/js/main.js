$(document).on("click",".sortCol", function () {
  $(this).children("a")[0].click()
});


if (($(window).height() + 100) < $(document).height()) {
	$('#top-link-block').removeClass('hidden').affix({
		offset : {
			top : 100
		}
	});
	$('#bottom-link-block').removeClass('hidden')
}
