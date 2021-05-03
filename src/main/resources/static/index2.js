//With Axios

let ajaxRequest = null; 


function searchActor() {

    let baseurl = "../searchfast/actors/";
    let searchQuery =  document.getElementById('searchActor').value;

    if (searchQuery!="") {

        // cancel  previous ajax if exists
        if (ajaxRequest) {
            ajaxRequest.cancel(); 
        }
        // creates a new token for upcomming ajax (overwrite the previous one)
        ajaxRequest = axios.CancelToken.source();  

        return axios.get(baseurl + searchQuery, { cancelToken: ajaxRequest.token }).then((response) => {
            
            let displayData =  "Zoekresultaten voor: \'"+ searchQuery +"\' zijn o.a.: "
            + (response.data.results.length > 0 ? response.data.results[0].name + ", ": "geen resultaten hiervoor..")
            + (response.data.results.length > 1 ? response.data.results[1].name + ", " : "")
            + (response.data.results.length > 2 ? response.data.results[2].name + "." : "");

            document.getElementById('resultsActor').innerHTML="";
            document.getElementById('resultsActor').innerHTML += displayData;

        }).catch(function(err) {
            if (axios.isCancel(err)) {
            //    console.log('Previous request canceled, new request is send', err.message);
            } else {
                //   console.log(error);
            }
        });

    }
    else{
      document.getElementById('resultsActor').innerHTML="";
    }
}




let ajaxRequest2 = null; 

function searchMovie() {

    let baseurl = "../search/movie/";
    let searchQuery =  document.getElementById('searchMovie').value;

    if (searchQuery!="") {

        // cancel  previous ajax if exists
        if (ajaxRequest2) {
            ajaxRequest2.cancel(); 
        }
        // creates a new token for upcomming ajax (overwrite the previous one)
        ajaxRequest2 = axios.CancelToken.source();  

        return axios.get(baseurl + searchQuery, { cancelToken: ajaxRequest2.token }).then((response) => {

            let displayData =  "Zoekresultaten voor: \'"+ searchQuery +"\' zijn o.a.: "
            + (response.data.results.length > 0 ? response.data.results[0].title + ", ": "geen resultaten hiervoor..")
            + (response.data.results.length > 1 ? response.data.results[1].title + ", " : "")
            + (response.data.results.length > 2 ? response.data.results[2].title + "." : "");

            document.getElementById('resultsMovie').innerHTML="";
            document.getElementById('resultsMovie').innerHTML += displayData;

        }).catch(function(err) {
            if (axios.isCancel(err)) {
            //    console.log('Previous request canceled, new request is send', err.message);
            } else {
                //   console.log(error);
            }
        });
    }
    else{
      document.getElementById('resultsMovie').innerHTML="";
    }
}