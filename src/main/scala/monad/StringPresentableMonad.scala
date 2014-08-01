package monad

object StringPresentableMonad {

  trait StringPresentable[T] {
    def toString(value: T): String

    def fromString(value: String): T
  }

  implicit object stringIsStringPresentable extends StringPresentable[String] {
    override def toString(value: String): String = value.toString

    override def fromString(value: String): String = value
  }

//  implicit object ListIsStringPresentable[T] extends StringPresentable[List[T]] {
//
//    override def toString(value: List[T]): String = ???
//
//    override def fromString(value: String): List[T] = ???
//  }

  case class Account(owner: String, balance: Double)

  implicit object accountIsStringPresentable extends StringPresentable[Account]{
    override def toString(value: Account): String = s"${value.owner},${value.balance}"

    override def fromString(value: String): Account = {
      val values = value.split(",")
      Account(values(0), values(1).toDouble)
    }
  }
}
