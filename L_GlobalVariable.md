
```
    ////////////GLOBAL VARIABLES////////////
    case class L_GlobalVariable(
        value        : L_Constant,
        addressSpace : Int = 0,          //Optional
        isConstant   : Boolean = false,  //Optional
        section      : String = "",      //Optional
        alignment    : Int = 0,          //Optional
        name         : String = "",      //Optional
        linkage      : String = ""       //Optional
        ) extends L_Global with L_Value
```

Global variables can be defined with just a value, but can also optionally contain information such as the address space, whether the variable is constant, section, alignmnet, variable name and linkage, embedded using the corresponding optional parameters.

Refer to the LLVM Assembly Language Reference Manual - [Global Variables](http://llvm.org/docs/LangRef.html#globalvars)