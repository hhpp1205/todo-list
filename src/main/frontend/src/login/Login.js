import React, {useState} from "react";
import './Login.css';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';
import Button from 'react-bootstrap/Button';

const Login = (props) => {
  const [userEmail, setUserEmail] = useState("");
  const [userPassword, setUserPassword] = useState("");

  const tryLogin = async (loginEmail, loginPassword) => {
    const loginURL = "http://localhost:8080/api/v1/members/login";



    if(!loginEmail) {
      return alert("이메일을 입력해주세요.");
    }

    if(!loginPassword) {
      return alert("비밀번호을 입력해주세요.");
    }

    fetch(loginURL, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({email: loginEmail, password: loginPassword})
    })
      .then(response => {
          if(!response.ok) {
            return response.json();
          }else {
            props.successLogin();
          }
      })
      .then(error => {
        if (error.code == 'C001') {
          return alert("이메일 형식으로 입력해주세요.");
        }
        else if (error.code == 'M002') {
          return alert("로그인 정보가 일치하지 않습니다.");
        }
      });
  }

  return (
    <>
      <InputGroup className="mb-3 input">
        <InputGroup.Text id="inputGroup-sizing-default">
          이메일
        </InputGroup.Text>
        <Form.Control name='userEmail' value={userEmail} onChange={(e) => setUserEmail(e.target.value)}
          aria-label="Default"
          aria-describedby="inputGroup-sizing-default"
          type="email"
        />
      </InputGroup>
      <InputGroup className="mb-5 input">
        <InputGroup.Text id="inputGroup-sizing-default">
          비밀번호
        </InputGroup.Text>
        <Form.Control name='userPassword' value={userPassword} onChange={(e) => setUserPassword(e.target.value)}
          aria-label="Default"
          aria-describedby="inputGroup-sizing-default"
          type="password"
        />
      </InputGroup>
        <Button id='login_button' variant="primary" onClick={() => tryLogin(userEmail, userPassword)}>로그인</Button>
    </>
  );
}

export default Login;