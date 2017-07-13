import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gk")
public class class206 {
   @ObfuscatedName("p")
   static final byte[] field2573;
   @ObfuscatedName("w")
   long field2572;
   @ObfuscatedName("r")
   int[] field2567;
   @ObfuscatedName("a")
   Buffer field2564;
   @ObfuscatedName("l")
   int field2570;
   @ObfuscatedName("n")
   int[] field2566;
   @ObfuscatedName("v")
   int[] field2569;
   @ObfuscatedName("e")
   int[] field2574;
   @ObfuscatedName("j")
   int field2565;

   static {
      field2573 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class206(byte[] var1) {
      this.field2564 = new Buffer((byte[])null);
      this.method3807(var1);
   }

   class206() {
      this.field2564 = new Buffer((byte[])null);
   }

   @ObfuscatedName("p")
   int method3817(int var1) {
      byte var2 = this.field2564.payload[this.field2564.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2574[var1] = var5;
         ++this.field2564.offset;
      } else {
         var5 = this.field2574[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3830(var1, var5);
      } else {
         int var3 = this.field2564.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2564.payload[this.field2564.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2564.offset;
               this.field2574[var1] = var4;
               return this.method3830(var1, var4);
            }
         }

         this.field2564.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("j")
   void method3839() {
      this.field2564.payload = null;
      this.field2566 = null;
      this.field2567 = null;
      this.field2569 = null;
      this.field2574 = null;
   }

   @ObfuscatedName("n")
   boolean method3816() {
      return this.field2564.payload != null;
   }

   @ObfuscatedName("a")
   void method3807(byte[] var1) {
      this.field2564.payload = var1;
      this.field2564.offset = 10;
      int var2 = this.field2564.readUnsignedShort();
      this.field2565 = this.field2564.readUnsignedShort();
      this.field2570 = 500000;
      this.field2566 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2564.offset += var5) {
         int var4 = this.field2564.readInt();
         var5 = this.field2564.readInt();
         if(var4 == 1297379947) {
            this.field2566[var3] = this.field2564.offset;
            ++var3;
         }
      }

      this.field2572 = 0L;
      this.field2567 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2567[var3] = this.field2566[var3];
      }

      this.field2569 = new int[var2];
      this.field2574 = new int[var2];
   }

   @ObfuscatedName("v")
   void method3811(int var1) {
      this.field2564.offset = this.field2567[var1];
   }

   @ObfuscatedName("g")
   int method3831() {
      int var1 = this.field2567.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2567[var4] >= 0 && this.field2569[var4] < var3) {
            var2 = var4;
            var3 = this.field2569[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("r")
   int method3810() {
      return this.field2567.length;
   }

   @ObfuscatedName("w")
   int method3849(int var1) {
      int var2 = this.method3817(var1);
      return var2;
   }

   @ObfuscatedName("s")
   void method3814(int var1) {
      int var2 = this.field2564.readVarInt();
      this.field2569[var1] += var2;
   }

   @ObfuscatedName("m")
   int method3830(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2564.readUnsignedByte();
         var4 = this.field2564.readVarInt();
         if(var7 == 47) {
            this.field2564.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2564.read24BitInt();
            var4 -= 3;
            int var6 = this.field2569[var1];
            this.field2572 += (long)var6 * (long)(this.field2570 - var5);
            this.field2570 = var5;
            this.field2564.offset += var4;
            return 2;
         } else {
            this.field2564.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2573[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2564.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2564.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("u")
   long method3832(int var1) {
      return this.field2572 + (long)var1 * (long)this.field2570;
   }

   @ObfuscatedName("l")
   void method3813() {
      this.field2564.offset = -1;
   }

   @ObfuscatedName("e")
   void method3812(int var1) {
      this.field2567[var1] = this.field2564.offset;
   }

   @ObfuscatedName("k")
   boolean method3819() {
      int var1 = this.field2567.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2567[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("c")
   void method3820(long var1) {
      this.field2572 = var1;
      int var3 = this.field2567.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2569[var4] = 0;
         this.field2574[var4] = 0;
         this.field2564.offset = this.field2566[var4];
         this.method3814(var4);
         this.field2567[var4] = this.field2564.offset;
      }

   }
}
