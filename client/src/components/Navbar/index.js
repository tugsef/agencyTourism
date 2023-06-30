import React from "react";
import { Container, Flag, Icon, Menu } from "semantic-ui-react";
import styles from "./styles.module.css";
import { Link, NavLink } from "react-router-dom";
import SignIn from "./SignIn";
import SignOut from "./SignOut";
import { useAuth } from "../../context/AuthContex";

function Navbar() {
  const { user, loggedIn } = useAuth();

  return (
    <div className={styles.container}>
      <Container fluid>
        <Menu fixed="top" stackable>
          <Menu.Item as={Link} to="/">
            <Icon name="home" size="big" />
          </Menu.Item>
          <Menu.Menu position="right">
            <Menu.Item as={Link} to="/hoteldetails">
              <Flag to={"/hoteldetails"} name="tr" />
            </Menu.Item>

            <Menu.Item>
              <NavLink to={"/hoteldetails/hotellist"} className={styles.nav}>
                Yardım
              </NavLink>
            </Menu.Item>
            <Menu.Item>
              <NavLink to={"/nopage"} className={styles.nav}>
                Tesisinizi Ekleyin
              </NavLink>
            </Menu.Item>
            {loggedIn ? <SignOut user={user.username} /> : <SignIn />}
          </Menu.Menu>
        </Menu>
      </Container>
    </div>
  );
}

export default Navbar;
