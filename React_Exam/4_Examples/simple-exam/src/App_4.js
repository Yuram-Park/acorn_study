import React, {useReducer} from 'react';

const App = () =>{
  
  const moneyReducer = (oldMoney, msg) => {
    if (msg.type === "hamberger"){
      return oldMoney + 4000;
    } else if (msg.type === "fri"){
      return oldMoney + 3000;
    } else if (msg.type === "cola"){
      return oldMoney + 1000
    }
  }

  const [money, moneyDispatcher] = useReducer(moneyReducer, 0);

  const hamberger = () => {
    moneyDispatcher({type:"hamberger"});
  }

  const fri = () => {
    moneyDispatcher({type:"fri"});
  }

  const cola = () => {
    moneyDispatcher({type:"cola"});
  }
  return (
    <div>
      <h1>햄버거 가게</h1>
      <h3>지불할 금액 : {money}</h3>
      <hr/>
      <button onClick={hamberger}>햄버거(4000원)</button>
      <button onClick={fri}>감자튀김(3000원)</button>
      <button onClick={cola}>콜라(1000원)</button>
    </div>
  );
}

export default App;