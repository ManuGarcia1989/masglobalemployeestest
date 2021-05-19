let submitButton = document.querySelector("#submit");
let loading = document.querySelector("#loader");
loading.style.display = "none";
submitButton.addEventListener('click',()=>{
   loading.style.display = "";
});