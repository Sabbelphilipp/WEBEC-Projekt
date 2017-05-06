package mvc


class WorkoutController{
    static scaffold = Workout

    def addNewWorkout(){
        def allExercises = Exercise.list()
        render view:"addNewWorkout", model:[allExercises:allExercises]
    }

    def displayWorkouts(){
        def allWorkouts = Workout.listOrderByDate(max: 10, order: "desc")
        render view:"DisplayWorkouts", model:[allWorkouts: allWorkouts]
    }

    def displayStatistics(){
        def allWeights = Workout.list().exerciseList.weight
        //def squatWeights = Workout.list().findAllWhere(name:"squat")

        def dummyData1 = [20,30,40,50,60]
        def dummyData2 = [25,23,25,32,21,32,12]
        def dummyData3 = [123,121,111,119]

        //render text: allWeights
        render view:"DisplayStatistics", model:[squatWeights: dummyData1, benchpressWeights: dummyData2, bizepCurlsWeights: dummyData3]
    }

    def displayTemplates(){
        def text = "display Templates"
        render view: "DisplayTemplates", model:[text:text]
    }

    def test(){
        def allWeights = Exercise.list().weight
        render view:"test", model: [weights : allWeights]
    }

}