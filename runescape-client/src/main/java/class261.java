import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("jz")
public class class261 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   public static final class261 field3628;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   public static final class261 field3634;
   @ObfuscatedName("ay")
   static java.awt.Font field3631;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   public static final class261 field3622;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   public static final class261 field3627;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   public static final class261 field3623;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   public static final class261 field3624;
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = 1921213987
   )
   public static int field3630;
   @ObfuscatedName("p")
   final String field3625;
   @ObfuscatedName("e")
   String field3629;

   static {
      field3634 = new class261("PLAIN11", "p11_full");
      field3623 = new class261("PLAIN12", "p12_full");
      field3624 = new class261("BOLD12", "b12_full");
      field3628 = new class261("VERDANA11", "verdana_11pt_regular");
      field3622 = new class261("VERDANA13", "verdana_13pt_regular");
      field3627 = new class261("VERDANA15", "verdana_15pt_regular");
   }

   class261(String var1, String var2) {
      this.field3625 = var1;
      this.field3629 = var2;
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(IIIZB)V",
      garbageValue = "1"
   )
   static final void method4814(int var0, int var1, int var2, boolean var3) {
      if(WorldMapData.loadWidget(var0)) {
         class43.method614(class215.widgets[var0], -1, var1, var2, var3);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lip;IIB)Z",
      garbageValue = "-74"
   )
   public static boolean method4822(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class93.decodeSprite(var3);
         return true;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)[Ljz;",
      garbageValue = "-1187394211"
   )
   public static class261[] method4816() {
      return new class261[]{field3628, field3622, field3624, field3623, field3627, field3634};
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1056693131"
   )
   static void method4821(String var0) {
      Timer.sessionToken = var0;

      try {
         String var1 = class7.clientInstance.getParameter(Parameters.field3721.key);
         String var2 = class7.clientInstance.getParameter(Parameters.field3726.key);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         String var5;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            String var4 = var3 + "; Expires=";
            long var6 = class174.currentTimeMs() + 94608000000L;
            class182.field2438.setTime(new Date(var6));
            int var8 = class182.field2438.get(7);
            int var9 = class182.field2438.get(5);
            int var10 = class182.field2438.get(2);
            int var11 = class182.field2438.get(1);
            int var12 = class182.field2438.get(11);
            int var13 = class182.field2438.get(12);
            int var14 = class182.field2438.get(13);
            var5 = class182.field2439[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + class182.field2436[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
            var3 = var4 + var5 + "; Max-Age=" + 94608000L;
         }

         Client var16 = class7.clientInstance;
         var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var16).eval(var5);
      } catch (Throwable var15) {
         ;
      }

   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "565655185"
   )
   static final void method4815() {
      for(Projectile var0 = (Projectile)Client.projectiles.getFront(); var0 != null; var0 = (Projectile)Client.projectiles.getNext()) {
         if(var0.floor == class46.plane && Client.gameCycle <= var0.cycle) {
            if(Client.gameCycle >= var0.startTime) {
               if(var0.interacting > 0) {
                  NPC var1 = Client.cachedNPCs[var0.interacting - 1];
                  if(var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.method1777(var1.x, var1.y, class41.getTileHeight(var1.x, var1.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               if(var0.interacting < 0) {
                  int var2 = -var0.interacting - 1;
                  Player var3;
                  if(var2 == Client.localInteractingIndex) {
                     var3 = class66.localPlayer;
                  } else {
                     var3 = Client.cachedPlayers[var2];
                  }

                  if(var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.method1777(var3.x, var3.y, class41.getTileHeight(var3.x, var3.y, var0.floor) - var0.endHeight, Client.gameCycle);
                  }
               }

               var0.method1778(Client.field1004);
               class3.region.method2718(class46.plane, (int)var0.x, (int)var0.velocityZ, (int)var0.z, 60, var0, var0.rotationX, -1, false);
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1761706863"
   )
   static int method4820(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }
}
