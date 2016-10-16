import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gt")
public class class185 {
   @ObfuscatedName("m")
   int field2984;
   @ObfuscatedName("z")
   int field2985;
   @ObfuscatedName("y")
   int[] field2987;
   @ObfuscatedName("p")
   int[] field2988;
   @ObfuscatedName("g")
   int[] field2989;
   @ObfuscatedName("s")
   Buffer field2990 = new Buffer((byte[])null);
   @ObfuscatedName("k")
   long field2992;
   @ObfuscatedName("h")
   static final byte[] field2993 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("t")
   int[] field2995;

   @ObfuscatedName("t")
   boolean method3517() {
      return this.field2990.payload != null;
   }

   class185(byte[] var1) {
      this.method3518(var1);
   }

   @ObfuscatedName("s")
   void method3518(byte[] var1) {
      this.field2990.payload = var1;
      this.field2990.offset = 10;
      int var2 = this.field2990.method2668();
      this.field2985 = this.field2990.method2668();
      this.field2984 = 500000;
      this.field2995 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2990.offset += var5) {
         int var4 = this.field2990.method2526();
         var5 = this.field2990.method2526();
         if(var4 == 1297379947) {
            this.field2995[var3] = this.field2990.offset;
            ++var3;
         }
      }

      this.field2992 = 0L;
      this.field2987 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2987[var3] = this.field2995[var3];
      }

      this.field2988 = new int[var2];
      this.field2989 = new int[var2];
   }

   @ObfuscatedName("z")
   void method3519() {
      this.field2990.payload = null;
      this.field2995 = null;
      this.field2987 = null;
      this.field2988 = null;
      this.field2989 = null;
   }

   @ObfuscatedName("f")
   void method3522(int var1) {
      int var2 = this.field2990.method2497();
      this.field2988[var1] += var2;
   }

   @ObfuscatedName("m")
   void method3524() {
      this.field2990.offset = -1;
   }

   @ObfuscatedName("w")
   long method3525(int var1) {
      return this.field2992 + (long)var1 * (long)this.field2984;
   }

   @ObfuscatedName("h")
   int method3527(int var1) {
      byte var2 = this.field2990.payload[this.field2990.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2989[var1] = var5;
         ++this.field2990.offset;
      } else {
         var5 = this.field2989[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3528(var1, var5);
      } else {
         int var3 = this.field2990.method2497();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2990.payload[this.field2990.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2990.offset;
               this.field2989[var1] = var4;
               return this.method3528(var1, var4);
            }
         }

         this.field2990.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("r")
   int method3528(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2990.method2481();
         var4 = this.field2990.method2497();
         if(var7 == 47) {
            this.field2990.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2990.method2485();
            var4 -= 3;
            int var6 = this.field2988[var1];
            this.field2992 += (long)var6 * (long)(this.field2984 - var5);
            this.field2984 = var5;
            this.field2990.offset += var4;
            return 2;
         } else {
            this.field2990.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2993[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2990.method2481() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2990.method2481() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("p")
   void method3529(int var1) {
      this.field2990.offset = this.field2987[var1];
   }

   @ObfuscatedName("u")
   int method3530() {
      int var1 = this.field2987.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2987[var4] >= 0 && this.field2988[var4] < var3) {
            var2 = var4;
            var3 = this.field2988[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("d")
   void method3531(long var1) {
      this.field2992 = var1;
      int var3 = this.field2987.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2988[var4] = 0;
         this.field2989[var4] = 0;
         this.field2990.offset = this.field2995[var4];
         this.method3522(var4);
         this.field2987[var4] = this.field2990.offset;
      }

   }

   @ObfuscatedName("g")
   void method3535(int var1) {
      this.field2987[var1] = this.field2990.offset;
   }

   @ObfuscatedName("n")
   boolean method3536() {
      int var1 = this.field2987.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2987[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("k")
   int method3540(int var1) {
      int var2 = this.method3527(var1);
      return var2;
   }

   @ObfuscatedName("y")
   int method3545() {
      return this.field2987.length;
   }

   class185() {
   }
}
