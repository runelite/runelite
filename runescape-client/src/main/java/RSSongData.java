import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
@Implements("RSSongData")
public class RSSongData {
   @ObfuscatedName("j")
   static final byte[] field2690;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgh;"
   )
   Buffer field2684;
   @ObfuscatedName("w")
   int field2682;
   @ObfuscatedName("e")
   int[] field2693;
   @ObfuscatedName("k")
   int[] field2686;
   @ObfuscatedName("u")
   int[] field2685;
   @ObfuscatedName("z")
   int[] field2691;
   @ObfuscatedName("t")
   int field2687;
   @ObfuscatedName("g")
   long field2689;

   static {
      field2690 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   RSSongData(byte[] var1) {
      this.field2684 = new Buffer((byte[])null);
      this.method3977(var1);
   }

   RSSongData() {
      this.field2684 = new Buffer((byte[])null);
   }

   @ObfuscatedName("a")
   void method3977(byte[] var1) {
      this.field2684.payload = var1;
      this.field2684.offset = 10;
      int var2 = this.field2684.readUnsignedShort();
      this.field2682 = this.field2684.readUnsignedShort();
      this.field2687 = 500000;
      this.field2693 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2684.offset += var5) {
         int var4 = this.field2684.readInt();
         var5 = this.field2684.readInt();
         if(var4 == 1297379947) {
            this.field2693[var3] = this.field2684.offset;
            ++var3;
         }
      }

      this.field2689 = 0L;
      this.field2686 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2686[var3] = this.field2693[var3];
      }

      this.field2685 = new int[var2];
      this.field2691 = new int[var2];
   }

   @ObfuscatedName("w")
   void method3978() {
      this.field2684.payload = null;
      this.field2693 = null;
      this.field2686 = null;
      this.field2685 = null;
      this.field2691 = null;
   }

   @ObfuscatedName("e")
   boolean method3979() {
      return this.field2684.payload != null;
   }

   @ObfuscatedName("k")
   int method4010() {
      return this.field2686.length;
   }

   @ObfuscatedName("u")
   void method4013(int var1) {
      this.field2684.offset = this.field2686[var1];
   }

   @ObfuscatedName("z")
   void method4022(int var1) {
      this.field2686[var1] = this.field2684.offset;
   }

   @ObfuscatedName("t")
   void method3983() {
      this.field2684.offset = -1;
   }

   @ObfuscatedName("f")
   void method4019(int var1) {
      int var2 = this.field2684.readVarInt();
      this.field2685[var1] += var2;
   }

   @ObfuscatedName("g")
   int method4016(int var1) {
      int var2 = this.method3986(var1);
      return var2;
   }

   @ObfuscatedName("x")
   int method3986(int var1) {
      byte var2 = this.field2684.payload[this.field2684.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2691[var1] = var5;
         ++this.field2684.offset;
      } else {
         var5 = this.field2691[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method4004(var1, var5);
      } else {
         int var3 = this.field2684.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2684.payload[this.field2684.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2684.offset;
               this.field2691[var1] = var4;
               return this.method4004(var1, var4);
            }
         }

         this.field2684.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("c")
   int method4004(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2684.readUnsignedByte();
         var4 = this.field2684.readVarInt();
         if(var7 == 47) {
            this.field2684.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2684.read24BitInt();
            var4 -= 3;
            int var6 = this.field2685[var1];
            this.field2689 += (long)var6 * (long)(this.field2687 - var5);
            this.field2687 = var5;
            this.field2684.offset += var4;
            return 2;
         } else {
            this.field2684.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2690[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2684.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2684.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("n")
   long method3988(int var1) {
      return this.field2689 + (long)var1 * (long)this.field2687;
   }

   @ObfuscatedName("y")
   int method3993() {
      int var1 = this.field2686.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2686[var4] >= 0 && this.field2685[var4] < var3) {
            var2 = var4;
            var3 = this.field2685[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("o")
   boolean method3987() {
      int var1 = this.field2686.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2686[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("r")
   void method3991(long var1) {
      this.field2689 = var1;
      int var3 = this.field2686.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2685[var4] = 0;
         this.field2691[var4] = 0;
         this.field2684.offset = this.field2693[var4];
         this.method4019(var4);
         this.field2686[var4] = this.field2684.offset;
      }

   }
}
