import React from "react";
import { useField } from "formik";
import { FormField, Label } from "semantic-ui-react";

export default function KodlamaIoCheckInput({ ...props }) {
  const [field, meta] = useField(props);

  return (
    <FormField className={props.className} error={meta.touched && !!meta.error}>
      <input {...field} {...props} />
      <label>{props.label}</label>
      {meta.touched && !!meta.error ? (
        <Label floating basic pointing="left" color="red" size="small">
          <p>{meta.error}</p>
        </Label>
      ) : null}
    </FormField>
  );
}
