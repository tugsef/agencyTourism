import React from "react";
import { Link } from "react-router-dom";
import { Button, Icon, Item, Label, Rating, Segment } from "semantic-ui-react";

function HotelCard({ hotel, i }) {
  return (
    <Segment stacked>
      <Item.Group>
        <Item key={i}>
          <Item.Image src="https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg" />

          <Item.Content>
            <Item.Header as="a">{hotel.name} </Item.Header>

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
                color={(hotel.type === "Butik"&&"red") || (hotel.type === "Otel"&&"green")||(hotel.type === "Apart"&&"brown")||(hotel.type === "Pansiyon"&&"olive")||(hotel.type === "Villa"&&"orange")||(hotel.type === "Bungalow"&&"purple") }
                icon="hotel"
                content={hotel.type}
              />
              <Button
                as={Link}
                to={`/hoteldetail/${hotel.id}`}
                animated
                primary
                floated="right"
              >
                <Button.Content visible>Yer Durumuna bak</Button.Content>
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

export default HotelCard;
