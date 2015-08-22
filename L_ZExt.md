
```



case class L_ZExt(valuein : L_Value, 
             targetTypein : L_Type) 
           extends L_ConversionOperation(valuein, targetTypein)
{
    override val instructionString = "zext"
}


```

**Overview:**

Constructs an 'zext .. to' instruction.

The 'zext' instruction zero extends its operand to the target type.

For further information see the LLVM Assembly Reference Manual - ['zext .. to' Instruction](http://llvm.org/docs/LangRef.html#i_zext)

**Arguments:**

The 'zext' instruction takes a value to cast, which must be of integer type, and a type to cast it to, which must also be of integer type. The bit size of the value must be smaller than the bit size of the destination type, 'targetTypein'.

**Semantics:**

The zext fills the high order bits of the value with zero bits until it reaches the size of the destination type, 'targetTypein'.

When zero extending from i1, the result will always be either 0 or 1.

**Emitted LLVM IR:**
```
For a 'zext' instruction 'n':

  <n->ssa> = zext <encodeType(valuein->resultType)> <encodeValue(valuein)>, 
             <encodeType(targetTypein)>    
    
```