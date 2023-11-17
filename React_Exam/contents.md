# 1. 리액트란?
사용자 인터페이스를 만들기 위한 자바스크립트 라이브러리이다.
- Virtual DOM
- Component
    - 리액트로 만들어진 앱을 이루는 최소한의 단위
    - 클래스형 컴퍼넌트, 함수형 컴퍼넌트

# 2. 프로젝트 구성 방법
## (1) 손수 작성하는 방법
    - babel, webpack, 그 외 툴 설치

## (2) CRA (Create React App)

## (3) Online Code Tool
    - CodeSandbox 사용

# 3. TypeScript
## (1) 특징
    - JS Static TypeChecker (compile할때 타입체크)
    - 아직 web에서는 실행안됨
    - 자바스크립트의 Superset
    - MS에서 만든 오픈소스

## (2) 실습
### 1) 프로젝트 만들기
    - npm init
    - npm install -D typescript

### 2) 코드 작성 및 실행
    - ts 파일을 작성하고 tsc로 컴파일 -> js로 변환시켜줌
    - npx tsc 파일명
    *설정 파일 만들기

## (3) 기본 타입들
    - number
    - string
    - boolean
    - array
    - object
    - enum
    - any
    - unknown
    - void
    - never
    - null
    - undefined

## (4) Function
    - Parameter type
    - Return type

## (5) Union & Intersection
    - union
        + 여러 타입들 중 하나
        + or(|) 연산자
    - intersection
        + 여러 타입들을 하나로 결합
        + And(&) 연산자

## (6) Type Alias & Interface
타입에 대한 정의를 저장하여 재사용성을 높이는 타입 정의



# 4. 리액트 매뉴얼 설치
[*]Eslint & Prettier : Linter & Formatter
- JS코드 작성 시 놓치는 부분을 도와주는 틀
- 주로 코드 컨벤션, 문법적 오류, 포매팅 등을 도와준다.
    - Eslint : https://eslint.org
        - npm init @eslint/config
    - Prettier : https://prettier.io
        - npm install --save-dev --save-exact prettier
        - prettier 설정 파일 만들기: .prettierrc.json
    - eslint-plugin-prettier : https://prettier.io/docs/en/integrating-with-linters
        - npm install --save-dev eslint-plugin-prettier

[ ] TypeScript : Static Typechecker
    - https://www.typescriptlang.org/
    - npm i typescript -D --save
    - 설정파일 만들기: tsconfig.json

[*] Babel : Transpiler
- 최신 문법의 JS를 특정 버전의 JS로 변화해주는 틀
- 현재 작성된 코드가 다양한 환경에서 호환될 수 있도록 도와준다.
- 특히 리액트에서는 JSX문법을 JS로 변환해주는 역할
- https://babeljs.io
    - npm install --save-dev @babel/core @babel/cli
    - npm install --save-dev babel-loader
    - npm install @babel/preset-env --save-dev
    - babel.config.json 파일 생성

[ ] Webpack : bundler
- 방대해진 JS프로젝트 코드를 최적의 조건으로 전달할 수 있도록 프로젝트 코드를 모아서 적절한 기준으로 나눠 파일에 담는 역할
- https://webpack.js.org
- npm install webpack webpack-cli --save-dev
- npm install ts-loader --save-dev
- webpack.config.js 설정파일 생성

[ ] 리액트
    - npm i react react-dom
    - npm i -D @types/react @types/react-dom

[ ] webpack-dev-server
    - npm install --save-dev webpack-dev-server
    - npx webpack serve

# 5. CRA 사용법
- https://create-react-app.dev
    - npx create-react-app my-app
    - Typescript는 따로 설치 : npx create-react-app my-app --template typescript

# 6. Online Code Tool 이용
- https://codesandbox.io

# 7. Virtual DOM, ReactElement, JSX, ReactComponent
## (1) Virtual DOM 
- 화면에 랜더링이 되지 않고, 메모리에만 존재하는 DOM
- DOM 변경 사항 => Virtual DOM => Real DOM

## (2) ReactElement
자기가 표현하고 싶은 무언가를 담고있는 내용 (Virtual dom에 던져진 내용)
- React.createElement(type, [props], [...child])

## (3) JSX
- Javascript + XML: Action + View
- 코드를 줄이고 View를 직관적으로 상상할 수 있게 도움을 준다.
- 주의할 점
    - Babel에 통해서 JSX -> JS로 Tranpiling이 필요하다
    - 시작과 끝태그가 반드시 한 쌍으로 묶여야 한다
    - 반드시 하나의 요소로 표현해야 한다
    - 중괄호를 이용하여 JS표현식을 사용할 수 있다
- compiling : npx tsc

## (4) Component
- input으로 props를 받고, output으로 Element를 내보내주는 것
- 작성 방식
    - Class Component
        - 생성자로 props를 받고 render를 통해서 Element를 내보낸다.

    - Function Component
        - 매개변수로 props를 받고 리턴값으로 Element를 내보낸다.
- 설계 방법
    - Highter Order Component Pattern
    - Compound Component Pattern
    - Provider Pattern
    - Hook Pattern
    - Atomic Design Pattern

# 8. Component 활용
## (1) Props & State
리액트로 동적페이지를 만들고 싶다면 Virtual DOM을 업데이트 할 줄 알면 된다.
그 방법은 바로 Props & State를 변경하는 것이다.

### 1) Props
- 외부에서 주입되는 데이터로 부모 컴퍼넌트에서 자식 컴퍼넌트로 전달
- 순수 JS객체로 컴퍼넌트안에서 수정되어서는 안된다.

### 2) State
- 컴퍼넌트에서 생성되며, 내부에서만 사용가능한 값이다.
- 순수 JS 객체로 수정 가능하다.
- 업데이트 방법: setState() 사용

### 3) 업데이트 과정
- Diffing Algorithm
리액트에서는 New Element와 Old Element의 비교를 통해서 Virtual DOM을 변경하는 작업을 Reconcilation(재조정)이라고 한다.
- 알고리즘
    - Type이 다르면 이전 트리를 버리고 새로운 트리를 적용한다. 이 과정에서 자식 엘리먼트들도 모두 제거된다.
    - 같은 타입의 DOM Element일 경우, 속성이 다른 내용에 대해서만 새롭게 수정한다.
      자식은 재귀적으로 Diffing Algorithm을 따른다.
    - 같은 타입의 Component Element인 경우에는 State는 유지되고 Props는 새로 만들어진 후 render를 호출해 비교한다.
    - 여러 개의 동일한 엘리먼트가 같은 깊이에 존재한다면, key 속성을 통해서 업데이트의 대상을 고를 수 있다.

## (2) Life Cycle
- https://projects.wojtekmaj.pl/react-lifecycle-methods-diagram/

### 1) Mounting
constructor => render => Update Read Dom => componentDidMount

### 2) Updating
render => Update Real DOM => componentDidUpdate

### 3) Unmounting
componentWillUnmount

### 4) Process
props => component => render() => Element => 비교 알고리즘 => Virtual DOM => Real DOM

<hr>

# 9. Function Component
## (1) Hooks
기존의 클래스 컴퍼넌트는 View와 Logic이 붙어있기 때문에 이것을 잘라서 분리시키고, 로직은 로직만의 자유로움을 가질 수 있게 하는 것이 Hook의 역할이다.
- View는 Function Component가 담당하고 Logic은 Hook이 담당한다.
- Hooks란 컴퍼넌트 외부로 렌더 로직을 분리하기 위한 수단으로 로직의 재사용성을 높이며 Function Component에 더 적합한 방식이다.

## (2) Hooks API
### 1) useState
- Function Component는 기본적으로 상태를 관리할 수 있는 컴퍼넌트가 아니다.
- Stateless => Stateful
- [상태값, 상태변경함수] = useState(초기값)

### 2) useEffect
- Side Effect
    - 네트워크 요청
    - 직접적인 DOM 변경
    - 로깅
    - 타이머 설정
    - 데이터 구독
- DOM에 반영된 이후 필요한 작업들을 어디에선가 처리를 ㅎ줘야 하는데, 이 때 이것들을 처리해주는 API
- useEffect(함수, [의존성])
- 모든 Render마다 => 의존성 체크 => clean up 동작 =>Effects 동작
- 의존성은 Effects 발동 조건: 배열 내의 데이터가 변경되었을 때에만 Effects 실행
- Class Component와 Life Cycle 비교
    - Class Component
        - Mounting : constructor => render => componentDidMount
        - Updating : render => componentDidUpdate
        - Unmounting : componentWillUnmounting
    - Function Component
        - Mounting / Updating : Run(function body) => Effects 동작
        - Unmounting : clean-up 동작
### 4) useCallback