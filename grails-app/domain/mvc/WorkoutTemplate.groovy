package mvc

class WorkoutTemplate {
    String name
    String type
    List<Exercise> exerciseList

    String toString(){
        return name
    }

    String getType(){
        return type
    }

    List<Exercise> getExercises(){
        return exerciseList
    }

    static constraints = {
        name()
        type()
        exerciseList()
    }
}