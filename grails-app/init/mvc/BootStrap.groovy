package mvc

import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        if (Environment.current == Environment.PRODUCTION) {
            return
        }
        // only in development and test
        Room upper = new Room(description: "5.3A17", capacity: 42).save(failOnError:true)
        Room lower = new Room(description: "5.1H19", capacity: 30).save(failOnError:true)

        Person dierk  = new Person(name: "Dierk").save(failOnError:true)
        Person dieter = new Person(name: "Dieter").save(failOnError:true)

        Date today = new Date().clearTime()
        new Booking(room: upper, booker: dierk, day: today - 1, timeSlot: Booking.AM).save(failOnError:true)
        new Booking(room: lower, booker: dierk, day: today,     timeSlot: Booking.AM).save(failOnError:true)
        new Booking(room: upper, booker: dierk, day: today + 1, timeSlot: Booking.AM).save(failOnError:true)
        new Booking(room: upper, booker: dieter, day: today,    timeSlot: Booking.AM).save(failOnError:true)
        new Booking(room: upper, booker: dieter, day: today,    timeSlot: Booking.PM1).save(failOnError:true)

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
        new Workout(date: Date.parse("yyyy-MM-dd", "2017-04-12"), duration: 60, type: "Stabilization", exerciseList: [clean,squat]).save(failOnError:true)
        new Workout(date: Date.parse("yyyy-MM-dd", "2017-03-02"), duration: 80, type: "Strength", exerciseList: [snatch,bizepsCurl]).save(failOnError:true)
        new Workout(date: Date.parse("yyyy-MM-dd", "2017-04-14"), duration: 90, type: "Endurance", exerciseList: [overheadSquat,squat]).save(failOnError:true)
        new Workout(date: Date.parse("yyyy-MM-dd", "2017-05-04"), duration: 100, type: "Explosive", exerciseList: [benchpress,bizepsCurl]).save(failOnError:true)

    }

    def destroy = {
    }
}
