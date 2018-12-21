import * as ACTION from './actionTypes';

export function fetchTime() {
  return function(dispatch) {
    console.log('Trying to fetch time...');

    fetch('/app/api/v1/time')
      .then(response => response.json())
      .then(time => {
        console.log('Sucessfully fetched time...');
        dispatch({ type: ACTION.FETCH_HOUR, payload: time.hour });
        dispatch({ type: ACTION.FETCH_MINUTE, payload: time.minute });
        dispatch({ type: ACTION.FETCH_SECOND, payload: time.second });
      })
      .catch(err => {
        console.log('Error while fetching time...');
        dispatch({ type: ACTION.FETCH_HOUR_ERROR, payload: err });
        dispatch({ type: ACTION.FETCH_MINUTE_ERROR, payload: err });
        dispatch({ type: ACTION.FETCH_SECOND_ERROR, payload: err });
      });
  };
}
