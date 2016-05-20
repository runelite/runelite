/*
 * Copyright (c) 2016, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. All advertising materials mentioning features or use of this software
 *    must display the following acknowledgement:
 *    This product includes software developed by Adam <Adam@sigterm.info>
 * 4. Neither the name of the Adam <Adam@sigterm.info> nor the
 *    names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY Adam <Adam@sigterm.info> ''AS IS'' AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL Adam <Adam@sigterm.info> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.cache.io;

import java.util.Arrays;

public abstract class Stream {
   protected int offset;
   protected int length;
   protected byte[] buffer;
   protected int bitPosition;

   public int getLength() {
      return this.length;
   }

   public byte[] getBuffer() {
      return this.buffer;
   }

   public int getOffset() {
      return this.offset;
   }

   public byte[] getReaminingBuffer() {
	   return Arrays.copyOfRange(buffer, offset, length);
   }

   public void decodeXTEA(int[] keys) {
      this.decodeXTEA(keys, 5, this.length);
   }

   public void decodeXTEA(int[] keys, int start, int end) {
      int l = this.offset;
      this.offset = start;
      int i1 = (end - start) / 8;

      for(int j1 = 0; j1 < i1; ++j1) {
         int k1 = this.readInt();
         int l1 = this.readInt();
         int sum = -957401312;
         int delta = -1640531527;

         for(int k2 = 32; k2-- > 0; k1 -= (l1 >>> 5 ^ l1 << 4) + l1 ^ keys[sum & 3] + sum) {
            l1 -= keys[(sum & 7300) >>> 11] + sum ^ (k1 >>> 5 ^ k1 << 4) + k1;
            sum -= delta;
         }

         this.offset -= 8;
         this.writeInt(k1);
         this.writeInt(l1);
      }

      this.offset = l;
   }

   private final int readInt() {
      this.offset += 4;
      return ((255 & this.buffer[-3 + this.offset]) << 16) + ((255 & this.buffer[-4 + this.offset]) << 24) + ((this.buffer[-2 + this.offset] & 255) << 8) + (this.buffer[-1 + this.offset] & 255);
   }

   public void writeInt(int value) {
      this.buffer[this.offset++] = (byte)(value >> 24);
      this.buffer[this.offset++] = (byte)(value >> 16);
      this.buffer[this.offset++] = (byte)(value >> 8);
      this.buffer[this.offset++] = (byte)value;
   }

   public final void getBytes(byte[] data, int off, int len) {
      for(int k = off; k < len + off; ++k) {
         data[k] = this.buffer[this.offset++];
      }

   }
}
