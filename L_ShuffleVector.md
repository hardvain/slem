
```



case class L_ShuffleVector (   v1 : L_Value, 
                               v2 : L_Value, 
                             mask : L_Value) 
           extends L_Instruction with L_Value



```

**Overview:**

Constructs a 'shufflevector' instruction.

The 'shufflevector' instruction constructs a permutation of elements from two input vectors, returning a vector with the same element type as the input and length that is the same as the shuffle mask.

For further information see the LLVM Assembly Reference Manual - ['shufflevector' Instruction](http://llvm.org/docs/LangRef.html#i_shufflevector)

**Arguments:**

The first two operands of a 'shufflevector' instruction are vectors with types that match each other. The third argument is a shuffle mask whose element type is always 'i32'. The result of the instruction is a vector whose length is the same as the shuffle mask and whose element type is the same as the element type of the first two operands.

The shuffle mask operand is required to be a constant vector with either constant integer or undef values.

**Semantics:**

The elements of the two input vectors are numbered from left to right across both of the vectors. The shuffle mask operand specifies, for each element of the result vector, which element of the two input vectors the result element gets. The element selector may be undef (meaning "don't care") and the second operand may be undef if performing a shuffle from only one vector.

**Emitted LLVM IR:**
```
For a shufflevector instruction 'n':

  <n->ssa> = shufflevector <encodeType(v1->resultType)> <encodeValue(v1)>, 
             <encodeType(v2->resulType)> <encodeValue(v2)>, 
             <encodeType(mask->resultType)> <encodeValue(mask)>
```