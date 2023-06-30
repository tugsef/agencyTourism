import { useQuery } from "@tanstack/react-query";
import React, { useState } from "react";
import { getAllStarSortDesc } from "../../service/api";
import {
  Button,
  Container,
  Divider,
  Header,
  Label,
  Loader,
  Segment,
} from "semantic-ui-react";
import ScrollToTop from "../../utilities/customForm/ScrollToTop";
import DataMessage from "../../utilities/DataMessage";
import HotelPriceCard from "../../components/Card/HotelPriceCard";

function AllDescStar() {
  const [count, setCount] = useState(1);
  const { isLoading, error, data } = useQuery({
    queryKey: ["hotels::descstar", count],
    queryFn: () => getAllStarSortDesc(count),
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
        <Header>
          En Yüksek Yıldız
          <Header.Subheader>
            Sayfa da görüntülenen hotel sayısı
            <Label circular color="red">
              {data?.data?.length}
            </Label>{" "}
          </Header.Subheader>
        </Header>
        {!isLoading && console.log(data.data)}

        {data.data.map((hotel, i) => (
          <HotelPriceCard hotel={hotel} key={i} />
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

export default AllDescStar;
