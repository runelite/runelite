import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -821412405
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1939000029
   )
   @Export("y")
   int y;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1211508383
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 596425325
   )
   @Export("rotation")
   int rotation;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1418759609
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 690610263
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1457049359
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("f")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1545958619
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 336251293
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked = 0;
   @ObfuscatedName("a")
   @Export("renderable2")
   public Renderable renderable2;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2121911469"
   )
   static void method1977() {
      FileOnDisk var0 = null;

      try {
         var0 = class60.method1204("", Client.field413.field2683, true);
         Buffer var1 = WallObject.field1551.method685();
         var0.method1468(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(null != var0) {
            var0.method1471();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-46"
   )
   public static boolean method1978(char var0) {
      return var0 >= 48 && var0 <= 57;
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "1048622472"
   )
   static final void method1979(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method1979(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2428((long)var3.id);
               if(var4 != null) {
                  class88.method1936(var4.id, var1);
               }
            }

            class18 var5;
            if(var1 == 0 && var3.field2197 != null) {
               var5 = new class18();
               var5.field185 = var3;
               var5.field197 = var3.field2197;
               class97.method1988(var5);
            }

            if(var1 == 1 && null != var3.field2304) {
               if(var3.index >= 0) {
                  Widget var6 = class140.method2681(var3.id);
                  if(var6 == null || null == var6.children || var3.index >= var6.children.length || var6.children[var3.index] != var3) {
                     continue;
                  }
               }

               var5 = new class18();
               var5.field185 = var3;
               var5.field197 = var3.field2304;
               class97.method1988(var5);
            }
         }
      }

   }
}
