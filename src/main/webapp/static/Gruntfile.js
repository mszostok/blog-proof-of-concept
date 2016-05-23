module.exports = function(grunt) {

    grunt.initConfig({
        less: {
            dev: {
                files: {
                    'css/style.css' : 'less/style.less'
                },
                options: {
                    sourceMap: true,
                    sourceMapFileInline: true
                }
            }
        },

        watch: {
            styles: {
                files: ['less/**/*.less'],
                tasks: ['less:dev']
            }
        },

        browserSync: {
            dev: {
                options: {
                    online: false,
                    watchTask: true,
                    proxy: "localhost:8080/"
                },
                bsFiles: {
                    src: "css/*.css"
                }
            }
        }

    });

    grunt.loadNpmTasks('grunt-contrib-less');
    grunt.loadNpmTasks('grunt-contrib-watch');
    grunt.loadNpmTasks('grunt-browser-sync');


    grunt.registerTask('default', ['less','browserSync', 'watch']);
    grunt.registerTask('no-bs', ['watch']);
};
