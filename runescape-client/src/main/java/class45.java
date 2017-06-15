import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class45 extends class28 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -234935723
   )
   int field592;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 398576725
   )
   int field593;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -360032969
   )
   int field594;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1822563261
   )
   int field597;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;LBuffer;I)V",
      garbageValue = "-182785550"
   )
   void method609(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(class36.field514.field518 != var3) {
         throw new IllegalStateException("");
      } else {
         super.field423 = var2.readUnsignedByte();
         super.field430 = var2.readUnsignedByte();
         super.field424 = var2.readUnsignedShort();
         super.field420 = var2.readUnsignedShort();
         this.field597 = var2.readUnsignedByte();
         this.field592 = var2.readUnsignedByte();
         super.field421 = var2.readUnsignedShort();
         super.field422 = var2.readUnsignedShort();
         this.field593 = var2.readUnsignedByte();
         this.field594 = var2.readUnsignedByte();
         super.field430 = Math.min(super.field430, 4);
         super.field425 = new short[1][64][64];
         super.field419 = new short[super.field430][64][64];
         super.field427 = new byte[super.field430][64][64];
         super.field428 = new byte[super.field430][64][64];
         super.field429 = new class31[super.field430][64][64][];
         var3 = var1.readUnsignedByte();
         if(class35.field504.field505 != var3) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field421 && super.field422 == var5 && this.field593 == var6 && this.field594 == var7) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method230(this.field593 * 8 + var8, var9 + this.field594 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "236"
   )
   boolean method610(int var1, int var2) {
      return var1 < this.field593 * 8?false:(var2 < this.field594 * 8?false:(var1 >= this.field593 * 8 + 8?false:var2 < this.field594 * 8 + 8));
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class45)) {
         return false;
      } else {
         class45 var2 = (class45)var1;
         return super.field421 == var2.field421 && super.field422 == var2.field422?this.field593 == var2.field593 && this.field594 == var2.field594:false;
      }
   }

   public int hashCode() {
      return super.field421 | super.field422 << 8 | this.field593 << 16 | this.field594 << 24;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-71"
   )
   int method611() {
      return this.field597;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-39"
   )
   int method612() {
      return this.field592;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1990199654"
   )
   int method613() {
      return this.field594;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-126"
   )
   int method615() {
      return this.field593;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "723491429"
   )
   static final int method627(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)LScript;",
      garbageValue = "1239147658"
   )
   static Script method630(int var0) {
      Script var1 = (Script)Script.field1533.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class69.indexScripts.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = class47.method673(var2);
            Script.field1533.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;I)Z",
      garbageValue = "-1913455658"
   )
   public static boolean method632(IndexDataBase var0, IndexDataBase var1) {
      Area.field3318 = var1;
      if(!var0.method3999()) {
         return false;
      } else {
         class177.field2429 = var0.method4075(35);
         Area.field3304 = new Area[class177.field2429];

         for(int var2 = 0; var2 < class177.field2429; ++var2) {
            byte[] var3 = var0.getConfigData(35, var2);
            if(var3 != null) {
               Area.field3304[var2] = new Area(var2);
               Area.field3304[var2].method4178(new Buffer(var3));
               Area.field3304[var2].method4172();
            }
         }

         return true;
      }
   }
}
