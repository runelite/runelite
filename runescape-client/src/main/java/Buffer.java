import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("qn")
   @ObfuscatedSignature(
      signature = "Lca;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("i")
   @Export("crc32Table")
   public static int[] crc32Table;
   @ObfuscatedName("v")
   @Export("crc64Table")
   static long[] crc64Table;
   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "[Lko;"
   )
   static IndexedSprite[] field2500;
   @ObfuscatedName("m")
   @Export("payload")
   public byte[] payload;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -77624639
   )
   @Export("offset")
   public int offset;

   static {
      crc32Table = new int[256];

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

         crc32Table[var1] = var0;
      }

      crc64Table = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         crc64Table[var2] = var4;
      }

   }

   public Buffer(int var1) {
      this.payload = class31.method304(var1);
      this.offset = 0;
   }

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "171546059"
   )
   public void method3505() {
      if(this.payload != null) {
         class34.method536(this.payload);
      }

      this.payload = null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "114806106"
   )
   @Export("putByte")
   public void putByte(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2116350690"
   )
   @Export("putShort")
   public void putShort(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "837452973"
   )
   @Export("put24bitInt")
   public void put24bitInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "119"
   )
   @Export("putInt")
   public void putInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("x")
   public void method3273(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("e")
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1688691190"
   )
   public void method3275(boolean var1) {
      this.putByte(var1?1:0);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "1"
   )
   @Export("putString")
   public void putString(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += KeyFocusListener.method831(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "16"
   )
   @Export("putJagString")
   public void putJagString(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += KeyFocusListener.method831(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)V",
      garbageValue = "-1991828237"
   )
   @Export("putCESU8")
   public void putCESU8(CharSequence var1) {
      int var3 = var1.length();
      int var4 = 0;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         char var6 = var1.charAt(var5);
         if(var6 <= 127) {
            ++var4;
         } else if(var6 <= 2047) {
            var4 += 2;
         } else {
            var4 += 3;
         }
      }

      this.payload[++this.offset - 1] = 0;
      this.putVarInt(var4);
      var4 = this.offset;
      byte[] var12 = this.payload;
      int var7 = this.offset;
      int var8 = var1.length();
      int var9 = var7;

      for(int var10 = 0; var10 < var8; ++var10) {
         char var11 = var1.charAt(var10);
         if(var11 <= 127) {
            var12[var9++] = (byte)var11;
         } else if(var11 <= 2047) {
            var12[var9++] = (byte)(192 | var11 >> 6);
            var12[var9++] = (byte)(128 | var11 & '?');
         } else {
            var12[var9++] = (byte)(224 | var11 >> '\f');
            var12[var9++] = (byte)(128 | var11 >> 6 & 63);
            var12[var9++] = (byte)(128 | var11 & '?');
         }
      }

      var5 = var9 - var7;
      this.offset = var4 + var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1846012507"
   )
   @Export("putBytes")
   public void putBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1678682051"
   )
   @Export("putLengthInt")
   public void putLengthInt(int var1) {
      this.payload[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.payload[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1910498564"
   )
   public void method3410(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "126532291"
   )
   public void method3287(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "37"
   )
   @Export("putShortSmart")
   public void putShortSmart(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.putByte(var1);
      } else if(var1 >= 0 && var1 < 32768) {
         this.putShort(var1 + 32768);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "98"
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2102807097"
   )
   @Export("readUnsignedByte")
   public int readUnsignedByte() {
      return this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-752119377"
   )
   @Export("readByte")
   public byte readByte() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "646447714"
   )
   @Export("readUnsignedShort")
   public int readUnsignedShort() {
      this.offset += 2;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1906477990"
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

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1390686149"
   )
   @Export("read24BitInt")
   public int read24BitInt() {
      this.offset += 3;
      return ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "47"
   )
   @Export("readInt")
   public int readInt() {
      this.offset += 4;
      return ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 24);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1815895053"
   )
   @Export("readLong")
   public long readLong() {
      long var1 = (long)this.readInt() & 4294967295L;
      long var3 = (long)this.readInt() & 4294967295L;
      return (var1 << 32) + var3;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-25260205"
   )
   public boolean method3320() {
      return (this.readUnsignedByte() & 1) == 1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1004015469"
   )
   @Export("getNullString")
   public String getNullString() {
      if(this.payload[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.readString();
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1336022053"
   )
   @Export("readString")
   public String readString() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":class33.getString(this.payload, var1, var2);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "372557497"
   )
   @Export("getJagString")
   public String getJagString() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.offset;

         while(this.payload[++this.offset - 1] != 0) {
            ;
         }

         int var3 = this.offset - var2 - 1;
         return var3 == 0?"":class33.getString(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-88"
   )
   @Export("getCESU8")
   public String getCESU8() {
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
            for(int var9 = var2 + var5; var8 < var9; var6[var7++] = (char)var11) {
               int var10 = var4[var8++] & 255;
               if(var10 < 128) {
                  if(var10 == 0) {
                     var11 = 65533;
                  } else {
                     var11 = var10;
                  }
               } else if(var10 < 192) {
                  var11 = 65533;
               } else if(var10 < 224) {
                  if(var8 < var9 && (var4[var8] & 192) == 128) {
                     var11 = (var10 & 31) << 6 | var4[var8++] & 63;
                     if(var11 < 128) {
                        var11 = 65533;
                     }
                  } else {
                     var11 = 65533;
                  }
               } else if(var10 < 240) {
                  if(var8 + 1 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128) {
                     var11 = (var10 & 15) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                     if(var11 < 2048) {
                        var11 = 65533;
                     }
                  } else {
                     var11 = 65533;
                  }
               } else if(var10 < 248) {
                  if(var8 + 2 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128 && (var4[var8 + 2] & 192) == 128) {
                     var11 = (var10 & 7) << 18 | (var4[var8++] & 63) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                     if(var11 >= 65536 && var11 <= 1114111) {
                        var11 = 65533;
                     } else {
                        var11 = 65533;
                     }
                  } else {
                     var11 = 65533;
                  }
               } else {
                  var11 = 65533;
               }
            }

            String var3 = new String(var6, 0, var7);
            this.offset += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "33"
   )
   @Export("readBytes")
   public void readBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "19"
   )
   @Export("readShortSmart")
   public int readShortSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - 49152;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1818757351"
   )
   @Export("getUSmart")
   public int getUSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte():this.readUnsignedShort() - 32768;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "27556"
   )
   @Export("getLargeSmart")
   public int getLargeSmart() {
      return this.payload[this.offset] < 0?this.readInt() & Integer.MAX_VALUE:this.readUnsignedShort();
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int method3301() {
      if(this.payload[this.offset] < 0) {
         return this.readInt() & Integer.MAX_VALUE;
      } else {
         int var1 = this.readUnsignedShort();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "8192"
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

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1626425931"
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

         for(int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3];
            var6 += var7;
         }

         this.offset -= 8;
         this.putInt(var4);
         this.putInt(var5);
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "1721160653"
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

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "([IIIB)V",
      garbageValue = "11"
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

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3];
            var9 += var10;
         }

         this.offset -= 8;
         this.putInt(var7);
         this.putInt(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-801891121"
   )
   @Export("decryptXtea")
   public void decryptXtea(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.readInt();
         int var8 = this.readInt();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.offset -= 8;
         this.putInt(var7);
         this.putInt(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;S)V",
      garbageValue = "-29227"
   )
   @Export("encryptRsa")
   public void encryptRsa(BigInteger var1, BigInteger var2) {
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

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "105"
   )
   @Export("putCrc")
   public int putCrc(int var1) {
      byte[] var3 = this.payload;
      int var4 = this.offset;
      int var5 = -1;

      for(int var6 = var1; var6 < var4; ++var6) {
         var5 = var5 >>> 8 ^ crc32Table[(var5 ^ var3[var6]) & 255];
      }

      var5 = ~var5;
      this.putInt(var5);
      return var5;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "934803080"
   )
   @Export("checkCrc")
   public boolean checkCrc() {
      this.offset -= 4;
      byte[] var2 = this.payload;
      int var3 = this.offset;
      int var4 = -1;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4 = var4 >>> 8 ^ crc32Table[(var4 ^ var2[var5]) & 255];
      }

      var4 = ~var4;
      var5 = this.readInt();
      return var5 == var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-362915979"
   )
   public void method3374(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1564697147"
   )
   public void method3311(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1288275813"
   )
   public void method3403(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1721338666"
   )
   public int method3313() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-124107456"
   )
   public int method3314() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2079603910"
   )
   public int method3407() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "53"
   )
   public byte method3316() {
      return (byte)(this.payload[++this.offset - 1] - 128);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1642085984"
   )
   public byte method3383() {
      return (byte)(0 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1954469510"
   )
   public byte method3318() {
      return (byte)(128 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1237048219"
   )
   public void method3319(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2025080041"
   )
   public void method3340(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-50"
   )
   @Export("putShortLE")
   public void putShortLE(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1874779893"
   )
   public int method3322() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1224610048"
   )
   @Export("readUnsignedShortOb1")
   public int readUnsignedShortOb1() {
      this.offset += 2;
      return (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-212900433"
   )
   public int method3324() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1388766040"
   )
   public int method3426() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-86009852"
   )
   public int method3326() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1371042615"
   )
   public void method3327(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "80"
   )
   public void method3295(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "65280"
   )
   public void method3446(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-37"
   )
   public void method3289(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1525895891"
   )
   public int method3331() {
      this.offset += 4;
      return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 3] & 255) << 8) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 24);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1108660200"
   )
   public int method3292() {
      this.offset += 4;
      return ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 8) + (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 1] & 255) << 16);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-214130899"
   )
   public int method3333() {
      this.offset += 4;
      return ((this.payload[this.offset - 1] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 16) + (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 3] & 255) << 24);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-104"
   )
   public void method3334(byte[] var1, int var2, int var3) {
      for(int var4 = var3 + var2 - 1; var4 >= var2; --var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1285367372"
   )
   public void method3460(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = (byte)(this.payload[++this.offset - 1] - 128);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   static void method3420() {
      class61.field725 = 99;
      class61.field726 = new byte[4][104][104];
      class285.field3790 = new byte[4][104][104];
      class61.field727 = new byte[4][104][104];
      class37.field490 = new byte[4][104][104];
      ItemLayer.field1710 = new int[4][105][105];
      class61.field738 = new byte[4][105][105];
      class218.field2686 = new int[105][105];
      class61.field729 = new int[104];
      RSCanvas.field632 = new int[104];
      Preferences.field1227 = new int[104];
      FloorUnderlayDefinition.field3399 = new int[104];
      class61.field728 = new int[104];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Z",
      garbageValue = "-23"
   )
   public static boolean method3504(CharSequence var0) {
      return KeyFocusListener.method832(var0, 10, true);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lik;Ljava/lang/String;Ljava/lang/String;B)[Lkd;",
      garbageValue = "-5"
   )
   public static SpritePixels[] method3496(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      SpritePixels[] var5;
      if(!class72.method1184(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = ObjectComposition.method4701();
      }

      return var5;
   }
}
