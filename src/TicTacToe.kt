fun showWelcome(){
    println("Welcome to OX Game")
}

fun generateTable() : Array<Array<String>>{
    return arrayOf(
        arrayOf("-","-","-"),
        arrayOf("-","-","-"),
        arrayOf("-","-","-")
    )
}

fun showTable(table : Array<Array<String>>){
    println("  1 2 3")
    for(i in table.indices){
        var index = i+1;
        print("$index ")
        for(j in table[i].indices){
            print(table[i][j] +" ")
        }
        println()
    }
}

fun calRound(round: Int) : Int{
    var cRound = round+1
    if(round % 2 == 0) {
        println("O Turn")
    }else{
        println("X Turn")
    }

    return cRound
}

fun putTable(table : Array<Array<String>>, row : Int, col : Int, round: Int) : Array<Array<String>>{
    var newTable = table
    if(round%2 == 0){
        if(newTable[row][col] != "-" || newTable[row][col] != "O" || newTable[row][col] != "X") {
            newTable[row][col] = "X"
        }
    }else{
        if(newTable[row][col] != "-" || newTable[row][col] != "O" || newTable[row][col] != "X") {
            newTable[row][col] = "O"
        }
    }

    return newTable
}

fun checkWin(table : Array<Array<String>>) : Boolean{
    for(i in table.indices){
        if(table[i][0] == "O" && table[i][1] == "O" && table[i][2] == "O"){
            print("0 win!")
            return true
        }

        if(table[0][i] == "O" && table[1][i] == "O" && table[2][i] == "O"){
            print("0 win!")
            return true
        }

        if(table[i][0] == "X" && table[i][1] == "X" && table[i][2] == "X"){
            print("X win!")
            return true
        }
        if(table[0][i] == "X" && table[1][i] == "X" && table[2][i] == "X"){
            print("X win!")
            return true
        }
    }
    if(table[0][0] == "O" && table[1][1] == "O" && table[2][2] == "O"){
        print("draw!")
    }
    if(table[0][0] == "X" && table[1][1] == "X" && table[2][2] == "X"){
        print("draw!")
    }
    return false;
}


fun main() {
    var round = 1
    showWelcome()
    var table = generateTable()

        while (true) {
            showTable(table)
            round = calRound(round)
            print("please input Row Col : ")
            val input = readLine()
            val rcList = input?.split(" ")
            if(rcList?.size != 2){
                continue
            }
//        print(rcList?.get(0)+" "+rcList?.get(1))
            var row  =  rcList!![0].toInt()-1
            var col  =  rcList!![1].toInt()-1

            if(row < 0 || col < 0 || row > 3 || col > 3){
                round -= 1
                println("Out of Index!!")
                continue
            }

            table = putTable(table,row,col,round)

            println()

            if(checkWin(table)){
                break;
            }

        }




}