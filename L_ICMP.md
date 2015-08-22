
```



abstract class L_ICMP(LHSin : L_Value, 
                      RHSin : L_Value, 
                 compCodein : String) 
               extends L_Instruction with L_Value
{
    val LHS = LHSin
    val RHS = RHSin
    val compCode = compCodein
}

case class L_ICmpEQ(LHSin : L_Value, 
                    RHSin : L_Value) 
           extends L_ICMP(LHSin, RHSin, "eq")

case class L_ICmpNEQ(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_ICMP(LHSin, RHSin, "ne")

case class L_ICmpNE(LHSin : L_Value, 
                    RHSin : L_Value) 
           extends L_ICMP(LHSin, RHSin, "ne")

case class L_ICmpUGT(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_ICMP(LHSin, RHSin, "ugt")

case class L_ICmpUGE(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_ICMP(LHSin, RHSin, "uge")

case class L_ICmpULT(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_ICMP(LHSin, RHSin, "ult")

case class L_ICmpULE(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_ICMP(LHSin, RHSin, "ule")

case class L_ICmpSGT(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_ICMP(LHSin, RHSin, "sgt")

case class L_ICmpSGE(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_ICMP(LHSin, RHSin, "sge")

case class L_ICmpSLT(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_ICMP(LHSin, RHSin, "slt")

case class L_ICmpSLE(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_ICMP(LHSin, RHSin, "sle")


```

**Overview:**

Constructs an 'icmp' instruction.

The 'icmp' instruction returns a boolean value or a vector of boolean values based on comparison of its two integer, integer vector, or pointer operands.

For further information see the LLVM Assembly Reference Manual - ['icmp' Instruction](http://llvm.org/docs/LangRef.html#i_icmp)

**Arguments:**

The 'icmp' instruction takes three operands. The first operand is the condition code indicating the kind of comparison to perform. It is not a value, just a keyword. The possible condition code are:

  1. eq: equal
  1. ne: not equal
  1. ugt: unsigned greater than
  1. uge: unsigned greater or equal
  1. ult: unsigned less than
  1. ule: unsigned less or equal
  1. sgt: signed greater than
  1. sge: signed greater or equal
  1. slt: signed less than
  1. sle: signed less or equal

The remaining two arguments must be integer or pointer or integer vector typed. They must also be identical types.

**Semantics:**

The 'icmp' compares op1 and op2 according to the condition code given as cond. The comparison performed always yields either an i1 or vector of i1 result, as follows:

  1. eq: yields true if the operands are equal, false otherwise. No sign interpretation is necessary or performed.
  1. ne: yields true if the operands are unequal, false otherwise. No sign interpretation is necessary or performed.
  1. ugt: interprets the operands as unsigned values and yields true if op1 is greater than op2.
  1. uge: interprets the operands as unsigned values and yields true if op1 is greater than or equal to op2.
  1. ult: interprets the operands as unsigned values and yields true if op1 is less than op2.
  1. ule: interprets the operands as unsigned values and yields true if op1 is less than or equal to op2.
  1. sgt: interprets the operands as signed values and yields true if op1 is greater than op2.
  1. sge: interprets the operands as signed values and yields true if op1 is greater than or equal to op2.
  1. slt: interprets the operands as signed values and yields true if op1 is less than op2.
  1. sle: interprets the operands as signed values and yields true if op1 is less than or equal to op2.

If the operands are pointer typed, the pointer values are compared as if they were integers.

If the operands are integer vectors, then they are compared element by element. The result is an i1 vector with the same number of elements as the values being compared. Otherwise, the result is an i1.

**Emitted LLVM IR:**
```
For a 'icmp' instruction 'n':

  <n->ssa> = icmp <compCode> <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, 
             <encodeValue(RHSin)>    
    
```