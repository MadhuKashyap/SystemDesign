import elevator.Elevator;
import request.ExternalRequest;
import request.InternalRequest;
import request.Request;
import types.Direction;

public class TestElevator {
    public static void main(String args[]) {
        Elevator elevator = new Elevator();

        //person wants to go in up direction from source floor 0
        ExternalRequest er = new ExternalRequest(Direction.UP, 0);

        //the destination floor is 5
        InternalRequest ir = new InternalRequest(5);
        Request request1 = new Request(ir, er);
    }
}
