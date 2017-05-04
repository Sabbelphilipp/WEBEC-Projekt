package mvc

class WorkoutController {

    static scaffold = Workout

    def showWorkouts(){
        def allWorkouts = Workout.list()
        render text: allWorkouts
    }
}
