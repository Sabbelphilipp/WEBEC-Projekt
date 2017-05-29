package mvc


class WorkoutController{
    static scaffold = Workout

    def index(){
        redirect(controller: 'workout', action: 'displayWorkouts')
    }

    //Controls the Data for creating a new Input
    def addNewWorkout(){
        def allExercises = Exercise.list()
        render view:"addNewWorkout", model:[allExercises:allExercises]
    }

    //Saving the Input
    def saveWorkout(String date, int duration, String type){
        //Todo: Replace this exercises with the Exercises from the List
        Exercise benchpress = new Exercise(name: "Benchpress", reps: 10, weight: 70).save(failOnError:true)
        Exercise squat = new Exercise(name:"Squat", reps: 10, weight: 120).save(failOnError:true)
        def myDate = date
        new Workout(date: Date.parse("yyyy-MM-dd", myDate), duration: duration, type: type, exerciseList: [benchpress, benchpress, squat]).save(failOnError:true)
        def allWorkouts = Workout.listOrderByDate(max: 10, order: "desc")
        render view:"DisplayWorkouts", model:[allWorkouts: allWorkouts]
    }

    /* ----This Test shows, that the Data isnt written correctly to the database. ---
    def addExercise(){
        Exercise bizeps = new Exercise(name:"Bizeps Curl", reps: 923, weight: 23).save(failOnError:true)
        //def myWorkout = Workout.findWhere(duration:120).exerciseList.addExercise(bizeps)
        //Workout.findWhere(duration:120).exerciseList.add(bizeps) -> Works
        def temp = Workout.findWhere(duration:120).exerciseList
        def newList = temp + [bizeps]

        Workout.findWhere(duration:120).exerciseList = newList
        Workout.findWhere(duration:120).save(failOnError: true)
        def bla = Workout.list().exerciseList
        //TODO: Why the Data is only available in addExercise? -> Test3 fails...
        render text : bla
    }
    def test3(){
        def blabla = Workout.list().exerciseList
        render text : blabla
    }
    */

    // Displays Workouts on Main Page
    def displayWorkouts(){
        def allWorkouts = Workout.listOrderByDate(max: 10, order: "desc")
        render view:"DisplayWorkouts", model:[allWorkouts: allWorkouts]
    }

    //Displays Statistics on Statistic Page
    def displayStatistics(){
        //Todo: Gewichte der einzelnen Übungen auslesen (Schwierig mit einer integrierten Liste)
        //def squatWeights = Workout.list().findAllWhere(name:"squat")

        def nrOfStrength = Workout.countByType("Strength")
        def nrOfEndurance = Workout.countByType("Endurance")
        def nrOfExplosive = Workout.countByType("Explosive")

        //Todo: Zählen der einzelnen Übungen -> iterieren über die ganzen Listen und CountBY ausführen
        def dummyData1 = [20,30,40,50,60,80]
        def dummyData2 = [25,23,25,32,21,32,12]
        def dummyData3 = [123,121,111,119]

        render view:"DisplayStatistics", model:[squatWeights: dummyData3, benchpressWeights: dummyData1, bizepCurlsWeights: dummyData2,
                                                nrOfStrength:nrOfStrength, nrOfEndurance:nrOfEndurance, nrOfExplosive:nrOfExplosive]
    }

    //Display Exercise Content when klicking on a Exercise
    def displayExercises(String date, String duration){
        def myDate = Date.parse("yyyy-MM-dd", date)
        def myWorkout = Workout.findWhere(date: myDate)
        render view: "DisplayExercises", model:[myWorkout: myWorkout]
    }

    /*
    def displayTemplates(){
        def text = "display Templates"
        render view: "DisplayTemplates", model:[text:text]
    }
    */

}