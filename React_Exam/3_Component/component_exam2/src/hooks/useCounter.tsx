import * as React from 'react';

interface useCounterReturnType{
    count: number;
    plus: ()=>void;
    minus: ()=>void;
}

export function useCounter ():useCounterReturnType{
    const [count, setCount] = React.useState(0);
    const plus = ()=> setCount((prev)=>prev +1);
    const minus = ()=> setCount((prev)=>prev -1);
    return {count, plus, minus};
}


