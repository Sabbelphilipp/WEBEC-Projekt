package mvc

class Exercise{
    String name
    int reps
    double weight

    String toString(){
        return name
    }

    static constraints = {
        name()
        reps()
        weight()
    }
}