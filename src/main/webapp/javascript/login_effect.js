function checkPasswordMatch() {
        var password = $("#txtNewPassword").val();
        var confirmPassword = $("#txtConfirmPassword").val();
        if (password != confirmPassword)
            $("#CheckPasswordMatch").html("<small>Passwords does not match!</small>");
        else
            $("#CheckPasswordMatch").html("<small>Passwords match!</small>");
    }
    $(document).ready(function () {
       $("#txtConfirmPassword").keyup(checkPasswordMatch);
    });
    
function showPwd() {
  var x = document.getElementById("password");
  var y = document.getElementById("txtNewPassword");
  var z = document.getElementById("txtConfirmPassword");
  if (x.type === "password" || y.type === "password" || z.type === "password") {
    x.type = "text";
    y.type = "text";
    z.type = "text";
  } else {
    x.type = "password";
    y.type = "password";
    z.type = "password";
  }
}


