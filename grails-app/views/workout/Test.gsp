<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title> Heighchart </title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://code.highcharts.com/highcharts.js"></script>
    <style>
    body {
        background-color: #fff2e6;
        font-family: Baskerville, "Baskerville Old Face", "Hoefler Text", Garamond, "Times New Roman", serif;

    }
    h1 {
        font-size: 28px;
    }
    h2{
        font-size: 22px;
    }
    .highcharts-background {
        fill: #fff2e6;
    }
    .highcharts-title {
        font-size: 16px;
        font-weight: bold;
        font-family: Baskerville, "Baskerville Old Face", "Hoefler Text", Garamond, "Times New Roman", serif;
    }
    p {
        font-size: 14px;
    }
    p1 {
        font-size: 12px;
    }
    </style>
</head>


<body>
<h1> Playing Around with Graphs </h1>


<table style="width:80%">
    <tr style="height:300px">
        <td id="container1" style="width:50%"></td>
    </tr>
</table>


<!--<p id="container" style="min-width: 400; max-width: 400px; height: 400px; margin: 0 auto"></p>
<p id="container2" style="min-width: 400px; max-width: 400px; height: 400px; margin: 0 auto"></p>
-->

<script>
    Highcharts.setOptions({
        colors: ['#9c2e12','#de732d','#d26028']
    });

    Highcharts.chart('container1', {
        title: {
            text: 'Blabla'
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
            data: ${weights}
        }, {
            type: 'line',
            name: 'Date',
            data: [65,65,59,61,64,63,70,77,85,88,92,99,58,57]
        }]
    });
</script>

</body>

</html>