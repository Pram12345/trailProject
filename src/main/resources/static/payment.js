function makePayment() {
	
	
	

            var options = {
                "key": "rzp_test_4phtPKDkNoCytr",
                "amount": "5000", 
                "name": "Synergistic Consultants",
                "description": "Donation",
                "image": "imgs/paylogo.png",
                "handler": function (response) {
                    // Send the payment ID to your backend for processing
                    fetch('/webhook', {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json',
                        },
                        body: JSON.stringify({
                            paymentId: response.razorpay_payment_id,
                            amount: "5000",
                            currency: "INR",
                            description: "Test Transaction"
                        })
                    })
                    .then(response => response.text())
                    .then(data => {
                        alert("Payment ID: " + response.razorpay_payment_id + "\n" + data);
                    })
                    .catch((error) => {
                        console.error('Error:', error);
                    });
                },
                "prefill": {
                    "name": "",
                    "email": "",
                    "contact": ""
                },
                "theme": {
                    "color": "#F37254"
                }
            };
            var rzp1 = new Razorpay(options);
            rzp1.open();
        }