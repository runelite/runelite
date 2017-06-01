import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -452522627
   )
   @Export("offset")
   public int offset;
   @ObfuscatedName("e")
   static int[] field2407;
   @ObfuscatedName("b")
   static long[] field2409;
   @ObfuscatedName("i")
   @Export("payload")
   public byte[] payload;

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1420800501"
   )
   @Export("putShort")
   public void putShort(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-689970322"
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

   @ObfuscatedName("h")
   public void method3130(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-83"
   )
   public int method3131() {
      this.offset += 3;
      return (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 1] & 255) << 16);
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1230629370"
   )
   public void method3132(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)V",
      garbageValue = "-1959596079"
   )
   public void method3134(CharSequence var1) {
      int var2 = method3347(var1);
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
            var5[var8++] = (byte)(128 | var10 & 63);
         } else {
            var5[var8++] = (byte)(224 | var10 >> 12);
            var5[var8++] = (byte)(128 | var10 >> 6 & 63);
            var5[var8++] = (byte)(128 | var10 & 63);
         }
      }

      int var4 = var8 - var6;
      this.offset = var3 + var4;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIIS)V",
      garbageValue = "-14034"
   )
   @Export("putBytes")
   public void putBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-54"
   )
   @Export("putByte")
   public void putByte(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "231138404"
   )
   public void method3138(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "76"
   )
   public void method3139(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.putByte(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.putShort(var1 + '耀');
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2061541491"
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
      signature = "(B)I",
      garbageValue = "48"
   )
   @Export("readUnsignedByte")
   public int readUnsignedByte() {
      return this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-987321608"
   )
   @Export("putInt")
   public void putInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1828317651"
   )
   @Export("readUnsignedShort")
   public int readUnsignedShort() {
      this.offset += 2;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2079247609"
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

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-277237297"
   )
   @Export("read24BitInt")
   public int read24BitInt() {
      this.offset += 3;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "393301079"
   )
   @Export("readInt")
   public int readInt() {
      this.offset += 4;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 4] & 255) << 24) + ((this.payload[this.offset - 3] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1074274421"
   )
   @Export("readLong")
   public long readLong() {
      long var1 = (long)this.readInt() & 4294967295L;
      long var3 = (long)this.readInt() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1917868400"
   )
   public String method3148() {
      if(this.payload[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.readString();
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "27"
   )
   @Export("readString")
   public String readString() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":class243.method4326(this.payload, var1, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "1"
   )
   public void method3150(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += GroundObject.method2478(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-270082219"
   )
   public void method3151(int var1) {
      this.payload[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.payload[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2126411788"
   )
   @Export("readBytes")
   public void readBytes(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1939865376"
   )
   public void method3153(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1730026505"
   )
   public int method3154() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte():this.readUnsignedShort() - '耀';
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-30761"
   )
   public int method3155() {
      return this.payload[this.offset] < 0?this.readInt() & Integer.MAX_VALUE:this.readUnsignedShort();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "18"
   )
   public int method3156() {
      if(this.payload[this.offset] < 0) {
         return this.readInt() & Integer.MAX_VALUE;
      } else {
         int var1 = this.readUnsignedShort();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-750134148"
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
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6;
            var6 += var7;
         }

         this.offset -= 8;
         this.putInt(var4);
         this.putInt(var5);
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "2035579505"
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
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var6 + var1[var6 >>> 11 & 3];
            var6 -= var7;
         }

         this.offset -= 8;
         this.putInt(var4);
         this.putInt(var5);
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "([IIIB)V",
      garbageValue = "95"
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

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "([IIIB)V",
      garbageValue = "55"
   )
   public void method3161(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.readInt();
         int var8 = this.readInt();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var9 & 3] + var9) {
            var8 -= (var7 << 4 ^ var7 >>> 5) + var7 ^ var1[var9 >>> 11 & 3] + var9;
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
      signature = "(II)I",
      garbageValue = "-1147364978"
   )
   public int method3163(int var1) {
      int var2 = class15.method75(this.payload, var1, this.offset);
      this.putInt(var2);
      return var2;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "56"
   )
   public boolean method3164() {
      this.offset -= 4;
      int var1 = class15.method75(this.payload, 0, this.offset);
      int var2 = this.readInt();
      return var1 == var2;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1592437978"
   )
   public void method3165(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1882069727"
   )
   public void method3166(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "29"
   )
   public String method3167() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.offset;

         while(this.payload[++this.offset - 1] != 0) {
            ;
         }

         int var3 = this.offset - var2 - 1;
         return var3 == 0?"":class243.method4326(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1003267760"
   )
   public int method3168() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "66"
   )
   public int method3169() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "598012718"
   )
   public void method3170(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1993870345"
   )
   public byte method3171() {
      return (byte)(0 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-541120851"
   )
   public byte method3172() {
      return (byte)(128 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-71430706"
   )
   public void method3175(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1764661068"
   )
   public int method3176() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-47"
   )
   public int method3177() {
      this.offset += 2;
      return ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] - 128 & 255);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-106"
   )
   public int method3178() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1172136860"
   )
   public int method3179() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2102941780"
   )
   public void method3183(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-845355680"
   )
   public int method3186() {
      this.offset += 4;
      return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 24) + ((this.payload[this.offset - 3] & 255) << 8);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-131035544"
   )
   public int method3187() {
      this.offset += 4;
      return (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 4] & 255) << 8) + ((this.payload[this.offset - 1] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 24);
   }

   @ObfuscatedName("x")
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

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-281847861"
   )
   public int method3191() {
      this.offset += 4;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 1] & 255) << 8) + ((this.payload[this.offset - 3] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 16);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public void method3192(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1764813522"
   )
   public String method3194() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.readVarInt();
         if(this.offset + var2 > this.payload.length) {
            throw new IllegalStateException("");
         } else {
            String var3 = Projectile.method1748(this.payload, this.offset, var2);
            this.offset += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-357068295"
   )
   @Export("readByte")
   public byte readByte() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1547983983"
   )
   public int method3219() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1670001400"
   )
   public void method3227(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "27367089"
   )
   public void method3244(BigInteger var1, BigInteger var2) {
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-573584599"
   )
   public void method3253(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += GroundObject.method2478(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "1035160199"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field3487.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Frames.field2161.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method4569();
         if(var1.notedTemplate != -1) {
            var1.method4572(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.field3492 != -1) {
            var1.method4584(getItemDefinition(var1.field3492), getItemDefinition(var1.field3533));
         }

         if(var1.field3536 != -1) {
            var1.method4574(getItemDefinition(var1.field3536), getItemDefinition(var1.field3535));
         }

         if(!class134.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field3532 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field3530 = 0;
            if(var1.field3531 != null) {
               boolean var3 = false;

               for(Node var4 = var1.field3531.method3482(); var4 != null; var4 = var1.field3531.method3478()) {
                  class251 var5 = class39.method528((int)var4.hash);
                  if(var5.field3388) {
                     var4.unlink();
                  } else {
                     var3 = true;
                  }
               }

               if(!var3) {
                  var1.field3531 = null;
               }
            }
         }

         ItemComposition.field3487.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1230181958"
   )
   @Export("put24bitInt")
   public void put24bitInt(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2009083094"
   )
   @Export("readShortSmart")
   public int readShortSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - '쀀';
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1160737692"
   )
   public void method3283(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   public Buffer(int var1) {
      this.payload = class174.method3349(var1);
      this.offset = 0;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-36"
   )
   public void method3308(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-7"
   )
   public int method3314() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   static {
      field2407 = new int[256];

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

         field2407[var1] = var0;
      }

      field2409 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if(1L == (var4 & 1L)) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2409[var2] = var4;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1720737850"
   )
   public static void method3344() {
      if(class164.field2337 != null) {
         class164.field2337.method2981();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass253;",
      garbageValue = "-897033227"
   )
   public static Enum method3345(int var0) {
      Enum var1 = (Enum)Enum.field3399.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Enum.field3402.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.method4472(new Buffer(var2));
         }

         Enum.field3399.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;S)I",
      garbageValue = "16662"
   )
   public static int method3347(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 <= 127) {
            ++var2;
         } else if(var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }
}
