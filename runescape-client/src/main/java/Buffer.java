import java.applet.Applet;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gp")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("po")
   @ObfuscatedSignature(
      signature = "Lds;"
   )
   static Resampler field2571;
   @ObfuscatedName("o")
   @Export("crc32Table")
   static int[] crc32Table;
   @ObfuscatedName("k")
   @Export("crc64Table")
   static long[] crc64Table;
   @ObfuscatedName("c")
   @Export("payload")
   public byte[] payload;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -732981237
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
            if(1L == (var4 & 1L)) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         crc64Table[var2] = var4;
      }

   }

   public Buffer(int var1) {
      this.payload = WorldMapRectangle.method271(var1);
      this.offset = 0;
   }

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-891684981"
   )
   public void method3502() {
      if(this.payload != null) {
         class38.method531(this.payload);
      }

      this.payload = null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-47"
   )
   @Export("putByte")
   public void putByte(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1330380923"
   )
   @Export("putShort")
   public void putShort(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-89"
   )
   @Export("put24bitInt")
   public void put24bitInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "43"
   )
   @Export("putInt")
   public void putInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("z")
   public void method3507(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("p")
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1432777546"
   )
   @Export("writeBooleanAsByte")
   public void writeBooleanAsByte(boolean var1) {
      this.putByte(var1?1:0);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1644114160"
   )
   @Export("putString")
   public void putString(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += AbstractByteBuffer.encodeStringCp1252(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-100"
   )
   @Export("putJagString")
   public void putJagString(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += AbstractByteBuffer.encodeStringCp1252(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)V",
      garbageValue = "-115"
   )
   @Export("putCESU8")
   public void putCESU8(CharSequence var1) {
      int var2 = class27.method240(var1);
      this.payload[++this.offset - 1] = 0;
      this.putVarInt(var2);
      int var3 = this.offset;
      byte[] var5 = this.payload;
      int var6 = this.offset;
      int var7 = var1.length();
      int var8 = var6;

      for(int var9 = 0; var9 < var7; ++var9) {
         char var10 = var1.charAt(var9);
         if(var10 <= 127) {
            var5[var8++] = (byte)var10;
         } else if(var10 <= 2047) {
            var5[var8++] = (byte)(192 | var10 >> 6);
            var5[var8++] = (byte)(128 | var10 & '?');
         } else {
            var5[var8++] = (byte)(224 | var10 >> '\f');
            var5[var8++] = (byte)(128 | var10 >> 6 & 63);
            var5[var8++] = (byte)(128 | var10 & '?');
         }
      }

      int var4 = var8 - var6;
      this.offset = var4 + var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "20"
   )
   @Export("putBytes")
   public void putBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "70"
   )
   @Export("putLengthInt")
   public void putLengthInt(int var1) {
      this.payload[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.payload[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-635318989"
   )
   public void method3515(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "196693314"
   )
   public void method3516(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-45"
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1793170748"
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

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "857706775"
   )
   @Export("readUnsignedByte")
   public int readUnsignedByte() {
      return this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-349109194"
   )
   @Export("readByte")
   public byte readByte() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1208216487"
   )
   @Export("readUnsignedShort")
   public int readUnsignedShort() {
      this.offset += 2;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "997392590"
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

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "18"
   )
   @Export("read24BitInt")
   public int read24BitInt() {
      this.offset += 3;
      return ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1817376731"
   )
   @Export("readInt")
   public int readInt() {
      this.offset += 4;
      return ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 24);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-29793952"
   )
   @Export("readLong")
   public long readLong() {
      long var1 = (long)this.readInt() & 4294967295L;
      long var3 = (long)this.readInt() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-57594751"
   )
   public boolean method3526() {
      return (this.readUnsignedByte() & 1) == 1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1024059047"
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

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-778927800"
   )
   @Export("readString")
   public String readString() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":CollisionData.getString(this.payload, var1, var2);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "352970756"
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
         return var3 == 0?"":CollisionData.getString(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1244460337"
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

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "269090564"
   )
   @Export("readBytes")
   public void readBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "764027762"
   )
   @Export("readShortSmart")
   public int readShortSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - 49152;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "776681888"
   )
   @Export("getUSmart")
   public int getUSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte():this.readUnsignedShort() - 32768;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-160670351"
   )
   @Export("getLargeSmart")
   public int getLargeSmart() {
      return this.payload[this.offset] < 0?this.readInt() & Integer.MAX_VALUE:this.readUnsignedShort();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1980867540"
   )
   public int method3603() {
      if(this.payload[this.offset] < 0) {
         return this.readInt() & Integer.MAX_VALUE;
      } else {
         int var1 = this.readUnsignedShort();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "480710536"
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

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "1"
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

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "-77"
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

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "1874652708"
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

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-1251864053"
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

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;B)V",
      garbageValue = "-23"
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

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1305885136"
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

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1284240414"
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
      return var4 == var5;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-6"
   )
   public void method3544(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1273153867"
   )
   @Export("putShortLE")
   public void putShortLE(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1472985457"
   )
   public void method3690(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-203349600"
   )
   public int method3673() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "97"
   )
   public int method3548() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-6"
   )
   public int method3549() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "847182371"
   )
   public byte method3550() {
      return (byte)(this.payload[++this.offset - 1] - 128);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "518724032"
   )
   public byte method3551() {
      return (byte)(0 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "64"
   )
   public byte method3552() {
      return (byte)(128 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1819797985"
   )
   public void method3619(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "989637488"
   )
   public void method3554(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "33"
   )
   public void method3648(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1114400981"
   )
   public int method3513() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1498916977"
   )
   @Export("readUnsignedShortOb1")
   public int readUnsignedShortOb1() {
      this.offset += 2;
      return (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-984734043"
   )
   public int method3716() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-845040914"
   )
   public int method3626() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-25"
   )
   public int method3560() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   public void method3670(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-38"
   )
   public void method3677(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-803900679"
   )
   public void method3563(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2116907147"
   )
   public int method3564() {
      this.offset += 4;
      return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 3] & 255) << 8) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 24);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1320795393"
   )
   public int method3565() {
      this.offset += 4;
      return ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 8) + (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 1] & 255) << 16);
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-751428932"
   )
   public int method3566() {
      this.offset += 4;
      return ((this.payload[this.offset - 1] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 16) + (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 3] & 255) << 24);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "230574637"
   )
   public void method3559(byte[] var1, int var2, int var3) {
      for(int var4 = var3 + var2 - 1; var4 >= var2; --var4) {
         var1[var4] = (byte)(this.payload[++this.offset - 1] - 128);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
      garbageValue = "90"
   )
   public static void method3581(Applet var0, String var1) {
      class57.field652 = var0;
      if(var1 != null) {
         class57.field646 = var1;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lbf;I)V",
      garbageValue = "-925721515"
   )
   static void method3738(GameEngine var0) {
      if(MouseInput.mouseLastButton == 1 || !WorldMapData.middleMouseMovesCamera && MouseInput.mouseLastButton == 4) {
         int var1 = class90.field1338 + 280;
         if(MouseInput.mouseLastPressedX >= var1 && MouseInput.mouseLastPressedX <= var1 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class195.method3750(0, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var1 + 15 && MouseInput.mouseLastPressedX <= var1 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class195.method3750(0, 1);
            return;
         }

         int var2 = class90.field1338 + 390;
         if(MouseInput.mouseLastPressedX >= var2 && MouseInput.mouseLastPressedX <= var2 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class195.method3750(1, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var2 + 15 && MouseInput.mouseLastPressedX <= var2 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class195.method3750(1, 1);
            return;
         }

         int var3 = class90.field1338 + 500;
         if(MouseInput.mouseLastPressedX >= var3 && MouseInput.mouseLastPressedX <= var3 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class195.method3750(2, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var3 + 15 && MouseInput.mouseLastPressedX <= var3 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class195.method3750(2, 1);
            return;
         }

         int var4 = class90.field1338 + 610;
         if(MouseInput.mouseLastPressedX >= var4 && MouseInput.mouseLastPressedX <= var4 + 14 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class195.method3750(3, 0);
            return;
         }

         if(MouseInput.mouseLastPressedX >= var4 + 15 && MouseInput.mouseLastPressedX <= var4 + 80 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedY <= 18) {
            class195.method3750(3, 1);
            return;
         }

         if(MouseInput.mouseLastPressedX >= class90.field1338 + 708 && MouseInput.mouseLastPressedY >= 4 && MouseInput.mouseLastPressedX <= class90.field1338 + 708 + 50 && MouseInput.mouseLastPressedY <= 20) {
            class90.worldSelectShown = false;
            class317.field3926.method5868(class90.field1338, 0);
            class61.field715.method5868(class90.field1338 + 382, 0);
            class90.logoSprite.method5842(class90.field1338 + 382 - class90.logoSprite.width / 2, 18);
            return;
         }

         if(class90.field1372 != -1) {
            World var5 = FaceNormal.worldList[class90.field1372];
            class80.changeWorld(var5);
            class90.worldSelectShown = false;
            class317.field3926.method5868(class90.field1338, 0);
            class61.field715.method5868(class90.field1338 + 382, 0);
            class90.logoSprite.method5842(class90.field1338 + 382 - class90.logoSprite.width / 2, 18);
            return;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILcx;ZB)I",
      garbageValue = "-59"
   )
   static int method3737(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.publicChatMode;
         return 1;
      } else if(var0 == 5001) {
         SceneTilePaint.intStackSize -= 3;
         Client.publicChatMode = class81.intStack[SceneTilePaint.intStackSize];
         class251.field3296 = ScriptEvent.method1103(class81.intStack[SceneTilePaint.intStackSize + 1]);
         if(class251.field3296 == null) {
            class251.field3296 = class320.field3930;
         }

         Client.field1035 = class81.intStack[SceneTilePaint.intStackSize + 2];
         PacketNode var21 = FaceNormal.method3078(ClientPacket.field2433, Client.field902.field1475);
         var21.packetBuffer.putByte(Client.publicChatMode);
         var21.packetBuffer.putByte(class251.field3296.field3929);
         var21.packetBuffer.putByte(Client.field1035);
         Client.field902.method2036(var21);
         return 1;
      } else {
         String var3;
         int var4;
         int var5;
         if(var0 == 5002) {
            var3 = class81.scriptStringStack[--World.scriptStringStackSize];
            SceneTilePaint.intStackSize -= 2;
            var4 = class81.intStack[SceneTilePaint.intStackSize];
            var5 = class81.intStack[SceneTilePaint.intStackSize + 1];
            PacketNode var6 = FaceNormal.method3078(ClientPacket.field2462, Client.field902.field1475);
            var6.packetBuffer.putByte(Projectile.getLength(var3) + 2);
            var6.packetBuffer.putString(var3);
            var6.packetBuffer.putByte(var4 - 1);
            var6.packetBuffer.putByte(var5);
            Client.field902.method2036(var6);
            return 1;
         } else {
            int var10;
            if(var0 == 5003) {
               SceneTilePaint.intStackSize -= 2;
               var10 = class81.intStack[SceneTilePaint.intStackSize];
               var4 = class81.intStack[SceneTilePaint.intStackSize + 1];
               MessageNode var16 = class2.method1(var10, var4);
               if(var16 != null) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var16.id;
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var16.tick;
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var16.name != null?var16.name:"";
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var16.sender != null?var16.sender:"";
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var16.value != null?var16.value:"";
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var16.method1110()?1:(var16.method1113()?2:0);
               } else {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 5004) {
               var10 = class81.intStack[--SceneTilePaint.intStackSize];
               MessageNode var19 = class20.method170(var10);
               if(var19 != null) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var19.type;
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var19.tick;
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var19.name != null?var19.name:"";
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var19.sender != null?var19.sender:"";
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var19.value != null?var19.value:"";
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = var19.method1110()?1:(var19.method1113()?2:0);
               } else {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = "";
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 5005) {
               if(class251.field3296 == null) {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = -1;
               } else {
                  class81.intStack[++SceneTilePaint.intStackSize - 1] = class251.field3296.field3929;
               }

               return 1;
            } else if(var0 == 5008) {
               var3 = class81.scriptStringStack[--World.scriptStringStackSize];
               var4 = class81.intStack[--SceneTilePaint.intStackSize];
               String var15 = var3.toLowerCase();
               byte var20 = 0;
               if(var15.startsWith("yellow:")) {
                  var20 = 0;
                  var3 = var3.substring("yellow:".length());
               } else if(var15.startsWith("red:")) {
                  var20 = 1;
                  var3 = var3.substring("red:".length());
               } else if(var15.startsWith("green:")) {
                  var20 = 2;
                  var3 = var3.substring("green:".length());
               } else if(var15.startsWith("cyan:")) {
                  var20 = 3;
                  var3 = var3.substring("cyan:".length());
               } else if(var15.startsWith("purple:")) {
                  var20 = 4;
                  var3 = var3.substring("purple:".length());
               } else if(var15.startsWith("white:")) {
                  var20 = 5;
                  var3 = var3.substring("white:".length());
               } else if(var15.startsWith("flash1:")) {
                  var20 = 6;
                  var3 = var3.substring("flash1:".length());
               } else if(var15.startsWith("flash2:")) {
                  var20 = 7;
                  var3 = var3.substring("flash2:".length());
               } else if(var15.startsWith("flash3:")) {
                  var20 = 8;
                  var3 = var3.substring("flash3:".length());
               } else if(var15.startsWith("glow1:")) {
                  var20 = 9;
                  var3 = var3.substring("glow1:".length());
               } else if(var15.startsWith("glow2:")) {
                  var20 = 10;
                  var3 = var3.substring("glow2:".length());
               } else if(var15.startsWith("glow3:")) {
                  var20 = 11;
                  var3 = var3.substring("glow3:".length());
               } else if(Client.languageId != 0) {
                  if(var15.startsWith("yellow:")) {
                     var20 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var15.startsWith("red:")) {
                     var20 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var15.startsWith("green:")) {
                     var20 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var15.startsWith("cyan:")) {
                     var20 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var15.startsWith("purple:")) {
                     var20 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var15.startsWith("white:")) {
                     var20 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var15.startsWith("flash1:")) {
                     var20 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var15.startsWith("flash2:")) {
                     var20 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var15.startsWith("flash3:")) {
                     var20 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var15.startsWith("glow1:")) {
                     var20 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var15.startsWith("glow2:")) {
                     var20 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var15.startsWith("glow3:")) {
                     var20 = 11;
                     var3 = var3.substring("glow3:".length());
                  }
               }

               var15 = var3.toLowerCase();
               byte var7 = 0;
               if(var15.startsWith("wave:")) {
                  var7 = 1;
                  var3 = var3.substring("wave:".length());
               } else if(var15.startsWith("wave2:")) {
                  var7 = 2;
                  var3 = var3.substring("wave2:".length());
               } else if(var15.startsWith("shake:")) {
                  var7 = 3;
                  var3 = var3.substring("shake:".length());
               } else if(var15.startsWith("scroll:")) {
                  var7 = 4;
                  var3 = var3.substring("scroll:".length());
               } else if(var15.startsWith("slide:")) {
                  var7 = 5;
                  var3 = var3.substring("slide:".length());
               } else if(Client.languageId != 0) {
                  if(var15.startsWith("wave:")) {
                     var7 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var15.startsWith("wave2:")) {
                     var7 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var15.startsWith("shake:")) {
                     var7 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var15.startsWith("scroll:")) {
                     var7 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var15.startsWith("slide:")) {
                     var7 = 5;
                     var3 = var3.substring("slide:".length());
                  }
               }

               PacketNode var8 = FaceNormal.method3078(ClientPacket.field2449, Client.field902.field1475);
               var8.packetBuffer.putByte(0);
               int var9 = var8.packetBuffer.offset;
               var8.packetBuffer.putByte(var4);
               var8.packetBuffer.putByte(var20);
               var8.packetBuffer.putByte(var7);
               ItemComposition.method5113(var8.packetBuffer, var3);
               var8.packetBuffer.method3516(var8.packetBuffer.offset - var9);
               Client.field902.method2036(var8);
               return 1;
            } else {
               int var13;
               if(var0 == 5009) {
                  World.scriptStringStackSize -= 2;
                  var3 = class81.scriptStringStack[World.scriptStringStackSize];
                  String var18 = class81.scriptStringStack[World.scriptStringStackSize + 1];
                  PacketNode var11 = FaceNormal.method3078(ClientPacket.field2440, Client.field902.field1475);
                  var11.packetBuffer.putShort(0);
                  var13 = var11.packetBuffer.offset;
                  var11.packetBuffer.putString(var3);
                  ItemComposition.method5113(var11.packetBuffer, var18);
                  var11.packetBuffer.method3515(var11.packetBuffer.offset - var13);
                  Client.field902.method2036(var11);
                  return 1;
               } else if(var0 != 5015) {
                  if(var0 == 5016) {
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.field1035;
                     return 1;
                  } else if(var0 == 5017) {
                     var10 = class81.intStack[--SceneTilePaint.intStackSize];
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = class57.method858(var10);
                     return 1;
                  } else if(var0 == 5018) {
                     var10 = class81.intStack[--SceneTilePaint.intStackSize];
                     int[] var17 = class81.intStack;
                     var5 = ++SceneTilePaint.intStackSize - 1;
                     MessageNode var14 = (MessageNode)class95.messages.get((long)var10);
                     if(var14 == null) {
                        var13 = -1;
                     } else if(var14.previous == class95.field1434.sentinel) {
                        var13 = -1;
                     } else {
                        var13 = ((MessageNode)var14.previous).id;
                     }

                     var17[var5] = var13;
                     return 1;
                  } else if(var0 == 5019) {
                     var10 = class81.intStack[--SceneTilePaint.intStackSize];
                     class81.intStack[++SceneTilePaint.intStackSize - 1] = GameObject.method3098(var10);
                     return 1;
                  } else if(var0 == 5020) {
                     var3 = class81.scriptStringStack[--World.scriptStringStackSize];
                     if(var3.equalsIgnoreCase("toggleroof")) {
                        class46.preferences.hideRoofs = !class46.preferences.hideRoofs;
                        class46.method694();
                        if(class46.preferences.hideRoofs) {
                           class189.sendGameMessage(99, "", "Roofs are now all hidden");
                        } else {
                           class189.sendGameMessage(99, "", "Roofs will only be removed selectively");
                        }
                     }

                     if(var3.equalsIgnoreCase("displayfps")) {
                        Client.displayFps = !Client.displayFps;
                     }

                     if(var3.equalsIgnoreCase("renderself")) {
                        Client.field974 = !Client.field974;
                     }

                     if(var3.equalsIgnoreCase("mouseovertext")) {
                        Client.field912 = !Client.field912;
                     }

                     if(Client.rights >= 2) {
                        if(var3.equalsIgnoreCase("aabb")) {
                           if(!class7.drawBoundingBoxes3D) {
                              class7.drawBoundingBoxes3D = true;
                              class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ALWAYS;
                           } else if(BoundingBox3DDrawMode.ALWAYS == class7.boundingBox3DDrawMode) {
                              class7.drawBoundingBoxes3D = true;
                              class7.boundingBox3DDrawMode = BoundingBox3DDrawMode.ON_MOUSEOVER;
                           } else {
                              class7.drawBoundingBoxes3D = false;
                           }
                        }

                        if(var3.equalsIgnoreCase("showcoord")) {
                           ScriptState.renderOverview.field4054 = !ScriptState.renderOverview.field4054;
                        }

                        if(var3.equalsIgnoreCase("fpson")) {
                           Client.displayFps = true;
                        }

                        if(var3.equalsIgnoreCase("fpsoff")) {
                           Client.displayFps = false;
                        }

                        if(var3.equalsIgnoreCase("gc")) {
                           System.gc();
                        }

                        if(var3.equalsIgnoreCase("clientdrop")) {
                           class150.method3132();
                        }

                        if(var3.equalsIgnoreCase("cs")) {
                           class189.sendGameMessage(99, "", "" + Client.field905);
                        }

                        if(var3.equalsIgnoreCase("errortest") && Client.socketType == 2) {
                           throw new RuntimeException();
                        }
                     }

                     PacketNode var12 = FaceNormal.method3078(ClientPacket.field2383, Client.field902.field1475);
                     var12.packetBuffer.putByte(var3.length() + 1);
                     var12.packetBuffer.putString(var3);
                     Client.field902.method2036(var12);
                     return 1;
                  } else if(var0 == 5021) {
                     Client.field869 = class81.scriptStringStack[--World.scriptStringStackSize].toLowerCase().trim();
                     return 1;
                  } else if(var0 == 5022) {
                     class81.scriptStringStack[++World.scriptStringStackSize - 1] = Client.field869;
                     return 1;
                  } else {
                     return 2;
                  }
               } else {
                  if(WorldComparator.localPlayer != null && WorldComparator.localPlayer.name != null) {
                     var3 = WorldComparator.localPlayer.name.getName();
                  } else {
                     var3 = "";
                  }

                  class81.scriptStringStack[++World.scriptStringStackSize - 1] = var3;
                  return 1;
               }
            }
         }
      }
   }

   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "504682852"
   )
   static void method3727(Buffer var0) {
      if(Client.field896 != null) {
         var0.putBytes(Client.field896, 0, Client.field896.length);
      } else {
         byte[] var1 = class33.method378();
         var0.putBytes(var1, 0, var1.length);
      }
   }
}
