package ducksim

class Flock(val ducks: List<Duck>) : Duck() {
    override fun display(): String {

        var result = "Flock"
        ducks.forEach {
            result = result + ":" + it.display().first().uppercase()
        }

        return result;
    }

    override val capture = object : DuckMenuItem {
        override fun invoke() {
            ducks.forEach { it.doCapture() }
            doCapture()
        }
    }

    override val release = object : DuckMenuItem {
        override fun invoke() {
            ducks.forEach { it.doRelease() }
            doRelease()
        }
    }

    override val quitDSCW = object : DuckMenuItem {
        override fun invoke() {
            ducks.forEach { it.doQuit() }
            doQuit()
        }
    }

    override val joinDSCW = object : DuckMenuItem {
        override fun invoke() {
            ducks.forEach { it.doJoin() }
            doJoin()
        }
    }

    override val quackText: String = "Noise!";
}