import React from 'react';
import ListBooks from "./components/ListBooks";

class App extends React.Component {
  
  render (){
    return (
      <div>
        <div className="container">
          <ListBooks />
        </div>
      </div>
    )
  }
}
export default App;
