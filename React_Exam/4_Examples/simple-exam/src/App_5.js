import React, {useReducer, useState} from 'react';

const App = () =>{
  const [check, setCheck] = useState(0);

  const moneyReducer = (oldMoney, action) => {
    if(action.type == 'deposit'){
      return oldMoney + action.check;
    } else if(action.type == 'withdraw'){
      return oldMoney - action.check;
    }
  }

  const [money , moneyDispatcher] = useReducer(moneyReducer, 0)
  
  const deposit = () =>{
    moneyDispatcher({type:'deposit', check: check});
  }
  const withdraw = () =>{
    moneyDispatcher({type:'withdraw', check: check});
  }

  // const changeMoney = (e) => {
  //   setCheck(Number(e.target.value));
  // }

  return (
    <div>
      <h1>금액을 입력하세요</h1>
      <input type='number' step={1000} onChange={(e) => setCheck(Number(e.target.value))}/>
      <hr/>
      <h2>입금 또는 출금 버튼을 클릭하세요</h2>
      <button onClick={deposit}>입금(Deposit)</button>
      <button onClick={withdraw}>출금(Withdraw)</button>
      <h2>현재 잔액 : {money}</h2>
    </div>
  );
}

export default App;