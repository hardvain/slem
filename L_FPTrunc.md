
```



case class L_FPTrunc(valuein : L_Value, 
                targetTypein : L_Type) 
           extends L_ConversionOperation(valuein, targetTypein)
{
    override val instructionString = "fptrunc"
}



```

**Overview:**

Constructs an 'fptrunc .. to' instruction.

The 'fptrunc' instruction truncates value to the target type.

For further information see the LLVM Assembly Reference Manual - ['fptrunc .. to' Instruction](http://llvm.org/docs/LangRef.html#i_fptrunc)

**Arguments:**

The 'fptrunc' instruction takes a floating point value to cast and a floating point type to cast it to. The size of value must be larger than the size of the target type. This implies that fptrunc cannot be used to make a no-op cast.

**Semantics:**

The 'fptrunc' instruction truncates a value from a larger floating point type to a smaller floating point type. If the value cannot fit within the destination type, then the results are undefined.

**Emitted LLVM IR:**
```
For a 'fptrunc' instruction 'n':

  <n->ssa> = fptrunc <encodeType(valuein->resultType)> <encodeValue(valuein)>, 
             <encodeType(targetTypein)>    
    
```