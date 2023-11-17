import * as React from 'react';

interface CountDisplayProps{
    count: number;
}

function CountDisplay(props:CountDisplayProps):React.ReactElement{
    React.useEffect(()=>{
        console.log("[Rendered] CountDisplay / useEffect")
    });
    React.useEffect(()=>{
        console.log("[Mounted] CountDisplay / useEffect")
    }, []);
    return <h3>Count: {props.count}</h3>

}

export default CountDisplay;