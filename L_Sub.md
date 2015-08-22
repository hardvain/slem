
```



case class L_Sub(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "sub"
}
    
case class L_NSWSub(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "sub nsw"
}
    
case class L_NUWSub(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "sub nuw"
}
    
case class L_NUWNSWSub(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "sub nuw nsw"
}

```
**Overview**:

Constructs a 'sub' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

The various classes represent the configurations for no signed wrap/no unsigned wrap for this add instruction - see the LLVM Assembly Reference Manual - ['sub' Instruction](http://llvm.org/docs/LangRef.html#i_sub)

**Arguments**:

The two arguments to the 'sub' instruction must be integer or vector of integer values. Both arguments must have identical types.

**Semantics**:

The value produced is the integer difference of the two operands.

If the difference has unsigned overflow, the result returned is the mathematical result modulo 2n, where n is the bit width of the result.

Because LLVM integers use a two's complement representation, this instruction is appropriate for both signed and unsigned integers.

nuw and nsw stand for "No Unsigned Wrap" and "No Signed Wrap", respectively. If the nuw and/or nsw keywords are present, the result value of the sub is a trap value if unsigned and/or signed overflow, respectively, occurs.

**Emitted LLVM IR:**
```
For a 'sub' instruction 'n':

  <n->ssa> = sub <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>        
  <n->ssa> = sub nuw <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>    
  <n->ssa> = sub nsw <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>    
  <n->ssa> = sub nuw nsw <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>
```