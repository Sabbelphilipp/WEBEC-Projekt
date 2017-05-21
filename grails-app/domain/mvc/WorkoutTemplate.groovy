package mvc

class WorkoutTemplate {
    String name
    String type
    List<Exercise> exerciseList

    String toString(){
        return name
    }


    static constraints = {
        name()
        type()
        exerciseList()
    }
}