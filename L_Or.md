
```



case class L_Or(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "or"
}


```

**Overview:**

Constructs an 'or' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

For further information see the LLVM Assembly Reference Manual - ['or' Instruction](http://llvm.org/docs/LangRef.html#i_or)

**Arguments:**

The two arguments to the 'or' instruction must be integer or vector of integer values. Both arguments must have identical types.

**Semantics:**

The 'or' instruction returns the bitwise logical inclusive or of its two operands.

**Emitted LLVM IR:**
```
For an 'or' instruction 'n':

  <n->ssa> = or <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>         
```