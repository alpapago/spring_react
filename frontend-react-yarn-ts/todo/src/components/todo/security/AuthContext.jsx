import { createContext, useContext, useState } from "react";
import { apiClient } from "../api/ApiClient";
import { executeJwtAuthenticationService } from "../api/AuthenticationApiService";

export const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export default function AuthProvider({ children }) {
  const [isAuthenticated, setAuthenticated] = useState(false);

  const [username, setUsername] = useState(null);

  const [token, setToken] = useState(null);

  const valueToBeShared = { isAuthenticated, login, logout, username, token };

  // async function login(username, password) {

  //     const baToken = 'Basic ' + window.btoa( username + ":" + password )

  //     try {

  //         const response = await executeBasicAuthenticationService(baToken)

  //         if(response.status==200){
  //             setAuthenticated(true)
  //             setUsername(username)
  //             setToken(baToken)

  //             apiClient.interceptors.request.use(
  //                 (config) => {
  //                     console.log('intercepting and adding a token')
  //                     config.headers.Authorization = baToken
  //                     return config
  //                 }
  //             )

  //             return true
  //         } else {
  //             logout()
  //             return false
  //         }
  //     } catch(error) {
  //         logout()
  //         return false
  //     }
  // }

  async function login(username, password) {
    try {
      const response = await executeJwtAuthenticationService(
        username,
        password
      );

      if (response.status == 200) {
        const jwtToken = "Bearer " + response.data.token;

        setAuthenticated(true);
        setUsername(username);
        setToken(jwtToken);

        apiClient.interceptors.request.use((config) => {
          console.log("intercepting and adding a token");
          config.headers.Authorization = jwtToken;
          return config;
        });

        return true;
      } else {
        logout();
        return false;
      }
    } catch (error) {
      logout();
      return false;
    }
  }

  function logout() {
    setAuthenticated(false);
    setToken(null);
    setUsername(null);
  }

  return (
    <AuthContext.Provider value={valueToBeShared}>
      {children}
    </AuthContext.Provider>
  );
}
