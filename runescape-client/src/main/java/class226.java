import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class226 {
   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "784007739"
   )
   static final void method4076() {
      for(class76 var0 = (class76)Client.field979.method3576(); var0 != null; var0 = (class76)Client.field979.method3578()) {
         if(var0.field1226 > 0) {
            --var0.field1226;
         }

         boolean var1;
         int var2;
         int var3;
         ObjectComposition var4;
         if(var0.field1226 == 0) {
            if(var0.field1222 >= 0) {
               var2 = var0.field1222;
               var3 = var0.field1221;
               var4 = getObjectDefinition(var2);
               if(var3 == 11) {
                  var3 = 10;
               }

               if(var3 >= 5 && var3 <= 8) {
                  var3 = 4;
               }

               var1 = var4.method4528(var3);
               if(!var1) {
                  continue;
               }
            }

            class100.method1855(var0.field1225, var0.field1216, var0.field1217, var0.field1224, var0.field1222, var0.field1220, var0.field1221);
            var0.unlink();
         } else {
            if(var0.field1219 > 0) {
               --var0.field1219;
            }

            if(var0.field1219 == 0 && var0.field1217 >= 1 && var0.field1224 >= 1 && var0.field1217 <= 102 && var0.field1224 <= 102) {
               if(var0.field1227 >= 0) {
                  var2 = var0.field1227;
                  var3 = var0.field1215;
                  var4 = getObjectDefinition(var2);
                  if(var3 == 11) {
                     var3 = 10;
                  }

                  if(var3 >= 5 && var3 <= 8) {
                     var3 = 4;
                  }

                  var1 = var4.method4528(var3);
                  if(!var1) {
                     continue;
                  }
               }

               class100.method1855(var0.field1225, var0.field1216, var0.field1217, var0.field1224, var0.field1227, var0.field1223, var0.field1215);
               var0.field1219 = -1;
               if(var0.field1227 == var0.field1222 && var0.field1222 == -1) {
                  var0.unlink();
               } else if(var0.field1222 == var0.field1227 && var0.field1220 == var0.field1223 && var0.field1221 == var0.field1215) {
                  var0.unlink();
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IS)LObjectComposition;",
      garbageValue = "4095"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field3440.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field3467.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.field3439 = var0;
         if(var2 != null) {
            var1.method4526(new Buffer(var2));
         }

         var1.method4563();
         if(var1.isSolid) {
            var1.field3471 = 0;
            var1.field3450 = false;
         }

         ObjectComposition.field3440.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-872444218"
   )
   public static void method4078() {
      class280.field3751 = new CombatInfoList();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;I)I",
      garbageValue = "1108308764"
   )
   static int method4079(PacketBuffer var0) {
      int var1 = var0.method3397(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method3397(5);
      } else if(var1 == 2) {
         var2 = var0.method3397(8);
      } else {
         var2 = var0.method3397(11);
      }

      return var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "2072868373"
   )
   static int method4080(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class83.intStack[--class83.intStackSize];
         var3 = WorldMapType3.method199(var4);
      } else {
         var3 = var2?class232.field3187:class2.field15;
      }

      if(var0 == 1100) {
         class83.intStackSize -= 2;
         var3.scrollX = class83.intStack[class83.intStackSize];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class83.intStack[class83.intStackSize + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class25.method169(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class83.intStack[--class83.intStackSize];
         class25.method169(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2680 = class83.intStack[--class83.intStackSize] == 1;
         class25.method169(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class83.intStack[--class83.intStackSize];
         class25.method169(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2684 = class83.intStack[--class83.intStackSize];
         class25.method169(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.spriteId = class83.intStack[--class83.intStackSize];
         class25.method169(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.field2687 = class83.intStack[--class83.intStackSize];
         class25.method169(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2689 = class83.intStack[--class83.intStackSize] == 1;
         class25.method169(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class83.intStack[--class83.intStackSize];
         class25.method169(var3);
         return 1;
      } else if(var0 == 1109) {
         class83.intStackSize -= 6;
         var3.field2700 = class83.intStack[class83.intStackSize];
         var3.field2701 = class83.intStack[class83.intStackSize + 1];
         var3.rotationX = class83.intStack[class83.intStackSize + 2];
         var3.rotationZ = class83.intStack[class83.intStackSize + 3];
         var3.rotationY = class83.intStack[class83.intStackSize + 4];
         var3.field2705 = class83.intStack[class83.intStackSize + 5];
         class25.method169(var3);
         return 1;
      } else {
         int var8;
         if(var0 == 1110) {
            var8 = class83.intStack[--class83.intStackSize];
            if(var8 != var3.field2698) {
               var3.field2698 = var8;
               var3.field2675 = 0;
               var3.field2774 = 0;
               class25.method169(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2783 = class83.intStack[--class83.intStackSize] == 1;
            class25.method169(var3);
            return 1;
         } else if(var0 == 1112) {
            String var7 = class83.scriptStringStack[--class51.scriptStringStackSize];
            if(!var7.equals(var3.text)) {
               var3.text = var7;
               class25.method169(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class83.intStack[--class83.intStackSize];
            class25.method169(var3);
            return 1;
         } else if(var0 == 1114) {
            class83.intStackSize -= 3;
            var3.field2714 = class83.intStack[class83.intStackSize];
            var3.field2715 = class83.intStack[class83.intStackSize + 1];
            var3.field2713 = class83.intStack[class83.intStackSize + 2];
            class25.method169(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.field2716 = class83.intStack[--class83.intStackSize] == 1;
            class25.method169(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class83.intStack[--class83.intStackSize];
            class25.method169(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class83.intStack[--class83.intStackSize];
            class25.method169(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class83.intStack[--class83.intStackSize] == 1;
            class25.method169(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class83.intStack[--class83.intStackSize] == 1;
            class25.method169(var3);
            return 1;
         } else if(var0 == 1120) {
            class83.intStackSize -= 2;
            var3.scrollWidth = class83.intStack[class83.intStackSize];
            var3.scrollHeight = class83.intStack[class83.intStackSize + 1];
            class25.method169(var3);
            if(var4 != -1 && var3.type == 0) {
               class236.method4216(CombatInfo1.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            class230.method4093(var3.id, var3.index);
            Client.field963 = var3;
            class25.method169(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2662 = class83.intStack[--class83.intStackSize];
            class25.method169(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2708 = class83.intStack[--class83.intStackSize];
            class25.method169(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2683 = class83.intStack[--class83.intStackSize];
            class25.method169(var3);
            return 1;
         } else if(var0 == 1125) {
            var8 = class83.intStack[--class83.intStackSize];
            class283 var6 = (class283)Item.method1751(DecorativeObject.method2897(), var8);
            if(var6 != null) {
               var3.field2681 = var6;
               class25.method169(var3);
            }

            return 1;
         } else if(var0 == 1126) {
            boolean var5 = class83.intStack[--class83.intStackSize] == 1;
            var3.field2782 = var5;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1758111439"
   )
   static final int method4081() {
      return class134.field2008;
   }
}
