
    function setFrequency(frequency) {
      console.log(frequency); // for debugging
      // Additional logic for frequency can be added here
    }

    function setAmount(amount) {
      document.getElementById('customAmount').value = amount;
      checkAmount();
    }

    function checkAmount() {
      const amount = document.getElementById('customAmount').value;
      const paymentOptions = document.querySelector('.payment-options');
      if (amount > 0) {
        paymentOptions.style.display = 'block';
      } else {
        paymentOptions.style.display = 'none';
      }
    }

    document.getElementById('paymentMethod').addEventListener('change', function () {
      const selectedMethod = this.value;
      const paymentDetails = document.querySelectorAll('.payment-details');
      paymentDetails.forEach(detail => detail.style.display = 'none');
      if (selectedMethod === 'credit-card') {
        document.getElementById('creditCardInfo').style.display = 'block';
      } else if (selectedMethod === 'qr-code') {
        document.getElementById('qrCodeInfo').style.display = 'block';
      } else if (selectedMethod === 'other') {
        document.getElementById('otherPaymentInfo').style.display = 'block';
      }
      if (selectedMethod === 'qr-code') {
        document.getElementById('qrCodeInfo').style.display = 'block';
      } else if (selectedMethod === 'credit-card') {
        document.getElementById('creditCardInfo').style.display = 'block';
      } else if (selectedMethod === 'other') {
        document.getElementById('otherPaymentInfo').style.display = 'block';
      }
      if (selectedMethod === 'other') {
        document.getElementById('otherPaymentInfo').style.display = 'block';
      } else if (selectedMethod === 'qr-code') {
        document.getElementById('qrCodeInfo').style.display = 'block';
      } else if (selectedMethod === 'credit-card') {
        document.getElementById('creditCardInfo').style.display = 'block';
      }
    });

    document.getElementById('donationForm').addEventListener('submit', function (event) {
      event.preventDefault();
      // Add form submission logic here
      alert('Form submitted!');
      location.reload(); // Refresh the page after submission

    });
