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
         int var7;
         for(var6 = 0; var6 < '耀'; ++var6) {
            NPC var8 = Client.cachedNPCs[var6];
            if(var8 != null) {
               for(var7 = 0; var7 < 10; ++var7) {
                  var8.pathX[var7] -= var4;
                  var8.pathY[var7] -= var5;
               }

               var8.x -= var4 * 128;
               var8.y -= var5 * 128;
            }
         }

         for(var6 = 0; var6 < 2048; ++var6) {
            Player var19 = Client.cachedPlayers[var6];
            if(var19 != null) {
               for(var7 = 0; var7 < 10; ++var7) {
                  var19.pathX[var7] -= var4;
                  var19.pathY[var7] -= var5;
               }

               var19.x -= var4 * 128;
               var19.y -= 128 * var5;
            }
         }

         byte var20 = 0;
         byte var9 = 104;
         byte var10 = 1;
         if(var4 < 0) {
            var20 = 103;
            var9 = -1;
            var10 = -1;
         }

         byte var11 = 0;
         byte var12 = 104;
         byte var13 = 1;
         if(var5 < 0) {
            var11 = 103;
            var12 = -1;
            var13 = -1;
         }

         int var14;
         for(int var15 = var20; var15 != var9; var15 += var10) {
            for(var14 = var11; var14 != var12; var14 += var13) {
               int var16 = var4 + var15;
               int var17 = var5 + var14;

               for(int var18 = 0; var18 < 4; ++var18) {
                  if(var16 >= 0 && var17 >= 0 && var16 < 104 && var17 < 104) {
                     Client.groundItemDeque[var18][var15][var14] = Client.groundItemDeque[var18][var16][var17];
                  } else {
                     Client.groundItemDeque[var18][var15][var14] = null;
                  }
               }
            }
         }

         for(class25 var21 = (class25)Client.field545.method2391(); var21 != null; var21 = (class25)Client.field545.method2393()) {
            var21.field568 -= var4;
            var21.field569 -= var5;
            if(var21.field568 < 0 || var21.field569 < 0 || var21.field568 >= 104 || var21.field569 >= 104) {
               var21.unlink();
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

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].method2229();
         }
      }

   }

   public void run() {
      for(; this.field218; VertexNormal.method1598(50L)) {
         Object var1 = this.field213;
         Object var2 = this.field213;
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
