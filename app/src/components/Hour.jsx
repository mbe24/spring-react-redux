import React from 'react';
import './Hour.css';

class Hour extends React.Component {
  state = {
    value: '00'
  };

  componentDidMount() {
    fetch('http://localhost:8080/app/api/v1/time')
      .then(response => response.json())
      .then(time => {
        this.setState({ value: time.hour });
      });
  }

  render() {
    return <p className="Hour">{this.state.value}:</p>;
  }
}

export default Hour;
