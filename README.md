# JWT Sample Server

JWT 를 이용한 인증을 위한 자바 기반 서버로 JWT 기반 Authentication 과 Authorization 을 어떻게 처리하는지 이해할 수 있는 예시 프로젝트입니다.

## 실행 방법

아래 파일을 다운로드 받아 실행해 보실 수 있습니다.

[jwt-sample-server-0.1.0.jar](https://github.com/okreact/jwt-sample-server/blob/master/dist/jwt-sample-server-0.1.0.jar)

그리고 아래와 같이 실행하시면 됩니다.

```$bash
java -jar jwt-sample-server-0.1.0.jar
``` 

만약 소스 코드를 수정해서 테스트해 보고 싶다면 아래와 같이 따라해 보세요.

1. git clone https://github.com/okreact/jwt-sample-server.git
2. 설정 변경 혹은 소스 코드 수정 
3. ``./gradlew bootRun`` 혹은 ``gradlew.bat bootRun`` 명령어로 실행 

## 인증 테스트 방법 

아이디 패스워드를 입력하면 응답 헤더에서 JWT 값을 전달받습니다. 테스트를 위해서 아래와 같이 ``CURL`` 도구를 사용해서 요청하거나 **Postman** 을 이용해서 요청을 할 수 있습니다.

```$bash
curl -d '{"username":"admin", "password":"tiger"}' -H "Content-Type: application/json" -X POST http://localhost:8080/login -i
```

아래는 응답 문자열입니다.

```
HTTP/1.1 200 
X-Content-Type-Options: nosniff
X-XSS-Protection: 1; mode=block
Cache-Control: no-cache, no-store, max-age=0, must-revalidate
Pragma: no-cache
Expires: 0
X-Frame-Options: DENY
Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTUxODU5MzEzM30.igRhEGIu8QAwvLA4ZLJB_4ej_oDOydpkgScPnQ6nWZJDvpIktLAhG02-yDGx5ZUXoa2qMp84c995KvHiP2_Gyg
Content-Length: 0
Date: Sun, 04 Feb 2018 07:25:33 GMT
```

위 응답 헤더 값 중 ``Authorization`` 헤더 값을 아래와 같이 전송해서 사용자 목록 값을 조회할 수 있습니다. 

```$bash
curl -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTUxODU5MzEzM30.igRhEGIu8QAwvLA4ZLJB_4ej_oDOydpkgScPnQ6nWZJDvpIktLAhG02-yDGx5ZUXoa2qMp84c995KvHiP2_Gyg" -X GET http://localhost:8080/users
```

아래는 응답 값입니다.

```$javascript
[{"firstName":"Richard","lastName":"Feynman"},{"firstName":"Grigori","lastName":"Perelman"}]
```

만약 ``Authorization`` 헤더 값을 전달하지 않으면 아래와 같이 ``403 Forbidden`` 오류가 발생합니다.

```$javascript
{"timestamp":1517729812092,"status":403,"error":"Forbidden","message":"Access Denied","path":"/users"}
```





