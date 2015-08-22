
```



case class L_Call(
    typ : L_Type, 
    fnptrval : L_Value, 
    fnargs : List[L_Argument], 
    tail : Boolean = false,                         //Optional
    callConvention : String = "",                   //Optional
    returnAttributes : List[String] = List(),       //Optional
    fnty : L_Type = null,                           //Optional
    fnattrs : List[String] = List()                 //Optional
    ) extends L_Instruction with L_Value



```

**Overview:**

Constructs an 'call' instruction.

The 'call' instruction represents a simple function call.

For further information see the LLVM Assembly Reference Manual - ['call' Instruction](http://llvm.org/docs/LangRef.html#i_call)

**Emitted LLVM IR:**
```
For a 'call' instruction 'n':

  <n->ssa> = [tail] call <callConvention> <returnAttributes(0) + " " + returnAttributes(1) + ...> 
             <encodeType(typ)> [<encodeType(fnty)>*] <encodeValue(fnptrval)>
             (<encodeArgument(fnargs(0)) + " " + encodeArgument(fnargs(1)) + ...>) 
             <fnattrs(0) + " " + fnattrs(1) + ...>
 
    
```