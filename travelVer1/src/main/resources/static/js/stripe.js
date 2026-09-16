const stripe = Stripe('pk_test_51U2nKwRzMsxPi8YlEnLAKwuX1uzRk38VuBsilp4mH3FwNbzHqbPJ1EqpqwpbkeuTsT4CD5jbc7udCYO8PmhGpILr00S8U9hRZh');

const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
    stripe.redirectToCheckout({
        sessionId: sessionId
    });
});