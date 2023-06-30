import React from "react";
import { Grid, Segment } from "semantic-ui-react";
import styles from "./styles.module.css";
import { Link, Outlet } from "react-router-dom";
import HotelDetailsLeft from "./HotelDetailsLeft";
import ScrollToTop from "../../utilities/customForm/ScrollToTop";
function HotelsDetailsLayout() {
  return (
    <div className={styles.container}>
      <Grid>
        <Grid.Row textAlign="center">
          <Grid.Column width={16}>
            <Grid columns={5} stackable>
              <Grid.Column as={Link} to="/hoteldetails/descstar">
                <Segment raised>En yüksek yıldız</Segment>
              </Grid.Column>
              <Grid.Column as={Link} to="/hoteldetails/ascstar">
                <Segment raised>En düşük Yıldız</Segment>
              </Grid.Column>
              <Grid.Column as={Link} to="/hoteldetails/ratingdescpriceasc">
                <Segment raised>En yüksek puan , En düşük fiyat</Segment>
              </Grid.Column>
              <Grid.Column as={Link} to="/hoteldetails/descprice">
                <Segment raised>En yüksek fiyat</Segment>
              </Grid.Column>
              <Grid.Column as={Link} to="/hoteldetails/ascprice">
                <Segment raised>En düşük fiyat</Segment>
              </Grid.Column>
            </Grid>
          </Grid.Column>
        </Grid.Row>
        <Grid.Row>
          <Grid columns={2}>
            <Grid.Column
              className={`${styles.colx} ${styles.scrollbar}`}
              computer={3}
              mobile={16}
            >
              <HotelDetailsLeft />
            </Grid.Column>
            <Grid.Column
              className={`${styles.scrollbar}`}
              computer={12}
              mobile={16}
            >
              <Outlet />
              <ScrollToTop />
            </Grid.Column>
          </Grid>
        </Grid.Row>
      </Grid>
    </div>
  );
}

export default HotelsDetailsLayout;
