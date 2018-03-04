import java.awt.Component;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
final class class19 implements Comparator {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static IndexedSprite field328;
   @ObfuscatedName("x")
   static int[] field327;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;I)I",
      garbageValue = "-39617309"
   )
   int method139(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.field289 < var2.field289?-1:(var2.field289 == var1.field289?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method139((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1670818136"
   )
   static void method148(Component var0) {
      var0.removeMouseListener(MouseInput.mouse);
      var0.removeMouseMotionListener(MouseInput.mouse);
      var0.removeFocusListener(MouseInput.mouse);
      MouseInput.MouseHandler_currentButton = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1078327855"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      Projectile.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1599223296"
   )
   @Export("ilog")
   public static int ilog(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Llv;",
      garbageValue = "-713586013"
   )
   static IndexedSprite method140() {
      IndexedSprite var0 = new IndexedSprite();
      var0.width = class332.field3995;
      var0.originalHeight = class332.field3991;
      var0.offsetX = class332.field3990[0];
      var0.offsetY = class332.offsetsY[0];
      var0.originalWidth = Varbit.field3539[0];
      var0.height = BoundingBox2D.field242[0];
      var0.palette = class332.field3994;
      var0.pixels = class332.spritePixels[0];
      class151.method3208();
      return var0;
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "([Liw;II)V",
      garbageValue = "1695441799"
   )
   static final void method141(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !class236.method4476(var3))) {
            if(var3.type == 0) {
               if(!var3.hasScript && class236.method4476(var3) && var3 != class45.field579) {
                  continue;
               }

               method141(var0, var3.id);
               if(var3.children != null) {
                  method141(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  class204.method3928(var4.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2820 != -1 || var3.field2873 != -1) {
                  boolean var7 = WorldMapManager.method562(var3);
                  if(var7) {
                     var5 = var3.field2873;
                  } else {
                     var5 = var3.field2820;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class270.getAnimation(var5);

                     for(var3.field2948 += Client.field914; var3.field2948 > var6.frameLenghts[var3.field2947]; class171.method3363(var3)) {
                        var3.field2948 -= var6.frameLenghts[var3.field2947];
                        ++var3.field2947;
                        if(var3.field2947 >= var6.frameIDs.length) {
                           var3.field2947 -= var6.frameStep;
                           if(var3.field2947 < 0 || var3.field2947 >= var6.frameIDs.length) {
                              var3.field2947 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2881 != 0 && !var3.hasScript) {
                  int var8 = var3.field2881 >> 16;
                  var5 = var3.field2881 << 16 >> 16;
                  var8 *= Client.field914;
                  var5 *= Client.field914;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class171.method3363(var3);
               }
            }
         }
      }

   }
}
