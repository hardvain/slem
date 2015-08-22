
```
////////////VALUES////////////
trait L_Value extends L_Node
```
Trait possessed by all LLVM "Values". A value in SLEM is anything that can be resolved to a ssa in LLVM - Typically the result returned from an [instruction](L_Instruction.md), but can also include [functions](L_Function.md) (for use as a [function](L_Function.md) pointer in [instructions](L_Instruction.md) that call a [function](L_Function.md)), or [global variables](L_GlobalVariable.md).