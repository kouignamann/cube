package fr.kouignamann.cube.core.model.gl;

import fr.kouignamann.cube.core.*;
import org.lwjgl.util.vector.*;

public class CameraMouvementVector3f extends Vector3f {

    private boolean walkVector;

    public CameraMouvementVector3f(boolean walkVector) {
        super();
        this.walkVector = walkVector;
        reset();
    }

    public void reset() {
        if (walkVector) {
            set(0f, 0f, Constant.CAMERA_MOVEMENT_SPEED);
        } else {
            set(Constant.CAMERA_MOVEMENT_SPEED, 0f, 0f);
        }
    }

    public void rotate(float[] rotationMatrix) {
        set(    getX()*rotationMatrix[0] + getY()*rotationMatrix[1] + getZ()*rotationMatrix[2],
                getX()*rotationMatrix[3] + getY()*rotationMatrix[4] + getZ()*rotationMatrix[5],
                getX()*rotationMatrix[6] + getY()*rotationMatrix[7] + getZ()*rotationMatrix[8]);
    }

    @Override
    public String toString() {
        return String.format("{Camera mvt vector : x=%f, y=%f, z=%f}", getX(), getY(), getZ());
    }
}