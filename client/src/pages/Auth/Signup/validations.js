import * as yup from "yup";
const validationSchema = yup.object().shape({
  username: yup
    .string()
    .required("Zorunlu Alan")
    .min(3, "3 karakter az olamaz.")
    .max(12, "10 karakterden fazla olamaz."),
  email: yup.string().email("Gerçerli email").required("Zorunlu alan."),
  password: yup
    .string()
    .min(5, "Parolanız en az 5 karakter olmalıdır")
    .required("Zorunlu alan."),
  passwordConfirm: yup
    .string()
    .oneOf([yup.ref("password")], "Parolalar uyuşmuyor.")
    .required("Boş Bırakılamaz"),
});

export default validationSchema;
