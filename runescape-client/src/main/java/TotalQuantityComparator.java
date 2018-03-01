import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("TotalQuantityComparator")
final class TotalQuantityComparator implements Comparator {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   static IndexDataBase field304;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   @Export("currentRequest")
   public static FileRequest currentRequest;
   @ObfuscatedName("ap")
   static int[] field299;
   @ObfuscatedName("fr")
   @Export("landRegionFileIds")
   static int[] landRegionFileIds;
   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "Lbd;"
   )
   @Export("localPlayer")
   static Player localPlayer;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;B)I",
      garbageValue = "70"
   )
   int method95(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity?-1:(var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method95((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZB)V",
      garbageValue = "17"
   )
   public static void method98(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class57.field668.startsWith("win")) {
            class266.method4851(var0, 0, "openjs");
         } else if(class57.field668.startsWith("mac")) {
            class266.method4851(var0, 1, "openjs");
         } else {
            class266.method4851(var0, 2, "openjs");
         }
      } else {
         class266.method4851(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lbq;B)V",
      garbageValue = "10"
   )
   static void method99(World var0) {
      if(var0.method1653() != Client.isMembers) {
         Client.isMembers = var0.method1653();
         boolean var1 = var0.method1653();
         if(var1 != ItemComposition.isMembersWorld) {
            class20.method152();
            ItemComposition.isMembersWorld = var1;
         }
      }

      BoundingBox.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class233.port1 = Client.socketType == 0?43594:var0.id + 40000;
      class44.port2 = Client.socketType == 0?443:var0.id + 50000;
      class247.myWorldPort = class233.port1;
   }
}
