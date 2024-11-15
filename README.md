# Schedules

## Schedules API 작성
___

|기능|Method|URL|Request|Response|상태코드|
|----|---|---|---|---|----|
|일정 생성|POST|/api/schedules|요청 body|등록 정보|200: 정상 등록, 400: 비정상값|
|전체 일정조회|GET|/api/schedules|X|다건 응답 정보|200: 정상 조회|
|특정 일정조회|GET|/api/schedules/{id}|X|단건 응답 정보|200: 정상조회, 404: 일정을 조회할 수 없음|
|선택 일정수정|PUT|/api/schedules/{id}|요청 body|수정 정보|200:정상등록, 400:비정상 값, 404: 일정을 조회할 수 없음|
|선택 일정 부분수정|PATCH|/api/schedules/{id}|요청 body|수정 정보|200:정상등록, 400:비정상 값, 404: 일정을 조회할 수 없음|
|선택 일정삭제|DELETE|/api/schedules/{id}|X|삭제 정보|200: 정상 실행 , 404: 일정을 조회할 수 없음|


###  일정 생성

* 기본 정보

|메서드|POST|
|--|--|
|요청 URL|/api/schedules|

* 본문
  * 요청 :
    
|컬럼|타입|설명|필수값|
|---|---|---|---|
|username|String|작성자의 이름| Y |
|title|String|작성된 글의 제목| Y |
|contents|String|작성된 글의 내용| Y |
|createDate|datetime|작성된 글의 날짜 및 시간| Y |
|modifiedDate|datetime|수정된 글의 날짜 및 시간| Y| 

   * 응답 :
     
|컬럼|타입|설명|필수값|
|---|---|---|---|
|id|LONG|작성된 글의 고유식별 id| Y |
|username|String|작성자의 이름| Y |
|title|String|작성된 글의 제목| Y |
|contents|String|작성된 글의 내용| Y |
|createDate|datetime|작성된 글의 날짜 및 시간| Y |
|modifiedDate|datetime|수정된 글의 날짜 및 시간| Y| 

* 예제

   * 요청 : POST/api/schedules
 
   * Body -> raw -> JSON 

 
  ```
  {  
    "username" : "이름",
    "title" : "제목",
    "contents" : "할일",
    "createdDate" : "2024-11-14 09:24:00",
    "modifiedDate" : "2024-11-14 09:24:00"
  } 
  ```
  
     
  * 응답 : HTTP/1.1 200 OK
 
   ```
  {  
     "id" : 1,
     "username" : "이름",
     "title" : "제목",
     "contents" : "할일",
     "createdDate" : "2024-11-14 09:24:00",
     "modifiedDate" : "2024-11-14 09:24:00"
  } 
  ```


###  일정 전체 조회

* 기본 정보

|메서드|GET|
|--|--|
|요청 URL|/api/schedules|

* 본문

   * 요청 : 없음

   * 응답 :
     
|컬럼|타입|설명|필수값|
|---|---|---|---|
|id|LONG|작성된 글의 고유식별 id| Y |
|username|String|작성자의 이름| Y |
|title|String|작성된 글의 제목| Y |
|contents|String|작성된 글의 내용| Y |
|createDate|datetime|작성된 글의 날짜 및 시간| Y |
|modifiedDate|datetime|수정된 글의 날짜 및 시간| Y| 

* 예제

   * 요청 : GET/api/schedules
 
   * params

     
  * 응답 : HTTP/1.1 200 OK
 
   ```
  {  
     "id" : 1,
     "username" : "이름",
     "title" : "제목",
     "contents" : "할일",
     "createdDate" : "2024-11-14 09:24:00",
     "modifiedDate" : "2024-11-14 09:24:00"
  } 
  ```



### 특정 일정 조회

* 기본 정보

|메서드|GET|
|--|--|
|요청 URL|/api/schedules/{id}|

* 본문

   * 요청 : 없음

   * 응답 :
     
|컬럼|타입|설명|필수값|
|---|---|---|---|
|id|LONG|작성된 글의 고유식별 id| Y |
|username|String|작성자의 이름| Y |
|title|String|작성된 글의 제목| Y |
|contents|String|작성된 글의 내용| Y |
|createDate|datetime|작성된 글의 날짜 및 시간| Y |
|modifiedDate|datetime|수정된 글의 날짜 및 시간| Y| 

* 예제

   * 요청 : GET/api/schedules/{id}
 
   * params

     
  * 응답 : HTTP/1.1 200 OK
 
   ```
  {  
     "id" : 1,
     "username" : "이름",
     "title" : "제목",
     "contents" : "할일",
     "createdDate" : "2024-11-14 09:24:00",
     "modifiedDate" : "2024-11-14 09:24:00"
  } 
  ```


### 일정 수정

* 기본 정보

|메서드|PUT|
|--|--|
|요청 URL|/api/schedules/{id}|

* 본문
  
  * 요청 :
    
|컬럼|타입|설명|필수값|
|---|---|---|---|
|title|String|작성된 글의 제목| Y |
|contents|String|작성된 글의 내용| Y |

   * 응답 :
     
|컬럼|타입|설명|필수값|
|---|---|---|---|
|id|LONG|작성된 글의 고유식별 id| Y |
|username|String|작성자의 이름| Y |
|title|String|작성된 글의 제목| Y |
|contents|String|작성된 글의 내용| Y |
|createDate|datetime|작성된 글의 날짜 및 시간| Y |
|modifiedDate|datetime|수정된 글의 날짜 및 시간| Y| 

* 예제

   * 요청 : PUT/api/schedules{id} 
 
   * Body -> raw -> JSON 

 
  ```
  {  
    "title" : "수정된 제목",
    "contents" : "수정된 할일"
  } 
  ```
  
     
  * 응답 : HTTP/1.1 200 OK
 
   ```
  {  
     "id" : 1
     "username" : "이름",
     "title" : "수정된 제목",
     "contents" : "수정된 할일",
     "createdDate" : "2024-11-14 09:24:00",
     "modifiedDate" : "2024-11-15 12:00:12"
  } 
  ```

### 일정 부분 수정

* 기본 정보

|메서드|PATCH|
|--|--|
|요청 URL|/api/schedules/{id}|

* 본문
  
  * 요청 : PATCH/api/schedules/{id}
___

#### 제목만 수정하는 경우

----

  * 본문
 
  * 요청 : 
    
|컬럼|타입|설명|필수값|
|---|---|---|---|
|title|String|작성된 글의 제목| Y |

  * 응답 :

|컬럼|타입|설명|필수값|
|---|---|---|---|
|id|LONG|작성된 글의 고유식별 id| Y |
|username|String|작성자의 이름| Y |
|title|String|작성된 글의 제목| Y |
|contents|String|작성된 글의 내용| Y |
|createDate|datetime|작성된 글의 날짜 및 시간| Y |
|modifiedDate|datetime|수정된 글의 날짜 및 시간| Y| 

  * 예제
  
   * 요청 : PATCH/api/schedules{id} 
 
   * Body -> raw -> JSON 

 ```
  {  
    "title" : "수정된 제목"
  } 
  ```

   * 응답 : 
 
   ```
  {
    "id" : 1, 
    "username" : "이름",
    "title" : "수정된 제목",
    "contents" : "할 일",
    "createdDate" : "2024-11-14 09:24:00",
    "modifiedDate" : "2024-11-15 12:00:12"
  } 
  ```
  ____

 
 #### 내용만 수정하는 경우

 ___


* 본문 :
   
  * 요청 : 
 
|컬럼|타입|설명|필수값|
|---|---|---|---|
|contents|String|작성된 글의 내용용| Y |

  * 응답 :
     
|컬럼|타입|설명|필수값|
|---|---|---|---|
|id|LONG|작성된 글의 고유식별 id| Y |
|username|String|작성자의 이름| Y |
|title|String|작성된 글의 제목| Y |
|contents|String|작성된 글의 내용| Y |
|createDate|datetime|작성된 글의 날짜 및 시간| Y |
|modifiedDate|datetime|수정된 글의 날짜 및 시간| Y| 


* 예제 :

  * 요청 :
    
 ```
  {  
    "contents" : "수정된 할 일"
  } 
  ```

   * 응답 : 
 
   ```
  {
    "id" : 1,
    "username" : "이름",
    "title" : "제목",
    "contents" : "수정된 할 일",
    "createdDate" : "2024-11-14 09:24:00",
    "modifiedDate" : "2024-11-15 12:00:12"
  } 
  ```
  ____


### 일정 삭제

* 기본 정보

|메서드|DELETE|
|--|--|
|요청 URL|/api/schedules/{id}|

* 본문

   * 요청 : 없음

   * 응답 : 없음
     
* 예제

   * 요청 : DELETE/api/schedules/{id}
 
   * params

     
  * 응답 : HTTP/1.1 200 OK
 

## User API 작성


#### 유저 생성

* 기본 정보

|메서드|POST|
|--|--|
|요청 URL|/api/users|

 * 본문 :

 * 요청 :
   
      
|컬럼|타입|설명|필수값|
|---|---|---|---|
|username|String|작성자의 이름| Y |
|password|Stirng|작성자의 비밀번호|Y|
|email|String|작성자의 이메일| Y |
   

 * 응답 :
   

|컬럼|타입|설명|필수값|
|---|---|---|---|
|id|Long|작성자의 고유식별id| Y |
|username|String|작성자의 이름| Y |
|email|String|작성자의 이메일| Y |
|createDate|datetime|작성된 글의 날짜 및 시간| Y |
|modifiedDate|datetime|수정된 글의 날짜 및 시간| Y | 


  * 예제 :
    
    * 요청 :
   
    * body -> raw -> JSON

 ```
  {  
    "username" : "이름",
    "password" : "0000",
    "email" : "a@a.com"
  }
```

 * 응답 :

      
```
  {
    "id" : 1,
    "username" : "이름",
    "email" : "a@a.com",
    "createdDate" : "2024-11-14 09:24:00",
    "modifiedDate" : "2024-11-14 09:24:00"
  }
```

#### 유저 조회

* 기본 정보

|메서드|GET|
|--|--|
|요청 URL|/api/users/{userId}|

* 본문

   * 요청 : 없음

   * 응답 :
     
|컬럼|타입|설명|필수값|
|---|---|---|---|
|id|LONG|작성된 글의 고유식별 id| Y |
|username|String|작성자의 이름| Y |
|title|String|작성된 글의 제목| Y |
|contents|String|작성된 글의 내용| Y |
|createDate|datetime|작성된 글의 날짜 및 시간| Y |
|modifiedDate|datetime|수정된 글의 날짜 및 시간| Y| 

* 예제

   * 요청 : GET/api/users/{userId}
 
   * params

     
  * 응답 : HTTP/1.1 200 OK
 
   ```
  {  
     "id" : 1,
     "username" : "이름",
     "email" : "제목",
     "createdDate" : "2024-11-14 09:24:00",
     "modifiedDate" : "2024-11-14 09:24:00"
  } 
  ```

#### 유저 삭제

* 기본 정보

|메서드|DELETE|
|--|--|
|요청 URL|/api/users/{userId}|

* 본문 :

  * 요청 : x
   
  * 응답 : x

* 예제 :

  * 요청 : /api/users/{userId}
 
  * params
 
  * 응답 : HTTP/1.1 200 OK

# ERD

___
![이알디사진](https://github.com/jangutae/Schedules/blob/main/ERD%20.png)
___

#SQL Query

1. 테이블 생성  

```
--- 일정 TABLE 생성
CREATE TABLE schedule {
    id INT NOT NULL PRIMARY KEY AUTO_INCREAMENT,
    userId INT NOT NULL COMMENT '사용자 식별 ID',
    title VARCHAR(50) NOT NULL,
    contents VARCHAR(250) NOT NULL,
    createdDate DATETIME NOT NULL,
    modifiedDate DATETIME
    FOREIGN KEY (userId) REFERENCES users (id)
);
```


```
--- 사용자 TABLE 생성
CREATE TABLE user {
    id INT NOT NULL PRIMARY KEY,
    password VARCHAR(16),
    email VARCHAR(30),
    createdDate DATETIME,
    modifiedDate DATETIME
);
```

2. 유저 생성 및 일정 생성

```
--- 컬럼 값 추가 INSERT schedule
INSERT INTO schedule(id, userId, title, contents, createdDate, modifiedDate)
VALUES (1, 1, 제목, 내용, CURRENT_DATETIME(), CURRENT_DATETIME());
```

```
--- 컬럼 값 추가 INSERT user
INSERT INTO user(id, password, email, createdDate, moddifiedDate)
VALUES (1, "0000", a@a.com, CURRENT_DATETIME(), CURRENT_DATETIME());
```

3. 전체 일정 조회

```
--- schedule 테이블 전체 컬럼 조회
SELECT * FROM schedule ORDER BY modifiedDate DESC

```

4. 특정 일정 조회

```
--- schedule 테이블 특정 일정
SELECT * FROM schedule WHERE id = 1 ORDER BY modifiedDate DESC

```

5. 특정 일정 수정
```
-- schedule 테이블 컬럼 값 수정 
UPDATE schedule SET title = '수정된 제목', content = '수정된 내용', update_date = CURRENT_DATE() WHERE id = 1;

```
6. 특정 일정 삭제
   
```
--- DELETE  FROM schedule  WHERE id = 1
```
