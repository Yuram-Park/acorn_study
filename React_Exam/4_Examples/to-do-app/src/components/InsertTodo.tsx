import {useState} from 'react';
import style from '../utils/InsertTodo.module.css'

const InsertTodo:React.FC<{onAddTodo:(item:string)=>void}> = (props) => { // props를 내려받을 일이 없으면 FC지정안함
    
    const [text, setText] = useState("");

    const submitHandler = (e:React.FormEvent) => {
        e.preventDefault();
        if(text.trim() !== "") {
            props.onAddTodo(text);
            setText("")
        }
    }

    const changeHandler = (e:React.FormEvent<HTMLInputElement>) => {
        setText(e.currentTarget.value);

    }
    
    

    return (
        <div>
            <form onSubmit={submitHandler} className={style.form}>
                <h3>할일 추가</h3>
                <input type="text" id="todo" value={text} onChange={changeHandler}/>
                <button>추가</button>
            </form>
        </div>
    );
}

export default InsertTodo;