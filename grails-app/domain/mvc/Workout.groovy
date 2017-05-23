package mvc

class Workout {
    Date date
    int duration
    String type
    List<Exercise> exerciseList

    String toString(){
        return  date.dateString
    }

    static constraints = {
        date(blank: false, unique: true)
        type()
        duration(min: 0)
        exerciseList()
    }

}