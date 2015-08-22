
```
    case class L_Label(label : String) extends L_Node
    implicit def stringToLabel(s : String) : L_Label = L_Label(s)
```

Can be used to create a new [block](L_Block.md) label in SLEM.