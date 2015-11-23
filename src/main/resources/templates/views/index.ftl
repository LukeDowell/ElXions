<#import "spring.ftl" as spring />

<#macro page>
<html>
<head>
    <title>ElXion</title>
    <link rel="stylesheet" href="vendors/bootstrap/bootstrap.css"/>
</head>
<body>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/">Login</a></li>
                    <li><a href="/home">Home</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <#nested>

</body>
</html>
</#macro>