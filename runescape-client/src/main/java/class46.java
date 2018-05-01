import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class46 extends class28 {
   @ObfuscatedName("am")
   static GarbageCollectorMXBean field572;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -533833813
   )
   int field576;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -922444411
   )
   int field573;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 434272825
   )
   int field574;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1233638771
   )
   int field575;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgg;Lgg;I)V",
      garbageValue = "-1595648378"
   )
   void method710(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class37.field500.field499) {
         throw new IllegalStateException("");
      } else {
         super.field402 = var2.readUnsignedByte();
         super.field403 = var2.readUnsignedByte();
         super.field405 = var2.readUnsignedShort();
         super.field399 = var2.readUnsignedShort();
         this.field576 = var2.readUnsignedByte();
         this.field573 = var2.readUnsignedByte();
         super.field410 = var2.readUnsignedShort();
         super.field398 = var2.readUnsignedShort();
         this.field574 = var2.readUnsignedByte();
         this.field575 = var2.readUnsignedByte();
         super.field403 = Math.min(super.field403, 4);
         super.field404 = new short[1][64][64];
         super.field400 = new short[super.field403][64][64];
         super.field406 = new byte[super.field403][64][64];
         super.field407 = new byte[super.field403][64][64];
         super.decorations = new WorldMapDecoration[super.field403][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class36.field492.field491) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            int var6 = var1.readUnsignedByte();
            int var7 = var1.readUnsignedByte();
            if(var4 == super.field410 && var5 == super.field398 && var6 == this.field574 && var7 == this.field575) {
               for(int var8 = 0; var8 < 8; ++var8) {
                  for(int var9 = 0; var9 < 8; ++var9) {
                     this.method223(var8 + this.field574 * 8, var9 + this.field575 * 8, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "90"
   )
   boolean method709(int var1, int var2) {
      return var1 < this.field574 * 8?false:(var2 < this.field575 * 8?false:(var1 >= this.field574 * 8 + 8?false:var2 < this.field575 * 8 + 8));
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1381621117"
   )
   int method686() {
      return this.field576;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-952983276"
   )
   int method687() {
      return this.field573;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1339539415"
   )
   int method704() {
      return this.field574;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-62"
   )
   int method689() {
      return this.field575;
   }

   public int hashCode() {
      return super.field410 | super.field398 << 8 | this.field574 << 16 | this.field575 << 24;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class46)) {
         return false;
      } else {
         class46 var2 = (class46)var1;
         return var2.field410 == super.field410 && var2.field398 == super.field398?var2.field574 == this.field574 && this.field575 == var2.field575:false;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "1308428668"
   )
   @Export("parseInt")
   public static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "961895359"
   )
   public static void method684() {
      class38.field507.method4241();
      class229.field2694 = 1;
      class132.field1905 = null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "154749746"
   )
   static int method707(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = UnitPriceComparator.getWidget(class81.intStack[--class171.intStackSize]);
      } else {
         var3 = var2?class49.field604:class81.field1270;
      }

      TotalQuantityComparator.method100(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class81.intStack[--class171.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = class265.localPlayer.composition.method4496();
            return 1;
         } else {
            return 2;
         }
      } else {
         class171.intStackSize -= 2;
         int var4 = class81.intStack[class171.intStackSize];
         int var5 = class81.intStack[class171.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = NetWriter.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.offsetX2d = var6.offsetX2d;
         var3.offsetY2d = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2879 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2879 = 1;
         } else {
            var3.field2879 = 2;
         }

         if(var3.field2876 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2876;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "64005372"
   )
   static final void method708() {
      if(Client.field1075 != ScriptVarType.plane) {
         Client.field1075 = ScriptVarType.plane;
         class240.method4523(ScriptVarType.plane);
      }

   }
}
