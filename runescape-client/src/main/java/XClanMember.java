import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("x")
   @Export("username")
   String username;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -255976437
   )
   @Export("world")
   int world;
   @ObfuscatedName("n")
   String field275;
   @ObfuscatedName("v")
   @Export("rank")
   byte rank;
   @ObfuscatedName("q")
   static String field278;

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-1708188391"
   )
   static final void method259(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(null != var3 && var1 == var3.parentId && (!var3.hasScript || !class9.method114(var3))) {
            if(var3.type == 0) {
               if(!var3.hasScript && class9.method114(var3) && var3 != class45.field924) {
                  continue;
               }

               method259(var0, var3.id);
               if(var3.children != null) {
                  method259(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2437((long)var3.id);
               if(var4 != null) {
                  Tile.method1642(var4.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2233 != -1 || var3.field2254 != -1) {
                  boolean var7 = class183.method3442(var3);
                  if(var7) {
                     var5 = var3.field2254;
                  } else {
                     var5 = var3.field2233;
                  }

                  if(var5 != -1) {
                     Sequence var6 = TextureProvider.getAnimation(var5);

                     for(var3.field2329 += Client.field365; var3.field2329 > var6.frameLenghts[var3.field2328]; ChatLineBuffer.method996(var3)) {
                        var3.field2329 -= var6.frameLenghts[var3.field2328];
                        ++var3.field2328;
                        if(var3.field2328 >= var6.frameIDs.length) {
                           var3.field2328 -= var6.frameStep;
                           if(var3.field2328 < 0 || var3.field2328 >= var6.frameIDs.length) {
                              var3.field2328 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2324 != 0 && !var3.hasScript) {
                  int var8 = var3.field2324 >> 16;
                  var5 = var3.field2324 << 16 >> 16;
                  var8 *= Client.field365;
                  var5 *= Client.field365;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  ChatLineBuffer.method996(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(Lclass25;I)V",
      garbageValue = "1856018694"
   )
   static final void method260(class25 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field585 == 0) {
         var1 = Friend.region.method1815(var0.field581, var0.field577, var0.field578);
      }

      if(var0.field585 == 1) {
         var1 = Friend.region.method1966(var0.field581, var0.field577, var0.field578);
      }

      if(var0.field585 == 2) {
         var1 = Friend.region.method1925(var0.field581, var0.field577, var0.field578);
      }

      if(var0.field585 == 3) {
         var1 = Friend.region.method1831(var0.field581, var0.field577, var0.field578);
      }

      if(var1 != 0) {
         int var5 = Friend.region.method1924(var0.field581, var0.field577, var0.field578, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field579 = var2;
      var0.field576 = var3;
      var0.field580 = var4;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-502037959"
   )
   static final boolean method261(int var0, int var1) {
      ObjectComposition var2 = ChatMessages.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method3664(var1);
   }
}
