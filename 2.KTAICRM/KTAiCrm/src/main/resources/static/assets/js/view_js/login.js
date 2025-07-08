$(function() {
	// Login 엔터 활성
	$('#id_input, #password_input').on('keypress', function(key) {
		if (key.keyCode == 13) $("#login").trigger('click');
	});
	
	checkAutoLoginCookie();
	
	$("#login").click(function(event) {
		$.ajax({
			type: "POST",
			url: "/doLogin",
			data: {
				param1: $("input[name=id_input]").val(),
				param2: $("input[name=password_input]").val(),
				autoLogin: $("#auto_login").is(":checked") // 자동 로그인 체크박스 상태 전송
			},
			beforeSend: function(xhr, opts) {
				if ($("input[name=id_input]").val() == "") {
					alert("ID를 입력해주세요.");
					$('#id_input').focus();
					xhr.abort();
					return;
				}
				if ($("input[name=password_input]").val() == "") {
					alert("비밀번호를 입력해주세요.");
					$('#password_input').focus();
					xhr.abort();
					return;
				}
			},
			success: function(data) {
				location.href = "/index";
			},
			error: function() {
				alert("계정정보를 확인해주세요.");
			}
		});
	});
	function setCookie(name, value, days) {
	               var expires = "";
	               if (days) {
	                       var date = new Date();
	                       date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
	                       expires = "; expires=" + date.toUTCString();
	               }
	               document.cookie = name + "=" + (value || "") + expires + "; path=/";
	       }

	       // 쿠키 가져오기 함수
       function getCookie(name) {
               var nameEQ = name + "=";
               var ca = document.cookie.split(';');
               for (var i = 0; i < ca.length; i++) {
                       var c = ca[i];
                       while (c.charAt(0) == ' ') c = c.substring(1, c.length);
                       if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
               }
               return null;
       }

       // 쿠키 삭제 함수
       function eraseCookie(name) {
               document.cookie = name + '=; Max-Age=-99999999; path=/';
       }

       // 페이지 로드 시 자동 로그인 쿠키 확인 함수
       function checkAutoLoginCookie() {
               var autoLoginEnabled = getCookie("autoLoginEnabled");
               if (autoLoginEnabled === "true") {
                       var userId = getCookie("autoLoginId");
                       
                       if (userId) {
                               // 폼에 값 설정
                               $("#id_input").val(userId);
                               $("#auto_login").prop("checked", true);
                               
                               // 자동 로그인 시도는 하지 않음 - 인터셉터에서 처리
                       }
               }
       }


	
})