package mvc

class ExerciseController {

    static scaffold = Exercise

    def showExercises(){
        def allExercises = Exercise.list()
        render text: allExercises
    }
}
