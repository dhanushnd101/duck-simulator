package ducksim

import java.awt.Color

class MoonBling(duckArg: Duck) : Bling(duckArg) {

    override val color: Color
        get() = wrappedDuck.color
    override val quackText: String
        get() = wrappedDuck.quackText

    override fun display(): String {
        return wrappedDuck.display() + ":)";
    }

}