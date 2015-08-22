
```



case class L_Trunc(valuein : L_Value, 
              targetTypein : L_Type) 
           extends L_ConversionOperation(valuein, targetTypein)
{
    override val instructionString = "trunc"
}


```

**Overview:**

Constructs an 'trunc .. to' instruction.

The 'trunc' instruction truncates its operand to the type ty2.

For further information see the LLVM Assembly Reference Manual - ['trunc .. to' Instruction](http://llvm.org/docs/LangRef.html#i_trunc)

**Arguments:**

The 'trunc' instruction takes a value to trunc, which must be an integer type, and a type that specifies the size and type of the result, which must be an integer type. The bit size of value must be larger than the bit size of ty2. Equal sized types are not allowed.

**Semantics:**

The 'trunc' instruction truncates the high order bits in value and converts the remaining bits to ty2. Since the source size must be larger than the destination size, trunc cannot be a no-op cast. It will always truncate bits.

**Emitted LLVM IR:**
```
For a 'trunc' instruction 'n':

  <n->ssa> = trunc <encodeType(valuein->resultType)> <encodeValue(valuein)>, 
             <encodeType(targetTypein)>    
    
```