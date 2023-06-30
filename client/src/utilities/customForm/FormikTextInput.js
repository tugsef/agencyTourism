import React from "react";
import { useField } from "formik";
import { FormField, Label } from "semantic-ui-react";

export default function KodlamaIoTextInput({ ...props }) {
  const [field, meta] = useField(props);

  return (
    <FormField
      className={`${props.className} equal  width fields`}
      error={meta.touched && !!meta.error}
    >
      <input {...field} {...props} />
      <i className={props.icon}></i>
      {meta.touched && !!meta.error ? (
        <Label floating basic pointing="left" color="red" size="small">
          <p>{meta.error}</p>
        </Label>
      ) : null}
    </FormField>
  );
}
