// 새로운 컴퍼넌트 -> Counter.tsx

import * as React from 'react';
import CounterDisplay from './CounterDisplay';

//외부로부터 전달 받음
interface CounterProps{
    //변수 두개를 묶어서 전달할거야!!
    title : String;
    //num : number;
}

//내부에서 수정 & 사용
interface CounterState{
    num : number;
    hideCount : boolean
}
// 이름은 가급적이면 file명과 동일하게 하는것이 좋다.
class Counter extends React.Component<CounterProps, CounterState>{
    // React.Component : 생성자를 통해 입력을 받는다.
    //반드시 오버라이딩을 해야하는 두가지 
    //필수 constructor(매개변수)
    constructor(props:CounterProps){
        //부모에게 알려줘야함
        super(props)
        // props.title="test"; props는 절대 수정할 수 없어요 메인에 가서 수정해야함
        this.state = {num:10, hideCount:false}

        console.log("Mounting : In constructor");
        
    }
    //setState => state update => render() => element
    // => reconciliation
    handleClick = () => {
        //this.setState({num:20})
        //console.log("Clicked with count : ", this.state.num)
        
        this.setState((prev)=>{
            //console.log(prev)
            return {num: prev.num+1}
            
        })
    }
    
    handleToggle = () => {
        this.setState((prev)=>{
            return { hideCount : !prev.hideCount }
            
        })
    }
    componentDidMount(): void {
        console.log("Mounting : In ComponentDidMount")
    }

    componentDidUpdate(): void {
        console.log("Updating : In componentDidUpdate")
        
    }

    render() {
        console.log("Mounting & Updating : In render")
        return <div>
                    <h1>{this.props.title}</h1>
                    <h3>Count:{this.state.num}</h3>
                    <h3>{!this.state.hideCount && <CounterDisplay count={this.state.num}/>}</h3>
                    <button onClick={this.handleClick}>PLUS</button> &nbsp;
                    <button onClick={this.handleToggle}>Toggle Count</button>
                </div>
    }
}

export default Counter;
