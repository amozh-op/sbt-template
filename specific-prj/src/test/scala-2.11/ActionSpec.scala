
import org.scalatest._


/**
  * Created by Andrii Mozharovskyi on 6/6/16.
  */
class ActionSpec extends FlatSpec {

  "An Action.eat('burger') action " should "return 'burger is swallowed' " in {
    assert(Action.eat("burger") === "burger is swallowed!")
  }

  "Action.multiply " should " multiply the values" in {
    assert(Action.multiply(2, 2) === 4)
  }

  "Action.subtract " should " subtract the values" in {
    assert(Action.subtract(2, 2) === 0)
  }

}
