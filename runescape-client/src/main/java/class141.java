import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("em")
public class class141 {
   @ObfuscatedName("r")
   int[] field1997;
   @ObfuscatedName("i")
   int field1998;
   @ObfuscatedName("u")
   int[] field1999;
   @ObfuscatedName("h")
   int[] field2000;
   @ObfuscatedName("m")
   long field2001;
   @ObfuscatedName("o")
   int[] field2002;
   @ObfuscatedName("l")
   int field2003;
   @ObfuscatedName("w")
   static final byte[] field2009 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   @ObfuscatedName("f")
   Buffer field2010 = new Buffer((byte[])null);

   @ObfuscatedName("f")
   void method2687(byte[] var1) {
      this.field2010.payload = var1;
      this.field2010.offset = 10;
      int var2 = this.field2010.readUnsignedShort();
      this.field1998 = this.field2010.readUnsignedShort();
      this.field2003 = 500000;
      this.field1999 = new int[var2];

      int var3;
      int var4;
      for(var3 = 0; var3 < var2; this.field2010.offset += var4) {
         int var5 = this.field2010.readInt();
         var4 = this.field2010.readInt();
         if(var5 == 1297379947) {
            this.field1999[var3] = this.field2010.offset;
            ++var3;
         }
      }

      this.field2001 = 0L;
      this.field2000 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2000[var3] = this.field1999[var3];
      }

      this.field1997 = new int[var2];
      this.field2002 = new int[var2];
   }

   @ObfuscatedName("u")
   boolean method2689() {
      return this.field2010.payload != null;
   }

   @ObfuscatedName("l")
   void method2692(int var1) {
      this.field2000[var1] = this.field2010.offset;
   }

   @ObfuscatedName("m")
   void method2694(int var1) {
      int var2 = this.field2010.readVarInt();
      this.field1997[var1] += var2;
   }

   @ObfuscatedName("w")
   int method2695(int var1) {
      int var2 = this.method2696(var1);
      return var2;
   }

   @ObfuscatedName("j")
   int method2696(int var1) {
      byte var2 = this.field2010.payload[this.field2010.offset];
      int var3;
      if(var2 < 0) {
         var3 = var2 & 255;
         this.field2002[var1] = var3;
         ++this.field2010.offset;
      } else {
         var3 = this.field2002[var1];
      }

      if(var3 != 240 && var3 != 247) {
         return this.method2697(var1, var3);
      } else {
         int var4 = this.field2010.readVarInt();
         if(var3 == 247 && var4 > 0) {
            int var5 = this.field2010.payload[this.field2010.offset] & 255;
            if(var5 >= 241 && var5 <= 243 || var5 == 246 || var5 == 248 || var5 >= 250 && var5 <= 252 || var5 == 254) {
               ++this.field2010.offset;
               this.field2002[var1] = var5;
               return this.method2697(var1, var5);
            }
         }

         this.field2010.offset += var4;
         return 0;
      }
   }

   @ObfuscatedName("s")
   int method2697(int var1, int var2) {
      int var3;
      if(var2 == 255) {
         int var7 = this.field2010.readUnsignedByte();
         var3 = this.field2010.readVarInt();
         if(var7 == 47) {
            this.field2010.offset += var3;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2010.read24BitInt();
            var3 -= 3;
            int var6 = this.field1997[var1];
            this.field2001 += (long)var6 * (long)(this.field2003 - var5);
            this.field2003 = var5;
            this.field2010.offset += var3;
            return 2;
         } else {
            this.field2010.offset += var3;
            return 3;
         }
      } else {
         byte var4 = field2009[var2 - 128];
         var3 = var2;
         if(var4 >= 1) {
            var3 = var2 | this.field2010.readUnsignedByte() << 8;
         }

         if(var4 >= 2) {
            var3 |= this.field2010.readUnsignedByte() << 16;
         }

         return var3;
      }
   }

   @ObfuscatedName("q")
   long method2698(int var1) {
      return this.field2001 + (long)var1 * (long)this.field2003;
   }

   @ObfuscatedName("d")
   int method2699() {
      int var1 = this.field2000.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2000[var4] >= 0 && this.field1997[var4] < var3) {
            var2 = var4;
            var3 = this.field1997[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("y")
   void method2701(long var1) {
      this.field2001 = var1;
      int var3 = this.field2000.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field1997[var4] = 0;
         this.field2002[var4] = 0;
         this.field2010.offset = this.field1999[var4];
         this.method2694(var4);
         this.field2000[var4] = this.field2010.offset;
      }

   }

   @ObfuscatedName("p")
   boolean method2704() {
      int var1 = this.field2000.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2000[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   class141(byte[] var1) {
      this.method2687(var1);
   }

   class141() {
   }

   @ObfuscatedName("i")
   void method2714() {
      this.field2010.payload = null;
      this.field1999 = null;
      this.field2000 = null;
      this.field1997 = null;
      this.field2002 = null;
   }

   @ObfuscatedName("n")
   void method2721() {
      this.field2010.offset = -1;
   }

   @ObfuscatedName("r")
   int method2725() {
      return this.field2000.length;
   }

   @ObfuscatedName("o")
   void method2728(int var1) {
      this.field2010.offset = this.field2000[var1];
   }
}
