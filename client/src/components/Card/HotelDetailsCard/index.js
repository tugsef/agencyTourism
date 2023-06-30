import React from "react";
import ImageGallery from "react-image-gallery";
import { Container, Grid, Header, Icon, Label } from "semantic-ui-react";
const images = [
  {
    original:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
    thumbnail:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
  },
  {
    original:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
    thumbnail:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
  },
  {
    original:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
    thumbnail:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
  },
  {
    original:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
    thumbnail:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
  },
  {
    original:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
    thumbnail:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
  },
  {
    original:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
    thumbnail:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
  },
  {
    original:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
    thumbnail:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
  },
  {
    original:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
    thumbnail:
      "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg",
  },
];
function HotelDetailsCard({ hotel, i }) {
  return (
    <div>
      <Header as="h1">
        {hotel.name}
        <Header.Subheader>
          <Icon name="map marker alternate" />
          <a href="mailto:jack@semantic-ui.com">{hotel.location?.adress}</a>
          {<Label color="brown">{hotel.location?.city}</Label>}
        </Header.Subheader>
      </Header>

      <ImageGallery items={images} disableThumbnailScroll />
      <br />
      <Container
        style={{
          border: "1px solid",
          borderColor: "#03001C",
          borderRadius: "10px",
          padding: "20px",
        }}
      >
        <Grid divided="vertically">
          <Grid.Row columns={2} style={{ borderRight: "1px" }}>
            <Grid.Column>
              <Header as="h3" dividing>
                Tesis açıklaması
              </Header>
              {hotel.decsription}
              {hotel.decsription}
              {hotel.decsription}
              {hotel.decsription}
              {hotel.decsription}
              <br />
              <Header as="h3" dividing>
                Tesis açıklaması
              </Header>
              {hotel.decsription}
              {hotel.decsription}
            </Grid.Column>
            <Grid.Column>
              <Header as="h3" dividing>
                Otel koşulları
              </Header>
              <Header as="h4">Check/in</Header>
              En erken saat 15:00 ve sonrası
              <Header as="h4">Check/out</Header>
              En geç saat 12:00 ve öncesi
              <Header as="h4">Evcil Hayvan</Header>
              Evcil hayvan kabul edilmemektedir.
              <Header as="h4">Sigara</Header>
              Odalarda sigara içilmez
              <Header as="h4">Çocuklar</Header>0 yaşına kadar olan bebekler
              ücretsizdir. Her bir oda için 6 yaşına kadar 1 çocuk ücretsizdir
            </Grid.Column>
          </Grid.Row>
        </Grid>
      </Container>
    </div>
  );
}

export default HotelDetailsCard;
