# Scala LLVM Emitter Module #

Slem is a Scala library for building/emitting LLVM IR. It provides tools to allow Scala language developers to construct an AST representation of an LLVM IR tree, and emit that representation in human readable LLVM IR.

Notable features include:
  * Type inference of LLVM values.
  * Automated SSA allocation to instruction results.
  * Automated label/function/parameter naming (with ability to specify manually).
  * Implicit type conversion of commonly used constant values such as integers/strings.
  * Integrated toolkit to easily construct blocks to automate utilisation of common C std library functionality.

### Examples of Slem in action ###

Suppose we want to build the following LLVM IR function:
```
define i64 @F0(i64 %param0, i64 %param1) {
block0:
  %0 = add i64 %param0, %param1
  %1 = mul i64 %0, 5
  ret i64 %1

}
```
This function consists of two arguments, an add instruction, a mul instuction, a ret terminator instruction ending the block and returning the function result, and a single block containing these instructions.

We can easily construct the relevant arguments, instructions, terminator, block and finally the function itself using the LLVM tree elements found in the [IRTree](https://code.google.com/p/slem/source/browse/trunk/slem/src/org/slem/IRTree.scala) module.

```
//Define the two parameters for the function
//note that as Slem supports type inference of 
//tree elements, we rarely need to specify types
//when constructing LLVM IR instructions.
val x = L_Argument(L_IntType(64))
val y = L_Argument(L_IntType(64))

//Creates an "add" instruction corresponding to
//the first instruction in the original code segment.
val addxy = L_Add(x, y)

//Creates a "mul" instruction corresponding to the
//second instruction in the original code segment. Note
//that we can simply place the value of the "add"
//instruction as one of the arguments of this L_Mul object,
//as slem supports automatic assignment of SSA addresses
//to instruction results - and we can also easily construct
//constant values by placing an int or long as an argument
val mulByFive = L_Mul(addxy, 5 : Long)

//Return the result from the second instruction.
val returnValue = L_Ret(mulByFive)

//Construct a single block containing the above instructions
//and block terminator
val myBlock = L_Block(List(addxy, mulByFive), returnValue)

//Construct the function, defining the return type, the list
//of code blocks that make up the function, and the two function
//arguments defined earlier.
val myFunction = L_FunctionDefinition(
    L_IntType(64), 
    List(myBlock), 
    arguments = List(x,y))

//Emit the tree as human readable LLVM IR to emitter
val e = new IRTreeEncoder(emitter)
e.encodeFunctionDefinition(myFunction)

```