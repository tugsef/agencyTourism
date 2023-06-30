import React from "react";
import {
  Button,
  Container,
  Grid,
  Header,
  Loader,
  Segment,
} from "semantic-ui-react";
import styles from "./styles.module.css";
import { Link, Outlet, useNavigate, useParams } from "react-router-dom";
import HotelDetailLeft from "./HotelDetailLeft";
import HotelDetailsCard from "../../components/Card/HotelDetailsCard";
import { useQuery } from "@tanstack/react-query";
import { fetchfindByIdHotel } from "../../service/api";
import { Formik, Form } from "formik";
import KodlamaIoTextInput from "../../utilities/customForm/FormikTextInput";
import validationSchema from "./validationSchema";
import { useHotel } from "../../context/HotelContex";
import RoomCard from "../../components/Card/RoomCard";

function HotelDetail() {
  const { id } = useParams();
  const { setSearch } = useHotel();
  const navigate = useNavigate();
  const initialValues = {
    checkInDate: "",
    checkOutDate: "",
    adult: "",
    child: "",
  };

  const { isLoading, error, data } = useQuery({
    queryKey: ["hotels:delta", id],
    queryFn: () => fetchfindByIdHotel(id),
  });

  if (isLoading)
    return (
      <Segment inverted tertiary>
        <Loader active inverted />
      </Segment>
    );
  if (error) return "An error has occurred: " + error.message;

  return (
    <div className={styles.container}>
      <Grid>
        <Grid.Row textAlign="center">
          <Grid.Column width={16}>
            <Grid columns={5} stackable>
              <Grid.Column as={Link} to="/hoteldetails/descstar">
                <Segment raised>En yüksek yıldız</Segment>
              </Grid.Column>
              <Grid.Column as={Link} to="/hoteldetails/ascstar">
                <Segment raised>En düşük Yıldız</Segment>
              </Grid.Column>
              <Grid.Column as={Link} to="/hoteldetails/ratingdescpriceasc">
                <Segment raised>En yüksek puan , En düşük fiyat</Segment>
              </Grid.Column>
              <Grid.Column as={Link} to="/hoteldetails/descprice">
                <Segment raised>En yüksek fiyat</Segment>
              </Grid.Column>
              <Grid.Column as={Link} to="/hoteldetails/ascprice">
                <Segment raised>En düşük fiyat</Segment>
              </Grid.Column>
            </Grid>
          </Grid.Column>
        </Grid.Row>
        <Grid.Row>
          <Grid columns={2}>
            <Grid.Column
              className={`${styles.colx} ${styles.scrollbar}`}
              computer={3}
              mobile={16}
            >
              <HotelDetailLeft />
            </Grid.Column>
            <Grid.Column
              className={`${styles.scrollbar}`}
              computer={12}
              mobile={16}
            >
              <HotelDetailsCard hotel={data.data} i={data.id} />
              <Container>
                <br />
                <Header as="h3" dividing>
                  Otel Odaları
                </Header>
                <RoomCard room={data.data.rooms} />
              </Container>
              <Container>
                <Formik
                  initialValues={initialValues}
                  validationSchema={validationSchema}
                  onSubmit={(value) => {
                    setSearch(value);
                    navigate(id);
                  }}
                >
                  <Form className="ui form" style={{ margin: "2em" }}>
                    <Header as="h3" dividing>
                      Müsait Oda Ara
                    </Header>
                    <Segment.Group horizontal>
                      <Segment>
                        <KodlamaIoTextInput
                          type="date"
                          className="ui input midium "
                          name="checkInDate"
                          style={{ width: "150px" }}
                        />
                      </Segment>
                      <Segment>
                        <KodlamaIoTextInput
                          type="date"
                          className="ui  input midium "
                          name="checkOutDate"
                          style={{ width: "150px" }}
                        />
                      </Segment>
                      <Segment>
                        <KodlamaIoTextInput
                          icon="add user icon"
                          className="ui right icon input midium "
                          name="adult"
                          placeholder={0}
                          style={{ width: "80px" }}
                        />
                      </Segment>
                      <Segment>
                        <KodlamaIoTextInput
                          icon="child icon"
                          className="ui right icon input medium "
                          name="child"
                          placeholder={0}
                          style={{ width: "80px" }}
                        />
                      </Segment>
                      <Segment textAlign="center">
                        <Button primary type="submit" fluid>
                          Ara
                        </Button>
                      </Segment>
                    </Segment.Group>
                  </Form>
                </Formik>
              </Container>

              <Outlet />
            </Grid.Column>
          </Grid>
        </Grid.Row>
      </Grid>
    </div>
  );
}

export default React.memo(HotelDetail);
