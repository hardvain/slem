
```



case class L_Load(typ : L_Type, 
              pointer : L_Value, 
           isVolatile : Boolean = false, 
            alignment : Long = 0) 
           extends L_Instruction with L_Value





```

**Overview:**

Constructs a 'load' instruction.

The 'load' instruction is used to read from memory.

For further information see the LLVM Assembly Reference Manual - ['load' Instruction](http://llvm.org/docs/LangRef.html#i_load)

**Arguments:**

The argument to the 'load' instruction specifies the memory address from which to load. The pointer must point to a first class type. If the load is marked as volatile, then the optimizer is not allowed to modify the number or order of execution of this load with other volatile operations.

The optional constant align argument specifies the alignment of the operation (that is, the alignment of the memory address). A value of 0 or an omitted align argument means that the operation has the preferential alignment for the target. It is the responsibility of the code emitter to ensure that the alignment information is correct. Overestimating the alignment results in undefined behavior. Underestimating the alignment may produce less efficient code. An alignment of 1 is always safe.

The optional !nontemporal metadata must reference a single metatadata name `<`index> corresponding to a metadata node with one i32 entry of value 1. The existence of the !nontemporal metatadata on the instruction tells the optimizer and code generator that this load is not expected to be reused in the cache. The code generator may select special instructions to save cache bandwidth, such as the MOVNT instruction on x86.

**Semantics:**

The location of memory pointed to is loaded. If the value being loaded is of scalar type then the number of bytes read does not exceed the minimum number of bytes needed to hold all bits of the type. For example, loading an i24 reads at most three bytes. When loading a value of a type like i20 with a size that is not an integral number of bytes, the result is undefined if the value was not originally written using a store of the same type.

**Emitted LLVM IR:**
```
For an load instruction 'n':

  <n->ssa> = [volatile ]load <encodeType(typ)> <encodeValue(pointer)>
             [, align <alignment>]
             [, !nontemporal !<index>]  

```