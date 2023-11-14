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
  - [x]  2023.12.1 ~ 2023.12.31 동안 적용

- [x] **주말 할인** 하는 기능 구현 (금요일, 토요일)

  - [x] 주말에는 **메인 메뉴**를 메뉴 1개당 2,023원 할인
  - [x]  2023.12.1 ~ 2023.12.31 동안 적용

- [x] **특별 할인**하는 기능 구현 (이벤트 달력에 별)

  - [x] 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
  - [x]  2023.12.1 ~ 2023.12.31 동안 적용

- [x] **증정 이벤트**하는 기능 구현 

  - [x] 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
  - [x]  2023.12.1 ~ 2023.12.31 동안 적용
  
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

# enum

- enum으로 관리
- 2중 enum으로 관리 해보자.

```java
enum <메뉴> {
  enum <메인> {
	티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)
	}
	enum <애피타이저> {
	 양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)
	}
	enum <디저트> {
		초코케이크(15,000), 아이스크림(5,000)
  }
	enum <음료> {
		제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
  }
}
```

- enum으로 관리

- 특별 할인

```java
enum <할인>{
  enum <디데이 할인>{
    1일 부터(1000월) ~ 25일 까지 (3,400)월
  }
  enum <평일 할인>{
    일요일~목요일
    2,023원 할인
  }
  enum <주말 할인>{
    금요일, 토요일
    2,023원 할인
  }
  enum <특별 할인>{
    3, 10, 17, 24, 25, 31일
		1000원 할인
  }
}
```

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

- 커밋의 내용을 적고 구현을 해보자.

- 기능구현당 커밋을 해보자, 너무 잘잘하게하니... 문제파악이 어려워서 실험적으로 적용해보자.

- enum을 할용해보자.
- 객체지향적 관점
  - Discount의 abstruct의 추상클래스가 과연 맞는지 모르겠다. 하지만 만족스러운 결과를 가져온 것같다.

# 회고

- 상속 클래스의 구현

- Stream reduce 사용

```java
        // 이전
				Integer totalDiscount = 0;
        List<Integer> list = discountManagement.stream()
                .map(discount -> discount.giveAmount())
                .collect(Collectors.toList());

        for (Integer integer : list) {
            totalDiscount = totalDiscount + integer;
        }

				// 이후
        Integer totalDiscount = discountManagement.stream()
                .map(Discount::giveAmount)
                .reduce(0, Integer::sum);
        return totalDiscount;
```

- Order

```java
    private Integer getMenuCount(MenuGroup appetizer) {
        Integer menuCount = 0;
        for (Map.Entry<String, Integer> order : orders.entrySet()) {
            String item = order.getKey();
            Integer quantity = order.getValue();

            Boolean isCondition = appetizer.isMenu(item);
            if (isCondition) {
                menuCount = menuCount + quantity;
            }
        }
        return menuCount;
    }
```

- 이넘을의 모든 상수가 리스트로 반환

```java
        List<MenuGroup> menuGroups = List.of(MenuGroup.MAIN_DISH, MenuGroup.APPETIZER, MenuGroup.DESSERT, MenuGroup.BEVERAGE);


=======
    public static List<MenuGroup> getAllMenuGroups() {
        return Arrays.asList(values());
    }


List<MenuGroup> menuGroups = MenuGroup.getAllMenuGroups();

```

- 이넘을 이용한 총 주문 액수 계산

```java
    public Integer getOrderMoney() {
        Integer orderMoney = 0;
        Integer menuPrice = 0;

        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            String menuName = entry.getKey();
            Integer menuQuantity = entry.getValue();

            menuPrice = getMenuPrice(menuName);
            orderMoney = orderMoney + (menuPrice * menuQuantity);
        }
        return orderMoney;
    }

    private Integer getMenuPrice(String menuName) {
        Integer menuPrice = 0;
        List<MenuGroup> menuGroups = MenuGroup.getAllMenuGroups();

        for (MenuGroup menuGroup : menuGroups) {
            if (menuGroup.isMenu(menuName)) {
                menuPrice = menuGroup.getMenuPrice(menuName);
                break;
            }
        }

        return menuPrice;
    }
```

- 과연 매개변수로 Order을 받는게 맞는가?

```java
    public Boolean isEligible(Orders orders) {
        return orders.getOrderMoney() >= CONDITION_SHAMPAGNE_ORDER_MONEY;
    }
```

왜냐하면 비효휼 부를시 계산을 해야한다.

- ui로직을 최대한 분리 (이제 ui라는게 무엇인지 알꺼같다.)

- 검증의 순서가 중요하다

  ```java
    private void validateReadDate(String orderDateString) {
          InputValidate.includeBlank(orderDateString);
          InputValidate.orderDateRange(orderDateString);
      }
      
        private void validateReadDate(String orderDateString) {
          InputValidate.orderDateRange(orderDateString);
  				InputValidate.includeBlank(orderDateString);
      }
  ```

  

- 이넘을 관리하여 찾기

  ```java
  
      public static void onlyBeverage(String orderString) {
          String[] orderArr = orderString.split(COMMAR_REGEX);
  
          for (String orderValue : orderArr) {
              String[] partsOfDash = orderValue.split(DASH_REGEX);
              String menu = partsOfDash[MENU_NAME];
  
              if (!MenuGroup.isBeverage(menu)) {
                  return;
              }
          }
          throwNumberFormatExceptionAboutOrder();
      }
  ```

  

- 존제하지 않는 메뉴 찾기

```java
   public static void notExistenceMenu(String orderString) {
        String[] orderArr = orderString.split(COMMAR_REGEX);

        for (String orderValue : orderArr) {
            String[] partsOfDash = orderValue.split(DASH_REGEX);
            String menu = partsOfDash[MENU_NAME];

            if (notExistMenu(orderString)) {
                throwNumberFormatExceptionAboutOrder();
            }
        }
    }
```

- final로 막는점
- 테스트를 위해 증정즘 샴페인 증정품을 클래스로 분리 - 3주차 조언 적용
- [Refactor(christmas)] Order 클래스와의 종속성 독립

- 클래스 분리

- ```
  package christmas.domain.order;
  
  import java.util.HashMap;
  import java.util.Map;
  
  public class Parse {
      private static final String COMMA_REGEX = ",";
      private static final String DASH_REGEX = "-";
      private static final Integer MENU_NAME = 0;
      private static final Integer MENU_QUANTITY = 1;
  
      public static Map<String, Integer> orders(String orderString) {
          Map<String, Integer> menuMap = new HashMap<>();
  
          String[] orders = orderString.split(COMMA_REGEX);
  
          for (String order : orders) {
              String[] orderParts = order.split(DASH_REGEX);
              String menuName = orderParts[MENU_NAME];
              int orderQuantity = Integer.parseInt(orderParts[MENU_QUANTITY]);
  
              menuMap.put(menuName, orderQuantity);
          }
  
          return menuMap;
      }
  }
  
  ```

  

- ```
      public Map<String, Integer> getOrderInformation(Integer orderDay, String orderString) {
          generateOrder(orderString);
          generateBenefit(orderDay, orders);
  
          return orders.getOrderInformation();
      }
  ```

- 테스트 이름 을 변경을 해야한다.

  이번에 느꼈다 테스트 이름을 지금까지 잘못한것 같다 메서드 이름이 아닌 행위의 기능을 단위 테스트 했으면 좋았을텐데 

  테스트또한 메서드이다 자료형이 들어가면 안된다

- 전체적인 회고

  order의 클래스에 종속성이 너무 심하다.... 이번과제에 잘못을 느겼습니다 객체의 독립성이 깨지니 분리가 너무 어렵습니다