import React, { useState } from "react";
import {
  Button,
  Container,
  Grid,
  Header,
  Message,
  Segment,
} from "semantic-ui-react";
import validationSchema from "./validations";
import { Formik, Form } from "formik";
import styles from "./styles.module.css";
import { fetchLogin } from "../../../service/api";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../../context/AuthContex";
import KodlamaIoTextInput from "../../../utilities/customForm/FormikTextInput";
import Signup from "../Signup";
import { toast } from "react-toastify";

function Signin() {
  const [open, setOpen] = useState(false);
  const navigate = useNavigate();
  const { login } = useAuth();

  const initialValues = { username: "", password: "" };

  const handleSubmit = async (values, bag) => {
    console.log(values);
    try {
      const loginResponse = await fetchLogin({
        username: values.username,
        password: values.password,
      });

      login(loginResponse);
      navigate("/");

      toast.success("Giriş Başarılı");

      console.log(loginResponse);
    } catch (e) {
      bag.setErrors({ general: e.response.data.message });
      toast.error("Parola veya şifre hatalı");
    }
  };

  return (
    <div>
      <Container className={styles.container} text>
        <Grid textAlign="center" stackable verticalAlign="middle">
          <Grid.Column className={styles.column}>
            <Segment stacked padded>
              <Header textAlign="center" block>
                Giris yapın veya kayıt olun
              </Header>

              <Formik
                initialValues={initialValues}
                validationSchema={validationSchema}
                onSubmit={handleSubmit}
              >
                <Form className="ui  form">
                  <KodlamaIoTextInput
                    icon="user icon "
                    className="ui right  icon input medium fluid"
                    name="username"
                    placeholder="Kullanıcı Adı"
                  />
                  <KodlamaIoTextInput
                    type="password"
                    icon="key icon"
                    className="ui right icon input medium fluid"
                    name="password"
                    placeholder="Parola"
                  />

                  <button className="ui primary button fluid" type="submit">
                    Giriş Yap
                  </button>
                  <hr />
                </Form>
              </Formik>

              {open ? (
                <Signup />
              ) : (
                <Button
                  className="ui positive button fluid"
                  onClick={() => setOpen(true)}
                >
                  Kayıt Ol
                </Button>
              )}
            </Segment>
          </Grid.Column>
        </Grid>
      </Container>
    
    </div>
  );
}

export default Signin;
