package ducksim

class QuackNormal : QuackBehavior {
    override val state: State
        get() = State.QUACKING
}