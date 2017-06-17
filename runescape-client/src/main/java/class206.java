import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gi")
public class class206 {
   @ObfuscatedName("m")
   int field2576;
   @ObfuscatedName("z")
   int[] field2578;
   @ObfuscatedName("t")
   int[] field2579;
   @ObfuscatedName("w")
   int[] field2580;
   @ObfuscatedName("c")
   static final byte[] field2581;
   @ObfuscatedName("j")
   int field2582;
   @ObfuscatedName("e")
   int[] field2583;
   @ObfuscatedName("f")
   long field2584;
   @ObfuscatedName("p")
   Buffer field2589;

   @ObfuscatedName("p")
   void method3710(byte[] var1) {
      this.field2589.payload = var1;
      this.field2589.offset = 10;
      int var2 = this.field2589.readUnsignedShort();
      this.field2576 = this.field2589.readUnsignedShort();
      this.field2582 = 500000;
      this.field2583 = new int[var2];

      int var3;
      int var4;
      for(var3 = 0; var3 < var2; this.field2589.offset += var4) {
         int var5 = this.field2589.readInt();
         var4 = this.field2589.readInt();
         if(var5 == 1297379947) {
            this.field2583[var3] = this.field2589.offset;
            ++var3;
         }
      }

      this.field2584 = 0L;
      this.field2579 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2579[var3] = this.field2583[var3];
      }

      this.field2580 = new int[var2];
      this.field2578 = new int[var2];
   }

   @ObfuscatedName("m")
   void method3711() {
      this.field2589.payload = null;
      this.field2583 = null;
      this.field2579 = null;
      this.field2580 = null;
      this.field2578 = null;
   }

   @ObfuscatedName("e")
   boolean method3712() {
      return this.field2589.payload != null;
   }

   @ObfuscatedName("t")
   int method3713() {
      return this.field2579.length;
   }

   @ObfuscatedName("w")
   void method3714(int var1) {
      this.field2589.offset = this.field2579[var1];
   }

   @ObfuscatedName("j")
   void method3715() {
      this.field2589.offset = -1;
   }

   @ObfuscatedName("a")
   long method3716(int var1) {
      return this.field2584 + (long)var1 * (long)this.field2582;
   }

   @ObfuscatedName("c")
   void method3717(int var1) {
      int var2 = this.field2589.readVarInt();
      this.field2580[var1] += var2;
   }

   @ObfuscatedName("z")
   void method3718(int var1) {
      this.field2579[var1] = this.field2589.offset;
   }

   @ObfuscatedName("q")
   int method3719(int var1) {
      byte var2 = this.field2589.payload[this.field2589.offset];
      int var3;
      if(var2 < 0) {
         var3 = var2 & 255;
         this.field2578[var1] = var3;
         ++this.field2589.offset;
      } else {
         var3 = this.field2578[var1];
      }

      if(var3 != 240 && var3 != 247) {
         return this.method3720(var1, var3);
      } else {
         int var4 = this.field2589.readVarInt();
         if(var3 == 247 && var4 > 0) {
            int var5 = this.field2589.payload[this.field2589.offset] & 255;
            if(var5 >= 241 && var5 <= 243 || var5 == 246 || var5 == 248 || var5 >= 250 && var5 <= 252 || var5 == 254) {
               ++this.field2589.offset;
               this.field2578[var1] = var5;
               return this.method3720(var1, var5);
            }
         }

         this.field2589.offset += var4;
         return 0;
      }
   }

   @ObfuscatedName("n")
   int method3720(int var1, int var2) {
      int var3;
      if(var2 == 255) {
         int var7 = this.field2589.readUnsignedByte();
         var3 = this.field2589.readVarInt();
         if(var7 == 47) {
            this.field2589.offset += var3;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2589.read24BitInt();
            var3 -= 3;
            int var6 = this.field2580[var1];
            this.field2584 += (long)var6 * (long)(this.field2582 - var5);
            this.field2582 = var5;
            this.field2589.offset += var3;
            return 2;
         } else {
            this.field2589.offset += var3;
            return 3;
         }
      } else {
         byte var4 = field2581[var2 - 128];
         var3 = var2;
         if(var4 >= 1) {
            var3 = var2 | this.field2589.readUnsignedByte() << 8;
         }

         if(var4 >= 2) {
            var3 |= this.field2589.readUnsignedByte() << 16;
         }

         return var3;
      }
   }

   class206(byte[] var1) {
      this.field2589 = new Buffer((byte[])null);
      this.method3710(var1);
   }

   @ObfuscatedName("g")
   int method3721() {
      int var1 = this.field2579.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2579[var4] >= 0 && this.field2580[var4] < var3) {
            var2 = var4;
            var3 = this.field2580[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("s")
   void method3723(long var1) {
      this.field2584 = var1;
      int var3 = this.field2579.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2580[var4] = 0;
         this.field2578[var4] = 0;
         this.field2589.offset = this.field2583[var4];
         this.method3717(var4);
         this.field2579[var4] = this.field2589.offset;
      }

   }

   @ObfuscatedName("v")
   boolean method3754() {
      int var1 = this.field2579.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2579[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("o")
   int method3757(int var1) {
      int var2 = this.method3719(var1);
      return var2;
   }

   class206() {
      this.field2589 = new Buffer((byte[])null);
   }

   static {
      field2581 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }
}
