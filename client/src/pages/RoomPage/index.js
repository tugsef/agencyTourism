import React from "react";
import { useHotel } from "../../context/HotelContex";
import { useParams } from "react-router-dom";
import { findByHotelIdRoomDate } from "../../service/api";
import { useQuery } from "@tanstack/react-query";
import moment from "moment";
import { Loader, Message, Segment } from "semantic-ui-react";
import RoomSearchCard from "../../components/Card/RoomSearchCard";

function RoomPage() {
  const { id } = useParams();
  const { search } = useHotel();
  const { isLoading, error, data } = useQuery({
    queryKey: ["hotels:roompage", search, id],
    queryFn: () =>
      findByHotelIdRoomDate(id, {
        checkInDate: moment(search.checkInDate).format("DD/MM/YYYY"),
        checkOutDate: moment(search.checkOutDate).format("DD/MM/YYYY"),
        adult: search.adult,
        child: search.child,
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
      {data?.data?.length === 0 && (
        <Message>
          <Message.Header>Sayfa Bulunamadı</Message.Header>
          <p>Aradığınız özelliklerde otel bulunamadı.</p>
        </Message>
      )}

      <RoomSearchCard room={data.data} />
    </div>
  );
}

export default React.memo(RoomPage);
