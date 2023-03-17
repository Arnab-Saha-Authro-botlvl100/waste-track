'use strict';

// element toggle function
const elemToggleFunc = function (elem) { elem.classList.toggle("active"); }



// navbar variables
const navbar = document.querySelector("[data-navbar]");
const navbarOpenBtn = document.querySelector("[data-nav-open-btn]");
const navbarCloseBtn = document.querySelector("[data-nav-close-btn]");

navbarOpenBtn.addEventListener("click", function () {
  elemToggleFunc(navbar);
});

navbarCloseBtn.addEventListener("click", function () {
  elemToggleFunc(navbar);
});



// go top variable
const goTopBtn = document.querySelector("[data-go-top]");

// window scroll event for go top button
window.addEventListener("scroll", function () {

  if (this.window.scrollY >= 500) {
    goTopBtn.classList.add("active");
  } else {
    goTopBtn.classList.remove("active");
  }

});


function getLocation() {
  if (navigator.geolocation) {
    navigator.geolocation.watchPosition(showPosition);
  } else {
    document.getElementById("latitude").value = "Geolocation is not supported by this browser.";
  }
}
function showPosition(position) {
  document.getElementById("latitude").value = position.coords.latitude ;
  document.getElementById("longitude").value = position.coords.longitude;
}
getLocation();