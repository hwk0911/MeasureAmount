# MeasureAmount Conference

## 20-03-16   
### 회의 참여자  
요구 : 비앤드지투  
기획 : laid_3  
개발 : cafeCoder   

### 프로그램 요구사항 및 분석
    1. 기능 구현목록 정리
        1. GUI
        2. 엑셀파일 load & save
        3. 발주 목록 계산
        4. 버전 컨트롤러 (자동 업데이트)
        
    2. 1.0.0.0 에서의 개선 사항
        1. xlsx파일로 결과 파일 출력
        2. 시트 별 데이터 분리
            N번 시트      : 기존 출력데이터
            N + 1 번 시트 : 모든 시트의 데이터 합
            
        3. GUI 탐색기 기능 + 드래그 앤 드랍 기능 추가

### 요구사항에 대한 초안
1. GUI 초안  
    1. Loading       
![](https://github.com/hwk0911/MeasureAmount/blob/master/resource/Scheme/load.png?raw=true)
    
    2. Main   
![](https://github.com/hwk0911/MeasureAmount/blob/master/resource/Scheme/MAIN_%EC%B4%88%EC%95%88.png?raw=true)

## 20-03-17   
### 회의 참여자  
요구 : 비앤드지투  
기획 : laid_3  
개발 : cafeCoder   

### 내용   
    1. 로딩창 사이즈
        1. 기존 이미지의 사이즈를 그대로 사용하여 출력한다.
        2. Title bar 숨기기
        
    2. Main 사이즈
        1. 해상도 별 동적으로 변하도록 설정
        2. Title bar 표현
        
    3. 공통
        1. 생성 위치 - 중앙

## 20-03-19   
### 회의 참여자  
요구 : 비앤드지투  
기획 : laid_3  
개발 : cafeCoder   

### 내용   
    1. 프로토타입 구현에 따른 부족한 기능 파악
    2. 세부적인 GUI 환경 개선 회의 (1차)
    3. bug fix
        프로그램 종료 없이 XLSX파일을 다시 열 때 기존 데이터가 삭제되지 않고 남아있는 현상 수정
        수정 방식 : List<File> object = null
                    object = new ArrayList<>();
