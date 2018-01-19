import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public class class217 {
   @ObfuscatedName("f")
   static final byte[] field2687;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   Buffer field2689;
   @ObfuscatedName("v")
   int field2688;
   @ObfuscatedName("y")
   int[] field2694;
   @ObfuscatedName("r")
   int[] field2690;
   @ObfuscatedName("h")
   int[] field2691;
   @ObfuscatedName("d")
   int[] field2692;
   @ObfuscatedName("s")
   int field2693;
   @ObfuscatedName("e")
   long field2695;

   static {
      field2687 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class217(byte[] var1) {
      this.field2689 = new Buffer((byte[])null);
      this.method4031(var1);
   }

   class217() {
      this.field2689 = new Buffer((byte[])null);
   }

   @ObfuscatedName("n")
   void method4031(byte[] var1) {
      this.field2689.payload = var1;
      this.field2689.offset = 10;
      int var2 = this.field2689.readUnsignedShort();
      this.field2688 = this.field2689.readUnsignedShort();
      this.field2693 = 500000;
      this.field2694 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2689.offset += var5) {
         int var4 = this.field2689.readInt();
         var5 = this.field2689.readInt();
         if(var4 == 1297379947) {
            this.field2694[var3] = this.field2689.offset;
            ++var3;
         }
      }

      this.field2695 = 0L;
      this.field2690 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2690[var3] = this.field2694[var3];
      }

      this.field2691 = new int[var2];
      this.field2692 = new int[var2];
   }

   @ObfuscatedName("v")
   void method4032() {
      this.field2689.payload = null;
      this.field2694 = null;
      this.field2690 = null;
      this.field2691 = null;
      this.field2692 = null;
   }

   @ObfuscatedName("y")
   boolean method4033() {
      return this.field2689.payload != null;
   }

   @ObfuscatedName("r")
   int method4034() {
      return this.field2690.length;
   }

   @ObfuscatedName("h")
   void method4054(int var1) {
      this.field2689.offset = this.field2690[var1];
   }

   @ObfuscatedName("d")
   void method4036(int var1) {
      this.field2690[var1] = this.field2689.offset;
   }

   @ObfuscatedName("s")
   void method4040() {
      this.field2689.offset = -1;
   }

   @ObfuscatedName("b")
   void method4038(int var1) {
      int var2 = this.field2689.readVarInt();
      this.field2691[var1] += var2;
   }

   @ObfuscatedName("e")
   int method4039(int var1) {
      int var2 = this.method4048(var1);
      return var2;
   }

   @ObfuscatedName("f")
   int method4048(int var1) {
      byte var2 = this.field2689.payload[this.field2689.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2692[var1] = var5;
         ++this.field2689.offset;
      } else {
         var5 = this.field2692[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method4041(var1, var5);
      } else {
         int var3 = this.field2689.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2689.payload[this.field2689.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2689.offset;
               this.field2692[var1] = var4;
               return this.method4041(var1, var4);
            }
         }

         this.field2689.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("u")
   int method4041(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2689.readUnsignedByte();
         var4 = this.field2689.readVarInt();
         if(var7 == 47) {
            this.field2689.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2689.read24BitInt();
            var4 -= 3;
            int var6 = this.field2691[var1];
            this.field2695 += (long)var6 * (long)(this.field2693 - var5);
            this.field2693 = var5;
            this.field2689.offset += var4;
            return 2;
         } else {
            this.field2689.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2687[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2689.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2689.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("t")
   long method4042(int var1) {
      return this.field2695 + (long)var1 * (long)this.field2693;
   }

   @ObfuscatedName("o")
   int method4061() {
      int var1 = this.field2690.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2690[var4] >= 0 && this.field2691[var4] < var3) {
            var2 = var4;
            var3 = this.field2691[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("a")
   boolean method4044() {
      int var1 = this.field2690.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2690[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("i")
   void method4045(long var1) {
      this.field2695 = var1;
      int var3 = this.field2690.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2691[var4] = 0;
         this.field2692[var4] = 0;
         this.field2689.offset = this.field2694[var4];
         this.method4038(var4);
         this.field2690[var4] = this.field2689.offset;
      }

   }
}
