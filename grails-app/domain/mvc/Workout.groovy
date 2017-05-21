package mvc

class Workout {
    Date date
    int duration
    String type
    List<Exercise> exerciseList

    String toString(){
        return  date.dateString
    }

    //TODO: Können hier Methoden hinzugefügt werden?

    static constraints = {
        date()
        type()
        duration()
        exerciseList()
    }

}