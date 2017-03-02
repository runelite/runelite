import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 154082443
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("n")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("gv")
   static Widget field1534;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -746215755
   )
   int field1535;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -19258395
   )
   int field1536;
   @ObfuscatedName("h")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1146564833
   )
   @Export("y")
   int y;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1489129489
   )
   @Export("x")
   int x;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -127039029
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("bk")
   static class184 field1545;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 928437753
   )
   int field1546 = 0;
   @ObfuscatedName("pj")
   static class30 field1551;

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-1285875244"
   )
   static final void method1949(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(null != var3 && var1 == var3.parentId && (!var3.hasScript || !Client.method611(var3))) {
            if(var3.type == 0) {
               if(!var3.hasScript && Client.method611(var3) && class45.field896 != var3) {
                  continue;
               }

               method1949(var0, var3.id);
               if(var3.children != null) {
                  method1949(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2428((long)var3.id);
               if(null != var4) {
                  class180.method3343(var4.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2243 != -1 || var3.field2262 != -1) {
                  boolean var7 = class175.method3328(var3);
                  if(var7) {
                     var5 = var3.field2262;
                  } else {
                     var5 = var3.field2243;
                  }

                  if(var5 != -1) {
                     Sequence var6 = XClanMember.getAnimation(var5);

                     for(var3.field2303 += Client.field477; var3.field2303 > var6.frameLenghts[var3.field2318]; Frames.method1960(var3)) {
                        var3.field2303 -= var6.frameLenghts[var3.field2318];
                        ++var3.field2318;
                        if(var3.field2318 >= var6.frameIDs.length) {
                           var3.field2318 -= var6.frameStep;
                           if(var3.field2318 < 0 || var3.field2318 >= var6.frameIDs.length) {
                              var3.field2318 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2252 != 0 && !var3.hasScript) {
                  int var8 = var3.field2252 >> 16;
                  var5 = var3.field2252 << 16 >> 16;
                  var8 *= Client.field477;
                  var5 *= Client.field477;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  Frames.method1960(var3);
               }
            }
         }
      }

   }
}
