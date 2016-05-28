<%@ tag %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<hr>
<!-- Footer -->
<footer>
    <div class="container site">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
                <ul class="list-inline text-center">
                    <li>
                        <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                                </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                                </span>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                                <span class="fa-stack fa-lg">
                                    <i class="fa fa-circle fa-stack-2x"></i>
                                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                                </span>
                        </a>
                    </li>
                </ul>
                <p class="copyright text-muted">Copyright &copy; Your Website 2014</p>
            </div>
        </div>
    </div>
</footer>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="<spring:url value='/static/js/clean-blog.min.js' />"></script>
<!--  TinyMCE -->
<script src='//cdn.tinymce.com/4/tinymce.min.js'></script>
<!-- Data table plugin -->
<script src="//cdn.datatables.net/1.10.11/js/jquery.dataTables.js"></script>
<!--  Own script -->
<script src='<spring:url value='/static/js/script.js' />'></script>


</body>

</html>