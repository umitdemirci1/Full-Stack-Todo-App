import { useState, useEffect } from "react";
import SidebarContent from "../SidebarContent/sidebarContent";
import "./sidebar.css"

const Sidebar = () => {

    const [error, setError] = useState(null);
    const [isLoaded, setIsLoaded] = useState(false)
    const [todos, setTodos] = useState([])

    const refreshTodos = () => {
        fetch("http://localhost:8080/todos")
            .then(res => res.json())
            .then(
                (result) => {
                    setIsLoaded(true)
                    setTodos(result)
                },
                (error) => {
                    setIsLoaded(true)
                    setError(error)
                }
            )
    }

    useEffect(() => {
        refreshTodos()
    }, [todos])

    if (error) {
        return (
            <div>
                <h1>Error is occured!</h1>
                {console.log(error)}
            </div>
        )
    } else if (!isLoaded) {
        return (
            <div>
                <h1>Loading...</h1>
            </div>
        )
    } else {
        

        return (
            <div>
                <div className="todo-list">
                    {todos.map((todo) => (
                        <SidebarContent todo={todo} key={todo.id}></SidebarContent>
                    ))}

                </div>
            </div>
        );
    }

}

export default Sidebar;