
```



case class L_ExtractValue(value : L_Value, 
                        indexes : List[L_Int]) 
           extends L_Instruction with L_Value



```

**Overview:**

Constructs a 'extractvalue' instruction.

The 'extractvalue' instruction extracts the value of a member field from an aggregate value.

For further information see the LLVM Assembly Reference Manual - ['extractvalue' Instruction](http://llvm.org/docs/LangRef.html#i_extractvalue)

**Arguments:**

The first operand of an 'extractvalue' instruction is a value of struct or array type. The operands are constant indices to specify which value to extract in a similar manner as indices in a 'getelementptr' instruction.

The major differences to getelementptr indexing are:

  * Since the value being indexed is not a pointer, the first index is omitted and assumed to be zero.
  * At least one index must be specified.
  * Not only struct indices but also array indices must be in bounds.

**Semantics:**

The result is the value at the position in the aggregate specified by the index operands.

**Emitted LLVM IR:**
```
For a extractvalue instruction 'n':

  <n->ssa> = extractvalue <encodeType(val->resultType)> <encodeValue(val)>, 
             <encodeValue(idx)>{, <encodeValue(idx)>}*

```