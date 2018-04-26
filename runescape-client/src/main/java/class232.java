import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
public class class232 {
   @ObfuscatedName("h")
   static final byte[] field2760;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   Buffer field2764;
   @ObfuscatedName("e")
   int field2751;
   @ObfuscatedName("b")
   int[] field2753;
   @ObfuscatedName("z")
   int[] field2756;
   @ObfuscatedName("n")
   int[] field2755;
   @ObfuscatedName("l")
   int[] field2763;
   @ObfuscatedName("s")
   int field2757;
   @ObfuscatedName("c")
   long field2759;

   static {
      field2760 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class232(byte[] var1) {
      this.field2764 = new Buffer((byte[])null);
      this.method4361(var1);
   }

   class232() {
      this.field2764 = new Buffer((byte[])null);
   }

   @ObfuscatedName("g")
   void method4361(byte[] var1) {
      this.field2764.payload = var1;
      this.field2764.offset = 10;
      int var2 = this.field2764.readUnsignedShort();
      this.field2751 = this.field2764.readUnsignedShort();
      this.field2757 = 500000;
      this.field2753 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2764.offset += var5) {
         int var4 = this.field2764.readInt();
         var5 = this.field2764.readInt();
         if(var4 == 1297379947) {
            this.field2753[var3] = this.field2764.offset;
            ++var3;
         }
      }

      this.field2759 = 0L;
      this.field2756 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2756[var3] = this.field2753[var3];
      }

      this.field2755 = new int[var2];
      this.field2763 = new int[var2];
   }

   @ObfuscatedName("e")
   void method4362() {
      this.field2764.payload = null;
      this.field2753 = null;
      this.field2756 = null;
      this.field2755 = null;
      this.field2763 = null;
   }

   @ObfuscatedName("b")
   boolean method4363() {
      return this.field2764.payload != null;
   }

   @ObfuscatedName("z")
   int method4375() {
      return this.field2756.length;
   }

   @ObfuscatedName("n")
   void method4365(int var1) {
      this.field2764.offset = this.field2756[var1];
   }

   @ObfuscatedName("l")
   void method4366(int var1) {
      this.field2756[var1] = this.field2764.offset;
   }

   @ObfuscatedName("s")
   void method4386() {
      this.field2764.offset = -1;
   }

   @ObfuscatedName("y")
   void method4367(int var1) {
      int var2 = this.field2764.readVarInt();
      this.field2755[var1] += var2;
   }

   @ObfuscatedName("c")
   int method4368(int var1) {
      int var2 = this.method4369(var1);
      return var2;
   }

   @ObfuscatedName("o")
   int method4369(int var1) {
      byte var2 = this.field2764.payload[this.field2764.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2763[var1] = var5;
         ++this.field2764.offset;
      } else {
         var5 = this.field2763[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method4360(var1, var5);
      } else {
         int var3 = this.field2764.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2764.payload[this.field2764.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2764.offset;
               this.field2763[var1] = var4;
               return this.method4360(var1, var4);
            }
         }

         this.field2764.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("d")
   int method4360(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2764.readUnsignedByte();
         var4 = this.field2764.readVarInt();
         if(var7 == 47) {
            this.field2764.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2764.read24BitInt();
            var4 -= 3;
            int var6 = this.field2755[var1];
            this.field2759 += (long)var6 * (long)(this.field2757 - var5);
            this.field2757 = var5;
            this.field2764.offset += var4;
            return 2;
         } else {
            this.field2764.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2760[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2764.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2764.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("r")
   long method4371(int var1) {
      return this.field2759 + (long)var1 * (long)this.field2757;
   }

   @ObfuscatedName("p")
   int method4373() {
      int var1 = this.field2756.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2756[var4] >= 0 && this.field2755[var4] < var3) {
            var2 = var4;
            var3 = this.field2755[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("q")
   boolean method4411() {
      int var1 = this.field2756.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2756[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("f")
   void method4374(long var1) {
      this.field2759 = var1;
      int var3 = this.field2756.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2755[var4] = 0;
         this.field2763[var4] = 0;
         this.field2764.offset = this.field2753[var4];
         this.method4367(var4);
         this.field2756[var4] = this.field2764.offset;
      }

   }
}
