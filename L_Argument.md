# Function Arguments #
```
case class L_Argument(ty : L_Type, 
                   value : L_Value = null, 
                   attrs : List[String] = List(), 
                 argName : String = "") 
           extends L_Node
```
An argument maps a [value](L_Value.md) to a list of parameter attributes. It also provides the ability to optionally set the name of a function parameter by using the argName optional parameter when constructing the argument.