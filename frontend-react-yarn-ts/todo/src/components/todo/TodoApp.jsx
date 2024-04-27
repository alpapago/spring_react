import { useState } from "react";
import "./TodoApp.css";

export default function TodoApp() {
  return (
    <div className="TodoApp">
      Todo Management Application
      <LoginComponent />
    </div>
  );
}

function LoginComponent() {
  const [username, setUsername] = useState("in28minutes");
  const [password, setPassword] = useState("");

  function handleUsernameChange(e) {
    setUsername(e.target.value);
  }

  function handlePasswordChange(e) {
    setPassword(e.target.value);
  }

  return (
    <div className="Login">
      <div className="LoginForm">
        <div>
          <label>User Name</label>
          <input
            type="text"
            name="username"
            value={username}
            onChange={handleUsernameChange}
          />
        </div>
        <div>
          <label>password</label>
          <input
            type="text"
            name="password"
            value={password}
            onChange={handlePasswordChange}
          />
        </div>
        <div>
          <button type="button" name="login">
            login
          </button>
        </div>
      </div>
    </div>
  );
}
