
```



case class L_ValueLabel(value : L_Value, label : L_Label) extends L_Node
    
case class L_Phi(valueLabels : List[L_ValueLabel]) extends L_Instruction with L_Value


```

**Overview:**

Constructs an 'phi' instruction.

The 'phi' instruction is used to implement the φ node in the SSA graph representing the function.

For further information see the LLVM Assembly Reference Manual - ['phi .. to' Instruction](http://llvm.org/docs/LangRef.html#i_phi)

**Arguments:**

The type of the incoming values is specified with the first type field. After this, the 'phi' instruction takes a list of pairs as arguments, with one pair for each predecessor basic block of the current block. Only values of first class type may be used as the value arguments to the PHI node. Only labels may be used as the label arguments.

There must be no non-phi instructions between the start of a basic block and the PHI instructions: i.e. PHI instructions must be first in a basic block.

For the purposes of the SSA form, the use of each incoming value is deemed to occur on the edge from the corresponding predecessor block to the current block (but after any definition of an 'invoke' instruction's return value on the same edge).

**Semantics:**

At runtime, the 'phi' instruction logically takes on the value specified by the pair corresponding to the predecessor basic block that executed just prior to the current block.

**Emitted LLVM IR:**
```
For a 'phi' instruction 'n':

  <n->ssa> = phi <encodeType(valueLabels(0)->resultType)>  
             [<encodeValue(valueLabels(0).value)> <encodeLabel(valueLabels(0).label)>],
             [<encodeValue(valueLabels(1).value)> <encodeLabel(valueLabels(1).label)>],
             ...
 
    
```