import './App.css';
import {BrowserRouter as Router,Route,Switch} from 'react-router-dom'
import Header from './component/Header';
import Footer from './component/Footer';
import ListEmployees from './component/ListEmployee';
import CreateEmployee from './component/CreateEmployee';
// import UpdateEmployee from './component/UpdateEmployee';

function App() {
  return ( 
    <div>
      <Router>
              <Header />
                <div className="container">
                    <Switch>
                      <Route path="/" exact component={ListEmployees}></Route>
                      <Route path="/employees" component ={ListEmployees}></Route>
                      <Route path="/add-employee/:id" component ={CreateEmployee}></Route>
                      <Route path="/add-employee/:id" component ={CreateEmployee}></Route>

                      {/* <Route path="/update-employee/:id" component ={UpdateEmployee}></Route> */}
                    </Switch>
                </div>
              <Footer />
      </Router>
      </div>
  );
}

export default App;
