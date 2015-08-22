
```



case class L_IndirectBr(address : L_Value, possibleDestinations : List[L_Label]) extends L_TerminatorInstruction



```

**Overview:**

Constructs a 'indirectbr' terminator instruction. Consists of a value for the address of the location to branch to, as well as a list of all possible destinations

The address branched to must be derived from a blockaddress constant.

For further information see the LLVM Assembly Reference Manual - ['indirectbr' Instruction](http://llvm.org/docs/LangRef.html#i_indirectbr)

**Arguments:**

The 'address' argument is the address of the label to jump to. The rest of the arguments indicate the full set of possible destinations that the address may point to. Blocks are allowed to occur multiple times in the destination list, though this isn't particularly useful.

This destination list is required so that dataflow analysis has an accurate understanding of the CFG.

**Semantics:**

Control transfers to the block specified in the address argument. All possible destination blocks must be listed in the label list, otherwise this instruction has undefined behavior. This implies that jumps to labels defined in other functions have undefined behavior as well.

**Emitted LLVM IR:**
```
For a indirectbr terminator instruction:

  indirectbr <encodeType(address->resultType)> <encodeValue(address)>
        [ label <encodeValue(possibleDestinations(1).dest)> , ... ]
```