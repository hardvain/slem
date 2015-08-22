
```



case class L_Ret(rvalue : L_Value) extends L_TerminatorInstruction


```

**Overview:**

Constructs a 'ret' terminator instruction. Takes a single value as a parameter for the return value.

For further information see the LLVM Assembly Reference Manual - ['ret' Instruction](http://llvm.org/docs/LangRef.html#i_ret)

**Arguments:**

The 'ret' instruction optionally accepts a single argument, the return value. The type of the return value must be a 'first class' type.

A function is not well formed if it it has a non-void return type and contains a 'ret' instruction with no return value or a return value with a type that does not match its type, or if it has a void return type and contains a 'ret' instruction with a return value.

**Semantics:**

When the 'ret' instruction is executed, control flow returns back to the calling function's context. If the caller is a "call" instruction, execution continues at the instruction after the call. If the caller was an "invoke" instruction, execution continues at the beginning of the "normal" destination block. If the instruction returns a value, that value shall set the call or invoke instruction's return value.

**Emitted LLVM IR:**
```
For a ret terminator instruction:

  ret <rvalue->resultType> <encodeValue(rvalue)>
```