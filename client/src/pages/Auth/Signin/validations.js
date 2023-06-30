import * as yup from "yup";

const validationSchema = yup.object().shape({
  username: yup
    .string()
    .required("Zorunlu Alan")
    .max(20, "Karakter Sayısı geçildi"),
  password: yup
    .string()
    .required("Zorunlu Alan")
    .max(120, "Karakter Sayısı geçildi"),
});

export default validationSchema;
