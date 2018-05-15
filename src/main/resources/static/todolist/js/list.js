$("li > .delete").click(function() {
	var $task = $(this).parent();
	
	$.ajax({
		url: "delete",
		type: "get",
		contentType: "application/json",
		data: {
			id: $task.attr('id'),
		},
		success: function() {
			$task.fadeOut();
		},
		error: function(e) {
			console.log(e.responseText);
		}
	});
});

$(".done").click(function() {
	$task = $(this).parent();
	
	$.ajax({
		url: "done",
		type: "get",
		contentType: "application/json",
		data: {
			id: $task.attr('id'),
			done: !$task.hasClass("stroked"),
		},
		success: function() {
			$task.toggleClass('stroked');
		},
		error: function(e) {
			console.log(e.responseText);
		}
	});
});

$( ".edit" ).click(function() {
	window.location.href = "edit?id=" + $(this).parent().attr('id');
});

$(".task-name").click(function() {
	
});

$("button#add-task").click(function () {
	window.location.href = "task";
});