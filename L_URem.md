
```



case class L_URem(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "urem"
}


```

**Overview:**

Constructs an 'urem' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

For further information see the LLVM Assembly Reference Manual - ['urem' Instruction](http://llvm.org/docs/LangRef.html#i_urem)

**Arguments:**

The two arguments to the 'urem' instruction must be integer or vector of integer values. Both arguments must have identical types.

**Semantics:**

This instruction returns the unsigned integer remainder of a division. This instruction always performs an unsigned division to get the remainder.

Note that unsigned integer remainder and signed integer remainder are distinct operations; for signed integer remainder, use 'srem'.

Taking the remainder of a division by zero leads to undefined behavior.

**Emitted LLVM IR:**
```
For a urem instruction 'n':

  <n->ssa> = urem <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>         
```