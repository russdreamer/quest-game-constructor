export default class LocationDTO {
    latitude: string;
    longitude: string;
    time: string;

    constructor(latitude: string , longitude: string, time: string) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.time = time;
    }
}