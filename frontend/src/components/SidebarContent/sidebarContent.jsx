import "./sidebarContent.css"

const SidebarContent = ({todo}) => {
    return ( 
        <div className="content">
            <p>{todo.name}</p>
            <p>{todo.description}</p>
        </div>
     );
}
 
export default SidebarContent;