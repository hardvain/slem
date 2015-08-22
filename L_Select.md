
```



case class L_Select(cond : L_Value, 
                    val1 : L_Value, 
                    val2 : L_Value) 
           extends L_Instruction with L_Value


```

**Overview:**

Constructs an 'select' instruction.

The 'select' instruction is used to choose one value based on a condition, without branching.

For further information see the LLVM Assembly Reference Manual - ['select' Instruction](http://llvm.org/docs/LangRef.html#i_select)

**Arguments:**

The 'select' instruction requires an 'i1' value or a vector of 'i1' values indicating the condition, and two values of the same first class type. If the val1/val2 are vectors and the condition is a scalar, then entire vectors are selected, not individual elements.

**Semantics:**

If the condition is an i1 and it evaluates to 1, the instruction returns the first value argument; otherwise, it returns the second value argument.

If the condition is a vector of i1, then the value arguments must be vectors of the same size, and the selection is done element by element.

**Emitted LLVM IR:**
```
For a 'select' instruction 'n':

  <n->ssa> = select <encodeType(cond->resultType)> <encodeValue(cond)>,
             <encodeType(val1->resultType)>, encodeValue(val1),
             <encodeType(val2->resultType)>, encodeValue(val2)
 
    
```