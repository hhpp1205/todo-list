import styled from "styled-components";
import React from "react";

type ModalProps = {
    onConfirm: () => void;
    onCancel: () => void;
    message: string;
};

const ModalOverlay = styled.div`
  position: fixed;
  top: 0;
  left: 0;
  z-index: 1000;
  width: 100vw;
  height: 100vh;
  background: rgba(0, 0, 0, 0.4);
  display: flex;
  justify-content: center;
  align-items: center;
`;

const ModalBox = styled.div`
  width: 300px;
  background: ${({ theme }) => theme.bgColor};
  color: ${({ theme }) => theme.textColor};
  border-radius: 10px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.3);
  padding: 24px;
  text-align: center;
`;

const ModalButtons = styled.div`
  display: flex;
  justify-content: space-around;
  margin-top: 16px;
`;

const Button = styled.button`
  padding: 8px 16px;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  background: ${({ theme }) => theme.textColor};
  color: ${({ theme }) => theme.bgColor};
`;

const Modal = ({onConfirm, onCancel, message }: ModalProps) => {
    return (
        <ModalOverlay>
            <ModalBox>
                <p>{message}</p>
                <ModalButtons>
                    <Button onClick={onConfirm}>확인</Button>
                    <Button onClick={onCancel}>취소</Button>
                </ModalButtons>
            </ModalBox>
        </ModalOverlay>
    );
};

export default Modal;
