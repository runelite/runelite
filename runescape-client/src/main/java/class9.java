import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public final class class9 {
   @ObfuscatedName("ma")
   static byte field75;
   @ObfuscatedName("kr")
   @Export("chatMessages")
   static ChatMessages chatMessages;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = 220504469
   )
   static int field78;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 1855052975
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("e")
   static int[] field83;

   class9() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "1789069987"
   )
   static final void method97(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !ISAACCipher.method3124(var3))) {
            if(var3.type == 0) {
               if(!var3.hasScript && ISAACCipher.method3124(var3) && class152.field2085 != var3) {
                  continue;
               }

               method97(var0, var3.id);
               if(null != var3.children) {
                  method97(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2417((long)var3.id);
               if(null != var4) {
                  class148.method2833(var4.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2266 != -1 || var3.field2276 != -1) {
                  boolean var7 = class161.method3138(var3);
                  if(var7) {
                     var5 = var3.field2276;
                  } else {
                     var5 = var3.field2266;
                  }

                  if(var5 != -1) {
                     Sequence var6 = Friend.getAnimation(var5);

                     for(var3.field2342 += Client.field511; var3.field2342 > var6.frameLenghts[var3.field2344]; class22.method197(var3)) {
                        var3.field2342 -= var6.frameLenghts[var3.field2344];
                        ++var3.field2344;
                        if(var3.field2344 >= var6.frameIDs.length) {
                           var3.field2344 -= var6.frameStep;
                           if(var3.field2344 < 0 || var3.field2344 >= var6.frameIDs.length) {
                              var3.field2344 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2275 != 0 && !var3.hasScript) {
                  int var8 = var3.field2275 >> 16;
                  var5 = var3.field2275 << 16 >> 16;
                  var8 *= Client.field511;
                  var5 *= Client.field511;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class22.method197(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass184;",
      garbageValue = "-635142358"
   )
   static class184 method98(int var0, boolean var1, boolean var2, boolean var3) {
      class116 var4 = null;
      if(null != class104.field1713) {
         var4 = new class116(var0, class104.field1713, WidgetNode.field186[var0], 1000000);
      }

      return new class184(var4, World.field695, var0, var1, var2, var3);
   }
}
