import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 732834487
   )
   @Export("offset")
   public int offset;
   @ObfuscatedName("a")
   @Export("crc32Table")
   static int[] crc32Table;
   @ObfuscatedName("s")
   @Export("crc64Table")
   static long[] crc64Table;
   @ObfuscatedName("i")
   @Export("payload")
   public byte[] payload;
   @ObfuscatedName("ic")
   static Widget field2405;
   @ObfuscatedName("l")
   static int[] field2406;

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   public int method3130() {
      if(this.payload[this.offset] < 0) {
         return this.readInt() & Integer.MAX_VALUE;
      } else {
         int var1 = this.readUnsignedShort();
         return var1 == 32767?-1:var1;
      }
   }

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1236374861"
   )
   @Export("putByte")
   public void putByte(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "73"
   )
   @Export("put24bitInt")
   public void put24bitInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-34"
   )
   @Export("putInt")
   public void putInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("r")
   public void method3135(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("v")
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2086193595"
   )
   @Export("putString")
   public void putString(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += class40.method563(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-896120651"
   )
   @Export("putJagString")
   public void putJagString(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += class40.method563(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)V",
      garbageValue = "1746134262"
   )
   @Export("putCESU8")
   public void putCESU8(CharSequence var1) {
      int var2 = class227.method4083(var1);
      this.payload[++this.offset - 1] = 0;
      this.putVarInt(var2);
      this.offset += class41.method590(this.payload, this.offset, var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "70712228"
   )
   @Export("putBytes")
   public void putBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1075620353"
   )
   @Export("putShortLength")
   public void putShortLength(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-334108585"
   )
   @Export("putShortSmart")
   public void putShortSmart(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.putByte(var1);
      } else {
         if(var1 < 0 || var1 >= '耀') {
            throw new IllegalArgumentException();
         }

         this.putShort(var1 + '耀');
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-10"
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1229885988"
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
      signature = "(I)I",
      garbageValue = "-1557658956"
   )
   @Export("readUnsignedShort")
   public int readUnsignedShort() {
      this.offset += 2;
      return ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1617798274"
   )
   @Export("readString")
   public String readString() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":class48.getString(this.payload, var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-618066285"
   )
   @Export("readInt")
   public int readInt() {
      this.offset += 4;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 24) + ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "649471868"
   )
   @Export("putCrc")
   public int putCrc(int var1) {
      int var2 = class27.method208(this.payload, var1, this.offset);
      this.putInt(var2);
      return var2;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "2123080036"
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
         return var3 == 0?"":class48.getString(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "899145730"
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
            String var3 = class37.decodeCESU8(this.payload, this.offset, var2);
            this.offset += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2087047576"
   )
   @Export("readBytes")
   public void readBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1967534858"
   )
   @Export("readShortSmart")
   public int readShortSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - '쀀';
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "284628155"
   )
   @Export("getUSmart")
   public int getUSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte():this.readUnsignedShort() - '耀';
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "-33"
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

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6;
            var6 += var7;
         }

         this.offset -= 8;
         this.putInt(var4);
         this.putInt(var5);
      }

   }

   public Buffer(int var1) {
      this.payload = class174.method3342(var1);
      this.offset = 0;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-2093907193"
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
            var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ var1[var9 & 3] + var9;
            var9 += var10;
         }

         this.offset -= 8;
         this.putInt(var7);
         this.putInt(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "([IIIB)V",
      garbageValue = "-90"
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

         for(int var11 = 32; var11-- > 0; var7 -= (var8 << 4 ^ var8 >>> 5) + var8 ^ var1[var9 & 3] + var9) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.offset -= 8;
         this.putInt(var7);
         this.putInt(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "749932241"
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
      signature = "(IS)V",
      garbageValue = "-32467"
   )
   public void method3167(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1826459633"
   )
   @Export("checkCrc")
   public boolean checkCrc() {
      this.offset -= 4;
      int var1 = class27.method208(this.payload, 0, this.offset);
      int var2 = this.readInt();
      return var2 == var1;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "640482974"
   )
   @Export("putShortLE")
   public void putShortLE(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "1009065296"
   )
   public byte method3172() {
      return (byte)(0 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "587575880"
   )
   public int method3173() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1891923345"
   )
   public int method3175() {
      this.offset += 4;
      return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 3] & 255) << 8) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 24);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1313789342"
   )
   @Export("readLong")
   public long readLong() {
      long var1 = (long)this.readInt() & 4294967295L;
      long var3 = (long)this.readInt() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2040516073"
   )
   @Export("putIntOb1")
   public void putIntOb1(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "587444852"
   )
   @Export("putLEShortA")
   public void putLEShortA(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1641854430"
   )
   @Export("readUnsignedShortOb1")
   public int readUnsignedShortOb1() {
      this.offset += 2;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1312110314"
   )
   @Export("readByteOb1")
   public int readByteOb1() {
      this.offset += 2;
      return (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1683749661"
   )
   @Export("read24BitInt")
   public int read24BitInt() {
      this.offset += 3;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "33"
   )
   public void method3184(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-68951579"
   )
   @Export("getLargeSmart")
   public int getLargeSmart() {
      return this.payload[this.offset] < 0?this.readInt() & Integer.MAX_VALUE:this.readUnsignedShort();
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "9"
   )
   @Export("putLEInt")
   public void putLEInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "43"
   )
   @Export("readShortOb3")
   public int readShortOb3() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 2] - 128 & 255) + ((this.payload[this.offset - 1] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "3"
   )
   @Export("readIntOb3")
   public int readIntOb3() {
      this.offset += 4;
      return ((this.payload[this.offset - 1] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 8) + (this.payload[this.offset - 3] & 255);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1915747322"
   )
   public int method3190() {
      this.offset += 4;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 4] & 255) << 16) + ((this.payload[this.offset - 3] & 255) << 24) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "-13"
   )
   @Export("readByte")
   public byte readByte() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(S)B",
      garbageValue = "173"
   )
   public byte method3207() {
      return (byte)(this.payload[++this.offset - 1] - 128);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-689980571"
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

         for(int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6) {
            var5 -= (var4 << 4 ^ var4 >>> 5) + var4 ^ var1[var6 >>> 11 & 3] + var6;
            var6 -= var7;
         }

         this.offset -= 8;
         this.putInt(var4);
         this.putInt(var5);
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-912102004"
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

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "34"
   )
   public void method3233(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   @Export("putLength")
   public void putLength(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-677567341"
   )
   @Export("putShort")
   public void putShort(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "3"
   )
   public void method3257(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "41"
   )
   public void method3265(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-119"
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1225206687"
   )
   @Export("readShort")
   public int readShort() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "50"
   )
   public int method3292() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1614566290"
   )
   public int method3318() {
      this.offset += 2;
      return (this.payload[this.offset - 2] - 128 & 255) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-584755208"
   )
   @Export("putShortOb2")
   public void putShortOb2(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int method3324() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-56"
   )
   @Export("readUnsignedByte")
   public int readUnsignedByte() {
      return this.payload[++this.offset - 1] & 255;
   }

   static {
      crc32Table = new int[256];

      int var0;
      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = var1;

         for(var0 = 0; var0 < 8; ++var0) {
            if((var2 & 1) == 1) {
               var2 = var2 >>> 1 ^ -306674912;
            } else {
               var2 >>>= 1;
            }
         }

         crc32Table[var1] = var2;
      }

      crc64Table = new long[256];

      for(var0 = 0; var0 < 256; ++var0) {
         long var4 = (long)var0;

         for(int var3 = 0; var3 < 8; ++var3) {
            if(1L == (var4 & 1L)) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         crc64Table[var0] = var4;
      }

   }
}
