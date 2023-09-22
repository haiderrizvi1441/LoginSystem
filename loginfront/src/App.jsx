
import { BrowserRouter } from 'react-router-dom';
import './App.css';
import Register from './Pages/Register';
import Pages from './Pages/Pages';

function App() {
  return (
    <BrowserRouter>
      <Pages/>
    </BrowserRouter>
  );
}

export default App;
