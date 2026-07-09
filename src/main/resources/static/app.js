const URL = "http://localhost:8080/api/banks";
document.addEventListener("DOMContentLoaded", () => {
    loadData();
});
// Add Bank
document.getElementById("bankForm")
.addEventListener("submit", async (e)=>{
    e.preventDefault();
    const bankName = document.getElementById("bankName").value;
    const ifscCode = document.getElementById("ifscCode").value;
    await fetch(URL,{
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify({bankName,ifscCode
        })
    });
    alert("Bank Saved!");
    document.getElementById("bankForm").reset();
    loadData();
});
// Add Account
document.getElementById("accountForm")
.addEventListener("submit", async(e)=>{
    e.preventDefault();
    const bankId = document.getElementById("bankSelect").value;
    const accountHolderName = document.getElementById("holderName").value;
    const balance = document.getElementById("balance").value;
    await fetch(`${URL}/${bankId}/accounts`,{
        method:"POST",
        headers:{ "Content-Type":"application/json" },
        body:JSON.stringify({accountHolderName,balance})
    });
    alert("Account Saved!");
    document.getElementById("accountForm").reset();
    loadData();
});
// Load Bank Data
async function loadData(){
    const response = await fetch(URL);
    const data = await response.json();
    const select = document.getElementById("bankSelect");
    const display = document.getElementById("Display");
    select.innerHTML = `<option value="">Select Bank</option>`;
    display.innerHTML="";
    data.forEach(bank=>{
        select.innerHTML += `<option value="${bank.id}">${bank.bankName}</option>`;
        let html = ` <div class="bank-box"><h3> ${bank.bankName}</h3><p> IFSC : ${bank.ifscCode}</p> `;
        if(bank.accounts && bank.accounts.length>0)
		{
            bank.accounts.forEach(account=>{
                html += `<div> Account Holder : ${account.accountHolderName}<br> Balance :  ₹${account.balance} </div> <hr> `;
            });
        }
        else
		{
            html += "<p>No Accounts</p>";
        }
        html += "</div>";
        display.innerHTML += html;
    });
}