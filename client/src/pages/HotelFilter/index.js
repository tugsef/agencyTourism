import React from "react";
import {
  Container,
  Divider,
  Header,
  Label,
  Loader,
  Segment,
} from "semantic-ui-react";
import { useHotel } from "../../context/HotelContex";
import { useQuery } from "@tanstack/react-query";
import { fetchFilter } from "../../service/api";
import DataMessage from "../../utilities/DataMessage";
import ScrollToTop from "../../utilities/customForm/ScrollToTop";
import HotelCardPriceQ1 from "../../components/Card/HotelCardPriceQ1";
function HotelFilter() {
  const { search } = useHotel();
  const { isLoading, error, data } = useQuery({
    queryKey: ["hotels:delta", search],
    queryFn: () =>
      fetchFilter({
        roomTypes: [
          search.otel?.[0],
          search.standart?.[0],
          search.suit?.[0],
          search.villa?.[0],
          search.btuqiue?.[0],
        ],
        hotelStars: [
          search.onestars?.[0],
          search.twostars?.[0],
          search.threestars?.[0],
          search.fourstars?.[0],
          search.fivestars?.[0],
        ],
        firstPrice: search.firstprice,
        lastPrice: search.lastprice,
      }),
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
     {}
      <Container fluid>
        <Header as="h1">
          {search.city}
          <br />
          <Header.Subheader>
            {search?.roomTypes
              ?.filter((f) => f === undefined)
              ?.map((f) => (
                <Label>{f}</Label>
              ))}
          </Header.Subheader>
        </Header>
        {!isLoading && console.log(data.data)}

        {data.data.map((hotel, i) => (
          <HotelCardPriceQ1 hotel={hotel} key={i} />
        ))}
      </Container>
      {data.data.length === 0 && <DataMessage />}
      <Divider />
      <ScrollToTop />
    </div>
  );
}

export default HotelFilter;
