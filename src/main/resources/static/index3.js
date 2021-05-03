//With Fetch

let abortController1 = new AbortController();

async function searchActor() {

  let baseurl = "../searchfast/actors/";
  let searchQuery =  document.getElementById('searchActor').value; 

  abortController1.abort(); // Cancel the previous request
  abortController1 = new AbortController();

  if (searchQuery!="") {

    try {
        let response = await fetch(baseurl + searchQuery, { signal: abortController1.signal });
        let data = await response.json();
        // console.log(data);

        let displayData =  "Zoekresultaten voor: \'"+ searchQuery +"\' zijn o.a.: "
        + (data.results.length > 0 ? data.results[0].name + ", ": "geen resultaten hiervoor..")
        + (data.results.length > 1 ? data.results[1].name + ", " : "")
        + (data.results.length > 2 ? data.results[2].name + ". " : "");
        
        document.getElementById('resultsActor').innerHTML="";
        document.getElementById('resultsActor').innerHTML += displayData;       
    }
    catch (ex) {
        if (ex.name === 'AbortError') {
        return;
        }
        throw ex;
    }

  } else{
      document.getElementById('resultsActor').innerHTML="";
    }

}


let abortController2 = new AbortController();

async function searchMovie() {

  let baseurl = "../search/movie/";
  let searchQuery =  document.getElementById('searchMovie').value; 

  abortController2.abort(); // Cancel the previous request
  abortController2 = new AbortController();

  if (searchQuery!="") {

    try {
        let response = await fetch(baseurl + searchQuery, { signal: abortController2.signal });
        let data = await response.json();
        // console.log(data);

        let displayData =  "Zoekresultaten voor: \'"+ searchQuery +"\' zijn o.a.: "
        + (data.results.length > 0 ? data.results[0].title + ", ": "geen resultaten hiervoor..")
        + (data.results.length > 1 ? data.results[1].title + ", " : "")
        + (data.results.length > 2 ? data.results[2].title + ". " : "");
        
        document.getElementById('resultsMovie').innerHTML="";
        document.getElementById('resultsMovie').innerHTML += displayData;     
    }
    catch (ex) {
        if (ex.name === 'AbortError') {
        return;
        }
        throw ex;
    }

  } else{
      document.getElementById('resultsMovie').innerHTML="";
    }

}