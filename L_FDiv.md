
```



case class L_FDiv(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "fdiv"
}


```

**Overview:**

Constructs an 'fdiv' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

For further information see the LLVM Assembly Reference Manual - ['fdiv' Instruction](http://llvm.org/docs/LangRef.html#i_fdiv)

**Arguments:**

The two arguments to the 'fdiv' instruction must be floating point or vector of floating point values. Both arguments must have identical types.

**Semantics:**

The value produced is the floating point quotient of the two operands.

**Emitted LLVM IR:**
```
For a fdiv instruction 'n':

  <n->ssa> = fdiv <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>         
```