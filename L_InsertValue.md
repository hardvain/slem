
```



case class L_InsertValue(value : L_Value, 
                           elt : L_Value, 
                           idx : L_Value) 
           extends L_Instruction with L_Value



```

**Overview:**

Constructs a 'insertvalue' instruction.

The 'insertvalue' instruction inserts a value into a member field in an aggregate value.

For further information see the LLVM Assembly Reference Manual - ['insertvalue' Instruction](http://llvm.org/docs/LangRef.html#i_insertvalue)

**Arguments:**

The first operand of an 'insertvalue' instruction is a value of struct or array type. The second operand is a first-class value to insert. The following operands are constant indices indicating the position at which to insert the value in a similar manner as indices in a 'extractvalue' instruction. The value to insert must have the same type as the value identified by the indices.

**Semantics:**

The result is an aggregate of the same type as val. Its value is that of val except that the value at the position specified by the indices is that of elt.

**Emitted LLVM IR:**
```
For a insertvalue instruction 'n':

  <n->ssa> = insertvalue <encodeType(value->resultType)> <encodeValue(value)>, 
             <encodeType(elt->resultType)> <encodeValue(elt)>, 
             <idx>

```