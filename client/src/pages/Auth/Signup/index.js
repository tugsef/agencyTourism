import React from "react";
import { Button, Container, Grid, Icon, Modal } from "semantic-ui-react";
import KodlamaIoTextInput from "../../../utilities/customForm/FormikTextInput";
import { Form, Formik } from "formik";
import validationSchema from "./validations";
import { toast } from "react-toastify";
import { fetchRegister } from "../../../service/api";

function Signup() {
  const initialValues = {
    username: "",
    email: "",
    password: "",
    passwordConfirm: "",
  };
  const [open, setOpen] = React.useState(true);

  const onClose = () => {
    setOpen(false);
  };

  const handleSubmit = async (values, bag) => {
    console.log(values);

    try {
      const registerResponse = await fetchRegister({
        username: values.username,
        email: values.email,
        password: values.password,
        role: [],
      });
      console.log(registerResponse);
      toast.success(registerResponse.message);
    } catch (e) {
      toast.error("E-posta veya Kullanıcı Mevcut");
      bag.setErrors({ general: e.response.data.message });
    }
  };

  return (
    <Modal
      open={open}
      onClose={onClose}
      onOpen={() => setOpen(true)}
      trigger={<Button className="ui positive button fluid">Kayıt Ol</Button>}
    >
      <Modal.Header>Kayıt Ol</Modal.Header>
      <Modal.Content scrolling>
        <Modal.Description>
          <Container text>
            <Grid textAlign="center" stackable verticalAlign="middle">
              <Grid.Column>
                <Formik
                  initialValues={initialValues}
                  validationSchema={validationSchema}
                  onSubmit={handleSubmit}
                >
                  <Form className="ui form">
                    <KodlamaIoTextInput
                      className="ui right  icon input big"
                      name="username"
                      placeholder="Kullanıcı Adı"
                    />
                    <br />
                    <KodlamaIoTextInput
                      className="ui right icon input big"
                      name="email"
                      placeholder="Email"
                    />
                    <br />
                    <KodlamaIoTextInput
                      type="password"
                      className="ui right icon input big"
                      name="password"
                      placeholder="Parola"
                    />
                    <br />
                    <KodlamaIoTextInput
                      type="password"
                      className="ui right icon input big"
                      name="passwordConfirm"
                      placeholder="Parola tekrar"
                    />
                    <br />

                    <button className="ui positive button fluid" type="submit">
                      Kayıt Ol
                    </button>
                  </Form>
                </Formik>
              </Grid.Column>
            </Grid>
          </Container>
        </Modal.Description>
      </Modal.Content>
      <Modal.Actions>
        <Button onClick={() => setOpen(false)} negative>
          Çıkış <Icon name="chevron right" />
        </Button>
      </Modal.Actions>
    </Modal>
  );
}

export default Signup;
