import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("e")
   public static int[] field2406;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1658072773
   )
   @Export("offset")
   public int offset;
   @ObfuscatedName("w")
   static long[] field2410;
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = -1102127597
   )
   static int field2411;
   @ObfuscatedName("p")
   @Export("payload")
   public byte[] payload;

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1396984658"
   )
   public int method3017() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "5"
   )
   @Export("put24bitInt")
   public void put24bitInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "17797558"
   )
   @Export("putInt")
   public void putInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("z")
   public void method3022(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-258390668"
   )
   public int method3023() {
      this.offset += 2;
      return ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] - 128 & 255);
   }

   @ObfuscatedName("j")
   @Export("putLong")
   public void putLong(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 56));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 48));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)V",
      garbageValue = "484"
   )
   public void method3025(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += class241.method4166(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   @Export("readInt")
   public int readInt() {
      this.offset += 4;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 4] & 255) << 24) + ((this.payload[this.offset - 3] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "57"
   )
   @Export("putBytes")
   public void putBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "45"
   )
   public void method3030(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public void method3031(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.putByte(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.putShort(var1 + '耀');
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1316237088"
   )
   @Export("putVarInt")
   public void putVarInt(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.putByte(var1 >>> 28 | 128);
               }

               this.putByte(var1 >>> 21 | 128);
            }

            this.putByte(var1 >>> 14 | 128);
         }

         this.putByte(var1 >>> 7 | 128);
      }

      this.putByte(var1 & 127);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-31"
   )
   @Export("readUnsignedByte")
   public int readUnsignedByte() {
      return this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "-71"
   )
   @Export("readByte")
   public byte readByte() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "389982679"
   )
   @Export("readLong")
   public long readLong() {
      long var1 = (long)this.readInt() & 4294967295L;
      long var3 = (long)this.readInt() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "1"
   )
   public String method3040() {
      if(this.payload[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.readString();
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1641423077"
   )
   @Export("readString")
   public String readString() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":class22.method181(this.payload, var1, var2);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-17"
   )
   public String method3042() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.offset;

         while(this.payload[++this.offset - 1] != 0) {
            ;
         }

         int var3 = this.offset - var2 - 1;
         return var3 == 0?"":class22.method181(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-285650141"
   )
   public int method3046() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte():this.readUnsignedShort() - '耀';
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1959866060"
   )
   @Export("readUnsignedShort")
   public int readUnsignedShort() {
      this.offset += 2;
      return ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-44"
   )
   public int method3048() {
      if(this.payload[this.offset] < 0) {
         return this.readInt() & Integer.MAX_VALUE;
      } else {
         int var1 = this.readUnsignedShort();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1982660333"
   )
   @Export("readVarInt")
   public int readVarInt() {
      byte var1 = this.payload[++this.offset - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.payload[++this.offset - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "196280097"
   )
   @Export("encryptXtea2")
   public void encryptXtea2(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.readInt();
         int var5 = this.readInt();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var6 + var1[var6 >>> 11 & 3]) {
            var4 += (var5 << 4 ^ var5 >>> 5) + var5 ^ var1[var6 & 3] + var6;
            var6 += var7;
         }

         this.offset -= 8;
         this.putInt(var4);
         this.putInt(var5);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "([IIIB)V",
      garbageValue = "0"
   )
   @Export("encryptXtea")
   public void encryptXtea(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.readInt();
         int var8 = this.readInt();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3]) {
            var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var9 & 3] + var9;
            var9 += var10;
         }

         this.offset -= 8;
         this.putInt(var7);
         this.putInt(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "([IIIB)V",
      garbageValue = "-1"
   )
   public void method3053(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.readInt();
         int var8 = this.readInt();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= (var8 << 4 ^ var8 >>> 5) + var8 ^ var9 + var1[var9 & 3]) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.offset -= 8;
         this.putInt(var7);
         this.putInt(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "-1860077279"
   )
   public void method3054(BigInteger var1, BigInteger var2) {
      int var3 = this.offset;
      this.offset = 0;
      byte[] var4 = new byte[var3];
      this.readBytes(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.offset = 0;
      this.putShort(var7.length);
      this.putBytes(var7, 0, var7.length);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-76"
   )
   @Export("read24BitInt")
   public int read24BitInt() {
      this.offset += 3;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "80"
   )
   public boolean method3056() {
      this.offset -= 4;
      byte[] var2 = this.payload;
      int var3 = this.offset;
      int var4 = -1;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4 = var4 >>> 8 ^ field2406[(var4 ^ var2[var5]) & 255];
      }

      var4 = ~var4;
      var5 = this.readInt();
      return var4 == var5;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "8"
   )
   public void method3057(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "12"
   )
   public void method3059(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-82"
   )
   public int method3060() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-705089113"
   )
   public int method3062() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-878540735"
   )
   public byte method3063() {
      return (byte)(this.payload[++this.offset - 1] - 128);
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1474093505"
   )
   public void method3065(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-17692"
   )
   public void method3066(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1314320224"
   )
   public void method3067(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "101443556"
   )
   public int method3068() {
      this.offset += 2;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "482403961"
   )
   public void method3069(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1250474116"
   )
   public int method3070() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "42"
   )
   public int method3071() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "36"
   )
   public void method3077(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-882558088"
   )
   public int method3078() {
      this.offset += 4;
      return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 24) + ((this.payload[this.offset - 3] & 255) << 8);
   }

   static {
      field2406 = new int[256];

      int var2;
      for(int var1 = 0; var1 < 256; ++var1) {
         int var0 = var1;

         for(var2 = 0; var2 < 8; ++var2) {
            if((var0 & 1) == 1) {
               var0 = var0 >>> 1 ^ -306674912;
            } else {
               var0 >>>= 1;
            }
         }

         field2406[var1] = var0;
      }

      field2410 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if(1L == (var4 & 1L)) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2410[var2] = var4;
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "986441580"
   )
   public String method3104() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.readVarInt();
         if(var2 + this.offset > this.payload.length) {
            throw new IllegalStateException("");
         } else {
            byte[] var4 = this.payload;
            int var5 = this.offset;
            char[] var6 = new char[var2];
            int var7 = 0;
            int var8 = var5;

            int var11;
            for(int var9 = var5 + var2; var8 < var9; var6[var7++] = (char)var11) {
               int var10 = var4[var8++] & 255;
               if(var10 < 128) {
                  if(var10 == 0) {
                     var11 = '�';
                  } else {
                     var11 = var10;
                  }
               } else if(var10 < 192) {
                  var11 = '�';
               } else if(var10 < 224) {
                  if(var8 < var9 && (var4[var8] & 192) == 128) {
                     var11 = (var10 & 31) << 6 | var4[var8++] & 63;
                     if(var11 < 128) {
                        var11 = '�';
                     }
                  } else {
                     var11 = '�';
                  }
               } else if(var10 < 240) {
                  if(var8 + 1 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128) {
                     var11 = (var10 & 15) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                     if(var11 < 2048) {
                        var11 = '�';
                     }
                  } else {
                     var11 = '�';
                  }
               } else if(var10 < 248) {
                  if(var8 + 2 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128 && (var4[var8 + 2] & 192) == 128) {
                     var11 = (var10 & 7) << 18 | (var4[var8++] & 63) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                     if(var11 >= 65536 && var11 <= 1114111) {
                        var11 = '�';
                     } else {
                        var11 = '�';
                     }
                  } else {
                     var11 = '�';
                  }
               } else {
                  var11 = '�';
               }
            }

            String var3 = new String(var6, 0, var7);
            this.offset += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "10422"
   )
   public int method3112(int var1) {
      byte[] var3 = this.payload;
      int var4 = this.offset;
      int var5 = -1;

      for(int var6 = var1; var6 < var4; ++var6) {
         var5 = var5 >>> 8 ^ field2406[(var5 ^ var3[var6]) & 255];
      }

      var5 = ~var5;
      this.putInt(var5);
      return var5;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1494483935"
   )
   public void method3114(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-784703104"
   )
   public int method3116() {
      this.offset += 4;
      return ((this.payload[this.offset - 3] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "24"
   )
   public void method3125(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += class241.method4166(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1239592296"
   )
   public void method3135(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   public Buffer(int var1) {
      this.payload = class174.method3248(var1);
      this.offset = 0;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1871262398"
   )
   @Export("readShortSmart")
   public int readShortSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - '쀀';
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)V",
      garbageValue = "-51"
   )
   public void method3153(CharSequence var1) {
      int var2 = class20.method167(var1);
      this.payload[++this.offset - 1] = 0;
      this.putVarInt(var2);
      this.offset += class35.method480(this.payload, this.offset, var1);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1709391680"
   )
   public int method3154() {
      return this.payload[this.offset] < 0?this.readInt() & Integer.MAX_VALUE:this.readUnsignedShort();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1941999712"
   )
   public void method3156(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1594731549"
   )
   public int method3160() {
      this.offset += 4;
      return ((this.payload[this.offset - 1] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 8) + (this.payload[this.offset - 3] & 255);
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-644154931"
   )
   public byte method3165() {
      return (byte)(0 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-48"
   )
   @Export("putShort")
   public void putShort(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1456997537"
   )
   @Export("decryptXtea")
   public void decryptXtea(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.readInt();
         int var5 = this.readInt();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3]) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
            var6 -= var7;
         }

         this.offset -= 8;
         this.putInt(var4);
         this.putInt(var5);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1849425916"
   )
   @Export("putByte")
   public void putByte(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "166990732"
   )
   public void method3196(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method3197() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1432850691"
   )
   public int method3201() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "28"
   )
   public void method3204(int var1) {
      this.payload[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.payload[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "479565005"
   )
   @Export("readShort")
   public int readShort() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-803906223"
   )
   @Export("readBytes")
   public void readBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }
}
