function calculateDiscount() {

    let productName = document.getElementById("productName").value;
    let price = parseFloat(document.getElementById("price").value);
    let discount = parseFloat(document.getElementById("discount").value);

    if (isNaN(price) || isNaN(discount) || productName === "") {
        alert("Please enter valid details!");
        return;
    }

    let finalPrice = price - (price * discount / 100);

    document.getElementById("result").innerHTML =
        `Final Price of ${productName} = ₹${finalPrice.toFixed(2)}`;
}

function clearFields() {

    document.getElementById("productName").value = "";
    document.getElementById("price").value = "";
    document.getElementById("discount").value = "";

    document.getElementById("result").innerHTML =
        "Final Price: ₹0";
}