package ducksim

object DuckFactory : Subject {

    var membersInDSWC = ArrayList<Observer>()

    fun createDuck(baseDuck: Duck, starCount: Int, moonCount: Int, crossCount: Int): Duck {

        var result: Duck = baseDuck

        //Star
        repeat(starCount) {
            result = StarBling(result)
        }

        //moon
        repeat(moonCount) {
            result = MoonBling(result)
        }

        //cross
        repeat(crossCount) {
            result = CrossBling(result)
        }

        notifyObserver(result);

        return result
    }

    override fun registerObserver(observer: Observer) {
        membersInDSWC.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        membersInDSWC.remove(observer)
    }

    override fun notifyObserver(observer: Observer) {
        for (observer in membersInDSWC) {
            observer.update()
        }
    }
}