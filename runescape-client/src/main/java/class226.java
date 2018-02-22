import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class226 {
   @ObfuscatedName("c")
   static final byte[] field2711;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   Buffer field2703;
   @ObfuscatedName("q")
   int field2709;
   @ObfuscatedName("o")
   int[] field2704;
   @ObfuscatedName("p")
   int[] field2705;
   @ObfuscatedName("a")
   int[] field2706;
   @ObfuscatedName("h")
   int[] field2707;
   @ObfuscatedName("l")
   int field2710;
   @ObfuscatedName("g")
   long field2714;

   static {
      field2711 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class226(byte[] var1) {
      this.field2703 = new Buffer((byte[])null);
      this.method4301(var1);
   }

   class226() {
      this.field2703 = new Buffer((byte[])null);
   }

   @ObfuscatedName("b")
   void method4301(byte[] var1) {
      this.field2703.payload = var1;
      this.field2703.offset = 10;
      int var2 = this.field2703.readUnsignedShort();
      this.field2709 = this.field2703.readUnsignedShort();
      this.field2710 = 500000;
      this.field2704 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2703.offset += var5) {
         int var4 = this.field2703.readInt();
         var5 = this.field2703.readInt();
         if(var4 == 1297379947) {
            this.field2704[var3] = this.field2703.offset;
            ++var3;
         }
      }

      this.field2714 = 0L;
      this.field2705 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2705[var3] = this.field2704[var3];
      }

      this.field2706 = new int[var2];
      this.field2707 = new int[var2];
   }

   @ObfuscatedName("q")
   void method4264() {
      this.field2703.payload = null;
      this.field2704 = null;
      this.field2705 = null;
      this.field2706 = null;
      this.field2707 = null;
   }

   @ObfuscatedName("o")
   boolean method4265() {
      return this.field2703.payload != null;
   }

   @ObfuscatedName("p")
   int method4266() {
      return this.field2705.length;
   }

   @ObfuscatedName("a")
   void method4312(int var1) {
      this.field2703.offset = this.field2705[var1];
   }

   @ObfuscatedName("h")
   void method4310(int var1) {
      this.field2705[var1] = this.field2703.offset;
   }

   @ObfuscatedName("l")
   void method4267() {
      this.field2703.offset = -1;
   }

   @ObfuscatedName("y")
   void method4270(int var1) {
      int var2 = this.field2703.readVarInt();
      this.field2706[var1] += var2;
   }

   @ObfuscatedName("g")
   int method4271(int var1) {
      int var2 = this.method4284(var1);
      return var2;
   }

   @ObfuscatedName("c")
   int method4284(int var1) {
      byte var2 = this.field2703.payload[this.field2703.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2707[var1] = var5;
         ++this.field2703.offset;
      } else {
         var5 = this.field2707[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method4299(var1, var5);
      } else {
         int var3 = this.field2703.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2703.payload[this.field2703.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2703.offset;
               this.field2707[var1] = var4;
               return this.method4299(var1, var4);
            }
         }

         this.field2703.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("u")
   int method4299(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2703.readUnsignedByte();
         var4 = this.field2703.readVarInt();
         if(var7 == 47) {
            this.field2703.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2703.read24BitInt();
            var4 -= 3;
            int var6 = this.field2706[var1];
            this.field2714 += (long)var6 * (long)(this.field2710 - var5);
            this.field2710 = var5;
            this.field2703.offset += var4;
            return 2;
         } else {
            this.field2703.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2711[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2703.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2703.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("t")
   long method4278(int var1) {
      return this.field2714 + (long)var1 * (long)this.field2710;
   }

   @ObfuscatedName("f")
   int method4275() {
      int var1 = this.field2705.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2705[var4] >= 0 && this.field2706[var4] < var3) {
            var2 = var4;
            var3 = this.field2706[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("m")
   boolean method4277() {
      int var1 = this.field2705.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2705[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("x")
   void method4293(long var1) {
      this.field2714 = var1;
      int var3 = this.field2705.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2706[var4] = 0;
         this.field2707[var4] = 0;
         this.field2703.offset = this.field2704[var4];
         this.method4270(var4);
         this.field2705[var4] = this.field2703.offset;
      }

   }
}
