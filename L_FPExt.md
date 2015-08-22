
```



case class L_FPExt(valuein : L_Value, 
                targetTypein : L_Type) 
           extends L_ConversionOperation(valuein, targetTypein)
{
    override val instructionString = "fpext"
}



```

**Overview:**

Constructs an 'fpext .. to' instruction.

The 'fpext' extends a floating point value to a larger floating point value.

For further information see the LLVM Assembly Reference Manual - ['fpext .. to' Instruction](http://llvm.org/docs/LangRef.html#i_fpext)

**Arguments:**

The 'fpext' instruction takes a floating point value to cast, and a floating point type to cast it to. The source type must be smaller than the destination type.

**Semantics:**

The 'fpext' instruction extends the value from a smaller floating point type to a larger floating point type. The fpext cannot be used to make a no-op cast because it always changes bits. Use bitcast to make a no-op cast for a floating point cast.

**Emitted LLVM IR:**
```
For a 'fpext' instruction 'n':

  <n->ssa> = fpext <encodeType(valuein->resultType)> <encodeValue(valuein)>, 
             <encodeType(targetTypein)>    
    
```