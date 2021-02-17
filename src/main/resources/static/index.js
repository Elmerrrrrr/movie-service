
function searchActor(){

document.getElementById('resultsActor').innerHTML="";
let baseurl = "http://localhost:2021/search/actors/";
let searchQuery = document.getElementById("searchActor").value;



let xmlhttp = new XMLHttpRequest();
xmlhttp.open("GET",baseurl + searchQuery,true);

xmlhttp.onreadystatechange = function() {

  if(xmlhttp.readyState ===4 && xmlhttp.status ===200){
    let results = JSON.parse(xmlhttp.responseText);
    console.log(results);

    let tbltop = "";

    let main =  "Zoekresultaten voor: \'"+ searchQuery +"\' zijn o.a.: "
    + results[0].name +", "
    + results[1].name +", "
    + results[2].name +"."
    ;

    let tblbottom = "";
    let tbl = tbltop + main + tblbottom;


          document.getElementById('resultsActor').innerHTML="";
          document.getElementById('resultsActor').innerHTML += tbl;


    
    

  }
};
xmlhttp.send();
}


function searchMovie(){

document.getElementById('resultsMovie').innerHTML="";
let baseurl = "http://localhost:2021/search/movie/";
let searchQuery = document.getElementById("searchMovie").value;



let xmlhttp = new XMLHttpRequest();
xmlhttp.open("GET",baseurl + searchQuery,true);

xmlhttp.onreadystatechange = function() {

  if(xmlhttp.readyState ===4 && xmlhttp.status ===200){
    let results = JSON.parse(xmlhttp.responseText);
    console.log(results);

    let tbltop = "";

    let main =  "Zoekresultaten voor: \'"+ searchQuery +"\' zijn o.a.: "+ results[0].title +".";

    let tblbottom = "";
    let tbl = tbltop + main + tblbottom;

    setTimeout(function(){
          document.getElementById('resultsMovie').innerHTML="";
          document.getElementById('resultsMovie').innerHTML += tbl;
    }, 1);




  }
};
xmlhttp.send();
}