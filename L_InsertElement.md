
```



case class L_InsertElement(vec : L_Value, 
                           elt : L_Value, 
                           idx : L_Value) 
           extends L_Instruction with L_Value



```

**Overview:**

Constructs a 'insertelement' instruction.

The 'insertelement' instruction inserts a scalar element into a vector at a specified index.

For further information see the LLVM Assembly Reference Manual - ['insertelement' Instruction](http://llvm.org/docs/LangRef.html#i_insertelement)

**Arguments:**

The first operand of an 'insertelement' instruction is a value of vector type. The second operand is a scalar value whose type must equal the element type of the first operand. The third operand is an index indicating the position at which to insert the value. The index may be a variable.

**Semantics:**

The result is a vector of the same type as vec. Its element values are those of vec except at position idx, where it gets the value elt. If idx exceeds the length of vec, the results are undefined.

**Emitted LLVM IR:**
```
For a insertelement instruction 'n':

  <n->ssa> = insertelement <encodeType(vec->resulttype)> <encodeValue(vec)>, 
             <encodeType(elt->resultType)> <encodeValue(elt)>, i32 <encodeValue(idx)>
```