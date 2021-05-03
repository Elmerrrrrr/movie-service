// getting all required elements
const searchWrapper = document.querySelector(".search-input");
const inputBox = searchWrapper.querySelector("input");
const suggBox = searchWrapper.querySelector(".autocom-box");
const icon = searchWrapper.querySelector(".icon");
let linkTag = searchWrapper.querySelector("a");
let webLink;
let emptyArray = [];

// if user press any key and release
inputBox.onkeyup = (e)=>{
    let userData = e.target.value; //user enetered data
    emptyArray = [];
    if(userData){
        icon.onclick = ()=>{
            webLink = "" + userData;
            linkTag.setAttribute("href", webLink);
//            console.log(webLink);
            linkTag.click();
        }
        emptyArray = searchActor().filter((data)=>{
//            console.log(data.name);
            //filtering array value and user characters to lowercase and return only those words which are start with user enetered chars
            return data.name.toLocaleLowerCase().startsWith(userData.toLocaleLowerCase()); 
        });
        emptyArray = emptyArray.map((data)=>{
           
            // passing return data inside li tag
            return data = '<li>'+ data.name +'</li>';
        });
        searchWrapper.classList.add("active"); //show autocomplete box
        showSuggestions(emptyArray);
        let allList = suggBox.querySelectorAll("li");
        for (let i = 0; i < allList.length; i++) {
            //adding onclick attribute in all li tag
            // console.log(allList[i]);
           
            allList[i].setAttribute("onclick", "select(this)");
        }
    }else{
        searchWrapper.classList.remove("active"); //hide autocomplete box
    }
}

function select(element){
    let selectData = element.textContent;
    inputBox.value = selectData;
    
    let actorId = resultsFetch.map((data)=>{
         if(data.name === selectData){
             console.log(data.id);
             return data.id
         }  
    });
   
    icon.onclick = ()=>{
        webLink = "../movies/actor/" + actorId;
        console.log(webLink);
        let newWebLink = webLink.replace(/,/g,'');
        console.log(newWebLink);
        linkTag.setAttribute("href", newWebLink);
        linkTag.click();
    }
    searchWrapper.classList.remove("active");
}


function showSuggestions(list){
    let listData;
    if(!list.length){
        userValue = inputBox.value;
        listData = '<li>'+ userValue +'</li>';
    }else{
        listData = list.join('');
    }
    suggBox.innerHTML = listData;
}



let resultsFetch;

function searchActor(){
 
//    console.log(resultsFetch);

    let baseurl = "../search/actors/sug/";
    let inputBox = document.querySelector("input").value;

    let xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET",baseurl + inputBox,true);
    
    xmlhttp.onreadystatechange = function() {
    
      if(xmlhttp.readyState ===4 && xmlhttp.status ===200){
        resultsFetch = JSON.parse(xmlhttp.responseText);
//        console.log(resultsFetch);
      }
    };
    xmlhttp.send();

    return resultsFetch;
    }