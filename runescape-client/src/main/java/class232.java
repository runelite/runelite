import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class232 {
   @ObfuscatedName("r")
   static final byte[] field2742;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   Buffer field2743;
   @ObfuscatedName("i")
   int field2736;
   @ObfuscatedName("o")
   int[] field2737;
   @ObfuscatedName("j")
   int[] field2738;
   @ObfuscatedName("k")
   int[] field2739;
   @ObfuscatedName("x")
   int[] field2735;
   @ObfuscatedName("z")
   int field2741;
   @ObfuscatedName("w")
   long field2744;

   static {
      field2742 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class232(byte[] var1) {
      this.field2743 = new Buffer((byte[])null);
      this.method4264(var1);
   }

   class232() {
      this.field2743 = new Buffer((byte[])null);
   }

   @ObfuscatedName("c")
   void method4264(byte[] var1) {
      this.field2743.payload = var1;
      this.field2743.offset = 10;
      int var2 = this.field2743.readUnsignedShort();
      this.field2736 = this.field2743.readUnsignedShort();
      this.field2741 = 500000;
      this.field2737 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2743.offset += var5) {
         int var4 = this.field2743.readInt();
         var5 = this.field2743.readInt();
         if(var4 == 1297379947) {
            this.field2737[var3] = this.field2743.offset;
            ++var3;
         }
      }

      this.field2744 = 0L;
      this.field2738 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2738[var3] = this.field2737[var3];
      }

      this.field2739 = new int[var2];
      this.field2735 = new int[var2];
   }

   @ObfuscatedName("i")
   void method4265() {
      this.field2743.payload = null;
      this.field2737 = null;
      this.field2738 = null;
      this.field2739 = null;
      this.field2735 = null;
   }

   @ObfuscatedName("o")
   boolean method4266() {
      return this.field2743.payload != null;
   }

   @ObfuscatedName("j")
   int method4278() {
      return this.field2738.length;
   }

   @ObfuscatedName("k")
   void method4268(int var1) {
      this.field2743.offset = this.field2738[var1];
   }

   @ObfuscatedName("x")
   void method4269(int var1) {
      this.field2738[var1] = this.field2743.offset;
   }

   @ObfuscatedName("z")
   void method4270() {
      this.field2743.offset = -1;
   }

   @ObfuscatedName("p")
   void method4271(int var1) {
      int var2 = this.field2743.readVarInt();
      this.field2739[var1] += var2;
   }

   @ObfuscatedName("w")
   int method4293(int var1) {
      int var2 = this.method4298(var1);
      return var2;
   }

   @ObfuscatedName("r")
   int method4298(int var1) {
      byte var2 = this.field2743.payload[this.field2743.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2735[var1] = var5;
         ++this.field2743.offset;
      } else {
         var5 = this.field2735[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method4304(var1, var5);
      } else {
         int var3 = this.field2743.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2743.payload[this.field2743.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2743.offset;
               this.field2735[var1] = var4;
               return this.method4304(var1, var4);
            }
         }

         this.field2743.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("d")
   int method4304(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2743.readUnsignedByte();
         var4 = this.field2743.readVarInt();
         if(var7 == 47) {
            this.field2743.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2743.read24BitInt();
            var4 -= 3;
            int var6 = this.field2739[var1];
            this.field2744 += (long)var6 * (long)(this.field2741 - var5);
            this.field2741 = var5;
            this.field2743.offset += var4;
            return 2;
         } else {
            this.field2743.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2742[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2743.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2743.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("a")
   long method4275(int var1) {
      return this.field2744 + (long)var1 * (long)this.field2741;
   }

   @ObfuscatedName("b")
   int method4267() {
      int var1 = this.field2738.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2738[var4] >= 0 && this.field2739[var4] < var3) {
            var2 = var4;
            var3 = this.field2739[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("h")
   boolean method4277() {
      int var1 = this.field2738.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2738[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("n")
   void method4280(long var1) {
      this.field2744 = var1;
      int var3 = this.field2738.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2739[var4] = 0;
         this.field2735[var4] = 0;
         this.field2743.offset = this.field2737[var4];
         this.method4271(var4);
         this.field2738[var4] = this.field2743.offset;
      }

   }
}
