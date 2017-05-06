package mvc


class WorkoutController{
    static scaffold = Workout

    def displayWorkouts(){
        def allWorkouts = Workout.listOrderByDate(max: 10, order: "desc")
        render view:"DisplayWorkouts", model:[allWorkouts: allWorkouts]
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