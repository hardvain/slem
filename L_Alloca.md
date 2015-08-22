
```



case class L_Alloca(typ : L_Type, 
            numElements : L_Value = null, 
              alignment : Long = 0) 
     extends L_Instruction with L_Value




```

**Overview:**

Constructs a 'alloca' instruction.

The 'alloca' instruction allocates memory on the stack frame of the currently executing function, to be automatically released when this function returns to its caller. The object is always allocated in the generic address space (address space zero).

For further information see the LLVM Assembly Reference Manual - ['alloca' Instruction](http://llvm.org/docs/LangRef.html#i_alloca)

**Arguments:**

The 'alloca' instruction allocates sizeof(typ) `*` NumElements bytes of memory on the runtime stack, returning a pointer of the appropriate type to the program. If NumElements is specified, it is the number of elements allocated, otherwise NumElements is defaulted to be one. If a constant alignment is specified, the value result of the allocation is guaranteed to be aligned to at least that boundary. If not specified, or if zero, the target can choose to align the allocation on any convenient boundary compatible with the type.

'typ' may be any sized type.

**Semantics:**

Memory is allocated; a pointer is returned. The operation is undefined if there is insufficient stack space for the allocation. 'alloca'd memory is automatically released when the function returns. The 'alloca' instruction is commonly used to represent automatic variables that must have an address available. When the function returns (either with the ret or unwind instructions), the memory is reclaimed. Allocating zero bytes is legal, but the result is undefined.

**Emitted LLVM IR:**
```
For an alloca instruction 'n':

  <n->ssa> = alloca <encodeType(typ)>
             [, <encodeType(numElements->resultType)> <encodeValue(NumElements)>]
             [, align <alignment>]  

```