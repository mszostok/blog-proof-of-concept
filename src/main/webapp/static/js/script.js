
$(document).ready(function () {
    tinymce.init({
        selector: '#post-edit-area',
        plugins : 'advlist autolink link image lists charmap print preview',
        a_plugin_option: true,
        a_configuration_option: 400
    });

})