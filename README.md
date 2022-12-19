# Spring Modulith Demo

코드 구조를 도메인에 맞추도록 초점에 맞추면 궁극적으로 더 이해하기 쉽고 유지보수가 용이한 어플리케이션이 탄생하는 것으로 입증되었다.

Spring Monolith 는 패키지를 기준으로 Spring Bean 의존성을 부여한다.

아래와 같은 구조가 있고, `Application.java` 에 `@SpringBootApplication` 이 있다면

```
demo
ㄴ Application.java
demo.inventory
ㄴ ...
demo.order
ㄴ ...
```

`inventory` 와 `order` 는 논리적인 모듈로 보고 각 하위 패키지들의 Spring Bean 들을 읽어들인다.

테스트 코드 중 `verifiesModularStructure` 테스트를 디버깅으로 찍어보면 알 수 있는데

### inventory

```
## inventory ##
> Logical name: inventory
> Base package: kr.pe.karsei.springmodulithdemo.inventory
> Spring beans:
  o ….InventoryInternal
  + ….InventoryManagement
  o ….InventorySettings
```

### order

```
## order ##
> Logical name: order
> Base package: kr.pe.karsei.springmodulithdemo.order
> Spring beans:
  + ….OrderManagement
  + ….internal.OrderInternal
```

위처럼 각 논리 모듈 상에서 Spring Bean 들을 읽어들이는 모습을 확인할 수 있다.

참고로, `order` 안에 있는 어느 Bean 상에서 `inventory` 에 있는 Bean 을 참조하려고 한다면 오류가 난다. (물론 따로 코드를 통해 의존성을 해제할 수 있다)

# References

* https://docs.spring.io/spring-modulith/docs/current-SNAPSHOT/reference/html/#fundamentals
* https://github.com/spring-projects-experimental/spring-modulith