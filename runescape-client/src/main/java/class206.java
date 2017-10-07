import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class206 {
   @ObfuscatedName("t")
   static final byte[] field2587;
   @ObfuscatedName("v")
   long field2583;
   @ObfuscatedName("p")
   int[] field2581;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfg;"
   )
   Buffer field2588;
   @ObfuscatedName("r")
   int field2584;
   @ObfuscatedName("e")
   int[] field2580;
   @ObfuscatedName("q")
   int[] field2586;
   @ObfuscatedName("k")
   int field2579;
   @ObfuscatedName("s")
   int[] field2591;

   static {
      field2587 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class206(byte[] var1) {
      this.field2588 = new Buffer((byte[])null);
      this.method3968(var1);
   }

   class206() {
      this.field2588 = new Buffer((byte[])null);
   }

   @ObfuscatedName("t")
   int method3975(int var1) {
      byte var2 = this.field2588.payload[this.field2588.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2591[var1] = var5;
         ++this.field2588.offset;
      } else {
         var5 = this.field2591[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3943(var1, var5);
      } else {
         int var3 = this.field2588.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2588.payload[this.field2588.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2588.offset;
               this.field2591[var1] = var4;
               return this.method3943(var1, var4);
            }
         }

         this.field2588.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("k")
   void method3934() {
      this.field2588.payload = null;
      this.field2580 = null;
      this.field2581 = null;
      this.field2586 = null;
      this.field2591 = null;
   }

   @ObfuscatedName("e")
   boolean method3949() {
      return this.field2588.payload != null;
   }

   @ObfuscatedName("d")
   void method3968(byte[] var1) {
      this.field2588.payload = var1;
      this.field2588.offset = 10;
      int var2 = this.field2588.readUnsignedShort();
      this.field2579 = this.field2588.readUnsignedShort();
      this.field2584 = 500000;
      this.field2580 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2588.offset += var5) {
         int var4 = this.field2588.readInt();
         var5 = this.field2588.readInt();
         if(var4 == 1297379947) {
            this.field2580[var3] = this.field2588.offset;
            ++var3;
         }
      }

      this.field2583 = 0L;
      this.field2581 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2581[var3] = this.field2580[var3];
      }

      this.field2586 = new int[var2];
      this.field2591 = new int[var2];
   }

   @ObfuscatedName("q")
   void method3971(int var1) {
      this.field2588.offset = this.field2581[var1];
   }

   @ObfuscatedName("i")
   int method3945() {
      int var1 = this.field2581.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2581[var4] >= 0 && this.field2586[var4] < var3) {
            var2 = var4;
            var3 = this.field2586[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("p")
   int method3948() {
      return this.field2581.length;
   }

   @ObfuscatedName("v")
   int method3941(int var1) {
      int var2 = this.method3975(var1);
      return var2;
   }

   @ObfuscatedName("g")
   void method3961(int var1) {
      int var2 = this.field2588.readVarInt();
      this.field2586[var1] += var2;
   }

   @ObfuscatedName("y")
   int method3943(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2588.readUnsignedByte();
         var4 = this.field2588.readVarInt();
         if(var7 == 47) {
            this.field2588.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2588.read24BitInt();
            var4 -= 3;
            int var6 = this.field2586[var1];
            this.field2583 += (long)var6 * (long)(this.field2584 - var5);
            this.field2584 = var5;
            this.field2588.offset += var4;
            return 2;
         } else {
            this.field2588.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2587[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2588.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2588.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("r")
   void method3939() {
      this.field2588.offset = -1;
   }

   @ObfuscatedName("s")
   void method3938(int var1) {
      this.field2581[var1] = this.field2588.offset;
   }

   @ObfuscatedName("u")
   boolean method3946() {
      int var1 = this.field2581.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2581[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("o")
   long method3944(int var1) {
      return this.field2583 + (long)var1 * (long)this.field2584;
   }

   @ObfuscatedName("x")
   void method3947(long var1) {
      this.field2583 = var1;
      int var3 = this.field2581.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2586[var4] = 0;
         this.field2591[var4] = 0;
         this.field2588.offset = this.field2580[var4];
         this.method3961(var4);
         this.field2581[var4] = this.field2588.offset;
      }

   }
}
