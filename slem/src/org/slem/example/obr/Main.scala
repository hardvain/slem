/**
 * Obr language implementation main program.
 *
 * This file is part of Slem.
 *
 * Copyright (C) 2009-2010 Anthony M Sloane, Macquarie University.
 *
 * Slem is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Slem is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for
 * more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Slem.  (See files COPYING and COPYING.LESSER.)  If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.slem.example.obr

import org.slem.example.obr.ObrTree.ObrInt
import org.kiama.util.RegexCompiler
//import org.slem.example.obr.SyntaxAnalysis

/**
 * Obr language implementation compiler driver.
 */
class Driver extends SyntaxAnalysis with RegexCompiler[ObrInt] {

    import java.io.FileReader
    import org.kiama.util.Console
    import org.kiama.util.Emitter
    import org.kiama.util.Messaging._
    import org.slem.IRTree._
    import org.slem.IRTreeEncoder
    import org.slem.util.IRTreeFactory._
    import org.slem.example.obr.IRTransform._
    import org.slem.example.obr.SemanticAnalysis._

    /**
     * The usage message for an erroneous invocation.
     */
    val usage = "usage: scala org.slem.example.obr.Main file.obr"

    /**
     * Function to process the input that was parsed.  emitter is
     * used for output.  Return true if everything worked, false
     * otherwise.
     */
    def process (ast : ObrInt, console : Console, emitter : Emitter) : Boolean = 
    {
    /*
        val oldprogram = false
        val testprog = false
        val newprog = true

        ast->errors
        if (messagecount > 0) {
            report
            false
        } else {
            val targettree = ast->code
            //println(targettree)
            val e = new IRTreeEncoder(emitter)
            e.encodeTree(targettree)
            true
        }
    */
        //Define the string global variable
        val str = L_GlobalVariable(L_String("Hello World\\00"), isConstant = true)

        //Define the puts function declaration
        val putsDeclaration = 
          L_FunctionDeclaration(
            L_IntType(32), 
            funcName = "puts", 
            arguments = List(L_PointerType(L_IntType(8)))
          )

        //Define the main function definition
        val stringPtr = 
          L_GetElementPtr(
            L_PointerType(str->resultType), 
            str, 
            List(0,0), 
            inBounds = true
          )
        val putsCall = L_Call(L_IntType(32), putsDeclaration, List(stringPtr))
        
        val listType = L_StructureType(List(L_IntType(32), L_UpReferenceType(2)))
        
        val myalloc = L_Alloca(listType)
        val myalloc2 = L_Alloca(listType)
        val mystore = L_Store(L_Structure(List(123456, L_NullPointer(listType))), myalloc)
        val genlist = L_InsertValue(L_Structure(List(23456, L_NullPointer(listType))), myalloc, 1)
        val mystore2 = L_Store(genlist, myalloc2)
        
        val listconstr = List(myalloc, myalloc2, mystore, genlist, mystore2)
        
        
        val listplay = L_GetElementPtr(myalloc2->resultType, myalloc2, List(0,1))
        val listload = L_Load(listplay->resultType, listplay)
        val listvget = L_GetElementPtr(listload->resultType, listload, List(0,0))
        val listvalue = L_Load(listvget->resultType, listvget)
        
        val listmayhem = List(listplay, listload, listvget, listvalue)
        
        val printoutCall = L_Macro_PrintLine(listvalue)
        val retZero = L_Ret(0)
        val entryBlock = L_Block(List(stringPtr, putsCall) ::: listconstr ::: listmayhem ::: printoutCall, retZero)
        val mainFunc = L_FunctionDefinition(L_IntType(32), List(entryBlock), funcName = "main")


        //Define our (only) module
        val myModule = L_Module(List(str, mainFunc, putsDeclaration) ::: imports)

        //Define our program itself
        val myProgram = L_Program(List(myModule))

        val e = new IRTreeEncoder(emitter)
        e.encodeTree(myProgram)  
        true        
    }
}

/**
 * Obr language implementation main program.
 */
object Main extends Driver
