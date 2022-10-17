import kotlin.random.Random
// Polymorphism:
abstract class Person(_name: String)
{
    var name: String
    abstract var age: Int

    init {
        this.name = _name
    }

    abstract fun setPersonAge(_age:Int)
    abstract fun getPersonAge():Int

    fun getPersonName(){
        println("Name = $name")
    }
}

// Interface:
interface Movable
{
    fun move()
    {
        println("This object can be moved")
    }
}

interface Exist
{
    fun place()
    {
        println("The object is placed somewhere in space.")
    }
}

class Cashier(_name:String):Person(_name)
{
    override var age: Int = 0

    override fun setPersonAge(_age: Int) {
        age = _age
    }
    override fun getPersonAge():Int {
        return age
    }
    var number1=(0..1).shuffled().last()
    fun scan()
    {
        println("This Cashier named "+ name +" just scanned buyers Products!")
    }

    fun collectMoney()
    {
        println("This Cashier collected your Money")
    }

    fun give()
    {
        println("This Cashier just gave buyer the receipt, change and a bag")
    }
    fun nameC()
    {
        println("The cashier name is $name and she is $age years old")
    }
}

class Buyer(var sex: String,_name:String,var gipsy:Boolean):Person(_name)
{
    override var age: Int = 0

    override fun setPersonAge(_age: Int) {
        age = _age
    }
    override fun getPersonAge():Int {
        return age
    }
    var walking:Boolean = true
    var number=(0..1).shuffled().last()


    fun walk()
    {
        println("The Buyer, "+ name +" is waling through supermarket and $sex is $age yars old ")
    }

    fun choose()
    {
        println("The Buyer is choosing the products")
    }

    fun give(product:Int, money:Int)
    {
        println("The Buyer gives " +product+" products " + money+" dollars to Cashier")
    }

    fun isNot()
    {
        println("Buyer is not here yet")
    }
}

class SecurityGuard(var awake:Boolean, var gun:Boolean, var gipsy:Boolean,var pistol: String,_name:String):Person(_name)
{
    override var age: Int = 0

    override fun setPersonAge(_age: Int) {
        age = _age
    }
    override fun getPersonAge():Int {
        return age
    }
    var number2=(0..1).shuffled().last()

    fun checks()
    {
        if(awake == true)
        {
            println("The guard awake and he watching the cameras")
        }
        else
        {
            println("The guard still sleeps")
        }
    }
    fun arrests()
    {
        if(awake == true && gun == true && gipsy == true)
        {
            println("The Guard arrested the gipsy using ${pistol} pistol")
        }
        else
        {
            println("The guard still sleeps")
        }

    }
    fun nameG()
    {
        println("THe guard is $name and he is $age years old")
    }
}

class ShoppingCart(var person:String):Movable, Exist
{
    private var Action: Boolean = true

    override fun move() {
        super.move()
    }


    fun movingOn()
    {
        println("Is the cart moving? : ")
        val stringInput = readLine()!!
        if (stringInput == "1")
        {
            println("This Shopping Cart is pushed by a ${person}")
        }
        else
        {
            println("The Shopping Cart stopped moving")
        }
    }
}

class Products():Exist
{
    var number3=(0..1).shuffled().last()
    fun drinks()
    {
        println("What things you put in cart? : ")
        val stringInput = readLine()!!
        println("you have bought this: ${stringInput}")


    }
    fun food()
    {
        println("Buyer bought some food!")
    }

    fun stay()
    {
        println("The food is just sitting on the shelves")
    }
}

class Building(var number:Int, var parking:Boolean, var floors:Int, var address:String):Exist
{

    var number4=(0..1).shuffled().last()
    var floor=(1..4).random()
    fun numbers() {
        println("The number of your buildings are ${number} with ${floors} floors and it is placed on ${address} street")
        if (parking == true) {
            println("This building has parking lot")
        } else {
            println("This building doesnt have parking lot")
        }
    }
}



fun main(args: Array<String>)
{
    val cashier1 = Cashier("Ana")
    var age:Int

    cashier1.setPersonAge(21)
    age = cashier1.getPersonAge()
    cashier1.nameC()


    //cashier1.getPersonName()
   // println("Age = $age")
    //cashier1.scan()

    val buyer1 = Buyer("he", "Alex",true)

    buyer1.setPersonAge(18)
    age = buyer1.getPersonAge()

    buyer1.getPersonName()
    //println("Age= $age")


    if(buyer1.number == 1)
    {
        buyer1.walk()
        buyer1.choose()
        buyer1.give(10,100)
    }
    else if(buyer1.number == 0)
    {
        buyer1.isNot()
    }
    else
    {
        println()
    }

    if(cashier1.number1 == 1 && buyer1.number == 1)
    {
        cashier1.scan()
        cashier1.collectMoney()
        cashier1.give()
    }
    else if(cashier1.number1 == 0 && buyer1.number == 1)
    {
        println("The Cashier ${cashier1.name} went to bathroom")
    }
    else if(cashier1.number1 == 1 && buyer1.number ==0)
    {
        buyer1.isNot()
        println("The Cashier ${cashier1.name} is sleeping")
    }
    else
    {
        println("The store is closed")
    }

    val guard1 = SecurityGuard(true,true,true,"P250","James")
    guard1.setPersonAge(54)
    age = guard1.getPersonAge()

    //guard1.getPersonName()
    //println("Age = $age")
    println("")
    guard1.nameG()

    if(buyer1.gipsy == true && guard1.awake == true)
    {
        if(guard1.number2 == 1)
        {
            println("The gipsy is filling his pockets!")
            guard1.checks()
            guard1.arrests()
        }
        else if(guard1.number2 == 0 && buyer1.gipsy == true)
        {
            println("THe guard is asleep and the thief is filling the pockets")
            println("THe thief escaped =(")
        }
        else
        {
            println("idk what happened =)")
        }
    }
    else
    {
        println("No gypsy")
    }

    val cart1:ShoppingCart = ShoppingCart("Dan")
    cart1.move()
    cart1.place()

    println("")

    val products1:Products = Products()
    products1.place()

    if(buyer1.number == 1 && products1.number3 ==1)
    {
        buyer1.choose()
        products1.food()
        println("${buyer1.name} is walking to the cashier ${cashier1.name} with his products.")
    }
    else if (buyer1.number == 1 && products1.number3 == 0)
    {
        buyer1.choose()
        println("There are no products left that ${buyer1.name} wants =(")
    }
    else if (buyer1.number == 0 && products1.number3 == 1)
    {
      println("THe buyer ${buyer1.name} has no arrived yet in the store")
        products1.stay()
    }
    else if (buyer1.number ==1 && products1.number3 == 1 && cashier1.number1 == 1 && guard1.number2 ==1)
    {
        println("THe buyer ${buyer1.name} lost his wallet")
        println("THe cashier ${cashier1.name} can't open the bath door")
        println("The guard ${guard1.name} lost his ${guard1.pistol} and the gypsy is running away")
    }
    else if (buyer1.number ==0 && products1.number3 == 0 && cashier1.number1 == 0 && guard1.number2 ==0)
    {
        println("Buyer ${buyer1.name} started dating cashier ${cashier1.name} and none of them came to the store")
        println("Guard ${guard1.name} went to shoot bears with his ${guard1.pistol}")
        println("THe store is just closed it's The New Year eve 2023 !!!")
    }
    else
    {
        println("it's midnight, the products haven't arrived yet.")
        println("THe buyer ${buyer1.name} and the cashier ${cashier1.name} are still asleep")
        println("And the security guard ${guard1.name} is always asleep =)")
    }

    println("")

    val building1:Building = Building(3,true, 4,"Stefan cel Mare 17 street")
    building1.numbers()
    if(buyer1.number == 1 && building1.number4 == 1)
    {
        println("THe buyer ${buyer1.name} came to the Market at ${building1.address}")
        println("The buyer ${buyer1.name} parked and is going into the store Nr. ${building1.number}")
        println("THe buyer ${buyer1.name} is choosing one of the ${building1.floors} floors.")
        if(building1.floor == 1){
            println("The buyer went to buy some drinks on the 1'st floor")
        }
        else if (building1.floor == 2)
        {
            println("THe buyer went on second floor to see the clothing")
        }
        else if (building1.floor == 3)
        {
            println("THe buyer went on third floor to buy some fresh prepared food")
        }
        else if (building1.floor == 4)
        {
            println("THe buyer is on 4th floor looking for the wallet")
        }
        else
        {
            println("IDK WHAT HAPPENED =(")
        }
    }
    else if(buyer1.number == 0 && building1.number4 == 1)
    {
        println("THe buyer is going to the other store =(")
    }
    else if (buyer1.number == 1 && building1.number4 == 0)
    {
        println("THe buyer ${buyer1.name} came to the Market at ${building1.address}")
        println("The buyer ${buyer1.name} parked and is going into the store Nr. ${building1.number}")
        println("THe buyer ${buyer1.name} is choosing one of the ${building1.floors} floors.")
        if(building1.floor == 1){
            println("The buyer went to buy some drinks on the 1'st floor")
        }
        else if (building1.floor == 2)
        {
            println("THe buyer went on second floor to see the clothing")
        }
        else if (building1.floor == 3)
        {
            println("THe buyer went on third floor to buy some fresh prepared food")
        }
        else if (building1.floor == 4)
        {
            println("THe buyer is on 4th floor looking for the wallet")
        }
        else
        {
            println("IDK WHAT HAPPENED =(")
        }
    }
    else
    {
        println("THe buyer is just sitting home...")
    }
}
