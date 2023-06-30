import styles from "./styles.module.css";
import { Button, Container, Header, Menu } from "semantic-ui-react";
import KodlamaIoTextInput from "../../utilities/customForm/FormikTextInput";
import { Formik, Form } from "formik";
import validationSchema from "./validations";
import "@splidejs/react-splide/css";
import SelectCardOtel from "../../components/Card/SelectCardOtel";
import { Link, useNavigate } from "react-router-dom";
import { useHotel } from "../../context/HotelContex";

function Home() {
  const { setSearch } = useHotel();
  const navigate = useNavigate();

  const initialValues = {
    city: "",
    checkInDate: "",
    checkOutDate: "",
    adult: "",
    child: "",
  };
  return (
    <>
      <Container className={styles.container} fluid>
        <Container text>
          <br />
          <br />
          <br />
          <Header as="h1" inverted className={styles.hc}>
            Yaz Fırsatlarını Kaçırma
          </Header>
          <Header as="h2" inverted>
            Rezervazyon Yap
          </Header>
          <Header as="h1" inverted className={styles.hc}>
            %15 indirim
          </Header>
          <Header as="h2" inverted>
            Puan Kazan
          </Header>
          <Header as="h1"></Header>
          <Button as={Link} to="/hoteldetails" inverted>
            Oteller
          </Button>
        </Container>
      </Container>

      <Container className={styles.cm}>
        <Formik
          initialValues={initialValues}
          validationSchema={validationSchema}
          onSubmit={(value) => {
            setSearch(value);

            navigate("/hoteldetails/search");
          }}
        >
          <Form className="ui form" style={{ margin: "2em" }}>
            <Menu stackable borderless color="olive">
              <Menu.Item>
                <KodlamaIoTextInput
                  icon="bed icon"
                  className="ui right icon input midium "
                  name="city"
                  placeholder="Nereye Gidiyorsun?"
                />
              </Menu.Item>
              <Menu.Item>
                <KodlamaIoTextInput
                  type="date"
                  className="ui   input midium "
                  name="checkInDate"
                />
              </Menu.Item>
              <Menu.Item>
                <KodlamaIoTextInput
                  type="date"
                  className="ui   input midium"
                  name="checkOutDate"
                />
              </Menu.Item>

              <Menu.Item>
                <KodlamaIoTextInput
                  icon="add user icon"
                  className="ui right icon input midium "
                  name="adult"
                  placeholder={0}
                  style={{ width: "160px" }}
                />
              </Menu.Item>

              <Menu.Item>
                <KodlamaIoTextInput
                  icon="child icon"
                  className="ui right icon input midium"
                  name="child"
                  placeholder={0}
                  style={{ width: "160px" }}
                />
              </Menu.Item>

              <Menu.Item>
                <Button primary type="submit" fluid>
                  Ara
                </Button>
              </Menu.Item>
            </Menu>
          </Form>
        </Formik>
      </Container>
      <SelectCardOtel />
    </>
  );
}

export default Home;
