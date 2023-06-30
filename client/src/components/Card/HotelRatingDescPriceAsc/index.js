import React from "react";
import { Link } from "react-router-dom";
import { Button, Icon, Item, Label, Rating, Segment } from "semantic-ui-react";

function HotelRatingDescPriceAsc({ hotel, i }) {
  return (
    <Segment stacked>
      <Item.Group>
        <Item key={i}>
          <Item.Image src="https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg" />

          <Item.Content>
          { Number(hotel.hotelId%3)===0 &&
            <Label as="a" color="violet" ribbon size="small" >
              Fırsat
            </Label>}

            { Number(hotel.hotelId%3)===1 &&
            <Label as="a" color="red" ribbon   size="small" >
              %10 indirim
            </Label>}
            <Item.Header as="a">{hotel.name}</Item.Header>
            {
              <Label color="orange" icon="tr" tag size="large">
                <Icon name="try" /> {hotel.rooms?.[0].prices?.[0].q1}
              </Label>
            }
            <Label
              color="black"
              attached="top right"
              circular
              style={{ margin: "3px" }}
            >
              {hotel.rating}
            </Label>
            <Item.Meta>
              <Icon name="map marker alternate" />
              <span className="cinema">
                {hotel.locationAdress} <Label>{hotel.locationCity}</Label>
              </span>
              <br />
              <br />

              <Rating maxRating={hotel.star} defaultRating={5} icon="star" />
            </Item.Meta>
            <Item.Description>{hotel.decsription}</Item.Description>
            <Item.Extra>
              <Label
                color={(hotel.type === "Butik"&&"red") || (hotel.type === "Otel"&&"green")||(hotel.type === "Apart"&&"brown")||(hotel.type === "Pansiyon"&&"olive")||(hotel.type === "Villa"&&"orange")||(hotel.type === "Bungalow"&&"purple")}
                icon="hotel"
                content={hotel.type}
              />
            </Item.Extra>
          </Item.Content>
          <Item.Content>
            <Item.Extra>
              <Label color="teal">{hotel.rooms?.[0].type} Oda</Label>
              <Button
                as={Link}
                to={`/hoteldetail/${hotel.id}`}
                style={{ marginTop: "10px" }}
                animated
                primary
              >
                <Button.Content visible>Rezervasyon</Button.Content>
                <Button.Content hidden>
                  <Icon name="arrow right" />
                </Button.Content>
              </Button>
            </Item.Extra>
          </Item.Content>
        </Item>
      </Item.Group>
    </Segment>
  );
}

export default HotelRatingDescPriceAsc;
