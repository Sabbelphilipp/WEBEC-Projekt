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

        Workout test = new Workout(name: "test", type: "Strength", exerciseList: [benchpress,squat]).save(failOnError:true)
    }

    def destroy = {
    }
}
