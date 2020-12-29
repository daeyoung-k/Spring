<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-7 col-xs-10 login-form">
                    <div class="titlebox">
                        로그인
                    </div>
                    <form action="login" method="post">
                        <div class="form-group"><!--사용자클래스선언-->
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" id="myid" name="userId" placeholder="아이디">                            
                         </div>
                         <div class="form-group"><!--사용자클래스선언-->
                            <label for="id">비밀번호</label>
                            <input type="password" class="form-control" id="mypw" name="userPw" placeholder="비밀번호">
                         </div>
                         <div class="form-group">
                            <button type="submit" class="btn btn-info btn-block" id="goLogin">로그인</button>
                            <button type="button" class="btn btn-primary btn-block" onclick="location='userJoin'">회원가입</button>
                         </div>
                    </form>                
                </div>
            </div>
        </div>
    </section>
	
	<!-- <script type="text/javascript">
		$("#goLogin").click(function(){
			var id = $("#myid").val();
			var pw = $("#mypw").val();
			console.log(id, pw)
			if(id == "" || pw == ""){				
				alert("아이디와 비밀번호를 입력하세요.")
			}else{
				$.ajax({
					type: "POST",
					url: "userLoginForm",
					data: JSON.stringify({"userId":id, "userPw":pw}),
					contentType: "application/json; charset=utf-8",
					success: function(data){
						console.log(data)
						if(data == 1){
							alert("로그인 성공")
							location.href="userMypage";
						}else{
							alert("로그인 실패.")
							$("#myid").focus();
							return;
						}
				
					},
					error:function(status, error){}
				})	
			}
		})	
		
	</script> -->