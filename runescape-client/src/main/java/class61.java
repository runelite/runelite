import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("bp")
public final class class61 {
   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   static Font field765;
   @ObfuscatedName("j")
   @Export("tileHeights")
   static int[][][] tileHeights;
   @ObfuscatedName("h")
   @Export("tileSettings")
   static byte[][][] tileSettings;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1615433323
   )
   static int field761;
   @ObfuscatedName("t")
   static final int[] field767;
   @ObfuscatedName("y")
   static final int[] field770;
   @ObfuscatedName("z")
   static final int[] field769;
   @ObfuscatedName("u")
   static final int[] field772;
   @ObfuscatedName("k")
   static final int[] field771;
   @ObfuscatedName("q")
   static final int[] field781;
   @ObfuscatedName("bp")
   static String field777;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -349839355
   )
   static int field773;
   @ObfuscatedName("az")
   protected static String field778;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 94700675
   )
   static int field774;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 221973413
   )
   static int field759;
   @ObfuscatedName("p")
   @Export("underlayIds")
   static byte[][][] underlayIds;
   @ObfuscatedName("x")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("g")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("c")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("l")
   static byte[][][] field784;
   @ObfuscatedName("b")
   @Export("blendedHue")
   static int[] blendedHue;
   @ObfuscatedName("qb")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   static class13 field779;

   static {
      tileHeights = new int[4][105][105];
      tileSettings = new byte[4][104][104];
      field761 = 99;
      field767 = new int[]{1, 2, 4, 8};
      field770 = new int[]{16, 32, 64, 128};
      field769 = new int[]{1, 0, -1, 0};
      field772 = new int[]{0, -1, 0, 1};
      field771 = new int[]{1, -1, -1, 1};
      field781 = new int[]{-1, -1, 1, 1};
      field773 = (int)(Math.random() * 17.0D) - 8;
      field774 = (int)(Math.random() * 33.0D) - 16;
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      signature = "([Lhi;IB)V",
      garbageValue = "121"
   )
   static final void method1116(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !Renderable.method2896(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && Renderable.method2896(var3) && var3 != class2.field12) {
                  continue;
               }

               method1116(var0, var3.id);
               if(var3.children != null) {
                  method1116(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var7 != null) {
                  var5 = var7.id;
                  if(Ignore.loadWidget(var5)) {
                     method1116(class176.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2775 != -1 || var3.field2713 != -1) {
                  boolean var4 = class170.method3142(var3);
                  if(var4) {
                     var5 = var3.field2713;
                  } else {
                     var5 = var3.field2775;
                  }

                  if(var5 != -1) {
                     Sequence var6 = PendingSpawn.getAnimation(var5);

                     for(var3.field2747 += Client.field957; var3.field2747 > var6.frameLenghts[var3.field2771]; class90.method1723(var3)) {
                        var3.field2747 -= var6.frameLenghts[var3.field2771];
                        ++var3.field2771;
                        if(var3.field2771 >= var6.frameIDs.length) {
                           var3.field2771 -= var6.frameStep;
                           if(var3.field2771 < 0 || var3.field2771 >= var6.frameIDs.length) {
                              var3.field2771 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2705 != 0 && !var3.hasScript) {
                  int var8 = var3.field2705 >> 16;
                  var5 = var3.field2705 << 16 >> 16;
                  var8 *= Client.field957;
                  var5 *= Client.field957;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class90.method1723(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-363614385"
   )
   static final void method1115() {
      if(Client.field1153 != class35.plane) {
         Client.field1153 = class35.plane;
         class83.method1623(class35.plane);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-2121386496"
   )
   static Class method1118(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(Lhi;III)V",
      garbageValue = "-9690690"
   )
   static final void method1117(Widget var0, int var1, int var2) {
      if(Client.field1107 == null && !Client.isMenuOpen) {
         if(var0 != null && class66.method1141(var0) != null) {
            Client.field1107 = var0;
            Client.field1173 = class66.method1141(var0);
            Client.field1101 = var1;
            Client.field1102 = var2;
            class48.field621 = 0;
            Client.field1110 = false;
            int var3 = Client.menuOptionCount - 1;
            if(var3 != -1) {
               class17.field318 = new class90();
               class17.field318.field1408 = Client.menuActionParams0[var3];
               class17.field318.field1406 = Client.menuActionParams1[var3];
               class17.field318.field1407 = Client.menuTypes[var3];
               class17.field318.field1409 = Client.menuIdentifiers[var3];
               class17.field318.field1411 = Client.menuOptions[var3];
            }

         }
      }
   }
}
