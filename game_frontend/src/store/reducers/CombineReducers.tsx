const combineReducers = (reducers:any) => (state:any, action:any) => {
  let hasChanged:any;
  const nextState = Object.keys(reducers).reduce((result:any, key) => {
    result[key] = reducers[key](state[key], action);
    hasChanged = hasChanged || result[key] !== state[key];
    return result;
  }, {});
  return hasChanged ? nextState : state;
};

export default combineReducers;