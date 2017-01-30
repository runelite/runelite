import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("er")
public class class141 {
   @ObfuscatedName("g")
   int field1983;
   @ObfuscatedName("p")
   Buffer field1984 = new Buffer((byte[])null);
   @ObfuscatedName("q")
   int[] field1985;
   @ObfuscatedName("d")
   int[] field1986;
   @ObfuscatedName("k")
   int[] field1987;
   @ObfuscatedName("j")
   int field1988;
   @ObfuscatedName("x")
   int[] field1990;
   @ObfuscatedName("a")
   static final byte[] field1992 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("o")
   long field1995;

   @ObfuscatedName("g")
   void method2644() {
      this.field1984.payload = null;
      this.field1990 = null;
      this.field1985 = null;
      this.field1986 = null;
      this.field1987 = null;
   }

   @ObfuscatedName("x")
   boolean method2645() {
      return this.field1984.payload != null;
   }

   @ObfuscatedName("q")
   int method2646() {
      return this.field1985.length;
   }

   @ObfuscatedName("d")
   void method2647(int var1) {
      this.field1984.offset = this.field1985[var1];
   }

   @ObfuscatedName("k")
   void method2648(int var1) {
      this.field1985[var1] = this.field1984.offset;
   }

   @ObfuscatedName("j")
   void method2649() {
      this.field1984.offset = -1;
   }

   @ObfuscatedName("s")
   void method2650(int var1) {
      int var2 = this.field1984.method2859();
      this.field1986[var1] += var2;
   }

   @ObfuscatedName("o")
   int method2651(int var1) {
      int var2 = this.method2656(var1);
      return var2;
   }

   @ObfuscatedName("c")
   int method2653(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field1984.readUnsignedByte();
         var4 = this.field1984.method2859();
         if(var7 == 47) {
            this.field1984.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field1984.read24BitInt();
            var4 -= 3;
            int var6 = this.field1986[var1];
            this.field1995 += (long)var6 * (long)(this.field1988 - var5);
            this.field1988 = var5;
            this.field1984.offset += var4;
            return 2;
         } else {
            this.field1984.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field1992[var2 - 128];
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

   @ObfuscatedName("u")
   long method2654(int var1) {
      return this.field1995 + (long)var1 * (long)this.field1988;
   }

   @ObfuscatedName("i")
   int method2655() {
      int var1 = this.field1985.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field1985[var4] >= 0 && this.field1986[var4] < var3) {
            var2 = var4;
            var3 = this.field1986[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("a")
   int method2656(int var1) {
      byte var2 = this.field1984.payload[this.field1984.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field1987[var1] = var5;
         ++this.field1984.offset;
      } else {
         var5 = this.field1987[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method2653(var1, var5);
      } else {
         int var3 = this.field1984.method2859();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field1984.payload[this.field1984.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field1984.offset;
               this.field1987[var1] = var4;
               return this.method2653(var1, var4);
            }
         }

         this.field1984.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("n")
   void method2657(long var1) {
      this.field1995 = var1;
      int var3 = this.field1985.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1986[var4] = 0;
         this.field1987[var4] = 0;
         this.field1984.offset = this.field1990[var4];
         this.method2650(var4);
         this.field1985[var4] = this.field1984.offset;
      }

   }

   class141() {
   }

   @ObfuscatedName("p")
   void method2670(byte[] var1) {
      this.field1984.payload = var1;
      this.field1984.offset = 10;
      int var2 = this.field1984.readUnsignedShort();
      this.field1983 = this.field1984.readUnsignedShort();
      this.field1988 = 500000;
      this.field1990 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field1984.offset += var5) {
         int var4 = this.field1984.method2819();
         var5 = this.field1984.method2819();
         if(var4 == 1297379947) {
            this.field1990[var3] = this.field1984.offset;
            ++var3;
         }
      }

      this.field1995 = 0L;
      this.field1985 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field1985[var3] = this.field1990[var3];
      }

      this.field1986 = new int[var2];
      this.field1987 = new int[var2];
   }

   @ObfuscatedName("z")
   boolean method2683() {
      int var1 = this.field1985.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field1985[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   class141(byte[] var1) {
      this.method2670(var1);
   }
}
