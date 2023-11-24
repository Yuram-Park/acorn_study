import React from 'react';
import Stopwatch from './Stopwatch';
import {reset} from './styles/reset';
import {Global} from '@emotion/react';
import styled from '@emotion/styled';

function App() {
  return (
    <Container>
      <Global styles={reset}/>
      <Stopwatch/>
    </Container>
  );
}

const Container = styled.div`
  position: absolute;
  left: 50%;
  top: 50%;
  translate: translate(-50%, -50%);
`;

export default App;
