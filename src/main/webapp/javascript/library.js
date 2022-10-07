console.log("Hello from the library.js file")

const card = document.getElementById("card");
console.log(card)

card.addEventListener("click", flipcard);

function flipcard(){
	card.classList.toggle("flipCard");
}

