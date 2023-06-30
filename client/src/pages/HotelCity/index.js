import { useParams } from "react-router-dom";
import { findByCity } from "../../service/api";
import { useQuery } from "@tanstack/react-query";
import GetCityCard from "../../components/Card/GetCityCard";
import DataMessage from "../../utilities/DataMessage";
import ScrollToTop from "../../utilities/customForm/ScrollToTop";
import {
  Container,
  Divider,
  Header,
  Label,
  Loader,
  Segment,
} from "semantic-ui-react";

function HotelCity() {
  let { city } = useParams();
  const { isLoading, error, data } = useQuery({
    queryKey: ["hotels", city],
    queryFn: () => findByCity(city),
  });

  if (isLoading)
    return (
      <Segment inverted tertiary>
        <Loader active inverted />
      </Segment>
    );
  if (error) return "An error has occurred: " + error.message;

  return (
    <div>
      <Container fluid>
        <Header as="h1">
          {city}
          <Header.Subheader>Hersey hayallerle baslar.</Header.Subheader>
          <Header.Subheader>
            Sayfada görüntülenen otel sayısı
            <Label circular color="red">
              {data?.data?.length}
            </Label>{" "}
          </Header.Subheader>
        </Header>

        {!isLoading && console.log(data.data)}

        {data.data.map((hotel, i) => (
          <GetCityCard hotel={hotel} key={i} />
        ))}
      </Container>
      {data.data.length === 0 && <DataMessage />}
      <Divider />

      <ScrollToTop />
    </div>
  );
}

export default HotelCity;
