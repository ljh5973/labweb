<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="${pageContext.request.contextPath }/resources/css/bootstrap.css" rel="stylesheet">
    <script src="js/jquery.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/join.css">
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath }/resources/js/index.js"></script>
</head>
<body>


    <section class="member-join">
        <div class="join-container">
            <form action="join">
                <div class="header-area">
                    <div class="logo">
                        <h2>
                            MINE
                        </h2>
                        <p class="text-info">
                            회원가입
                        </p>
                    </div>
                </div>
                    <div class="join-form">
                        <div class="form-set">
                            <label for="memberId" class="j-form-label">아이디</label>
                            <input type="text" name="userId" class="j-input" placeholder="아이디 입력(5~11자)" >
                        </div>
                        <div class="form-set">
                            <label for="memberName" class="j-form-label">이름</label>
                            <input type="text" name="userName" class="j-input">
                        </div>
                        <div class="form-set">
                            <label for="password" class="j-form-label">비밀번호</label>
                            <input type="password" name="userPw" class="j-input" placeholder="비밀번호(숫자, 영문 ,특수문자 조합 최소 8자)" >
                            <p></p>
                        </div>

                        <button type="submit" class="join-submit">가입하기</button>
                    </div>
    
                   
                    
                
            </form>
        </div>

    </section>
    
</body>
</html>