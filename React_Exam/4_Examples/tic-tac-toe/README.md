# Tic Tac Toe 게임 만들기

## 1. App 컴퍼넌트 만들기
- 기본 구조 준비

## 2. Board, Square 컴퍼넌트 만들기
- components / Board.js
- components / Square.js

### (1) 3 * 3 게임판 만들기

### (2) 간단한 스타일링

## 3. props를 통해서 컴퍼넌트 간 데이터 전달하기

## 4. 사용자와 상호 작용하는 컴퍼넌트 만들기
- Square Component를 클릭하면 "click" 로그를 출력

## 5. state 추가하기
- Square Component를 클릭한 것을 기억하게 만들어 'x' 표시를 채워넣는다

## 6. 부모 컴퍼넌트에 state 보관하기
- Board.js에 state를 생성하여 자식들(Square)에게 props로 전달

## 7. 불변성에 대해서
- 자바스크립트에서 원시 타입은 불변성을 가지고, 참조 타입은 그렇지 않다
    - 원시 타입: Boolean, String, number, null, undefined, ..
        - let a = 10;
        - a = 20;
    - 참조 타입 : Object, Array

- 불변성은 왜 지켜야 하는가?
    - 참조 타입에서 객체나 배열의 값이 변할 때, 원본 데이터가 변하기 때문에 이 원본 데이터를 참조하는 다른 객체에서 예상치 못한 오류 발생
    - 리액트에서는 화면을 업데이트 할 때 불변성을 지켜서 값을 이전 값과 비교해서 변경된 사항을 확인한 후 업데이트를 하기 때문

- 불변성을 지키는 방법은?
    - spread operator(...), map, filter, slice, reduce
    - 원본데이터 변경: splice, push

## 8. 함수형 컴퍼넌트로 변경
