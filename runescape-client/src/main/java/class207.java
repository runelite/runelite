import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class207 {
   @ObfuscatedName("b")
   static final byte[] field2564;
   @ObfuscatedName("w")
   long field2563;
   @ObfuscatedName("p")
   int[] field2574;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   Buffer field2567;
   @ObfuscatedName("c")
   int field2569;
   @ObfuscatedName("f")
   int[] field2565;
   @ObfuscatedName("x")
   int[] field2572;
   @ObfuscatedName("g")
   int[] field2568;
   @ObfuscatedName("h")
   int field2576;

   static {
      field2564 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class207(byte[] var1) {
      this.field2567 = new Buffer((byte[])null);
      this.method3820(var1);
   }

   class207() {
      this.field2567 = new Buffer((byte[])null);
   }

   @ObfuscatedName("b")
   int method3828(int var1) {
      byte var2 = this.field2567.payload[this.field2567.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2568[var1] = var5;
         ++this.field2567.offset;
      } else {
         var5 = this.field2568[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3827(var1, var5);
      } else {
         int var3 = this.field2567.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2567.payload[this.field2567.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2567.offset;
               this.field2568[var1] = var4;
               return this.method3827(var1, var4);
            }
         }

         this.field2567.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("h")
   void method3826() {
      this.field2567.payload = null;
      this.field2565 = null;
      this.field2574 = null;
      this.field2572 = null;
      this.field2568 = null;
   }

   @ObfuscatedName("f")
   boolean method3854() {
      return this.field2567.payload != null;
   }

   @ObfuscatedName("j")
   void method3820(byte[] var1) {
      this.field2567.payload = var1;
      this.field2567.offset = 10;
      int var2 = this.field2567.readUnsignedShort();
      this.field2576 = this.field2567.readUnsignedShort();
      this.field2569 = 500000;
      this.field2565 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2567.offset += var5) {
         int var4 = this.field2567.readInt();
         var5 = this.field2567.readInt();
         if(var4 == 1297379947) {
            this.field2565[var3] = this.field2567.offset;
            ++var3;
         }
      }

      this.field2563 = 0L;
      this.field2574 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2574[var3] = this.field2565[var3];
      }

      this.field2572 = new int[var2];
      this.field2568 = new int[var2];
   }

   @ObfuscatedName("x")
   void method3824(int var1) {
      this.field2567.offset = this.field2574[var1];
   }

   @ObfuscatedName("e")
   int method3831() {
      int var1 = this.field2574.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2574[var4] >= 0 && this.field2572[var4] < var3) {
            var2 = var4;
            var3 = this.field2572[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("p")
   int method3851() {
      return this.field2574.length;
   }

   @ObfuscatedName("w")
   int method3869(int var1) {
      int var2 = this.method3828(var1);
      return var2;
   }

   @ObfuscatedName("l")
   void method3822(int var1) {
      int var2 = this.field2567.readVarInt();
      this.field2572[var1] += var2;
   }

   @ObfuscatedName("o")
   int method3827(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2567.readUnsignedByte();
         var4 = this.field2567.readVarInt();
         if(var7 == 47) {
            this.field2567.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2567.read24BitInt();
            var4 -= 3;
            int var6 = this.field2572[var1];
            this.field2563 += (long)var6 * (long)(this.field2569 - var5);
            this.field2569 = var5;
            this.field2567.offset += var4;
            return 2;
         } else {
            this.field2567.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2564[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2567.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2567.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("m")
   long method3830(int var1) {
      return this.field2563 + (long)var1 * (long)this.field2569;
   }

   @ObfuscatedName("c")
   void method3847() {
      this.field2567.offset = -1;
   }

   @ObfuscatedName("g")
   void method3825(int var1) {
      this.field2574[var1] = this.field2567.offset;
   }

   @ObfuscatedName("a")
   boolean method3841() {
      int var1 = this.field2574.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2574[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("v")
   void method3833(long var1) {
      this.field2563 = var1;
      int var3 = this.field2574.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2572[var4] = 0;
         this.field2568[var4] = 0;
         this.field2567.offset = this.field2565[var4];
         this.method3822(var4);
         this.field2574[var4] = this.field2567.offset;
      }

   }
}
