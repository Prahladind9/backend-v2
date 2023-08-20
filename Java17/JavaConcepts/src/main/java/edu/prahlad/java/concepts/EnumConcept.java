package edu.prahlad.java.concepts;

public class EnumConcept {
    protected static class CrewMember {
        private FlightCrew job;
        private String name;

        public CrewMember(FlightCrew job, String name) {
            this.job = job;
            this.name = name;
        }

        @Override
        public String toString() {
            return "CrewMember{" +
                    "job=" + job +
                    ", name='" + name + '\'' +
                    '}';
        }

        public FlightCrew getJob() {
            return job;
        }

        public String getName() {
            return name;
        }
    }

    protected enum FlightCrew {
        FLIGHT_ATTENDANT("Flight Attendant"),
        PILOT("Captain");
        //last value has the top priority


        private String title;

        FlightCrew(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "FlightCrew{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }
}
