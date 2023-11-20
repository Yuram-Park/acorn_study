//import { Component } from 'react';
import * as React from 'react';
import './App.css';
import Board from './components/Board';

클래스형
class App extends React.Component {
  render(){
    return (
      <div className="game">
        <div className="game-borad">
          <Board/>
        </div>
        <div className="game-info">
          Game Information 영역
        </div>
      </div>
    );
  };
}


// 함수형
function App() {
    
      return (
        <div className="game">
          <div className="game-borad">
            <Board/>
          </div>
          <div className="game-info">
            Game Information 영역
          </div>
        </div>
      );
}

export default App;
