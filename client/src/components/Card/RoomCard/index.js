import { Container, Icon, Item, Label, Segment } from "semantic-ui-react";

function RoomCard({ room }) {
  return (
    <div>
      {console.log(room)}
      <Container>
        <br />
        {room?.map((room) => (
          <Segment attached compact clearing stacked key={room.id}>
            <Item.Group>
              <Item>
                <Item.Image
                  size="tiny"
                  src="https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686318255/pexels-photo-2844474_bcsxnj.jpg"
                  verticalAlign="bottom"
                />

                <Item.Content>
                  <Item.Header>
                    {room.type}{" "}
                    <Label color="orange" attached="top right" size="large">
                      <Icon name="try" /> {room.prices?.[0].q1}
                    </Label>
                    <br />
                    <Label color="red">
                      {room.squareMeters} m<sup>2</sup>
                    </Label>{" "}
                  </Item.Header>

                  <Item.Meta>
                    {room.features
                      .filter((f) => f.active === true)
                      .map((f) => (
                        <Label color="olive" key={f.id}>
                          {f.property}
                        </Label>
                      ))}
                  </Item.Meta>
                  <Item.Description>{room.decsription}</Item.Description>
                </Item.Content>
              </Item>
            </Item.Group>
          </Segment>
        ))}
      </Container>
    </div>
  );
}

export default RoomCard;
