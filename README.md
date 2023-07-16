# commerce
스프링 부트 커머스 프로젝트

프로젝트 주제 : Spring Boot를 통한 판매 시스템 제작

🔘 설정
- IDE : IntelliJ Ultimate 2023.1
- Spring Boot : 2.7.13
- JDK : Oracle OpenJDK version 11.0.19
- Java : 11
  
🧡 프론트엔드
- HTML + CSS + Javascript

~~백엔드 개발에 집중하기 위해 뷰는 기능상의 최소만 구현하고 validation을 위한 Javascript 사용~~
~~템플릿 엔진 : ThymeLeaf 사용~~

~~사용 이유 : jsp를 이용한 개발을 이전에 경험해본 바 있고, 다른 SSR 방식인 ThymeLeaf에서 필요한 부분을 공부하여 적용해볼 생각. 순수 HTML 방식으로 내용에 포함된 th:를 무시하고 WAS 없이 뼈대를 확인할 수 있고 Spring Boot에서 추천하는 방식이기에 채택.
개인 프로젝트이기 때문에 SPA(React, Vue 등)를 사용할 수 없으므로 @RestController가 아닌 뷰를 리턴하는 @Controller 사용~~

-> REST API로 선회

💛 백엔드
- DB : H2 -> MySQL
- 개발 초기 단계에서 기능단위 구현 까지는 H2 이용 -> 추후 MySQL로 전환 예정
- ORM 프레임워크 : Hibernate
- Spring Data JPA를 통한 JpaRepository 이용
- 다양한 Annotation 사용을 위한 Lombok 이용

💚 기능 명세
- 회원 관리( BUYER, ( SELLER, ADMIN ) )
- 이메일 중복 체크
- 비밀번호 확인 기능
- 이메일을 통한 아이디 찾기
- 아이디, 이메일을 통한 비밀번호 찾기

Additional
- 판매자 등록
- 수기 입력 대신 카카오 주소 API 이용
- ( 관리자 - 판매자 - 구매자 ) 구조는 프로젝트 진행 후 고려 예정. 우선은 BUYER - ADMIN(SELLER) 구조로 진행

상품
- 상품 CRUD
- 상품 등록
- 상품 상세 확인
- 상품 정보 수정
- 상품 삭제
- 상품 CRUD는 ADMIN 계정으로 로그인해 조작할 예정

장바구니
- 상품 추가
- 상품 수량 조절(추가 / 감소)
- 상품 삭제
- 총 가격 출력
장바구니 하나에 여러 상품을 넣는 방법이 아닌 구매자의 고유 번호(중복 가능)와 상품의 고유 번호(수량으로 조절)를 참조하는 방법으로 처리.

- 카테고리
- 카테고리 추가
- 카테고리 이름 변경
- 카테고리 삭제
2차 이상 분류에 대해서는 자가 참조를 통해 시도해볼 예정.

찜
- 찜 추가
- 찜 삭제
  
💙 ERD 설계
![image](https://github.com/sunlake123/commerce/assets/91143081/75bf1859-098f-45a6-b6cf-d29925315e76)


💜 추가 예정
- 주문 테이블
- 결제 금액 - 장바구니 총액 참조
- 주문 날짜
- 결제 방식
- 배송지

가능하다면?
- 회원 배송지(기존에는 회원의 주소를 배송지로 사용)
- 후기 테이블
- 문의 / 후기 / 별점 등
- profile
