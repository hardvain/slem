
```



case class L_FAdd(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "fadd"
}


```

**Overview:**

Constructs an 'fadd' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

For further information see the LLVM Assembly Reference Manual - ['fadd' Instruction](http://llvm.org/docs/LangRef.html#i_fadd)

**Arguments:**

The two arguments to the 'fadd' instruction must be floating point or vector of floating point values. Both arguments must have identical types.

**Semantics:**

The value produced is the floating point sum of the two operands.

**Emitted LLVM IR:**
```
For a fadd instruction 'n':

  <n->ssa> = fadd <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>    
    
```