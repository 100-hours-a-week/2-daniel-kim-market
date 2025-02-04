# 2-daniel-kim-delivery-order
1 week homework

# 클래스 다이어그램
<img width="358" alt="Image" src="https://github.com/user-attachments/assets/51e719d5-f765-4bfe-9408-51bf93e99574" />

# 과제 설명

사용자는 로그인을 해야 중고책 마켓에 들어갈 수 있다. 아이디가 없다면 회원가입을 한 뒤 로그인을 한다.
중고책 마켓에서는 물건을 구매하거나 판매할 수 있다.


# 초기화면
<img width="357" alt="Image" src="https://github.com/user-attachments/assets/32246f3e-5054-4977-b05f-42169bceffbc" />

로그인 화면이 뜨고 [1] 로그인, [2] 회원가입, [3] 종료
를 선택할 수 있다.


# 회원가입
<img width="358" alt="Image" src="https://github.com/user-attachments/assets/4c2961e5-4cce-4c73-bf57-578565d1a03a" />

<img width="549" alt="Image" src="https://github.com/user-attachments/assets/952abf26-34c6-4b2f-80de-a8c23bfaebb7" />
텍스트 파일 목록에 있지 않은 아이디와 비밀번호는 접근이 되지 않으며,
회원가입을 통해 아이디를 생성하고 접속할 수 있다.

# 책 판매
<img width="348" alt="Image" src="https://github.com/user-attachments/assets/a012025b-4da3-4685-ae89-93b007a0fea2" />

다른 사람이 판매중인 책 목록을 확인할 수 있고,
책을 판매할 수도 있다.

책 등록 후 추가된 것을 확인할 수 있다.
<img width="362" alt="Image" src="https://github.com/user-attachments/assets/d9395c95-05c1-48f0-b9b0-50026be8d5dd" />

# 책 구매
<img width="351" alt="Image" src="https://github.com/user-attachments/assets/099aedb2-46cb-43df-b786-b538475f1026" />

구매하고자 하는 책의 제목을 입력하여 책을 구매할 수 있다.

# 로그아웃
<img width="241" alt="Image" src="https://github.com/user-attachments/assets/913a365c-b599-4669-898d-5d9f0f8f0e80" />

프로그램을 종료하면 완전히 종료되는 것이 아닌,
로그아웃하는 것이며 다른 아이디로 접속할 수 있다.

<img width="457" alt="Image" src="https://github.com/user-attachments/assets/56c93551-8495-4f3e-bcfe-9dc77b7d74b0" />


# 추후 추가하고자 하는 기능
과제 제출 기간이 끝나고 생각나는 것이 있으면 아래와 같은 기능들을 추가하고자 한다.
User 관리 측면
1. 고객마다 가지고 있는 금액을 토대로 사용할 수 있다.
2. 추천인을 작성하면 초기에 10% 할인쿠폰이나 10,000원 할인 쿠폰을 받을 수 있다.
3. 비밀번호를 변경할 수 있다.
4. 기본키를 생각해보고 한 사람이 여러 개의 아이디를 소유할 수 없도록 한다. (사기 방지)

Book 관리 측면
1. 올린지 일정기간이 지난 책은 목록에서 사라지게 한다.
2. 카테고리별로 책들을 확인할 수 있다.
3. 검색기능을 통해 내가 구매하고자 하는 책이 있는지 확인할 수 있다.


# 마주했던 오류들
1. StackOverFlowError
    - 상황: 초기 User와 Book 패키지로만 나누어 각각 두 개의 Class로 제작하였다.
    - 불편했던 점: 
      - 1. 오류를 수정할 때 어디서 오류가 났고 어디를 변경해야할지 한 눈에 들어오지 않아 어려웠다.
      - 2. 기능을 확장할 때 여러 곳에 추가하다보니 어려웠다. 
      -> Class를 나누어 직관적이고 가독성이 좋게 만들자!
    - 오류 발생 원인: 너무 많은 곳에서 무턱대고 생성자를 생성하여 A class에서 B class를 호출하고,
                   B class에서 A class를 호출하다보니 '무한 재귀 호출'로 인해 Stack이 쌓여 넘쳤다.
<img width="755" alt="Image" src="https://github.com/user-attachments/assets/9800a73e-1fa9-4386-80f0-ba2409eb7802" />
   
    - 해결방법: SellBook과 BuyBook이 BookManager 내부에서 직접 생성되지 않고, 생성자 주입을 통해 관리되도록 하였다.
    - 느낀점: 클래스에서 다른 클래스의 메소드를 사용하고 싶으면 그냥 생성자를 통해 가져오는 것인줄 알았는데,
            이렇게 무턱대고 생성하면 안 된다는 것을 느꼈고 
            이를 해결하려면 객체를 생성할 때 직접 참조하지 말고, 생성자 주입 방식으로 관리하는 것이 좋은 해결책임을 알게 되었습니다.

2. txt 파일 깨짐
    - 상횡: 책을 등록한 뒤, 잘 등록되었는지 확인하기 위해 txt 파일을 여니 알아보기 힘든 문자로 작성되어 있었다.
    - 불편했던 점:
      - 1. 내가 기입한 정보가 제대로 들어갔는지 확인하기 어려움.
      - 2. txt 파일에 들어가 강제적으로 정보를 변환하는 것이 불가능함.
      -> csv 파일로 바꾸어 사람이 알아보기 쉬운 파일로 만들자!
    - 오류 사진
      <img width="640" alt="Image" src="https://github.com/user-attachments/assets/058cbc58-ba23-41ce-a72b-54c7ccda8166" />
   
    - 해결방법: BufferedWriter를 사용하여 csv 파일에 정보를 넣었다.