
```



case class L_Xor(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "xor"
}


```

**Overview:**

Constructs a 'xor' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

For further information see the LLVM Assembly Reference Manual - ['xor' Instruction](http://llvm.org/docs/LangRef.html#i_xor)

**Arguments:**

The two arguments to the 'xor' instruction must be integer or vector of integer values. Both arguments must have identical types.

**Semantics:**

The 'xor' instruction returns the bitwise logical exclusive or of its two operands. The xor is used to implement the "one's complement" operation, which is the "~" operator in C.

**Emitted LLVM IR:**
```
For an 'xor' instruction 'n':

  <n->ssa> = xor <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>         
```