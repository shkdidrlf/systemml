/**
 * (C) Copyright IBM Corp. 2010, 2015
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.ibm.bi.dml.runtime.instructions.spark.functions;

import org.apache.spark.Accumulator;
import org.apache.spark.api.java.function.Function;

import com.ibm.bi.dml.runtime.matrix.data.MatrixBlock;

/**
 * 
 */
public class ComputeBinaryBlockNnzFunction implements Function<MatrixBlock,MatrixBlock> 
{
	private static final long serialVersionUID = -8396410450821999936L;
	
	private Accumulator<Double> _aNnz = null;
	
	public ComputeBinaryBlockNnzFunction( Accumulator<Double> aNnz )
	{
		_aNnz = aNnz;
	}

	@Override
	public MatrixBlock call(MatrixBlock arg0) throws Exception 
	{
		_aNnz.add( (double)arg0.getNonZeros() );
		return arg0;
	}
}
