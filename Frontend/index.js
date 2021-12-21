const cprForm = document.getElementById("cprForm");
cprForm.addEventListener("submit", (e) => {
    e.preventDefault()
    sessionStorage.setItem("cpr", cprForm.cpr.value)
    window.location.href = "/pages/selection"
})