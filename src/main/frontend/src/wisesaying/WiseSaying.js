import React, {useEffect, useState} from "react";
import './WiseSaying.css';


const WiseSaying = () => {
  const [wiseSaying, setWiseSaying] = useState("");

  useEffect(() => {
    fetch('https://api.qwer.pw/request/helpful_text?apikey=guest')
      .then(response => response.json())
      .then(data => {
        if (data[0].result == 'success'){
          setWiseSaying(data[1].respond);
        }else {
          setWiseSaying('습관은 성공의 지름길이다 -홍성민');
        }

      });
  }, []);

  return (
   <>
     <div id='wise-saying-box'>
       {wiseSaying}
     </div>
   </>
  );
}
export default WiseSaying;