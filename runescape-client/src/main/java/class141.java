import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ea")
public class class141 {
   @ObfuscatedName("r")
   int field1976;
   @ObfuscatedName("d")
   int field1977;
   @ObfuscatedName("p")
   int[] field1979;
   @ObfuscatedName("j")
   int[] field1980;
   @ObfuscatedName("n")
   int[] field1981;
   @ObfuscatedName("h")
   int[] field1982;
   @ObfuscatedName("i")
   long field1984;
   @ObfuscatedName("o")
   static final byte[] field1985 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("q")
   Buffer field1989 = new Buffer((byte[])null);

   @ObfuscatedName("z")
   boolean method2669() {
      int var1 = this.field1979.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field1979[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("q")
   void method2670(byte[] var1) {
      this.field1989.payload = var1;
      this.field1989.offset = 10;
      int var2 = this.field1989.readUnsignedShort();
      this.field1977 = this.field1989.readUnsignedShort();
      this.field1976 = 500000;
      this.field1982 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field1989.offset += var5) {
         int var4 = this.field1989.method2965();
         var5 = this.field1989.method2965();
         if(var4 == 1297379947) {
            this.field1982[var3] = this.field1989.offset;
            ++var3;
         }
      }

      this.field1984 = 0L;
      this.field1979 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field1979[var3] = this.field1982[var3];
      }

      this.field1980 = new int[var2];
      this.field1981 = new int[var2];
   }

   @ObfuscatedName("d")
   void method2671() {
      this.field1989.payload = null;
      this.field1982 = null;
      this.field1979 = null;
      this.field1980 = null;
      this.field1981 = null;
   }

   @ObfuscatedName("p")
   int method2673() {
      return this.field1979.length;
   }

   @ObfuscatedName("j")
   void method2674(int var1) {
      this.field1989.offset = this.field1979[var1];
   }

   @ObfuscatedName("n")
   void method2675(int var1) {
      this.field1979[var1] = this.field1989.offset;
   }

   @ObfuscatedName("o")
   void method2677(int var1) {
      int var2 = this.field1989.method2849();
      this.field1980[var1] += var2;
   }

   @ObfuscatedName("u")
   int method2679(int var1) {
      byte var2 = this.field1989.payload[this.field1989.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field1981[var1] = var5;
         ++this.field1989.offset;
      } else {
         var5 = this.field1981[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method2709(var1, var5);
      } else {
         int var3 = this.field1989.method2849();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field1989.payload[this.field1989.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field1989.offset;
               this.field1981[var1] = var4;
               return this.method2709(var1, var4);
            }
         }

         this.field1989.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("c")
   void method2681() {
      this.field1989.offset = -1;
   }

   @ObfuscatedName("f")
   int method2682() {
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

   class141() {
   }

   @ObfuscatedName("h")
   boolean method2689() {
      return this.field1989.payload != null;
   }

   @ObfuscatedName("s")
   int method2695(int var1) {
      int var2 = this.method2679(var1);
      return var2;
   }

   @ObfuscatedName("v")
   long method2696(int var1) {
      return this.field1984 + (long)var1 * (long)this.field1976;
   }

   class141(byte[] var1) {
      this.method2670(var1);
   }

   @ObfuscatedName("t")
   void method2703(long var1) {
      this.field1984 = var1;
      int var3 = this.field1979.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1980[var4] = 0;
         this.field1981[var4] = 0;
         this.field1989.offset = this.field1982[var4];
         this.method2677(var4);
         this.field1979[var4] = this.field1989.offset;
      }

   }

   @ObfuscatedName("b")
   int method2709(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field1989.readUnsignedByte();
         var4 = this.field1989.method2849();
         if(var7 == 47) {
            this.field1989.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field1989.read24BitInt();
            var4 -= 3;
            int var6 = this.field1980[var1];
            this.field1984 += (long)var6 * (long)(this.field1976 - var5);
            this.field1976 = var5;
            this.field1989.offset += var4;
            return 2;
         } else {
            this.field1989.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field1985[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field1989.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field1989.readUnsignedByte() << 16;
         }

         return var4;
      }
   }
}
