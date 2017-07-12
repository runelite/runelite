import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gz")
public class class206 {
   @ObfuscatedName("k")
   static final byte[] field2577;
   @ObfuscatedName("j")
   long field2575;
   @ObfuscatedName("t")
   int[] field2567;
   @ObfuscatedName("i")
   Buffer field2579;
   @ObfuscatedName("v")
   int field2573;
   @ObfuscatedName("a")
   int[] field2569;
   @ObfuscatedName("s")
   int[] field2571;
   @ObfuscatedName("r")
   int[] field2572;
   @ObfuscatedName("w")
   int field2568;

   static {
      field2577 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class206(byte[] var1) {
      this.field2579 = new Buffer((byte[])null);
      this.method3855(var1);
   }

   class206() {
      this.field2579 = new Buffer((byte[])null);
   }

   @ObfuscatedName("k")
   int method3808(int var1) {
      byte var2 = this.field2579.payload[this.field2579.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2572[var1] = var5;
         ++this.field2579.offset;
      } else {
         var5 = this.field2572[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3817(var1, var5);
      } else {
         int var3 = this.field2579.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2579.payload[this.field2579.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2579.offset;
               this.field2572[var1] = var4;
               return this.method3817(var1, var4);
            }
         }

         this.field2579.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("w")
   void method3815() {
      this.field2579.payload = null;
      this.field2569 = null;
      this.field2567 = null;
      this.field2571 = null;
      this.field2572 = null;
   }

   @ObfuscatedName("a")
   boolean method3809() {
      return this.field2579.payload != null;
   }

   @ObfuscatedName("i")
   void method3855(byte[] var1) {
      this.field2579.payload = var1;
      this.field2579.offset = 10;
      int var2 = this.field2579.readUnsignedShort();
      this.field2568 = this.field2579.readUnsignedShort();
      this.field2573 = 500000;
      this.field2569 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2579.offset += var5) {
         int var4 = this.field2579.readInt();
         var5 = this.field2579.readInt();
         if(var4 == 1297379947) {
            this.field2569[var3] = this.field2579.offset;
            ++var3;
         }
      }

      this.field2575 = 0L;
      this.field2567 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2567[var3] = this.field2569[var3];
      }

      this.field2571 = new int[var2];
      this.field2572 = new int[var2];
   }

   @ObfuscatedName("s")
   void method3811(int var1) {
      this.field2579.offset = this.field2567[var1];
   }

   @ObfuscatedName("z")
   int method3851() {
      int var1 = this.field2567.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2567[var4] >= 0 && this.field2571[var4] < var3) {
            var2 = var4;
            var3 = this.field2571[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("t")
   int method3810() {
      return this.field2567.length;
   }

   @ObfuscatedName("j")
   int method3816(int var1) {
      int var2 = this.method3808(var1);
      return var2;
   }

   @ObfuscatedName("y")
   void method3814(int var1) {
      int var2 = this.field2579.readVarInt();
      this.field2571[var1] += var2;
   }

   @ObfuscatedName("o")
   long method3827(int var1) {
      return this.field2575 + (long)var1 * (long)this.field2573;
   }

   @ObfuscatedName("e")
   int method3817(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2579.readUnsignedByte();
         var4 = this.field2579.readVarInt();
         if(var7 == 47) {
            this.field2579.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2579.read24BitInt();
            var4 -= 3;
            int var6 = this.field2571[var1];
            this.field2575 += (long)var6 * (long)(this.field2573 - var5);
            this.field2573 = var5;
            this.field2579.offset += var4;
            return 2;
         } else {
            this.field2579.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2577[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2579.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2579.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("v")
   void method3813() {
      this.field2579.offset = -1;
   }

   @ObfuscatedName("r")
   void method3812(int var1) {
      this.field2567[var1] = this.field2579.offset;
   }

   @ObfuscatedName("l")
   boolean method3822() {
      int var1 = this.field2567.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2567[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("c")
   void method3818(long var1) {
      this.field2575 = var1;
      int var3 = this.field2567.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2571[var4] = 0;
         this.field2572[var4] = 0;
         this.field2579.offset = this.field2569[var4];
         this.method3814(var4);
         this.field2567[var4] = this.field2579.offset;
      }

   }
}
