import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("WorldComparator")
final class WorldComparator implements Comparator {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -1242510738399371395L
   )
   @Export("currentTimeMsLast")
   static long currentTimeMsLast;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Llv;"
   )
   static IndexedSprite field259;
   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static Widget field258;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ls;Ls;I)I",
      garbageValue = "-864073000"
   )
   int method56(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.world < var2.world?-1:(var2.world == var1.world?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method56((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Ldx;",
      garbageValue = "-1173678231"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class29.field387, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(UnitPriceComparator.field297 == 33) {
         var4 = "_rc";
      } else if(UnitPriceComparator.field297 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(Occluder.userHome, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1598551532"
   )
   static final void method66(int var0, int var1, int var2, int var3) {
      if(Client.cursorState == 1) {
         class25.crossSprites[Client.field911 / 100].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
      }

      if(Client.cursorState == 2) {
         class25.crossSprites[Client.field911 / 100 + 4].drawAt(Client.lastLeftClickX - 8, Client.lastLeftClickY - 8);
      }

      class29.method270();
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-1"
   )
   static final void method67(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         class47.menuAction(var1, var2, var3, var4, var5, var6, MouseInput.mouseLastPressedX, MouseInput.mouseLastPressedY);
      }
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "2"
   )
   static final int method62() {
      return Client.menuOptionCount - 1;
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1165314846"
   )
   static String method71(int var0) {
      return var0 < 0?"":(Client.menuTargets[var0].length() > 0?Client.menuOptions[var0] + " " + Client.menuTargets[var0]:Client.menuOptions[var0]);
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "(Lim;III)V",
      garbageValue = "228451156"
   )
   static void method55(Widget var0, int var1, int var2) {
      if(var0.dynamicX == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.dynamicX == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.dynamicX == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.dynamicX == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.dynamicX == 4) {
         var0.relativeX = (var0.originalX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.dynamicY == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.dynamicY == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.dynamicY == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.dynamicY == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.dynamicY == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var2 * var0.originalY >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field1000 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }
}
