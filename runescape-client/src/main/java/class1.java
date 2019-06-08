import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
final class class1 implements class0 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("__f_m")
   public static AbstractIndexCache __f_m;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;Lgr;I)V",
      garbageValue = "-223205903"
   )
   public void vmethod44(Object var1, Buffer var2) {
      this.method6((Integer)var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;I)Ljava/lang/Object;",
      garbageValue = "704451908"
   )
   public Object vmethod46(Buffer var1) {
      return Integer.valueOf(var1.readInt());
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Integer;Lgr;I)V",
      garbageValue = "-254123307"
   )
   void method6(Integer var1, Buffer var2) {
      var2.writeInt(var1.intValue());
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "553036714"
   )
   public static boolean method19(int var0) {
      return var0 == class231.field2819.field2820;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "644743473"
   )
   static int method18(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.quantities.length; ++var4) {
            if(var2.ids[var4] == var1) {
               var3 += var2.quantities[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILcg;ZB)I",
      garbageValue = "-91"
   )
   static int method8(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         var4 = Huffman.getWidget(var3);
      } else {
         var4 = var2?WorldMapIcon1.__t_i:class12.__n_n;
      }

      if(var0 == 1000) {
         class179.Interpreter_intStackSize -= 4;
         var4.rawX = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4.rawY = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         var4.xAlignment = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 2];
         var4.yAlignment = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 3];
         class22.method295(var4);
         TextureProvider.client.alignWidget(var4);
         if(var3 != -1 && var4.type == 0) {
            class39.revalidateWidgetScroll(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class179.Interpreter_intStackSize -= 4;
         var4.rawWidth = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4.rawHeight = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         var4.widthAlignment = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 2];
         var4.heightAlignment = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 3];
         class22.method295(var4);
         TextureProvider.client.alignWidget(var4);
         if(var3 != -1 && var4.type == 0) {
            class39.revalidateWidgetScroll(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class22.method295(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.noClickThrough = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.noScrollThrough = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(ILcg;ZB)I",
      garbageValue = "-82"
   )
   static int method16(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 4200) {
         var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Skills.getItemDefinition(var3).name;
         return 1;
      } else {
         int var4;
         ItemDefinition var5;
         if(var0 == 4201) {
            class179.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
            var5 = Skills.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.groundActions[var4 - 1];
            } else {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4202) {
            class179.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
            var5 = Skills.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var5.inventoryActions[var4 - 1];
            } else {
               Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4203) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Skills.getItemDefinition(var3).price;
            return 1;
         } else if(var0 == 4204) {
            var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Skills.getItemDefinition(var3).isStackable == 1?1:0;
            return 1;
         } else {
            ItemDefinition var6;
            if(var0 == 4205) {
               var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               var6 = Skills.getItemDefinition(var3);
               if(var6.noteTemplate == -1 && var6.note >= 0) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var6.note;
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4206) {
               var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               var6 = Skills.getItemDefinition(var3);
               if(var6.noteTemplate >= 0 && var6.note >= 0) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var6.note;
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4207) {
               var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Skills.getItemDefinition(var3).isMembersOnly?1:0;
               return 1;
            } else if(var0 == 4208) {
               var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               var6 = Skills.getItemDefinition(var3);
               if(var6.placeholderTemplate == -1 && var6.placeholder >= 0) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var6.placeholder;
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4209) {
               var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               var6 = Skills.getItemDefinition(var3);
               if(var6.placeholderTemplate >= 0 && var6.placeholder >= 0) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var6.placeholder;
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4210) {
               String var7 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               var4 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
               class50.method900(var7, var4 == 1);
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = WorldMapSection0.__y_sn;
               return 1;
            } else if(var0 != 4211) {
               if(var0 == 4212) {
                  class231.__hb_sg = 0;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(AttackOption.__cj_sp != null && class231.__hb_sg < WorldMapSection0.__y_sn) {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = AttackOption.__cj_sp[++class231.__hb_sg - 1] & '\uffff';
               } else {
                  Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = -1;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-370289311"
   )
   static boolean method15(int var0) {
      for(int var1 = 0; var1 < Client.__client_pm; ++var1) {
         if(Client.__client_pn[var1] == var0) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("kp")
   @ObfuscatedSignature(
      signature = "(Lho;I)I",
      garbageValue = "1809366429"
   )
   @Export("getWidgetClickMask")
   static int getWidgetClickMask(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetClickMasks.get(((long)var0.id << 32) + (long)var0.childIndex);
      return var1 != null?var1.integer:var0.clickMask;
   }
}
