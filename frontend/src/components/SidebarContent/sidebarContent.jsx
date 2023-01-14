import "./sidebarContent.css"

const SidebarContent = ({todo}) => {

    const todoName = todo.name
    const editedTodoName = todoName.charAt(0).toUpperCase() + todoName.slice(1)

    const todoDescription = todo.description
    const editedTodoDescription = todoDescription.charAt(0).toUpperCase() + todoDescription.slice(1)
    const handleClick = () => {
        
    }

    return ( 
        <div className="content" onClick={handleClick}>
            <p>{editedTodoName}</p>
            <p>{editedTodoDescription}</p>
        </div>
     );
}
 
export default SidebarContent;