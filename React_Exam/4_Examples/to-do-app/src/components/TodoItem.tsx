import {useState} from 'react';
import style from '../utils/TodoItem.module.css'

const TodoItem:React.FC<{text: string; id: string; onRemoveTodo:(delNum:string)=>void}> = (props) => {

    const [deleteNum, setDeleteNum] = useState("");

    // const deleteList = (id:string) => {
    //     setDeleteNum(id);
    //     props.onRemoveTodo(deleteNum);
    // }

    return <div>
            <li className={style.item} onClick={()=>props.onRemoveTodo(props.id)}>{props.text}<button>삭제</button></li>
            </div>
}

export default TodoItem;