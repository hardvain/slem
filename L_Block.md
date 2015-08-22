# LLVM Blocks #

```
case class L_Block(
  instructions : List[L_Instruction], 
  terminator : L_TerminatorInstruction, 
  label : L_Label = L_Label("")
) extends L_Node
```

LLVM Blocks are simple to construct in SLEM. All LLVM Blocks _**must**_ have a (possibly empty) list of **[instructions](L_Instruction.md)**, and a **[terminator instruction](L_TerminatorInstruction.md)**.

Slem will automatically generate [label](L_Label.md) names for blocks, but you may choose to set the block [label](L_Label.md) name using the optional parameter "label" if you wish.




### Constructing a very simple block ###
Block in LLVM IR
```
%0 = add i32 1, 2
ret %0
```
Block definition in SLEM
```
val addInstr = L_Add(1,2)
val retInstr = L_Ret(addinstr)
val myBlock = L_Block(List(addInstr), retInstr))
```

### Manually setting a block's label ###
Block in LLVM IR
```
myblockname:
  %0 = add i32 1, 2
  ret %0
```
Block definition in SLEM
```
val addInstr = L_Add(1,2)
val retInstr = L_Ret(addinstr)
val myBlockLabel : L_Label = "myblockname"
val myBlock = L_Block(List(addInstr), retInstr), myBlockLabel)
```