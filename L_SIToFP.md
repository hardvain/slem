
```



case class L_SIToFP(valuein : L_Value, 
               targetTypein : L_Type) 
           extends L_ConversionOperation(valuein, targetTypein)
{
    override val instructionString = "sitofp"
}




```

**Overview:**

Constructs an 'sitofp .. to' instruction.

The 'sitofp' instruction regards value as a signed integer and converts that value to the target type.

For further information see the LLVM Assembly Reference Manual - ['sitofp .. to' Instruction](http://llvm.org/docs/LangRef.html#i_sitofp)

**Arguments:**

The 'sitofp' instruction takes a value to cast, which must be a scalar or vector integer value, and a type to cast it to target type, which must be an floating point type. If the source type is a vector integer type, the target type must be a vector floating point type with the same number of elements as the source type.

**Semantics:**

The 'sitofp' instruction interprets its operand as a signed integer quantity and converts it to the corresponding floating point value. If the value cannot fit in the floating point value, the results are undefined.

**Emitted LLVM IR:**
```
For a 'sitofp' instruction 'n':

  <n->ssa> = sitofp <encodeType(valuein->resultType)> <encodeValue(valuein)>, 
             <encodeType(targetTypein)>    
    
```