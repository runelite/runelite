import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
final class class17 implements Comparator {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1370548867
   )
   static int field299;
   @ObfuscatedName("em")
   @ObfuscatedGetter(
      intValue = -1122846647
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("af")
   @Export("authCode")
   static String authCode;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;I)I",
      garbageValue = "508840192"
   )
   int method116(class14 var1, class14 var2) {
      return var1.field279.price < var2.field279.price?-1:(var2.field279.price == var1.field279.price?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method116((class14)var1, (class14)var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Lhe;",
      garbageValue = "-1080831267"
   )
   public static BuildType[] method120() {
      return new BuildType[]{BuildType.BUILD_LIVE, BuildType.LIVE, BuildType.WIP, BuildType.RC};
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILhh;I)I",
      garbageValue = "8680744"
   )
   public static int method118(int var0, class219 var1) {
      return (var0 << 8) + var1.field2776;
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-154947727"
   )
   static final void method123(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class170.preferences.hideRoofs = !class170.preferences.hideRoofs;
         Projectile.method1762();
         if(class170.preferences.hideRoofs) {
            class202.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            class202.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.displayFps = !Client.displayFps;
      }

      if(var0.equalsIgnoreCase("clickbox")) {
         Model.field1938 = !Model.field1938;
         class202.sendGameMessage(99, "", "Clickbox Mode: " + (Model.field1938?"AABB":"Legacy"));
      }

      if(Client.rights >= 2) {
         if(var0.equalsIgnoreCase("aabb")) {
            if(!class7.field228) {
               class7.field228 = true;
               class7.field227 = class11.field252;
               class202.sendGameMessage(99, "", "AABB boxes: All");
            } else if(class7.field227 == class11.field252) {
               class7.field228 = true;
               class7.field227 = class11.field256;
               class202.sendGameMessage(99, "", "AABB boxes: Mouse Over");
            } else {
               class7.field228 = false;
               class202.sendGameMessage(99, "", "AABB boxes: Off");
            }
         }

         if(var0.equalsIgnoreCase("legacyboxes")) {
            class7.field225 = !class7.field225;
            class202.sendGameMessage(99, "", "Show legacy boxes: " + class7.field225);
         }

         if(var0.equalsIgnoreCase("geotests")) {
            class7.field230 = !class7.field230;
            class202.sendGameMessage(99, "", "Show geometry tests: " + class7.field230);
         }

         if(var0.equalsIgnoreCase("fpson")) {
            Client.displayFps = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.displayFps = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            if(Client.field946 > 0) {
               class51.method792();
            } else {
               class2.setGameState(40);
               NPC.field1339 = CacheFile.rssocket;
               CacheFile.rssocket = null;
            }
         }

         if(var0.equalsIgnoreCase("errortest") && Client.socketType == 2) {
            throw new RuntimeException();
         }
      }

      Client.secretPacketBuffer1.putOpcode(66);
      Client.secretPacketBuffer1.putByte(var0.length() + 1);
      Client.secretPacketBuffer1.putString(var0);
   }
}
