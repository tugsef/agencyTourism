import { useQuery } from "@tanstack/react-query";
import React, { useState } from "react";
import { fetchHotelsMapList } from "../../service/api";
import { Button, Container, Divider, Header, Label, Loader, Segment } from "semantic-ui-react";
import HotelCard from "../../components/Card/HotelCard";
import ScrollToTop from "../../utilities/customForm/ScrollToTop";
import DataMessage from "../../utilities/DataMessage";

function HotelsList() {
  const [count, setCount] = useState(1);
  const { isLoading, error, data } = useQuery({
    queryKey: ["hotels::list", count],
    queryFn: () => fetchHotelsMapList(count),
  });

  if (isLoading)
    return (
      <Segment inverted tertiary>
        <Loader active inverted />
      </Segment>
    );
  if (error) return "An error has occurred: " + error.message;

  const increase = () => setCount((count) => count + 1);

  const descrease = () => count > 1 && setCount((count) => count - 1);

  return (
    <div>
      <Container fluid>
      <Header as="h1">
          Oteller
          <Header.Subheader>Hersey hayallerle baslar.</Header.Subheader>
          <Header.Subheader>Sayfada görüntülenen otel sayısı<Label circular color="red">{data?.data?.length}</Label> </Header.Subheader>
        </Header>
        {!isLoading && console.log(data.data)}

        {data.data.map((hotel, i) => (
          <HotelCard hotel={hotel} key={i} />
        ))}
      </Container>
      {data.data.length === 0 && <DataMessage />}
      <Divider />
      <Button
        content="Geri"
        icon="left arrow"
        labelPosition="left"
        floated="left"
        color="teal"
        onClick={() => descrease()}
      />
      <Button
        content="İleri"
        icon="right arrow"
        labelPosition="right"
        floated="right"
        style={{ marginRight: "35px" }}
        color="teal"
        onClick={() => increase()}
      />

      <ScrollToTop />
    </div>
  );
}

export default HotelsList;
