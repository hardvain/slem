
```



case class L_LShr(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "lshr"
}

case class L_ExactLShr(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "lshr exact"
}



```

**Overview:**

Constructs an 'lshr' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

For further information see the LLVM Assembly Reference Manual - ['lshr' Instruction](http://llvm.org/docs/LangRef.html#i_lshr)

**Arguments:**

Both arguments to the 'lshr' instruction must be the same integer or vector of integer type. 'op2' is treated as an unsigned value.

**Semantics:**

This instruction always performs a logical shift right operation. The most significant bits of the result will be filled with zero bits after the shift. If op2 is (statically or dynamically) equal to or larger than the number of bits in op1, the result is undefined. If the arguments are vectors, each vector element of op1 is shifted by the corresponding shift amount in op2.

If the exact keyword is present, the result value of the lshr is a trap value if any of the bits shifted out are non-zero.

**Emitted LLVM IR:**
```
For a lshr instruction 'n':

  <n->ssa> = lshr <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>  
  <n->ssa> = lshr exact <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>       
```