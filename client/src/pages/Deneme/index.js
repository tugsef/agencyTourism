import React from "react";
import { fetchFilter } from "../../service/api";
import { useQuery } from "@tanstack/react-query";
import { Loader, Segment } from "semantic-ui-react";
import { useHotel } from "../../context/HotelContex";

function Deneme() {
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
          search.firstprice?.[0],
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
  return <div>{console.log(data)}</div>;
}

export default Deneme;
