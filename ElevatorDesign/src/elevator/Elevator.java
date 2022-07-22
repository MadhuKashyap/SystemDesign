package elevator;

import request.Request;
import types.Direction;
import types.State;

import java.util.TreeSet;

public class Elevator {
        private int currentFloor = 0;
        private Direction currentDirection = Direction.UP;
        private State currentState = State.IDLE;
        private TreeSet<Request> currentJobs = new TreeSet<>();
        private TreeSet<Request> upPendingJobs = new TreeSet<>();
        private TreeSet<Request> downPendingJobs = new TreeSet<>();

        public void startElevator() {
                while (true) {
                        if (checkIfJob()) {
                                if (currentDirection == Direction.UP) {
                                        Request request = currentJobs.pollFirst();
                                        processUpRequest(request);
                                        if (currentJobs.isEmpty()) {
                                                addPendingDownJobsToCurrentJobs();

                                        }
                                }
                                if (currentDirection == Direction.DOWN) {
                                        Request request = currentJobs.pollLast();
                                        processDownRequest(request);
                                        if (currentJobs.isEmpty()) {
                                                addPendingUpJobsToCurrentJobs();
                                        }
                                }
                        }
                }
        }

        public boolean checkIfJob() {

                if (currentJobs.isEmpty()) {
                        return false;
                }
                return true;

        }

        private void processUpRequest(Request request) {
                int startFloor = currentFloor;
                if (startFloor < request.getExternalRequest().getSourceFloor()) {
                        for (int i = startFloor; i <= request.getExternalRequest().getSourceFloor(); i++) {
                                System.out.println("We have reached floor -- " + i);
                                currentFloor = i;
                        }
                        System.out.println("Reached Destination Floor--opening door");
                }
                //Another person enterred the elevator at destination floor(d) and wants to go further up
                else
                {
                        downPendingJobs.add(request);
                }
                startFloor = currentFloor;
                for (int i = startFloor; i <= request.getInternalRequest().getDestinationFloor(); i++) {
                        System.out.println("We have reached floor -- " + i);
                        currentFloor = i;
                        //There could be n floor between current floor and floor d which could be a part of upPendingJobs
                        if (checkIfNewJobCanBeProcessed(request)) {
                                break;
                        }
                }
        }

        private void processDownRequest(Request request) {
                int startFloor = currentFloor;
                if (startFloor < request.getExternalRequest().getSourceFloor()) {
                        for (int i = startFloor; i <= request.getExternalRequest().getSourceFloor(); i++) {
                                System.out.println("We have reached floor -- " + i);
                                currentFloor = i;
                        }
                        System.out.println("Reached Source Floor--opening door");

                        startFloor = currentFloor;

                        for (int i = startFloor; i >= request.getInternalRequest().getDestinationFloor(); i--) {
                                System.out.println("We have reached floor -- " + i);
                                currentFloor = i;
                                if (checkIfNewJobCanBeProcessed(request)) {
                                        break;
                                }
                        }
                }
        }

        private boolean checkIfNewJobCanBeProcessed(Request currentRequest) {
                if (checkIfJob()) {
                        if (currentDirection == Direction.UP) {
                                Request request = currentJobs.pollFirst();
                                if (request.getInternalRequest().getDestinationFloor() < currentRequest.getInternalRequest()
                                    .getDestinationFloor()) {
                                        currentJobs.add(request);
                                        currentJobs.add(currentRequest);
                                        return true;
                                }
                                currentJobs.add(request);

                        }

                        if (currentDirection == Direction.DOWN) {
                                Request request = currentJobs.pollLast();
                                if (request.getInternalRequest().getDestinationFloor() > currentRequest.getInternalRequest()
                                    .getDestinationFloor()) {
                                        currentJobs.add(request);
                                        currentJobs.add(currentRequest);
                                        return true;
                                }
                                currentJobs.add(request);

                        }

                }
                return false;

        }

        private void addPendingDownJobsToCurrentJobs() {
                if (!downPendingJobs.isEmpty()) {
                        currentJobs = downPendingJobs;
                        currentDirection = Direction.DOWN;
                } else {
                        currentState = State.IDLE;
                }

        }

        private void addPendingUpJobsToCurrentJobs() {
                if (!upPendingJobs.isEmpty()) {
                        currentJobs = upPendingJobs;
                        currentDirection = Direction.UP;
                } else {
                        currentState = State.IDLE;
                }

        }



}
