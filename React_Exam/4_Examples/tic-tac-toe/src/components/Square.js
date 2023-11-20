import React from 'react'
import "./Square.css";


// export default class Square extends Component {
//     // constructor(props){
//     //     super(props);
//     //     this.state = {value: null}
//     // }
    
//     render() {
//         return (
//         // setState 사용
//         //<button className='square' onClick={() => {this.setState({value:'X'})}}>{this.props.value}</button>
//         // props에 있는 onClick을 호출
//         <button className='square' onClick={()=>this.props.onClick()}>{this.props.value}</button>
//         )
//     }
// }


const Square = ({onClick, value})=> {
    return (
        <button className='square' onClick={onClick}>{value}</button>
    )
 
}

export default Square;