
```



case class L_Unreachable() extends L_TerminatorInstruction



```

**Overview:**

Constructs a 'unreachable' terminator instruction.

For further information see the LLVM Assembly Reference Manual - ['unreachable' Instruction](http://llvm.org/docs/LangRef.html#i_unreachable)

**Arguments:**

None.

**Semantics:**

The 'unreachable' instruction has no defined semantics. This instruction is used to inform the optimizer that a particular portion of the code is not reachable. This can be used to indicate that the code after a no-return function cannot be reached, and other facts.

**Emitted LLVM IR:**
```
For a unwind terminator instruction:

  unreachable
```