$(document).ready(function() {
	console.log("Page is ready...!!!");

	$('#myform').on('submit', function(event) {
		event.preventDefault();

		//var data = $(this).serialize();
		//console.log(data);
		let data = new FormData(this);
		console.log(data);

		$('.loader').show();
		$('#myform').hide();

		$.ajax({
			url: "Register",
			data: data,
			type: 'POST',
			enctype: 'multipart/form-data',

			success: function(data, textStatus, jqXHR) {
				//console.log(data);
				//console.log("success...!!!");
				$('.loader').hide();
				$('#myform').show();

				if (data.trim() === "Done") {
					$('#msg').html("Registered Successfully !!!");
					//$('#msg').removeClass('text-warning');
					$('#msg').addClass('green-text');
				}/* else if (data.trim() === "Please agree terms and conditions first...!!!") {
					$('#msg').html("Please agree terms and conditions first...!!!");
					$('#msg').addClass('text-warning');
				}*/
				else {
					$('#msg').html("Something went wrong on server !!!");
					$('#msg').addClass('red-text');
				}
			},
			error: function(jqXHR, textStatus, errorThrown) {
				//console.log("error...!!!");
				$('#loader').hide();
				$('#myform').show();
				$('#msg').html("Something went wrong on server !!!");
				$('#msg').addClass('red-text');
			},
			processData: false,
			contentType: false
		});
	});
});