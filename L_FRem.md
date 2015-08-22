
```



case class L_FRem(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "frem"
}


```

**Overview:**

Constructs an 'frem' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

For further information see the LLVM Assembly Reference Manual - ['frem' Instruction](http://llvm.org/docs/LangRef.html#i_frem)

**Arguments:**

The two arguments to the 'frem' instruction must be floating point or vector of floating point values. Both arguments must have identical types.

**Semantics:**

This instruction returns the remainder of a division. The remainder has the same sign as the dividend.

**Emitted LLVM IR:**
```
For a frem instruction 'n':

  <n->ssa> = frem <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>         
```