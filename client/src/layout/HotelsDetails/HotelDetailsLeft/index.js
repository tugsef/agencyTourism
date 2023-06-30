import { Formik, Form } from "formik";
import React from "react";
import { Button, Divider, Header } from "semantic-ui-react";
import validationSchema from "../../../pages/Home/validations";
import KodlamaIoTextInput from "../../../utilities/customForm/FormikTextInput";
import styles from "./styles.module.css";
import KodlamaIoCheckInput from "../../../utilities/customForm/FormikCheckInput";
import { useHotel } from "../../../context/HotelContex";
import { useNavigate } from "react-router-dom";
function HotelDetailsLeft() {
  const navigate = useNavigate();
  const { setSearch } = useHotel();

  const initialValues = {
    city: "",
    checkInDate: "",
    checkOutDate: "",
    adult: "",
    child: "",
  };
  const initialValuesFilter = {
    firstprice: "",
    lastprice: "",
    onestars: "",
    twostars: "",
    threestars: "",
    fourstars: "",
    fivestars: "",
    btuqiue: "",
    otel: "",
    suit: "",
    standart: "",
    villa: "",
  };
  return (
    <div>
      <div className={styles.container}>
        <Formik
          initialValues={initialValues}
          validationSchema={validationSchema}
          onSubmit={(value) => {
            setSearch(value);
            navigate("/hoteldetails/search");
          }}
        >
          <Form className="ui form">
            <KodlamaIoTextInput
              icon="bed icon small"
              className="ui right icon input medium fluid"
              name="city"
              placeholder="Nereye Gidiyorsun?"
            />
            <KodlamaIoTextInput
              type="date"
              className="ui  input medium fluid"
              name="checkInDate"
            />
            <KodlamaIoTextInput
              type="date"
              className="ui  input medium fluid"
              name="checkOutDate"
              placeholder={0}
            />
            <KodlamaIoTextInput
              icon="add user icon"
              className="ui right icon input medium fluid"
              name="adult"
              placeholder={0}
              style={{ width: "80px" }}
            />

            <KodlamaIoTextInput
              icon="child icon"
              className="ui right icon input medium fluid"
              name="child"
              placeholder={0}
              style={{ width: "80px" }}
            />

            <Button primary type="submit" fluid>
              Ara
            </Button>
          </Form>
        </Formik>
      </div>

      <div className={styles.container2}>
        <Header as="h3">Filtrele </Header>
        <Divider />
        <Formik
          initialValues={initialValuesFilter}
          onSubmit={(value) => {
            setSearch(value);
            navigate("/hoteldetails/filter");
          }}
        >
          <Form className="ui form">
            <div>
              <Header as="h4">Fiyat Aralığı</Header>
              <Divider />
              <KodlamaIoTextInput
                icon="lira sign icon small"
                className="ui left icon input small fluid"
                name="firstprice"
                placeholder="En Düşük Değer"
              />
              <KodlamaIoTextInput
                icon="lira sign icon small"
                className="ui left icon input small fluid"
                name="lastprice"
                placeholder="En Yüksek Değer"
              />

              <Header as="h4">Yıldız Sayısı</Header>
              <Divider />
              <KodlamaIoCheckInput
                type="checkbox"
                className="ui  checkbox small fluid"
                name="fivestars"
                value="5"
                label="Beş Yıldızlı"
              />
              <br />
              <KodlamaIoCheckInput
                type="checkbox"
                className="ui  checkbox small fluid"
                name="fourstars"
                value="4"
                label="Dört Yıldızlı"
              />
              <br />
              <KodlamaIoCheckInput
                type="checkbox"
                className="ui  checkbox small fluid"
                name="threestars"
                value="3"
                label="Üç Yıldızlı"
              />
              <br />
              <KodlamaIoCheckInput
                type="checkbox"
                className="ui  checkbox small fluid"
                name="twostars"
                value="2"
                label="İki Yıldızlı"
              />
              <br />
              <KodlamaIoCheckInput
                type="checkbox"
                className="ui  checkbox small fluid"
                name="onestars"
                value="1"
                label="Bir Yıldızlı"
              />

              <Header as="h4">Tesis Tipleri</Header>
              <Divider />
              <KodlamaIoCheckInput
                type="checkbox"
                className="ui  checkbox small fluid"
                name="btuqiue"
                value="Butik"
                label="Butik Otel"
              />
              <br />
              <KodlamaIoCheckInput
                type="checkbox"
                className="ui  checkbox small fluid"
                name="otel"
                value="Otel"
                label="Otel"
              />
              <br />
              <Header as="h4">Oda Tipleri</Header>
              <Divider />
              <KodlamaIoCheckInput
                type="checkbox"
                className="ui  checkbox small fluid"
                name="standart"
                value="Standart"
                label="Standart"
              />
              <br />
              <KodlamaIoCheckInput
                type="checkbox"
                className="ui  checkbox small fluid"
                name="suit"
                value="Suit"
                label="Suit"
              />
              <br />
              <KodlamaIoCheckInput
                type="checkbox"
                className="ui  checkbox small fluid"
                name="villa"
                value="Villa"
                label="Villa"
              />

              <br />
              <Button primary type="submit" fluid>
                Ara
              </Button>
            </div>
          </Form>
        </Formik>
      </div>
    </div>
  );
}

export default HotelDetailsLeft;
