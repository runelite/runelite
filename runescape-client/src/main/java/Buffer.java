import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("i")
   @Export("crc32Table")
   static int[] crc32Table;
   @ObfuscatedName("l")
   @Export("crc64Table")
   static long[] crc64Table;
   @ObfuscatedName("aq")
   protected static boolean field2550;
   @ObfuscatedName("t")
   @Export("payload")
   public byte[] payload;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 507752683
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
      this.payload = RunException.method3218(var1);
      this.offset = 0;
   }

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "187811701"
   )
   public void method3520() {
      if(this.payload != null) {
         FriendManager.method1724(this.payload);
      }

      this.payload = null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "15"
   )
   @Export("putByte")
   public void putByte(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2143427659"
   )
   @Export("putShort")
   public void putShort(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "947718873"
   )
   @Export("put24bitInt")
   public void put24bitInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-956862309"
   )
   @Export("putInt")
   public void putInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("x")
   public void method3722(long var1) {
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   @Export("writeBooleanAsByte")
   public void writeBooleanAsByte(boolean var1) {
      this.putByte(var1?1:0);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1043856678"
   )
   @Export("putString")
   public void putString(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += ChatPlayer.encodeStringCp1252(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   @Export("putJagString")
   public void putJagString(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += ChatPlayer.encodeStringCp1252(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)V",
      garbageValue = "-58"
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
      this.offset = var5 + var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-73"
   )
   @Export("putBytes")
   public void putBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "553527330"
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
      signature = "(II)V",
      garbageValue = "-2048273507"
   )
   public void method3681(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1788513907"
   )
   public void method3534(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1844901814"
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "437059360"
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

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1304834792"
   )
   @Export("readUnsignedByte")
   public int readUnsignedByte() {
      return this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-771278545"
   )
   @Export("readByte")
   public byte readByte() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2120624130"
   )
   @Export("readUnsignedShort")
   public int readUnsignedShort() {
      this.offset += 2;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1363126656"
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

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1088134723"
   )
   @Export("read24BitInt")
   public int read24BitInt() {
      this.offset += 3;
      return ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "982959386"
   )
   @Export("readInt")
   public int readInt() {
      this.offset += 4;
      return ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 24);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-621357184"
   )
   @Export("readLong")
   public long readLong() {
      long var1 = (long)this.readInt() & 4294967295L;
      long var3 = (long)this.readInt() & 4294967295L;
      return (var1 << 32) + var3;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1296734568"
   )
   public boolean method3544() {
      return (this.readUnsignedByte() & 1) == 1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "-29853"
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

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "401569419"
   )
   @Export("readString")
   public String readString() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":MessageNode.getString(this.payload, var1, var2);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "59"
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
         return var3 == 0?"":MessageNode.getString(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "97"
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

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-402806804"
   )
   @Export("readBytes")
   public void readBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "994168670"
   )
   @Export("readShortSmart")
   public int readShortSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - 49152;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-456853093"
   )
   @Export("getUSmart")
   public int getUSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte():this.readUnsignedShort() - 32768;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1320498833"
   )
   @Export("getLargeSmart")
   public int getLargeSmart() {
      return this.payload[this.offset] < 0?this.readInt() & Integer.MAX_VALUE:this.readUnsignedShort();
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "125"
   )
   public int method3553() {
      if(this.payload[this.offset] < 0) {
         return this.readInt() & Integer.MAX_VALUE;
      } else {
         int var1 = this.readUnsignedShort();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "32"
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
      garbageValue = "32768"
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

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "-11"
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

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "33526847"
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

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "([IIIB)V",
      garbageValue = "-7"
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
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "-1107504358"
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

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-48"
   )
   @Export("putCrc")
   public int putCrc(int var1) {
      int var2 = class178.method3429(this.payload, var1, this.offset);
      this.putInt(var2);
      return var2;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-724480436"
   )
   @Export("checkCrc")
   public boolean checkCrc() {
      this.offset -= 4;
      int var1 = class178.method3429(this.payload, 0, this.offset);
      int var2 = this.readInt();
      return var2 == var1;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2133792888"
   )
   public void method3562(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-11"
   )
   public void method3619(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1744019542"
   )
   @Export("putShortLE")
   public void putShortLE(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-3"
   )
   public int method3565() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "8697"
   )
   public int method3566() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "151741568"
   )
   public int method3567() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "32528480"
   )
   public byte method3613() {
      return (byte)(this.payload[++this.offset - 1] - 128);
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "0"
   )
   public byte method3529() {
      return (byte)(0 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "1283855181"
   )
   public byte method3535() {
      return (byte)(128 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-14879"
   )
   public void method3519(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1351733442"
   )
   public void method3570(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1972854146"
   )
   public void method3573(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "128"
   )
   public int method3574() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "80"
   )
   @Export("readUnsignedShortOb1")
   public int readUnsignedShortOb1() {
      this.offset += 2;
      return (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1834227962"
   )
   public int method3576() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2038326954"
   )
   public int method3571() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-798888402"
   )
   public int method3693() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method3579() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "56"
   )
   public void method3695(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1773315645"
   )
   public int method3702() {
      this.offset += 3;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 3] & 255) << 8) + ((this.payload[this.offset - 2] & 255) << 16);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "25"
   )
   public void method3582(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1838209859"
   )
   public void method3713(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1374631388"
   )
   public void method3584(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1497947307"
   )
   public int method3585() {
      this.offset += 4;
      return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 3] & 255) << 8) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 24);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-422973512"
   )
   public int method3586() {
      this.offset += 4;
      return ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 8) + (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 1] & 255) << 16);
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1773582616"
   )
   public int method3587() {
      this.offset += 4;
      return ((this.payload[this.offset - 1] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 16) + (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 3] & 255) << 24);
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1775081844"
   )
   public void method3588(byte[] var1, int var2, int var3) {
      for(int var4 = var3 + var2 - 1; var4 >= var2; --var4) {
         var1[var4] = (byte)(this.payload[++this.offset - 1] - 128);
      }

   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-2039229805"
   )
   static final String method3763(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }
}
