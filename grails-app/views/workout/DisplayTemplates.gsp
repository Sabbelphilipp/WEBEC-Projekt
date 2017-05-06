<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title> Meine Workouts </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


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
    <a href="displayWorkouts" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-flash w3-xxlarge"></i>
        <p>My Workouts</p>
    </a>
    <a href="displayStatistics" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-heartbeat w3-xxlarge"></i>
        <!--area-chart, line-chart-->
        <p>My Statistics</p>
    </a>
    <a href="displayTemplates" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
        <i class="fa fa-copy w3-xxlarge"></i>
        <p>My Templates</p>
    </a>
</nav>

<!-- Main part -->
<div class="w3-padding-large" id="main">

    <header class="w3-container w3-padding-32 w3-center w3-black" id="header">
        <h1 class="w3-xxxlarge">My Templates</h1>
    </header>

    <!---------------------- Section MyWorkouts ----------------------------->
    <div id="myTemplates">

        ${text}

    </div>


</div>
</body>
</html>