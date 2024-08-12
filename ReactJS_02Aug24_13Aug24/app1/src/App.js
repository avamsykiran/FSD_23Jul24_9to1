import { Fragment } from 'react';
import Header from "./uis/Header";
import Welcome from "./uis/Welcome";
import Welcome2 from './uis/Welcome2';
import Loan from './uis/Loan';
import Counter from './uis/Counter';
import CounterFC from './uis/CounterFC';

const App = () => (
  <Fragment>
    <Header appTitle="React SPA 1.0" />
    <Welcome />
    <Welcome2 />
    <Loan />
    <Counter />
    <CounterFC />
  </Fragment>
);

export default App;
