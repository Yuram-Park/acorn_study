import * as React from 'react';

interface CountDisplayProps{
    count:number;
}

interface CountDisplayState{}

class CounterDisplay extends React.Component<CountDisplayProps, CountDisplayState>{
    constructor(props:CountDisplayProps){
        super(props);
    }

    componentDidUpdate(): void {
        console.log("[Updating] CountDisplay / componetDidUpdate")
    }

    componentDidMount(): void{
        console.log("[Mounting] CountDisplay / componentDidMount")
    }

    componentWillMount(): void{
        console.log("[Unmounting] CountDisplay / componentWillUnmount")
    }

    render(){
        return <div>Count: {this.props.count}</div>
    }
}

export default CounterDisplay;