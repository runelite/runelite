import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class217 {
   @ObfuscatedName("h")
   static final byte[] field2661;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   Buffer field2654;
   @ObfuscatedName("i")
   int field2653;
   @ObfuscatedName("w")
   int[] field2658;
   @ObfuscatedName("s")
   int[] field2652;
   @ObfuscatedName("j")
   int[] field2656;
   @ObfuscatedName("a")
   int[] field2657;
   @ObfuscatedName("t")
   int field2662;
   @ObfuscatedName("m")
   long field2660;

   static {
      field2661 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class217(byte[] var1) {
      this.field2654 = new Buffer((byte[])null);
      this.method4095(var1);
   }

   class217() {
      this.field2654 = new Buffer((byte[])null);
   }

   @ObfuscatedName("p")
   void method4095(byte[] var1) {
      this.field2654.payload = var1;
      this.field2654.offset = 10;
      int var2 = this.field2654.readUnsignedShort();
      this.field2653 = this.field2654.readUnsignedShort();
      this.field2662 = 500000;
      this.field2658 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2654.offset += var5) {
         int var4 = this.field2654.readInt();
         var5 = this.field2654.readInt();
         if(var4 == 1297379947) {
            this.field2658[var3] = this.field2654.offset;
            ++var3;
         }
      }

      this.field2660 = 0L;
      this.field2652 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2652[var3] = this.field2658[var3];
      }

      this.field2656 = new int[var2];
      this.field2657 = new int[var2];
   }

   @ObfuscatedName("i")
   void method4081() {
      this.field2654.payload = null;
      this.field2658 = null;
      this.field2652 = null;
      this.field2656 = null;
      this.field2657 = null;
   }

   @ObfuscatedName("w")
   boolean method4082() {
      return this.field2654.payload != null;
   }

   @ObfuscatedName("s")
   int method4083() {
      return this.field2652.length;
   }

   @ObfuscatedName("j")
   void method4084(int var1) {
      this.field2654.offset = this.field2652[var1];
   }

   @ObfuscatedName("a")
   void method4085(int var1) {
      this.field2652[var1] = this.field2654.offset;
   }

   @ObfuscatedName("t")
   void method4122() {
      this.field2654.offset = -1;
   }

   @ObfuscatedName("r")
   void method4087(int var1) {
      int var2 = this.field2654.readVarInt();
      this.field2656[var1] += var2;
   }

   @ObfuscatedName("m")
   int method4088(int var1) {
      int var2 = this.method4106(var1);
      return var2;
   }

   @ObfuscatedName("h")
   int method4106(int var1) {
      byte var2 = this.field2654.payload[this.field2654.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2657[var1] = var5;
         ++this.field2654.offset;
      } else {
         var5 = this.field2657[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method4089(var1, var5);
      } else {
         int var3 = this.field2654.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2654.payload[this.field2654.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2654.offset;
               this.field2657[var1] = var4;
               return this.method4089(var1, var4);
            }
         }

         this.field2654.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("o")
   int method4089(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2654.readUnsignedByte();
         var4 = this.field2654.readVarInt();
         if(var7 == 47) {
            this.field2654.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2654.read24BitInt();
            var4 -= 3;
            int var6 = this.field2656[var1];
            this.field2660 += (long)var6 * (long)(this.field2662 - var5);
            this.field2662 = var5;
            this.field2654.offset += var4;
            return 2;
         } else {
            this.field2654.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2661[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2654.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2654.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("x")
   long method4096(int var1) {
      return this.field2660 + (long)var1 * (long)this.field2662;
   }

   @ObfuscatedName("q")
   int method4091() {
      int var1 = this.field2652.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2652[var4] >= 0 && this.field2656[var4] < var3) {
            var2 = var4;
            var3 = this.field2656[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("d")
   boolean method4092() {
      int var1 = this.field2652.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2652[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("l")
   void method4126(long var1) {
      this.field2660 = var1;
      int var3 = this.field2652.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2656[var4] = 0;
         this.field2657[var4] = 0;
         this.field2654.offset = this.field2658[var4];
         this.method4087(var4);
         this.field2652[var4] = this.field2654.offset;
      }

   }
}
