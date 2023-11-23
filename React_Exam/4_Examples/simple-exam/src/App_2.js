import React, {useState} from 'react';

const App = () =>{
  const [message, setMsg] = useState({title:'내용없음', textColor: 'black'})

  

  const changeMsg = event => {
    setMsg({...message, title: event.target.value});
  }

  let showTitle;

  const changeColor = () => {
    setMsg({...message, textColor: 'red'});
    alert(message.title);
  }

  

  return (
    <div>
      <h1 style={{color:message.textColor}}>{message.title}</h1>
      <hr/>
      <input id="text" type="text" placeholder='내용을 입력' onChange={changeMsg}/>
      <button onClick={changeColor}>클릭</button>
    </div>
  );
}

export default App;