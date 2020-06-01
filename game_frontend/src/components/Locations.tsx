import React, {useState, useEffect} from 'react';
import axios from 'axios';
import { properties } from '../Properties'
import "../css/Location.css";
import '../css/Spinner.css';
import { Redirect, useHistory } from 'react-router';
import { getUser, isLoggedIn } from './utils';
import LocationDTO from './dto/LocationDTO';
import { locationValidator } from  './validators'
import User from './dto/UserDTO';

export default function LocationPage():JSX.Element {
    if (!isLoggedIn()) {
        return <Redirect to="/login" push />
    }
    return <Locations/>
}
    
interface LocationState {
    locationItems: LocationDTO[] | null,
    error: boolean,
    errorMessage: string | null
}

function Locations():JSX.Element {
    const history = useHistory();
    const [state, setState] = useState<LocationState>({
        locationItems: null,
        error: false,
        errorMessage: null
    });

    let user: User|null = null;

    useEffect( () => {
        if(user) {
            getLocationsResponse(user!.username, user!.password)
                .then( resp => resp.data)
                .then( data => {
                    validate(data);
                    setState(prev=> ({
                        ...prev,
                        locationItems: data
                    }))
                })
                .catch( err => setState(prev=> ({
                    ...prev,
                    error: true,
                    errorMessage: err.toString()
                })
            ));
        }
    }, [user]);

    user = getUser();
    if (!user) {
        return <Redirect to="/login" push />
    }

    return (
        <>
        {!state.locationItems && !state.error && <div className="loader"/>}
        {state.locationItems && drawMap(state.locationItems)}
        {state.error && <div>{state.errorMessage!}</div>}
        <br/>
        {state.error && <button onClick={() => window.location.reload()}>Try Again</button>}
        <br/>
        {state.error && <button onClick={() => history.push("/login")}>Logout</button>}
        </>
    )
}

const getLocationsResponse = (username: string, password: string) => {

    let config = {
        auth: {
            username: username,
            password: password
          }
    }

    return axios(properties.locationsURL, config);
}

function validate(locationItems:Array<LocationDTO>) {
    locationItems.map(location => locationValidator.runWithException(location));
}

function drawMap(locationItems:Array<LocationDTO>) {
    return (
        <ul>
            { locationItems.map(loc => 
            <li key={loc.time}><div >{(new Date(loc.time)).toString()}</div>
            <hr/>
            {getMap(loc)}
            </li>)}
        </ul>
        )
}

function getMap(location:LocationDTO) {
    return (
    <iframe 
    title = {location.time}
    className = "map"
    width = "600"
    height = "450"
    src = {`https://www.google.com/maps/embed/v1/place?key=${properties.googleApiKey}&q=${location.latitude},${location.longitude}`}
    allowFullScreen/>
    )
}