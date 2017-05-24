package mvc

import geb.spock.GebSpec
import grails.test.mixin.integration.Integration

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
class WorkoutTestSpec extends GebSpec {

    void "Checking Links"() {
        when: "Visiting Page DisplayWorkouts"
        go '/workout/DisplayWorkouts'
        then: "Page Display Workouts is displayed"
        title == "My Workouts"

        when: "Visiting Page addNewWorkout"
        go '/workout/addNewWorkout'
        then: "Page Add Workout is displayed"
        title == "Add Workout"

        when: "Visiting Page Display Statistics"
        go '/workout/DisplayStatistics'
        then: "Page Display Statistics is displayed"
        title == "My Statistics"

        when: "Visiting Page Display Statistics"
        go '/workout/DisplayStatistics'
        then: "Page Display Statistics is displayed"
        title == "My Statistics"


    }

    void "Checking Exercise Link"() {
        when: "Visiting existing Workout"
        go '/workout//displayExercises?date=2017-03-02%2000:00:00.0&duration=80'
        then: "Page with the Exercises is displayed"
        title == "My Exercises"
    }

    void "Checking New Workout Link"() {
        when: "Creating new Workout"
        go '/workout/saveWorkout?date=2017-01-01&duration=60&type=Strength'
        then: "Page DisplayWorkouts is displayed"
        title == "My Workouts"
    }

    void "Checking Button functionality of DisplayWorkout"(){
        when: "click on Add new Workout Button"
        $("a", text:"Add new Workout").click()
        then: "addNewWorkout page is displayed"
        title == "Add Workout"
        $("li").size() == 1
    }

    void "Checking Button functionality of addNewWorkout"(){
        when: "Visiting Page addNewWorkout"
        go '/workout/addNewWorkout'
        then: "Page Add Workout is displayed"
        title == "Add Workout"

        when: "click on Add Exercise Button"
        $("a", text:"Add Exercise").click()
        then: "A new Exercise is added"
        title == "Add Workout"
        //$("li").size() == 2

    }

    void "Checking Save Workout Button"(){
        given:
            go '/workout/addNewWorkout'
            $("form").duration   = 120
            $("form").type = "Strength"
            $("form").date = "2017-06-02"
        when: "click on Save Workout Button"
            $("input", text:"Save Workout").click()
        then: "Page DisplayWorkout is shown"
            //title == "My Workouts"
            title == "Add Workout"
    }



}
