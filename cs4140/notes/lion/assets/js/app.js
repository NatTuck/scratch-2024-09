

function readImage(ev) {
  ev.preventDefault();
  let field = document.getElementById('upload-field');
  let file = field.files[0];
  console.log(file);

  let rdr = new FileReader();
  rdr.onload = function(ev) {
    //console.log(ev.target.result);
    let dataURL = ev.target.result;

    let img = document.getElementById('img1');
    img.src = dataURL;

    localStorage.setItem('saved-image', dataURL);

    localStorage.setItem('podcast-17/episode-31');
    localStorage.setItem('index');
  }
  rdr.readAsDataURL(file);
}

document.getElementById('show-btn').addEventListener('click', readImage);

let dataURL = localStorage.getItem('saved-image');
if (dataURL) {
  console.log("loaded from localStorage cache");
  let img = document.getElementById('img1');
  img.src = dataURL;
}
