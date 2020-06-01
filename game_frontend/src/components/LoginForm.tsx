import React, { useState }  from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../css/LoginForm.css';
import { useHistory } from 'react-router';
import { logOut } from './utils';

const LoginForm:React.FC = () => {
    logOut();
    
    const history = useHistory();
    const [user, setUser] = useState({
        username: "",
        password: ""
    });

    function onChange(e: React.ChangeEvent<HTMLInputElement>) {
        setUser({...user,  [e.target.name]: e.target.value });
    }

    function onsubmit(e: React.MouseEvent) {
        e.preventDefault();
        localStorage.setItem("user", JSON.stringify(user));
        history.goBack();
    }

    return (
        <form className="LoginForm">
            <div className="form-group">
                <label htmlFor="login">Login</label>
                <input type="text" className="form-control" name="username" id="username" placeholder="Enter login" value={user.username} onChange={(e) => onChange(e)}/>
            </div>
            <div className="form-group">
                <label htmlFor="password">Password</label>
                 <input type="password" className="form-control" name="password" id="password" placeholder="Password" value={user.password} onChange={(e) => onChange(e)}/>
            </div>
            <button onClick={(e) => onsubmit(e) } className="btn btn-primary">Submit</button>
        </form>
    )
}

export default LoginForm;