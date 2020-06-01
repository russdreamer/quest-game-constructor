import {Decoder, object, string} from '@mojotech/json-type-validation';
import User from './dto/UserDTO';
import LocationDTO from './dto/LocationDTO';

export const userValidator: Decoder<User> = object({
    username: string(),
    password: string()
});

export const locationValidator: Decoder<LocationDTO> = object({
  latitude: string(),
  longitude: string(),
  time: string()
});
  