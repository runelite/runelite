import java.applet.Applet;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public final class class31 extends Node {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1041993871
   )
   int field721;
   @ObfuscatedName("a")
   static int[] field722;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -420368487
   )
   int field723;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -627640609
   )
   int field724;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2035149615
   )
   int field725;
   @ObfuscatedName("ee")
   static SpritePixels[] field726;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 954086027
   )
   int field727;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1134904703
   )
   int field728;
   @ObfuscatedName("o")
   class66 field729;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1412201411
   )
   int field730;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -869092075
   )
   int field731;
   @ObfuscatedName("u")
   int[] field732;
   @ObfuscatedName("q")
   static Deque field733 = new Deque();
   @ObfuscatedName("v")
   class66 field734;
   @ObfuscatedName("r")
   ObjectComposition field735;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -422773119
   )
   int field736;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1018777063
   )
   int field737;
   @ObfuscatedName("dc")
   static byte[][] field738;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -445951465
   )
   static int field739;
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = -2054288477
   )
   static int field740;
   @ObfuscatedName("en")
   static ModIcon[] field741;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
      garbageValue = "-125"
   )
   public static void method704(Applet var0, String var1) {
      class114.field1789 = var0;
      class114.field1791 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "9"
   )
   void method707() {
      int var1 = this.field736;
      ObjectComposition var2 = this.field735.getImpostor();
      if(var2 != null) {
         this.field736 = var2.ambientSoundId;
         this.field724 = var2.field2922 * 128;
         this.field728 = var2.field2938;
         this.field731 = var2.field2936;
         this.field732 = var2.field2941;
      } else {
         this.field736 = -1;
         this.field724 = 0;
         this.field728 = 0;
         this.field731 = 0;
         this.field732 = null;
      }

      if(this.field736 != var1 && null != this.field729) {
         class16.field184.method990(this.field729);
         this.field729 = null;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZI)I",
      garbageValue = "1997750473"
   )
   static int method708(int var0, class48 var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class32.field747[--class103.field1686];
         var4 = class179.method3296(var3);
      } else {
         var4 = var2?XGrandExchangeOffer.field58:class24.field297;
      }

      if(var0 == 1000) {
         class103.field1686 -= 4;
         var4.originalX = class32.field747[class103.field1686];
         var4.originalY = class32.field747[class103.field1686 + 1];
         var4.field2291 = class32.field747[class103.field1686 + 2];
         var4.field2217 = class32.field747[class103.field1686 + 3];
         class174.method3276(var4);
         class108.method2105(var4);
         if(var3 != -1 && var4.type == 0) {
            class154.method3034(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class103.field1686 -= 4;
         var4.originalWidth = class32.field747[class103.field1686];
         var4.field2297 = class32.field747[class103.field1686 + 1];
         var4.field2215 = class32.field747[2 + class103.field1686];
         var4.field2312 = class32.field747[3 + class103.field1686];
         class174.method3276(var4);
         class108.method2105(var4);
         if(var3 != -1 && var4.type == 0) {
            class154.method3034(Widget.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class32.field747[--class103.field1686] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class174.method3276(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2232 = class32.field747[--class103.field1686] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2199 = class32.field747[--class103.field1686] == 1;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1981868630"
   )
   static void method709(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.method2399((long)var0);
      if(null == var4) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.method2400(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[1 + var1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "3"
   )
   static final void method710(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field489; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetBoundsHeight[var4] + Client.widgetPositionY[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field426[var4] = true;
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;B)[LSpritePixels;",
      garbageValue = "2"
   )
   public static SpritePixels[] method711(class182 var0, String var1, String var2) {
      int var3 = var0.method3335(var1);
      int var4 = var0.method3319(var3, var2);
      SpritePixels[] var5;
      if(!class94.method1979(var0, var3, var4)) {
         var5 = null;
      } else {
         SpritePixels[] var7 = new SpritePixels[class225.field3232];

         for(int var8 = 0; var8 < class225.field3232; ++var8) {
            SpritePixels var9 = var7[var8] = new SpritePixels();
            var9.maxWidth = class202.field3074;
            var9.maxHeight = class225.field3231;
            var9.offsetX = Ignore.field223[var8];
            var9.offsetY = class225.field3233[var8];
            var9.width = class225.field3234[var8];
            var9.height = class41.field862[var8];
            int var10 = var9.width * var9.height;
            byte[] var11 = class11.field129[var8];
            var9.image = new int[var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               var9.image[var12] = class160.field2146[var11[var12] & 255];
            }
         }

         Actor.method636();
         var5 = var7;
      }

      return var5;
   }
}
