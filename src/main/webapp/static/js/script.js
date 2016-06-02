$(document).ready(function () {

    /**
     * TinyMCE init
     */
    tinyMCE.init({
        selector: '#post-edit-area',
        relative_urls: true,
        remove_script_host: false,
        convert_urls: false,
        fix_list_elements: false,
        plugins: 'advlist autolink link image lists charmap save print preview',
        a_plugin_option: true,
        a_configuration_option: 400,
        height : "480"
    });


    /**
     * Init Data table jquery plugin
     */
    var dataTable = $('#data-table').DataTable({
        language: {
            "decimal": "",
            "emptyTable": "No data available in table",
            "info": "Showing _START_ to _END_ of _TOTAL_ entries",
            "infoEmpty": "Showing 0 to 0 of 0 entries",
            "infoFiltered": "(filtered from _MAX_ total entries)",
            "infoPostFix": "",
            "thousands": ",",
            "lengthMenu": "Show _MENU_ entries",
            "loadingRecords": "Loading...",
            "processing": "Processing...",
            "search": "Search:",
            "zeroRecords": "No matching records found",
            "paginate": {
                "first": "First",
                "last": "Last",
                "next": "Next",
                "previous": "Previous"
            },
            "aria": {
                "sortAscending": ": activate to sort column ascending",
                "sortDescending": ": activate to sort column descending"
            }
        }
    });


    $('[data-toggle="tooltip"]').tooltip();

    /**
     * Init tags input plugin
     */
    $('#tags').tagsInput({
        'interactive': true,
        'defaultText': 'Your tags..',
        'delimiter': [','],
        'removeWithBackspace': true,
        'placeholderColor': '#fff'
    });

    /**
     * Upload the file sending it via Ajax at the Spring Boot server.
     */
    $("#upload-file-input").on("change", uploadFile);
})

/**
 * Upload the file sending it via Ajax.
 */
function uploadFile() {
    $.ajax({
        url: "/upload",
        type: "POST",
        data: new FormData($("#upload-file-form")[0]),
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        cache: false,
        success: function (response) {
            // Handle upload success
            $("#upload-file-message").text(response.message);

            // Add img url to content
            tinyMCE.triggerSave();
            var content = $("#post-edit-area").val();
            content = content + response.imgUrl;

            // Update content
            tinyMCE.activeEditor.setContent(content);

        },
        error: function (xhr, status, error) {
            // Handle upload error
            var message ="File upload failed.";
            if(xhr.responseText !== undefined) {
                var responseText = jQuery.parseJSON(xhr.responseText);
                 message = responseText.ex;
            }

            $("#upload-file-message").text(message);
        }
    });
}