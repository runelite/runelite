import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
public final class class61 {
   @ObfuscatedName("w")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("s")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -445336753
   )
   static int field770;
   @ObfuscatedName("j")
   static final int[] field774;
   @ObfuscatedName("y")
   static final int[] field785;
   @ObfuscatedName("k")
   static final int[] field776;
   @ObfuscatedName("c")
   static final int[] field780;
   @ObfuscatedName("r")
   static final int[] field768;
   @ObfuscatedName("m")
   static final int[] field775;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1255198553
   )
   static int field779;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1764912815
   )
   static int field781;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -432197985
   )
   static int field783;
   @ObfuscatedName("g")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("p")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("u")
   static int[] field777;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field770 = 99;
      field774 = new int[]{1, 2, 4, 8};
      field785 = new int[]{16, 32, 64, 128};
      field776 = new int[]{1, 0, -1, 0};
      field780 = new int[]{0, -1, 0, 1};
      field768 = new int[]{1, -1, -1, 1};
      field775 = new int[]{-1, -1, 1, 1};
      field779 = (int)(Math.random() * 17.0D) - 8;
      field781 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "(Lhj;IIZI)V",
      garbageValue = "-1755043626"
   )
   static void method1065(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2649 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2649 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2649 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.field2654;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.field2654;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.field2654 >> 14;
      }

      if(var0.field2649 == 4) {
         var0.width = var0.field2696 * var0.height / var0.field2660;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.field2660 * var0.width / var0.field2696;
      }

      if(Client.field1084 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field1086 = var0;
      }

      if(var3 && var0.field2661 != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.field849 = var0.field2661;
         Client.field1113.addFront(var6);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lip;I)V",
      garbageValue = "2147391919"
   )
   public static void method1066(IndexDataBase var0) {
      InvType.field3276 = var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILct;ZB)I",
      garbageValue = "126"
   )
   static int method1064(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 == 2700) {
         var3 = ItemLayer.method2454(class81.intStack[--class278.intStackSize]);
         class81.intStack[++class278.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 2701) {
         var3 = ItemLayer.method2454(class81.intStack[--class278.intStackSize]);
         if(var3.itemId != -1) {
            class81.intStack[++class278.intStackSize - 1] = var3.itemQuantity;
         } else {
            class81.intStack[++class278.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2702) {
         int var5 = class81.intStack[--class278.intStackSize];
         WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var5);
         if(var4 != null) {
            class81.intStack[++class278.intStackSize - 1] = 1;
         } else {
            class81.intStack[++class278.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2706) {
         class81.intStack[++class278.intStackSize - 1] = Client.widgetRoot;
         return 1;
      } else {
         return 2;
      }
   }
}
