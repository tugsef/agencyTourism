import React from "react";
import { Message } from "semantic-ui-react";

function DataMessage() {
  return (
    <Message>
      <Message.Header>Sayfa Sonu </Message.Header>
      <p>Daha fazla otel mevcut değil</p>
    </Message>
  );
}

export default DataMessage;
