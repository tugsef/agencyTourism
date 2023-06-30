import { Formik, Form } from "formik";
import React from "react";
import { Button, Divider, Header } from "semantic-ui-react";
import validationSchema from "../../../pages/Home/validations";
import KodlamaIoTextInput from "../../../utilities/customForm/FormikTextInput";
import styles from "./styles.module.css";
import KodlamaIoCheckInput from "../../../utilities/customForm/FormikCheckInput";
import { useHotel } from "../../../context/HotelContex";
import { useNavigate } from "react-router-dom";
function HotelDetailLeft() {
  const navigate = useNavigate();
  const { setSearch } = useHotel();

  const initialValues = {
    city: "",
    checkInDate: "",
    checkOutDate: "",
    adult: "",
    child: "",
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
              className="ui right icon input small fluid"
              name="city"
              placeholder="Nereye Gidiyorsun?"
            />
            <KodlamaIoTextInput
              type="date"
              className="ui input medium fluid"
              name="checkInDate"
            />
            <KodlamaIoTextInput
              type="date"
              className="uiinput medium fluid"
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
       
      </div>
    </div>
  );
}

export default HotelDetailLeft;
