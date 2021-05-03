//With XMLHttp

function searchActor(){
document.getElementById('resultsActor').innerHTML="";
searchQuery = document.getElementById("searchActor").value
let baseurl = "../searchfast/actors/";

let xmlhttp = new XMLHttpRequest();

xmlhttp.open("GET",baseurl + searchQuery,true);
xmlhttp.onreadystatechange = function() {

  if(xmlhttp.readyState ===4 && xmlhttp.status ===200){
    let resultsActor = JSON.parse(xmlhttp.responseText);

    let displayData =  "Zoekresultaten voor: \'"+ searchQuery +"\' zijn o.a.: "
    + resultsActor.results[0].name +", "
    + resultsActor.results[1].name +", "
    + resultsActor.results[2].name +"."
    ;

    document.getElementById('resultsActor').innerHTML="";
    document.getElementById('resultsActor').innerHTML += displayData;
  }
};
xmlhttp.send();
}



function searchMovie(){

document.getElementById('resultsMovie').innerHTML="";
let baseurl = "../search/movie/";
let searchQuery = document.getElementById("searchMovie").value;

let xmlhttp = new XMLHttpRequest();

xmlhttp.open("GET",baseurl + searchQuery,true);
xmlhttp.onreadystatechange = function() {

  if(xmlhttp.readyState ===4 && xmlhttp.status ===200){
    let results = JSON.parse(xmlhttp.responseText);
    
    let displayData =  "Zoekresultaten voor: \'"+ searchQuery +"\' zijn o.a.: "
    + results.results[0].title +", "
    + results.results[1].title +", "
    + results.results[2].title +".";

    document.getElementById('resultsMovie').innerHTML="";
    document.getElementById('resultsMovie').innerHTML += displayData;
  }
};

xmlhttp.send();
}
