import * as yup from "yup";

const validationSchema = yup.object().shape({
  city: yup.string().required("Zorunlu Alan"),
  checkInDate: yup.date().required("Zorunlu Alan"),
  checkOutDate: yup.date().required("Zorunlu Alan"),
  adult: yup.number("Rakam").required("Zorunlu Alan"),
  child: yup.number("Rakam").required("Zorunlu Alan"),
});

export default validationSchema;
