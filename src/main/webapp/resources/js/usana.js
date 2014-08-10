$(function() {

    $(".update").click(function() {
        var id = $(this).data("id");
        var firstName = $("#first"+id).val();
        var lastName  = $("#last"+id).val();
        var address1  = $("#addOne"+id).val();
        var address2  = $("#addTwo"+id).val();
        var city      = $("#city"+id).val();
        var state     = $("#state"+id).val();
        var zip       = $("#zip"+id).val();
        var phone     = $("#phone"+id).val();

        if (!firstName) { alert("The first name is important."); return; }
        if (!lastName)  { alert("Dude, you left the last name blank."); return; }
        if (!address1)  { alert("Why is the address empty?"); return; }
        if (!city)      { alert("What city is this person in?"); return; }
        if (!state)     { alert("Need the state."); return; }
        if (!zip)       { alert("Your Zip is \"down.\""); return; }
        if (!phone)     { alert("How do you plan to call this person without a phone number?"); return; }

        $.ajax({
            data: {
                "firstName": firstName,
                "lastName":  lastName,
                "address1":  address1,
                "address2":  address2,
                "city":      city,
                "state":     state,
                "zip":       zip,
                "phone":     phone,
                "id":        id
            },
            type:"PUT"
        }).done(function(){alert("Successful Update!")});
    });

});