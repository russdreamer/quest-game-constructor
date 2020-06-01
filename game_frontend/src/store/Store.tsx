import { createContext } from "react";

const initialStore = {
    user: {}
}
export const Store = createContext(initialStore);