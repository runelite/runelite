import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("w")
   @Export("crc32Table")
   public static int[] crc32Table;
   @ObfuscatedName("j")
   @Export("crc64Table")
   static long[] crc64Table;
   @ObfuscatedName("p")
   @Export("payload")
   public byte[] payload;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -588566327
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
      this.payload = Frames.method3009(var1);
      this.offset = 0;
   }

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1353428427"
   )
   public void method3388() {
      if(this.payload != null) {
         class163.method3221(this.payload);
      }

      this.payload = null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-194517525"
   )
   @Export("putByte")
   public void putByte(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "73"
   )
   @Export("putShort")
   public void putShort(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1846943988"
   )
   @Export("put24bitInt")
   public void put24bitInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1974086910"
   )
   @Export("putInt")
   public void putInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("a")
   public void method3501(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("t")
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1969202511"
   )
   @Export("writeBooleanAsByte")
   public void writeBooleanAsByte(boolean var1) {
      this.putByte(var1?1:0);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1246291116"
   )
   @Export("putString")
   public void putString(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += class278.encodeStringCp1252(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-344072262"
   )
   @Export("putJagString")
   public void putJagString(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += class278.encodeStringCp1252(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)V",
      garbageValue = "0"
   )
   @Export("putCESU8")
   public void putCESU8(CharSequence var1) {
      int var2 = ItemLayer.method2563(var1);
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "2084759294"
   )
   @Export("putBytes")
   public void putBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   @Export("putLengthInt")
   public void putLengthInt(int var1) {
      this.payload[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.payload[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "128"
   )
   public void method3492(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2014423755"
   )
   public void method3402(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-797023735"
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1360877718"
   )
   @Export("readUnsignedByte")
   public int readUnsignedByte() {
      return this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1220173861"
   )
   @Export("readByte")
   public byte readByte() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1502219451"
   )
   @Export("readUnsignedShort")
   public int readUnsignedShort() {
      this.offset += 2;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2139705679"
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

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2058564905"
   )
   @Export("read24BitInt")
   public int read24BitInt() {
      this.offset += 3;
      return ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "5"
   )
   @Export("readInt")
   public int readInt() {
      this.offset += 4;
      return ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 24);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "2041291115"
   )
   @Export("readLong")
   public long readLong() {
      long var1 = (long)this.readInt() & 4294967295L;
      long var3 = (long)this.readInt() & 4294967295L;
      return (var1 << 32) + var3;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2047963805"
   )
   public boolean method3411() {
      return (this.readUnsignedByte() & 1) == 1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "573167787"
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

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-50"
   )
   @Export("readString")
   public String readString() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":class23.getString(this.payload, var1, var2);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "58"
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
         return var3 == 0?"":class23.getString(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "22107005"
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
            for(int var9 = var5 + var2; var8 < var9; var6[var7++] = (char)var11) {
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

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-19"
   )
   @Export("readBytes")
   public void readBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "904296951"
   )
   @Export("readShortSmart")
   public int readShortSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - 49152;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   @Export("getUSmart")
   public int getUSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte():this.readUnsignedShort() - 32768;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-141723608"
   )
   @Export("getLargeSmart")
   public int getLargeSmart() {
      return this.payload[this.offset] < 0?this.readInt() & Integer.MAX_VALUE:this.readUnsignedShort();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2066002596"
   )
   public int method3414() {
      if(this.payload[this.offset] < 0) {
         return this.readInt() & Integer.MAX_VALUE;
      } else {
         int var1 = this.readUnsignedShort();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1895485419"
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

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "-15"
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

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "10"
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

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "([IIIB)V",
      garbageValue = "-64"
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

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "([IIIB)V",
      garbageValue = "68"
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

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;S)V",
      garbageValue = "13521"
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

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1218295549"
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

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2090616641"
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

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1042806344"
   )
   public void method3429(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "999605137"
   )
   public void method3430(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   public void method3397(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "17"
   )
   public int method3432() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1746805225"
   )
   public int method3433() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1126535699"
   )
   @Export("readUnsignedByteNegate")
   public int readUnsignedByteNegate() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "-107"
   )
   public byte method3458() {
      return (byte)(this.payload[++this.offset - 1] - 128);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-2031348670"
   )
   public byte method3396() {
      return (byte)(0 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "-53"
   )
   public byte method3466() {
      return (byte)(128 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "73"
   )
   @Export("writeIntLE16")
   public void writeIntLE16(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-100"
   )
   @Export("writeShortLE")
   public void writeShortLE(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1994653652"
   )
   @Export("putShortLE")
   public void putShortLE(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "3"
   )
   public int method3440() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1113123510"
   )
   @Export("readUnsignedShortOb1")
   public int readUnsignedShortOb1() {
      this.offset += 2;
      return (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1422025249"
   )
   public int method3442() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "86"
   )
   public int method3443() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1073018620"
   )
   public int method3457() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "834082205"
   )
   public void method3445(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-10688"
   )
   public int method3446() {
      this.offset += 3;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 3] & 255) << 8) + ((this.payload[this.offset - 2] & 255) << 16);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "8"
   )
   @Export("writeIntLE")
   public void writeIntLE(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "438181272"
   )
   public void method3387(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "96"
   )
   public void method3401(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-518912910"
   )
   public int method3450() {
      this.offset += 4;
      return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 3] & 255) << 8) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 24);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1878663998"
   )
   public int method3451() {
      this.offset += 4;
      return ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 8) + (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 1] & 255) << 16);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2061390466"
   )
   public int method3452() {
      this.offset += 4;
      return ((this.payload[this.offset - 1] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 16) + (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 3] & 255) << 24);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-553118630"
   )
   public void method3453(byte[] var1, int var2, int var3) {
      for(int var4 = var3 + var2 - 1; var4 >= var2; --var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IS)Ljava/io/File;",
      garbageValue = "6415"
   )
   public static File method3610(String var0, String var1, int var2) {
      String var3 = var2 == 0?"":"" + var2;
      class157.jagexClDat = new File(class299.userHome, "jagex_cl_" + var0 + "_" + var1 + var3 + ".dat");
      String var4 = null;
      String var5 = null;
      boolean var6 = false;
      int var11;
      File var26;
      if(class157.jagexClDat.exists()) {
         try {
            FileOnDisk var7 = new FileOnDisk(class157.jagexClDat, "rw", 10000L);

            Buffer var8;
            int var9;
            for(var8 = new Buffer((int)var7.length()); var8.offset < var8.payload.length; var8.offset += var9) {
               var9 = var7.read(var8.payload, var8.offset, var8.payload.length - var8.offset);
               if(var9 == -1) {
                  throw new IOException();
               }
            }

            var8.offset = 0;
            var9 = var8.readUnsignedByte();
            if(var9 < 1 || var9 > 3) {
               throw new IOException("" + var9);
            }

            int var10 = 0;
            if(var9 > 1) {
               var10 = var8.readUnsignedByte();
            }

            if(var9 <= 2) {
               var4 = var8.getJagString();
               if(var10 == 1) {
                  var5 = var8.getJagString();
               }
            } else {
               var4 = var8.getCESU8();
               if(var10 == 1) {
                  var5 = var8.getCESU8();
               }
            }

            var7.close();
         } catch (IOException var24) {
            var24.printStackTrace();
         }

         if(var4 != null) {
            var26 = new File(var4);
            if(!var26.exists()) {
               var4 = null;
            }
         }

         if(var4 != null) {
            var26 = new File(var4, "test.dat");

            boolean var27;
            try {
               RandomAccessFile var15 = new RandomAccessFile(var26, "rw");
               var11 = var15.read();
               var15.seek(0L);
               var15.write(var11);
               var15.seek(0L);
               var15.close();
               var26.delete();
               var27 = true;
            } catch (Exception var22) {
               var27 = false;
            }

            if(!var27) {
               var4 = null;
            }
         }
      }

      if(var4 == null && var2 == 0) {
         label136:
         for(int var16 = 0; var16 < WorldMapType2.field490.length; ++var16) {
            for(int var17 = 0; var17 < Size.cacheLocations.length; ++var17) {
               File var18 = new File(Size.cacheLocations[var17] + WorldMapType2.field490[var16] + File.separatorChar + var0 + File.separatorChar);
               if(var18.exists()) {
                  File var19 = new File(var18, "test.dat");

                  boolean var28;
                  try {
                     RandomAccessFile var12 = new RandomAccessFile(var19, "rw");
                     int var13 = var12.read();
                     var12.seek(0L);
                     var12.write(var13);
                     var12.seek(0L);
                     var12.close();
                     var19.delete();
                     var28 = true;
                  } catch (Exception var21) {
                     var28 = false;
                  }

                  if(var28) {
                     var4 = var18.toString();
                     var6 = true;
                     break label136;
                  }
               }
            }
         }
      }

      if(var4 == null) {
         var4 = class299.userHome + File.separatorChar + "jagexcache" + var3 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
         var6 = true;
      }

      if(var5 != null) {
         File var25 = new File(var5);
         var26 = new File(var4);

         try {
            File[] var31 = var25.listFiles();
            File[] var30 = var31;

            for(var11 = 0; var11 < var30.length; ++var11) {
               File var29 = var30[var11];
               File var20 = new File(var26, var29.getName());
               boolean var14 = var29.renameTo(var20);
               if(!var14) {
                  throw new IOException();
               }
            }
         } catch (Exception var23) {
            var23.printStackTrace();
         }

         var6 = true;
      }

      if(var6) {
         OwnWorldComparator.method1183(new File(var4), (File)null);
      }

      return new File(var4);
   }
}
