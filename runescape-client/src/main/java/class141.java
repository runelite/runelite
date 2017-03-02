import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ec")
public class class141 {
   @ObfuscatedName("k")
   int[] field1970;
   @ObfuscatedName("r")
   static final byte[] field1971 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("l")
   int field1974;
   @ObfuscatedName("h")
   int[] field1975;
   @ObfuscatedName("n")
   int field1976;
   @ObfuscatedName("a")
   long field1978;
   @ObfuscatedName("t")
   int[] field1979;
   @ObfuscatedName("i")
   int[] field1982;
   @ObfuscatedName("b")
   Buffer field1983 = new Buffer((byte[])null);

   @ObfuscatedName("l")
   void method2687() {
      this.field1983.payload = null;
      this.field1982 = null;
      this.field1979 = null;
      this.field1970 = null;
      this.field1975 = null;
   }

   @ObfuscatedName("i")
   boolean method2688() {
      return this.field1983.payload != null;
   }

   @ObfuscatedName("t")
   int method2689() {
      return this.field1979.length;
   }

   @ObfuscatedName("k")
   void method2690(int var1) {
      this.field1983.offset = this.field1979[var1];
   }

   @ObfuscatedName("z")
   void method2692() {
      this.field1983.offset = -1;
   }

   @ObfuscatedName("p")
   void method2693(int var1) {
      int var2 = this.field1983.method2872();
      this.field1970[var1] += var2;
   }

   @ObfuscatedName("s")
   int method2694(int var1) {
      int var2 = this.method2708(var1);
      return var2;
   }

   @ObfuscatedName("w")
   long method2697(int var1) {
      return this.field1978 + (long)var1 * (long)this.field1976;
   }

   @ObfuscatedName("u")
   boolean method2699() {
      int var1 = this.field1979.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field1979[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("m")
   int method2700() {
      int var1 = this.field1979.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field1979[var4] >= 0 && this.field1970[var4] < var3) {
            var2 = var4;
            var3 = this.field1970[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("x")
   void method2705(int var1) {
      this.field1979[var1] = this.field1983.offset;
   }

   @ObfuscatedName("o")
   int method2708(int var1) {
      byte var2 = this.field1983.payload[this.field1983.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field1975[var1] = var5;
         ++this.field1983.offset;
      } else {
         var5 = this.field1975[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method2720(var1, var5);
      } else {
         int var3 = this.field1983.method2872();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field1983.payload[this.field1983.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field1983.offset;
               this.field1975[var1] = var4;
               return this.method2720(var1, var4);
            }
         }

         this.field1983.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("q")
   void method2709(long var1) {
      this.field1978 = var1;
      int var3 = this.field1979.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1970[var4] = 0;
         this.field1975[var4] = 0;
         this.field1983.offset = this.field1982[var4];
         this.method2693(var4);
         this.field1979[var4] = this.field1983.offset;
      }

   }

   @ObfuscatedName("b")
   void method2715(byte[] var1) {
      this.field1983.payload = var1;
      this.field1983.offset = 10;
      int var2 = this.field1983.readUnsignedShort();
      this.field1974 = this.field1983.readUnsignedShort();
      this.field1976 = 500000;
      this.field1982 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field1983.offset += var5) {
         int var4 = this.field1983.readInt();
         var5 = this.field1983.readInt();
         if(var4 == 1297379947) {
            this.field1982[var3] = this.field1983.offset;
            ++var3;
         }
      }

      this.field1978 = 0L;
      this.field1979 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field1979[var3] = this.field1982[var3];
      }

      this.field1970 = new int[var2];
      this.field1975 = new int[var2];
   }

   class141() {
   }

   @ObfuscatedName("y")
   int method2720(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field1983.readUnsignedByte();
         var4 = this.field1983.method2872();
         if(var7 == 47) {
            this.field1983.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field1983.read24BitInt();
            var4 -= 3;
            int var6 = this.field1970[var1];
            this.field1978 += (long)var6 * (long)(this.field1976 - var5);
            this.field1976 = var5;
            this.field1983.offset += var4;
            return 2;
         } else {
            this.field1983.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field1971[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field1983.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field1983.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   class141(byte[] var1) {
      this.method2715(var1);
   }
}
