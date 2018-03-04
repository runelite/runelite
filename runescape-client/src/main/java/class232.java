import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class232 {
   @ObfuscatedName("x")
   static final byte[] field2754;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   Buffer field2748;
   @ObfuscatedName("z")
   int field2745;
   @ObfuscatedName("n")
   int[] field2747;
   @ObfuscatedName("r")
   int[] field2751;
   @ObfuscatedName("e")
   int[] field2749;
   @ObfuscatedName("y")
   int[] field2750;
   @ObfuscatedName("k")
   int field2752;
   @ObfuscatedName("p")
   long field2753;

   static {
      field2754 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class232(byte[] var1) {
      this.field2748 = new Buffer((byte[])null);
      this.method4374(var1);
   }

   class232() {
      this.field2748 = new Buffer((byte[])null);
   }

   @ObfuscatedName("d")
   void method4374(byte[] var1) {
      this.field2748.payload = var1;
      this.field2748.offset = 10;
      int var2 = this.field2748.readUnsignedShort();
      this.field2745 = this.field2748.readUnsignedShort();
      this.field2752 = 500000;
      this.field2747 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2748.offset += var5) {
         int var4 = this.field2748.readInt();
         var5 = this.field2748.readInt();
         if(var4 == 1297379947) {
            this.field2747[var3] = this.field2748.offset;
            ++var3;
         }
      }

      this.field2753 = 0L;
      this.field2751 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2751[var3] = this.field2747[var3];
      }

      this.field2749 = new int[var2];
      this.field2750 = new int[var2];
   }

   @ObfuscatedName("z")
   void method4375() {
      this.field2748.payload = null;
      this.field2747 = null;
      this.field2751 = null;
      this.field2749 = null;
      this.field2750 = null;
   }

   @ObfuscatedName("n")
   boolean method4376() {
      return this.field2748.payload != null;
   }

   @ObfuscatedName("r")
   int method4377() {
      return this.field2751.length;
   }

   @ObfuscatedName("e")
   void method4378(int var1) {
      this.field2748.offset = this.field2751[var1];
   }

   @ObfuscatedName("y")
   void method4379(int var1) {
      this.field2751[var1] = this.field2748.offset;
   }

   @ObfuscatedName("k")
   void method4380() {
      this.field2748.offset = -1;
   }

   @ObfuscatedName("s")
   void method4399(int var1) {
      int var2 = this.field2748.readVarInt();
      this.field2749[var1] += var2;
   }

   @ObfuscatedName("x")
   int method4382(int var1) {
      int var2 = this.method4383(var1);
      return var2;
   }

   @ObfuscatedName("h")
   int method4383(int var1) {
      byte var2 = this.field2748.payload[this.field2748.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2750[var1] = var5;
         ++this.field2748.offset;
      } else {
         var5 = this.field2750[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method4422(var1, var5);
      } else {
         int var3 = this.field2748.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2748.payload[this.field2748.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2748.offset;
               this.field2750[var1] = var4;
               return this.method4422(var1, var4);
            }
         }

         this.field2748.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("t")
   int method4422(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2748.readUnsignedByte();
         var4 = this.field2748.readVarInt();
         if(var7 == 47) {
            this.field2748.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2748.read24BitInt();
            var4 -= 3;
            int var6 = this.field2749[var1];
            this.field2753 += (long)var6 * (long)(this.field2752 - var5);
            this.field2752 = var5;
            this.field2748.offset += var4;
            return 2;
         } else {
            this.field2748.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2754[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2748.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2748.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("i")
   long method4385(int var1) {
      return this.field2753 + (long)var1 * (long)this.field2752;
   }

   @ObfuscatedName("u")
   int method4386() {
      int var1 = this.field2751.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2751[var4] >= 0 && this.field2749[var4] < var3) {
            var2 = var4;
            var3 = this.field2749[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("q")
   boolean method4387() {
      int var1 = this.field2751.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2751[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("v")
   void method4403(long var1) {
      this.field2753 = var1;
      int var3 = this.field2751.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2749[var4] = 0;
         this.field2750[var4] = 0;
         this.field2748.offset = this.field2747[var4];
         this.method4399(var4);
         this.field2751[var4] = this.field2748.offset;
      }

   }
}
