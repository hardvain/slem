
```



case class L_Invoke(
    funcPtrVal : L_Value,      
    args : List[L_Argument],
    normal : L_Label,
    unwind : L_Label,
    funcTypePtr : L_Type = null,          //Optional
    callConv : String = "",               //Optional
    retAttrs : List[String] = List(),     //Optional
    attrs : List[String] = List()         //Optional
    ) extends L_TerminatorInstruction with L_Value



```

**Overview:**

Constructs a 'invoke' terminator instruction.

The field funcTypePtr is an optional function pointer type which is required where there is ambiguity - such as varargs fns.

For further information see the LLVM Assembly Reference Manual - ['invoke' Instruction](http://llvm.org/docs/LangRef.html#i_invoke)

**Arguments:**

This instruction requires several arguments:

  1. The optional "cconv" marker indicates which calling convention the call should use. If none is specified, the call defaults to using C calling conventions.
  1. The optional Parameter Attributes list for return values. Only 'zeroext', 'signext', and 'inreg' attributes are valid here.
  1. 'ptr to function ty': shall be the signature of the pointer to function value being invoked. In most cases, this is a direct function invocation, but indirect invokes are just as possible, branching off an arbitrary pointer to function value.
  1. 'function ptr val': An LLVM value containing a pointer to a function to be invoked.
  1. 'function args': argument list whose types match the function signature argument types and parameter attributes. All arguments must be of first class type. If the function signature indicates the function accepts a variable number of arguments, the extra arguments can be specified.
  1. 'normal label': the label reached when the called function executes a 'ret' instruction.
  1. 'exception label': the label reached when a callee returns with the unwind instruction.
  1. The optional function attributes list. Only 'noreturn', 'nounwind', 'readonly' and 'readnone' attributes are valid here.

**Semantics:**

This instruction is designed to operate as a standard 'call' instruction in most regards. The primary difference is that it establishes an association with a label, which is used by the runtime library to unwind the stack.

This instruction is used in languages with destructors to ensure that proper cleanup is performed in the case of either a longjmp or a thrown exception. Additionally, this is important for implementation of 'catch' clauses in high-level languages that support them.

For the purposes of the SSA form, the definition of the value returned by the 'invoke' instruction is deemed to occur on the edge from the current block to the "normal" label. If the callee unwinds then no return value is available.

Note that the code generator does not yet completely support unwind, and that the invoke/unwind semantics are likely to change in future versions.

**Emitted LLVM IR:**
```
For a invoke terminator instruction:

<result> = invoke [cconv] [ret attrs] <ptr to function ty> <function ptr val>(<function args>) 
           [fn attrs] to label <normal label> unwind label <exception label>
```