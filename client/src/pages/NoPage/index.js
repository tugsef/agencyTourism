import React from "react";
import { Link } from "react-router-dom";
import { Container, Header, Icon, Message } from "semantic-ui-react";

function NoPage() {
  return (
    <div>
      <div style={{ marginTop: "2em" }}></div>
      <Container>
        <Message warning>
          <Header as="h2">
            <Icon name="settings" />
            <Header.Content>
              Sayfa Yapım Aşamasında
              <Header.Subheader as={Link} to="/">
                Anasayfaya geri dönebilirsiniz.
              </Header.Subheader>
            </Header.Content>
          </Header>
        </Message>
      </Container>
    </div>
  );
}

export default NoPage;
