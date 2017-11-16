import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
public class class213 {
   @ObfuscatedName("n")
   static final byte[] field2653;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfs;"
   )
   Buffer field2647;
   @ObfuscatedName("s")
   int field2646;
   @ObfuscatedName("r")
   int[] field2652;
   @ObfuscatedName("g")
   int[] field2648;
   @ObfuscatedName("x")
   int[] field2654;
   @ObfuscatedName("f")
   int[] field2650;
   @ObfuscatedName("u")
   int field2651;
   @ObfuscatedName("k")
   long field2656;

   static {
      field2653 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class213(byte[] var1) {
      this.field2647 = new Buffer((byte[])null);
      this.method3862(var1);
   }

   class213() {
      this.field2647 = new Buffer((byte[])null);
   }

   @ObfuscatedName("b")
   void method3862(byte[] var1) {
      this.field2647.payload = var1;
      this.field2647.offset = 10;
      int var2 = this.field2647.readUnsignedShort();
      this.field2646 = this.field2647.readUnsignedShort();
      this.field2651 = 500000;
      this.field2652 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2647.offset += var5) {
         int var4 = this.field2647.readInt();
         var5 = this.field2647.readInt();
         if(var4 == 1297379947) {
            this.field2652[var3] = this.field2647.offset;
            ++var3;
         }
      }

      this.field2656 = 0L;
      this.field2648 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2648[var3] = this.field2652[var3];
      }

      this.field2654 = new int[var2];
      this.field2650 = new int[var2];
   }

   @ObfuscatedName("s")
   void method3873() {
      this.field2647.payload = null;
      this.field2652 = null;
      this.field2648 = null;
      this.field2654 = null;
      this.field2650 = null;
   }

   @ObfuscatedName("r")
   boolean method3864() {
      return this.field2647.payload != null;
   }

   @ObfuscatedName("g")
   int method3865() {
      return this.field2648.length;
   }

   @ObfuscatedName("x")
   void method3866(int var1) {
      this.field2647.offset = this.field2648[var1];
   }

   @ObfuscatedName("f")
   void method3867(int var1) {
      this.field2648[var1] = this.field2647.offset;
   }

   @ObfuscatedName("u")
   void method3892() {
      this.field2647.offset = -1;
   }

   @ObfuscatedName("t")
   void method3883(int var1) {
      int var2 = this.field2647.readVarInt();
      this.field2654[var1] += var2;
   }

   @ObfuscatedName("k")
   int method3861(int var1) {
      int var2 = this.method3871(var1);
      return var2;
   }

   @ObfuscatedName("n")
   int method3871(int var1) {
      byte var2 = this.field2647.payload[this.field2647.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2650[var1] = var5;
         ++this.field2647.offset;
      } else {
         var5 = this.field2650[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3872(var1, var5);
      } else {
         int var3 = this.field2647.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2647.payload[this.field2647.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2647.offset;
               this.field2650[var1] = var4;
               return this.method3872(var1, var4);
            }
         }

         this.field2647.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("d")
   int method3872(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2647.readUnsignedByte();
         var4 = this.field2647.readVarInt();
         if(var7 == 47) {
            this.field2647.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2647.read24BitInt();
            var4 -= 3;
            int var6 = this.field2654[var1];
            this.field2656 += (long)var6 * (long)(this.field2651 - var5);
            this.field2651 = var5;
            this.field2647.offset += var4;
            return 2;
         } else {
            this.field2647.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2653[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2647.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2647.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("o")
   long method3877(int var1) {
      return this.field2656 + (long)var1 * (long)this.field2651;
   }

   @ObfuscatedName("a")
   int method3874() {
      int var1 = this.field2648.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2648[var4] >= 0 && this.field2654[var4] < var3) {
            var2 = var4;
            var3 = this.field2654[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("q")
   boolean method3875() {
      int var1 = this.field2648.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2648[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("j")
   void method3876(long var1) {
      this.field2656 = var1;
      int var3 = this.field2648.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2654[var4] = 0;
         this.field2650[var4] = 0;
         this.field2647.offset = this.field2652[var4];
         this.method3883(var4);
         this.field2648[var4] = this.field2647.offset;
      }

   }
}
