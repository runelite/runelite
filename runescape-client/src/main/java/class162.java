import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fa")
public class class162 {
   @ObfuscatedName("u")
   int field2127;
   @ObfuscatedName("n")
   int[] field2129;
   @ObfuscatedName("q")
   int[] field2130;
   @ObfuscatedName("c")
   int field2131;
   @ObfuscatedName("p")
   int[] field2132;
   @ObfuscatedName("v")
   static final byte[] field2133;
   @ObfuscatedName("l")
   long field2135;
   @ObfuscatedName("t")
   int[] field2136;
   @ObfuscatedName("d")
   Buffer field2140;

   class162(byte[] var1) {
      this.field2140 = new Buffer((byte[])null);
      this.method3055(var1);
   }

   class162() {
      this.field2140 = new Buffer((byte[])null);
   }

   @ObfuscatedName("q")
   int method3031() {
      return this.field2130.length;
   }

   @ObfuscatedName("t")
   void method3033(int var1) {
      this.field2140.offset = this.field2130[var1];
   }

   @ObfuscatedName("p")
   void method3034(int var1) {
      this.field2130[var1] = this.field2140.offset;
   }

   @ObfuscatedName("u")
   void method3035() {
      this.field2140.offset = -1;
   }

   @ObfuscatedName("w")
   void method3036(int var1) {
      int var2 = this.field2140.readVarInt();
      this.field2136[var1] += var2;
   }

   @ObfuscatedName("r")
   int method3037(int var1) {
      int var2 = this.method3038(var1);
      return var2;
   }

   @ObfuscatedName("s")
   int method3038(int var1) {
      byte var2 = this.field2140.payload[this.field2140.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2132[var1] = var5;
         ++this.field2140.offset;
      } else {
         var5 = this.field2132[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3041(var1, var5);
      } else {
         int var3 = this.field2140.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2140.payload[this.field2140.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2140.offset;
               this.field2132[var1] = var4;
               return this.method3041(var1, var4);
            }
         }

         this.field2140.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("e")
   long method3040(int var1) {
      return this.field2135 + (long)var1 * (long)this.field2127;
   }

   @ObfuscatedName("k")
   int method3041(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2140.readUnsignedByte();
         var4 = this.field2140.readVarInt();
         if(var7 == 47) {
            this.field2140.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2140.read24BitInt();
            var4 -= 3;
            int var6 = this.field2136[var1];
            this.field2135 += (long)var6 * (long)(this.field2127 - var5);
            this.field2127 = var5;
            this.field2140.offset += var4;
            return 2;
         } else {
            this.field2140.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2133[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2140.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2140.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("a")
   void method3043(long var1) {
      this.field2135 = var1;
      int var3 = this.field2130.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2136[var4] = 0;
         this.field2132[var4] = 0;
         this.field2140.offset = this.field2129[var4];
         this.method3036(var4);
         this.field2130[var4] = this.field2140.offset;
      }

   }

   static {
      field2133 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   @ObfuscatedName("j")
   int method3049() {
      int var1 = this.field2130.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2130[var4] >= 0 && this.field2136[var4] < var3) {
            var2 = var4;
            var3 = this.field2136[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("n")
   boolean method3051() {
      return this.field2140.payload != null;
   }

   @ObfuscatedName("d")
   void method3055(byte[] var1) {
      this.field2140.payload = var1;
      this.field2140.offset = 10;
      int var2 = this.field2140.readUnsignedShort();
      this.field2131 = this.field2140.readUnsignedShort();
      this.field2127 = 500000;
      this.field2129 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2140.offset += var5) {
         int var4 = this.field2140.readInt();
         var5 = this.field2140.readInt();
         if(var4 == 1297379947) {
            this.field2129[var3] = this.field2140.offset;
            ++var3;
         }
      }

      this.field2135 = 0L;
      this.field2130 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2130[var3] = this.field2129[var3];
      }

      this.field2136 = new int[var2];
      this.field2132 = new int[var2];
   }

   @ObfuscatedName("i")
   boolean method3064() {
      int var1 = this.field2130.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2130[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("c")
   void method3069() {
      this.field2140.payload = null;
      this.field2129 = null;
      this.field2130 = null;
      this.field2136 = null;
      this.field2132 = null;
   }
}
