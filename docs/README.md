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

- [x] IllegalArgumentException 를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

- [x] Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

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

```
- [라이브러리]camp.nextstep.edu.missionutils 에서 제공하는 Console API를 사용하여 구현해야 한다.

- 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
```



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
  - 이번 문제는 너무 재미있게 풀었습니다. 상속을 적용을 의도한지는 몰랐지만 상속을 사용해보세요... 라고 말하는 기분이였습니다.

# 회고

- 클래스의 분리

  저는 이번과제에서 클래스의 분리을 최대한 노력을 하였습니다. 

  private가 기능을 담당하면 바로 클래스의 분리를 고민하였습니다.

  Discount의 abstract 클래스를 적용하여 상속을 적용하였습니다.
  
  아직 abstract을 사용이 맞는지에 관한 확신이 없습니다. 이는 코드리뷰를 통해 사람들과 이야기를 하고싶습니다.
  
  <img src="https://private-user-images.githubusercontent.com/76943741/283008517-6cc79fad-39e1-4377-a47c-3c2d77dcffda.jpeg?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTEiLCJleHAiOjE3MDAwMzQ1NzYsIm5iZiI6MTcwMDAzNDI3NiwicGF0aCI6Ii83Njk0Mzc0MS8yODMwMDg1MTctNmNjNzlmYWQtMzllMS00Mzc3LWE0N2MtM2MyZDc3ZGNmZmRhLmpwZWc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBSVdOSllBWDRDU1ZFSDUzQSUyRjIwMjMxMTE1JTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDIzMTExNVQwNzQ0MzZaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1jMDRiNWIzMzA1ZmM2ZmIzOGNhZDIwMjNlZjA3ZWUwNGNiMWY3NjY5Njk4YTY2NzZiM2UzYmYyOWU3ZWYxYzBjJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.KdpYILSbhjsSO73JyvIElLcL3M85Fv2r6ZzpRoxBAEA" alt="클래스_관계도" style="zoom: 25%;" />
  
  화이트 보드에 그림을 그려가면서 작업을 하였습니다.
  
  **클래스**
  
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
  
  
  
- 상속을 Overriding 적용

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

- Order클래스의 enum적용

```java
#Orders.class
private Integer getMenuCount(MenuGroup appetizer) {
	...
	Boolean isCondition = appetizer.isMenu(item);    <- enum 적용
	...
}
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
      if (menuGroup.isMenu(menuName)) { <- enum 메뉴가 맞는가?
          menuPrice = menuGroup.getMenuPrice(menuName); <- enum 메뉴의 가격을 가져온다
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
    String 메뉴이름 = ...

    if (!MenuGroup.isBeverage(메뉴이름)) {
        return;
    }
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




# 회고 - 제출

<abstract 클래스 적용>

이번 과제에서는 클래스의 분리를 최대한 고려하였고, 처음으로 abstract 클래스를 도입해 보았습니다.

'디데이', '주말', '평일', '특별 할인' 등 할인이라는 공통적인 부분을 기본 클래스로 설정하고, 오버라이딩을 메서드를 구현하는 방식을 시도해 보았습니다.

인터페이스를 선언하여 구현하고 싶었지만, 인터페이스 내에서 static을 구현해야 하는 부분이 마음에 걸려, 책에서만 보아 왔던 추상 클래스를 사용하여 구현하게 되었습니다.

Discount라는 기본 클래스를 상속받아 'dDayDiscount', 'weekDayDiscount', 'weekendDayDiscount', 'specialDayDiscount'를 선언하였고, 주문 날짜에 해당하는 혜택의 금액을 'Discount#giveAmount()'를 이용해 값을 얻는 과정에서 큰 희열을 느꼈습니다.

아직도 추상 클래스를 사용한 점에 대해 의심하고 있습니다. 더 나은 방법에 대한 확신이 없어, 코드 리뷰를 통해 다른 사람들과 이야기를 나누고 싶습니다.

그러나, 결과적으로는 성공적이었다고 생각합니다🤔



<enum 클래스 적용>

3주차 과제에서는 enum을 적용해 보았고, 더 많은 적용 사례를 공부한 뒤, 이번에는 메뉴 관리와 할인 날짜 관리에 도전해 보았습니다. Menu.enum 안에 메뉴의 이름과 가격을 선언하였고, MenuGroup.enum을 이용하여 찾고자 하는 이름이 메뉴에 있는지, 그리고 그 가격이 얼마인지를 알 수 있는 'MenuGroup#isMenu'와 'MenuGroup#getMenuPrice'을 사용하는 과정에서 상수을 어떻게 관리해야 하는지에 대한 이해를 더욱 깊게 하게 되었습니다.

enum을 단순히 상수를 관리하는 클래스라고 생각했었는데, 이번에 enum 안에 상수들을 이용해 관리해주는 메서드를 선언하고 사용하면서, enum과 interface, abstract등 모든건 만들어진 이유가 있으며, 클래스를 만들 때 생각을 많이 해야 한다는 것을 깨달았습니다



<ui을  View클래스에서 관리하고 domain은 비지니스 로직에 집중하라>

저는 클래스를 클래스 답게 관리하는 방법에 대해 고민하게 되었습니다. 클래스를 어떻게 클래스 답게 사용할 것인가를 고민하는 시간은 매우 가치 있는 시간이었습니다.

지금까지 클래스에 UI 관련 메서드를 만들었습니다. 당시에는 출력을 View에서 하니, UI와 비즈니스 로직이 분리되었다고 생각했었습니다. 하지만, 이는 완전한 분리가 아니었다는 것을 깨달았습니다.

'비즈니스 로직과 UI 로직을 한 클래스가 담당하지 않도록 한다. 이는 단일 책임 원칙에도 위배된다.'라는 말을 보며 UI 클래스를 제외한 클래스들은 값의 이동만 책임지며, 사용자에게 보여지는 UI 클래스에서는 UI 작업만 담당한다는 것을 이해하게 되었습니다. , 책임에 대한 이해도가 높아졌습니다.



<클래스 분리>

  'private 함수를 테스트 하고 싶다면 클래스(객체) 분리를 고려한다'라는 말을 보고, 이번 과제를 진행하면서 이를 고려해보기로 결정했습니다. 클래스를 분리하는 것은 정말 어려운 작업입니다. 과도하게 분리하면 클래스의 남용이 되어 이해하는 데 어려움을 겪을 수 있습니다. 하지만  선생님들의 피드백은 이 과정에서 큰 도움이 되었습니다. 

  Champagne.class, Parse.class, OrderCalculator.class, PaymentCalculator.class 등의 클래스들은 '가독성 이상의 역할을 하는 경우, 테스트하기 쉽게 구현하기 위해서는 해당 역할을 수행하는 다른 객체를 만들 타이밍이 아닐지 고민해 볼 수 있다.'라는 글에서 힌트를 얻어 클래스 분리를 시도해보았습니다.

  가독성 이상의 역할을 하는 private 메서드는 클래스의 책임을 가지고 있으며, 이런 분할 과정을 통해 클래스의 책임을 줄이는 과정을 공부하고 생각해보는 것이 유익했습니다. 이런 훈련은 점차 많은 클래스 간의 관계성을 구상하는 데 도움이 된다고 확신하고 있습니다. 

<테스트 코드>

  지금까지 저는 테스트 메서드의 이름을 테스트하고 싶은 메서드의 이름으로 사용하였습니다. 그러나 그렇게 하다 보니, 메서드를 변경하였을 때 테스트 메서드 역시 변경해야 하는 작업이 생기게 되었습니다. 그래서 메서드가 하는 역할이나 기능에 대한 이름을 부여하여 테스트를 진행하는 것이 더 좋겠다는 생각을 하였고, 테스트 메서드의 이름을 변경하게 되었습니다.

  테스트 코드는 지금까지 제가 만든 메서드가 제대로 반환을 하는지에 대한 테스트를 진행하였지만, 생각을 확장해 보니 내가 지금 작업하는 기능을 먼저 확인하는 것이 테스트 코드라는 저만의 생각을 가지게 되었습니다.

  '단위 테스트하기 어려운 코드를 단위 테스트하기'라는 피드백을 계속 상기하며 코드를 작성하였습니다. 단위 테스트를 하기 어려운 코드는 많은 책임을 가지고 있는 코드를 의미하는 것 같습니다. 이는 책임을 분할하는 과정을 말하는 것 같습니다. 앞으로도 선생님들의 피드백을 곱씹어 보며, 저만의 생각을 가지고 싶습니다.



<문제점>

전체적인 클래스를 살펴볼 때, Order.class가 다른 클래스에 너무 많이 종속되어 있어 클래스 분리가 어렵다는 것을 느꼈습니다. 지금도 분리가 가능한지, 분리가 맞는지에 대한 확신이 서지 않습니다. 다음에 설계와 구상을 할 때에는 이 점을 참고하여 작업을 해야겠다는 생각을 하였습니다.

혜택을 관리하는 Benefit.class를 생성하기 위해서는 Order 클래스를 매개변수로 사용하여 생성해야 합니다. 저는 Order와 Benefit을 분리하여 사용하고 싶었지만, 그것이 불가능하다는 것을 알게 되었습니다.

객체의 독립성을 유지하면서 설계하는 것이 어렵다는 것을 다시 한번 상기하였고, 많은 전공 책과 다른 사람들의 의견을 참조하면서 계속 생각을 정리하는 시간을 가져야겠다는 결심을 하였습니다.

---

감사합니다 선생님들...🥰

이번 우테코에 떨어져도 아쉬움이 없습니다. 한 달 동안의 프리코스 기간 동안 저는 최선을 다했습니다.

저는 전기와 기계 관련 일을 약 6년 동안 해왔습니다. 고등학교 시절부터 프로그래밍에 대한 관심이 있었지만, 스스로의 확신이 부족하고 두려움에 이를 실천에 옮기지 못했습니다. 결국 용기를 내어 학교에 복학을 하여 기계공학에서 컴퓨터 공학으로 전과하는 결정을 내렸습니다.

2022년 6월쯤 우테코를 알게 되었고,  우테코에 관련된 공부를 하였습니다.  프로그램이 너무 즐거웠습니다. 새로운 지식을 습득하고 동생, 친구들과 토론하는 과정이 신났으며, 일상 생활에 프로그래밍을 적용해보며 그로부터 오는 편리함을 직접 느끼는 과정은 매우 짜릿했습니다.

우테코덕분에 저는 확장된 객체지향의 개념을 이해하게 되었습니다. 또한, 단독으로 코딩을 하는 것이 아니라 다른 사람들과 협업하는 방법에 대해 많은 고민을 하게 되었습니다. 이러한 시간은 저의 프로그래밍 습관을 완전히 변화시키는 계기가 되었습니다.

약 1년 4개월 동안 저는 프로그래밍에 전념했습니다.

우테코는 저에게 '세상을 프로그래밍하는 한 방식인' 객체지향에 대한 깊은 이해, 단위 테스트의 중요성, 그리고 요구사항 분석 방법 등을 가르쳐 주었습니다. 이 모든 것들은 저에게 귀중한 선물처럼 느껴졌습니다.

프로그래밍을 처음 시작했을 때, 걱정과 비난을 하였던 친구들과 가족들이 이제는 저의 꿈을 응원해주고 있습니다.😎

프로그래밍의 장벽을 제거해준 우아한테크코스의 선생님들께 진심으로 감사의 말씀을 전하고 싶습니다.😭

