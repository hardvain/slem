
```



case class L_Bitcast(valuein : L_Value, 
               targetTypein : L_Type) 
           extends L_ConversionOperation(valuein, targetTypein)
{
    override val instructionString = "bitcast"
}




```

**Overview:**

Constructs an 'bitcast .. to' instruction.

The 'bitcast' instruction converts value to the target type without changing any bits.

For further information see the LLVM Assembly Reference Manual - ['bitcast .. to' Instruction](http://llvm.org/docs/LangRef.html#i_bitcast)

**Arguments:**

The 'bitcast' instruction takes a value to cast, which must be a non-aggregate first class value, and a type to cast it to, which must also be a non-aggregate first class type. The bit sizes of value and the target type must be identical. If the source type is a pointer, the destination type must also be a pointer. This instruction supports bitwise conversion of vectors to integers and to vectors of other types (as long as they have the same size).

**Semantics:**

The 'bitcast' instruction converts value to the target type. It is always a no-op cast because no bits change with this conversion. The conversion is done as if the value had been stored to memory and read back as the target type. Pointer types may only be converted to other pointer types with this instruction. To convert pointers to other types, use the inttoptr or ptrtoint instructions first.

**Emitted LLVM IR:**
```
For a 'bitcast' instruction 'n':

  <n->ssa> = bitcast <encodeType(valuein->resultType)> <encodeValue(valuein)>, 
             <encodeType(targetTypein)>    
    
```