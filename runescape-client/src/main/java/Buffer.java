import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("m")
   @Export("crc32Table")
   static int[] crc32Table;
   @ObfuscatedName("i")
   @Export("crc64Table")
   static long[] crc64Table;
   @ObfuscatedName("s")
   @Export("payload")
   public byte[] payload;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -591835367
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
      this.payload = GrandExchangeEvents.method73(var1);
      this.offset = 0;
   }

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1326169496"
   )
   public void method3574() {
      if(this.payload != null) {
         class179.method3470(this.payload);
      }

      this.payload = null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-5"
   )
   @Export("putByte")
   public void putByte(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "34"
   )
   @Export("putShort")
   public void putShort(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-365537132"
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
      garbageValue = "-710702493"
   )
   @Export("putInt")
   public void putInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("t")
   public void method3496(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("d")
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1421487040"
   )
   @Export("writeBooleanAsByte")
   public void writeBooleanAsByte(boolean var1) {
      this.putByte(var1?1:0);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "16"
   )
   @Export("putString")
   public void putString(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += GameObject.encodeStringCp1252(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1271588338"
   )
   @Export("putJagString")
   public void putJagString(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += GameObject.encodeStringCp1252(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)V",
      garbageValue = "-1945605807"
   )
   @Export("putCESU8")
   public void putCESU8(CharSequence var1) {
      int var3 = var1.length();
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
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
      this.offset += BuildType.method4487(this.payload, this.offset, var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "2"
   )
   @Export("putBytes")
   public void putBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-758957673"
   )
   @Export("putLengthInt")
   public void putLengthInt(int var1) {
      this.payload[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.payload[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1078732074"
   )
   public void method3504(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "32796485"
   )
   public void method3505(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "317885712"
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2038865374"
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

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "748597262"
   )
   @Export("readUnsignedByte")
   public int readUnsignedByte() {
      return this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1900997948"
   )
   @Export("readByte")
   public byte readByte() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-863193644"
   )
   @Export("readUnsignedShort")
   public int readUnsignedShort() {
      this.offset += 2;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1263994301"
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

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1827038284"
   )
   @Export("read24BitInt")
   public int read24BitInt() {
      this.offset += 3;
      return ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-621406655"
   )
   @Export("readInt")
   public int readInt() {
      this.offset += 4;
      return ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 24);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "63"
   )
   @Export("readLong")
   public long readLong() {
      long var1 = (long)this.readInt() & 4294967295L;
      long var3 = (long)this.readInt() & 4294967295L;
      return (var1 << 32) + var3;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1192484694"
   )
   public boolean method3515() {
      return (this.readUnsignedByte() & 1) == 1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "53"
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

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1145824687"
   )
   @Export("readString")
   public String readString() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":ContextMenuRow.getString(this.payload, var1, var2);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-706593388"
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
         return var3 == 0?"":ContextMenuRow.getString(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-2096467166"
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

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "403171600"
   )
   @Export("readBytes")
   public void readBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-21202339"
   )
   @Export("readShortSmart")
   public int readShortSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - 49152;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2098590645"
   )
   @Export("getUSmart")
   public int getUSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte():this.readUnsignedShort() - 32768;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "156320007"
   )
   @Export("getLargeSmart")
   public int getLargeSmart() {
      return this.payload[this.offset] < 0?this.readInt() & Integer.MAX_VALUE:this.readUnsignedShort();
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-276980698"
   )
   public int method3715() {
      if(this.payload[this.offset] < 0) {
         return this.readInt() & Integer.MAX_VALUE;
      } else {
         int var1 = this.readUnsignedShort();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "26"
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

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-936143861"
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

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "46"
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

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-237181112"
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

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-525047462"
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

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "-628611808"
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
      signature = "(II)I",
      garbageValue = "980424513"
   )
   @Export("putCrc")
   public int putCrc(int var1) {
      int var2 = class65.method1060(this.payload, var1, this.offset);
      this.putInt(var2);
      return var2;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-824323071"
   )
   @Export("checkCrc")
   public boolean checkCrc() {
      this.offset -= 4;
      int var1 = class65.method1060(this.payload, 0, this.offset);
      int var2 = this.readInt();
      return var1 == var2;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-523581268"
   )
   public void method3533(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1588269218"
   )
   @Export("putShortLE")
   public void putShortLE(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-122"
   )
   public void method3535(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-82"
   )
   public int method3536() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1109048412"
   )
   public int method3506() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "586958922"
   )
   public int method3538() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-104890865"
   )
   public byte method3539() {
      return (byte)(this.payload[++this.offset - 1] - 128);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1556813594"
   )
   public byte method3540() {
      return (byte)(0 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "1096753981"
   )
   public byte method3541() {
      return (byte)(128 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2004741231"
   )
   public void method3542(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1066728640"
   )
   @Export("writeShortLE")
   public void writeShortLE(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-15"
   )
   @Export("writeIntLE16")
   public void writeIntLE16(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "37"
   )
   @Export("readUnsignedByteNegate")
   public int readUnsignedByteNegate() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1421667335"
   )
   @Export("readUnsignedShortOb1")
   public int readUnsignedShortOb1() {
      this.offset += 2;
      return (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method3547() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1359123503"
   )
   public int method3548() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-9"
   )
   public int method3549() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2062145656"
   )
   public int method3550() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1615280504"
   )
   public void method3551(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-44"
   )
   public int method3552() {
      this.offset += 3;
      return (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 1] & 255) << 16);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1009989856"
   )
   public void method3553(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "284073580"
   )
   public void method3554(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1140622040"
   )
   @Export("writeIntLE")
   public void writeIntLE(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1265489691"
   )
   public int method3556() {
      this.offset += 4;
      return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 3] & 255) << 8) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 24);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "653234831"
   )
   public int method3557() {
      this.offset += 4;
      return ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 8) + (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 1] & 255) << 16);
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1721582058"
   )
   public int method3722() {
      this.offset += 4;
      return ((this.payload[this.offset - 1] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 16) + (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 3] & 255) << 24);
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "110"
   )
   public void method3559(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = (byte)(this.payload[++this.offset - 1] - 128);
      }

   }

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1686403713"
   )
   public void method3560(byte[] var1, int var2, int var3) {
      for(int var4 = var3 + var2 - 1; var4 >= var2; --var4) {
         var1[var4] = (byte)(this.payload[++this.offset - 1] - 128);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method3749() {
      for(class79 var0 = (class79)class79.field1233.getFront(); var0 != null; var0 = (class79)class79.field1233.getNext()) {
         if(var0.field1234 != null) {
            var0.method1760();
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "0"
   )
   public static String method3707(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class292.field3797[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class292.field3797[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class292.field3797[(var6 & 15) << 2 | var7 >>> 6]).append(class292.field3797[var7 & 63]);
            } else {
               var3.append(class292.field3797[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class292.field3797[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "116"
   )
   public static void method3750() {
      class265.field3490.reset();
      class265.field3495.reset();
      class265.field3492.reset();
   }
}
