import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
public final class class10 extends class9 {
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 1025212641
   )
   static int field261;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1387685085
   )
   final int field258;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1306943805
   )
   final int field255;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 255959661
   )
   final int field260;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 250492253
   )
   final int field262;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 396354513
   )
   final int field254;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1342044199
   )
   final int field257;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1078442841
   )
   final int field252;

   @ObfuscatedSignature(
      signature = "(Lew;IIII)V"
   )
   class10(Model var1, int var2, int var3, int var4, int var5) {
      this.field258 = var2 + var1.field1944 - var1.field1939;
      this.field260 = var3 + var1.field1945 - var1.field1948;
      this.field254 = var4 + var1.field1946 - var1.field1942;
      this.field255 = var2 + var1.field1944 + var1.field1939;
      this.field262 = var3 + var1.field1945 + var1.field1948;
      this.field257 = var4 + var1.field1946 + var1.field1942;
      this.field252 = var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   final void vmethod53() {
      for(int var4 = 0; var4 < 8; ++var4) {
         int var1 = (var4 & 1) == 0?this.field258:this.field255;
         int var2 = (var4 & 2) == 0?this.field260:this.field262;
         int var3 = (var4 & 4) == 0?this.field254:this.field257;
         if((var4 & 1) == 0) {
            class33.method352(var1, var2, var3, this.field255, var2, var3, this.field252);
         }

         if((var4 & 2) == 0) {
            class33.method352(var1, var2, var3, var1, this.field262, var3, this.field252);
         }

         if((var4 & 4) == 0) {
            class33.method352(var1, var2, var3, var1, var2, this.field257, this.field252);
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-74"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(Timer.validInterfaces[var0]) {
         return true;
      } else if(!Widget.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = Widget.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            Timer.validInterfaces[var0] = true;
            return true;
         } else {
            if(Item.widgets[var0] == null) {
               Item.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Item.widgets[var0][var2] == null) {
                  byte[] var3 = Widget.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     Item.widgets[var0][var2] = new Widget();
                     Item.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Item.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        Item.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            Timer.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lit;Ljava/lang/String;Ljava/lang/String;B)[Ljp;",
      garbageValue = "-101"
   )
   public static IndexedSprite[] method55(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite[] var5;
      if(!Script.method1883(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = Widget.method3998();
      }

      return var5;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILcc;ZI)I",
      garbageValue = "-1037730764"
   )
   static int method51(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class266.method4862(class84.intStack[--class84.intStackSize]);
      } else {
         var3 = var2?class269.field3661:DecorativeObject.field2164;
      }

      int var4;
      if(var0 == 1300) {
         var4 = class84.intStack[--class84.intStackSize] - 1;
         if(var4 >= 0 && var4 <= 9) {
            var3.method4009(var4, class84.scriptStringStack[--class84.scriptStringStackSize]);
            return 1;
         } else {
            --class84.scriptStringStackSize;
            return 1;
         }
      } else if(var0 == 1301) {
         class84.intStackSize -= 2;
         var4 = class84.intStack[class84.intStackSize];
         int var5 = class84.intStack[class84.intStackSize + 1];
         var3.dragParent = class24.method183(var4, var5);
         return 1;
      } else if(var0 == 1302) {
         var3.field2701 = class84.intStack[--class84.intStackSize] == 1;
         return 1;
      } else if(var0 == 1303) {
         var3.field2699 = class84.intStack[--class84.intStackSize];
         return 1;
      } else if(var0 == 1304) {
         var3.field2700 = class84.intStack[--class84.intStackSize];
         return 1;
      } else if(var0 == 1305) {
         var3.name = class84.scriptStringStack[--class84.scriptStringStackSize];
         return 1;
      } else if(var0 == 1306) {
         var3.selectedAction = class84.scriptStringStack[--class84.scriptStringStackSize];
         return 1;
      } else if(var0 == 1307) {
         var3.actions = null;
         return 1;
      } else {
         return 2;
      }
   }
}
