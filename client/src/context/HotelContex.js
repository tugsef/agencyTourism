import { createContext, useContext, useState } from "react";

const HotelContext = createContext();

const HotelProvider = ({ children }) => {
  const [search, setSearch] = useState();
  const [room, setRoom] = useState();
  const values = {
    search,
    setSearch,
    room,
    setRoom,
  };

  return (
    <HotelContext.Provider value={values}>{children}</HotelContext.Provider>
  );
};

const useHotel = () => useContext(HotelContext);

export { HotelProvider, useHotel };
