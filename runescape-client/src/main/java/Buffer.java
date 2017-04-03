import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1847016227
   )
   @Export("offset")
   public int offset;
   @ObfuscatedName("r")
   static long[] field2112;
   @ObfuscatedName("f")
   @Export("payload")
   public byte[] payload;
   @ObfuscatedName("u")
   static int[] field2115 = new int[256];

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-588761303"
   )
   public int method2851() {
      this.offset += 3;
      return ((this.payload[this.offset - 1] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 3] & 255);
   }

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-777998984"
   )
   @Export("putByte")
   public void putByte(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1078171618"
   )
   public int method2853() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "24558"
   )
   @Export("putInt")
   public void putInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("n")
   @Export("put48bitLong")
   public void put48bitLong(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("m")
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

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "1"
   )
   public String method2859() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.readVarInt();
         if(var2 + this.offset > this.payload.length) {
            throw new IllegalStateException("");
         } else {
            String var3 = class72.method1440(this.payload, this.offset, var2);
            this.offset += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)V",
      garbageValue = "-1698945613"
   )
   public void method2860(CharSequence var1) {
      int var2 = class15.method168(var1);
      this.payload[++this.offset - 1] = 0;
      this.putVarInt(var2);
      this.offset += class186.method3481(this.payload, this.offset, var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1615755660"
   )
   @Export("putBytes")
   public void putBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1621415166"
   )
   public void method2864(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1725016043"
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

         for(int var8 = 32; var8-- > 0; var4 -= (var5 << 4 ^ var5 >>> 5) + var5 ^ var6 + var1[var6 & 3]) {
            var5 -= (var4 << 4 ^ var4 >>> 5) + var4 ^ var1[var6 >>> 11 & 3] + var6;
            var6 -= var7;
         }

         this.offset -= 8;
         this.putInt(var4);
         this.putInt(var5);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2106934821"
   )
   @Export("readUnsignedByte")
   public int readUnsignedByte() {
      return this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-791604181"
   )
   @Export("readByte")
   public byte readByte() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-83"
   )
   @Export("readUnsignedShort")
   public int readUnsignedShort() {
      this.offset += 2;
      return ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-35"
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   @Export("read24BitInt")
   public int read24BitInt() {
      this.offset += 3;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1790331341"
   )
   @Export("readString")
   public String readString() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":class139.method2679(this.payload, var1, var2);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "488476901"
   )
   public String method2876() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.offset;

         while(this.payload[++this.offset - 1] != 0) {
            ;
         }

         int var3 = this.offset - var2 - 1;
         return var3 == 0?"":class139.method2679(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1609768938"
   )
   @Export("readBytes")
   public void readBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1921014398"
   )
   public int method2880() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte():this.readUnsignedShort() - '耀';
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method2881() {
      return this.payload[this.offset] < 0?this.readInt() & Integer.MAX_VALUE:this.readUnsignedShort();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1477123898"
   )
   public int method2882() {
      if(this.payload[this.offset] < 0) {
         return this.readInt() & Integer.MAX_VALUE;
      } else {
         int var1 = this.readUnsignedShort();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2013894330"
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

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1474038298"
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
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6;
            var6 += var7;
         }

         this.offset -= 8;
         this.putInt(var4);
         this.putInt(var5);
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "2018752133"
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

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "-179123706"
   )
   public void method2888(BigInteger var1, BigInteger var2) {
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
      signature = "(II)I",
      garbageValue = "2123400593"
   )
   public int method2889(int var1) {
      int var2 = RSSocket.method2119(this.payload, var1, this.offset);
      this.putInt(var2);
      return var2;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1157723311"
   )
   public void method2891(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "884994425"
   )
   public void method2892(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-22807"
   )
   public void method2893(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "69"
   )
   public void method2895(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1318152652"
   )
   @Export("readInt")
   public int readInt() {
      this.offset += 4;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 3] & 255) << 16) + ((this.payload[this.offset - 4] & 255) << 24) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "26"
   )
   public byte method2898() {
      return (byte)(128 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1797405993"
   )
   public void method2900(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1710005119"
   )
   public int method2903() {
      this.offset += 2;
      return (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2033742952"
   )
   public int method2904() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "307390588"
   )
   public void method2908(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-775500506"
   )
   public void method2909(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1347076710"
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

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "17"
   )
   public int method2912() {
      this.offset += 4;
      return ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 1] & 255) << 16) + ((this.payload[this.offset - 4] & 255) << 8) + (this.payload[this.offset - 3] & 255);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "200181727"
   )
   public int method2913() {
      this.offset += 4;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 1] & 255) << 8) + ((this.payload[this.offset - 3] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 16);
   }

   static {
      int var2;
      for(int var1 = 0; var1 < 256; ++var1) {
         int var4 = var1;

         for(var2 = 0; var2 < 8; ++var2) {
            if((var4 & 1) == 1) {
               var4 = var4 >>> 1 ^ -306674912;
            } else {
               var4 >>>= 1;
            }
         }

         field2115[var1] = var4;
      }

      field2112 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var0 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if((var0 & 1L) == 1L) {
               var0 = var0 >>> 1 ^ -3932672073523589310L;
            } else {
               var0 >>>= 1;
            }
         }

         field2112[var2] = var0;
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1815678754"
   )
   @Export("readShortSmart")
   public int readShortSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - '쀀';
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "2"
   )
   public int method2921() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public String method2922() {
      if(this.payload[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.readString();
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "1361186649"
   )
   public void method2924(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.readInt();
         int var8 = this.readInt();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= (var8 << 4 ^ var8 >>> 5) + var8 ^ var1[var9 & 3] + var9) {
            var8 -= (var7 << 4 ^ var7 >>> 5) + var7 ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.offset -= 8;
         this.putInt(var7);
         this.putInt(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-67"
   )
   @Export("readLong")
   public long readLong() {
      long var1 = (long)this.readInt() & 4294967295L;
      long var3 = (long)this.readInt() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1584135130"
   )
   public void method2931(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += class139.method2681(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-640199760"
   )
   public void method2932(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.putByte(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.putShort('耀' + var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1543803486"
   )
   public void method2933(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += class139.method2681(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1586072711"
   )
   public int method2939() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2043795006"
   )
   public boolean method2943() {
      this.offset -= 4;
      int var1 = RSSocket.method2119(this.payload, 0, this.offset);
      int var2 = this.readInt();
      return var1 == var2;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "94"
   )
   public void method2950(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1860080053"
   )
   @Export("put24bitInt")
   public void put24bitInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   public Buffer(int var1) {
      this.payload = class154.method3067(var1);
      this.offset = 0;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "-22"
   )
   public byte method2960() {
      return (byte)(this.payload[++this.offset - 1] - 128);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1599116185"
   )
   public void method2973(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 + var1);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2023960291"
   )
   @Export("putShort")
   public void putShort(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   public int method3006() {
      this.offset += 4;
      return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 1] & 255) << 24) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 3] & 255) << 8);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1853643343"
   )
   public int method3015() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1373011373"
   )
   public void method3023(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1291669635"
   )
   public void method3046(int var1) {
      this.payload[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.payload[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-786815766"
   )
   public void method3048(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1305342582"
   )
   public int method3051() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LGameEngine;I)V",
      garbageValue = "-712142337"
   )
   static void method3064(GameEngine var0) {
      if(class41.worldSelectShown) {
         class3.method26(var0);
      } else {
         int var2;
         int var3;
         if((class115.field1823 == 1 || !class177.field2687 && class115.field1823 == 4) && class115.field1825 >= class41.field859 + 765 - 50 && class115.field1813 >= 453) {
            class148.field2058.field719 = !class148.field2058.field719;
            class150.method2839();
            if(!class148.field2058.field719) {
               IndexData var9 = Client.indexTrack1;
               var2 = var9.method3351("scape main");
               var3 = var9.method3352(var2, "");
               TextureProvider.method1487(var9, var2, var3, 255, false);
            } else {
               TextureProvider.method1486();
            }
         }

         if(Client.gameState != 5) {
            ++class41.field849;
            if(Client.gameState == 10 || Client.gameState == 11) {
               int var1;
               if(Client.field308 == 0) {
                  if(class115.field1823 == 1 || !class177.field2687 && class115.field1823 == 4) {
                     var1 = class41.field859 + 5;
                     short var10 = 463;
                     byte var11 = 100;
                     byte var4 = 35;
                     if(class115.field1825 >= var1 && class115.field1825 <= var1 + var11 && class115.field1813 >= var10 && class115.field1813 <= var10 + var4) {
                        class156.method3086();
                        return;
                     }
                  }

                  if(null != class15.worldServersDownload) {
                     class156.method3086();
                  }
               }

               var1 = class115.field1823;
               var2 = class115.field1825;
               var3 = class115.field1813;
               if(!class177.field2687 && var1 == 4) {
                  var1 = 1;
               }

               int var5;
               short var6;
               if(class41.loginIndex == 0) {
                  boolean var12 = false;

                  while(ItemLayer.method1491()) {
                     if(class203.field3084 == 84) {
                        var12 = true;
                     }
                  }

                  var5 = 180 + class41.loginWindowX - 80;
                  var6 = 291;
                  if(var1 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                     World.method612(class173.method3310("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
                  }

                  var5 = 180 + class41.loginWindowX + 80;
                  if(var1 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= var6 + 20 || var12) {
                     if((Client.flags & 33554432) != 0) {
                        class41.field854 = "";
                        class41.loginMessage1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
                        class41.loginMessage2 = "Your normal account will not be affected.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 4) != 0) {
                        if((Client.flags & 1024) != 0) {
                           class41.loginMessage1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other almost everywhere";
                           class41.loginMessage3 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class41.loginMessage1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class41.loginMessage2 = "Players can attack each other";
                           class41.loginMessage3 = "almost everywhere.";
                        }

                        class41.field854 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else if((Client.flags & 1024) != 0) {
                        class41.loginMessage1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class41.loginMessage2 = "The Protect Item prayer will";
                        class41.loginMessage3 = "not work on this world.";
                        class41.field854 = "Warning!";
                        class41.loginIndex = 1;
                        class41.loginIndex2 = 0;
                     } else {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }
                  }
               } else {
                  int var13;
                  short var15;
                  if(class41.loginIndex != 1) {
                     short var14;
                     if(class41.loginIndex == 2) {
                        var14 = 231;
                        var13 = var14 + 30;
                        if(var1 == 1 && var3 >= var13 - 15 && var3 < var13) {
                           class41.loginIndex2 = 0;
                        }

                        var13 += 15;
                        if(var1 == 1 && var3 >= var13 - 15 && var3 < var13) {
                           class41.loginIndex2 = 1;
                        }

                        var13 += 15;
                        var14 = 361;
                        if(var1 == 1 && var3 >= var14 - 15 && var3 < var14) {
                           class65.method1204("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class41.loginIndex = 5;
                           return;
                        }

                        var5 = class41.loginWindowX + 180 - 80;
                        var6 = 321;
                        if(var1 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                           class41.username = class41.username.trim();
                           if(class41.username.length() == 0) {
                              class65.method1204("", "Please enter your username/email address.", "");
                              return;
                           }

                           if(class41.password.length() == 0) {
                              class65.method1204("", "Please enter your password.", "");
                              return;
                           }

                           class65.method1204("", "Connecting to server...", "");
                           class41.field858 = class148.field2058.field715.containsKey(Integer.valueOf(class108.method2088(class41.username)))?class97.field1655:class97.field1651;
                           GameObject.setGameState(20);
                           return;
                        }

                        var5 = 80 + class41.loginWindowX + 180;
                        if(var1 == 1 && var2 >= var5 - 75 && var2 <= var5 + 75 && var3 >= var6 - 20 && var3 <= 20 + var6) {
                           class41.loginIndex = 0;
                           class41.username = "";
                           class41.password = "";
                           CombatInfo1.field683 = 0;
                           Ignore.authCode = "";
                           class41.field861 = true;
                        }

                        while(true) {
                           while(ItemLayer.method1491()) {
                              boolean var7 = false;

                              for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                                 if(class37.field810 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                    var7 = true;
                                    break;
                                 }
                              }

                              if(class203.field3084 == 13) {
                                 class41.loginIndex = 0;
                                 class41.username = "";
                                 class41.password = "";
                                 CombatInfo1.field683 = 0;
                                 Ignore.authCode = "";
                                 class41.field861 = true;
                              } else if(class41.loginIndex2 == 0) {
                                 if(class203.field3084 == 85 && class41.username.length() > 0) {
                                    class41.username = class41.username.substring(0, class41.username.length() - 1);
                                 }

                                 if(class203.field3084 == 84 || class203.field3084 == 80) {
                                    class41.loginIndex2 = 1;
                                 }

                                 if(var7 && class41.username.length() < 320) {
                                    class41.username = class41.username + class37.field810;
                                 }
                              } else if(class41.loginIndex2 == 1) {
                                 if(class203.field3084 == 85 && class41.password.length() > 0) {
                                    class41.password = class41.password.substring(0, class41.password.length() - 1);
                                 }

                                 if(class203.field3084 == 84 || class203.field3084 == 80) {
                                    class41.loginIndex2 = 0;
                                 }

                                 if(class203.field3084 == 84) {
                                    class41.username = class41.username.trim();
                                    if(class41.username.length() == 0) {
                                       class65.method1204("", "Please enter your username/email address.", "");
                                       return;
                                    }

                                    if(class41.password.length() == 0) {
                                       class65.method1204("", "Please enter your password.", "");
                                       return;
                                    }

                                    class65.method1204("", "Connecting to server...", "");
                                    class41.field858 = class148.field2058.field715.containsKey(Integer.valueOf(class108.method2088(class41.username)))?class97.field1655:class97.field1651;
                                    GameObject.setGameState(20);
                                    return;
                                 }

                                 if(var7 && class41.password.length() < 20) {
                                    class41.password = class41.password + class37.field810;
                                 }
                              }
                           }

                           return;
                        }
                     } else if(class41.loginIndex == 3) {
                        var13 = class41.loginWindowX + 180;
                        var15 = 276;
                        if(var1 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var15 - 20 && var3 <= 20 + var15) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                        }

                        var13 = class41.loginWindowX + 180;
                        var15 = 326;
                        if(var1 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var15 - 20 && var3 <= 20 + var15) {
                           class65.method1204("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                           class41.loginIndex = 5;
                           return;
                        }
                     } else {
                        boolean var16;
                        int var17;
                        if(class41.loginIndex == 4) {
                           var13 = 180 + class41.loginWindowX - 80;
                           var15 = 321;
                           if(var1 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                              Ignore.authCode.trim();
                              if(Ignore.authCode.length() != 6) {
                                 class65.method1204("", "Please enter a 6-digit PIN.", "");
                                 return;
                              }

                              CombatInfo1.field683 = Integer.parseInt(Ignore.authCode);
                              Ignore.authCode = "";
                              class41.field858 = class41.field861?class97.field1650:class97.field1649;
                              class65.method1204("", "Connecting to server...", "");
                              GameObject.setGameState(20);
                              return;
                           }

                           if(var1 == 1 && var2 >= class41.loginWindowX + 180 - 9 && var2 <= 130 + 180 + class41.loginWindowX && var3 >= 263 && var3 <= 296) {
                              class41.field861 = !class41.field861;
                           }

                           if(var1 == 1 && var2 >= 180 + class41.loginWindowX - 34 && var2 <= class41.loginWindowX + 180 + 34 && var3 >= 351 && var3 <= 363) {
                              World.method612(class173.method3310("secure", true) + "m=totp-authenticator/disableTOTPRequest", true, false);
                           }

                           var13 = class41.loginWindowX + 180 + 80;
                           if(var1 == 1 && var2 >= var13 - 75 && var2 <= 75 + var13 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                              class41.loginIndex = 0;
                              class41.username = "";
                              class41.password = "";
                              CombatInfo1.field683 = 0;
                              Ignore.authCode = "";
                           }

                           while(ItemLayer.method1491()) {
                              var16 = false;

                              for(var17 = 0; var17 < "1234567890".length(); ++var17) {
                                 if(class37.field810 == "1234567890".charAt(var17)) {
                                    var16 = true;
                                    break;
                                 }
                              }

                              if(class203.field3084 == 13) {
                                 class41.loginIndex = 0;
                                 class41.username = "";
                                 class41.password = "";
                                 CombatInfo1.field683 = 0;
                                 Ignore.authCode = "";
                              } else {
                                 if(class203.field3084 == 85 && Ignore.authCode.length() > 0) {
                                    Ignore.authCode = Ignore.authCode.substring(0, Ignore.authCode.length() - 1);
                                 }

                                 if(class203.field3084 == 84) {
                                    Ignore.authCode.trim();
                                    if(Ignore.authCode.length() != 6) {
                                       class65.method1204("", "Please enter a 6-digit PIN.", "");
                                       return;
                                    }

                                    CombatInfo1.field683 = Integer.parseInt(Ignore.authCode);
                                    Ignore.authCode = "";
                                    class41.field858 = class41.field861?class97.field1650:class97.field1649;
                                    class65.method1204("", "Connecting to server...", "");
                                    GameObject.setGameState(20);
                                    return;
                                 }

                                 if(var16 && Ignore.authCode.length() < 6) {
                                    Ignore.authCode = Ignore.authCode + class37.field810;
                                 }
                              }
                           }
                        } else if(class41.loginIndex == 5) {
                           var13 = class41.loginWindowX + 180 - 80;
                           var15 = 321;
                           if(var1 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                              class16.method171();
                              return;
                           }

                           var13 = 180 + class41.loginWindowX + 80;
                           if(var1 == 1 && var2 >= var13 - 75 && var2 <= 75 + var13 && var3 >= var15 - 20 && var3 <= 20 + var15) {
                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.password = "";
                           }

                           while(ItemLayer.method1491()) {
                              var16 = false;

                              for(var17 = 0; var17 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var17) {
                                 if(class37.field810 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var17)) {
                                    var16 = true;
                                    break;
                                 }
                              }

                              if(class203.field3084 == 13) {
                                 class41.loginMessage1 = "";
                                 class41.loginMessage2 = "Enter your username/email & password.";
                                 class41.loginMessage3 = "";
                                 class41.loginIndex = 2;
                                 class41.loginIndex2 = 0;
                                 class41.password = "";
                              } else {
                                 if(class203.field3084 == 85 && class41.username.length() > 0) {
                                    class41.username = class41.username.substring(0, class41.username.length() - 1);
                                 }

                                 if(class203.field3084 == 84) {
                                    class16.method171();
                                    return;
                                 }

                                 if(var16 && class41.username.length() < 320) {
                                    class41.username = class41.username + class37.field810;
                                 }
                              }
                           }
                        } else if(class41.loginIndex == 6) {
                           while(true) {
                              do {
                                 if(!ItemLayer.method1491()) {
                                    var14 = 321;
                                    if(var1 == 1 && var3 >= var14 - 20 && var3 <= 20 + var14) {
                                       class41.loginMessage1 = "";
                                       class41.loginMessage2 = "Enter your username/email & password.";
                                       class41.loginMessage3 = "";
                                       class41.loginIndex = 2;
                                       class41.loginIndex2 = 0;
                                       class41.password = "";
                                    }

                                    return;
                                 }
                              } while(class203.field3084 != 84 && class203.field3084 != 13);

                              class41.loginMessage1 = "";
                              class41.loginMessage2 = "Enter your username/email & password.";
                              class41.loginMessage3 = "";
                              class41.loginIndex = 2;
                              class41.loginIndex2 = 0;
                              class41.password = "";
                           }
                        }
                     }
                  } else {
                     while(ItemLayer.method1491()) {
                        if(class203.field3084 == 84) {
                           class41.loginMessage1 = "";
                           class41.loginMessage2 = "Enter your username/email & password.";
                           class41.loginMessage3 = "";
                           class41.loginIndex = 2;
                           class41.loginIndex2 = 0;
                        } else if(class203.field3084 == 13) {
                           class41.loginIndex = 0;
                        }
                     }

                     var13 = class41.loginWindowX + 180 - 80;
                     var15 = 321;
                     if(var1 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var15 - 20 && var3 <= 20 + var15) {
                        class41.loginMessage1 = "";
                        class41.loginMessage2 = "Enter your username/email & password.";
                        class41.loginMessage3 = "";
                        class41.loginIndex = 2;
                        class41.loginIndex2 = 0;
                     }

                     var13 = 180 + class41.loginWindowX + 80;
                     if(var1 == 1 && var2 >= var13 - 75 && var2 <= var13 + 75 && var3 >= var15 - 20 && var3 <= var15 + 20) {
                        class41.loginIndex = 0;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "8"
   )
   static final void method3065(int var0, int var1, int var2, int var3) {
      ++Client.field337;
      class10.method115(class15.field174);
      boolean var4 = false;
      int var5;
      int var7;
      if(Client.field340 >= 0) {
         var5 = class45.field923;
         int[] var6 = class45.field918;

         for(var7 = 0; var7 < var5; ++var7) {
            if(Client.field340 == var6[var7]) {
               var4 = true;
               break;
            }
         }
      }

      if(var4) {
         class10.method115(class15.field167);
      }

      class94.method1952(true);
      class10.method115(var4?class15.field169:class15.field168);
      class94.method1952(false);
      NPC.method750();

      for(class33 var28 = (class33)Client.field391.method2464(); null != var28; var28 = (class33)Client.field391.method2472()) {
         if(var28.field759 == Sequence.plane && !var28.field766) {
            if(Client.gameCycle >= var28.field772) {
               var28.method711(Client.field511);
               if(var28.field766) {
                  var28.unlink();
               } else {
                  CombatInfo1.region.method1747(var28.field759, var28.field757, var28.field768, var28.field762, 60, var28, 0, -1, false);
               }
            }
         } else {
            var28.unlink();
         }
      }

      XItemContainer.method154(var0, var1, var2, var3, true);
      var0 = Client.field565;
      var1 = Client.field566;
      var2 = Client.camera2;
      var3 = Client.camera3;
      Rasterizer2D.method4001(var0, var1, var0 + var2, var3 + var1);
      class84.method1671();
      int var29;
      if(!Client.field446) {
         var5 = Client.field398;
         if(Client.field394 / 256 > var5) {
            var5 = Client.field394 / 256;
         }

         if(Client.field552[4] && Client.field356[4] + 128 > var5) {
            var5 = Client.field356[4] + 128;
         }

         var29 = Client.field370 + Client.mapAngle & 2047;
         class94.method1953(class36.field786, class103.method2025(Projectile.localPlayer.x, Projectile.localPlayer.y, Sequence.plane) - Client.field572, class180.field2720, var5, var29, 3 * var5 + 600);
      }

      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      if(!Client.field446) {
         if(class148.field2058.field716) {
            var29 = Sequence.plane;
         } else {
            label668: {
               var7 = 3;
               if(class16.cameraPitch < 310) {
                  var8 = MessageNode.cameraX >> 7;
                  var9 = DecorativeObject.cameraY >> 7;
                  var10 = Projectile.localPlayer.x >> 7;
                  var11 = Projectile.localPlayer.y >> 7;
                  if(var8 < 0 || var9 < 0 || var8 >= 104 || var9 >= 104) {
                     var29 = Sequence.plane;
                     break label668;
                  }

                  if((class10.tileSettings[Sequence.plane][var8][var9] & 4) != 0) {
                     var7 = Sequence.plane;
                  }

                  if(var10 > var8) {
                     var12 = var10 - var8;
                  } else {
                     var12 = var8 - var10;
                  }

                  if(var11 > var9) {
                     var13 = var11 - var9;
                  } else {
                     var13 = var9 - var11;
                  }

                  if(var12 > var13) {
                     var14 = var13 * 65536 / var12;
                     var15 = '耀';

                     while(var10 != var8) {
                        if(var8 < var10) {
                           ++var8;
                        } else if(var8 > var10) {
                           --var8;
                        }

                        if((class10.tileSettings[Sequence.plane][var8][var9] & 4) != 0) {
                           var7 = Sequence.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var9 < var11) {
                              ++var9;
                           } else if(var9 > var11) {
                              --var9;
                           }

                           if((class10.tileSettings[Sequence.plane][var8][var9] & 4) != 0) {
                              var7 = Sequence.plane;
                           }
                        }
                     }
                  } else {
                     var14 = 65536 * var12 / var13;
                     var15 = '耀';

                     while(var9 != var11) {
                        if(var9 < var11) {
                           ++var9;
                        } else if(var9 > var11) {
                           --var9;
                        }

                        if((class10.tileSettings[Sequence.plane][var8][var9] & 4) != 0) {
                           var7 = Sequence.plane;
                        }

                        var15 += var14;
                        if(var15 >= 65536) {
                           var15 -= 65536;
                           if(var8 < var10) {
                              ++var8;
                           } else if(var8 > var10) {
                              --var8;
                           }

                           if((class10.tileSettings[Sequence.plane][var8][var9] & 4) != 0) {
                              var7 = Sequence.plane;
                           }
                        }
                     }
                  }
               }

               if(Projectile.localPlayer.x >= 0 && Projectile.localPlayer.y >= 0 && Projectile.localPlayer.x < 13312 && Projectile.localPlayer.y < 13312) {
                  if((class10.tileSettings[Sequence.plane][Projectile.localPlayer.x >> 7][Projectile.localPlayer.y >> 7] & 4) != 0) {
                     var7 = Sequence.plane;
                  }

                  var29 = var7;
               } else {
                  var29 = Sequence.plane;
               }
            }
         }

         var5 = var29;
      } else {
         var5 = class7.method87();
      }

      var29 = MessageNode.cameraX;
      var7 = class16.cameraZ;
      var8 = DecorativeObject.cameraY;
      var9 = class16.cameraPitch;
      var10 = class9.cameraYaw;

      for(var11 = 0; var11 < 5; ++var11) {
         if(Client.field552[var11]) {
            var12 = (int)(Math.random() * (double)(1 + 2 * Client.field482[var11]) - (double)Client.field482[var11] + Math.sin((double)Client.field383[var11] / 100.0D * (double)Client.field413[var11]) * (double)Client.field356[var11]);
            if(var11 == 0) {
               MessageNode.cameraX += var12;
            }

            if(var11 == 1) {
               class16.cameraZ += var12;
            }

            if(var11 == 2) {
               DecorativeObject.cameraY += var12;
            }

            if(var11 == 3) {
               class9.cameraYaw = class9.cameraYaw + var12 & 2047;
            }

            if(var11 == 4) {
               class16.cameraPitch += var12;
               if(class16.cameraPitch < 128) {
                  class16.cameraPitch = 128;
               }

               if(class16.cameraPitch > 383) {
                  class16.cameraPitch = 383;
               }
            }
         }
      }

      var11 = class115.field1817;
      var12 = class115.field1818;
      if(class115.field1823 != 0) {
         var11 = class115.field1825;
         var12 = class115.field1813;
      }

      if(var11 >= var0 && var11 < var0 + var2 && var12 >= var1 && var12 < var3 + var1) {
         Model.field1431 = true;
         Model.field1421 = 0;
         Model.field1408 = var11 - var0;
         Model.field1433 = var12 - var1;
      } else {
         Model.field1431 = false;
         Model.field1421 = 0;
      }

      World.method596();
      Rasterizer2D.method4007(var0, var1, var2, var3, 0);
      World.method596();
      var13 = class84.field1461;
      class84.field1461 = Client.scale;
      CombatInfo1.region.method1893(MessageNode.cameraX, class16.cameraZ, DecorativeObject.cameraY, class16.cameraPitch, class9.cameraYaw, var5);
      class84.field1461 = var13;
      World.method596();
      CombatInfo1.region.method1880();
      Client.field395 = 0;
      boolean var32 = false;
      var15 = -1;
      int var16 = class45.field923;
      int[] var17 = class45.field918;

      int var18;
      for(var18 = 0; var18 < var16 + Client.field402; ++var18) {
         Object var31;
         if(var18 < var16) {
            var31 = Client.cachedPlayers[var17[var18]];
            if(Client.field340 == var17[var18]) {
               var32 = true;
               var15 = var18;
               continue;
            }
         } else {
            var31 = Client.cachedNPCs[Client.field342[var18 - var16]];
         }

         Widget.method3299((Actor)var31, var18, var0, var1, var2, var3);
      }

      if(var32) {
         Widget.method3299(Client.cachedPlayers[Client.field340], var15, var0, var1, var2, var3);
      }

      for(var18 = 0; var18 < Client.field395; ++var18) {
         int var19 = Client.field397[var18];
         int var20 = Client.field380[var18];
         int var21 = Client.field444[var18];
         int var22 = Client.field399[var18];
         boolean var23 = true;

         while(var23) {
            var23 = false;

            for(int var24 = 0; var24 < var18; ++var24) {
               if(var20 + 2 > Client.field380[var24] - Client.field399[var24] && var20 - var22 < Client.field380[var24] + 2 && var19 - var21 < Client.field397[var24] + Client.field444[var24] && var21 + var19 > Client.field397[var24] - Client.field444[var24] && Client.field380[var24] - Client.field399[var24] < var20) {
                  var20 = Client.field380[var24] - Client.field399[var24];
                  var23 = true;
               }
            }
         }

         Client.field407 = Client.field397[var18];
         Client.field408 = Client.field380[var18] = var20;
         String var30 = Client.field404[var18];
         if(Client.field465 == 0) {
            int var25 = 16776960;
            if(Client.field401[var18] < 6) {
               var25 = Client.field520[Client.field401[var18]];
            }

            if(Client.field401[var18] == 6) {
               var25 = Client.field337 % 20 < 10?16711680:16776960;
            }

            if(Client.field401[var18] == 7) {
               var25 = Client.field337 % 20 < 10?255:'\uffff';
            }

            if(Client.field401[var18] == 8) {
               var25 = Client.field337 % 20 < 10?'뀀':8454016;
            }

            int var26;
            if(Client.field401[var18] == 9) {
               var26 = 150 - Client.field403[var18];
               if(var26 < 50) {
                  var25 = 16711680 + 1280 * var26;
               } else if(var26 < 100) {
                  var25 = 16776960 - (var26 - 50) * 327680;
               } else if(var26 < 150) {
                  var25 = '\uff00' + (var26 - 100) * 5;
               }
            }

            if(Client.field401[var18] == 10) {
               var26 = 150 - Client.field403[var18];
               if(var26 < 50) {
                  var25 = 5 * var26 + 16711680;
               } else if(var26 < 100) {
                  var25 = 16711935 - 327680 * (var26 - 50);
               } else if(var26 < 150) {
                  var25 = 327680 * (var26 - 100) + 255 - 5 * (var26 - 100);
               }
            }

            if(Client.field401[var18] == 11) {
               var26 = 150 - Client.field403[var18];
               if(var26 < 50) {
                  var25 = 16777215 - var26 * 327685;
               } else if(var26 < 100) {
                  var25 = (var26 - 50) * 327685 + '\uff00';
               } else if(var26 < 150) {
                  var25 = 16777215 - (var26 - 100) * 327680;
               }
            }

            if(Client.field532[var18] == 0) {
               class63.field1119.method3963(var30, Client.field407 + var0, Client.field408 + var1, var25, 0);
            }

            if(Client.field532[var18] == 1) {
               class63.field1119.method3906(var30, Client.field407 + var0, var1 + Client.field408, var25, 0, Client.field337);
            }

            if(Client.field532[var18] == 2) {
               class63.field1119.method3907(var30, var0 + Client.field407, var1 + Client.field408, var25, 0, Client.field337);
            }

            if(Client.field532[var18] == 3) {
               class63.field1119.method3916(var30, Client.field407 + var0, Client.field408 + var1, var25, 0, Client.field337, 150 - Client.field403[var18]);
            }

            if(Client.field532[var18] == 4) {
               var26 = (150 - Client.field403[var18]) * (class63.field1119.method3897(var30) + 100) / 150;
               Rasterizer2D.method4002(var0 + Client.field407 - 50, var1, Client.field407 + var0 + 50, var3 + var1);
               class63.field1119.method3930(var30, var0 + Client.field407 + 50 - var26, var1 + Client.field408, var25, 0);
               Rasterizer2D.method4001(var0, var1, var2 + var0, var3 + var1);
            }

            if(Client.field532[var18] == 5) {
               var26 = 150 - Client.field403[var18];
               int var27 = 0;
               if(var26 < 25) {
                  var27 = var26 - 25;
               } else if(var26 > 125) {
                  var27 = var26 - 125;
               }

               Rasterizer2D.method4002(var0, Client.field408 + var1 - class63.field1119.field3117 - 1, var0 + var2, 5 + var1 + Client.field408);
               class63.field1119.method3963(var30, Client.field407 + var0, var1 + Client.field408 + var27, var25, 0);
               Rasterizer2D.method4001(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class63.field1119.method3963(var30, var0 + Client.field407, var1 + Client.field408, 16776960, 0);
         }
      }

      if(Client.field320 == 2) {
         Widget.method3294((Client.field323 - class119.baseX << 7) + Client.field501, (Client.field393 - class187.baseY << 7) + Client.field327, Client.field466 * 2);
         if(Client.field407 > -1 && Client.gameCycle % 20 < 10) {
            class15.field170[0].method4143(Client.field407 + var0 - 12, var1 + Client.field408 - 28);
         }
      }

      ((TextureProvider)class84.field1472).method1468(Client.field511);
      if(Client.field412 == 1) {
         class33.field771[Client.field312 / 100].method4143(Client.field557 - 8, Client.field410 - 8);
      }

      if(Client.field412 == 2) {
         class33.field771[4 + Client.field312 / 100].method4143(Client.field557 - 8, Client.field410 - 8);
      }

      Client.field421 = 0;
      var14 = (Projectile.localPlayer.x >> 7) + class119.baseX;
      var15 = class187.baseY + (Projectile.localPlayer.y >> 7);
      if(var14 >= 3053 && var14 <= 3156 && var15 >= 3056 && var15 <= 3136) {
         Client.field421 = 1;
      }

      if(var14 >= 3072 && var14 <= 3118 && var15 >= 9492 && var15 <= 9535) {
         Client.field421 = 1;
      }

      if(Client.field421 == 1 && var14 >= 3139 && var14 <= 3199 && var15 >= 3008 && var15 <= 3062) {
         Client.field421 = 0;
      }

      MessageNode.cameraX = var29;
      class16.cameraZ = var7;
      DecorativeObject.cameraY = var8;
      class16.cameraPitch = var9;
      class9.cameraYaw = var10;
      if(Client.field578 && FileOnDisk.method1455(true, false) == 0) {
         Client.field578 = false;
      }

      if(Client.field578) {
         Rasterizer2D.method4007(var0, var1, var2, var3, 0);
         GameEngine.method2242("Loading - please wait.", false);
      }

   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1813013411"
   )
   static final void method3066() {
      Client.secretCipherBuffer1.putOpcode(253);
      Client.secretCipherBuffer1.putByte(0);
   }
}
