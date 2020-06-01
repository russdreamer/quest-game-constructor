import User from "./dto/UserDTO";
import { userValidator } from "./validators";

/**
 * return user from localStore or null if not present
 */
export function getUser(): User | null {
    let userStr = localStorage.getItem('user');
    if (userStr) {
        let user = JSON.parse(userStr);

        if (userValidator.run(user).ok) {
            return user;
        }
    }
    return null;
}

export function isLoggedIn(): boolean {
    return localStorage.getItem('user') != null;
}

export function logOut() {
    localStorage.removeItem("user");
}