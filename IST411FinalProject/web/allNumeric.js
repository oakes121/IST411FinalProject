function allNumeric(form){   
    var d = form.cardNumber.value;
    var zip = form.ZipCode.value;
    var numbers = /^[0-9]+$/;
    
    if(!d.match(numbers)){
        alert('Please input numeric characters only');
        document.form1.text1.focus();
        return false;
    } 
    
    if(!zip.match(numbers)){
        alert('Please input numeric characters only');
        document.form1.text1.focus();
        return false;
    } 
    
} 