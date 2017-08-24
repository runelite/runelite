import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class207 {
   @ObfuscatedName("s")
   static final byte[] field2578;
   @ObfuscatedName("k")
   long field2574;
   @ObfuscatedName("r")
   int[] field2569;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   Buffer field2575;
   @ObfuscatedName("q")
   int field2572;
   @ObfuscatedName("a")
   int[] field2568;
   @ObfuscatedName("o")
   int[] field2570;
   @ObfuscatedName("n")
   int[] field2571;
   @ObfuscatedName("j")
   int field2573;

   static {
      field2578 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class207(byte[] var1) {
      this.field2575 = new Buffer((byte[])null);
      this.method3895(var1);
   }

   class207() {
      this.field2575 = new Buffer((byte[])null);
   }

   @ObfuscatedName("s")
   int method3889(int var1) {
      byte var2 = this.field2575.payload[this.field2575.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2571[var1] = var5;
         ++this.field2575.offset;
      } else {
         var5 = this.field2571[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3883(var1, var5);
      } else {
         int var3 = this.field2575.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2575.payload[this.field2575.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2575.offset;
               this.field2571[var1] = var4;
               return this.method3883(var1, var4);
            }
         }

         this.field2575.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("j")
   void method3880() {
      this.field2575.payload = null;
      this.field2568 = null;
      this.field2569 = null;
      this.field2570 = null;
      this.field2571 = null;
   }

   @ObfuscatedName("a")
   boolean method3916() {
      return this.field2575.payload != null;
   }

   @ObfuscatedName("i")
   void method3895(byte[] var1) {
      this.field2575.payload = var1;
      this.field2575.offset = 10;
      int var2 = this.field2575.readUnsignedShort();
      this.field2573 = this.field2575.readUnsignedShort();
      this.field2572 = 500000;
      this.field2568 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2575.offset += var5) {
         int var4 = this.field2575.readInt();
         var5 = this.field2575.readInt();
         if(var4 == 1297379947) {
            this.field2568[var3] = this.field2575.offset;
            ++var3;
         }
      }

      this.field2574 = 0L;
      this.field2569 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2569[var3] = this.field2568[var3];
      }

      this.field2570 = new int[var2];
      this.field2571 = new int[var2];
   }

   @ObfuscatedName("o")
   void method3885(int var1) {
      this.field2575.offset = this.field2569[var1];
   }

   @ObfuscatedName("c")
   int method3892() {
      int var1 = this.field2569.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2569[var4] >= 0 && this.field2570[var4] < var3) {
            var2 = var4;
            var3 = this.field2570[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("r")
   int method3884() {
      return this.field2569.length;
   }

   @ObfuscatedName("k")
   int method3910(int var1) {
      int var2 = this.method3889(var1);
      return var2;
   }

   @ObfuscatedName("b")
   void method3888(int var1) {
      int var2 = this.field2575.readVarInt();
      this.field2570[var1] += var2;
   }

   @ObfuscatedName("d")
   int method3883(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2575.readUnsignedByte();
         var4 = this.field2575.readVarInt();
         if(var7 == 47) {
            this.field2575.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2575.read24BitInt();
            var4 -= 3;
            int var6 = this.field2570[var1];
            this.field2574 += (long)var6 * (long)(this.field2572 - var5);
            this.field2572 = var5;
            this.field2575.offset += var4;
            return 2;
         } else {
            this.field2575.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2578[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2575.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2575.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("l")
   long method3891(int var1) {
      return this.field2574 + (long)var1 * (long)this.field2572;
   }

   @ObfuscatedName("q")
   void method3887() {
      this.field2575.offset = -1;
   }

   @ObfuscatedName("n")
   void method3886(int var1) {
      this.field2569[var1] = this.field2575.offset;
   }

   @ObfuscatedName("u")
   boolean method3882() {
      int var1 = this.field2569.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2569[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("e")
   void method3894(long var1) {
      this.field2574 = var1;
      int var3 = this.field2569.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2570[var4] = 0;
         this.field2571[var4] = 0;
         this.field2575.offset = this.field2568[var4];
         this.method3888(var4);
         this.field2569[var4] = this.field2575.offset;
      }

   }
}
