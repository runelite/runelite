import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class20 implements Runnable {
   @ObfuscatedName("x")
   Object field213 = new Object();
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1939524313
   )
   int field214 = 0;
   @ObfuscatedName("a")
   int[] field215 = new int[500];
   @ObfuscatedName("f")
   int[] field216 = new int[500];
   @ObfuscatedName("u")
   boolean field218 = true;
   @ObfuscatedName("ri")
   protected static boolean field219;
   @ObfuscatedName("hk")
   @ObfuscatedGetter(
      intValue = -1844226871
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("z")
   static int[] field221;
   @ObfuscatedName("nd")
   static class51 field222;

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1507253848"
   )
   static final void method190(int var0, int var1) {
      if(MessageNode.field231 != var0 || var1 != XGrandExchangeOffer.field31) {
         MessageNode.field231 = var0;
         XGrandExchangeOffer.field31 = var1;
         Friend.setGameState(25);
         VertexNormal.method1599("Loading - please wait.", true);
         int var2 = FrameMap.baseX;
         int var3 = XItemContainer.baseY;
         FrameMap.baseX = (var0 - 6) * 8;
         XItemContainer.baseY = (var1 - 6) * 8;
         int var4 = FrameMap.baseX - var2;
         int var5 = XItemContainer.baseY - var3;
         var2 = FrameMap.baseX;
         var3 = XItemContainer.baseY;

         int var6;
         int var8;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var7 = Client.cachedNPCs[var6];
            if(var7 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var7.pathX[var8] -= var4;
                  var7.pathY[var8] -= var5;
               }

               var7.x -= var4 * 128;
               var7.y -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var20 = Client.cachedPlayers[var6];
            if(var20 != null) {
               for(var8 = 0; var8 < 10; ++var8) {
                  var20.pathX[var8] -= var4;
                  var20.pathY[var8] -= var5;
               }

               var20.x -= var4 * 128;
               var20.y -= 128 * var5;
            }
         }

         byte var19 = 0;
         byte var18 = 104;
         byte var21 = 1;
         if(var4 < 0) {
            var19 = 103;
            var18 = -1;
            var21 = -1;
         }

         byte var9 = 0;
         byte var10 = 104;
         byte var11 = 1;
         if(var5 < 0) {
            var9 = 103;
            var10 = -1;
            var11 = -1;
         }

         int var13;
         for(int var17 = var19; var17 != var18; var17 += var21) {
            for(var13 = var9; var13 != var10; var13 += var11) {
               int var14 = var4 + var17;
               int var15 = var5 + var13;

               for(int var16 = 0; var16 < 4; ++var16) {
                  if(var14 >= 0 && var15 >= 0 && var14 < 104 && var15 < 104) {
                     Client.groundItemDeque[var16][var17][var13] = Client.groundItemDeque[var16][var14][var15];
                  } else {
                     Client.groundItemDeque[var16][var17][var13] = null;
                  }
               }
            }
         }

         for(class25 var12 = (class25)Client.field545.method2391(); var12 != null; var12 = (class25)Client.field545.method2393()) {
            var12.field568 -= var4;
            var12.field569 -= var5;
            if(var12.field568 < 0 || var12.field569 < 0 || var12.field568 >= 104 || var12.field569 >= 104) {
               var12.unlink();
            }
         }

         if(Client.flagX != 0) {
            Client.flagX -= var4;
            Client.flagY -= var5;
         }

         Client.field516 = 0;
         Client.field529 = false;
         Client.field359 = -1;
         Client.field405.method2385();
         Client.projectiles.method2385();

         for(var13 = 0; var13 < 4; ++var13) {
            Client.collisionMaps[var13].method2229();
         }

      }
   }

   public void run() {
      for(; this.field218; VertexNormal.method1598(50L)) {
         Object var1 = this.field213;
         synchronized(this.field213) {
            if(this.field214 < 500) {
               this.field215[this.field214] = class115.field1788;
               this.field216[this.field214] = class115.field1789;
               ++this.field214;
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "605983678"
   )
   public static boolean method193() {
      return class138.field1900 != 0?true:class138.field1899.method2484();
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(IIII)LWidgetNode;",
      garbageValue = "-1707971283"
   )
   static final WidgetNode method194(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field182 = var2;
      Client.componentTable.method2340(var3, (long)var0);
      class157.method3024(var1);
      Widget var4 = class44.method799(var0);
      class6.method87(var4);
      if(null != Client.field537) {
         class6.method87(Client.field537);
         Client.field537 = null;
      }

      class101.method1909();
      class6.method97(Widget.widgets[var0 >> 16], var4, false);
      class18.method186(var1);
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class94.method1870(var5)) {
            class140.method2607(Widget.widgets[var5], 1);
         }
      }

      return var3;
   }
}
