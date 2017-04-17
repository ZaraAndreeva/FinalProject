var text = document.getElementById("text");

var btn = document.getElementById("Laptop");
btn.addEventListener("click", function() {
	$.ajax({
		  url: "showCategory",
		  type: "get", //send it through get method
		  data: { 
		    category: "Laptop"
		  },
		  success: function(response) {
			  var data=JSON.parse(response);
//			  btn.innerHTML=data.category;
			  text.innerHTML=data.category;
		  },
		  error: function(xhr) {
			  
		    //Do Something to handle error
		  }
		});
})


var btn = document.getElementById("Fridge");
btn.addEventListener("click", function() {
	$.ajax({
		  url: "showCategory",
		  type: "get", //send it through get method
		  data: { 
		    category: "Fridge"
		  },
		  success: function(response) {
			  var data=JSON.parse(response);
//			  btn.innerHTML=data.category;
			  text.innerHTML=data.category;
		  },
		  error: function(xhr) {
		    //Do Something to handle error
		  }
		});
})