import React from 'react';
import './App.css';
import Hour from './components/Hour';
import Minute from './components/Minute';
import Second from './components/Second';

class App extends React.Component {
  render() {
    return (
      <div className="App">
        <Hour />
        <Minute value="10" />
        <Second value="10" />
      </div>
    );
  }
}

export default App;
