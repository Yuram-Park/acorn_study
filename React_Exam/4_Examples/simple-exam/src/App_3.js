import React, {useState} from 'react';

const App = () =>{
  const [regions, setRegions] = useState([{kor:"서울", eng:"seoul"}, {kor:"부산", eng:"busan"}, {kor:"제주", eng:"jeju"}])
  const [target, setTarget] = useState("");
  
  const changeHandler = (e) => {
    setTarget(e.target.value);
    //target = regions[regions.findIndex(region => region.eng === e.target.value)].kor;
  }

  //React.useEffect(()=>{}, [target]);
  

  
  return (
    <div>
      <h1>라디오 버튼의 value를 출력</h1>
      <select onChange={changeHandler}>
        {
          regions.map(region =>(
            <option key={region.eng} value={region.eng}>{region.kor}</option>
          ))
        }
      </select>
      <button onClick={()=>alert(target)}>확인</button>
    </div>
  );
}

export default App;