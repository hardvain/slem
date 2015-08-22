
```



case class L_UDiv(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "udiv"
}

case class L_ExactUDiv(LHSin : L_Value, RHS : L_Value) extends L_BinOpInstruction(LHSin, RHSin)
{
    override val instructionString = "udiv exact"
}



```

**Overview:**

Constructs an 'udiv' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

For further information see the LLVM Assembly Reference Manual - ['udiv' Instruction](http://llvm.org/docs/LangRef.html#i_udiv)

**Arguments:**

The two arguments to the 'udiv' instruction must be integer or vector of integer values. Both arguments must have identical types.

**Semantics:**

The value produced is the unsigned integer quotient of the two operands.

Note that unsigned integer division and signed integer division are distinct operations; for signed integer division, use 'sdiv'.

Division by zero leads to undefined behavior.

If the exact keyword is present, the result value of the udiv is a trap value if %op1 is not a multiple of %op2 (as such, "((a udiv exact b) mul b) == a").

**Emitted LLVM IR:**
```
For a udiv instruction 'n':

  <n->ssa> = udiv <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>    
  <n->ssa> = udiv exact <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>      
```