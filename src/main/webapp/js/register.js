$(document).ready(function() {
	//console.log("Page is ready...!!!");

	$('#myform').on('submit', function(event) {
		event.preventDefault();

		var data = $(this).serialize();
		//console.log(data);

		$('#loader').show();
		$('#myform').hide();

		$.ajax({
			url: "Register",
			data: data,
			type: 'POST',

			success: function(data, textStatus, jqXHR) {
				//console.log(data);
				//console.log("success...!!!");
				$('#loader').hide();
				$('#myform').show();

				if (data.trim() === "Done") {
					$('#msg').html("Registered Successfully !!!");
					$('#msg').removeClass('text-warning');
					$('#msg').addClass('text-success');
				} else if (data.trim() === "Please agree terms and conditions first...!!!") {
					$('#msg').html("Please agree terms and conditions first...!!!");
					$('#msg').addClass('text-warning');
				} else {
					$('#msg').html("Something went wrong on server !!!");
					$('#msg').addClass('text-danger');
				}
			},
			error: function(jqXHR, textStatus, errorThrown) {
				//console.log("error...!!!");
				$('#loader').hide();
				$('#myform').show();
				$('#msg').html("Something went wrong on server !!!");
				$('#msg').addClass('text-danger');
			}
		});
	});
});