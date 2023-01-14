import { useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import Sidebar from './components/Sidebar/sidebar'
import Navbar from './components/Navbar/navbar'

function App() {
  const [count, setCount] = useState(0)

  return (
    <div className="App">
      <Navbar></Navbar>
      <Sidebar></Sidebar>
    </div>
  )
}

export default App
