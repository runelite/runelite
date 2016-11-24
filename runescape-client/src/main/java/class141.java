import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("el")
public class class141 {
   @ObfuscatedName("h")
   int[] field1978;
   @ObfuscatedName("m")
   int[] field1980;
   @ObfuscatedName("d")
   int field1981;
   @ObfuscatedName("w")
   int[] field1982;
   @ObfuscatedName("r")
   int[] field1983;
   @ObfuscatedName("c")
   int field1984;
   @ObfuscatedName("z")
   static final byte[] field1987 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("n")
   Buffer field1989 = new Buffer((byte[])null);
   @ObfuscatedName("g")
   long field1991;

   @ObfuscatedName("c")
   void method2686() {
      this.field1989.offset = -1;
   }

   class141(byte[] var1) {
      this.method2687(var1);
   }

   @ObfuscatedName("n")
   void method2687(byte[] var1) {
      this.field1989.payload = var1;
      this.field1989.offset = 10;
      int var2 = this.field1989.method3097();
      this.field1981 = this.field1989.method3097();
      this.field1984 = 500000;
      this.field1980 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field1989.offset += var5) {
         int var4 = this.field1989.method2995();
         var5 = this.field1989.method2995();
         if(var4 == 1297379947) {
            this.field1980[var3] = this.field1989.offset;
            ++var3;
         }
      }

      this.field1991 = 0L;
      this.field1978 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field1978[var3] = this.field1980[var3];
      }

      this.field1982 = new int[var2];
      this.field1983 = new int[var2];
   }

   @ObfuscatedName("d")
   void method2688() {
      this.field1989.payload = null;
      this.field1980 = null;
      this.field1978 = null;
      this.field1982 = null;
      this.field1983 = null;
   }

   @ObfuscatedName("m")
   boolean method2689() {
      return this.field1989.payload != null;
   }

   @ObfuscatedName("h")
   int method2690() {
      return this.field1978.length;
   }

   @ObfuscatedName("w")
   void method2691(int var1) {
      this.field1989.offset = this.field1978[var1];
   }

   class141() {
   }

   @ObfuscatedName("r")
   void method2692(int var1) {
      this.field1978[var1] = this.field1989.offset;
   }

   @ObfuscatedName("l")
   int method2695(int var1) {
      byte var2 = this.field1989.payload[this.field1989.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field1983[var1] = var5;
         ++this.field1989.offset;
      } else {
         var5 = this.field1983[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method2717(var1, var5);
      } else {
         int var3 = this.field1989.method3142();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field1989.payload[this.field1989.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field1989.offset;
               this.field1983[var1] = var4;
               return this.method2717(var1, var4);
            }
         }

         this.field1989.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("e")
   long method2697(int var1) {
      return this.field1991 + (long)var1 * (long)this.field1984;
   }

   @ObfuscatedName("x")
   int method2698() {
      int var1 = this.field1978.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field1978[var4] >= 0 && this.field1982[var4] < var3) {
            var2 = var4;
            var3 = this.field1982[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("q")
   int method2699(int var1) {
      int var2 = this.method2695(var1);
      return var2;
   }

   @ObfuscatedName("s")
   void method2700(long var1) {
      this.field1991 = var1;
      int var3 = this.field1978.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1982[var4] = 0;
         this.field1983[var4] = 0;
         this.field1989.offset = this.field1980[var4];
         this.method2724(var4);
         this.field1978[var4] = this.field1989.offset;
      }

   }

   @ObfuscatedName("y")
   int method2717(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field1989.method3033();
         var4 = this.field1989.method3142();
         if(var7 == 47) {
            this.field1989.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field1989.method2994();
            var4 -= 3;
            int var6 = this.field1982[var1];
            this.field1991 += (long)var6 * (long)(this.field1984 - var5);
            this.field1984 = var5;
            this.field1989.offset += var4;
            return 2;
         } else {
            this.field1989.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field1987[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field1989.method3033() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field1989.method3033() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("z")
   void method2724(int var1) {
      int var2 = this.field1989.method3142();
      this.field1982[var1] += var2;
   }

   @ObfuscatedName("f")
   boolean method2731() {
      int var1 = this.field1978.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field1978[var2] >= 0) {
            return false;
         }
      }

      return true;
   }
}
