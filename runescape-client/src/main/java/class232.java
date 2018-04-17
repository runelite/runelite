import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class232 {
   @ObfuscatedName("x")
   static final byte[] field2751;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   Buffer field2754;
   @ObfuscatedName("k")
   int field2743;
   @ObfuscatedName("t")
   int[] field2744;
   @ObfuscatedName("d")
   int[] field2745;
   @ObfuscatedName("h")
   int[] field2753;
   @ObfuscatedName("m")
   int[] field2742;
   @ObfuscatedName("z")
   int field2747;
   @ObfuscatedName("u")
   long field2750;

   static {
      field2751 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class232(byte[] var1) {
      this.field2754 = new Buffer((byte[])null);
      this.method4298(var1);
   }

   class232() {
      this.field2754 = new Buffer((byte[])null);
   }

   @ObfuscatedName("o")
   void method4298(byte[] var1) {
      this.field2754.payload = var1;
      this.field2754.offset = 10;
      int var2 = this.field2754.readUnsignedShort();
      this.field2743 = this.field2754.readUnsignedShort();
      this.field2747 = 500000;
      this.field2744 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2754.offset += var5) {
         int var4 = this.field2754.readInt();
         var5 = this.field2754.readInt();
         if(var4 == 1297379947) {
            this.field2744[var3] = this.field2754.offset;
            ++var3;
         }
      }

      this.field2750 = 0L;
      this.field2745 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2745[var3] = this.field2744[var3];
      }

      this.field2753 = new int[var2];
      this.field2742 = new int[var2];
   }

   @ObfuscatedName("k")
   void method4268() {
      this.field2754.payload = null;
      this.field2744 = null;
      this.field2745 = null;
      this.field2753 = null;
      this.field2742 = null;
   }

   @ObfuscatedName("t")
   boolean method4269() {
      return this.field2754.payload != null;
   }

   @ObfuscatedName("d")
   int method4270() {
      return this.field2745.length;
   }

   @ObfuscatedName("h")
   void method4271(int var1) {
      this.field2754.offset = this.field2745[var1];
   }

   @ObfuscatedName("m")
   void method4272(int var1) {
      this.field2745[var1] = this.field2754.offset;
   }

   @ObfuscatedName("z")
   void method4273() {
      this.field2754.offset = -1;
   }

   @ObfuscatedName("i")
   void method4274(int var1) {
      int var2 = this.field2754.readVarInt();
      this.field2753[var1] += var2;
   }

   @ObfuscatedName("u")
   int method4275(int var1) {
      int var2 = this.method4276(var1);
      return var2;
   }

   @ObfuscatedName("x")
   int method4276(int var1) {
      byte var2 = this.field2754.payload[this.field2754.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2742[var1] = var5;
         ++this.field2754.offset;
      } else {
         var5 = this.field2742[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method4281(var1, var5);
      } else {
         int var3 = this.field2754.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2754.payload[this.field2754.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2754.offset;
               this.field2742[var1] = var4;
               return this.method4281(var1, var4);
            }
         }

         this.field2754.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("y")
   int method4281(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2754.readUnsignedByte();
         var4 = this.field2754.readVarInt();
         if(var7 == 47) {
            this.field2754.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2754.read24BitInt();
            var4 -= 3;
            int var6 = this.field2753[var1];
            this.field2750 += (long)var6 * (long)(this.field2747 - var5);
            this.field2747 = var5;
            this.field2754.offset += var4;
            return 2;
         } else {
            this.field2754.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2751[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2754.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2754.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("a")
   long method4296(int var1) {
      return this.field2750 + (long)var1 * (long)this.field2747;
   }

   @ObfuscatedName("v")
   int method4279() {
      int var1 = this.field2745.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2745[var4] >= 0 && this.field2753[var4] < var3) {
            var2 = var4;
            var3 = this.field2753[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("q")
   boolean method4280() {
      int var1 = this.field2745.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2745[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("r")
   void method4285(long var1) {
      this.field2750 = var1;
      int var3 = this.field2745.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2753[var4] = 0;
         this.field2742[var4] = 0;
         this.field2754.offset = this.field2744[var4];
         this.method4274(var4);
         this.field2745[var4] = this.field2754.offset;
      }

   }
}
