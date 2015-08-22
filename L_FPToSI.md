
```



case class L_FPToSI(valuein : L_Value, 
                targetTypein : L_Type) 
           extends L_ConversionOperation(valuein, targetTypein)
{
    override val instructionString = "fptosi"
}



```

**Overview:**

Constructs an 'fptosi .. to' instruction.

The 'fptosi' instruction converts floating point value to the target type.

For further information see the LLVM Assembly Reference Manual - ['fptosi .. to' Instruction](http://llvm.org/docs/LangRef.html#i_fptosi)

**Arguments:**

The 'fptosi' instruction takes a value to cast, which must be a scalar or vector floating point value, and a type to cast it to the destination type, which must be an integer type. If the source type is a vector floating point type, the target type must be a vector integer type with the same number of elements as the source type.

**Semantics:**

The 'fptosi' instruction converts its floating point operand into the nearest (rounding towards zero) signed integer value. If the value cannot fit in the destination type, the results are undefined.

**Emitted LLVM IR:**
```
For a 'fptosi' instruction 'n':

  <n->ssa> = fptosi <encodeType(valuein->resultType)> <encodeValue(valuein)>, 
             <encodeType(targetTypein)>    
    
```