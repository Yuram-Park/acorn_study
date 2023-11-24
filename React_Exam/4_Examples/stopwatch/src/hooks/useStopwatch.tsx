import * as React from 'react';
import {INTERVAL, MILLISEC_PER_SECOND} from '../constants';

export enum STATUS {
    PROCESSING,
    STOP
};

export interface Lap {
    id: number;
    title: string;
    seconds: number;
};

// 실제 데이터 만들어서 메인 컴퍼넌트로 전달
interface UseStopwatchReturnType {
    status: STATUS;
    seconds: number;
    laps: Lap[];
    nextLap: Lap;

    start: ()=>void;
    stop: ()=>void;
    reset: ()=>void;
    record: ()=>void;
};

// 메인컴퍼넌트로 데이터 전달
const useStopwatch: () => UseStopwatchReturnType = () => {

    // Time 컴퍼넌트에서 사용할 데이터
    const [seconds, setSeconds] = React.useState(0);
    // Controller 컴퍼넌트에서 사용할 데이터
    const [status, setStatus] = React.useState<STATUS>(STATUS.PROCESSING);
    // Laps 컴퍼넌트에서 사용할 데이터
    const [laps, setLaps] = React.useState<Lap[]>([]);
    const nextLap = React.useMemo<Lap>(()=>{
        return {
            id: laps.length + 1,
            title: `랩 ${laps.length + 1}`,
            seconds: seconds
        }
    },[seconds, laps]);

    // 
    const start = React.useCallback(()=>{
        if(status !== STATUS.STOP){
            return;
        }
        setStatus(STATUS.PROCESSING);
    }, [status]);

    const stop = React.useCallback(()=>{
        if(status !== STATUS.PROCESSING){
            return; // 진행중이 아니라면 그냥 return
        }
        setStatus(STATUS.STOP);
    }, [status]);

    const reset = React.useCallback(()=>{
        if(status !== STATUS.STOP){
            return;
        }
        setSeconds(0);
        setLaps([]);
    }, [status]);

    const record = React.useCallback(()=>{
        setLaps((prev)=>[nextLap, ...prev])
    }, [status, nextLap]);

    React.useEffect(()=>{
        let intervalId:number;
        if(status === STATUS.PROCESSING){
            intervalId = window.setInterval(()=>{
                setSeconds((prev)=>{return prev + INTERVAL/MILLISEC_PER_SECOND})
            }, INTERVAL);
        }

        return ()=>{
            window.clearInterval(intervalId);
        }
    },[status]);

    return {seconds, status, laps, nextLap, start, stop, reset, record};
};

export default useStopwatch;
