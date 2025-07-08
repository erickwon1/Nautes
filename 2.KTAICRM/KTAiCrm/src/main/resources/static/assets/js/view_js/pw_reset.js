
$(function() {
	$("#submitButton").click(function(event) {
		$.ajax({
			type: "POST",
			url: "/authenticate/pw_reset",
			data: {
				username: $("input[name=username]").val(),
				currentPassword: $("input[name=currentPassword]").val(),
				newPassword: $("input[name=newPassword]").val()
			},
			beforeSend: function(xhr, opts) {

				if ($.trim($('#username').val()) == "") {
					alert('이름을 입력해주세요.');
					$('#username').focus();
					xhr.abort();
					return;
				}

				if ($.trim($('#currentPassword').val()) == "") {
					alert('비밀번호를 입력해주세요.');
					$('#currentPassword').focus();
					xhr.abort();
					return;
				}
			
				if ($.trim($('#confirmPassword').val()) == "") {
					alert('비밀번호를 입력해주세요.');
					$('#confirmPassword').focus();
					xhr.abort();
					return;
				}
				if ($.trim($('#newPassword').val()) != $.trim($('#confirmPassword').val())) {
					alert('비밀번호가 일치하지 않습니다. 비밀번호 확인해주세요.');
					$('#confirmPassword').focus();
					xhr.abort();
					return;
				}

			}, 
		
			success: function(result) {
				
				if (result.result) {
					alert("비밀번호 변경이 완료되었습니다. 로그인해주세요.");
					location.href = "/";
				} else {
					
					alert(result.failMsg);
				}
			},

		})

	})
	backButton.addEventListener('click', function() {
		location.href = "/";
	})
	
	
	
	
})