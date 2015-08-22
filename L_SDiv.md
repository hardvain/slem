
```



case class L_SDiv(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "sdiv"
}

case class L_ExactSDiv(LHSin : L_Value, RHS : L_Value) extends L_BinOpInstruction(LHSin, RHSin)
{
    override val instructionString = "sdiv exact"
}



```

**Overview:**

Constructs an 'sdiv' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

For further information see the LLVM Assembly Reference Manual - ['sdiv' Instruction](http://llvm.org/docs/LangRef.html#i_sdiv)

**Arguments:**

The two arguments to the 'sdiv' instruction must be integer or vector of integer values. Both arguments must have identical types.

**Semantics:**

The value produced is the signed integer quotient of the two operands rounded towards zero.

Note that signed integer division and unsigned integer division are distinct operations; for unsigned integer division, use 'udiv'.

Division by zero leads to undefined behavior. Overflow also leads to undefined behavior; this is a rare case, but can occur, for example, by doing a 32-bit division of -2147483648 by -1.

If the exact keyword is present, the result value of the sdiv is a trap value if the result would be rounded.

**Emitted LLVM IR:**
```
For a sdiv instruction 'n':

  <n->ssa> = sdiv <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>    
  <n->ssa> = sdiv exact <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>      
```