import * as React from 'react';
import styled from '@emotion/styled';
import {css} from '@emotion/react';

type ButtonType = "NORMAL" | "SUCCESS" | "ERROR";

interface IProps {
    type: ButtonType;
    onClick: () => void;
    children: React.ReactNode;
}

const Button:React.FC<IProps> = ({type, onClick, children}) => {
    return <Container onClick={onClick} type={type}>{children}</Container>
}

type styleProps = Omit<IProps, "onClick" | "children">
const getStyledByType = (props:styleProps) => {
    let color = "white";
    let background = "#333333";

    switch(props.type){
        case "NORMAL":
            color = "white";
            background = "#333333"
            break;
        case "SUCCESS":
            color = "gray";
            background = "#00f"
            break;
        case "ERROR":
            color = "blue";
            background = "#f00"
            break;
    }

    return css`
        color: ${color};
        background-color: ${background};
    `;
}

const Container = styled.div<styleProps>`
    width: 100px;
    height: 100px;
    border-radius: 50px;
    ${getStyledByType}

    display: flex;
    justify-content: center;
    align-items: center;
`;

export default Button;
