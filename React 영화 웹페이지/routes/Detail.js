import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
function Detail() {
  const[index,setIndex] =useState([]);
  const { id } = useParams();
  const getMovie = async () => {
    const json = await (
      await fetch(`https://yts.mx/api/v2/movie_details.json?movie_id=${id}`)
    ).json();
    setIndex(json.data.movie);
    console.log(index);
  };
  useEffect(() => {
    getMovie();
  }, []);
  return (
    <div>
      <div key={index.id}>
        <img src={index.medium_cover_image} />
        <h2>{index.title}</h2>
        <h3>{index.description_full}</h3>
        <h3>{index.genres}</h3>
        <h3>{index.rating}</h3>
      </div>
  </div>
  );
}
export default Detail;