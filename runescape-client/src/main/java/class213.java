import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
public class class213 {
   @ObfuscatedName("r")
   static final byte[] field2657;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   Buffer field2659;
   @ObfuscatedName("x")
   int field2652;
   @ObfuscatedName("k")
   int[] field2653;
   @ObfuscatedName("z")
   int[] field2654;
   @ObfuscatedName("v")
   int[] field2655;
   @ObfuscatedName("m")
   int[] field2656;
   @ObfuscatedName("b")
   int field2661;
   @ObfuscatedName("p")
   long field2651;

   static {
      field2657 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class213(byte[] var1) {
      this.field2659 = new Buffer((byte[])null);
      this.method3987(var1);
   }

   class213() {
      this.field2659 = new Buffer((byte[])null);
   }

   @ObfuscatedName("d")
   void method3987(byte[] var1) {
      this.field2659.payload = var1;
      this.field2659.offset = 10;
      int var2 = this.field2659.readUnsignedShort();
      this.field2652 = this.field2659.readUnsignedShort();
      this.field2661 = 500000;
      this.field2653 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2659.offset += var5) {
         int var4 = this.field2659.readInt();
         var5 = this.field2659.readInt();
         if(var4 == 1297379947) {
            this.field2653[var3] = this.field2659.offset;
            ++var3;
         }
      }

      this.field2651 = 0L;
      this.field2654 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2654[var3] = this.field2653[var3];
      }

      this.field2655 = new int[var2];
      this.field2656 = new int[var2];
   }

   @ObfuscatedName("x")
   void method3988() {
      this.field2659.payload = null;
      this.field2653 = null;
      this.field2654 = null;
      this.field2655 = null;
      this.field2656 = null;
   }

   @ObfuscatedName("k")
   boolean method3989() {
      return this.field2659.payload != null;
   }

   @ObfuscatedName("z")
   int method3990() {
      return this.field2654.length;
   }

   @ObfuscatedName("v")
   void method3991(int var1) {
      this.field2659.offset = this.field2654[var1];
   }

   @ObfuscatedName("m")
   void method4001(int var1) {
      this.field2654[var1] = this.field2659.offset;
   }

   @ObfuscatedName("b")
   void method4010() {
      this.field2659.offset = -1;
   }

   @ObfuscatedName("t")
   void method3994(int var1) {
      int var2 = this.field2659.readVarInt();
      this.field2655[var1] += var2;
   }

   @ObfuscatedName("p")
   int method4015(int var1) {
      int var2 = this.method3996(var1);
      return var2;
   }

   @ObfuscatedName("r")
   int method3996(int var1) {
      byte var2 = this.field2659.payload[this.field2659.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2656[var1] = var5;
         ++this.field2659.offset;
      } else {
         var5 = this.field2656[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method4036(var1, var5);
      } else {
         int var3 = this.field2659.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2659.payload[this.field2659.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2659.offset;
               this.field2656[var1] = var4;
               return this.method4036(var1, var4);
            }
         }

         this.field2659.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("l")
   int method4036(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2659.readUnsignedByte();
         var4 = this.field2659.readVarInt();
         if(var7 == 47) {
            this.field2659.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2659.read24BitInt();
            var4 -= 3;
            int var6 = this.field2655[var1];
            this.field2651 += (long)var6 * (long)(this.field2661 - var5);
            this.field2661 = var5;
            this.field2659.offset += var4;
            return 2;
         } else {
            this.field2659.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2657[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2659.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2659.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("u")
   long method3998(int var1) {
      return this.field2651 + (long)var1 * (long)this.field2661;
   }

   @ObfuscatedName("c")
   int method4024() {
      int var1 = this.field2654.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2654[var4] >= 0 && this.field2655[var4] < var3) {
            var2 = var4;
            var3 = this.field2655[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("j")
   boolean method4013() {
      int var1 = this.field2654.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2654[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("f")
   void method3999(long var1) {
      this.field2651 = var1;
      int var3 = this.field2654.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2655[var4] = 0;
         this.field2656[var4] = 0;
         this.field2659.offset = this.field2653[var4];
         this.method3994(var4);
         this.field2654[var4] = this.field2659.offset;
      }

   }
}
