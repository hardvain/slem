
```



case class L_Shl(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "shl"
}

case class L_NUWShl(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "shl nuw"
}

case class L_NSWShl(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "shl nsw"
}

case class L_NUWNSWShl(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "shl nuw nsw"
}



```

**Overview:**

Constructs an 'shl' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

For further information see the LLVM Assembly Reference Manual - ['shl' Instruction](http://llvm.org/docs/LangRef.html#i_shl)

**Arguments:**

Both arguments to the 'shl' instruction must be the same integer or vector of integer type. 'op2' is treated as an unsigned value.

**Semantics:**

The 'shl' instruction returns the first operand shifted to the left a specified number of bits.

The value produced is op1 `*` 2op2 mod 2n, where n is the width of the result. If op2 is (statically or dynamically) negative or equal to or larger than the number of bits in op1, the result is undefined. If the arguments are vectors, each vector element of op1 is shifted by the corresponding shift amount in op2.

If the nuw keyword is present, then the shift produces a trap value if it shifts out any non-zero bits. If the nsw keyword is present, then the shift produces a trap value if it shifts out any bits that disagree with the resultant sign bit. As such, NUW/NSW have the same semantics as they would if the shift were expressed as a mul instruction with the same nsw/nuw bits in (mul %op1, (shl 1, %op2)).

**Emitted LLVM IR:**
```
For a shl instruction 'n':

  <n->ssa> = shl <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>     
  <n->ssa> = shl nuw <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>    
  <n->ssa> = shl nsw <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>    
  <n->ssa> = shl nuw nsw <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>        
```