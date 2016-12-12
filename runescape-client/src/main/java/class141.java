import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eq")
public class class141 {
   @ObfuscatedName("v")
   static final byte[] field1976 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("e")
   int field1977;
   @ObfuscatedName("i")
   Buffer field1978 = new Buffer((byte[])null);
   @ObfuscatedName("k")
   int[] field1979;
   @ObfuscatedName("g")
   int[] field1980;
   @ObfuscatedName("n")
   int[] field1981;
   @ObfuscatedName("a")
   int field1982;
   @ObfuscatedName("f")
   int[] field1983;
   @ObfuscatedName("w")
   long field1984;

   @ObfuscatedName("w")
   void method2597() {
      this.field1978.offset = -1;
   }

   @ObfuscatedName("i")
   void method2598(byte[] var1) {
      this.field1978.payload = var1;
      this.field1978.offset = 10;
      int var2 = this.field1978.readUnsignedShort();
      this.field1977 = this.field1978.readUnsignedShort();
      this.field1982 = 500000;
      this.field1983 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field1978.offset += var5) {
         int var4 = this.field1978.method2844();
         var5 = this.field1978.method2844();
         if(var4 == 1297379947) {
            this.field1983[var3] = this.field1978.offset;
            ++var3;
         }
      }

      this.field1984 = 0L;
      this.field1979 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field1979[var3] = this.field1983[var3];
      }

      this.field1980 = new int[var2];
      this.field1981 = new int[var2];
   }

   @ObfuscatedName("e")
   void method2599() {
      this.field1978.payload = null;
      this.field1983 = null;
      this.field1979 = null;
      this.field1980 = null;
      this.field1981 = null;
   }

   @ObfuscatedName("k")
   int method2601() {
      return this.field1979.length;
   }

   @ObfuscatedName("a")
   void method2602(int var1) {
      this.field1978.offset = this.field1979[var1];
   }

   @ObfuscatedName("q")
   void method2603(int var1) {
      this.field1979[var1] = this.field1978.offset;
   }

   class141(byte[] var1) {
      this.method2598(var1);
   }

   @ObfuscatedName("h")
   int method2605(int var1) {
      int var2 = this.method2606(var1);
      return var2;
   }

   @ObfuscatedName("p")
   int method2606(int var1) {
      byte var2 = this.field1978.payload[this.field1978.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field1981[var1] = var5;
         ++this.field1978.offset;
      } else {
         var5 = this.field1981[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method2619(var1, var5);
      } else {
         int var3 = this.field1978.method2869();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field1978.payload[this.field1978.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field1978.offset;
               this.field1981[var1] = var4;
               return this.method2619(var1, var4);
            }
         }

         this.field1978.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("m")
   int method2609() {
      int var1 = this.field1979.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field1979[var4] >= 0 && this.field1980[var4] < var3) {
            var2 = var4;
            var3 = this.field1980[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("r")
   boolean method2610() {
      int var1 = this.field1979.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field1979[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("u")
   void method2611(long var1) {
      this.field1984 = var1;
      int var3 = this.field1979.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1980[var4] = 0;
         this.field1981[var4] = 0;
         this.field1978.offset = this.field1983[var4];
         this.method2631(var4);
         this.field1979[var4] = this.field1978.offset;
      }

   }

   @ObfuscatedName("f")
   boolean method2615() {
      return this.field1978.payload != null;
   }

   class141() {
   }

   @ObfuscatedName("l")
   int method2619(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field1978.readUnsignedByte();
         var4 = this.field1978.method2869();
         if(var7 == 47) {
            this.field1978.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field1978.read24BitInt();
            var4 -= 3;
            int var6 = this.field1980[var1];
            this.field1984 += (long)var6 * (long)(this.field1982 - var5);
            this.field1982 = var5;
            this.field1978.offset += var4;
            return 2;
         } else {
            this.field1978.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field1976[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field1978.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field1978.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("v")
   void method2631(int var1) {
      int var2 = this.field1978.method2869();
      this.field1980[var1] += var2;
   }

   @ObfuscatedName("c")
   long method2632(int var1) {
      return this.field1984 + (long)var1 * (long)this.field1982;
   }
}
