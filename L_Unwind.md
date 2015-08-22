
```



case class L_Unwind() extends L_TerminatorInstruction



```

**Overview:**

Constructs a 'unwind' terminator instruction.

For further information see the LLVM Assembly Reference Manual - ['unwind' Instruction](http://llvm.org/docs/LangRef.html#i_unwind)

**Arguments:**

None.

**Semantics:**

The 'unwind' instruction causes execution of the current function to immediately halt. The dynamic call stack is then searched for the first invoke instruction on the call stack. Once found, execution continues at the "exceptional" destination block specified by the invoke instruction. If there is no invoke instruction in the dynamic call chain, undefined behavior results.

Note that the code generator does not yet completely support unwind, and that the invoke/unwind semantics are likely to change in future versions.

**Emitted LLVM IR:**
```
For a unwind terminator instruction:

  unwind
```