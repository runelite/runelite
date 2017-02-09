import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eq")
public class class141 {
   @ObfuscatedName("r")
   int[] field1971;
   @ObfuscatedName("j")
   int[] field1972;
   @ObfuscatedName("o")
   int[] field1973;
   @ObfuscatedName("w")
   int[] field1974;
   @ObfuscatedName("y")
   int field1978;
   @ObfuscatedName("n")
   long field1979;
   @ObfuscatedName("c")
   static final byte[] field1980 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("q")
   int field1982;
   @ObfuscatedName("k")
   Buffer field1984 = new Buffer((byte[])null);

   class141(byte[] var1) {
      this.method2615(var1);
   }

   @ObfuscatedName("k")
   void method2615(byte[] var1) {
      this.field1984.payload = var1;
      this.field1984.offset = 10;
      int var2 = this.field1984.readUnsignedShort();
      this.field1978 = this.field1984.readUnsignedShort();
      this.field1982 = 500000;
      this.field1973 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field1984.offset += var5) {
         int var4 = this.field1984.method3062();
         var5 = this.field1984.method3062();
         if(var4 == 1297379947) {
            this.field1973[var3] = this.field1984.offset;
            ++var3;
         }
      }

      this.field1979 = 0L;
      this.field1971 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field1971[var3] = this.field1973[var3];
      }

      this.field1974 = new int[var2];
      this.field1972 = new int[var2];
   }

   @ObfuscatedName("y")
   void method2616() {
      this.field1984.payload = null;
      this.field1973 = null;
      this.field1971 = null;
      this.field1974 = null;
      this.field1972 = null;
   }

   @ObfuscatedName("o")
   boolean method2617() {
      return this.field1984.payload != null;
   }

   @ObfuscatedName("r")
   int method2618() {
      return this.field1971.length;
   }

   @ObfuscatedName("w")
   void method2619(int var1) {
      this.field1984.offset = this.field1971[var1];
   }

   @ObfuscatedName("j")
   void method2620(int var1) {
      this.field1971[var1] = this.field1984.offset;
   }

   @ObfuscatedName("c")
   void method2621() {
      this.field1984.offset = -1;
   }

   @ObfuscatedName("v")
   int method2625(int var1) {
      byte var2 = this.field1984.payload[this.field1984.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field1972[var1] = var5;
         ++this.field1984.offset;
      } else {
         var5 = this.field1972[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method2651(var1, var5);
      } else {
         int var3 = this.field1984.method2942();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field1984.payload[this.field1984.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field1984.offset;
               this.field1972[var1] = var4;
               return this.method2651(var1, var4);
            }
         }

         this.field1984.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("h")
   long method2626(int var1) {
      return this.field1979 + (long)var1 * (long)this.field1982;
   }

   @ObfuscatedName("t")
   boolean method2628() {
      int var1 = this.field1971.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field1971[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   class141() {
   }

   @ObfuscatedName("g")
   void method2635(int var1) {
      int var2 = this.field1984.method2942();
      this.field1974[var1] += var2;
   }

   @ObfuscatedName("f")
   void method2642(long var1) {
      this.field1979 = var1;
      int var3 = this.field1971.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1974[var4] = 0;
         this.field1972[var4] = 0;
         this.field1984.offset = this.field1973[var4];
         this.method2635(var4);
         this.field1971[var4] = this.field1984.offset;
      }

   }

   @ObfuscatedName("i")
   int method2645(int var1) {
      int var2 = this.method2625(var1);
      return var2;
   }

   @ObfuscatedName("a")
   int method2651(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field1984.readUnsignedByte();
         var4 = this.field1984.method2942();
         if(var7 == 47) {
            this.field1984.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field1984.read24BitInt();
            var4 -= 3;
            int var6 = this.field1974[var1];
            this.field1979 += (long)var6 * (long)(this.field1982 - var5);
            this.field1982 = var5;
            this.field1984.offset += var4;
            return 2;
         } else {
            this.field1984.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field1980[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field1984.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field1984.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("p")
   int method2659() {
      int var1 = this.field1971.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field1971[var4] >= 0 && this.field1974[var4] < var3) {
            var2 = var4;
            var3 = this.field1974[var4];
         }
      }

      return var2;
   }
}
