import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("BoundingBox3D")
public final class BoundingBox3D extends BoundingBox {
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = -650709577
   )
   static int field264;
   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "Lbb;"
   )
   @Export("mouseRecorder")
   static MouseRecorder mouseRecorder;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1269585401
   )
   @Export("int1")
   final int int1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 534661615
   )
   @Export("int2")
   final int int2;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 621499393
   )
   @Export("int3")
   final int int3;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1467907473
   )
   @Export("int4")
   final int int4;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1768428995
   )
   @Export("int5")
   final int int5;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 808869803
   )
   @Export("int6")
   final int int6;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1367137847
   )
   @Export("color")
   final int color;

   @ObfuscatedSignature(
      signature = "(Lel;IIII)V"
   )
   public BoundingBox3D(Model var1, int var2, int var3, int var4, int var5) {
      this.int1 = var2 + var1.centerX - var1.extremeX;
      this.int2 = var3 + var1.centerY - var1.extremeY;
      this.int3 = var4 + var1.centerZ - var1.extremeZ;
      this.int4 = var2 + var1.extremeX + var1.centerX;
      this.int5 = var3 + var1.extremeY + var1.centerY;
      this.int6 = var4 + var1.centerZ + var1.extremeZ;
      this.color = var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public final void vmethod59() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.int1:this.int4;
         int var2 = (var4 & 2) == 0?this.int2:this.int5;
         int var3 = (var4 & 4) == 0?this.int3:this.int6;
         if((var4 & 1) == 0) {
            MapLabel.method369(var1, var2, var3, this.int4, var2, var3, this.color);
         }

         if((var4 & 2) == 0) {
            MapLabel.method369(var1, var2, var3, var1, this.int5, var3, this.color);
         }

         if((var4 & 4) == 0) {
            MapLabel.method369(var1, var2, var3, var1, var2, this.int6, this.color);
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "915864679"
   )
   static synchronized byte[] method61(int var0) {
      return class195.method3820(var0, false);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-65"
   )
   public static boolean method60(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "143644636"
   )
   static int method57(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 4200) {
         var3 = class81.intStack[--class81.intStackSize];
         class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = class251.getItemDefinition(var3).name;
         return 1;
      } else {
         int var4;
         ItemComposition var5;
         if(var0 == 4201) {
            class81.intStackSize -= 2;
            var3 = class81.intStack[class81.intStackSize];
            var4 = class81.intStack[class81.intStackSize + 1];
            var5 = class251.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
               class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var5.groundActions[var4 - 1];
            } else {
               class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4202) {
            class81.intStackSize -= 2;
            var3 = class81.intStack[class81.intStackSize];
            var4 = class81.intStack[class81.intStackSize + 1];
            var5 = class251.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
               class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var5.inventoryActions[var4 - 1];
            } else {
               class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4203) {
            var3 = class81.intStack[--class81.intStackSize];
            class81.intStack[++class81.intStackSize - 1] = class251.getItemDefinition(var3).price;
            return 1;
         } else if(var0 == 4204) {
            var3 = class81.intStack[--class81.intStackSize];
            class81.intStack[++class81.intStackSize - 1] = class251.getItemDefinition(var3).isStackable == 1?1:0;
            return 1;
         } else {
            ItemComposition var6;
            if(var0 == 4205) {
               var3 = class81.intStack[--class81.intStackSize];
               var6 = class251.getItemDefinition(var3);
               if(var6.notedTemplate == -1 && var6.note >= 0) {
                  class81.intStack[++class81.intStackSize - 1] = var6.note;
               } else {
                  class81.intStack[++class81.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4206) {
               var3 = class81.intStack[--class81.intStackSize];
               var6 = class251.getItemDefinition(var3);
               if(var6.notedTemplate >= 0 && var6.note >= 0) {
                  class81.intStack[++class81.intStackSize - 1] = var6.note;
               } else {
                  class81.intStack[++class81.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4207) {
               var3 = class81.intStack[--class81.intStackSize];
               class81.intStack[++class81.intStackSize - 1] = class251.getItemDefinition(var3).isMembers?1:0;
               return 1;
            } else if(var0 == 4208) {
               var3 = class81.intStack[--class81.intStackSize];
               var6 = class251.getItemDefinition(var3);
               if(var6.int3 == -1 && var6.int2 >= 0) {
                  class81.intStack[++class81.intStackSize - 1] = var6.int2;
               } else {
                  class81.intStack[++class81.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4209) {
               var3 = class81.intStack[--class81.intStackSize];
               var6 = class251.getItemDefinition(var3);
               if(var6.int3 >= 0 && var6.int2 >= 0) {
                  class81.intStack[++class81.intStackSize - 1] = var6.int2;
               } else {
                  class81.intStack[++class81.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4210) {
               String var7 = class81.scriptStringStack[--UrlRequester.scriptStringStackSize];
               var4 = class81.intStack[--class81.intStackSize];
               WorldMapType1.method283(var7, var4 == 1);
               class81.intStack[++class81.intStackSize - 1] = AttackOption.field1333;
               return 1;
            } else if(var0 != 4211) {
               if(var0 == 4212) {
                  BaseVarType.field28 = 0;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(class45.field578 != null && BaseVarType.field28 < AttackOption.field1333) {
                  class81.intStack[++class81.intStackSize - 1] = class45.field578[++BaseVarType.field28 - 1] & '\uffff';
               } else {
                  class81.intStack[++class81.intStackSize - 1] = -1;
               }

               return 1;
            }
         }
      }
   }
}
