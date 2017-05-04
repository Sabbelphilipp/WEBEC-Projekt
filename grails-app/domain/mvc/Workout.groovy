package mvc

class Workout {
    String name
    String type
    List<Exercise> exerciseList

    String toString(){
        return "Name: " + name + "   Type: " + type + "   ExerciseList"
    }

    static constraints = {

    }
}