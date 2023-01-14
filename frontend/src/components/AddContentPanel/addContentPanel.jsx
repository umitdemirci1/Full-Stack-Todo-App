import { GrAdd } from "react-icons/gr"
import { useEffect, useState } from "react"
import "./addContentPanel.css"
import TodoItemDetails from "../TodoItemDetails/todoItemDetails"

const addContentPanel = () => {
    const [todoItems, setTodoItems] = useState([])
    const [error, setError] = useState()
    const [isLoaded, setIsLoaded] = useState(false)
    const refreshContent = () => {
        fetch("http://localhost:8080/todoItems")
            .then(res => res.json())
            .then(
                (result) => {
                    setIsLoaded(true)
                    setTodoItems(result)
                    console.log(result)
                },
                (error) => {
                    setIsLoaded(true)
                    setError(error)
                }
            )
    }

    useEffect(() => {
        refreshContent()
    }, [])

    return (
        <div className="contentBody">
            <div className="addButton">
                <div className="cover">
                    <button><GrAdd /></button>
                </div>
            </div>
            <TodoItemDetails></TodoItemDetails>
        </div>
    );
}

export default addContentPanel;