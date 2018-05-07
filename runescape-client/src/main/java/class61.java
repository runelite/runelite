import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public final class class61 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "-2126376581"
   )
   static int method1097(int var0, Script var1, boolean var2) {
      if(var0 == 6200) {
         class171.intStackSize -= 2;
         Client.field1100 = (short)class81.intStack[class171.intStackSize];
         if(Client.field1100 <= 0) {
            Client.field1100 = 256;
         }

         Client.field1125 = (short)class81.intStack[class171.intStackSize + 1];
         if(Client.field1125 <= 0) {
            Client.field1125 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         class171.intStackSize -= 2;
         Client.field1102 = (short)class81.intStack[class171.intStackSize];
         if(Client.field1102 <= 0) {
            Client.field1102 = 256;
         }

         Client.field1103 = (short)class81.intStack[class171.intStackSize + 1];
         if(Client.field1103 <= 0) {
            Client.field1103 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class171.intStackSize -= 4;
         Client.field883 = (short)class81.intStack[class171.intStackSize];
         if(Client.field883 <= 0) {
            Client.field883 = 1;
         }

         Client.field1026 = (short)class81.intStack[class171.intStackSize + 1];
         if(Client.field1026 <= 0) {
            Client.field1026 = 32767;
         } else if(Client.field1026 < Client.field883) {
            Client.field1026 = Client.field883;
         }

         Client.field1106 = (short)class81.intStack[class171.intStackSize + 2];
         if(Client.field1106 <= 0) {
            Client.field1106 = 1;
         }

         Client.field940 = (short)class81.intStack[class171.intStackSize + 3];
         if(Client.field940 <= 0) {
            Client.field940 = 32767;
         } else if(Client.field940 < Client.field1106) {
            Client.field940 = Client.field1106;
         }

         return 1;
      } else if(var0 == 6203) {
         if(Client.field862 != null) {
            class1.method2(0, 0, Client.field862.width, Client.field862.height, false);
            class81.intStack[++class171.intStackSize - 1] = Client.viewportWidth;
            class81.intStack[++class171.intStackSize - 1] = Client.viewportHeight;
         } else {
            class81.intStack[++class171.intStackSize - 1] = -1;
            class81.intStack[++class171.intStackSize - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class81.intStack[++class171.intStackSize - 1] = Client.field1102;
         class81.intStack[++class171.intStackSize - 1] = Client.field1103;
         return 1;
      } else if(var0 == 6205) {
         class81.intStack[++class171.intStackSize - 1] = Client.field1100;
         class81.intStack[++class171.intStackSize - 1] = Client.field1125;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(Liz;Lju;IIZI)V",
      garbageValue = "1896011363"
   )
   static final void method1096(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         String var9 = DynamicObject.getColTags(16748608) + var1.name;
         int var11 = var1.id;
         int var13 = var0.id;
         if(!Client.isMenuOpen && Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var7;
            Client.menuTargets[Client.menuOptionCount] = var9;
            Client.menuTypes[Client.menuOptionCount] = var6;
            Client.menuIdentifiers[Client.menuOptionCount] = var11;
            Client.menuActionParams0[Client.menuOptionCount] = var2;
            Client.menuActionParams1[Client.menuOptionCount] = var13;
            Client.menuBooleanArray[Client.menuOptionCount] = var4;
            ++Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      signature = "([Liz;II)V",
      garbageValue = "486430032"
   )
   static final void method1091(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method1091(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  GraphicsObject.method1920(var4.id, var1);
               }
            }

            ScriptEvent var5;
            if(var1 == 0 && var3.onDialogAbortListener != null) {
               var5 = new ScriptEvent();
               var5.source = var3;
               var5.objs = var3.onDialogAbortListener;
               class71.method1203(var5);
            }

            if(var1 == 1 && var3.onSubChangeListener != null) {
               if(var3.index >= 0) {
                  Widget var6 = UnitPriceComparator.getWidget(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                     continue;
                  }
               }

               var5 = new ScriptEvent();
               var5.source = var3;
               var5.objs = var3.onSubChangeListener;
               class71.method1203(var5);
            }
         }
      }

   }
}
