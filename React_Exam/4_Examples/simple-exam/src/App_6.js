import React, {useReducer, useState} from 'react';

const uid = () => { 
  let a = new Uint32Array(3)
  window.crypto.getRandomValues(a)
  return (
    performance.now().toString(36) +
    Array.from(a)
      .map(A => A.toString(36))
      .join('')
  ).replace(/\./g, '')
}

const App = () =>{
  
  const [info, setInfo] = useState({});
  
  const addReducer = (state, action) => {
    switch(action.type){
      case 'ADD':
        return {
          ...state,
          member : [...state.member, {...action.info}],
          count: state.count + 1
        };
      case 'DELETE':
        return {
          ...state,
          member : [...state.member.filter((element)=>(element.id !== action.idx))],
          count: state.count -1
        };
      default:
        return state;
      //let array = {count: action.count, member:[{name:action.name, age:action.age, addr:action.addr}]};
    }
  }
  
  const [add, addDispatcher] = useReducer(addReducer, {count:0, member:[]});
  
  const addClick = () => {
    addDispatcher({type: "ADD", info: info});
  }


  const onChangeHandler = (e) => {
    // console.log(e.target.name);
    // console.log(e.target.value);
    setInfo({...info, id:uid(), [e.target.name]:[e.target.value]})
  }

  const delMember = (e) => {
    addDispatcher({type:"DELETE", idx: e.target.value})
    console.log(e.target.value);
    console.log(info.id === e.target.value)
  }

  return (
    <div>
      <div>
        <h1>전체 회원 수 : {add.count} </h1>
        <div>
          <label>이름 : </label>
          <input type={'text'} name="name" autoComplete="off" onChange={onChangeHandler}></input>
        </div>
        <div>
          <label>나이 : </label>
          <input type={'number'} name="age" autoComplete="off" onChange={onChangeHandler}></input>
        </div>
        <div>
          <label>주소 : </label>
          <input type={'text'} name="address" autoComplete="off" onChange={onChangeHandler}></input>
        </div>

        <button onClick={addClick}>추가</button>
      </div>

      <table>
        <thead>
          <tr>
            <th>이름</th>
            <th>나이</th>
            <th>지역</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
            {add.member.map((mem) => (
              <tr>
              <td>{mem.name}</td>
              <td>{mem.age}</td>
              <td>{mem.address}</td>
              <td>
              <button onClick={delMember} value={mem.id}>
                ❌
              </button>
              </td>
              </tr>
            ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
