import { Route, Routes } from "react-router-dom";
import "./App.css";
import Signin from "./pages/Auth/Signin";
import Home from "./pages/Home";
import NoMatch from "./pages/NoMatch";
import HomeLayout from "./layout/HomeLayout";
import "react-toastify/dist/ReactToastify.min.css";
import "@splidejs/react-splide/css";
import "@splidejs/react-splide/css/skyblue";
import "@splidejs/react-splide/css/sea-green";
import "@splidejs/react-splide/css/core";
import HotelCity from "./pages/HotelCity";

import NoPage from "./pages/NoPage";
import HotelsDetailsLayout from "./layout/HotelsDetails";
import HotelsList from "./pages/HotelsList";
import { ToastContainer } from "react-toastify";
import ScrollToTop from "./utilities/customForm/ScrollToTop";
import AllDescStar from "./pages/AllDescStar";
import AllAscStar from "./pages/AllAscStar";
import Deneme from "./pages/Deneme";
import AllAscPrice from "./pages/AllAscPrice";
import AllDescPrice from "./pages/AllDescPrice";
import AllRatingDescPriceAsc from "./pages/AllRatingDescPriceAsc";
import HotelSearch from "./pages/HotelSearch";
import HotelFilter from "./pages/HotelFilter";
import HotelDetail from "./layout/HotelDetail";
import RoomPage from "./pages/RoomPage";





function App() {
  
  return (
    <>
      <ToastContainer
        position="bottom-center"
        autoClose={5000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
        theme="colored"
      />
     

      <Routes>
        <Route path="/" element={<HomeLayout />}>
          <Route index element={<Home />} />

          <Route path="hoteldetails" element={<HotelsDetailsLayout />}>
            <Route index="/" element={<HotelsList />} />
            <Route path="hotellist" element={<HotelsList />} />
            <Route path="descstar" element={<AllDescStar />} />
            <Route path="ascstar" element={<AllAscStar />} />
            <Route path="ascprice" element={<AllAscPrice />} />
            <Route path="descprice" element={<AllDescPrice />} />
            <Route path=":city" element={<HotelCity />} />
            <Route
              path="ratingdescpriceasc"
              element={<AllRatingDescPriceAsc />}
            />
            <Route path="search" element={<HotelSearch />} />
            <Route path="filter" element={<HotelFilter />} />
          </Route>
          <Route path="hoteldetail/:id" element={<HotelDetail />}>
            <Route path=":id" element={<RoomPage/>}/>
          </Route>
        </Route>
        
        <Route path="/signin" element={<Signin />} />
        <Route path="/nopage" element={<NoPage />} />
        <Route path="/deneme" element={<Deneme />} />
        <Route path="/*" element={<NoMatch />} />
      </Routes>
    </>
  );
}

export default App;
