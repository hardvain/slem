
```



abstract class L_FCMP(LHSin : L_Value, 
                      RHSin : L_Value, 
                 compCodein : String) 
               extends L_Instruction with L_Value
{
    val LHS = LHSin
    val RHS = RHSin
    val compCode = compCodein
}	
case class L_FCmpFalse(LHSin : L_Value, 
                       RHSin : L_Value) 
           extends L_FCMP(LHSin, RHSin, "false")
    
case class L_FCmpOEQ(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_FCMP(LHSin, RHSin, "oeq")
    
case class L_FCmpOGT(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_FCMP(LHSin, RHSin, "ogt")
    
case class L_FCmpOGE(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_FCMP(LHSin, RHSin, "oge")
    
case class L_FCmpOLT(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_FCMP(LHSin, RHSin, "olt")
    
case class L_FCmpONE(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_FCMP(LHSin, RHSin, "one")
    
case class L_FCmpORD(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_FCMP(LHSin, RHSin, "ord")
    
case class L_FCmpUEQ(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_FCMP(LHSin, RHSin, "ueq")
    
case class L_FCmpUGT(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_FCMP(LHSin, RHSin, "ugt")
    
case class L_FCmpUGE(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_FCMP(LHSin, RHSin, "uge")
    
case class L_FCmpULT(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_FCMP(LHSin, RHSin, "ult")
    
case class L_FCmpULE(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_FCMP(LHSin, RHSin, "ule")
    
case class L_FCmpUNE(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_FCMP(LHSin, RHSin, "une")
    
case class L_FCmpUNO(LHSin : L_Value, 
                     RHSin : L_Value) 
           extends L_FCMP(LHSin, RHSin, "uno")
    
case class L_FCmpTrue(LHSin : L_Value, 
                      RHSin : L_Value) 
           extends L_FCMP(LHSin, RHSin, "true")



```

**Overview:**

Constructs an 'fcmp' instruction.

The 'fcmp' instruction returns a boolean value or vector of boolean values based on comparison of its operands.

If the operands are floating point scalars, then the result type is a boolean (i1).

If the operands are floating point vectors, then the result type is a vector of boolean with the same number of elements as the operands being compared.

For further information see the LLVM Assembly Reference Manual - ['icmp' Instruction](http://llvm.org/docs/LangRef.html#i_icmp)

**Arguments:**

The 'fcmp' instruction takes three operands. The first operand is the condition code indicating the kind of comparison to perform. It is not a value, just a keyword. The possible condition code are:

  1. false: no comparison, always returns false
  1. oeq: ordered and equal
  1. ogt: ordered and greater than
  1. oge: ordered and greater than or equal
  1. olt: ordered and less than
  1. ole: ordered and less than or equal
  1. one: ordered and not equal
  1. ord: ordered (no nans)
  1. ueq: unordered or equal
  1. ugt: unordered or greater than
  1. uge: unordered or greater than or equal
  1. ult: unordered or less than
  1. ule: unordered or less than or equal
  1. une: unordered or not equal
  1. uno: unordered (either nans)
  1. true: no comparison, always returns true

Ordered means that neither operand is a QNAN while unordered means that either operand may be a QNAN.

Each of val1 and val2 arguments must be either a floating point type or a vector of floating point type. They must have identical types.

**Semantics:**

The 'fcmp' instruction compares op1 and op2 according to the condition code given as cond. If the operands are vectors, then the vectors are compared element by element. Each comparison performed always yields an i1 result, as follows:

  1. false: always yields false, regardless of operands.
  1. oeq: yields true if both operands are not a QNAN and op1 is equal to op2.
  1. ogt: yields true if both operands are not a QNAN and op1 is greater than op2.
  1. oge: yields true if both operands are not a QNAN and op1 is greater than or equal to op2.
  1. olt: yields true if both operands are not a QNAN and op1 is less than op2.
  1. ole: yields true if both operands are not a QNAN and op1 is less than or equal to op2.
  1. one: yields true if both operands are not a QNAN and op1 is not equal to op2.
  1. ord: yields true if both operands are not a QNAN.
  1. ueq: yields true if either operand is a QNAN or op1 is equal to op2.
  1. ugt: yields true if either operand is a QNAN or op1 is greater than op2.
  1. uge: yields true if either operand is a QNAN or op1 is greater than or equal to op2.
  1. ult: yields true if either operand is a QNAN or op1 is less than op2.
  1. ule: yields true if either operand is a QNAN or op1 is less than or equal to op2.
  1. une: yields true if either operand is a QNAN or op1 is not equal to op2.
  1. uno: yields true if either operand is a QNAN.
  1. true: always yields true, regardless of operands.

Note that the code generator does not yet support vector types with the fcmp instruction.

**Emitted LLVM IR:**
```
For a 'fcmp' instruction 'n':

  <n->ssa> = fcmp <compCode> <encodeType(LHSin->resultType)> <encodeValue(LHSin)>, 
             <encodeValue(RHSin)>    
    
```