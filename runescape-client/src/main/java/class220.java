import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public class class220 {
   @ObfuscatedName("a")
   static final byte[] field2543;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   Buffer field2548;
   @ObfuscatedName("m")
   int field2540;
   @ObfuscatedName("q")
   int[] field2539;
   @ObfuscatedName("b")
   int[] field2542;
   @ObfuscatedName("f")
   int[] field2541;
   @ObfuscatedName("n")
   int[] field2545;
   @ObfuscatedName("h")
   int field2544;
   @ObfuscatedName("j")
   long field2547;

   static {
      field2543 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class220(byte[] var1) {
      this.field2548 = new Buffer((byte[])null);
      this.method4364(var1);
   }

   class220() {
      this.field2548 = new Buffer((byte[])null);
   }

   @ObfuscatedName("w")
   void method4364(byte[] var1) {
      this.field2548.payload = var1;
      this.field2548.offset = 10;
      int var2 = this.field2548.readUnsignedShort();
      this.field2540 = this.field2548.readUnsignedShort();
      this.field2544 = 500000;
      this.field2539 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2548.offset += var5) {
         int var4 = this.field2548.readInt();
         var5 = this.field2548.readInt();
         if(var4 == 1297379947) {
            this.field2539[var3] = this.field2548.offset;
            ++var3;
         }
      }

      this.field2547 = 0L;
      this.field2542 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2542[var3] = this.field2539[var3];
      }

      this.field2541 = new int[var2];
      this.field2545 = new int[var2];
   }

   @ObfuscatedName("m")
   void method4365() {
      this.field2548.payload = null;
      this.field2539 = null;
      this.field2542 = null;
      this.field2541 = null;
      this.field2545 = null;
   }

   @ObfuscatedName("q")
   boolean method4406() {
      return this.field2548.payload != null;
   }

   @ObfuscatedName("x")
   int method4367() {
      return this.field2542.length;
   }

   @ObfuscatedName("j")
   void method4411(int var1) {
      this.field2548.offset = this.field2542[var1];
   }

   @ObfuscatedName("a")
   void method4402(int var1) {
      this.field2542[var1] = this.field2548.offset;
   }

   @ObfuscatedName("l")
   void method4370() {
      this.field2548.offset = -1;
   }

   @ObfuscatedName("d")
   void method4371(int var1) {
      int var2 = this.field2548.readVarInt();
      this.field2541[var1] += var2;
   }

   @ObfuscatedName("s")
   int method4372(int var1) {
      int var2 = this.method4373(var1);
      return var2;
   }

   @ObfuscatedName("p")
   int method4373(int var1) {
      byte var2 = this.field2548.payload[this.field2548.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2545[var1] = var5;
         ++this.field2548.offset;
      } else {
         var5 = this.field2545[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method4374(var1, var5);
      } else {
         int var3 = this.field2548.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2548.payload[this.field2548.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2548.offset;
               this.field2545[var1] = var4;
               return this.method4374(var1, var4);
            }
         }

         this.field2548.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("g")
   int method4374(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2548.readUnsignedByte();
         var4 = this.field2548.readVarInt();
         if(var7 == 47) {
            this.field2548.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2548.read24BitInt();
            var4 -= 3;
            int var6 = this.field2541[var1];
            this.field2547 += (long)var6 * (long)(this.field2544 - var5);
            this.field2544 = var5;
            this.field2548.offset += var4;
            return 2;
         } else {
            this.field2548.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2543[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2548.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2548.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("y")
   long method4375(int var1) {
      return this.field2547 + (long)var1 * (long)this.field2544;
   }

   @ObfuscatedName("c")
   int method4409() {
      int var1 = this.field2542.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2542[var4] >= 0 && this.field2541[var4] < var3) {
            var2 = var4;
            var3 = this.field2541[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("e")
   boolean method4390() {
      int var1 = this.field2542.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2542[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("t")
   void method4378(long var1) {
      this.field2547 = var1;
      int var3 = this.field2542.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2541[var4] = 0;
         this.field2545[var4] = 0;
         this.field2548.offset = this.field2539[var4];
         this.method4371(var4);
         this.field2542[var4] = this.field2548.offset;
      }

   }
}
