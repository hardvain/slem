
```



case class L_AShr(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "ashr"
}

case class L_ExactAShr(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "ashr exact"
}    



```

**Overview:**

Constructs an 'ashr' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

For further information see the LLVM Assembly Reference Manual - ['ashr' Instruction](http://llvm.org/docs/LangRef.html#i_ashr)

**Arguments:**

Both arguments to the 'ashr' instruction must be the same integer or vector of integer type. 'op2' is treated as an unsigned value.

**Semantics:**

The 'ashr' instruction (arithmetic shift right) returns the first operand shifted to the right a specified number of bits with sign extension.

This instruction always performs an arithmetic shift right operation, The most significant bits of the result will be filled with the sign bit of op1. If op2 is (statically or dynamically) equal to or larger than the number of bits in op1, the result is undefined. If the arguments are vectors, each vector element of op1 is shifted by the corresponding shift amount in op2.

If the exact keyword is present, the result value of the ashr is a trap value if any of the bits shifted out are non-zero.

**Emitted LLVM IR:**
```
For an ashr instruction 'n':

  <n->ssa> = ashr <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>  
  <n->ssa> = ashr exact <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>       
```