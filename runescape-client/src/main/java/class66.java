import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class66 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lbq;"
   )
   static final class66 field823;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lbq;"
   )
   static final class66 field824;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lbq;"
   )
   static final class66 field825;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lbq;"
   )
   static final class66 field826;
   @ObfuscatedName("la")
   @ObfuscatedGetter(
      intValue = -1696983387
   )
   static int field830;

   static {
      field823 = new class66();
      field824 = new class66();
      field825 = new class66();
      field826 = new class66();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1116282484"
   )
   static int method1143(int var0, int var1) {
      Overlay var2 = NPCComposition.method4664(var0);
      if(var2 == null) {
         return var1;
      } else if(var2.otherRgbColor >= 0) {
         return var2.otherRgbColor | -16777216;
      } else if(var2.texture >= 0) {
         int var3 = Friend.method1139(Graphics3D.textureLoader.getAverageTextureRGB(var2.texture), 96);
         return Graphics3D.colorPalette[var3] | -16777216;
      } else if(var2.color == 16711935) {
         return var1;
      } else {
         int var4 = var2.hue;
         int var5 = var2.saturation;
         int var6 = var2.lightness;
         if(var6 > 179) {
            var5 /= 2;
         }

         if(var6 > 192) {
            var5 /= 2;
         }

         if(var6 > 217) {
            var5 /= 2;
         }

         if(var6 > 243) {
            var5 /= 2;
         }

         int var7 = (var5 / 32 << 7) + var6 / 2 + (var4 / 4 << 10);
         int var8 = Friend.method1139(var7, 96);
         return Graphics3D.colorPalette[var8] | -16777216;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lia;IIIZI)V",
      garbageValue = "481384056"
   )
   public static void method1144(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class204.field2507 = 1;
      class204.field2502 = var0;
      class150.field2205 = var1;
      class153.field2222 = var2;
      class204.field2504 = var3;
      class99.field1532 = var4;
      class204.field2505 = 10000;
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "([Lhi;II)V",
      garbageValue = "1049941668"
   )
   static final void method1142(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method1142(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  Friend.method1140(var4.id, var1);
               }
            }

            ScriptEvent var5;
            if(var1 == 0 && var3.field2756 != null) {
               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.field856 = var3.field2756;
               Coordinates.method3942(var5);
            }

            if(var1 == 1 && var3.field2744 != null) {
               if(var3.index >= 0) {
                  Widget var6 = class84.method1670(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                     continue;
                  }
               }

               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.field856 = var3.field2744;
               Coordinates.method3942(var5);
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "-1758096949"
   )
   static int method1145(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class84.intStack[--class84.intStackSize];
         var4 = class84.method1670(var3);
      } else {
         var4 = var2?class43.field582:class208.field2580;
      }

      if(var0 == 1000) {
         class84.intStackSize -= 4;
         var4.originalX = class84.intStack[class84.intStackSize];
         var4.originalY = class84.intStack[class84.intStackSize + 1];
         var4.field2654 = class84.intStack[class84.intStackSize + 2];
         var4.field2734 = class84.intStack[class84.intStackSize + 3];
         class90.method1723(var4);
         class27.clientInstance.method1228(var4);
         if(var3 != -1 && var4.type == 0) {
            class51.method812(class176.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class84.intStackSize -= 4;
         var4.originalWidth = class84.intStack[class84.intStackSize];
         var4.field2656 = class84.intStack[class84.intStackSize + 1];
         var4.field2637 = class84.intStack[class84.intStackSize + 2];
         var4.buttonType = class84.intStack[class84.intStackSize + 3];
         class90.method1723(var4);
         class27.clientInstance.method1228(var4);
         if(var3 != -1 && var4.type == 0) {
            class51.method812(class176.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class84.intStack[--class84.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class90.method1723(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2758 = class84.intStack[--class84.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2732 = class84.intStack[--class84.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(Lhi;I)Lhi;",
      garbageValue = "-610261049"
   )
   static Widget method1141(Widget var0) {
      Widget var1 = Preferences.method1598(var0);
      if(var1 == null) {
         var1 = var0.dragParent;
      }

      return var1;
   }
}
