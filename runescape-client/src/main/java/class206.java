import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gy")
public class class206 {
   @ObfuscatedName("g")
   static final byte[] field2570;
   @ObfuscatedName("p")
   int field2571;
   @ObfuscatedName("i")
   int[] field2572;
   @ObfuscatedName("n")
   Buffer field2573;
   @ObfuscatedName("m")
   int[] field2574;
   @ObfuscatedName("c")
   int field2575;
   @ObfuscatedName("f")
   int[] field2576;
   @ObfuscatedName("h")
   long field2578;
   @ObfuscatedName("j")
   int[] field2581;

   class206(byte[] var1) {
      this.field2573 = new Buffer((byte[])null);
      this.method3845(var1);
   }

   @ObfuscatedName("n")
   void method3845(byte[] var1) {
      this.field2573.payload = var1;
      this.field2573.offset = 10;
      int var2 = this.field2573.readUnsignedShort();
      this.field2571 = this.field2573.readUnsignedShort();
      this.field2575 = 500000;
      this.field2572 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2573.offset += var5) {
         int var4 = this.field2573.readInt();
         var5 = this.field2573.readInt();
         if(var4 == 1297379947) {
            this.field2572[var3] = this.field2573.offset;
            ++var3;
         }
      }

      this.field2578 = 0L;
      this.field2581 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2581[var3] = this.field2572[var3];
      }

      this.field2576 = new int[var2];
      this.field2574 = new int[var2];
   }

   @ObfuscatedName("p")
   void method3846() {
      this.field2573.payload = null;
      this.field2572 = null;
      this.field2581 = null;
      this.field2576 = null;
      this.field2574 = null;
   }

   @ObfuscatedName("i")
   boolean method3847() {
      return this.field2573.payload != null;
   }

   @ObfuscatedName("j")
   int method3848() {
      return this.field2581.length;
   }

   @ObfuscatedName("z")
   void method3850(int var1) {
      int var2 = this.field2573.readVarInt();
      this.field2576[var1] += var2;
   }

   class206() {
      this.field2573 = new Buffer((byte[])null);
   }

   @ObfuscatedName("g")
   int method3853(int var1) {
      byte var2 = this.field2573.payload[this.field2573.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2574[var1] = var5;
         ++this.field2573.offset;
      } else {
         var5 = this.field2574[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3870(var1, var5);
      } else {
         int var3 = this.field2573.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2573.payload[this.field2573.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2573.offset;
               this.field2574[var1] = var4;
               return this.method3870(var1, var4);
            }
         }

         this.field2573.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("h")
   int method3854(int var1) {
      int var2 = this.method3853(var1);
      return var2;
   }

   @ObfuscatedName("o")
   long method3855(int var1) {
      return this.field2578 + (long)var1 * (long)this.field2575;
   }

   @ObfuscatedName("x")
   int method3856() {
      int var1 = this.field2581.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2581[var4] >= 0 && this.field2576[var4] < var3) {
            var2 = var4;
            var3 = this.field2576[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("a")
   boolean method3857() {
      int var1 = this.field2581.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2581[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("y")
   void method3863(long var1) {
      this.field2578 = var1;
      int var3 = this.field2581.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2576[var4] = 0;
         this.field2574[var4] = 0;
         this.field2573.offset = this.field2572[var4];
         this.method3850(var4);
         this.field2581[var4] = this.field2573.offset;
      }

   }

   static {
      field2570 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   @ObfuscatedName("e")
   int method3870(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2573.readUnsignedByte();
         var4 = this.field2573.readVarInt();
         if(var7 == 47) {
            this.field2573.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2573.read24BitInt();
            var4 -= 3;
            int var6 = this.field2576[var1];
            this.field2578 += (long)var6 * (long)(this.field2575 - var5);
            this.field2575 = var5;
            this.field2573.offset += var4;
            return 2;
         } else {
            this.field2573.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2570[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2573.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2573.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("f")
   void method3872(int var1) {
      this.field2573.offset = this.field2581[var1];
   }

   @ObfuscatedName("m")
   void method3886(int var1) {
      this.field2581[var1] = this.field2573.offset;
   }

   @ObfuscatedName("c")
   void method3895() {
      this.field2573.offset = -1;
   }
}
