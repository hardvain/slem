
```
abstract class L_TerminatorInstruction extends L_Instruction
```

Superclass of all LLVM Terminator Instructions in SLEM

A LLVM block _**must**_ have a terminator instruction defined and passed as a parameter to its constructor.

For further general information refer to the LLVM Assembly Language Reference Manual - [Terminator Instructions](http://llvm.org/docs/LangRef.html#terminators)