# JPA 종속성 예시 프로젝트

이 프로젝트는 Spring Boot 애플리케이션에서 JPA 에 종속적인 구조의 문제점을 시연하기 위한 예시 애플리케이션입니다.  
JPA 와 MySQL 을 사용하여 간단한 상품(Product) CRUD 기능을 구현하고, 데이터 액세스 계층이 JPA 에 강하게 결합된 구조를 보여줍니다.

## 프로젝트 구조

```
com.example.jpaexample
├── domain                  # 도메인 엔티티
│   └── Product.java        # 상품 엔티티
├── infrastructure          # 데이터 접근 계층
│   ├── ProductJpaRepository.java  # JPA 리포지토리
│   ├── persistence         # JPA 엔티티
│   │   └── ProductPersistenceEntity.java  # 상품 JPA 엔티티
│   └── tobe                # 개선 시도 패키지
│       ├── ProductDataAccess.java      # 데이터 접근 인터페이스
│       └── ProductDataAccessImpl.java  # JPA 기반 구현체
├── presentation            # 컨트롤러 계층
│   ├── ProductController.java  # REST API 엔드포인트
│   └── dto                 # 요청/응답 DTO
├── service                 # 비즈니스 로직 계층
│   ├── ProductService.java      # 서비스 인터페이스
│   └── ProductServiceImpl.java  # 서비스 구현체
```

## JPA 종속성 설명

이 프로젝트는 다음과 같은 이유로 JPA 에 강하게 종속되어 있습니다:

1. **엔티티 클래스의 JPA 의존성**:
   - `Product` 클래스는 `@Entity`, `@Id` 등 JPA 애노테이션을 직접 사용
   - 도메인 모델이 영속성 프레임워크에 종속됨

2. **인프라스트럭처 레이어의 JPA 의존성**:
   - `ProductJpaRepository` 클래스는 `JpaRepository` 인터페이스를 상속
   - 서비스 레이어에서 `JpaRepository`를 직접 사용

## 문제점

이러한 JPA 종속성이 가진 문제점:

1. **기술 변경의 어려움**:
   - 다른 저장소로 변경 시 대규모 수정이 필요할 수 있음
   - 특히 엔티티 계층의 변경은 전체 애플리케이션에 영향

2. **비즈니스 로직과 영속성 로직의 혼합**:
   - 도메인 모델이 데이터베이스 구조에 종속됨
   - 비즈니스 요구사항보다 기술적 제약이 모델 설계를 주도

## 개선 시도

`infrastructure.tobe` 패키지에서 인터페이스를 통한 추상화 진행

1. **인프라스트럭처 레이어의 JPA 의존성 해결**:
   - `ProductDataAccess` 인터페이스 도입
   - `ProductDataAccessImpl`에서 JPA 의존성을 숨김
   - 서비스 레이어에서는 `ProductDataAccess` 인터페이스를 사용

2. **도메인 엔티티와 영속성 엔티티 분리**:
   - `Product` 엔티티는 영속성과 관련 없는 순수한 비즈니스 로직만 포함
   - `ProductPersistence` 엔티티는 JPA 관련 애노테이션을 포함

## 개선 결과

| 문제점                  | As-Is                   | To-Be                                                                       | 개선여부 |
|----------------------|-------------------------|-----------------------------------------------------------------------------|------|
| **서비스 계층의 기술 의존성**   | 서비스가 `JpaRepository`에 직접 의존 | 서비스가 `DataAccess` 인터페이스에 의존 (`JpaRepository` 에 대한 의존은 감춰짐)                  | ✅    |
| **도메인 엔티티와 영속성 엔티티** | 비지니스 로직과 영속성 로직이 혼재     | 두 개념을 분리하여 도메인 엔티티는 순수한 비지니스 로직만을 가짐 (다만 변환 과정이 추가되었지만, 수용할만 한 트레이드오프라 생각함) |✅|
## API 엔드포인트

- `GET /api/products` - 모든 상품 조회
- `GET /api/products/{id}` - ID로 상품 조회
- `POST /api/products` - 상품 생성
- `PATCH /api/products` - 상품 수정
- `DELETE /api/products` - 상품 삭제

## 도커를 통한 실행 방법

### 실행 방법

1. 프로젝트 루트 디렉토리에서 다음 명령어 실행:

```bash
docker-compose up --build
```

2. 애플리케이션이 성공적으로 시작되면 다음 주소로 API에 접근할 수 있습니다:
```
http://localhost:8080/api/products
```

### 종료 방법

1. 다음 명령어로 컨테이너 중지 및 리소스 정리:

```bash
docker-compose down
```

2. 데이터베이스 볼륨을 포함한 모든 리소스를 삭제하려면:

```bash
docker-compose down -v
```

### 구성 설명

- **MySQL**: 컨테이너는 포트 3306으로 노출되며, 초기 데이터베이스 `jpaexample`이 생성됩니다.
- **애플리케이션**: Spring Boot 애플리케이션이 포트 8080으로 노출됩니다.
