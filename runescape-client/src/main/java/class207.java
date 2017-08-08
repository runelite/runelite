import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
public class class207 {
   @ObfuscatedName("u")
   static final byte[] field2554;
   @ObfuscatedName("r")
   long field2556;
   @ObfuscatedName("y")
   int[] field2547;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   Buffer field2557;
   @ObfuscatedName("v")
   int field2553;
   @ObfuscatedName("g")
   int[] field2549;
   @ObfuscatedName("w")
   int[] field2552;
   @ObfuscatedName("k")
   int[] field2550;
   @ObfuscatedName("n")
   int field2548;

   static {
      field2554 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class207(byte[] var1) {
      this.field2557 = new Buffer((byte[])null);
      this.method3820(var1);
   }

   class207() {
      this.field2557 = new Buffer((byte[])null);
   }

   @ObfuscatedName("u")
   int method3844(int var1) {
      byte var2 = this.field2557.payload[this.field2557.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2550[var1] = var5;
         ++this.field2557.offset;
      } else {
         var5 = this.field2550[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3827(var1, var5);
      } else {
         int var3 = this.field2557.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2557.payload[this.field2557.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2557.offset;
               this.field2550[var1] = var4;
               return this.method3827(var1, var4);
            }
         }

         this.field2557.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("n")
   void method3829() {
      this.field2557.payload = null;
      this.field2549 = null;
      this.field2547 = null;
      this.field2552 = null;
      this.field2550 = null;
   }

   @ObfuscatedName("g")
   boolean method3822() {
      return this.field2557.payload != null;
   }

   @ObfuscatedName("e")
   void method3820(byte[] var1) {
      this.field2557.payload = var1;
      this.field2557.offset = 10;
      int var2 = this.field2557.readUnsignedShort();
      this.field2548 = this.field2557.readUnsignedShort();
      this.field2553 = 500000;
      this.field2549 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2557.offset += var5) {
         int var4 = this.field2557.readInt();
         var5 = this.field2557.readInt();
         if(var4 == 1297379947) {
            this.field2549[var3] = this.field2557.offset;
            ++var3;
         }
      }

      this.field2556 = 0L;
      this.field2547 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2547[var3] = this.field2549[var3];
      }

      this.field2552 = new int[var2];
      this.field2550 = new int[var2];
   }

   @ObfuscatedName("w")
   void method3824(int var1) {
      this.field2557.offset = this.field2547[var1];
   }

   @ObfuscatedName("s")
   int method3832() {
      int var1 = this.field2547.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2547[var4] >= 0 && this.field2552[var4] < var3) {
            var2 = var4;
            var3 = this.field2552[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("y")
   int method3823() {
      return this.field2547.length;
   }

   @ObfuscatedName("r")
   int method3828(int var1) {
      int var2 = this.method3844(var1);
      return var2;
   }

   @ObfuscatedName("z")
   void method3830(int var1) {
      int var2 = this.field2557.readVarInt();
      this.field2552[var1] += var2;
   }

   @ObfuscatedName("d")
   int method3827(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2557.readUnsignedByte();
         var4 = this.field2557.readVarInt();
         if(var7 == 47) {
            this.field2557.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2557.read24BitInt();
            var4 -= 3;
            int var6 = this.field2552[var1];
            this.field2556 += (long)var6 * (long)(this.field2553 - var5);
            this.field2553 = var5;
            this.field2557.offset += var4;
            return 2;
         } else {
            this.field2557.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2554[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2557.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2557.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("v")
   void method3826() {
      this.field2557.offset = -1;
   }

   @ObfuscatedName("k")
   void method3839(int var1) {
      this.field2547[var1] = this.field2557.offset;
   }

   @ObfuscatedName("c")
   boolean method3833() {
      int var1 = this.field2547.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2547[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("o")
   long method3831(int var1) {
      return this.field2556 + (long)var1 * (long)this.field2553;
   }

   @ObfuscatedName("m")
   void method3834(long var1) {
      this.field2556 = var1;
      int var3 = this.field2547.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2552[var4] = 0;
         this.field2550[var4] = 0;
         this.field2557.offset = this.field2549[var4];
         this.method3830(var4);
         this.field2547[var4] = this.field2557.offset;
      }

   }
}
