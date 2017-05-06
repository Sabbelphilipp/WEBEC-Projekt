package mvc


class WorkoutController{
    static scaffold = Workout

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
        render text: "display Templates"
    }


    def showWorkouts(){
        def allWorkouts = Workout.listOrderByDate(max: 10, order: "desc")
        render text: allWorkouts
    }

    def showExercises(){
        def allExercises = Exercise.list()
        render text: allExercises
    }

    def showWorkoutTemplates(){
        def allWorkoutTemplates = WorkoutTemplate.list()
        render text: allWorkoutTemplates
    }

    def test2() {
        def workout1 = WorkoutTemplate.findWhere(name:"Legs")
        render text: workout1.type
    }

    def test3(){
        def workout1 = WorkoutTemplate.list()
        //render text : workout1
        render view:"test", model: [workout1: workout1]
    }

    def test(){
        def allWeights = Exercise.list().weight
        render view:"test", model: [weights : allWeights]
    }

}