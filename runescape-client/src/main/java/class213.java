import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public class class213 {
   @ObfuscatedName("n")
   static final byte[] field2662;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   Buffer field2653;
   @ObfuscatedName("p")
   int field2654;
   @ObfuscatedName("i")
   int[] field2655;
   @ObfuscatedName("j")
   int[] field2656;
   @ObfuscatedName("v")
   int[] field2657;
   @ObfuscatedName("x")
   int[] field2658;
   @ObfuscatedName("e")
   int field2659;
   @ObfuscatedName("b")
   long field2661;

   static {
      field2662 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class213(byte[] var1) {
      this.field2653 = new Buffer((byte[])null);
      this.method4031(var1);
   }

   class213() {
      this.field2653 = new Buffer((byte[])null);
   }

   @ObfuscatedName("m")
   void method4031(byte[] var1) {
      this.field2653.payload = var1;
      this.field2653.offset = 10;
      int var2 = this.field2653.readUnsignedShort();
      this.field2654 = this.field2653.readUnsignedShort();
      this.field2659 = 500000;
      this.field2655 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2653.offset += var5) {
         int var4 = this.field2653.readInt();
         var5 = this.field2653.readInt();
         if(var4 == 1297379947) {
            this.field2655[var3] = this.field2653.offset;
            ++var3;
         }
      }

      this.field2661 = 0L;
      this.field2656 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2656[var3] = this.field2655[var3];
      }

      this.field2657 = new int[var2];
      this.field2658 = new int[var2];
   }

   @ObfuscatedName("p")
   void method3984() {
      this.field2653.payload = null;
      this.field2655 = null;
      this.field2656 = null;
      this.field2657 = null;
      this.field2658 = null;
   }

   @ObfuscatedName("i")
   boolean method3985() {
      return this.field2653.payload != null;
   }

   @ObfuscatedName("j")
   int method3986() {
      return this.field2656.length;
   }

   @ObfuscatedName("v")
   void method3987(int var1) {
      this.field2653.offset = this.field2656[var1];
   }

   @ObfuscatedName("x")
   void method3988(int var1) {
      this.field2656[var1] = this.field2653.offset;
   }

   @ObfuscatedName("e")
   void method3989() {
      this.field2653.offset = -1;
   }

   @ObfuscatedName("l")
   void method3990(int var1) {
      int var2 = this.field2653.readVarInt();
      this.field2657[var1] += var2;
   }

   @ObfuscatedName("b")
   int method4012(int var1) {
      int var2 = this.method3992(var1);
      return var2;
   }

   @ObfuscatedName("n")
   int method3992(int var1) {
      byte var2 = this.field2653.payload[this.field2653.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2658[var1] = var5;
         ++this.field2653.offset;
      } else {
         var5 = this.field2658[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3993(var1, var5);
      } else {
         int var3 = this.field2653.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2653.payload[this.field2653.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2653.offset;
               this.field2658[var1] = var4;
               return this.method3993(var1, var4);
            }
         }

         this.field2653.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("c")
   int method3993(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2653.readUnsignedByte();
         var4 = this.field2653.readVarInt();
         if(var7 == 47) {
            this.field2653.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2653.read24BitInt();
            var4 -= 3;
            int var6 = this.field2657[var1];
            this.field2661 += (long)var6 * (long)(this.field2659 - var5);
            this.field2659 = var5;
            this.field2653.offset += var4;
            return 2;
         } else {
            this.field2653.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2662[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2653.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2653.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("a")
   long method3994(int var1) {
      return this.field2661 + (long)var1 * (long)this.field2659;
   }

   @ObfuscatedName("y")
   int method3995() {
      int var1 = this.field2656.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2656[var4] >= 0 && this.field2657[var4] < var3) {
            var2 = var4;
            var3 = this.field2657[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("w")
   boolean method3996() {
      int var1 = this.field2656.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2656[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("k")
   void method3997(long var1) {
      this.field2661 = var1;
      int var3 = this.field2656.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2657[var4] = 0;
         this.field2658[var4] = 0;
         this.field2653.offset = this.field2655[var4];
         this.method3990(var4);
         this.field2656[var4] = this.field2653.offset;
      }

   }
}
