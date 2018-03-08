import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class46 extends class28 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1443982277
   )
   int field559;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1514186289
   )
   int field560;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1392548365
   )
   int field561;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1112571767
   )
   int field562;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgb;Lgb;I)V",
      garbageValue = "-1887428871"
   )
   void method695(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class37.field482.field483) {
         throw new IllegalStateException("");
      } else {
         super.field381 = var2.readUnsignedByte();
         super.field382 = var2.readUnsignedByte();
         super.field379 = var2.readUnsignedShort();
         super.field378 = var2.readUnsignedShort();
         this.field559 = var2.readUnsignedByte();
         this.field560 = var2.readUnsignedByte();
         super.field390 = var2.readUnsignedShort();
         super.field385 = var2.readUnsignedShort();
         this.field561 = var2.readUnsignedByte();
         this.field562 = var2.readUnsignedByte();
         super.field382 = Math.min(super.field382, 4);
         super.field383 = new short[1][64][64];
         super.field384 = new short[super.field382][64][64];
         super.field389 = new byte[super.field382][64][64];
         super.field386 = new byte[super.field382][64][64];
         super.decorations = new WorldMapDecoration[super.field382][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class36.field473.field474) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field390 && var5 == super.field385 && var6 == this.field561 && var7 == this.field562) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method234(var8 + this.field561 * 8, var9 + this.field562 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "791183531"
   )
   boolean method703(int var1, int var2) {
      return var1 < this.field561 * 8?false:(var2 < this.field562 * 8?false:(var1 >= this.field561 * 8 + 8?false:var2 < this.field562 * 8 + 8));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1164041156"
   )
   int method705() {
      return this.field559;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   int method696() {
      return this.field560;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "31"
   )
   int method697() {
      return this.field561;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "87"
   )
   int method698() {
      return this.field562;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class46)) {
         return false;
      } else {
         class46 var2 = (class46)var1;
         return super.field390 == var2.field390 && super.field385 == var2.field385?var2.field561 == this.field561 && var2.field562 == this.field562:false;
      }
   }

   public int hashCode() {
      return super.field390 | super.field385 << 8 | this.field561 << 16 | this.field562 << 24;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2142379490"
   )
   public static boolean method717() {
      ClassInfo var0 = (ClassInfo)class326.classInfos.last();
      return var0 != null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIS)I",
      garbageValue = "28315"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = UnitPriceComparator.getSmoothNoise2D(var3, var5);
      int var8 = UnitPriceComparator.getSmoothNoise2D(var3 + 1, var5);
      int var9 = UnitPriceComparator.getSmoothNoise2D(var3, var5 + 1);
      int var10 = UnitPriceComparator.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var11 = class19.method161(var7, var8, var4, var2);
      int var12 = class19.method161(var9, var10, var4, var2);
      return class19.method161(var11, var12, var6, var2);
   }
}
