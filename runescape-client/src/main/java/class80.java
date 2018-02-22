import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
public class class80 {
   @ObfuscatedName("o")
   @Export("scriptLocalInts")
   static int[] scriptLocalInts;
   @ObfuscatedName("p")
   @Export("scriptLocalStrings")
   static String[] scriptLocalStrings;
   @ObfuscatedName("a")
   static int[] field1221;
   @ObfuscatedName("h")
   @Export("SHAPE_VERTICES")
   static int[][] SHAPE_VERTICES;
   @ObfuscatedName("l")
   @Export("intStack")
   static int[] intStack;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1885914111
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("g")
   @Export("scriptStringStack")
   static String[] scriptStringStack;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2029414653
   )
   @Export("scriptStackCount")
   static int scriptStackCount;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "[Lbt;"
   )
   @Export("scriptStack")
   static ScriptState[] scriptStack;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static Widget field1228;
   @ObfuscatedName("s")
   static Calendar field1229;
   @ObfuscatedName("t")
   static final String[] field1223;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1174421717
   )
   static int field1231;
   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;

   static {
      field1221 = new int[5];
      SHAPE_VERTICES = new int[5][5000];
      intStack = new int[1000];
      scriptStringStack = new String[1000];
      scriptStackCount = 0;
      scriptStack = new ScriptState[50];
      field1229 = Calendar.getInstance();
      field1223 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
      field1231 = 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILev;[Lfq;B)V",
      garbageValue = "-17"
   )
   static final void method1814(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.getUSmart();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.getUSmart();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               ObjectComposition var21 = Preferences.getObjectDefinition(var11);
               int var24 = var16 & 7;
               int var25 = var15 & 7;
               int var27 = var21.width;
               int var28 = var21.length;
               int var29;
               if((var20 & 1) == 1) {
                  var29 = var27;
                  var27 = var28;
                  var28 = var29;
               }

               int var26 = var7 & 3;
               int var23;
               if(var26 == 0) {
                  var23 = var24;
               } else if(var26 == 1) {
                  var23 = var25;
               } else if(var26 == 2) {
                  var23 = 7 - var24 - (var27 - 1);
               } else {
                  var23 = 7 - var25 - (var28 - 1);
               }

               var29 = var2 + var23;
               int var32 = var16 & 7;
               int var33 = var15 & 7;
               int var35 = var21.width;
               int var36 = var21.length;
               int var37;
               if((var20 & 1) == 1) {
                  var37 = var35;
                  var35 = var36;
                  var36 = var37;
               }

               int var34 = var7 & 3;
               int var31;
               if(var34 == 0) {
                  var31 = var33;
               } else if(var34 == 1) {
                  var31 = 7 - var32 - (var35 - 1);
               } else if(var34 == 2) {
                  var31 = 7 - var33 - (var36 - 1);
               } else {
                  var31 = var32;
               }

               var37 = var3 + var31;
               if(var29 > 0 && var37 > 0 && var29 < 103 && var37 < 103) {
                  int var38 = var1;
                  if((class61.tileSettings[1][var29][var37] & 2) == 2) {
                     var38 = var1 - 1;
                  }

                  CollisionData var39 = null;
                  if(var38 >= 0) {
                     var39 = var9[var38];
                  }

                  class19.addObject(var1, var29, var37, var11, var20 + var7 & 3, var19, var8, var39);
               }
            }
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILca;ZB)I",
      garbageValue = "-37"
   )
   static int method1815(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = NetWriter.getWidget(intStack[--intStackSize]);
      } else {
         var3 = var2?class223.field2643:field1228;
      }

      ScriptEvent.method1132(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = intStack[--intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = OwnWorldComparator.localPlayer.composition.method4400();
            return 1;
         } else {
            return 2;
         }
      } else {
         intStackSize -= 2;
         int var4 = intStack[intStackSize];
         int var5 = intStack[intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = ContextMenuRow.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2835 = var6.offsetX2d;
         var3.field2795 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2858 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2858 = 1;
         } else {
            var3.field2858 = 2;
         }

         if(var3.field2832 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2832;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }
}
