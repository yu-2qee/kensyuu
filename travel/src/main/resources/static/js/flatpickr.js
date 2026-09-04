let maxDate=newDate();
maxDate=maxDate.setMonth(maxDate.getMonth()+3);
flatpicker('#fromCheckinDateToCheckoutDate', {

mode: "range",

locale: 'ja',

minDate: 'today',

maxDate: maxDate

});