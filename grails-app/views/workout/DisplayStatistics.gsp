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

    .highcharts-root{
        color: #4cae4c;
        font-size: 40px;
    }

    .highcharts-background {
        fill: #000000;
    }
    .highcharts-title {
        font-size: 16px;
        font-weight: bold;
        font-family: Baskerville, "Baskerville Old Face", "Hoefler Text", Garamond, "Times New Roman", serif;
        color: #ffffff;
    }
    .highcharts-axis{
        color: white;
        font-size: 12px;
        text-decoration: underline;
    }

    </style>
</head>

<body class="w3-black">

<!-- Icon Bar (Sidebar - hidden on small screens) -->
<nav class="w3-sidebar w3-bar-block w3-small w3-hide-small w3-center">
    <a href="displayWorkouts" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-flash w3-xxlarge"></i>
        <p>My Workouts</p>
    </a>
    <a href="displayStatistics" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-heartbeat w3-xxlarge"></i>
        <!--area-chart, line-chart-->
        <p>My Statistics</p>
    </a>
    <!--
    <a href="displayTemplates" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-copy w3-xxlarge"></i>
        <p>My Templates</p>
    </a>-->
</nav>

<!-- Main part -->
<div class="w3-padding-large" id="main">

    <header class="w3-container w3-padding-32 w3-center w3-black" id="header">
        <h1 class="w3-jumbo">My Statistics</h1>
    </header>

    <!---------------------- Section MyStatistics ----------------------------->

    <div class="w3-content" id="myStatistics">
        <div class="w3-cell-row" style="width:100%">
            <div class="w3-container w3-cell">
                <p id="container1"> </p>
            </div>
        </div>
        <div class="w3-cell-row"style="width: 100%">
            <div class="w3-container w3-half w3-cell">
                <p id="container2"> </p>
            </div>
            <div class="w3-container w3-half w3-cell">
                <p id="container3"> </p>
            </div>
        </div>
    </div>
</div>

<script>
    Highcharts.setOptions({
        colors: ['#254b70','#34689c','#4985c2','#75a3d1','#a1c0e0','#cddeee']
        //colors: ['#ff3300','#ff4dd2','#3385ff','#00e64d','#ffff4d','#bf80ff']
    });

    Highcharts.chart('container1', {
        title: {
            text: 'Weight Progress',
            style: {
                color: "#ffffff"
            }
        },
        yAxis: {
            title: {
                text: 'kg'
            },
            min: 0,
            max: 150
        },
        legend: {
            enabled: true,
            backgroundColor: '#ffffff'
        },
        plotOptions: {
            series: {
                pointStart: 1
            }
        },
        series: [{
                type: 'line',
                name: 'Squat',
                data: ${squatWeights}
            },{
                type: 'line',
                name: 'Bizeps',
                data: ${bizepCurlsWeights}
            },{
                type: 'line',
                name: 'Benchpress',
                data: ${benchpressWeights}
        }]
    });

    Highcharts.chart('container2', {
        chart: {
        },
        title: {
            text: 'Übungstyp<br>Verteilung',
            align: 'center',
            style: {
                color: "#ffffff"
            },
            verticalAlign: 'middle',
            y: 40
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                dataLabels: {
                    enabled: true,
                    distance: -50,
                    style: {
                        fontWeight: 'bold',
                        color: 'white'
                    }
                },
                startAngle: -90,
                endAngle: 90,
                center: ['50%', '75%']
            }
        },
        series: [{
            type: 'pie',
            name: 'Type Share',
            innerSize: '50%',
            data: [
                ['Bizeps',   3],
                ['Squat', 6],
                ['Snatch', 2],
                ['Benchpress', 5],
                ['Clean', 4],
            ]
        }]
    });

    Highcharts.chart('container3', {
        chart: {
        },
        title: {
            text: 'Übungs-<br>verteilung',
            align: 'center',
            style: {
                color: "#ffffff"
            },
            verticalAlign: 'middle',
            y: 40
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                dataLabels: {
                    enabled: true,
                    distance: -50,
                    style: {
                        fontWeight: 'bold',
                        color: 'white'
                    }
                },
                startAngle: -90,
                endAngle: 90,
                center: ['50%', '75%']
            }
        },
        series: [{
            type: 'pie',
            name: 'Type Share',
            innerSize: '50%',
            data: [
                ['Strength',   ${nrOfStrength}],
                ['Explosiveness', ${nrOfExplosive}],
                ['Endurance', ${nrOfEndurance}],
            ]
        }]
    });
</script>

</body>
</html>