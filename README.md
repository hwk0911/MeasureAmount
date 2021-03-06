# MeasureAmount Ver 1.0.0.0

# 에이블리 발주 항목 계산기  

## 프로젝트 참여 
요구 : [비앤드지투](http://a-bly.com/app/markets/?sno=4673)   
기획 : laid_3   
개발 : cafeCoder     

### [jar & exe Download](https://drive.google.com/open?id=1wU79iWMZq5T_G_Qn0p7ZGsBZ-s-MGJM2)

## Class   
1. Calculator  
불러 온 엑셀을 저장한 데이터를 다룸.  
이중 맵을 사용하여 상품명에 대한 옵션들을 정리   

2. GUI   
메인.  
Swing, Jframe,  등 외형을 담당한다.  
JChooser를 통한 탐색기 구현

3. XLSXController  
Xlsx 파일을 불러, 해당 엑셀을 분석 및 사용하기 쉽게 데이터로 변환한다.  
상품명, 옵션 정보, 수량 에 대한 데이터를 리스트 항목으로 인덱스로 저장하여,  
이중 맵을 통해 데이터를 저장한다. 후에 Calculator 클래스를 통해 연산한다.  

4. SaveText  
계산 된 데이터를 토대로, 기본 저장위치 (download 디렉토리)에 data.txt파일로 
저장한다.


## 실행  
1. GUI를 통해 사용자가 엑셀 파일을 JFileChooser로 구현 된 탐색기를 통해
불러온다.   

2. XLSXController 클래스에서 Xlsx파일을 분석 및 데이터를 가공한다.  

3. Calculator 클래스에서 가공 된 데이터를 받아 각 항목에 대한 연산을 수행한다.  

4. SaveData 클래스에서 연산 된 데이터를 받아 defaultDirectory + "₩data.txt" 위치로   
저장한다.

5. 다시 GUI 클래스로 돌아와 저장 된 data.txt 파일을 실행하고,  
해당 Xlsx 파일 분석이 끝난다.


# MeasureAmount Ver 2.0.0.0 업데이트 예정
  1. 매출 총 합
  2. 엑셀 파일 여러개 로드하여 한번에 연산하는 기능
  3. GUI 개선
  4. 드래그앤 드랍으로 파일 업로드기능 추가 (xlsx 확장자만 지원)
  5. 파일 출력 xlsx 확장자로 출력하도록 변경
  
 
## 개발 진행도
  ### 20-03-16
    프로그램 요구사항 및 분석 회의
    
  ### 20-03-17
    프로그램 상세 설정, Loading 화면 개발

  ### 20-03-18
    코드 리팩토링, 메인컨테이너 버튼 레이아웃 배치 완료

  ### 20-03-19
    코드 리팩토링, 전체적인 프로토타입 구현
    
  ### 20-03-20
    코드 리팩토링, bug fix
    1. 수량체크 잘못되는 에러 수정
    2. OneDrive로 인한 경로 에러 수정
    3. 경로 변경으로 인해 연산 종류 후 해당 디렉토리 열어주는 기능 추가
