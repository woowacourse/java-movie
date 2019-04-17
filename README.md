# java-movie
> 우아한 테크코스 - 오프라인 코딩테스트 '영화예매' 구현

## 기능 목록
- 상영영화목록 출력
- 예약할 영화 선택
  - validate : 유효한 영화id인지
- 예약할 시간표 선택
  - validate : 유효한 시간표값인지, 이미담은 영화와 1시간이상 차이나지않는지
- 예약할 인원 입력
  - validate : 양수인지, 예약가능인원보다 크지않은지, 현재시간 이후인지
- 영화 담기
  - 선택한 영화와 인원 담기
  - 예약가능인원 갱신
- 결제 진행 or 추가 예약
  - 추가예약시, 다시 앞으로
  - 결제진행시, 예약내역 출력
- 결제 진행
  - 사용할 포인트 입력
  	- validate : 양수인지, (결제금액보다 많다면 최종금액 0원)
  - 신용카드 or 현금
  	- 5% or 2% 할인
  - 최종금액 산출
  - 출력


### 시간관계상 구현하지 못한 기능
- 시간표를 선택할때, 이미 담은 영화와 1시간이상 차이나는지 확인하는 validate logic.
- MainApplication과 main()의 메소드 분리 및 Refactoring 작업
...


### 클래스 구성
- MovieApplication
- (domain)
  - Movie
  - MovieRepository
  - PlaySchedule
  - SelectedMovie
- (view)
  - InputView
  - OutputView
- (utils)
  - DateTimeUtils
