
```



case class L_Mul(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin)
{
    override val instructionString = "mul"
}
    
case class L_NSWMul(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin)
{
    override val instructionString = "mul nsw"
}
    
case class L_NUWMul(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin)
{
    override val instructionString = "mul nuw"
}
    
case class L_NUWNSWMul(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin)
{
    override val instructionString = "mul nuw nsw"
}

```
**Overview**:

Constructs a 'mul' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

The various classes represent the configurations for no signed wrap/no unsigned wrap for this mul instruction - see the LLVM Assembly Reference Manual - ['mul' Instruction](http://llvm.org/docs/LangRef.html#i_mul)

**Arguments**:

The two arguments to the 'mul' instruction must be integer or vector of integer values. Both arguments must have identical types.

**Semantics**:

The value produced is the integer product of the two operands.

If the result of the multiplication has unsigned overflow, the result returned is the mathematical result modulo 2n, where n is the bit width of the result.

Because LLVM integers use a two's complement representation, and the result is the same width as the operands, this instruction returns the correct result for both signed and unsigned integers. If a full product (e.g. i32xi32->i64) is needed, the operands should be sign-extended or zero-extended as appropriate to the width of the full product.

nuw and nsw stand for "No Unsigned Wrap" and "No Signed Wrap", respectively. If the nuw and/or nsw keywords are present, the result value of the mul is a trap value if unsigned and/or signed overflow, respectively, occurs.

**Emitted LLVM IR:**
```
For a mul instruction 'n':

  <n->ssa> = mul <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>        
  <n->ssa> = mul nuw <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>    
  <n->ssa> = mul nsw <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>    
  <n->ssa> = mul nuw nsw <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>
```