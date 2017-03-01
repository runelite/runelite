import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ei")
public class class141 {
   @ObfuscatedName("i")
   static final byte[] field1978 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("g")
   int[] field1980;
   @ObfuscatedName("a")
   long field1981;
   @ObfuscatedName("v")
   int[] field1982;
   @ObfuscatedName("p")
   int[] field1983;
   @ObfuscatedName("j")
   int field1984;
   @ObfuscatedName("y")
   int[] field1986;
   @ObfuscatedName("n")
   int field1987;
   @ObfuscatedName("x")
   Buffer field1991 = new Buffer((byte[])null);

   @ObfuscatedName("f")
   int method2707(int var1) {
      byte var2 = this.field1991.payload[this.field1991.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field1983[var1] = var5;
         ++this.field1991.offset;
      } else {
         var5 = this.field1983[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method2721(var1, var5);
      } else {
         int var3 = this.field1991.method3059();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field1991.payload[this.field1991.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field1991.offset;
               this.field1983[var1] = var4;
               return this.method2721(var1, var4);
            }
         }

         this.field1991.offset += var3;
         return 0;
      }
   }

   class141() {
   }

   @ObfuscatedName("n")
   void method2708() {
      this.field1991.payload = null;
      this.field1980 = null;
      this.field1982 = null;
      this.field1986 = null;
      this.field1983 = null;
   }

   @ObfuscatedName("v")
   int method2710() {
      return this.field1982.length;
   }

   @ObfuscatedName("g")
   boolean method2711() {
      return this.field1991.payload != null;
   }

   @ObfuscatedName("p")
   void method2712(int var1) {
      this.field1982[var1] = this.field1991.offset;
   }

   @ObfuscatedName("j")
   void method2713() {
      this.field1991.offset = -1;
   }

   @ObfuscatedName("s")
   void method2714(int var1) {
      int var2 = this.field1991.method3059();
      this.field1986[var1] += var2;
   }

   @ObfuscatedName("x")
   void method2716(byte[] var1) {
      this.field1991.payload = var1;
      this.field1991.offset = 10;
      int var2 = this.field1991.readUnsignedShort();
      this.field1987 = this.field1991.readUnsignedShort();
      this.field1984 = 500000;
      this.field1980 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field1991.offset += var5) {
         int var4 = this.field1991.readInt();
         var5 = this.field1991.readInt();
         if(var4 == 1297379947) {
            this.field1980[var3] = this.field1991.offset;
            ++var3;
         }
      }

      this.field1981 = 0L;
      this.field1982 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field1982[var3] = this.field1980[var3];
      }

      this.field1986 = new int[var2];
      this.field1983 = new int[var2];
   }

   @ObfuscatedName("c")
   int method2719() {
      int var1 = this.field1982.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field1982[var4] >= 0 && this.field1986[var4] < var3) {
            var2 = var4;
            var3 = this.field1986[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("b")
   boolean method2720() {
      int var1 = this.field1982.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field1982[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("o")
   int method2721(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field1991.readUnsignedByte();
         var4 = this.field1991.method3059();
         if(var7 == 47) {
            this.field1991.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field1991.read24BitInt();
            var4 -= 3;
            int var6 = this.field1986[var1];
            this.field1981 += (long)var6 * (long)(this.field1984 - var5);
            this.field1984 = var5;
            this.field1991.offset += var4;
            return 2;
         } else {
            this.field1991.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field1978[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field1991.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field1991.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("q")
   long method2729(int var1) {
      return this.field1981 + (long)var1 * (long)this.field1984;
   }

   @ObfuscatedName("w")
   void method2734(long var1) {
      this.field1981 = var1;
      int var3 = this.field1982.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1986[var4] = 0;
         this.field1983[var4] = 0;
         this.field1991.offset = this.field1980[var4];
         this.method2714(var4);
         this.field1982[var4] = this.field1991.offset;
      }

   }

   @ObfuscatedName("y")
   void method2737(int var1) {
      this.field1991.offset = this.field1982[var1];
   }

   @ObfuscatedName("k")
   int method2745(int var1) {
      int var2 = this.method2707(var1);
      return var2;
   }

   class141(byte[] var1) {
      this.method2716(var1);
   }
}
