import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("m")
   static class228 field214;
   @ObfuscatedName("be")
   static class184 field215;
   @ObfuscatedName("na")
   @ObfuscatedGetter(
      intValue = -1681682811
   )
   static int field216;
   @ObfuscatedName("n")
   static byte[][][] field219;
   @ObfuscatedName("ao")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("i")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("nu")
   static class51 field224;
   @ObfuscatedName("f")
   @Export("name")
   String name;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;II)V",
      garbageValue = "2032229567"
   )
   static void method176(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class31 var5 = new class31();
      var5.field723 = var0;
      var5.field724 = var1 * 128;
      var5.field725 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field726 = (var6 + var1) * 128;
      var5.field722 = (var7 + var2) * 128;
      var5.field734 = var3.ambientSoundId;
      var5.field728 = var3.field2909 * 128;
      var5.field731 = var3.field2943;
      var5.field727 = var3.field2944;
      var5.field733 = var3.field2939;
      if(var3.impostorIds != null) {
         var5.field729 = var3;
         var5.method665();
      }

      class31.field732.method2459(var5);
      if(null != var5.field733) {
         var5.field730 = var5.field731 + (int)(Math.random() * (double)(var5.field727 - var5.field731));
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;I)V",
      garbageValue = "1560372377"
   )
   static final void method177(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var2 + var9 < 103 && var3 + var10 > 0 && var3 + var10 < 103) {
               var8[var1].flags[var2 + var9][var10 + var3] &= -16777217;
            }
         }
      }

      Buffer var20 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var4 == var10 && var11 >= var5 && var11 < 8 + var5 && var12 >= var6 && var12 < 8 + var6) {
                  int var17 = var11 & 7;
                  int var18 = var12 & 7;
                  int var19 = var7 & 3;
                  int var16;
                  if(var19 == 0) {
                     var16 = var17;
                  } else if(var19 == 1) {
                     var16 = var18;
                  } else if(var19 == 2) {
                     var16 = 7 - var17;
                  } else {
                     var16 = 7 - var18;
                  }

                  TextureProvider.method1489(var20, var1, var16 + var2, var3 + class116.method2313(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  TextureProvider.method1489(var20, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-6358"
   )
   public static boolean method178(int var0) {
      if(class6.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2301.method3385(var0)) {
         return false;
      } else {
         int var1 = Widget.field2301.method3346(var0);
         if(var1 == 0) {
            class6.validInterfaces[var0] = true;
            return true;
         } else {
            if(null == Widget.widgets[var0]) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == Widget.widgets[var0][var2]) {
                  byte[] var3 = Widget.field2301.getConfigData(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3252(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3251(new Buffer(var3));
                     }
                  }
               }
            }

            class6.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1634090795"
   )
   static void method179() {
      XItemContainer.itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1659233389"
   )
   static int method180(int var0, Script var1, boolean var2) {
      Widget var3 = FaceNormal.method1932(class32.field743[--class30.field713]);
      if(var0 == 2500) {
         class32.field743[++class30.field713 - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 2501) {
         class32.field743[++class30.field713 - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 2502) {
         class32.field743[++class30.field713 - 1] = var3.width;
         return 1;
      } else if(var0 == 2503) {
         class32.field743[++class30.field713 - 1] = var3.height;
         return 1;
      } else if(var0 == 2504) {
         class32.field743[++class30.field713 - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 2505) {
         class32.field743[++class30.field713 - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
