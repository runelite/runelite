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

package net.runelite.cache.fs.util;

import java.util.Arrays;

public class Whirlpool {
   public static final int DIGESTBITS = 512;
   public static final int DIGESTBYTES = 64;
   protected static final int R = 10;
   private static final String sbox = "\u1823\uc6e8\u87b8\u014f\u36a6\ud2f5\u796f\u9152\u60bc\u9b8e\ua30c\u7b35\u1de0\ud7c2\u2e4b\ufe57\u1577\u37e5\u9ff0\u4ada\u58c9\u290a\ub1a0\u6b85\ubd5d\u10f4\ucb3e\u0567\ue427\u418b\ua77d\u95d8\ufbee\u7c66\udd17\u479e\uca2d\ubf07\uad5a\u8333\u6302\uaa71\uc819\u49d9\uf2e3\u5b88\u9a26\u32b0\ue90f\ud580\ubecd\u3448\uff7a\u905f\u2068\u1aae\ub454\u9322\u64f1\u7312\u4008\uc3ec\udba1\u8d3d\u9700\ucf2b\u7682\ud61b\ub5af\u6a50\u45f3\u30ef\u3f55\ua2ea\u65ba\u2fc0\ude1c\ufd4d\u9275\u068a\ub2e6\u0e1f\u62d4\ua896\uf9c5\u2559\u8472\u394c\u5e78\u388c\ud1a5\ue261\ub321\u9c1e\u43c7\ufc04\u5199\u6d0d\ufadf\u7e24\u3bab\uce11\u8f4e\ub7eb\u3c81\u94f7\ub913\u2cd3\ue76e\uc403\u5644\u7fa9\u2abb\uc153\udc0b\u9d6c\u3174\uf646\uac89\u14e1\u163a\u6909\u70b6\ud0ed\ucc42\u98a4\u285c\uf886";
   private static long[][] C = new long[8][256];
   private static long[] rc = new long[11];
   protected byte[] bitLength = new byte[32];
   protected byte[] buffer = new byte[64];
   protected int bufferBits = 0;
   protected int bufferPos = 0;
   protected long[] hash = new long[8];
   protected long[] K = new long[8];
   protected long[] L = new long[8];
   protected long[] block = new long[8];
   protected long[] state = new long[8];

   static {
      int r;
      for(r = 0; r < 256; ++r) {
         char i = "\u1823\uc6e8\u87b8\u014f\u36a6\ud2f5\u796f\u9152\u60bc\u9b8e\ua30c\u7b35\u1de0\ud7c2\u2e4b\ufe57\u1577\u37e5\u9ff0\u4ada\u58c9\u290a\ub1a0\u6b85\ubd5d\u10f4\ucb3e\u0567\ue427\u418b\ua77d\u95d8\ufbee\u7c66\udd17\u479e\uca2d\ubf07\uad5a\u8333\u6302\uaa71\uc819\u49d9\uf2e3\u5b88\u9a26\u32b0\ue90f\ud580\ubecd\u3448\uff7a\u905f\u2068\u1aae\ub454\u9322\u64f1\u7312\u4008\uc3ec\udba1\u8d3d\u9700\ucf2b\u7682\ud61b\ub5af\u6a50\u45f3\u30ef\u3f55\ua2ea\u65ba\u2fc0\ude1c\ufd4d\u9275\u068a\ub2e6\u0e1f\u62d4\ua896\uf9c5\u2559\u8472\u394c\u5e78\u388c\ud1a5\ue261\ub321\u9c1e\u43c7\ufc04\u5199\u6d0d\ufadf\u7e24\u3bab\uce11\u8f4e\ub7eb\u3c81\u94f7\ub913\u2cd3\ue76e\uc403\u5644\u7fa9\u2abb\uc153\udc0b\u9d6c\u3174\uf646\uac89\u14e1\u163a\u6909\u70b6\ud0ed\ucc42\u98a4\u285c\uf886".charAt(r / 2);
         long v1 = (long)((r & 1) == 0?i >>> 8:i & 255);
         long v2 = v1 << 1;
         if(v2 >= 256L) {
            v2 ^= 285L;
         }

         long v4 = v2 << 1;
         if(v4 >= 256L) {
            v4 ^= 285L;
         }

         long v5 = v4 ^ v1;
         long v8 = v4 << 1;
         if(v8 >= 256L) {
            v8 ^= 285L;
         }

         long v9 = v8 ^ v1;
         C[0][r] = v1 << 56 | v1 << 48 | v4 << 40 | v1 << 32 | v8 << 24 | v5 << 16 | v2 << 8 | v9;

         for(int t = 1; t < 8; ++t) {
            C[t][r] = C[t - 1][r] >>> 8 | C[t - 1][r] << 56;
         }
      }

      rc[0] = 0L;

      for(r = 1; r <= 10; ++r) {
         int var15 = 8 * (r - 1);
         rc[r] = C[0][var15] & -72057594037927936L ^ C[1][var15 + 1] & 71776119061217280L ^ C[2][var15 + 2] & 280375465082880L ^ C[3][var15 + 3] & 1095216660480L ^ C[4][var15 + 4] & 4278190080L ^ C[5][var15 + 5] & 16711680L ^ C[6][var15 + 6] & 65280L ^ C[7][var15 + 7] & 255L;
      }

   }

   public static byte[] getHash(byte[] data, int off, int len) {
      byte[] source;
      if(off <= 0) {
         source = data;
      } else {
         source = new byte[len];

         for(int whirlpool = 0; whirlpool < len; ++whirlpool) {
            source[whirlpool] = data[off + whirlpool];
         }
      }

      Whirlpool var6 = new Whirlpool();
      var6.NESSIEinit();
      var6.NESSIEadd(source, (long)(len * 8));
      byte[] digest = new byte[64];
      var6.NESSIEfinalize(digest);
      return digest;
   }

   protected void processBuffer() {
      int i = 0;

      int i1;
      for(i1 = 0; i < 8; i1 += 8) {
         this.block[i] = (long)this.buffer[i1] << 56 ^ ((long)this.buffer[i1 + 1] & 255L) << 48 ^ ((long)this.buffer[i1 + 2] & 255L) << 40 ^ ((long)this.buffer[i1 + 3] & 255L) << 32 ^ ((long)this.buffer[i1 + 4] & 255L) << 24 ^ ((long)this.buffer[i1 + 5] & 255L) << 16 ^ ((long)this.buffer[i1 + 6] & 255L) << 8 ^ (long)this.buffer[i1 + 7] & 255L;
         ++i;
      }

      for(i = 0; i < 8; ++i) {
         this.state[i] = this.block[i] ^ (this.K[i] = this.hash[i]);
      }

      for(i = 1; i <= 10; ++i) {
         int t;
         int s;
         for(i1 = 0; i1 < 8; ++i1) {
            this.L[i1] = 0L;
            t = 0;

            for(s = 56; t < 8; s -= 8) {
               this.L[i1] ^= C[t][(int)(this.K[i1 - t & 7] >>> s) & 255];
               ++t;
            }
         }

         for(i1 = 0; i1 < 8; ++i1) {
            this.K[i1] = this.L[i1];
         }

         this.K[0] ^= rc[i];

         for(i1 = 0; i1 < 8; ++i1) {
            this.L[i1] = this.K[i1];
            t = 0;

            for(s = 56; t < 8; s -= 8) {
               this.L[i1] ^= C[t][(int)(this.state[i1 - t & 7] >>> s) & 255];
               ++t;
            }
         }

         for(i1 = 0; i1 < 8; ++i1) {
            this.state[i1] = this.L[i1];
         }
      }

      for(i = 0; i < 8; ++i) {
         this.hash[i] ^= this.state[i] ^ this.block[i];
      }

   }

   public void NESSIEinit() {
      Arrays.fill(this.bitLength, (byte)0);
      this.bufferBits = this.bufferPos = 0;
      this.buffer[0] = 0;
      Arrays.fill(this.hash, 0L);
   }

   public void NESSIEadd(byte[] source, long sourceBits) {
      int sourcePos = 0;
      int sourceGap = 8 - ((int)sourceBits & 7) & 7;
      int bufferRem = this.bufferBits & 7;
      long value = sourceBits;
      int i = 31;

      for(int carry = 0; i >= 0; --i) {
         carry += (this.bitLength[i] & 255) + ((int)value & 255);
         this.bitLength[i] = (byte)carry;
         carry >>>= 8;
         value >>>= 8;
      }

      int b;
      while(sourceBits > 8L) {
         b = source[sourcePos] << sourceGap & 255 | (source[sourcePos + 1] & 255) >>> 8 - sourceGap;
         if(b < 0 || b >= 256) {
            throw new RuntimeException("LOGIC ERROR");
         }

         byte[] var10000 = this.buffer;
         int var10001 = this.bufferPos++;
         var10000[var10001] = (byte)(var10000[var10001] | b >>> bufferRem);
         this.bufferBits += 8 - bufferRem;
         if(this.bufferBits == 512) {
            this.processBuffer();
            this.bufferBits = this.bufferPos = 0;
         }

         this.buffer[this.bufferPos] = (byte)(b << 8 - bufferRem & 255);
         this.bufferBits += bufferRem;
         sourceBits -= 8L;
         ++sourcePos;
      }

      if(sourceBits > 0L) {
         b = source[sourcePos] << sourceGap & 255;
         this.buffer[this.bufferPos] = (byte)(this.buffer[this.bufferPos] | b >>> bufferRem);
      } else {
         b = 0;
      }

      if((long)bufferRem + sourceBits < 8L) {
         this.bufferBits = (int)((long)this.bufferBits + sourceBits);
      } else {
         ++this.bufferPos;
         this.bufferBits += 8 - bufferRem;
         sourceBits -= (long)(8 - bufferRem);
         if(this.bufferBits == 512) {
            this.processBuffer();
            this.bufferBits = this.bufferPos = 0;
         }

         this.buffer[this.bufferPos] = (byte)(b << 8 - bufferRem & 255);
         this.bufferBits += (int)sourceBits;
      }

   }

   public void NESSIEfinalize(byte[] digest) {
      this.buffer[this.bufferPos] = (byte)(this.buffer[this.bufferPos] | 128 >>> (this.bufferBits & 7));
      ++this.bufferPos;
      if(this.bufferPos > 32) {
         while(true) {
            if(this.bufferPos >= 64) {
               this.processBuffer();
               this.bufferPos = 0;
               break;
            }

            this.buffer[this.bufferPos++] = 0;
         }
      }

      while(this.bufferPos < 32) {
         this.buffer[this.bufferPos++] = 0;
      }

      System.arraycopy(this.bitLength, 0, this.buffer, 32, 32);
      this.processBuffer();
      int i = 0;

      for(int j = 0; i < 8; j += 8) {
         long h = this.hash[i];
         digest[j] = (byte)((int)(h >>> 56));
         digest[j + 1] = (byte)((int)(h >>> 48));
         digest[j + 2] = (byte)((int)(h >>> 40));
         digest[j + 3] = (byte)((int)(h >>> 32));
         digest[j + 4] = (byte)((int)(h >>> 24));
         digest[j + 5] = (byte)((int)(h >>> 16));
         digest[j + 6] = (byte)((int)(h >>> 8));
         digest[j + 7] = (byte)((int)h);
         ++i;
      }

   }

   public void NESSIEadd(String source) {
      if(source.length() > 0) {
         byte[] data = new byte[source.length()];

         for(int i = 0; i < source.length(); ++i) {
            data[i] = (byte)source.charAt(i);
         }

         this.NESSIEadd(data, (long)(8 * data.length));
      }

   }
}
