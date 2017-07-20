import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class206 {
   @ObfuscatedName("k")
   static final byte[] field2532;
   @ObfuscatedName("p")
   long field2530;
   @ObfuscatedName("u")
   int[] field2535;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   Buffer field2539;
   @ObfuscatedName("s")
   int field2536;
   @ObfuscatedName("i")
   int[] field2540;
   @ObfuscatedName("g")
   int[] field2538;
   @ObfuscatedName("m")
   int[] field2534;
   @ObfuscatedName("o")
   int field2533;

   static {
      field2532 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class206(byte[] var1) {
      this.field2539 = new Buffer((byte[])null);
      this.method3764(var1);
   }

   class206() {
      this.field2539 = new Buffer((byte[])null);
   }

   @ObfuscatedName("k")
   int method3773(int var1) {
      byte var2 = this.field2539.payload[this.field2539.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2534[var1] = var5;
         ++this.field2539.offset;
      } else {
         var5 = this.field2534[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3774(var1, var5);
      } else {
         int var3 = this.field2539.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2539.payload[this.field2539.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2539.offset;
               this.field2534[var1] = var4;
               return this.method3774(var1, var4);
            }
         }

         this.field2539.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("o")
   void method3766() {
      this.field2539.payload = null;
      this.field2540 = null;
      this.field2535 = null;
      this.field2538 = null;
      this.field2534 = null;
   }

   @ObfuscatedName("i")
   boolean method3788() {
      return this.field2539.payload != null;
   }

   @ObfuscatedName("c")
   void method3764(byte[] var1) {
      this.field2539.payload = var1;
      this.field2539.offset = 10;
      int var2 = this.field2539.readUnsignedShort();
      this.field2533 = this.field2539.readUnsignedShort();
      this.field2536 = 500000;
      this.field2540 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2539.offset += var5) {
         int var4 = this.field2539.readInt();
         var5 = this.field2539.readInt();
         if(var4 == 1297379947) {
            this.field2540[var3] = this.field2539.offset;
            ++var3;
         }
      }

      this.field2530 = 0L;
      this.field2535 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2535[var3] = this.field2540[var3];
      }

      this.field2538 = new int[var2];
      this.field2534 = new int[var2];
   }

   @ObfuscatedName("v")
   int method3776() {
      int var1 = this.field2535.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2535[var4] >= 0 && this.field2538[var4] < var3) {
            var2 = var4;
            var3 = this.field2538[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("g")
   void method3798(int var1) {
      this.field2539.offset = this.field2535[var1];
   }

   @ObfuscatedName("u")
   int method3767() {
      return this.field2535.length;
   }

   @ObfuscatedName("p")
   int method3772(int var1) {
      int var2 = this.method3773(var1);
      return var2;
   }

   @ObfuscatedName("x")
   void method3771(int var1) {
      int var2 = this.field2539.readVarInt();
      this.field2538[var1] += var2;
   }

   @ObfuscatedName("r")
   int method3774(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2539.readUnsignedByte();
         var4 = this.field2539.readVarInt();
         if(var7 == 47) {
            this.field2539.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2539.read24BitInt();
            var4 -= 3;
            int var6 = this.field2538[var1];
            this.field2530 += (long)var6 * (long)(this.field2536 - var5);
            this.field2536 = var5;
            this.field2539.offset += var4;
            return 2;
         } else {
            this.field2539.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2532[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2539.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2539.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("w")
   long method3775(int var1) {
      return this.field2530 + (long)var1 * (long)this.field2536;
   }

   @ObfuscatedName("s")
   void method3770() {
      this.field2539.offset = -1;
   }

   @ObfuscatedName("m")
   void method3763(int var1) {
      this.field2535[var1] = this.field2539.offset;
   }

   @ObfuscatedName("h")
   boolean method3777() {
      int var1 = this.field2535.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2535[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("t")
   void method3778(long var1) {
      this.field2530 = var1;
      int var3 = this.field2535.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2538[var4] = 0;
         this.field2534[var4] = 0;
         this.field2539.offset = this.field2540[var4];
         this.method3771(var4);
         this.field2535[var4] = this.field2539.offset;
      }

   }
}
