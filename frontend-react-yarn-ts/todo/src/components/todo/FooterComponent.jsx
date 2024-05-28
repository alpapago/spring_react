import { useContext } from "react";
import { AuthContext } from "./security/AuthContext";
import "./FooterStyle.css";

function FooterComponent() {
  const authContext = useContext(AuthContext);

  console.log(`Footer component - ${authContext.number}`);

  return (
    <footer className="footer">
      <hr />
      <div className="container">Your Footer</div>
    </footer>
  );
}

export default FooterComponent;
