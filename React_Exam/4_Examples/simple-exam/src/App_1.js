import React, {useState} from 'react';

const App = () =>{
  const [num, setNum] = useState(0);

  

  return (
    <div>
      <h1>{num}</h1>
      <button onClick={()=>setNum(num+1)} onMouseOut={()=>setNum(0)}>클릭</button>
    </div>
  );
}

export default App;