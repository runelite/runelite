import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
public class class206 {
   @ObfuscatedName("r")
   static final byte[] field2542;
   @ObfuscatedName("i")
   long field2545;
   @ObfuscatedName("y")
   int[] field2540;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   Buffer field2549;
   @ObfuscatedName("v")
   int field2543;
   @ObfuscatedName("x")
   int[] field2539;
   @ObfuscatedName("e")
   int[] field2550;
   @ObfuscatedName("f")
   int[] field2548;
   @ObfuscatedName("q")
   int field2538;

   static {
      field2542 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class206(byte[] var1) {
      this.field2549 = new Buffer((byte[])null);
      this.method3837(var1);
   }

   class206() {
      this.field2549 = new Buffer((byte[])null);
   }

   @ObfuscatedName("r")
   int method3868(int var1) {
      byte var2 = this.field2549.payload[this.field2549.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2548[var1] = var5;
         ++this.field2549.offset;
      } else {
         var5 = this.field2548[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3847(var1, var5);
      } else {
         int var3 = this.field2549.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2549.payload[this.field2549.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2549.offset;
               this.field2548[var1] = var4;
               return this.method3847(var1, var4);
            }
         }

         this.field2549.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("q")
   void method3872() {
      this.field2549.payload = null;
      this.field2539 = null;
      this.field2540 = null;
      this.field2550 = null;
      this.field2548 = null;
   }

   @ObfuscatedName("x")
   boolean method3870() {
      return this.field2549.payload != null;
   }

   @ObfuscatedName("d")
   void method3837(byte[] var1) {
      this.field2549.payload = var1;
      this.field2549.offset = 10;
      int var2 = this.field2549.readUnsignedShort();
      this.field2538 = this.field2549.readUnsignedShort();
      this.field2543 = 500000;
      this.field2539 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2549.offset += var5) {
         int var4 = this.field2549.readInt();
         var5 = this.field2549.readInt();
         if(var4 == 1297379947) {
            this.field2539[var3] = this.field2549.offset;
            ++var3;
         }
      }

      this.field2545 = 0L;
      this.field2540 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2540[var3] = this.field2539[var3];
      }

      this.field2550 = new int[var2];
      this.field2548 = new int[var2];
   }

   @ObfuscatedName("o")
   int method3849() {
      int var1 = this.field2540.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2540[var4] >= 0 && this.field2550[var4] < var3) {
            var2 = var4;
            var3 = this.field2550[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("e")
   void method3841(int var1) {
      this.field2549.offset = this.field2540[var1];
   }

   @ObfuscatedName("y")
   int method3840() {
      return this.field2540.length;
   }

   @ObfuscatedName("i")
   int method3836(int var1) {
      int var2 = this.method3868(var1);
      return var2;
   }

   @ObfuscatedName("t")
   void method3860(int var1) {
      int var2 = this.field2549.readVarInt();
      this.field2550[var1] += var2;
   }

   @ObfuscatedName("g")
   int method3847(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2549.readUnsignedByte();
         var4 = this.field2549.readVarInt();
         if(var7 == 47) {
            this.field2549.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2549.read24BitInt();
            var4 -= 3;
            int var6 = this.field2550[var1];
            this.field2545 += (long)var6 * (long)(this.field2543 - var5);
            this.field2543 = var5;
            this.field2549.offset += var4;
            return 2;
         } else {
            this.field2549.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2542[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2549.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2549.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("s")
   long method3848(int var1) {
      return this.field2545 + (long)var1 * (long)this.field2543;
   }

   @ObfuscatedName("v")
   void method3843() {
      this.field2549.offset = -1;
   }

   @ObfuscatedName("f")
   void method3842(int var1) {
      this.field2540[var1] = this.field2549.offset;
   }

   @ObfuscatedName("p")
   boolean method3850() {
      int var1 = this.field2540.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2540[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("u")
   void method3851(long var1) {
      this.field2545 = var1;
      int var3 = this.field2540.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2550[var4] = 0;
         this.field2548[var4] = 0;
         this.field2549.offset = this.field2539[var4];
         this.method3860(var4);
         this.field2540[var4] = this.field2549.offset;
      }

   }
}
