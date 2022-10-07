console.log("hello, i am from the search.js file");

// get search bar element
const searchInput = document.getElementById("searchBar");

// store name elements in array-like object
const booksFromDOM = document.getElementsByClassName("book");

// listen for user events
searchInput.addEventListener("keyup", (event) => {
    const { value } = event.target;
    
    // get user search input converted to lowercase
    const searchQuery = value.toLowerCase();
    
    for (const nameElement of booksFromDOM) {
        // store name text and convert to lowercase
        let name = nameElement.textContent.toLowerCase();
        console.log (name)
        // compare current name to search input
        if (name.includes(searchQuery)) {
            // found name matching search, display it
            nameElement.style.display = "block";
        } else {
            // no match, don't display name
            nameElement.style.display = "none";
        }
    }
});