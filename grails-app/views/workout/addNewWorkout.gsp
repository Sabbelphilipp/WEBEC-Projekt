<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title> Meine Workouts </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

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
        <h1 class="w3-xxLarge">Add new Workout</h1>
    </header>

    <!---------------------- Section AddNewWorkout ----------------------------->

    <div class="w3-content w3-padding" id="addNewWorkout">

        <p><label>Date (dd.mm.yyyy)</label>
            <input class="w3-input w3-border" type="date" name="date" id ="datepicker">


        <p><label>Type:</label>
            <input class="w3-input w3-border" name="type" type="text" id="type"></p>


        <p><label>Duration:</label>
            <input class="w3-input w3-border" name="duration" type="text" id="duration"></p>




        <ul class="w3-ul w3-card-4 w3-content" id="exerciseList">

            <li class="w3-padding-16 w3-container w3-row" id="firstLi">

                <div class="w3-col w3-padding-small" style="width:50%">
                    <p>
                    <label>Exercise</label>
                    <select class="w3-select" name="Exercises" id="selectBox">
                        <option value="" disabled selected>Choose your Exercise</option>
                        <g:each var="exercise" in="${allExercises}">
                            <option value=${exercise}>${exercise}</option>
                        </g:each>
                    </select>
                    </p>
                </div>
                <div class="w3-col w3-padding-small" style="width:20%"><p>
                    <label>Weight</label>
                    <input class="w3-input w3-border" type="text"></p>
                </div>
                <div class="w3-col w3-padding-small" style="width:20%"><p>
                    <label>Repetitions</label>
                    <input class="w3-input w3-border" type="text"></p>
                </div>
                <div class="w3-col w3-padding-small" style="width:10%">
                    <p>
                    <label style="visibility:hidden"> test  </label>
                    <button onclick="this.parentElement.parentElement.parentElement.style.display='none'" class="w3-col w3-button w3-white ">x</button></p>
                </div>
            </li>

        </ul>


            <p></p>

            <div>
                <!-- TODO Save Workout -->
                <a class="w3-bar-item w3-button w3-white w3-padding-large w3-hover-black" onclick="saveItem()"> Save Workout</a>
                <a class="w3-bar-item w3-button w3-white w3-padding-large w3-hover-black" onclick="addItem()"> Add Exercise</a>
                <a href="testLink?test=blabla" class="w3-bar-item w3-button w3-white w3-padding-large w3-hover-black"> Load Template</a>
                <a href="addExercise" class="w3-bar-item w3-button w3-white w3-padding-large w3-hover-black"> TestButton</a>

            </div>

            <p></p>
    </div>
</div>

<script>

    function addItem(){
        var li = document.createElement("LI");
        var li2 = document.getElementById("firstLi")
        li.className = "w3-padding-16 w3-container w3-row"
        li.innerHTML = li2.innerHTML
        document.getElementById("exerciseList").appendChild(li);
    }

    function saveItem(){
        //Create new Workout
        var date = document.getElementById('datepicker').value
        var duration = document.getElementById("duration").value
        var type = document.getElementById("type").value
        var myLink = new String("saveWorkout?date=" + date + "&duration=" + duration +"&type=" + type)
        window.location.href = myLink

        //Add Exercises to Workout
        var ul = document.getElementById("exerciseList");
        var items = ul.getElementsByTagName("li");
        for (var i = 0; i < items.length; ++i) {
            //Todo: Add exercise für jede übung in LI
            //li.box.value = name, li.box.weight = weight usw.
        }


    }

    $(document).ready(function() {
        $("#datepicker").datepicker({
            dateFormat: 'dd-mm-yy'
        });
    });
</script>

</body>
</html>