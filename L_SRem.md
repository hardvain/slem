
```



case class L_SRem(LHSin : L_Value, RHSin : L_Value) extends L_BinOpInstruction(LHSin, RHSin) 
{
    override val instructionString = "srem"
}


```

**Overview:**

Constructs an 'srem' instruction. Takes a pair of values for LHS/RHS respectively as parameters.

For further information see the LLVM Assembly Reference Manual - ['srem' Instruction](http://llvm.org/docs/LangRef.html#i_srem)

**Arguments:**

The two arguments to the 'srem' instruction must be integer or vector of integer values. Both arguments must have identical types.

**Semantics:**

This instruction returns the remainder of a division (where the result has the same sign as the dividend, op1), not the modulo operator (where the result has the same sign as the divisor, op2) of a value. For more information about the difference, see The Math Forum. For a table of how this is implemented in various languages, please see Wikipedia: modulo operation.

Note that signed integer remainder and unsigned integer remainder are distinct operations; for unsigned integer remainder, use 'urem'.

Taking the remainder of a division by zero leads to undefined behavior. Overflow also leads to undefined behavior; this is a rare case, but can occur, for example, by taking the remainder of a 32-bit division of -2147483648 by -1. (The remainder doesn't actually overflow, but this rule lets srem be implemented using instructions that return both the result of the division and the remainder.)

**Emitted LLVM IR:**
```
For a srem instruction 'n':

  <n->ssa> = srem <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, <encodeValue(RHSin)>         
```