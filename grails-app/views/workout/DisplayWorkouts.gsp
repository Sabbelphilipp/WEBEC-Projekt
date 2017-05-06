<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title> Meine Workouts </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <style>
    body, h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif}
    .w3-row-padding img {margin-bottom: 12px}
    /* Set the width of the sidebar to 120px */
    .w3-sidebar {width: 120px;background: #222;}
    /* Add a left margin to the "page content" that matches the width of the sidebar (120px) */
    #main {margin-left: 120px}

    </style>
</head>

<body class="w3-black">

<!-- Icon Bar (Sidebar - hidden on small screens) -->
<nav class="w3-sidebar w3-bar-block w3-small w3-hide-small w3-center">
    <a href="#myWorkouts" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-flash w3-xxlarge"></i>
        <p>My Workouts</p>
    </a>
    <a href="#myStatistics" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-heartbeat w3-xxlarge"></i>
        <!--area-chart, line-chart-->
        <p>My Statistics</p>
    </a>
    <a href="#myTemplates" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-copy w3-xxlarge"></i>
        <p>My Templates</p>
    </a>
</nav>

<!-- Main part -->
<div class="w3-padding-large" id="main">


    <header class="w3-container w3-padding-32 w3-center w3-black" id="header">
        <h1 class="w3-jumbo">My Workouts</h1>
    </header>

    <!---------------------- Section MyWorkouts ----------------------------->
    <div id="myWorkouts">
        <img src="${resource(dir:'images', file:'header7.png')}" style="width:100%">

        <ul class="w3-ul w3-card-4">
            <g:each var="name" in="${allWorkouts}">
                <li class="w3-padding-16">
                    <img src="${resource(dir:'images', file:'squat.jpg')}" class="w3-left w3-round w3-grayscale w3-margin-right" style="width:70px">
                    <span class="w3-large">${name}</span><br>
                    <span>Type: ${name.type}</span><br>
                    <span>Duration: ${name.duration} </span>
                </li>
            </g:each>
        </ul>


    </div>


    <!---------------------- Section MyStatistics ----------------------------->

    <div id="myStatistics">

        <table class="w3-table w3-black">
            <tr>
                <td id="container1"></td>
            </tr>
        </table>


    </div>


    <!---------------------- Section MyTemplates ----------------------------->

    <div id="myTemplates">

        hier kommen meine Templates


    </div>

</div>



<script>
    Highcharts.setOptions({
        colors: ['#9c2e12','#de732d','#d26028']
    });

    Highcharts.chart('container1', {
        title: {
            text: 'Weight Progress'
        },
        yAxis: {
            title: {
                text: 'kg'
            },
            min: 0,
            max: 150
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            series: {
                pointStart: 2000
            }
        },
        series: [{
            type: 'line',
            name: 'Weights',
            data: [65,65,59,61,64,63,70,77,85,88,92,99,58,57]
        }, {
            type: 'line',
            name: 'Date',
            data: [65,65,59,61,64,63,70,77,85,88,92,99,58,57]
        }]
    });
</script>

</body>
</html>