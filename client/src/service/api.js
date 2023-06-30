import axios from "axios";

const config = {
  headers: { Authorization: `Bearer ${localStorage.getItem("access-token")}` },
};

export const fetchLogin = async (input) => {
  console.log(input);
  const { data } = await axios.post(
    `${process.env.REACT_APP_BASE_ENDPOINT}/auth/signin`,
    input
  );

  return data;
};
export const fetchRegister = async ( input ) => {
  console.log(input);
  const { data } = await axios.post(
    `${process.env.REACT_APP_BASE_ENDPOINT}/auth/signup`,
    input
  );

  return data;
};

export const fetchHotelsMapList = async (input) => {
  console.log(input);
  const { data } = await axios.get(
    `${process.env.REACT_APP_BASE_ENDPOINT}/hotels/getAllMap?pageSize=7&pageNo=${input}`
  );

  return data;
};

export const getAllStarSortDesc = async (input) => {
  const { data } = await axios.get(
    `${process.env.REACT_APP_BASE_ENDPOINT}/hotels/starDesc/${input}`
  );
  return data;
};

export const getAllStarSortAsc = async (input) => {
  const { data } = await axios.get(
    `${process.env.REACT_APP_BASE_ENDPOINT}/hotels/starAsc/${input}`
  );
  return data;
};
export const getAllPrice = async () => {
  const { data } = await axios.get(
    `${process.env.REACT_APP_BASE_ENDPOINT}/rooms/prices`
  );
  console.log(data);
  return data;
};
export const getAllStarPriceAsc = async (input) => {
  const { data } = await axios.get(
    `${process.env.REACT_APP_BASE_ENDPOINT}/rooms/prices/asc/${input}`
  );
  console.log(data);
  return data;
};

export const getAllPriceSortDesc = async (input) => {
  const { data } = await axios.get(
    `${process.env.REACT_APP_BASE_ENDPOINT}/rooms/prices/desc/${input}`
  );
  console.log(data);
  return data;
};

export const findByOrderByRatingDescRoomsPricesQ1Asc = async (input) => {
  const { data } = await axios.get(
    `${process.env.REACT_APP_BASE_ENDPOINT}/hotels/ratingdescpriceasc/${input}`
  );
  console.log(data);
  return data;
};

export const findByCity = async (input) => {
  const { data } = await axios.get(
    `${process.env.REACT_APP_BASE_ENDPOINT}/location/${input}`
  );
  console.log(data);
  return data;
};

export const signOutUser = async () => {
  const { data } = await axios.post(
    `${process.env.REACT_APP_BASE_ENDPOINT}/auth/signout`,
    config
  );
  console.log(data);
  return { data };
};

export const fetchSearch = async (search) => {
  const { data } = await axios.post(
    `${process.env.REACT_APP_BASE_ENDPOINT}/hotels/search`,
    search
  );
  console.log(data);
  return data;
};

export const fetchFilter = async (search) => {
  const { data } = await axios.post(
    `${process.env.REACT_APP_BASE_ENDPOINT}/rooms/prices/filter`,
    search
  );
  console.log(data);
  return data;
};

export const fetchfindByIdHotel =async (id) => {
  const { data } = await axios.get(
    `${process.env.REACT_APP_BASE_ENDPOINT}/hotels/${id}`
  );
  console.log(data);
  return data;
}

export const findByHotelIdRoomDate =async (id , search) => {
  console.log(id);
  console.log(search);
  const { data } = await axios.post(
    `${process.env.REACT_APP_BASE_ENDPOINT}/rooms/search/${id}` , search
  );
  console.log(data);
  return data;
}