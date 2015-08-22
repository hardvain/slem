
```



case class L_ExtractElement(vec : L_Value, idx : L_Value) extends L_Instruction with L_Value



```

**Overview:**

Constructs a 'extractelement' instruction.

The 'extractelement' instruction extracts a single scalar element from a vector at a specified index.

For further information see the LLVM Assembly Reference Manual - ['extractelement' Instruction](http://llvm.org/docs/LangRef.html#i_extractelement)

**Arguments:**

The first operand of an 'extractelement' instruction is a value of vector type. The second operand is an index indicating the position from which to extract the element. The index may be a variable.

**Semantics:**

The result is a scalar of the same type as the element type of vec. Its value is the value at position idx of vec. If idx exceeds the length of vec, the results are undefined.

**Emitted LLVM IR:**
```
For a extractelement instruction 'n':

  <n->ssa> = extractelement <encodeType(vec->resultType)> <encodeValue(vec)>, 
             i32 <encodeValue(idx)>
```