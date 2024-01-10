# Kakaocloud_1st.project

## "자리바꿔보"조
주제: 랜덤 자리 배치 프로그램
목적: 카카오 클라우드 스쿨 4기 개발자 과정 중 2주마다 시행되는 자리 배정을 용이하게 하기 위함입니다.


기존의 자리와 짝꿍이 중복되지 않고 구성원 모두와 친해질 수 있도록하는 자리배치프로그램 개발에 중점을 두었습니다.


구성원 모두가 친해질 수 있도록 함과 동시에 모두가 함께 성장할 수 있도록 하기 위함입니다.

## 목차
- 개요
- 프로그램 설명
- 프로그램 운영 방식


## 개요
- 프로그램 이름: "자리바꿔보" 조
- 프로젝트 지속시간: 2023.12.20 - 2024.01.09
- 개발 엔진 및 언어: Java
- 멤버: 변인정, 권익재, 임창희, 김민혁


## 프로그램 설명

- 교육 과정 중에 구성원 모두가 함께 성장할 수 있도록, 모두의 친밀함에 기반한 성장이 가능하도록 자리배치 프로그램을 개발하게 되었습니다.
  
- 다양한 짝꿍 만나기 : 자리배정시 직전에 배정되었던 짝꿍이 중복되지 않도록 설계 하였습니다. 

- 새로운 자리 앉기 : 공평한 자리 배정 시스템을 추구하여 직전에 배정된 자리에 다시 배치되지 않도록 설계하였습니다. 

- 외톨이 방지 : 총 구성원 중 단 한분도 혼자 앉는 일이 없도록 설계하였습니다. 두 곳의 빈자리는 맨 뒤에 배치하여 모두의 공용 공간으로 활용할 계획입니다.


## 프로그램 운영 방식

### 요구사항 정의서
![1차팀플_요구사항정의서](https://github.com/inyujeongsang/Kakaocloud_1st.project/assets/104670277/fedcb16b-813a-4887-9e9b-1375a8d3608c)




### USECASE DIAGRAM
![1차팀플_유스케이스다이어그램](https://github.com/inyujeongsang/Kakaocloud_1st.project/assets/104670277/11028bdf-7c1a-45fd-8929-90fdd636d79e)



### 간트차트
<img width="1183" alt="1차팀플_간트차트_최종" src="https://github.com/inyujeongsang/Kakaocloud_1st.project/assets/104670277/40edc07a-f6f9-4dba-8fb7-26e4420447a7">


저희의 첫 번째 간트 차트 작성은 원활한 프로젝트 진행을 위해 계획대로 진행하는 것을 목표로 합니다.

그러나 계획을 정확히 따르는 것은 매우 어려울 수 있습니다. 또한 예상치 못한 장애 요소가 발생할 수 있으므로 이러한 상황을 현명하게 극복하는 방법 또한 프로젝트 과정 중에서 중요한 부분이라고 생각합니다.


### CLASS DIAGRAM
![kakao1stClassDiagram](https://github.com/inyujeongsang/Kakaocloud_1st.project/assets/104670277/a7346416-e5a3-44ff-991d-7db664896c9d)




### CLASS 역할 설명 (개요)
![1차팀플클래스다이어그램_러프하게 (2)](https://github.com/inyujeongsang/Kakaocloud_1st.project/assets/104670277/ffb260c7-f7c9-4dd9-a58a-6c2b37688240)

1. ArrangeFrame
   : 자리배치 GUI 이벤트 관리 (드래그&드랍), 버튼 동작 등
2. StudentFrame
   : 학생정보관리 GUI 버튼 기능 관리
3. Student
   : 학생정보를 담는다.
4. SeatAssignment
   : 개별 자리 정보 관리, 현재 자리번호, 이전 자리번호를 추적할 수 있다.
5. ReservedSeat
   : 지정석 정보 관리
6. ArrangeManager
   : 좌석 관리 배치 메서드 관리
7. Arrange
   : 좌석 그 자체



### 와이어프레임
<img width="792" alt="스크린샷 2024-01-04 오후 5 37 10" src="https://github.com/inyujeongsang/Kakaocloud_1st.project/assets/154866994/b146c65f-07d4-4605-8730-b6ff8fc3b40f">

와이어프레임 제작을 통해 두개의 UI가 필요하다는 결론 도출


### 와이어프레임을 기반으로 UI/UX 제작

|학생정보관리|랜덤좌석배치프로그램|
|------|---|
|![학생정보관리_UI](https://github.com/inyujeongsang/Kakaocloud_1st.project/assets/104670277/d0334766-4af9-4c07-8621-46a3e6d252a5)|![자리배치_UI](https://github.com/inyujeongsang/Kakaocloud_1st.project/assets/104670277/8b86f8e1-79d4-4d87-98e7-8db3106f6b53)|



### 프로그램 실행

JAVA GUI 버튼들을 통해 기능 구현



### 프로젝트 팀원
![팀원사진](https://github.com/inyujeongsang/Kakaocloud_1st.project/assets/104670277/1901a511-1d18-4e14-8cfb-95f515ecbd0c)








