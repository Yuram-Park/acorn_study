import * as React from 'react';
import CountDisplay from './CountDisplay';
import {useCounter} from './hooks/useCounter';
import useToggle from './hooks/useToggle';
import { AnyTxtRecord } from 'dns';

interface CounterProps{
    title : String;
}


interface CounterState{
    num : number;
    hideCount : boolean;
}

function Counter(props:CounterProps):React.ReactElement{
    //const [count, setCount] = React.useState(0);
    //const [hideCount, setHideCount] = React.useState(false);
    //const plus = () => setCount((prev)=>prev + 1);
    //const minus = () => setCount((prev)=>prev -1);
    //const toggle = ()=>setHideCount(!hideCount);

    const {count, plus, minus} = useCounter();
    const [hideCount, toggle] = useToggle();

    React.useEffect(()=>{console.log("[Rendered] Count / useEffect");});
    React.useEffect(()=>{console.log("[Mounted] Count / useEffect")}, [count]);

    return(
        <div>
            <h1>{props.title} / {width}</h1>
            {!hideCount && <CountDisplay count={count}/>}
            카운터:{count}<br/>
            <CountDisplay count={count}/>
            <button onClick={plus}>Plus</button>
            <button onClick={minus}
            >Minus</button>
            <button onClick={toggle}>Toggle Count</button>
        </div>
    );

}

export default Counter;
