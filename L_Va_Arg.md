
```



case class L_Va_Arg(argList : L_Value, 
                    argType : L_Type) 
           extends L_Instruction with L_Value


```

**Overview:**

Constructs an 'va\_arg' instruction.

The 'va\_arg' instruction is used to access arguments passed through the "variable argument" area of a function call. It is used to implement the va\_arg macro in C.

For further information see the LLVM Assembly Reference Manual - ['va\_arg' Instruction](http://llvm.org/docs/LangRef.html#i_va_arg)

**Arguments:**

The instruction takes a pointer to the list of arguments as argList and the type of each argument in that list as argType

**Semantics:**

The 'va\_arg' instruction loads an argument of the specified type from the specified va\_list and causes the va\_list to point to the next argument. For more information, see the variable argument handling Intrinsic Functions.

It is legal for this instruction to be called in a function which does not take a variable number of arguments, for example, the vfprintf function.

va\_arg is an LLVM instruction instead of an intrinsic function because it takes a type as an argument.

**Emitted LLVM IR:**
```
For a 'va_arg' instruction 'n':

  <n->ssa> = va_arg <encodeType(argList->resultType)> <encodeValue(argList)>, 
             <encodeType(argType)>    
    
```