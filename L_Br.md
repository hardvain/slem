
```



case class L_Br(dest : L_Label) extends L_TerminatorInstruction

//Conditional Branch
case class L_BrCond(cond : L_Value, ifTrue : L_Label, ifFalse : L_Label) extends L_TerminatorInstruction


```

**Overview:**

L\_Br Constructs a 'br' terminator instruction.

Use L\_BrCond to construct a conditional branch - pass the condition value as cond, and destination labels to ifTrue/ifFalse as parameters.

For further information see the LLVM Assembly Reference Manual - ['br' Instruction](http://llvm.org/docs/LangRef.html#i_br)

**Arguments:**

The conditional branch form of the 'br' instruction takes a single 'i1' value and two 'label' values. The unconditional form of the 'br' instruction takes a single 'label' value as a target.

**Semantics:**

Upon execution of a conditional 'br' instruction, the 'i1' argument is evaluated. If the value is true, control flows to the 'iftrue' label argument. If "cond" is false, control flows to the 'iffalse' label argument.

**Emitted LLVM IR:**
```
For an unconditional br terminator instruction:
  br label <encodeValue(dest)>

For a conditional br terminator instruction:
  br <cond->resultType> <encodeValue(cond)>, label <encodeValue(ifTrue)>, label <encodeValue(ifFalse)>
```