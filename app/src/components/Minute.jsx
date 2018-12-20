import React from 'react';
import './Minute.css';

class Minute extends React.Component {
  state = {
    value: '00'
  };

  componentDidMount() {
    fetch('/app/api/v1/time')
      .then(response => response.json())
      .then(time => {
        this.setState({ value: time.minute });
      });
  }
  render() {
    return <p className="Minute">{this.state.value}:</p>;
  }
}

export default Minute;
