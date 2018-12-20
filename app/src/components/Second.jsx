import React from 'react';
import './Second.css';

class Second extends React.Component {
  state = {
    value: '00'
  };

  componentDidMount() {
    fetch('/app/api/v1/time')
      .then(response => response.json())
      .then(time => {
        this.setState({ value: time.second });
      });
  }
  render() {
    return <p className="Second">{this.state.value}</p>;
  }
}

export default Second;
