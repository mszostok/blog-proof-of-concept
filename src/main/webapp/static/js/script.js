$(document).ready(function () {

    //TinyMCE init
    tinymce.init({
        selector: '#post-edit-area',
        plugins: 'advlist autolink link image lists charmap print preview',
        a_plugin_option: true,
        a_configuration_option: 400
    });


    // dataTable init
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

})