
```



case class L_Add(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin)
{
    override val instructionString = "add"
}
    
case class L_NSWAdd(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin)
{
    override val instructionString = "add nsw"
}
    
case class L_NUWAdd(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin)
{
    override val instructionString = "add nuw"
}
    
case class L_NUWNSWAdd(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin)
{
    override val instructionString = "add nuw nsw"
}

```
**Overview**:

Constructs an 'add' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

The various classes represent the configurations for no signed wrap/no unsigned wrap for this add instruction - see the LLVM Assembly Reference Manual - ['add' Instruction](http://llvm.org/docs/LangRef.html#i_add)

**Arguments:**

The two arguments to the 'add' instruction must be integer or vector of integer values. Both arguments must have identical types.

**Semantics**:

The value produced is the integer sum of the two operands.

If the sum has unsigned overflow, the result returned is the mathematical result modulo 2n, where n is the bit width of the result.

Because LLVM integers use a two's complement representation, this instruction is appropriate for both signed and unsigned integers.

nuw and nsw stand for "No Unsigned Wrap" and "No Signed Wrap", respectively. If the nuw and/or nsw keywords are present, the result value of the add is a trap value if unsigned and/or signed overflow, respectively, occurs.

**Emitted LLVM IR:**
```
For an add instruction 'n':

  <n->ssa> = add <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>        
  <n->ssa> = add nuw <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>    
  <n->ssa> = add nsw <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>    
  <n->ssa> = add nuw nsw <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>
```