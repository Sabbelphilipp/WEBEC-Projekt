package mvc

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        if (Environment.current == Environment.PRODUCTION) {
            return
        }

        Exercise benchpress = new Exercise(name: "Benchpress", reps: 10, weight: 70).save(failOnError:true)
        Exercise squat = new Exercise(name:"Squat", reps: 10, weight: 120).save(failOnError:true)
        Exercise overheadSquat = new Exercise(name:"Overhead Squat", reps: 10, weight: 60).save(failOnError:true)
        Exercise snatch = new Exercise(name:"Snatch", reps: 10, weight: 120).save(failOnError:true)
        Exercise clean = new Exercise(name:"Clean", reps: 10, weight: 120).save(failOnError:true)
        Exercise bizepsCurl = new Exercise(name:"Bizeps Curl", reps: 10, weight: 120).save(failOnError:true)


        WorkoutTemplate legs = new WorkoutTemplate(name: "Legs", type: "Strength", exerciseList: [benchpress,squat]).save(failOnError:true)
        WorkoutTemplate chest = new WorkoutTemplate(name: "Chest", type: "Strength", exerciseList: [benchpress,squat]).save(failOnError:true)
        WorkoutTemplate cardio = new WorkoutTemplate(name: "Cardio", type: "Endurance", exerciseList: [benchpress,squat]).save(failOnError:true)

        new Workout(date: Date.parse("yyyy-MM-dd", "2017-05-01"), duration: 120, type: "Strength", exerciseList: [benchpress,squat,clean,snatch,bizepsCurl]).save(failOnError:true)
        new Workout(date: Date.parse("yyyy-MM-dd", "2017-04-12"), duration: 60, type: "Stabilization", exerciseList: [clean,squat,bizepsCurl,overheadSquat]).save(failOnError:true)
        new Workout(date: Date.parse("yyyy-MM-dd", "2017-03-02"), duration: 80, type: "Strength", exerciseList: [snatch,bizepsCurl,benchpress,squat]).save(failOnError:true)
        new Workout(date: Date.parse("yyyy-MM-dd", "2017-04-14"), duration: 90, type: "Endurance", exerciseList: [overheadSquat,squat,bizepsCurl,clean]).save(failOnError:true)
        new Workout(date: Date.parse("yyyy-MM-dd", "2017-05-04"), duration: 100, type: "Explosive", exerciseList: [benchpress,bizepsCurl,squat,overheadSquat]).save(failOnError:true)

    }

    def destroy = {
    }
}
