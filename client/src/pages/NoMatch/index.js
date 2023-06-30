import React from "react";
import { NavLink } from "react-router-dom";
import { Container, Icon, Message } from "semantic-ui-react";

function NoMatch() {
  return (
    <Container style={{ marginTop: "2em" }}>
      <Message
        icon={<Icon name="help" />}
        error
        header="Üzgünüz aradığınız sayfayı bulamadık."
        content={
          <p>
            <NavLink to={"/"}>Anasayfaya dönmek ister misiniz?</NavLink>
          </p>
        }
      />
    </Container>
  );
}

export default NoMatch;
