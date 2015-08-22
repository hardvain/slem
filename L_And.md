
```



case class L_And(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "and"
}


```

**Overview:**

Constructs an 'and' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

For further information see the LLVM Assembly Reference Manual - ['and' Instruction](http://llvm.org/docs/LangRef.html#i_and)

**Arguments:**

The two arguments to the 'and' instruction must be integer or vector of integer values. Both arguments must have identical types.

**Semantics:**

The 'and' instruction returns the bitwise logical and of its two operands.

**Emitted LLVM IR:**
```
For an 'and' instruction 'n':

  <n->ssa> = and <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>         
```