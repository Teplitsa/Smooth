/**
 * Created by kascode on 05.12.15.
 */
import React, { Component, PropTypes } from 'react';
import { setStartRoutePoint, setMap } from '../../actions/Actions';

require('./ObstacleForm.css');

export default class ObstacleForm extends Component {
  render() {
    return <div className="card ObstacleForm">
      <p className="card__text ObstacleForm__text">Подтверите предандлежность препятствия выделенному ребру или передвинте препятствие</p>
      <button className="ObstacleForm__button card__button">Подтвердить</button>
    </div>
  }
}
