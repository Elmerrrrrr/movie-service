

function multiSearch(){

document.getElementById('results').innerHTML="";
let baseurl = "http://localhost:2021/search/";
let searchQuery = document.getElementById("searchMulti").value;



let xmlhttp = new XMLHttpRequest();
xmlhttp.open("GET",baseurl + searchQuery,true);

xmlhttp.onreadystatechange = function() {

  if(xmlhttp.readyState ===4 && xmlhttp.status ===200){
    let results = JSON.parse(xmlhttp.responseText);
    console.log(results);

    let tbltop = "";

    let main =  "Zoekresultaten voor: \'"+ searchQuery +"\' zijn o.a.: "+ results.results[0].title +".";

    let tblbottom = "";
    let tbl = tbltop + main + tblbottom;

    setTimeout(function(){
          document.getElementById('results').innerHTML="";
          document.getElementById('results').innerHTML += tbl;
    }, 10); 

    
    

  }
};
xmlhttp.send();
}

