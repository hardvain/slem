
```



case class L_SExt(valuein : L_Value, 
             targetTypein : L_Type) 
           extends L_ConversionOperation(valuein, targetTypein)
{
    override val instructionString = "sext"
}



```

**Overview:**

Constructs an 'sext .. to' instruction.

The 'sext' sign extends value to the target type.

For further information see the LLVM Assembly Reference Manual - ['sext .. to' Instruction](http://llvm.org/docs/LangRef.html#i_sext)

**Arguments:**

The 'sext' instruction takes a value to cast, which must be of integer type, and a type to cast it to, which must also be of integer type. The bit size of the value must be smaller than the bit size of the destination type, 'targetTypein'.

**Semantics:**

The 'sext' instruction performs a sign extension by copying the sign bit (highest order bit) of the value until it reaches the bit size of the target type.

When sign extending from i1, the extension always results in -1 or 0.

**Emitted LLVM IR:**
```
For a 'sext' instruction 'n':

  <n->ssa> = sext <encodeType(valuein->resultType)> <encodeValue(valuein)>, 
             <encodeType(targetTypein)>    
    
```