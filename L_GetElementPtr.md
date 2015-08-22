
```



case class L_GetElementPtr(pty : L_Type, 
                          pval : L_Value, 
                   typeIndexes : List[L_Value], 
                      inBounds : Boolean = false) 
           extends L_Instruction with L_Value
    



```

**Overview:**

The 'getelementptr' instruction is used to get the address of a subelement of an aggregate data structure. It performs address calculation only and does not access memory.

For further information see the LLVM Assembly Reference Manual - ['getelementptr' Instruction](http://llvm.org/docs/LangRef.html#i_getelementptr)

**Emitted LLVM IR:**
```
For a getelementptr instruction 'n':

  <n->ssa> = getelementptr [inbounds ] <encodeType(pty)> <encodeValue(pval)>, 
             {<encodeType(typeIndexes(0)->resultType)> <encodeValue(typeIndexes(0))>}*

```