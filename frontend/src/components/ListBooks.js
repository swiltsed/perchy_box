import React, {useEffect, useState } from "react";

const ListBooks = () => {
    
    const [books, setBooks] = useState([]);
    
    const handleChange = (e) => {
        let bookid = e.target.getAttribute("bookid")
        let copy = [...books]
        let targetBook = {}
        for (var i = 0; i < books.length; i++){
            if(books[i].id == bookid){
                targetBook = [books[i], i]
                break;
            }
        }
        targetBook[0].checked = !targetBook[0].checked;
        copy[targetBook[1]] = targetBook[0];
        setBooks(copy);
    }

    const getBooks = async () => {
        try {

            const responst = await fetch("http://localhost:8080/books");
            const jsonData = await responst.json();

            const displayData = jsonData.map((book)=>{
                book.checked = false;
                return book;
            })
            setBooks(displayData);
            
        } catch (err) {
            console.error(err.message);
        }
    }

    useEffect(() => {
        getBooks();
    }, []);

    console.log(books);
    if(!books) return <div>No books</div>
    return (
        <div>
            <table className="table mt-5 text-center">
                <thead>
                <tr>
                    <th></th>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Publication Date</th>
                </tr>
                </thead>
                <tbody>
                    {books.map((book) => {
                        return (<tr key={book.id}>
                        <td>
                            <input 
                                type="checkbox"
                                checked={book.checked}
                                onChange={handleChange}
                                bookid={book.id}
                            >
                            </input>
                        </td>
                        <td>{book.title}</td>
                        <td>{book.author}</td>
                        <td>{book.date}</td>
                        
                    </tr>)
                    } 
                        
                    )}
                </tbody>
            </table>
        </div>
    )
}

export default ListBooks; 