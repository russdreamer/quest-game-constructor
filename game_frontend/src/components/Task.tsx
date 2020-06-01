import React from 'react';
import {Navbar, Nav, Form, FormControl, Button} from 'react-bootstrap';

export default function Task() {
    return (
        <Navbar bg="dark" variant="dark">
    <Navbar.Brand href="#home">Navbar</Navbar.Brand>
    <Nav className="mr-auto">
      <Nav.Link href="#home">Home</Nav.Link>
      <Nav.Link href="#features">Features</Nav.Link>
      <Nav.Link href="#pricing">Pricing</Nav.Link>
    </Nav>
    <Form inline>
      <input type="text" 
      id='sds'
      //onChange={changeInput} 
      key="2"
      //value={title}
      />
      <input type="text" 
      id='sdssds'
      //onChange={changeInput} 
      key="1" 
     //value={title}
      />
      <FormControl type="text" placeholder="Search" className="mr-sm-2" />
      <Button variant="outline-info">Search</Button>
    </Form>
  </Navbar>
    )
} 