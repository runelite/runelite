import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eo")
public class class141 {
   @ObfuscatedName("u")
   Buffer field1962 = new Buffer((byte[])null);
   @ObfuscatedName("x")
   int field1963;
   @ObfuscatedName("i")
   int[] field1964;
   @ObfuscatedName("a")
   int[] field1965;
   @ObfuscatedName("f")
   int[] field1966;
   @ObfuscatedName("d")
   int field1968;
   @ObfuscatedName("g")
   long field1970;
   @ObfuscatedName("c")
   int[] field1971;
   @ObfuscatedName("z")
   static final byte[] field1975 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};

   class141(byte[] var1) {
      this.method2610(var1);
   }

   @ObfuscatedName("u")
   void method2610(byte[] var1) {
      this.field1962.payload = var1;
      this.field1962.offset = 10;
      int var2 = this.field1962.readUnsignedShort();
      this.field1963 = this.field1962.readUnsignedShort();
      this.field1968 = 500000;
      this.field1964 = new int[var2];

      int var3;
      int var4;
      for(var3 = 0; var3 < var2; this.field1962.offset += var4) {
         int var5 = this.field1962.method2780();
         var4 = this.field1962.method2780();
         if(var5 == 1297379947) {
            this.field1964[var3] = this.field1962.offset;
            ++var3;
         }
      }

      this.field1970 = 0L;
      this.field1965 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field1965[var3] = this.field1964[var3];
      }

      this.field1966 = new int[var2];
      this.field1971 = new int[var2];
   }

   @ObfuscatedName("x")
   void method2611() {
      this.field1962.payload = null;
      this.field1964 = null;
      this.field1965 = null;
      this.field1966 = null;
      this.field1971 = null;
   }

   @ObfuscatedName("i")
   boolean method2612() {
      return this.field1962.payload != null;
   }

   @ObfuscatedName("a")
   int method2613() {
      return this.field1965.length;
   }

   @ObfuscatedName("c")
   void method2614(int var1) {
      this.field1962.offset = this.field1965[var1];
   }

   @ObfuscatedName("g")
   void method2615(int var1) {
      this.field1965[var1] = this.field1962.offset;
   }

   @ObfuscatedName("t")
   void method2617(int var1) {
      int var2 = this.field1962.method2862();
      this.field1966[var1] += var2;
   }

   @ObfuscatedName("e")
   int method2620(int var1, int var2) {
      int var3;
      if(var2 == 255) {
         int var7 = this.field1962.readUnsignedByte();
         var3 = this.field1962.method2862();
         if(var7 == 47) {
            this.field1962.offset += var3;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field1962.read24BitInt();
            var3 -= 3;
            int var6 = this.field1966[var1];
            this.field1970 += (long)var6 * (long)(this.field1968 - var5);
            this.field1968 = var5;
            this.field1962.offset += var3;
            return 2;
         } else {
            this.field1962.offset += var3;
            return 3;
         }
      } else {
         byte var4 = field1975[var2 - 128];
         var3 = var2;
         if(var4 >= 1) {
            var3 = var2 | this.field1962.readUnsignedByte() << 8;
         }

         if(var4 >= 2) {
            var3 |= this.field1962.readUnsignedByte() << 16;
         }

         return var3;
      }
   }

   @ObfuscatedName("v")
   long method2621(int var1) {
      return this.field1970 + (long)var1 * (long)this.field1968;
   }

   @ObfuscatedName("j")
   int method2622() {
      int var1 = this.field1965.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field1965[var4] >= 0 && this.field1966[var4] < var3) {
            var2 = var4;
            var3 = this.field1966[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("q")
   int method2632(int var1) {
      byte var2 = this.field1962.payload[this.field1962.offset];
      int var3;
      if(var2 < 0) {
         var3 = var2 & 255;
         this.field1971[var1] = var3;
         ++this.field1962.offset;
      } else {
         var3 = this.field1971[var1];
      }

      if(var3 != 240 && var3 != 247) {
         return this.method2620(var1, var3);
      } else {
         int var4 = this.field1962.method2862();
         if(var3 == 247 && var4 > 0) {
            int var5 = this.field1962.payload[this.field1962.offset] & 255;
            if(var5 >= 241 && var5 <= 243 || var5 == 246 || var5 == 248 || var5 >= 250 && var5 <= 252 || var5 == 254) {
               ++this.field1962.offset;
               this.field1971[var1] = var5;
               return this.method2620(var1, var5);
            }
         }

         this.field1962.offset += var4;
         return 0;
      }
   }

   class141() {
   }

   @ObfuscatedName("z")
   void method2636() {
      this.field1962.offset = -1;
   }

   @ObfuscatedName("p")
   boolean method2641() {
      int var1 = this.field1965.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field1965[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("m")
   int method2650(int var1) {
      int var2 = this.method2632(var1);
      return var2;
   }

   @ObfuscatedName("k")
   void method2659(long var1) {
      this.field1970 = var1;
      int var3 = this.field1965.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1966[var4] = 0;
         this.field1971[var4] = 0;
         this.field1962.offset = this.field1964[var4];
         this.method2617(var4);
         this.field1965[var4] = this.field1962.offset;
      }

   }
}
