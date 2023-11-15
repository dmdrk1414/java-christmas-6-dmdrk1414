# 🤔 핵심 기능

- 중~~복된 할인과 증정을 허용하여 혜택을 적용하라! ?~~
- ~~**총액에서 할인을 적용하라**~~
- **할인과 증정을 적용하라**

#### [이벤트 목표]

1. **중복된 할인과 증정을 허용**해서, 고객들이 혜택을 많이 받는다는 것을 체감할 수 있게 하는 것

# ✅ 기능 구현 목록

#### 🗒️ [할인 이벤트]

- [x] 날짜가 지날수록 할인하는 기능 구현(총주문 금액에서 해당 금액만큼 할인하는 기능)

  - [x] 이벤트 기간: 2023.12.1 ~ 2023.12.25
  - [x] 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 **할인 금액이 100원씩 증가**

  총주문 금액에서 해당 금액만큼 할인

  (e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)

- [x] **평일 할인** 하는 기능 구현 (일요일~목요일)

  - [x] 평일에는 **디저트 메뉴**를 메뉴 1개당 2,023원 할인
  - [x] 2023.12.1 ~ 2023.12.31 동안 적용

- [x] **주말 할인** 하는 기능 구현 (금요일, 토요일)

  - [x] 주말에는 **메인 메뉴**를 메뉴 1개당 2,023원 할인
  - [x] 2023.12.1 ~ 2023.12.31 동안 적용

- [x] **특별 할인**하는 기능 구현 (이벤트 달력에 별)

  - [x] 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
  - [x] 2023.12.1 ~ 2023.12.31 동안 적용

- [x] **증정 이벤트**하는 기능 구현 

  - [x] 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
  - [x] 2023.12.1 ~ 2023.12.31 동안 적용

- [x] 할인 후 예상 결제 금액을 알려주는 기능 구현

#### 🗒️ [혜택 금액에 따른 배지 부여]

- [x] **배지를 부여**하는 기능 (할인 금액에 따라)
  - [x] 5천 원 이상: 별
  - [x] 1만 원 이상: 트리
  - [x] 2만 원 이상: 산타

#### 🗒️ [기능 실현 주문 조건]

- [x] 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.
- [x] 음료만 주문 시, 주문할 수 없습니다.
- [x] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.
  (e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)

#### 🗒️[입력 요구 사항]

- [x] **"12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)" 출력**
  - [x] 방문할 날짜는 1 이상 31 이하의 숫자로만 입력받아 주세요.
    - [x] 양수 입력 검사
    - [x] 숫자 "0"인지 검사.
  - [x] 1 이상 31 이하의 숫자가 아닌 경우, "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
  - [x] 모든 에러 메시지는 "[ERROR]"로 시작하도록 작성해 주세요.
  - [x] 입력을 받고 `trim()`
  - [x] 공백 포함 검사.
  - [x] 숫자 입력 검사.
    - [x] 문자열 포함 검사
    - [x] 특수문자 포함 검사
- [x] **"주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)" 출력**
  - [x] 고객이 메뉴판에 없는 메뉴를 입력하는 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.	
  - [x] 메뉴의 개수는 1 이상의 숫자만 입력되도록 해주세요. 이외의 입력값은 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
  - [x] 메뉴 형식이 예시와 다른 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
  - [x] 중복 메뉴를 입력한 경우(e.g. 시저샐러드-1,시저샐러드-1), "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
  - [x] 모든 에러 메시지는 "[ERROR]"로 시작하도록 작성해 주세요.
  - [x]  `,,`의 중간에  입력을 안한 것이 있는지 확인
  - [x]  공백 포함 검사.
  - [x]  처음과 끝이 `,`인지 확인이
  - [x] -다음 숫자가 왔는지 , 이전에 문자가 있는지 확인한다.
    - [x] '-'을 포함하고있는가
    - [x] '-'을 기준으로 "주문-갯수" 인가
    - [x] 특수기호 포함 검사
  - [x] 음료만 주문 시, 주문할 수 없습니다.
  - [x] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.
    (e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)
  - [x] 주문입력 중복 확인

#### 🗒️[출력 요구 사항]

- [x] **"안녕하세요! 우테코 식당 12월 이벤트 플래너입니다." 출력
- [x] **"12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!" 출력**
- [x] **"추문 메뉴" 출력**
  - [x] 주문 메뉴의 출력 순서는 자유롭게 출력해 주세요.
  - [x] 메인, 애피타이저, 디저트, 음료
- [x] **"할인 전 총주문 금액" 출력**
  - [x] 할인 적용이 안된금액 출력
- [x] **"증정 메뉴" 출력**
  - [x] "샴페인 1개"
  - [x] 증정 이벤트에 해당하지 않는 경우, 증정 메뉴 "없음"으로 보여 주세요.
- [x] **"혜택 내역" 출력**
  - [x] 고객에게 적용된 이벤트 내역만 보여 주세요.
  - [x] 적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 보여 주세요.
  - [x] 혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력 순서는 자유롭게 출력해주세요.
- [x] **"총혜택 금액" 출력**
  - [x] 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
- [x] **"할인 후 예상 결제 금액" 출력**
  - [x] 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액
- [x] **"12월 이벤트 배지" 출력**
  - [x] 총혜택 금액에 따라 이벤트 배지의 이름을 다르게 보여 주세요.
  - [x] 이벤트 배지가 부여되지 않는 경우, "없음"으로 보여 주세요.
- [x] 적용된 이벤트가 하나도 없는 경우는 아래 예시를 참고해 주세요.

# [🎯 프로그래밍 요구 사항]

- [x] JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**

- [x] 프로그램 실행의 시작점은 `Application`의 `main()`이다.

- [x] `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.

- [x] [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.

- [x] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.

- [x] 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**

- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

- [x] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.

  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.

  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.

- [x] 3항 연산자를 쓰지 않는다.

- [x] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.

  - [x] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.

  - [x] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.

- [x] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.

- [x] else 예약어를 쓰지 않는다.

  - [x] 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - [x] else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

- [x] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.

  - [x] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.

- [x] 사용자가 잘못된 값을 입력할 경우

​	 IllegalArgumentException 를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

​	Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

# [추가된 요구 사항]

- 아래 있는  InputView OutputView

  - 클래스를 참고하여 입출력 클래스를 구현한다.
  - 입력과 출력을 담당하는 클래스를 별도로 구현한다.
  - 해당 클래스의 패키지, 클래스명, 메서드의 반환 타입과 시그니처는 자유롭게 구현할 수 있다.

  ```java
  public class InputView {
      public int readDate() {
          System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
          String input = Console.readLine();    
          // ...
      }
      // ...
  }
  ```

  ```java
public class OutputView {
      public void printMenu() {
          System.out.println("<주문 메뉴>");
          // ...
      }
      // ...
  }
  ```
  
  

- [라이브러리]camp.nextstep.edu.missionutils 에서 제공하는 Console API를 사용하여 구현해야 한다.

- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.



# 이번 과제의 목표

- 커밋의 내용을 먼저 적고 구현을 해보자
  - TDD을 왜 해야되는지 느겼다.
  - 30분에 한번식 내가 무엇을 하는지 커밋을 보면서 확인을 하였다
- 기능구현당 커밋을 해보자, 너무 잘잘하게하니... 문제파악이 어려워서 실험적으로 적용해보자.
  - 커밋내용을 적고 커밋내용을 구현한수 커밋을 하였다
  - 문제파악과 기능구현의 효율적인 것을 느겼습니다.
- enum을 할용해보자.
  - enum을 활용해보니 너무 좋았습니다. 
  - 상수를 이용한 Searching의 방식을 보며
  - 왜 enum을 사용하는지 생각하였습니다.
- 객체지향적 관점
  - Discount의 abstruct의 추상클래스가 과연 맞는지 모르겠다. 하지만 만족스러운 결과를 가져온 것같다.
  - 할인의 공통점과 디데이, 주말, 평일, 특별 할인의 상속도를 생각을 하였습니다
  - 처음으로 추상클래스를 적용해 보았는데 객체지향의 개념이 확장되었습니다.
  - 정말 감사합니다 선생님들...😍

# 회고

- 클래스의 분리

  저는 이번과제에서 클래스의 분리을 최대한 노력을 하였습니다. 

  private가 기능을 담당하면 바로 클래스의 분리를 고민하였습니다.

  Discount의 abstract 클래스를 적용하여 상속을 적용하였습니다.
  
  아직 abstract을 사용이 맞는지에 관한 확신이 없습니다. 이는 코드리뷰를 통해 사람들과 이야기를 하고싶습니다.
  
  <img src="/Users/seungchan/Library/Application Support/typora-user-images/image-20231115112552009.png" alt="image-20231115112552009" style="zoom: 50%;" />
  
  화이트 보드에 그림을 그려가면서 작업을 하였습니다.
  
  혜택
  
  - 할인
  
    - Discount, DDayDiscount, WeekDayDiscount, WeekendDayDiscount, SpecialDayDiscount
  
    - DiscountManagement - Discount 클래스 관리
  
  - 증정품
  
    - Freebie, Champane
  
  - 배지
  
    - BadgeManagement
  
  주문
  
  - Order
  - OrderCalculator -  주문 금액 계산
  
  혜택 적용 금액
  
  - PaymentCalculator
  
  
  
- 상속을 적용

  저는 이 메서드를 사용을 하고 Overriding을 사용하는 이유을 깨닳았습니다.

  지금까지 상속에 대한 편함을 느낀적이 적었지만 이제 알았습니다.

  Overriding은 객체지향의 꽃이라는 것을 친구들에게 알려주고있습니다.

```java
#DiscountManagement.class
public class DiscountManagement {
    private final List<Discount> discountManagement = List.of(
	  	dDayDiscount(...),
      weekDayDiscount(...),
   	  weekendDayDiscount(...),
   	  specialDayDiscount(...),
   );

    private Integer calculatorTotalDiscount() { <- Overriding 사용
        return discountManagement.stream()
                .map(Discount::giveAmount)
                .reduce(0, Integer::sum);
    }
```

- Order클래스의 

```java
#Orders.class
		private Integer getMenuCount(MenuGroup appetizer) {
        Integer menuCount = 0;
        for (Map.Entry<String, Integer> order : orders.entrySet()) {
            String item = order.getKey();
            Integer quantity = order.getValue();

            Boolean isCondition = appetizer.isMenu(item);    <- enum 적용
            if (isCondition) {
                menuCount = menuCount + quantity;
            }
        }
        return menuCount;
    }
```

- enum을 활용한 

```java
#MenuGroup.enum
        List<MenuGroup> menuGroups = List.of(MenuGroup.MAIN_DISH, MenuGroup.APPETIZER, MenuGroup.DESSERT, MenuGroup.BEVERAGE);


=======
    public static List<MenuGroup> getAllMenuGroups() {
        return Arrays.asList(values());
    }


List<MenuGroup> menuGroups = MenuGroup.getAllMenuGroups();

```

- 이넘을 이용한 총 주문 액수 계산

  enum의 메서드를 이용하여 메뉴가 맞는지, 메뉴의 가격을 가져온다

  Menu.enum을 만들고 MenuGroup.enum을 이용해 Menu.enum을 관리하는 형태이다.

  enum에 메서드를 생성해본적은 처음이지만 너무 편한 방식인 것 같습니다.

```java
private Integer getMenuPrice(String menuName) {
  ...
  List<MenuGroup> menuGroups = MenuGroup.getAllMenuGroups();

  for (MenuGroup menuGroup : menuGroups) {
      if (menuGroup.isMenu(menuName)) { <- 메뉴가 맞는가?
          menuPrice = menuGroup.getMenuPrice(menuName); <- 메뉴의 가격을 가져온다
          break;
      }
  }
	...
}

#MenuGroup.enum
public Boolean isMenu(String orderMenu) {
    return menuList.stream()
            .anyMatch(menu -> menu.is(orderMenu));
}
```

```java
#InputView.class
public static void onlyBeverage(String orderString) {
    ...
    for (String orderValue : orderArr) {
        String 메뉴이름 = ...

        if (!MenuGroup.isBeverage(메뉴이름)) {
            return;
        }
    }
    throwNumberFormatExceptionAboutOrder();
}

#MenuGroup.enum
public static Boolean isBeverage(String orderMenu) {
	return BEVERAGE.isMenu(orderMenu);
}
```

- ui로직을 최대한 분리 (이제 ui라는게 무엇인지 알꺼같다.)

  "ui을  View클래스에서 관리하고 domain은 비지니스 로직에 집중하라" 라는 말을 이제 이해 했습니다.

- final사용

- 테스트를 위해 증정즘 샴페인 증정품을 클래스로 분리 - 3주차 조언 적용

  - Champagne.class 분리

    - 올바르게 적용을 하였는가는 고민을 해야겠지만

    - 증정품을 관리하는 Freebie클래스에서 Champagne의 클래스를 따로 관리를 하였습니다. 

    - ```java
      public class Champagne {
          private static final Integer CONDITION_SHAMPAGNE_ORDER_MONEY = 12_0000;
      
          public Map<String, Integer> makeChampagneCountInformation() {
             ... 증정품의 메뉴은 샴페인의 정보를 만든다.
          }	
        ...
      }
      ```

  - 문자열을 원하는 타입으로 파싱해주는 Parse.class 생성

    - Order에서 주문의 문자열을 Map 형식으로 파싱을 하였습니다.

    - 하지만 테스트를 적용하기에는 private이기에 테스트를 하지 못하였습니다. 

    - 그래서 클래스로 분리할 시기인가? 라는 고민을 하여 Parse.class으로 분리하여 테스트코드또한 작성하였습니다.

    - ```java
      public class Parse {
         	...
          public static Map<String, Integer> orders(String orderString) {
             ... 주문의 문자열을 Map 형식으로 변경을 한다.
          }
      }
      ```

- 테스트 이름 을 변경을 해야한다.

  테스트 메서드의 에름에 대한 고찰을 하였습니다. 

  지금까지 테스트 메서드의 이름을 테스트를 하고싶은 메서드의 이름을 사용하였습니다. 

  그렇게 하니 메서드를 변경을 하였을때 테스트 메서드또한 변경해야 한다는 것을 알았습니다. 

  메서드가 하는 역할, 기능에대한 이름을 부여하여 테스트를 하였으면 좋았을 것같다는 생각을 하였고

  지금까지 잘못하고 있었다는 생각을 하였습니다. 

  ```java
  이전 방식의 테스트 메서드 선언 방식 - 테스트 하고자하는 메서드 명시
  void giveTitle(Integer orderDay) {
      ...
  }
  
  변경된 테스트 메서드 선언 방식 - 행위, 기능, 역할의 이름을 부여
  void 디데이_할인의_제목을_확인한다(Integer orderDay) {
      ...
  }
  ```

  

- 전체적인 회고

  ~~order의 클래스에 종속성이 너무 심하다.... 이번과제에 잘못을 느겼습니다 객체의 독립성이 깨지니 분리가 너무 어렵습니다~~

  전체적인 클래스를 살펴보니 Order.class의 종속이 심하여 클래스의 분리가 힘들었습니다.

  지금도 분리가 가능한지, 분리가 맞는지 확신이 없는 상태입니다. 

  다음에 설계와 구상을할때 참고를 하여 작업을 해야겠습니다.

  혜택을 관리하는 Benefit.class을 생성하기 위해서는 Order클래스를 매개변수로 사용하여 생성을 해야됩니다.

  저는 Order와 Benefit을 분리하여 사용을 하고싶지만 분리할수없음을 알았습니다.

  ```java
  public class Management {
      private Benefit benefit;
      private Orders orders;
    
      private void generateBenefit(Integer orderDay, Orders orders) {
          benefit = Config.benefit(orderDay, orders);
      }
  
  ```

  

감사합니다 선생님들...🥰

이번 우테코에 떨어져도 아쉬움이 없습니다. 한달간의 프리코스 기간 동안 최선을 다했습니다. 

전기, 기계일을 하여 약6년 정도 일을 하고 고등학교때 부터 도전을 하고싶었지만 스스로의 확신과 무서움때문에 하지 못하였던 프로그램을 하고자 학교에 다시 복학을 하여 기계공학과에서 컴퓨터 공학과로 전과를 하였습니다.

2022년 6월테 우테코를 알았고 우테코에 관련된 모든 프로그램에 대한 공부를 하였습니다.  프로그램이 너무 재미있었습니다. 새로운 지식을 알고 동생, 친구들과 전공에 대해 토론하는 과정이 너무 신났으며

저의 생활에 프로그램을 적용하여 편리함을 느끼는 과정이 너무 짜릿했습니다. 

우테코덕분에 확장된 객체지향의 개념이 생겼고, 혼자 코딩을 하는 것이 아닌 남들과 협업을 하는 방법에 대해 고민하는 시간은 저의 프로그램의 습관을 봐꿔버리는 시간이었습니다. 

약 1년 4개월간 프로그램에 미쳐있었습니다.

우테코는 저에게  '세상을 프로그램하는 방식중 하나인' 객체지향에 대해 공부, 단위 테스트의 중요성, 요구사항을 분석하는 방법 등 저에게 너무 선물을 주었습니다. 

처음 프로그램을 하였을때 걱정과 비난을 하던 친구들과 가족들은 저의 꿈을 응원을 해주고 있습니다. 

프로그램의 벽을 없애준 우테코 선생님들께 정말 감사합니다ㅎㅎ

