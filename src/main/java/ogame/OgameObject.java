package ogame;

import ogame.utils.AntiLooping;

import java.io.Serializable;

public abstract class OgameObject implements Serializable {

    private final AntiLooping antiLooping = new AntiLooping(5);
    private static final long serialVersionUID = 1992L;

    public AntiLooping getAntiLooping() {
        return antiLooping;
    }
}
