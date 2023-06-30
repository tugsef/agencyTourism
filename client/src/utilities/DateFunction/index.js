export const dateFunction = (startDate, endDate) => {
  startDate = new Date(startDate);
  endDate = new Date(endDate);
  const difference = new Date(endDate - startDate);
  const day = Math.floor(difference / 1000 / 60 / 60 / 24);
  return day;
};
