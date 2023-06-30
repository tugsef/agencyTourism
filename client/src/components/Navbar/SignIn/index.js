import React from "react";
import { Link } from "react-router-dom";
import { Button, Menu } from "semantic-ui-react";

function SignIn() {
  return (
    <>
      <Menu.Item>
        <Button as={Link} to="/signin" basic color="green" fluid>
          Kayıt Ol
        </Button>
      </Menu.Item>
      <Menu.Item>
        <Button as={Link} to="/signin" basic color="blue" fluid>
          Giriş Yap
        </Button>
      </Menu.Item>
    </>
  );
}

export default SignIn;
