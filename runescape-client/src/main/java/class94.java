import java.awt.Canvas;
import java.awt.Color;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public final class class94 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1385085549
   )
   int field1588;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -371836267
   )
   int field1589;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1298648569
   )
   int field1590;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -5227787
   )
   int field1591;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -468032323
   )
   int field1592;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1940272915
   )
   int field1593;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -675878197
   )
   int field1594;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1161049011
   )
   int field1595;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 44824913
   )
   int field1596;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1755493839
   )
   int field1597;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -699910755
   )
   int field1598;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1689283341
   )
   int field1599;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1998426449
   )
   int field1600;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1801622701
   )
   int field1601;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1627455971
   )
   int field1602;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -331047917
   )
   int field1603;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -397767613
   )
   int field1604;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2136767173
   )
   int field1605;

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "1"
   )
   static final void method1978(boolean var0) {
      int var1 = Client.widgetRoot;
      int var2 = class108.field1748;
      int var3 = class145.field2018;
      if(class44.method892(var1)) {
         class178.method3289(Widget.widgets[var1], -1, var2, var3, var0);
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(LPlayer;III)V",
      garbageValue = "-355501235"
   )
   static void method1979(Player var0, int var1, int var2) {
      if(var1 == var0.animation && var1 != -1) {
         int var3 = class168.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field659 = 0;
            var0.actionAnimationDisable = var2;
            var0.field629 = 0;
         }

         if(var3 == 2) {
            var0.field629 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class168.getAnimation(var1).forcedPriority >= class168.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field659 = 0;
         var0.actionAnimationDisable = var2;
         var0.field629 = 0;
         var0.field636 = var0.field679;
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-409340617"
   )
   static void method1980() {
      XItemContainer.method188(CollisionData.canvas);
      class140.method2659(CollisionData.canvas);
      if(null != FaceNormal.field1575) {
         FaceNormal.field1575.vmethod2142(CollisionData.canvas);
      }

      Client.field308.method2153();
      CollisionData.canvas.setBackground(Color.black);
      Canvas var0 = CollisionData.canvas;
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class105.keyboard);
      var0.addFocusListener(class105.keyboard);
      Canvas var1 = CollisionData.canvas;
      var1.addMouseListener(class115.mouse);
      var1.addMouseMotionListener(class115.mouse);
      var1.addFocusListener(class115.mouse);
      if(FaceNormal.field1575 != null) {
         FaceNormal.field1575.vmethod2141(CollisionData.canvas);
      }

      if(Client.widgetRoot != -1) {
         method1978(false);
      }

      GameEngine.field1789 = true;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1209226619"
   )
   public static int method1981(int var0) {
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

      return var1 + var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "16"
   )
   static final String method1982(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }
}
