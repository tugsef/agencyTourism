import { fetchSearch } from "../../service/api";
import { useQuery } from "@tanstack/react-query";
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
import moment from "moment";
import { useHotel } from "../../context/HotelContex";
import HotelSearchCard from "../../components/Card/HotelSearchCard";
import { dateFunction } from "../../utilities/DateFunction";

function HotelSearch() {
  const { search } = useHotel();
  const { isLoading, error, data } = useQuery({
    queryKey: ["hotels::search", search],
    queryFn: () =>
      fetchSearch({
        city: search.city,
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
      <Container fluid>
        <Header as="h1">
          Oteller
          <Header.Subheader>Hersey hayallerle baslar.</Header.Subheader>
          <Header.Subheader>
            Sayfada görüntülenen otel sayısı
            <Label circular color="red">
              {data?.data?.length}
            </Label>{" "}
          </Header.Subheader>
        </Header>
        <Header as="h1">
          {search.city}
          <br />
          <Header.Subheader>
            <Label color="teal">
              {" "}
              Giriş Tarihi :{moment(search.checkInDate).format(
                "DD/MM/YYYY"
              )}{" "}
            </Label>
            <Label color="teal">
              {" "}
              Çıkış Tarihi:{moment(search.checkOutDate).format(
                "DD/MM/YYYY"
              )}{" "}
            </Label>
            <Label color="teal">
              {" "}
              {dateFunction(search.checkInDate, search.checkOutDate)} Gece
            </Label>
          </Header.Subheader>
        </Header>
        {!isLoading && console.log(data.data)}

        {data.data.map((hotel, i) => (
          <HotelSearchCard hotel={hotel} key={i} />
        ))}
      </Container>
      {data.data.length === 0 && <DataMessage />}
      <Divider />

      <ScrollToTop />
    </div>
  );
}

export default HotelSearch;
