import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class206 {
   @ObfuscatedName("x")
   static final byte[] field2568;
   @ObfuscatedName("d")
   long field2556;
   @ObfuscatedName("o")
   int[] field2559;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   Buffer field2569;
   @ObfuscatedName("p")
   int field2562;
   @ObfuscatedName("q")
   int[] field2558;
   @ObfuscatedName("g")
   int[] field2560;
   @ObfuscatedName("s")
   int field2557;
   @ObfuscatedName("v")
   int[] field2565;

   static {
      field2568 = new byte[]{(byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)1, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)2, (byte)0, (byte)1, (byte)2, (byte)1, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0, (byte)0};
   }

   class206(byte[] var1) {
      this.field2569 = new Buffer((byte[])null);
      this.method3909(var1);
   }

   class206() {
      this.field2569 = new Buffer((byte[])null);
   }

   @ObfuscatedName("x")
   int method3953(int var1) {
      byte var2 = this.field2569.payload[this.field2569.offset];
      int var5;
      if(var2 < 0) {
         var5 = var2 & 255;
         this.field2565[var1] = var5;
         ++this.field2569.offset;
      } else {
         var5 = this.field2565[var1];
      }

      if(var5 != 240 && var5 != 247) {
         return this.method3918(var1, var5);
      } else {
         int var3 = this.field2569.readVarInt();
         if(var5 == 247 && var3 > 0) {
            int var4 = this.field2569.payload[this.field2569.offset] & 255;
            if(var4 >= 241 && var4 <= 243 || var4 == 246 || var4 == 248 || var4 >= 250 && var4 <= 252 || var4 == 254) {
               ++this.field2569.offset;
               this.field2565[var1] = var4;
               return this.method3918(var1, var4);
            }
         }

         this.field2569.offset += var3;
         return 0;
      }
   }

   @ObfuscatedName("s")
   void method3910() {
      this.field2569.payload = null;
      this.field2558 = null;
      this.field2559 = null;
      this.field2560 = null;
      this.field2565 = null;
   }

   @ObfuscatedName("q")
   boolean method3911() {
      return this.field2569.payload != null;
   }

   @ObfuscatedName("w")
   void method3909(byte[] var1) {
      this.field2569.payload = var1;
      this.field2569.offset = 10;
      int var2 = this.field2569.readUnsignedShort();
      this.field2557 = this.field2569.readUnsignedShort();
      this.field2562 = 500000;
      this.field2558 = new int[var2];

      int var3;
      int var5;
      for(var3 = 0; var3 < var2; this.field2569.offset += var5) {
         int var4 = this.field2569.readInt();
         var5 = this.field2569.readInt();
         if(var4 == 1297379947) {
            this.field2558[var3] = this.field2569.offset;
            ++var3;
         }
      }

      this.field2556 = 0L;
      this.field2559 = new int[var2];

      for(var3 = 0; var3 < var2; ++var3) {
         this.field2559[var3] = this.field2558[var3];
      }

      this.field2560 = new int[var2];
      this.field2565 = new int[var2];
   }

   @ObfuscatedName("h")
   int method3920() {
      int var1 = this.field2559.length;
      int var2 = -1;
      int var3 = Integer.MAX_VALUE;

      for(int var4 = 0; var4 < var1; ++var4) {
         if(this.field2559[var4] >= 0 && this.field2560[var4] < var3) {
            var2 = var4;
            var3 = this.field2560[var4];
         }
      }

      return var2;
   }

   @ObfuscatedName("g")
   void method3913(int var1) {
      this.field2569.offset = this.field2559[var1];
   }

   @ObfuscatedName("o")
   int method3912() {
      return this.field2559.length;
   }

   @ObfuscatedName("d")
   int method3943(int var1) {
      int var2 = this.method3953(var1);
      return var2;
   }

   @ObfuscatedName("e")
   void method3916(int var1) {
      int var2 = this.field2569.readVarInt();
      this.field2560[var1] += var2;
   }

   @ObfuscatedName("u")
   int method3918(int var1, int var2) {
      int var4;
      if(var2 == 255) {
         int var7 = this.field2569.readUnsignedByte();
         var4 = this.field2569.readVarInt();
         if(var7 == 47) {
            this.field2569.offset += var4;
            return 1;
         } else if(var7 == 81) {
            int var5 = this.field2569.read24BitInt();
            var4 -= 3;
            int var6 = this.field2560[var1];
            this.field2556 += (long)var6 * (long)(this.field2562 - var5);
            this.field2562 = var5;
            this.field2569.offset += var4;
            return 2;
         } else {
            this.field2569.offset += var4;
            return 3;
         }
      } else {
         byte var3 = field2568[var2 - 128];
         var4 = var2;
         if(var3 >= 1) {
            var4 = var2 | this.field2569.readUnsignedByte() << 8;
         }

         if(var3 >= 2) {
            var4 |= this.field2569.readUnsignedByte() << 16;
         }

         return var4;
      }
   }

   @ObfuscatedName("i")
   long method3919(int var1) {
      return this.field2556 + (long)var1 * (long)this.field2562;
   }

   @ObfuscatedName("p")
   void method3915() {
      this.field2569.offset = -1;
   }

   @ObfuscatedName("v")
   void method3907(int var1) {
      this.field2559[var1] = this.field2569.offset;
   }

   @ObfuscatedName("b")
   boolean method3921() {
      int var1 = this.field2559.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         if(this.field2559[var2] >= 0) {
            return false;
         }
      }

      return true;
   }

   @ObfuscatedName("j")
   void method3922(long var1) {
      this.field2556 = var1;
      int var3 = this.field2559.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field2560[var4] = 0;
         this.field2565[var4] = 0;
         this.field2569.offset = this.field2558[var4];
         this.method3916(var4);
         this.field2559[var4] = this.field2569.offset;
      }

   }
}
