import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gf")
public class class206 {
   @ObfuscatedName("a")
   static final byte[] field2555;
   @ObfuscatedName("h")
   int field2556;
   @ObfuscatedName("i")
   Buffer field2557;
   @ObfuscatedName("g")
   int[] field2559;
   @ObfuscatedName("v")
   int[] field2560;
   @ObfuscatedName("t")
   int field2561;
   @ObfuscatedName("l")
   long field2563;
   @ObfuscatedName("u")
   int[] field2564;
   @ObfuscatedName("q")
   int[] field2567;

   @ObfuscatedName("u")
   boolean method3890() {
      return this.field2557.payload != null;
   }

   class206(byte[] var1) {
      this.field2557 = new Buffer((byte[])null);
      this.method3896(var1);
   }

   @ObfuscatedName("v")
   void method3891(int var1) {
      this.field2567[var1] = this.field2557.offset;
   }

   @ObfuscatedName("q")
   int method3894() {
      return this.field2567.length;
   }

   @ObfuscatedName("i")
   void method3896(byte[] var1) {
      this.field2557.payload = var1;
      this.field2557.offset = 10;
      int var2 = this.field2557.readUnsignedShort();
      this.field2556 = this.field2557.readUnsignedShort();
      this.field2561 = 500000;
      this.field2564 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2557.offset += var5) {
         int var4 = this.field2557.readInt();
         var5 = this.field2557.readInt();
         if(var4 == 1297379947) {
            this.field2564[var3] = this.field2557.offset;
            ++var3;
         }
      }

      this.field2563 = 0L;
      this.field2567 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2567[var3] = this.field2564[var3];
      }

      this.field2559 = new int[var2];
      this.field2560 = new int[var2];
   }

   @ObfuscatedName("t")
   void method3897() {
      this.field2557.offset = -1;
   }

   @ObfuscatedName("p")
   void method3898(int var1) {
      int var2 = this.field2557.readVarInt();
      this.field2559[var1] += var2;
   }

   @ObfuscatedName("l")
   int method3899(int var1) {
      int var2 = this.method3900(var1);
      return var2;
   }

   @ObfuscatedName("a")
   int method3900(int var1) {
      byte var2 = this.field2557.payload[this.field2557.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2560[var1] = var5;
         ++this.field2557.offset;
      } else {
         var5 = this.field2560[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3901(var1, var5);
      } else {
         int var3 = this.field2557.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2557.payload[this.field2557.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2557.offset;
               this.field2560[var1] = var4;
               return this.method3901(var1, var4);
            }
         }

         this.field2557.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("k")
   int method3901(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2557.readUnsignedByte();
         var4 = this.field2557.readVarInt();
         if(var7 == 47) {
            this.field2557.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2557.read24BitInt();
            var4 -= 3;
            int var6 = this.field2559[var1];
            this.field2563 += (long)var6 * (long)(this.field2561 - var5);
            this.field2561 = var5;
            this.field2557.offset += var4;
            return 2;
         } else {
            this.field2557.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2555[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2557.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2557.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("b")
   long method3902(int var1) {
      return this.field2563 + (long)var1 * (long)this.field2561;
   }

   @ObfuscatedName("o")
   boolean method3904() {
      int var1 = this.field2567.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2567[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("j")
   void method3905(long var1) {
      this.field2563 = var1;
      int var3 = this.field2567.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2559[var4] = 0;
         this.field2560[var4] = 0;
         this.field2557.offset = this.field2564[var4];
         this.method3898(var4);
         this.field2567[var4] = this.field2557.offset;
      }

   }

   @ObfuscatedName("g")
   void method3906(int var1) {
      this.field2557.offset = this.field2567[var1];
   }

   class206() {
      this.field2557 = new Buffer((byte[])null);
   }

   @ObfuscatedName("x")
   int method3911() {
      int var1 = this.field2567.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2567[var4] >= 0 && this.field2559[var4] < var3) {
            var2 = var4;
            var3 = this.field2559[var4];
         }
      }

      return var2;
   }

   static {
      field2555 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   @ObfuscatedName("h")
   void method3930() {
      this.field2557.payload = null;
      this.field2564 = null;
      this.field2567 = null;
      this.field2559 = null;
      this.field2560 = null;
   }
}
