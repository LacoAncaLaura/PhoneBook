package org.fasttrackit;

public class UpdatePhoneBookRepositary {
    private boolean done;

    @Override
    public String toString() {
        return "UpdatePhoneBookRequest{" +
                "done=" + done +
                '}';
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
