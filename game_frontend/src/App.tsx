import React, { Suspense, useEffect} from 'react';
import { BrowserRouter, Route, Link } from 'react-router-dom';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Task from './components/Task';
import './css/Spinner.css';
import ErrorBoundary from './components/ErrorBoundary';

const Locations = React.lazy(() => import('./components/Locations'));
const LoginForm = React.lazy(() => import('./components/LoginForm'));


function App() {

  useEffect(() => {
    window.onunhandledrejection = (err: any) => {
      console.log("<< Global exception is handled >>");
    }
  });

  const task = () => (
    <div><h2>Task</h2></div>
  )

  const locations = () => (
    <ErrorBoundary fallback={<h2>Could not fetch locations.</h2>}>
    <Suspense fallback={
      <div className="loader"></div>
    }>
      <Locations/>
    </Suspense>
    </ErrorBoundary>
  )

  function Login() {
    return (
      <Suspense fallback={
        <div className="loader"></div>
      }>
        <LoginForm/>
      </Suspense>
    )
  }

  function Navigation()  {
    return (
      <BrowserRouter>
      <div>
        <ul>
          <li><Link to="/">Task</Link></li>
          <li><Link to="/locations">Locations</Link></li>
        </ul>
        <hr/>
        <Route exact path="/" component={task}/>
        <Route exact path="/login" component={Login}/>
        <Route exact path="/locations" component={locations} />
        </div>
      </BrowserRouter>
    )
}

  return (
    <div>
      <Task/>
      <Navigation/>
    </div>
  )
}

export default App;
