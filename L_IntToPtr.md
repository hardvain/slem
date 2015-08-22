
```



case class L_IntToPtr(valuein : L_Value, 
               targetTypein : L_Type) 
           extends L_ConversionOperation(valuein, targetTypein)
{
    override val instructionString = "inttoptr"
}




```

**Overview:**

Constructs an 'inttoptr .. to' instruction.

The 'inttoptr' instruction converts an integer value to the target pointer type.

For further information see the LLVM Assembly Reference Manual - ['inttoptr .. to' Instruction](http://llvm.org/docs/LangRef.html#i_inttoptr)

**Arguments:**

The 'inttoptr' instruction takes an integer value to cast, and a type to cast it to, which must be a pointer type.

**Semantics:**

The 'inttoptr' instruction converts value to the target type by applying either a zero extension or a truncation depending on the size of the integer value. If value is larger than the size of a pointer then a truncation is done. If value is smaller than the size of a pointer then a zero extension is done. If they are the same size, nothing is done (no-op cast).

**Emitted LLVM IR:**
```
For a 'inttoptr' instruction 'n':

  <n->ssa> = inttoptr <encodeType(valuein->resultType)> <encodeValue(valuein)>, 
             <encodeType(targetTypein)>    
    
```