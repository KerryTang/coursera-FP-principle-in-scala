package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || c == r)
        1
      else
        pascal(c-1, r-1) + pascal(c, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      def charIter(stack: List[Char], xs: List[Char]): Boolean = {
        if(xs.isEmpty)
          stack.isEmpty
        else 
          xs.head match {
            case '(' => {
              charIter(stack :+'(', xs.tail)
            }
            case ')' => {
              if(stack.isEmpty)
                false
              else
                charIter(stack.tail, xs.tail)
            }
            case _ => charIter(stack, xs.tail)
          }
      }

      charIter(List[Char](), chars)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {


      def count(money: Int, coins: List[Int]): Int = {
        
        if(money == 0)
          1
        
        else if(coins.isEmpty || money < 0)
          0

        else
          count(money-coins.head, coins) + count(money, coins.tail)
      }

      if(money == 0)
        0
      else
        count(money, coins.sorted(Ordering[Int].reverse))
      
      
    }
}
