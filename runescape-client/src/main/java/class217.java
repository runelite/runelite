import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public class class217 {
   @ObfuscatedName("k")
   static final byte[] field2679;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgy;"
   )
   Buffer field2681;
   @ObfuscatedName("g")
   int field2683;
   @ObfuscatedName("m")
   int[] field2670;
   @ObfuscatedName("h")
   int[] field2673;
   @ObfuscatedName("i")
   int[] field2674;
   @ObfuscatedName("w")
   int[] field2680;
   @ObfuscatedName("t")
   int field2676;
   @ObfuscatedName("z")
   long field2678;

   static {
      field2679 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class217(byte[] var1) {
      this.field2681 = new Buffer((byte[])null);
      this.method4271(var1);
   }

   class217() {
      this.field2681 = new Buffer((byte[])null);
   }

   @ObfuscatedName("s")
   void method4271(byte[] var1) {
      this.field2681.payload = var1;
      this.field2681.offset = 10;
      int var2 = this.field2681.readUnsignedShort();
      this.field2683 = this.field2681.readUnsignedShort();
      this.field2676 = 500000;
      this.field2670 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2681.offset += var5) {
         int var4 = this.field2681.readInt();
         var5 = this.field2681.readInt();
         if(var4 == 1297379947) {
            this.field2670[var3] = this.field2681.offset;
            ++var3;
         }
      }

      this.field2678 = 0L;
      this.field2673 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2673[var3] = this.field2670[var3];
      }

      this.field2674 = new int[var2];
      this.field2680 = new int[var2];
   }

   @ObfuscatedName("g")
   void method4254() {
      this.field2681.payload = null;
      this.field2670 = null;
      this.field2673 = null;
      this.field2674 = null;
      this.field2680 = null;
   }

   @ObfuscatedName("m")
   boolean method4278() {
      return this.field2681.payload != null;
   }

   @ObfuscatedName("h")
   int method4256() {
      return this.field2673.length;
   }

   @ObfuscatedName("i")
   void method4295(int var1) {
      this.field2681.offset = this.field2673[var1];
   }

   @ObfuscatedName("w")
   void method4258(int var1) {
      this.field2673[var1] = this.field2681.offset;
   }

   @ObfuscatedName("t")
   void method4266() {
      this.field2681.offset = -1;
   }

   @ObfuscatedName("d")
   void method4260(int var1) {
      int var2 = this.field2681.readVarInt();
      this.field2674[var1] += var2;
   }

   @ObfuscatedName("z")
   int method4252(int var1) {
      int var2 = this.method4262(var1);
      return var2;
   }

   @ObfuscatedName("k")
   int method4262(int var1) {
      byte var2 = this.field2681.payload[this.field2681.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2680[var1] = var5;
         ++this.field2681.offset;
      } else {
         var5 = this.field2680[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method4263(var1, var5);
      } else {
         int var3 = this.field2681.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2681.payload[this.field2681.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2681.offset;
               this.field2680[var1] = var4;
               return this.method4263(var1, var4);
            }
         }

         this.field2681.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("c")
   int method4263(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2681.readUnsignedByte();
         var4 = this.field2681.readVarInt();
         if(var7 == 47) {
            this.field2681.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2681.read24BitInt();
            var4 -= 3;
            int var6 = this.field2674[var1];
            this.field2678 += (long)var6 * (long)(this.field2676 - var5);
            this.field2676 = var5;
            this.field2681.offset += var4;
            return 2;
         } else {
            this.field2681.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2679[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2681.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2681.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("o")
   long method4264(int var1) {
      return this.field2678 + (long)var1 * (long)this.field2676;
   }

   @ObfuscatedName("l")
   int method4265() {
      int var1 = this.field2673.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2673[var4] >= 0 && this.field2674[var4] < var3) {
            var2 = var4;
            var3 = this.field2674[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("f")
   boolean method4267() {
      int var1 = this.field2673.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2673[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("q")
   void method4255(long var1) {
      this.field2678 = var1;
      int var3 = this.field2673.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2674[var4] = 0;
         this.field2680[var4] = 0;
         this.field2681.offset = this.field2670[var4];
         this.method4260(var4);
         this.field2673[var4] = this.field2681.offset;
      }

   }
}
