
```



case class L_Store(value : L_Value, 
                 pointer : L_Value, 
              isVolatile : Boolean = false, 
               alignment : Long = 0) 
           extends L_Instruction




```

**Overview:**

Constructs a 'store' instruction.

The 'store' instruction is used to write to memory.

For further information see the LLVM Assembly Reference Manual - ['store' Instruction](http://llvm.org/docs/LangRef.html#i_store)

**Arguments:**

There are two arguments to the 'store' instruction: a value to store and an address at which to store it. The type of the '`<`pointer>' operand must be a pointer to the first class type of the '`<`value>' operand. If the store is marked as volatile, then the optimizer is not allowed to modify the number or order of execution of this store with other volatile operations.

The optional constant "align" argument specifies the alignment of the operation (that is, the alignment of the memory address). A value of 0 or an omitted "align" argument means that the operation has the preferential alignment for the target. It is the responsibility of the code emitter to ensure that the alignment information is correct. Overestimating the alignment results in an undefined behavior. Underestimating the alignment may produce less efficient code. An alignment of 1 is always safe.

The optional !nontemporal metadata must reference a single metatadata name `<`index> corresponding to a metadata node with one i32 entry of value 1. The existence of the !nontemporal metatadata on the instruction tells the optimizer and code generator that this load is not expected to be reused in the cache. The code generator may select special instructions to save cache bandwidth, such as the MOVNT instruction on x86.

**Semantics:**

The contents of memory are updated to contain '`<`value>' at the location specified by the '`<`pointer>' operand. If '`<`value>' is of scalar type then the number of bytes written does not exceed the minimum number of bytes needed to hold all bits of the type. For example, storing an i24 writes at most three bytes. When writing a value of a type like i20 with a size that is not an integral number of bytes, it is unspecified what happens to the extra bits that do not belong to the type, but they will typically be overwritten.

**Emitted LLVM IR:**
```
For a store instruction 'n':

  <n->ssa> = [volatile ]store <encodeType(value->resultType)> <encodeValue(value)>, 
             <encodeType(pointer->resultType)> <encodeValue(pointer)>
             [, align <alignment>]
             [, !nontemporal !<index>] 

```