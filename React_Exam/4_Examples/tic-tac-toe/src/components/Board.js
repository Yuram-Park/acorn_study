//import React, { Component } from 'react';
import React, { useState } from 'react';
import Square from "./Square";
import "./Board.css";

// class형
// export default class Board extends Component {

//     constructor(props){
//         super(props);
//         // 초기값 할당
//         this.state = {
//             squares: Array(9).fill(null)
//         }
//     }

//     handleClick(i){
//         // 불변성을 지키기 위해 slice로 배열 복제
//         const squares = this.state.squares.slice();
//         squares[i] = 'X';
//         this.setState({squares: squares})
//     }

//     renderSquare(i){
//         return <Square value={this.state.squares[i]} onClick={()=>this.handleClick(i)}/>
//     }

//   render() {
//     return (
//         <div>
//             <div className="status"> Next Player : X, O </div>
//             <div className="board-row">
//                 {this.renderSquare(0)}
//                 {this.renderSquare(1)}
//                 {this.renderSquare(2)}
//             </div>
//             <div className="board-row">
//                 {this.renderSquare(3)}
//                 {this.renderSquare(4)}
//                 {this.renderSquare(5)}
//             </div>
//             <div className="board-row">
//                 {this.renderSquare(6)}
//                 {this.renderSquare(7)}
//                 {this.renderSquare(8)}
//             </div>
//         </div>
//     )
//   }
// }


// 함수형
const Board = () => {
    // function에서 state를 쓸 수 있도록 지원해주는 함수 : useState(초기값) 
    // 초기 배열 값 = squares, 변경 후 배열 값 = setSquares
    const [squares, setSquares] = useState(Array(9).fill(null))

    const handleClick = (i) => {
        const newSquares = squares.slice();
        newSquares[i] = 'X';
        setSquares(newSquares);
    }

    const renderSquare = (i) => {
        return <Square value={squares[i]} onClick={()=>handleClick(i)}/>
    }

    return (
        <div>
            <div className="status"> Next Player : X, O </div>
            <div className="board-row">
                {renderSquare(0)}
                {renderSquare(1)}
                {renderSquare(2)}
            </div>
            <div className="board-row">
                {renderSquare(3)}
                {renderSquare(4)}
                {renderSquare(5)}
            </div>
            <div className="board-row">
                {renderSquare(6)}
                {renderSquare(7)}
                {renderSquare(8)}
            </div>
        </div>
    )
  
}

export default Board;