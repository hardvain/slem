
```



case class L_FMul(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "fmul"
}


```

**Overview:**

Constructs an 'fmul' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

For further information see the LLVM Assembly Reference Manual - ['fmul' Instruction](http://llvm.org/docs/LangRef.html#i_fmul)

**Arguments:**

The two arguments to the 'fmul' instruction must be floating point or vector of floating point values. Both arguments must have identical types.

**Semantics:**

The value produced is the floating point product of the two operands.

**Emitted LLVM IR:**
```
For a fmul instruction 'n':

  <n->ssa> = fmul <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>    
    
```