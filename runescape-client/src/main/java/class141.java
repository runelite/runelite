import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("et")
public class class141 {
   @ObfuscatedName("k")
   int field1986;
   @ObfuscatedName("c")
   int field1987;
   @ObfuscatedName("f")
   int[] field1988;
   @ObfuscatedName("b")
   long field1990;
   @ObfuscatedName("g")
   int[] field1991;
   @ObfuscatedName("x")
   static final byte[] field1992 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("s")
   Buffer field1994 = new Buffer((byte[])null);
   @ObfuscatedName("h")
   int[] field1995;
   @ObfuscatedName("a")
   int[] field1997;

   @ObfuscatedName("r")
   int method2555(int var1) {
      int var2 = this.method2602(var1);
      return var2;
   }

   @ObfuscatedName("c")
   void method2556() {
      this.field1994.payload = null;
      this.field1988 = null;
      this.field1995 = null;
      this.field1997 = null;
      this.field1991 = null;
   }

   @ObfuscatedName("g")
   int method2557() {
      return this.field1995.length;
   }

   @ObfuscatedName("k")
   void method2559(int var1) {
      this.field1994.offset = this.field1995[var1];
   }

   @ObfuscatedName("u")
   void method2560(int var1) {
      this.field1995[var1] = this.field1994.offset;
   }

   @ObfuscatedName("f")
   boolean method2561() {
      return this.field1994.payload != null;
   }

   @ObfuscatedName("x")
   void method2562(int var1) {
      int var2 = this.field1994.method2851();
      this.field1997[var1] += var2;
   }

   class141(byte[] var1) {
      this.method2599(var1);
   }

   @ObfuscatedName("m")
   int method2564(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field1994.readUnsignedByte();
         var4 = this.field1994.method2851();
         if(var7 == 47) {
            this.field1994.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field1994.read24BitInt();
            var4 -= 3;
            int var6 = this.field1997[var1];
            this.field1990 += (long)var6 * (long)(this.field1986 - var5);
            this.field1986 = var5;
            this.field1994.offset += var4;
            return 2;
         } else {
            this.field1994.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field1992[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field1994.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field1994.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("j")
   long method2565(int var1) {
      return this.field1990 + (long)var1 * (long)this.field1986;
   }

   @ObfuscatedName("w")
   int method2566() {
      int var1 = this.field1995.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field1995[var4] >= 0 && this.field1997[var4] < var3) {
            var2 = var4;
            var3 = this.field1997[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("p")
   boolean method2567() {
      int var1 = this.field1995.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field1995[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("o")
   void method2568(long var1) {
      this.field1990 = var1;
      int var3 = this.field1995.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1997[var4] = 0;
         this.field1991[var4] = 0;
         this.field1994.offset = this.field1988[var4];
         this.method2562(var4);
         this.field1995[var4] = this.field1994.offset;
      }

   }

   @ObfuscatedName("b")
   void method2579() {
      this.field1994.offset = -1;
   }

   class141() {
   }

   @ObfuscatedName("s")
   void method2599(byte[] var1) {
      this.field1994.payload = var1;
      this.field1994.offset = 10;
      int var2 = this.field1994.readUnsignedShort();
      this.field1987 = this.field1994.readUnsignedShort();
      this.field1986 = 500000;
      this.field1988 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field1994.offset += var5) {
         int var4 = this.field1994.method2727();
         var5 = this.field1994.method2727();
         if(var4 == 1297379947) {
            this.field1988[var3] = this.field1994.offset;
            ++var3;
         }
      }

      this.field1990 = 0L;
      this.field1995 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field1995[var3] = this.field1988[var3];
      }

      this.field1997 = new int[var2];
      this.field1991 = new int[var2];
   }

   @ObfuscatedName("n")
   int method2602(int var1) {
      byte var2 = this.field1994.payload[this.field1994.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field1991[var1] = var5;
         ++this.field1994.offset;
      } else {
         var5 = this.field1991[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method2564(var1, var5);
      } else {
         int var3 = this.field1994.method2851();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field1994.payload[this.field1994.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field1994.offset;
               this.field1991[var1] = var4;
               return this.method2564(var1, var4);
            }
         }

         this.field1994.offset += var3;
         return 0;
      }
   }
}
