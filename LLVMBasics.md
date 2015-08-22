# LLVM High Level Structure #

### LLVM Program Basics ###

A Simplified description of a LLVM IR program is as follows. Further reading of the [High Level Structure Section](http://llvm.org/docs/LangRef.html#highlevel) of the LLVM Assembly Language Reference Manual is reccomended.

  * A **[program](L_Program.md)** consists of a number of **[modules](L_Module.md)**.
Each of these **modules** can contain a number of **global values** and named **metadata** entries.
  * A **[global value](L_Global.md)** can be either a **[global variable](L_GlobalVariable.md)**, or a **[function definition](L_FunctionDefinition.md)**/**[function declaration](L_FunctionDeclaration.md)**.
  * A **[function definition](L_FunctionDefinition.md)** contains a number of **[blocks](L_Block.md)**.
  * A **[block](L_Block.md)** consists of a number of **[instructions](L_Instruction.md)**, and a **[terminator instruction](L_TerminatorInstruction.md)**.

### LLVM Example Program ###
The following program consists of a single **[module](L_Module.md)**, which contains three **[global values](L_Global.md)** - A **[global variable](L_GlobalVariable.md)**, a **[function definition](L_FunctionDefinition.md)** and a **[function declaration](L_FunctionDeclaration.md)**.

The **[function definition](L_FunctionDefinition.md)** contains a single **[block](L_Block.md)**, which in turn contains a single **[instruction](L_Instruction.md)** (the call to puts), and a **[terminator instruction](L_TerminatorInstruction.md)**

```
@.str = private constant [12 x i8] c"Hello World\00", align 1 ;

define i32 @main(i32 %argc, i8** %argv) {
entry:
  %0 = i8* getelementptr inbounds [12 x i8]* @.str, i32 0, i32 0
  %1 = tail call i32 @puts(i8* %0) nounwind ;
  ret i32 0
}

declare i32 @puts(i8*)
```

### Constructing this example program in SLEM ###

```
//Define the string global variable
val str = L_GlobalVariable(L_String("Hello World\n"))

//Define the puts function declaration
val putsDeclaration = 
  L_FunctionDeclaration(
    L_IntType(32), 
    funcName = "puts", 
    arguments = List(L_PointerType(L_IntType(8))
  )

//Define the main function definition
val stringPtr = 
  L_GetElementPtr(
    L_PointerType(IntType(8)), 
    str, 
    List(0,0), 
    inbounds = true
  )
val putsCall = L_Call(L_IntType(32), putsDeclaration, List(stringPtr))
val retZero = L_Ret(0)
val entryBlock = L_Block(List(stringPtr, putsCall), retZero)
val mainFunc = L_FunctionDefinition(L_IntType(32), entryBlock)

//Define our (only) module
val myModule = L_Module(List(str, mainFunc, putsDeclaration))

//Define our program itself
val myProgram = L_Program(List(myModule))


```