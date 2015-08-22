
```
case class L_Module(globals : List[L_Global]) extends L_Node
```
A LLVM Module in SLEM is defined as a list of [globals](L_Global.md).

Refer to the LLVM Assembly Language Reference Manual - [Module Structure](http://llvm.org/docs/LangRef.html#modulestructure)