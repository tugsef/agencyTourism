import { Splide, SplideSlide } from "@splidejs/react-splide";
import React from "react";
import { Link } from "react-router-dom";
import {
  Card,
  Container,
  Divider,
  Header,
  Image,
  Reveal,
} from "semantic-ui-react";

function SelectCardOtel() {
  return (
    <div>
      <Container stackable="true">
        <Header size="large"> TercihEdilenler</Header>
        <Divider />
        <Splide
          options={{
            rewind: true,
            arrows: false,

            type: "loop",
          }}
        >
          <SplideSlide>
            <Container fluid>
              <Card.Group stackable style={{ margin: "1em" }} itemsPerRow={2}>
                <Card
                  as={Link}
                  to="/hoteldetails/İzmir"
                  header="İzmir Otelleri"
                  raised
                  image={
                    <Reveal animated="small fade">
                      <Reveal.Content visible>
                        <Image src="https://res.cloudinary.com/dvfdwlbuy/image/upload/h_342,w_612/v1687741745/saat-kulesi_elsvqu.jpg" />
                      </Reveal.Content>
                      <Reveal.Content hidden>
                        <Image src="https://res.cloudinary.com/dvfdwlbuy/image/upload/h_342,w_612/v1686944328/izmir_crfjzi.jpg" />
                      </Reveal.Content>
                    </Reveal>
                  }
                />

                <Card
                  as={Link}
                  to="/hoteldetails/Balıkesir"
                  header="Balıkesir Otelleri"
                  raised
                  image={
                    <Reveal animated="small fade">
                      <Reveal.Content visible>
                        <Image src="https://res.cloudinary.com/dvfdwlbuy/image/upload/h_342,w_612/v1686944378/bal%C4%B1kesir_a2t8uc.jpg" />
                      </Reveal.Content>
                      <Reveal.Content hidden>
                        <Image src="https://res.cloudinary.com/dvfdwlbuy/image/upload/h_342,w_612/v1687742112/balikesir-cunda_705069346-11.05.2021101211_siy5b2.webp" />
                      </Reveal.Content>
                    </Reveal>
                  }
                />
              </Card.Group>
            </Container>
          </SplideSlide>

          <SplideSlide>
            <Container fluid>
              <Card.Group stackable style={{ margin: "1em" }} itemsPerRow={2}>
                <Card
                  as={Link}
                  to="/hoteldetails/Ankara"
                  header="Ankara Otelleri"
                  raised
                  image={
                    <Reveal animated="small fade" wrapped="true">
                      <Reveal.Content visible>
                        <Image src="https://res.cloudinary.com/dvfdwlbuy/image/upload/h_342,w_612/v1686943994/ankara_xrdnge.webp" />
                      </Reveal.Content>
                      <Reveal.Content hidden>
                        <Image src="https://res.cloudinary.com/dvfdwlbuy/image/upload/h_342,w_612/v1686943422/otels_foto_obdtyr.jpg" />
                      </Reveal.Content>
                    </Reveal>
                  }
                />

                <Card
                  as={Link}
                  to="/hoteldetails/İstanbul"
                  header="İstanbul Otelleri"
                  raised
                  image={
                    <Reveal animated="small fade" wrapped="true">
                      <Reveal.Content visible>
                        <Image src="https://res.cloudinary.com/dvfdwlbuy/image/upload/h_342,w_612/v1687741632/cami-ve-bo_C4_9Faz-k_C3_B6pr_C3_BCs_C3_BC_xeaqi8.jpg" />
                      </Reveal.Content>
                      <Reveal.Content hidden>
                        <Image src="https://res.cloudinary.com/dvfdwlbuy/image/upload/h_342,w_612/v1686944202/istanbul_rdj3bx.jpg" />
                      </Reveal.Content>
                    </Reveal>
                  }
                />
              </Card.Group>
            </Container>
          </SplideSlide>
        </Splide>
      </Container>
      <Container>
        <Header size="large">Mükemmel Yerler</Header>
        <Divider />
        <Splide
          options={{
            rewind: true,

            pagination: false,

            type: "loop",
          }}
        >
          <SplideSlide>
            <Container fluid>
              <Card.Group stackable style={{ margin: "1em" }} itemsPerRow={3}>
                <Card
                  as={Link}
                  to="/nopage"
                  description="Yunan Adaları"
                  raised
                  image={
                    "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686944933/yunan_lx5hgc.jpg"
                  }
                />

                <Card
                  as={Link}
                  to="/nopage"
                  description="Gizemli Mısır"
                  raised
                  image={
                    "https://res.cloudinary.com/dvfdwlbuy/image/upload/h_800,w_1200/v1686944825/piramit_wzbbwf.jpg"
                  }
                />
                <Card
                  as={Link}
                  to="/nopage"
                  description="Umre"
                  raised
                  image={
                    "https://res.cloudinary.com/dvfdwlbuy/image/upload/h_800,w_1200/v1686944644/umre_ripdgi.jpg"
                  }
                />
              </Card.Group>
            </Container>
          </SplideSlide>

          <SplideSlide>
            <Container fluid>
              <Card.Group stackable style={{ margin: "1em" }} itemsPerRow={3}>
                <Card
                  as={Link}
                  to="/nopage"
                  description="Tatil Zamanı"
                  raised
                  image={
                    "https://res.cloudinary.com/dvfdwlbuy/image/upload/h_800,w_1200/v1686944588/tatilli_fegggi.jpg"
                  }
                />

                <Card
                  as={Link}
                  to="/nopage"
                  description="Tarihi Mekanlar"
                  raised
                  image={
                    "https://res.cloudinary.com/dvfdwlbuy/image/upload/h_800,w_1200/v1686944505/tarihi_pwewlw.jpg"
                  }
                />
                <Card
                  as={Link}
                  to="/nopage"
                  description="Keşfet"
                  raised
                  image={
                    "https://res.cloudinary.com/dvfdwlbuy/image/upload/h_800,w_1200/v1686667072/add.jpg"
                  }
                />
              </Card.Group>
            </Container>
          </SplideSlide>
        </Splide>
      </Container>
      <Container>
        <Header size="large"> Tatil Temaları</Header>
        <Divider />
        <Card.Group itemsPerRow={3}>
          <Card
            as={Link}
            to="/nopage"
            meta="Ultra herşey dahil oteller"
            color="red"
            image={
              "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686667072/add.jpg"
            }
          />
          <Card
            as={Link}
            to="/nopage"
            color="orange"
            image={
              "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686667072/add.jpg"
            }
            meta="Erken Rezervasyon Otelleri "
          />
          <Card
            as={Link}
            to="/select"
            color="yellow"
            image={
              "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686667072/add.jpg"
            }
            meta="Hafta Sonu Otelleri"
          />
          <Card
            as={Link}
            to="/nopage"
            color="olive"
            image={
              "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686667072/add.jpg"
            }
            meta="Jakuzili Otelleri"
          />

          <Card
            as={Link}
            to="/nopage"
            color="green"
            image={
              "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686667072/add.jpg"
            }
            meta="Muhafazakar Otelleri"
          />
          <Card
            as={Link}
            to="/nopage"
            color="teal"
            image={
              "https://res.cloudinary.com/dvfdwlbuy/image/upload/v1686667072/add.jpg"
            }
            meta="Balayı Otelleri"
          />
        </Card.Group>
      </Container>
    </div>
  );
}

export default SelectCardOtel;
