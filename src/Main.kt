fun main(args :Array<String>)
{


    val even: IntArray = intArrayOf(2, 4, 6)
    val odd: IntArray = intArrayOf(1, 3, 5)

    val lala: Array<IntArray> = arrayOf(even, odd)

    println(lala[0][2])

    lateinit var test :String
    var asdf :String ?= readLine()
    while(true)
    {

        if (asdf?.trim() == "")
        {

            println("podaj równanie!\n")

        }
        else
        {

            test = asdf!!
            break

        }

        asdf = readLine()

    }

    var num = mutableListOf<String>()
    var sym = mutableListOf<String>()

    var numi :Int = 0
    var symi :Int = 0

    var i :Int = 0
    var z :Int = 0

    loop@ while(i < test.length)
    {

        println(test[i])

        if(z > 0)
        {

            i += z
            z = 0
            continue

        }

        when(test[i])
        {


            in '0'..'9' ->
            {

                if (z > 0)
                {

                    i += z

                }

                if(i > 0)
                {

                    when(test[i-1])
                    {

                        '-' ->
                        {

                            sym.add(symi, "-")
                            symi++

                        }

                        else ->
                        {

                            sym.add(symi, "+")
                            symi++

                        }

                    }

                }
                else
                {

                    sym.add(symi, "+")
                    symi++

                }


                var concat :String = ""
                println("index i + z ${i+z}")
                while(test[i] in '0'..'9')
                {
                    if(i+z < test.length)
                    {
                        concat += test[i + z]
                        z++
                        println("z = $z")
                    }
                    else
                    {

                        println("koniec ciagu liczb")
                        break

                    }
                }

                num.add(numi, concat)
                numi++

                println("num = ${num[numi - 1]} numer numi: $numi, sym = ${sym[symi - 1]} numer symi: $symi")
                println("Final concat: $concat")


            }

            '-', '+' -> {i++; continue@loop}


        }
        println(i)
        i++
        println(i)

    }


}