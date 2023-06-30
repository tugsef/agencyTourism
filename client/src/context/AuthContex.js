import { createContext, useContext, useState } from "react";
import { signOutUser } from "../service/api";

const AuthContext = createContext();

const AuthProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [loggedIn, setLoggedIn] = useState(false);

  const login = (data) => {
    setLoggedIn(true);
    setUser(data);
    localStorage.setItem("access-token", data.token);
  };

  const logout = async () => {
    setLoggedIn(false);
    setUser(null);
    await signOutUser();
    localStorage.removeItem("access-token");
  };

  const values = {
    loggedIn,
    user,
    login,
    setLoggedIn,
    logout,
  };

  return <AuthContext.Provider value={values}>{children}</AuthContext.Provider>;
};

const useAuth = () => useContext(AuthContext);

export { AuthProvider, useAuth };
