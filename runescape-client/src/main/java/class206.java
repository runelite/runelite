import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gx")
public class class206 {
   @ObfuscatedName("f")
   long field2567;
   @ObfuscatedName("b")
   int[] field2569;
   @ObfuscatedName("v")
   int[] field2570;
   @ObfuscatedName("n")
   static final byte[] field2571;
   @ObfuscatedName("y")
   int[] field2572;
   @ObfuscatedName("h")
   int field2573;
   @ObfuscatedName("e")
   int[] field2575;
   @ObfuscatedName("c")
   int field2578;
   @ObfuscatedName("i")
   Buffer field2580;

   class206(byte[] var1) {
      this.field2580 = new Buffer((byte[])null);
      this.method3795(var1);
   }

   @ObfuscatedName("i")
   void method3795(byte[] var1) {
      this.field2580.payload = var1;
      this.field2580.offset = 10;
      int var2 = this.field2580.readUnsignedShort();
      this.field2578 = this.field2580.readUnsignedShort();
      this.field2573 = 500000;
      this.field2575 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2580.offset += var5) {
         int var4 = this.field2580.readInt();
         var5 = this.field2580.readInt();
         if(var4 == 1297379947) {
            this.field2575[var3] = this.field2580.offset;
            ++var3;
         }
      }

      this.field2567 = 0L;
      this.field2570 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2570[var3] = this.field2575[var3];
      }

      this.field2569 = new int[var2];
      this.field2572 = new int[var2];
   }

   @ObfuscatedName("v")
   int method3796() {
      return this.field2570.length;
   }

   @ObfuscatedName("n")
   int method3797(int var1) {
      byte var2 = this.field2580.payload[this.field2580.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2572[var1] = var5;
         ++this.field2580.offset;
      } else {
         var5 = this.field2572[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3803(var1, var5);
      } else {
         int var3 = this.field2580.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2580.payload[this.field2580.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2580.offset;
               this.field2572[var1] = var4;
               return this.method3803(var1, var4);
            }
         }

         this.field2580.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("h")
   void method3799() {
      this.field2580.offset = -1;
   }

   @ObfuscatedName("x")
   void method3800(int var1) {
      int var2 = this.field2580.readVarInt();
      this.field2569[var1] += var2;
   }

   @ObfuscatedName("f")
   int method3801(int var1) {
      int var2 = this.method3797(var1);
      return var2;
   }

   @ObfuscatedName("a")
   int method3803(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2580.readUnsignedByte();
         var4 = this.field2580.readVarInt();
         if(var7 == 47) {
            this.field2580.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2580.read24BitInt();
            var4 -= 3;
            int var6 = this.field2569[var1];
            this.field2567 += (long)var6 * (long)(this.field2573 - var5);
            this.field2573 = var5;
            this.field2580.offset += var4;
            return 2;
         } else {
            this.field2580.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2571[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2580.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2580.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("o")
   long method3804(int var1) {
      return this.field2567 + (long)var1 * (long)this.field2573;
   }

   @ObfuscatedName("z")
   int method3805() {
      int var1 = this.field2570.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2570[var4] >= 0 && this.field2569[var4] < var3) {
            var2 = var4;
            var3 = this.field2569[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("q")
   boolean method3806() {
      int var1 = this.field2570.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2570[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   static {
      field2571 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   @ObfuscatedName("y")
   void method3817(int var1) {
      this.field2570[var1] = this.field2580.offset;
   }

   class206() {
      this.field2580 = new Buffer((byte[])null);
   }

   @ObfuscatedName("j")
   void method3824(long var1) {
      this.field2567 = var1;
      int var3 = this.field2570.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2569[var4] = 0;
         this.field2572[var4] = 0;
         this.field2580.offset = this.field2575[var4];
         this.method3800(var4);
         this.field2570[var4] = this.field2580.offset;
      }

   }

   @ObfuscatedName("b")
   void method3834(int var1) {
      this.field2580.offset = this.field2570[var1];
   }

   @ObfuscatedName("c")
   void method3835() {
      this.field2580.payload = null;
      this.field2575 = null;
      this.field2570 = null;
      this.field2569 = null;
      this.field2572 = null;
   }

   @ObfuscatedName("e")
   boolean method3838() {
      return this.field2580.payload != null;
   }
}
