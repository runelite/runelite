import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("gl")
public class class182 {
   @ObfuscatedName("i")
   int field2961;
   @ObfuscatedName("t")
   class119 field2962 = new class119((byte[])null);
   @ObfuscatedName("h")
   int[] field2963;
   @ObfuscatedName("z")
   int[] field2964;
   @ObfuscatedName("r")
   int[] field2965;
   @ObfuscatedName("f")
   int field2966;
   @ObfuscatedName("g")
   int[] field2967;
   @ObfuscatedName("d")
   long field2968;
   @ObfuscatedName("l")
   static final byte[] field2973 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};

   class182(byte[] var1) {
      this.method3478(var1);
   }

   @ObfuscatedName("t")
   void method3478(byte[] var1) {
      this.field2962.field2001 = var1;
      this.field2962.field2000 = 10;
      int var2 = this.field2962.method2470();
      this.field2961 = this.field2962.method2470();
      this.field2966 = 500000;
      this.field2967 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2962.field2000 += var5) {
         int var4 = this.field2962.method2505();
         var5 = this.field2962.method2505();
         if(var4 == 1297379947) {
            this.field2967[var3] = this.field2962.field2000;
            ++var3;
         }
      }

      this.field2968 = 0L;
      this.field2963 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2963[var3] = this.field2967[var3];
      }

      this.field2964 = new int[var2];
      this.field2965 = new int[var2];
   }

   @ObfuscatedName("i")
   void method3479() {
      this.field2962.field2001 = null;
      this.field2967 = null;
      this.field2963 = null;
      this.field2964 = null;
      this.field2965 = null;
   }

   @ObfuscatedName("g")
   boolean method3480() {
      return this.field2962.field2001 != null;
   }

   @ObfuscatedName("h")
   int method3481() {
      return this.field2963.length;
   }

   @ObfuscatedName("f")
   void method3484() {
      this.field2962.field2000 = -1;
   }

   @ObfuscatedName("s")
   void method3485(int var1) {
      int var2 = this.field2962.method2452();
      this.field2964[var1] += var2;
   }

   @ObfuscatedName("r")
   void method3486(int var1) {
      this.field2963[var1] = this.field2962.field2000;
   }

   @ObfuscatedName("l")
   int method3487(int var1) {
      byte var2 = this.field2962.field2001[this.field2962.field2000];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2965[var1] = var5;
         ++this.field2962.field2000;
      } else {
         var5 = this.field2965[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3511(var1, var5);
      } else {
         int var3 = this.field2962.method2452();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2962.field2001[this.field2962.field2000] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2962.field2000;
               this.field2965[var1] = var4;
               return this.method3511(var1, var4);
            }
         }

         this.field2962.field2000 += var3;
         return 0;
      }
   }

   @ObfuscatedName("d")
   int method3488(int var1) {
      int var2 = this.method3487(var1);
      return var2;
   }

   @ObfuscatedName("p")
   long method3489(int var1) {
      return this.field2968 + (long)var1 * (long)this.field2966;
   }

   @ObfuscatedName("k")
   int method3490() {
      int var1 = this.field2963.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2963[var4] >= 0 && this.field2964[var4] < var3) {
            var2 = var4;
            var3 = this.field2964[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("o")
   boolean method3491() {
      int var1 = this.field2963.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2963[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("z")
   void method3506(int var1) {
      this.field2962.field2000 = this.field2963[var1];
   }

   class182() {
   }

   @ObfuscatedName("y")
   int method3511(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2962.method2494();
         var4 = this.field2962.method2452();
         if(var7 == 47) {
            this.field2962.field2000 += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2962.method2472();
            var4 -= 3;
            int var6 = this.field2964[var1];
            this.field2968 += (long)var6 * (long)(this.field2966 - var5);
            this.field2966 = var5;
            this.field2962.field2000 += var4;
            return 2;
         } else {
            this.field2962.field2000 += var4;
            return 3;
         }
      } else {
         byte var3 = field2973[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2962.method2494() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2962.method2494() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("b")
   void method3513(long var1) {
      this.field2968 = var1;
      int var3 = this.field2963.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2964[var4] = 0;
         this.field2965[var4] = 0;
         this.field2962.field2000 = this.field2967[var4];
         this.method3485(var4);
         this.field2963[var4] = this.field2962.field2000;
      }

   }
}
