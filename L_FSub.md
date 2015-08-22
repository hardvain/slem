
```



case class L_FSub(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "fsub"
}


```

**Overview:**

Constructs an 'fsub' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

For further information see the LLVM Assembly Reference Manual - ['fsub' Instruction](http://llvm.org/docs/LangRef.html#i_fsub)

**Arguments:**

The two arguments to the 'fsub' instruction must be floating point or vector of floating point values. Both arguments must have identical types.

**Semantics:**

The value produced is the floating point difference of the two operands.

**Emitted LLVM IR:**
```
For a fsub instruction 'n':

  <n->ssa> = fsub <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>    
    
```