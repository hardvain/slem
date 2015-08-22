
```



case class L_FPToUI(valuein : L_Value, 
                targetTypein : L_Type) 
           extends L_ConversionOperation(valuein, targetTypein)
{
    override val instructionString = "fptoui"
}



```

**Overview:**

Constructs an 'fptoui .. to' instruction.

TThe 'fptoui' converts a floating point value to its unsigned integer equivalent of the target type.

For further information see the LLVM Assembly Reference Manual - ['fptoui .. to' Instruction](http://llvm.org/docs/LangRef.html#i_fptoui)

**Arguments:**

The 'fptoui' instruction takes a value to cast, which must be a scalar or vector floating point value, and a type to cast it to the target type, which must be an integer type. If the source type is a vector floating point type, the target type must be a vector integer type with the same number of elements as the source type.

**Semantics:**

The 'fptoui' instruction converts its floating point operand into the nearest (rounding towards zero) unsigned integer value. If the value cannot fit in the destination type, the results are undefined.

**Emitted LLVM IR:**
```
For a 'fptoui' instruction 'n':

  <n->ssa> = fptoui <encodeType(valuein->resultType)> <encodeValue(valuein)>, 
             <encodeType(targetTypein)>    
    
```