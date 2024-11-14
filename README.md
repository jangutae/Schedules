# Schedules

## Schedules API 작성
___

|기능|Method|URL|Request|Response|상태코드|
|----|---|---|---|---|---|
|일정 생성|POST|/api/schedules|요청 body|등록 정보|200: 정상 등록, 400: 비정상값|
|전체 일정조회|GET|/api/schedules|X|다건 응답 정보|200: 정상 조회|
|특정 일정조회|GET|/api/schedules/{id}|X|단건 응답 정보|200: 정상조회, 404: 일정을 조회 할수 없음|
|선택 일정수정|PUT|/api/schedules/{id}|요청 body|수정 정보|200:정상등록, 400:비정상 값, 404: 일정을 조회 할수 없음|
|선택 일정 부분수정|PATCH|/api/schedules/{id}|요청 body|수정 정보|200:정상등록, 400:비정상 값, 404: 일정을 조회 할수 없음|
|선택 일정삭제|DELETE|/api/schedules/{id}|X||삭제 정보|204: 정상 등록, 404: 일정을 조회 할수 없음|


###  일정 생성

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
    "username" : "이름"
    "title" : "제목"
    "contents" : "할일"
    "createdDate" : "2024-11-14 09:24:00"
    "modifiedDate" : "2024-11-14 09:24:00"
  } 
  ```
  
     
  * 응답 : HTTP/1.1 200 OK
 
   ```
  {  
     "id" : 1
     "username" : "이름"
     "title" : "제목"
     "contents" : "할일"
     "createdDate" : "2024-11-14 09:24:00"
     "modifiedDate" : "2024-11-14 09:24:00"
  } 
  ```


###  일정 전체 조회

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
     "id" : 1
     "username" : "이름"
     "title" : "제목"
     "contents" : "할일"
     "createdDate" : "2024-11-14 09:24:00"
     "modifiedDate" : "2024-11-14 09:24:00"
  } 
  ```



### 특정 일정 조회

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
     "id" : 1
     "username" : "이름"
     "title" : "제목"
     "contents" : "할일"
     "createdDate" : "2024-11-14 09:24:00"
     "modifiedDate" : "2024-11-14 09:24:00"
  } 
  ```


### 일정 수정

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
    "title" : "수정된 제목"
    "contents" : "수정된 할일"
  } 
  ```
  
     
  * 응답 : HTTP/1.1 200 OK
 
   ```
  {  
     "id" : 1
     "username" : "이름"
     "title" : "수정된 제목"
     "contents" : "수정된 할일"
     "createdDate" : "2024-11-14 09:24:00"
     "modifiedDate" : "2024-11-15 12:00:12"
  } 
  ```

### 일정 부분 수정

|메서드|PATCH|
|--|--|
|요청 URL|/api/schedules/{id}|

* 본문
  
  * 요청 : PATCH/api/schedules/{id}

#### 제목만 수정하는 경우

----


  * 본문
 
  * 요청 : 
    
|컬럼|타입|설명|필수값|
|---|---|---|---|
|username|String|작성자의 이름| Y |

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
    "username" : "이름"
    "title" : "수정된 제목"
    "contents" : "할 일"
    "createdDate" : "2024-11-14 09:24:00"
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
    "username" : "이름"
    "title" : "제목"
    "contents" : "수정된 할 일"
    "createdDate" : "2024-11-14 09:24:00"
    "modifiedDate" : "2024-11-15 12:00:12"
  } 
  ```
  ____


### 일정 삭제

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

* 유저 생성

|메서드|POST|
|--|--|
|요청 URL|/api/users|


* 특정 유저 조회

|메서드|GET|
|--|--|
|요청 URL|/api/users/{id}|

* 유저 삭제

|메서드|DELETE|
|--|--|
|요청 URL|/api/users/{id}|
