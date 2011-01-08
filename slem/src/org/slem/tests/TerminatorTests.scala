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
 
class TerminatorSpec extends Spec {

    def emitTest(instr : L_TerminatorInstruction) : String = 
    {
        val e = new StringEmitter()
		val encoder = new IRTreeEncoder(e)
		encoder.encodeTerminator(instr)
		e.result
    }
	
	/*
	describe("BinOp - Type Inference: ") {
	    it("L_IntType") {
			expect("i32")
			{
				typeTest(L_Add(1,2))
			}
		}
		it("L_FloatType") {
			expect("float")
			{
				typeTest(L_Add(L_Float("1.0"), L_Float("2.0")))
			}
		}
		it("L_DoubleType") {
			expect("double")
			{
				typeTest(L_Add(L_Double("1.0"), L_Double("2.0")))
			}
		}
        it("L_VectorType") {
            expect("<3 x i32>")
			{
				val vec1 = L_Vector(List(0,1,2))
				val vec2 = L_Vector(List(3,4,5))
			    typeTest(L_Add(vec1, vec2))
			}
		}
	}
    */
    describe("Terminator - Ret: ") {
 
      it("L_Ret - Basic") {
        expect("ret i32 1") 
	    {  
	      emitTest(L_Ret(1))
	    }
      }
      it("L_Ret - Type Inference") {
        expect("ret i64 1") 
	    { 
	      emitTest(L_Ret(1 : Long))
	    }
      }
      it("L_Ret - Void") {
        expect("ret void")
        {
          emitTest(L_Ret(L_Void()))
        }
      }
    }
    
    describe("Terminator - Br: ") {
      it("L_Br - Unconditional") 
      {
        expect("br label %mylabel") 
	    {  
          var myLabel = L_Label("mylabel")
	      emitTest(L_Br(myLabel))
	    }
      }   
      it("L_BrCond - Conditional") 
      {
        expect("br i1 0, label %mylabel, label %mylabel2") 
	    {  
          var myLabel = L_Label("mylabel")
          var myLabel2 = L_Label("mylabel2")
	      emitTest(L_BrCond(false, myLabel, myLabel2))
	    }
      }       
    }

    describe("Terminator - Switch: ") {
      it("L_Switch - Uncond Br")
      {
        expect("switch i32 0, label %mylabel [ ]") 
	    {  
          var myLabel = L_Label("mylabel")
	      emitTest(L_Switch(0, myLabel, List()))
	    }      
      }
      it("L_Switch - One Destination")
      {
        expect("switch i32 0, label %mylabel [ i32 1, label %mylabel2 ]") 
	    {  
          var myLabel = L_Label("mylabel")
          var myLabel2 = L_Label("mylabel2")
          var valuelab = L_ValueLabel(1, myLabel2)
	      emitTest(L_Switch(0, myLabel, List(valuelab)))
	    }      
      }
      it("L_Switch - Multiple Destinations")
      {
        expect("switch i32 0, label %mylabel [ i32 1, label %mylabel2 i32 2, label %mylabel3 i32 3, label %mylabel4 ]") 
	    {  
          var myLabel = L_Label("mylabel")
          var myLabel2 = L_Label("mylabel2")
          var myLabel3 = L_Label("mylabel3")
          var myLabel4 = L_Label("mylabel4")
          var valuelab = L_ValueLabel(1, myLabel2)
          var valuelab2 = L_ValueLabel(2, myLabel3)
          var valuelab3 = L_ValueLabel(3, myLabel4)
          
	      emitTest(L_Switch(0, myLabel, List(valuelab, valuelab2, valuelab3)))
	    }      
      }    
    }
    
    describe("Terminator - IndirectBr: ") {
      it("L_IndirectBr - Indirect Branch")
      {
        expect("indirectbr i8* null, [ label %mylabel, label %mylabel2 ]") 
	    {
          var myval = L_NullPointer(L_IntType(8))
          var myLabel = L_Label("mylabel")
          var myLabel2 = L_Label("mylabel2")
	      emitTest(L_IndirectBr(myval, List(myLabel, myLabel2)))
	    }      
      }    
    }
    
    describe("Terminator - Invoke: ") {
    
    } //TODO
    
    describe("Terminator - Unwind: ") {
      it("L_Unwind")
      {
        expect("unwind")
        {
          emitTest(L_Unwind())
        }
      }
    }
    
    describe("Terminator - Unreachable: ") {
      it("L_Unreachable")
      {
        expect("unreachable")
        {
          emitTest(L_Unreachable())
        }
      }
    }
    
    
    
}