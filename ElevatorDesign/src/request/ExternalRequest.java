package request;

import types.Direction;

public class ExternalRequest {
    private Direction directionToGo;
    private int sourceFloor;
    public ExternalRequest(Direction directionToGo, int sourceFloor) {
        this.directionToGo = directionToGo;
        this.sourceFloor = sourceFloor;
    }
    public Direction getDirectionToGo() {
        return directionToGo;
    }
    public void setDirectionToGo(Direction directionToGo) {
        this.directionToGo = directionToGo;
    }
    public int getSourceFloor() {
        return sourceFloor;
    }
    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }
}
