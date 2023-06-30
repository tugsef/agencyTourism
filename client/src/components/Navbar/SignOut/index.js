import React from "react";
import { Dropdown, Image, Menu } from "semantic-ui-react";
import { useAuth } from "../../../context/AuthContex";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

function SignOut({ user, signOut }) {
  const navigate = useNavigate();
  const { logout } = useAuth();
  const handleLogout = () => {
    toast.success("Çıkış Başarılı");
    logout();
    navigate("/");
  };
  return (
    <>
      <Menu.Item>
        <Image
          avatar
          spaced="right"
          src="https://res.cloudinary.com/dvfdwlbuy/image/upload/v1684421007/jykpmcyutpfkmfxiz94x.jpg"
        />
        <Dropdown pointing="top left" text={user} fluid>
          <Dropdown.Menu>
            <Dropdown.Item text="Bilgilerim" icon="info" />
            <Dropdown.Item
              onClick={handleLogout}
              text="Çıkış Yap"
              icon="sign-out"
            />
          </Dropdown.Menu>
        </Dropdown>
      </Menu.Item>
    </>
  );
}

export default SignOut;
