/*
 * Copyright (c) 2026 Abex
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class EntityOpsDefinition
{
	public List<Op> ops = new ArrayList<>();
	public List<List<SubOp>> subOps = new ArrayList<>();
	public List<List<ConditionalOp>> conditionalOps = new ArrayList<>();
	public List<Map<Integer, List<ConditionalSubOp>>> conditionalSubOps = new ArrayList<>();

	public EntityOpsDefinition setOp(int index, String text)
	{
		for (; this.ops.size() <= index; this.ops.add(null)) ;
		this.ops.set(index, new EntityOpsDefinition.Op(text));

		return this;
	}

	public EntityOpsDefinition setSubOp(int index, int subID, String text)
	{
		for (; this.subOps.size() <= index; this.subOps.add(new ArrayList<>())) ;
		this.subOps.get(index).add(new EntityOpsDefinition.SubOp(text, subID));

		return this;
	}

	public EntityOpsDefinition setConditionalOp(int index, String text, int varpID, int varbitID, int minValue, int maxValue)
	{
		for (; this.conditionalOps.size() <= index; this.conditionalOps.add(new ArrayList<>())) ;
		this.conditionalOps.get(index).add(new EntityOpsDefinition.ConditionalOp(text, varpID, varbitID, minValue, maxValue));

		return this;
	}

	public EntityOpsDefinition setConditionalSubOp(int index, int subID, String text, int varpID, int varbitID, int minValue, int maxValue)
	{
		for (; this.conditionalSubOps.size() <= index; this.conditionalSubOps.add(null)) ;

		var map = this.conditionalSubOps.get(index);
		if (map == null)
		{
			this.conditionalSubOps.set(index, map = new HashMap<>());
		}

		var list = map.computeIfAbsent(subID, k -> new ArrayList<>());
		list.add(new EntityOpsDefinition.ConditionalSubOp(text, subID, varpID, varbitID, minValue, maxValue));

		return this;
	}

	@AllArgsConstructor
	public static class Op
	{
		public String text;
	}

	public static class SubOp extends Op
	{
		public int subID;

		public SubOp(String text, int subID)
		{
			super(text);

			this.subID = subID;
		}
	}

	@Data
	public static class ConditionalOp extends Op
	{
		public int varpID;
		public int varbitID;
		public int minValue;
		public int maxValue;

		public ConditionalOp(String text, int varpID, int varbitID, int minValue, int maxValue)
		{
			super(text);

			this.varpID = varpID;
			this.varbitID = varbitID;
			this.minValue = minValue;
			this.maxValue = maxValue;
		}
	}

	@Data
	public static class ConditionalSubOp extends ConditionalOp
	{
		public int subID;

		public ConditionalSubOp(String text, int subID, int varpID, int varbitID, int minValue, int maxValue)
		{
			super(text, varpID, varbitID, minValue, maxValue);

			this.subID = subID;
		}
	}
}
