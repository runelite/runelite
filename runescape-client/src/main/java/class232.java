import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
public class class232 {
   @ObfuscatedName("g")
   static final byte[] field2741;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   Buffer field2737;
   @ObfuscatedName("q")
   int field2734;
   @ObfuscatedName("i")
   int[] field2745;
   @ObfuscatedName("a")
   int[] field2735;
   @ObfuscatedName("l")
   int[] field2736;
   @ObfuscatedName("b")
   int[] field2732;
   @ObfuscatedName("e")
   int field2733;
   @ObfuscatedName("p")
   long field2740;

   static {
      field2741 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class232(byte[] var1) {
      this.field2737 = new Buffer((byte[])null);
      this.method4294(var1);
   }

   class232() {
      this.field2737 = new Buffer((byte[])null);
   }

   @ObfuscatedName("t")
   void method4294(byte[] var1) {
      this.field2737.payload = var1;
      this.field2737.offset = 10;
      int var2 = this.field2737.readUnsignedShort();
      this.field2734 = this.field2737.readUnsignedShort();
      this.field2733 = 500000;
      this.field2745 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2737.offset += var5) {
         int var4 = this.field2737.readInt();
         var5 = this.field2737.readInt();
         if(var4 == 1297379947) {
            this.field2745[var3] = this.field2737.offset;
            ++var3;
         }
      }

      this.field2740 = 0L;
      this.field2735 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2735[var3] = this.field2745[var3];
      }

      this.field2736 = new int[var2];
      this.field2732 = new int[var2];
   }

   @ObfuscatedName("q")
   void method4306() {
      this.field2737.payload = null;
      this.field2745 = null;
      this.field2735 = null;
      this.field2736 = null;
      this.field2732 = null;
   }

   @ObfuscatedName("i")
   boolean method4296() {
      return this.field2737.payload != null;
   }

   @ObfuscatedName("a")
   int method4324() {
      return this.field2735.length;
   }

   @ObfuscatedName("l")
   void method4298(int var1) {
      this.field2737.offset = this.field2735[var1];
   }

   @ObfuscatedName("b")
   void method4297(int var1) {
      this.field2735[var1] = this.field2737.offset;
   }

   @ObfuscatedName("e")
   void method4300() {
      this.field2737.offset = -1;
   }

   @ObfuscatedName("x")
   void method4301(int var1) {
      int var2 = this.field2737.readVarInt();
      this.field2736[var1] += var2;
   }

   @ObfuscatedName("p")
   int method4341(int var1) {
      int var2 = this.method4303(var1);
      return var2;
   }

   @ObfuscatedName("o")
   int method4303(int var1) {
      byte var2 = this.field2737.payload[this.field2737.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2732[var1] = var5;
         ++this.field2737.offset;
      } else {
         var5 = this.field2732[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method4336(var1, var5);
      } else {
         int var3 = this.field2737.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2737.payload[this.field2737.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2737.offset;
               this.field2732[var1] = var4;
               return this.method4336(var1, var4);
            }
         }

         this.field2737.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("c")
   int method4336(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2737.readUnsignedByte();
         var4 = this.field2737.readVarInt();
         if(var7 == 47) {
            this.field2737.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2737.read24BitInt();
            var4 -= 3;
            int var6 = this.field2736[var1];
            this.field2740 += (long)var6 * (long)(this.field2733 - var5);
            this.field2733 = var5;
            this.field2737.offset += var4;
            return 2;
         } else {
            this.field2737.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2741[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2737.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2737.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("u")
   long method4315(int var1) {
      return this.field2740 + (long)var1 * (long)this.field2733;
   }

   @ObfuscatedName("k")
   int method4304() {
      int var1 = this.field2735.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2735[var4] >= 0 && this.field2736[var4] < var3) {
            var2 = var4;
            var3 = this.field2736[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("z")
   boolean method4307() {
      int var1 = this.field2735.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2735[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("w")
   void method4308(long var1) {
      this.field2740 = var1;
      int var3 = this.field2735.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2736[var4] = 0;
         this.field2732[var4] = 0;
         this.field2737.offset = this.field2745[var4];
         this.method4301(var4);
         this.field2735[var4] = this.field2737.offset;
      }

   }
}
