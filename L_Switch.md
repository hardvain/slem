
```



case class L_Switch(value : L_Value, default : L_Label, cases : List[L_ValueLabel]) extends L_TerminatorInstruction


```

**Overview:**

Constructs a 'switch' terminator instruction. Takes a value to index against a list of value-label pairs.

For further information see the LLVM Assembly Reference Manual - ['switch' Instruction](http://llvm.org/docs/LangRef.html#i_switch)

**Arguments:**

The 'switch' instruction uses three parameters: an integer comparison value 'value', a default 'label' destination, and an array of pairs of comparison value constants and 'label's. The table is not allowed to contain duplicate constant entries.

The destination table is stored as a list of L\_ValueLabel.

To construct a value-label pair to use in the list of destination value-label pairs, use:
```
case class L_ValueLabel(value : L_Value, label : L_Label) extends L_Node
```
and pass each value/label pair as parameters to a constructor.

**Semantics:**

The switch instruction specifies a table of values and destinations. When the 'switch' instruction is executed, this table is searched for the given value. If the value is found, control flow is transferred to the corresponding destination; otherwise, control flow is transferred to the default destination.

**Emitted LLVM IR:**
```
For a switch terminator instruction:

  switch <encodeType(value->resultType)> <encodeValue(value)>, label <encodeValue(defaultdest)> 
        [ <encodeType(cases(1)->resultType)> <encodeValue(cases(1).val)>,  
          label <encodeValue(cases(1).dest)> ... ]
```