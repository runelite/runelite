import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("es")
public class class141 {
   @ObfuscatedName("y")
   static final byte[] field1983 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("x")
   Buffer field1984 = new Buffer((byte[])null);
   @ObfuscatedName("d")
   int[] field1985;
   @ObfuscatedName("w")
   int[] field1986;
   @ObfuscatedName("h")
   int[] field1987;
   @ObfuscatedName("u")
   int field1988;
   @ObfuscatedName("g")
   long field1989;
   @ObfuscatedName("c")
   int[] field1991;
   @ObfuscatedName("j")
   int field1992;

   class141(byte[] var1) {
      this.method2662(var1);
   }

   @ObfuscatedName("x")
   void method2662(byte[] var1) {
      this.field1984.payload = var1;
      this.field1984.offset = 10;
      int var2 = this.field1984.readUnsignedShort();
      this.field1992 = this.field1984.readUnsignedShort();
      this.field1988 = 500000;
      this.field1991 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field1984.offset += var5) {
         int var4 = this.field1984.readInt();
         var5 = this.field1984.readInt();
         if(var4 == 1297379947) {
            this.field1991[var3] = this.field1984.offset;
            ++var3;
         }
      }

      this.field1989 = 0L;
      this.field1985 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field1985[var3] = this.field1991[var3];
      }

      this.field1986 = new int[var2];
      this.field1987 = new int[var2];
   }

   @ObfuscatedName("j")
   void method2663() {
      this.field1984.payload = null;
      this.field1991 = null;
      this.field1985 = null;
      this.field1986 = null;
      this.field1987 = null;
   }

   @ObfuscatedName("e")
   void method2664(int var1) {
      int var2 = this.field1984.method2847();
      this.field1986[var1] += var2;
   }

   @ObfuscatedName("w")
   void method2666(int var1) {
      this.field1984.offset = this.field1985[var1];
   }

   @ObfuscatedName("u")
   void method2667(int var1) {
      this.field1985[var1] = this.field1984.offset;
   }

   @ObfuscatedName("q")
   int method2670(int var1) {
      int var2 = this.method2671(var1);
      return var2;
   }

   @ObfuscatedName("v")
   int method2671(int var1) {
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
         return this.method2672(var1, var5);
      } else {
         int var3 = this.field1984.method2847();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field1984.payload[this.field1984.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field1984.offset;
               this.field1987[var1] = var4;
               return this.method2672(var1, var4);
            }
         }

         this.field1984.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("l")
   int method2672(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field1984.readUnsignedByte();
         var4 = this.field1984.method2847();
         if(var7 == 47) {
            this.field1984.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field1984.read24BitInt();
            var4 -= 3;
            int var6 = this.field1986[var1];
            this.field1989 += (long)var6 * (long)(this.field1988 - var5);
            this.field1988 = var5;
            this.field1984.offset += var4;
            return 2;
         } else {
            this.field1984.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field1983[var2 - 128];
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

   @ObfuscatedName("s")
   long method2673(int var1) {
      return this.field1989 + (long)var1 * (long)this.field1988;
   }

   @ObfuscatedName("r")
   int method2674() {
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

   @ObfuscatedName("m")
   boolean method2676() {
      int var1 = this.field1985.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field1985[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("y")
   void method2678() {
      this.field1984.offset = -1;
   }

   class141() {
   }

   @ObfuscatedName("c")
   boolean method2691() {
      return this.field1984.payload != null;
   }

   @ObfuscatedName("i")
   void method2696(long var1) {
      this.field1989 = var1;
      int var3 = this.field1985.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1986[var4] = 0;
         this.field1987[var4] = 0;
         this.field1984.offset = this.field1991[var4];
         this.method2664(var4);
         this.field1985[var4] = this.field1984.offset;
      }

   }

   @ObfuscatedName("d")
   int method2700() {
      return this.field1985.length;
   }
}
