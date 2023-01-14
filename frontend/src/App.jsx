import './App.css'
import Sidebar from './components/Sidebar/sidebar'
import Navbar from './components/Navbar/navbar'
import AddContentPanel from './components/AddContentPanel/addContentPanel'

function App() {
  return (
    <div className="App">
      <Navbar></Navbar>
      <div className='align'>
        <Sidebar></Sidebar>
        <AddContentPanel></AddContentPanel>
      </div>

    </div>
  )
}

export default App
