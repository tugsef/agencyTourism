import React from "react";
import {
  Container,
  Grid,
  Header,
  Icon,
  Item,
  Label,
  Segment,
} from "semantic-ui-react";
import { dateFunction } from "../../../utilities/DateFunction";
import { useHotel } from "../../../context/HotelContex";
import moment from "moment";
function RoomSearchCard({ room }) {
  const { search } = useHotel();

  const total = Number(search.adult) + Number(search.child);
  return (
    <div>
      {console.log(room)}
      <Container>
        <br />
        {room?.map((room) => (
          <Segment stacked key={room?.id}>
            <Grid>
              <Grid.Column width={12}>
                <Item.Group>
                  <Item>
                    <Item.Image
                      size="tiny"
                      src="https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg"
                    />

                    <Item.Content>
                      <Item.Header>
                        {room.type}{" "}
                        <Label color="orange" attached="top right" size="large">
                          <Icon name="try" /> {room.prices?.[0].q1}
                        </Label>
                      </Item.Header>
                      <Item.Extra>
                        <Label color="red">
                          {room.squareMeters} m<sup>2</sup>
                        </Label>{" "}
                      </Item.Extra>
                      <Item.Meta>
                        {room.features
                          .filter((f) => f.active === true)
                          .map((f) => (
                            <Label color="olive">{f.property}</Label>
                          ))}
                      </Item.Meta>
                      <Item.Description>{room.decsription}</Item.Description>
                    </Item.Content>
                  </Item>
                </Item.Group>
              </Grid.Column>
              <Grid.Column width={4}>
                <Item.Group>
                  <Item>
                    <Item.Content>
                      <Item.Extra>
                        <Label color="violet">
                          {moment(search.checkInDate).format("DD/MM/YYYY")}-{" "}
                          {moment(search.checkOutDate).format("DD/MM/YYYY")}
                        </Label>

                        <Label color="violet">
                          {search.adult} Yetişkin ,{search.child} Çocuk ,{" "}
                          {dateFunction(
                            search.checkInDate,
                            search.checkOutDate
                          )}{" "}
                          Gece
                        </Label>
                        <Header textAlign="right" as="h1" color="teal">
                          {total * room.prices?.[0].q1}

                          <Header.Subheader>Vergiler Dahil</Header.Subheader>
                        </Header>
                      </Item.Extra>
                      <br />
                    </Item.Content>
                  </Item>
                </Item.Group>
              </Grid.Column>
            </Grid>
          </Segment>
        ))}
      </Container>
    </div>
  );
}

export default React.memo(RoomSearchCard);
