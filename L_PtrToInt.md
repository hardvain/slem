
```



case class L_PtrToInt(valuein : L_Value, 
               targetTypein : L_Type) 
           extends L_ConversionOperation(valuein, targetTypein)
{
    override val instructionString = "ptrtoint"
}




```

**Overview:**

Constructs an 'ptrtoint .. to' instruction.

The 'ptrtoint' instruction converts the pointer value to the integer target type.

For further information see the LLVM Assembly Reference Manual - ['ptrtoint .. to' Instruction](http://llvm.org/docs/LangRef.html#i_ptrtoint)

**Arguments:**

The 'ptrtoint' instruction takes a value to cast, which must be a pointer value, and a type to cast it to the target type, which must be an integer type.

**Semantics:**

The 'ptrtoint' instruction converts value to the integer target type by interpreting the pointer value as an integer and either truncating or zero extending that value to the size of the integer type. If value is smaller than the target type then a zero extension is done. If value is larger than the target type then a truncation is done. If they are the same size, then nothing is done (no-op cast) other than a type change.

**Emitted LLVM IR:**
```
For a 'ptrtoint' instruction 'n':

  <n->ssa> = ptrtoint <encodeType(valuein->resultType)> <encodeValue(valuein)>, 
             <encodeType(targetTypein)>    
    
```