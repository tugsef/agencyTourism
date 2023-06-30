import React from "react";
import { Link } from "react-router-dom";
import {
  Button,
  Container,
  Divider,
  Grid,
  Header,
  List,
  Segment,
} from "semantic-ui-react";

function Footer() {
  return (
    <div>
      {" "}
      <Segment
        inverted
        vertical
        style={{ margin: "5em 0em 0em", padding: "5em 0em" }}
      >
        <Container textAlign="center">
          <Grid divided inverted stackable>
            <Grid.Column width={3}>
              <Header inverted as="h4" content="Müşteri hizmetleri" />
              <List link inverted>
                <List.Item as={Link} to="/nopage">
                  Rezervasyonları Yönet
                </List.Item>
                <List.Item as={Link} to="/nopage">
                  Bize mesaj gönderin
                </List.Item>
                <List.Item as={Link} to="/nopage">
                  İştirak olun
                </List.Item>
                <List.Item as={Link} to="/nopage">
                  Müşteri hizmetleri
                </List.Item>
              </List>
            </Grid.Column>
            <Grid.Column width={3}>
              <Header inverted as="h4" content="Keşfet" />
              <List link inverted>
                <List.Item as={Link} to="/nopage">
                  Hediye Kart
                </List.Item>
                <List.Item as={Link} to="/nopage">
                  XPara Nedir?
                </List.Item>
                <List.Item as={Link} to="/signin">
                  Üye girişi
                </List.Item>
                <List.Item as={Link} to="/signin">
                  Hesap oluştur
                </List.Item>
              </List>
            </Grid.Column>
            <Grid.Column width={3}>
              <Header
                inverted
                as="h4"
                content="
Otelx hakkında"
              />
              <List link inverted>
                <List.Item as={Link} to="/nopage">
                  Hakkımızda
                </List.Item>
                <List.Item as={Link} to="/nopage">
                  Koşullar ve şartlar
                </List.Item>
                <List.Item as={Link} to="/nopage">
                  Aydınlatma Metni
                </List.Item>
                <List.Item as={Link} to="/nopage">
                  Yasal Bilgiler
                </List.Item>
              </List>
            </Grid.Column>
            <Grid.Column width={7}>
              <Header inverted as="h4" content="Sayfa Hakkında" />
              <p>
                İnternet sitesi eğitim amaçlı hazırlanmıştır. İçindeki veri ve
                bilgiler gerçeği yansıtmamaktadır.
              </p>
            </Grid.Column>
          </Grid>

          <Divider inverted section />

          <List horizontal inverted divided link size="small">
            <List.Item as={Link} to="/nopage">
              Site Map
            </List.Item>
            <List.Item as={Link} to="/nopage">
              Contact Us
            </List.Item>
            <List.Item as={Link} to="/nopage">
              Terms and Conditions
            </List.Item>
            <List.Item as={Link} to="/nopage">
              Privacy Policy
            </List.Item>
          </List>

          <p size="small">
            ©Copyright 2023 sefademirtas91@gmail.com Tüm hakları saklıdır.
            <br />
            Sefa Demirtaş
          </p>
          <div>
            <Button
              as={Link}
              to="https://twitter.com/SefaDemirtas91"
              circular
              color="twitter"
              icon="twitter"
            />
            <Button
              as={Link}
              to="https://www.linkedin.com/in/sefa-demirta%C5%9F-86b473230/"
              circular
              color="linkedin"
              icon="linkedin"
            />
            <Button
              as={Link}
              to="https://github.com/tugsef"
              circular
              icon="github"
            />
          </div>
        </Container>
      </Segment>
    </div>
  );
}

export default Footer;
