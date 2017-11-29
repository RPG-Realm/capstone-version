var fsClient = filestack.init('AEI1UqHQ4QfmBMMZ6KMFmz');

function openPicker() {
    fsClient.pick({
        fromSources: ["local_file_system", "url", "imagesearch", "googledrive"],
        accept: ["image/*", ".pdf", "text/plain"],
        transformations: {
            crop: {
                force: true,
                aspectRatio: 1
            }
        },
        maxSize: 2000000
    }).then(function (response) {
        console.log(response);
        console.log(response.filesUploaded[0].url);




    });
}

document.getElementById("upload").addEventListener("click", function(){
    openPicker();
});
