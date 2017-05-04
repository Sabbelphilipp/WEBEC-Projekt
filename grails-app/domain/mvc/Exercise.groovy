package mvc

class Exercise{
    String name
    int reps
    double weight

    String toString(){
        return "Name: " + name + "   Repetitions: " + reps + "   Weight: " + weight + " kg"
    }

    static constraints = {

    }
}