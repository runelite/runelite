import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eo")
public class class141 {
   @ObfuscatedName("g")
   int[] field1992;
   @ObfuscatedName("m")
   int field1993;
   @ObfuscatedName("b")
   int[] field1994;
   @ObfuscatedName("l")
   int field1995;
   @ObfuscatedName("h")
   int[] field1996;
   @ObfuscatedName("v")
   int[] field1997;
   @ObfuscatedName("u")
   long field2000;
   @ObfuscatedName("o")
   Buffer field2001 = new Buffer((byte[])null);
   @ObfuscatedName("k")
   static final byte[] field2005 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};

   class141(byte[] var1) {
      this.method2581(var1);
   }

   @ObfuscatedName("k")
   void method2571(int var1) {
      int var2 = this.field2001.method2878();
      this.field1996[var1] += var2;
   }

   @ObfuscatedName("m")
   void method2572() {
      this.field2001.payload = null;
      this.field1994 = null;
      this.field1992 = null;
      this.field1996 = null;
      this.field1997 = null;
   }

   @ObfuscatedName("g")
   int method2574() {
      return this.field1992.length;
   }

   @ObfuscatedName("l")
   void method2575(int var1) {
      this.field2001.offset = this.field1992[var1];
   }

   @ObfuscatedName("c")
   void method2576(int var1) {
      this.field1992[var1] = this.field2001.offset;
   }

   @ObfuscatedName("u")
   void method2577() {
      this.field2001.offset = -1;
   }

   @ObfuscatedName("z")
   int method2578(int var1) {
      int var2 = this.method2615(var1);
      return var2;
   }

   @ObfuscatedName("o")
   void method2581(byte[] var1) {
      this.field2001.payload = var1;
      this.field2001.offset = 10;
      int var2 = this.field2001.readUnsignedShort();
      this.field1993 = this.field2001.readUnsignedShort();
      this.field1995 = 500000;
      this.field1994 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2001.offset += var5) {
         int var4 = this.field2001.method2731();
         var5 = this.field2001.method2731();
         if(var4 == 1297379947) {
            this.field1994[var3] = this.field2001.offset;
            ++var3;
         }
      }

      this.field2000 = 0L;
      this.field1992 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field1992[var3] = this.field1994[var3];
      }

      this.field1996 = new int[var2];
      this.field1997 = new int[var2];
   }

   @ObfuscatedName("p")
   int method2582() {
      int var1 = this.field1992.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field1992[var4] >= 0 && this.field1996[var4] < var3) {
            var2 = var4;
            var3 = this.field1996[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("s")
   void method2584(long var1) {
      this.field2000 = var1;
      int var3 = this.field1992.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1996[var4] = 0;
         this.field1997[var4] = 0;
         this.field2001.offset = this.field1994[var4];
         this.method2571(var4);
         this.field1992[var4] = this.field2001.offset;
      }

   }

   @ObfuscatedName("i")
   boolean method2592() {
      int var1 = this.field1992.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field1992[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   class141() {
   }

   @ObfuscatedName("f")
   long method2598(int var1) {
      return this.field2000 + (long)var1 * (long)this.field1995;
   }

   @ObfuscatedName("j")
   int method2604(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2001.readUnsignedByte();
         var4 = this.field2001.method2878();
         if(var7 == 47) {
            this.field2001.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2001.read24BitInt();
            var4 -= 3;
            int var6 = this.field1996[var1];
            this.field2000 += (long)var6 * (long)(this.field1995 - var5);
            this.field1995 = var5;
            this.field2001.offset += var4;
            return 2;
         } else {
            this.field2001.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2005[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2001.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2001.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("b")
   boolean method2605() {
      return this.field2001.payload != null;
   }

   @ObfuscatedName("y")
   int method2615(int var1) {
      byte var2 = this.field2001.payload[this.field2001.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field1997[var1] = var5;
         ++this.field2001.offset;
      } else {
         var5 = this.field1997[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method2604(var1, var5);
      } else {
         int var3 = this.field2001.method2878();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2001.payload[this.field2001.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2001.offset;
               this.field1997[var1] = var4;
               return this.method2604(var1, var4);
            }
         }

         this.field2001.offset += var3;
         return 0;
      }
   }
}
