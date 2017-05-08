package mvc


class WorkoutController{
    static scaffold = Workout

    def addNewWorkout(){
        def allExercises = Exercise.list()
        render view:"addNewWorkout", model:[allExercises:allExercises]
    }

    def saveWorkout(int duration, String type){
        Exercise benchpress = new Exercise(name: "Benchpress", reps: 10, weight: 70).save(failOnError:true)
        Exercise squat = new Exercise(name:"Squat", reps: 10, weight: 120).save(failOnError:true)
        new Workout(date: Date.parse("yyyy-MM-dd hh:mm:ss", "2017-05-09 11:00:00"), duration: duration, type: type, exerciseList: [benchpress,squat]).save(failOnError:true)
        render text: "Testpage"
    }

    def displayWorkouts(){
        def allWorkouts = Workout.listOrderByDate(max: 10, order: "desc")
        render view:"DisplayWorkouts", model:[allWorkouts: allWorkouts]
    }

    def displayStatistics(){
        def allWeights = Workout.list().exerciseList.weight
        //def squatWeights = Workout.list().findAllWhere(name:"squat")
        def nrOfStrength = Workout.countByType("Strength")
        def nrOfEndurance = Workout.countByType("Endurance")
        def nrOfExplosiveness = Workout.countByType("Explosiveness")

        //def nrOfBenchpress = Workout.list().exerciseList.countByType("[Clean, Squat]")
        def test = Workout.list().exerciseList

        def dummyData1 = [20,30,40,50,60]
        def dummyData2 = [25,23,25,32,21,32,12]
        def dummyData3 = [123,121,111,119]

        //render text: allWeights
        render view:"DisplayStatistics", model:[squatWeights: dummyData1, benchpressWeights: dummyData2, bizepCurlsWeights: dummyData3,
                                                nrOfStrength:nrOfStrength, nrOfEndurance:nrOfEndurance, nrOfExplosiveness:nrOfExplosiveness, test:test]
    }

    def displayTemplates(){
        def text = "display Templates"
        render view: "DisplayTemplates", model:[text:text]
    }

    def test(){
        def allWeights = Exercise.list().weight
        render view:"test", model: [weights : allWeights]
    }

    def testLink(String test){

        render text: test
    }

}