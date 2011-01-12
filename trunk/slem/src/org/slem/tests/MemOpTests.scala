/**
 * This file is part of Slem.
 *
 * Copyright 2011 Timothy Morton.
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


package org.slem.tests
 
import org.scalatest.Spec
import org.slem.IRTree._
import org.slem.IRTreeEncoder
import org.kiama.util.Console
import org.kiama.util.StringEmitter
 
class MemOpSpec extends Spec {

    def emitTest(instr : L_Instruction) : String = 
    {
        val e = new StringEmitter()
		val encoder = new IRTreeEncoder(e)
		encoder.encodeInstruction(instr)
		e.result
    }
	
    describe("Memory Op Instruction - alloca: ") {
 
      it("L_Alloca - i32") {
        expect("%0 = alloca i32") 
	    {  
	      emitTest(L_Alloca(L_IntType(32)))
	    }
      }
      it("L_Alloca - i8*") {
        expect("%0 = alloca i8*") 
	    {  
	      emitTest(L_Alloca(L_PointerType(L_IntType(8))))
	    }
      }
      it("L_Alloca - NumElements + alignment") {
        expect("%0 = alloca i8*, i32 5, align 2")
        {
          emitTest(L_Alloca(L_PointerType(L_IntType(8)), numElements = 5, alignment = 2))
        }
      }
    }
    
    describe("Memory Op Instruction - load: ") {
      
      it("L_Load - basic") {
        expect("%0 = load i32* %1")
        {
          val myPtr = L_Alloca(L_IntType(32))
          val stor = L_Store(myPtr, 1)
          emitTest(L_Load(L_PointerType(L_IntType(32)), myPtr))
        }
      }
      it("L_Load - aligned + volatile") {
        expect("%0 = volatile load i32* %1, align 5")
        {
          val myPtr = L_Alloca(L_IntType(32))
          val stor = L_Store(myPtr, 1)
          emitTest(L_Load(L_PointerType(L_IntType(32)), myPtr, alignment = 5, isVolatile = true))
        }
      }    
    }
    
    
    describe("Memory Op Instruction - store: ") {
      
      it("L_Store - basic") {
        expect("store i32 1, i32* %0")
        {
          val myPtr = L_Alloca(L_IntType(32))
          emitTest(L_Store(1, myPtr))
        }
      }
      
      it("L_Store - aligned + volatile")
      {
        expect("volatile store i32 1, i32* %0, align 5")
        {
          val myPtr = L_Alloca(L_IntType(32))
          emitTest(L_Store(1, myPtr, alignment = 5, isVolatile = true))
        }
      }
    }
    
    describe("Memory Op Instruction - getelementptr: ") {
      it("L_GetElementPtr - basic pointer")
      {
        expect("%0 = getelementptr i32* %1, i32 0")
        {
            val myPtr = L_Alloca(L_IntType(32))
            emitTest(L_GetElementPtr(L_PointerType(L_IntType(32)), myPtr, List(0)))
        }
      }
      it("L_GetElementPtr - basic pointer inbounds")
      {
        expect("%0 = getelementptr inbounds i32* %1, i32 0")
        {
            val myPtr = L_Alloca(L_IntType(32))
            emitTest(L_GetElementPtr(L_PointerType(L_IntType(32)), myPtr, List(0), inBounds = true))
        }
      }
      //TODO GEP Type tests
    }
    
    
    
}