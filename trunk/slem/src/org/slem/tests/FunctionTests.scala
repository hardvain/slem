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
 
class FunctionSpec extends Spec {

    private def emitTest(instr : L_FunctionDeclaration) : String = 
    {
        val e = new StringEmitter()
		val encoder = new IRTreeEncoder(e)
		encoder.encodeFunctionDeclaration(instr)
		e.result
    }
	private def typeTest(instr : L_Instruction) : String =
	{
	    val e = new StringEmitter()
		val encoder = new IRTreeEncoder(e)
		encoder.encodeType(instr->resultType)
		e.result
	}	
    
    describe("Function Declarations: ") {
      
      it("full fn test") {
        expect("declare linktest vistest cctest retattrs1 retattrs2 i64 @myFunc(i32, i64) align 5 gc " + '"' + "gctest" + '"' + " \n")
        {
            val myfunc = L_FunctionDeclaration(
                L_IntType(64),
                funcName = "myFunc",
                arguments = List(L_IntType(32), L_IntType(64)),
                linkage = "linktest",
                visibilityStyle = "vistest",
                callConvention = "cctest",
                returnAttributes = List("retattrs1", "retattrs2"),
                alignment = 5,  
                garbageCollector = "gctest"
            )
            emitTest(myfunc)
        }
      }
    }
    
    
    
}