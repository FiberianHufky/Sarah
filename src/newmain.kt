import java.lang.Math.pow
import java.lang.Math.sqrt

fun larry(tempeq :MutableList<String>) :String
{

    var i :Int = 0

    var tot :MutableList<String> = mutableListOf<String>()

    while(i <= tempeq.lastIndex)
    {

        when (tempeq[i])
        {

            "s" ->
            {

                tempeq[i] = sqrt(tempeq[i + 1].toDouble()).toString()
                tempeq.removeAt(i+1)
                i = 0


            }

            "^" ->
            {

                tempeq[i] = pow(tempeq[i - 1].toDouble(), tempeq[i + 1].toDouble()).toString()
                tempeq.removeAt(i+1)
                tempeq.removeAt(i-1)
                i = 0

            }

        }

        i++

    }


    i = 0

    while(i <= tempeq.lastIndex)
    {

        when(tempeq[i])
        {

            "*" ->
            {

                tempeq[i] = (tempeq[i - 1].toDouble() * tempeq[i + 1].toDouble()).toString()
                tempeq.removeAt(i+1)
                tempeq.removeAt(i-1)
                i = 0

            }

            "/" ->
            {

                tempeq[i] = (tempeq[i - 1].toDouble() / tempeq[i + 1].toDouble()).toString()
                tempeq.removeAt(i+1)
                tempeq.removeAt(i-1)
                i = 0

            }

        }

        i++

    }

    i = 0

    while(tempeq.lastIndex > 0)
    {

        tempeq[0] = (tempeq[0].toFloat() + tempeq[1].toFloat()).toString()
        tempeq.removeAt(1)

    }

    return tempeq[0]

}


fun alice(eq :MutableList<String>, paro :Int, parc :Int) :String
{

    var eqstr :MutableList<String> = mutableListOf<String>()
    var tstr :String = ""

    var counter :Int = paro

    while(counter <= parc)
    {

        if(eq[counter].length > 1)
        {

            eqstr.add(eq[counter])
            counter++
            continue

        }

        if (eq[counter] == "-")
        {

            counter++

            if(eq[counter].length > 1)
            {

                eqstr.add((eq[counter].toFloat() * (-1)).toString())
                counter++
                continue

            }

            while (eq[counter] in "0".."9" || eq[counter] == ".")
            {

                tstr += eq[counter]
                counter++
                if(counter > eq.lastIndex) break

            }

            tstr = (tstr.toFloat() * (-1)).toString() //Don't tell Sarah
            println("adding $tstr to eqstr")
            eqstr.add(tstr)
            tstr = ""

        }
        else
        {

            when(eq[counter])
            {

                in "0".."9" ->
                {

                    while (eq[counter] in "0".."9" || eq[counter] == ".")
                    {

                        tstr += eq[counter]
                        counter++
                        if(counter > eq.lastIndex) break

                    }

                    println("adding $tstr to eqstr")
                    eqstr.add(tstr)
                    tstr = ""

                }

                "+" ->
                {

                    counter++

                    println("FOUND + SKIPPING")


                }

                "s", "*", "/", "^" ->
                {

                    println("adding ${eq[counter]} to esqtr")
                    eqstr.add(eq[counter])
                    counter++

                }

                else ->
                {

                    println("NIEDOZWOLONY ZNAK")
                    counter++

                }

            }

        }

    }

    return larry(eqstr)

}

fun main(array :Array<String>)
{

    var a :String = "0+0"
    a.decapitalize()
    a = a.replace("\\s".toRegex(), "")

    var eq :MutableList<String> = mutableListOf<String>()

    if(a != null)
    {

        for(c in a)
        {

            eq.add(c.toString())

        }

        var i :Int = 0
        var par = 0
        var paro = 0
        var parc = 0

        asdf@ while(i <= eq.lastIndex) //Don't tell Sarah
        {

            when(eq[i])
            {

                "(" ->
                {

                    par++
                    paro = i

                }

                ")" ->
                {

                    par--
                    parc = i
                    var z :Int = 0

                    var tempeq :MutableList<String> = mutableListOf<String>()

                    while(z <= eq.lastIndex)
                    {

                        if(z == paro + 1) tempeq.add(alice(eq, paro+1, parc-1))
                        if(z < paro || z > parc) tempeq.add(eq[z])
                        z++

                    }

                    eq = tempeq
                    i = 0
                    continue@asdf

                }

            }

            i++

        }

        println(eq)

        println(alice(eq, 0, eq.lastIndex))

    }

}