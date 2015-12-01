<#import "spring.ftl" as spring />

<#macro page>
<html>
<head>
    <title>Super NAT</title>
    <link rel="stylesheet" href="vendors/bootstrap/bootstrap.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/">Login</a></li>
                    <li><a href="/logout">Logout</a></li>
                    <li><a href="/home">Home</a></li>
                    <li><a href="/games">Games</a></li>
                    <li><a href="/vote">Vote</a></li>
                    <li><a href="/admin">Admin</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="well">
        <h2>Data model: </h2>
        <#list .data_model?keys as key>
        ${key}
        </#list>
    </div>

    <!-- View -->
    <#nested>

    <!-- BEGIN SCRIPTS -->
    <script src="vendors/jquery/dist/jquery.js"></script>
    <script src="vendors/bootstrap/bootstrap.js"></script>
    <script src="js/app.js"></script>
    <!-- END SCRIPTS -->
</body>
</html>
</#macro>