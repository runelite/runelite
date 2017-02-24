import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 906787017
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("ar")
   static class110 field907;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1041544025
   )
   @Export("id")
   int id;

   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "-1849890498"
   )
   static String method876(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field305 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field305 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field305 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field305 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field305 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(Client.field310 != null) {
         var3 = "/p=" + Client.field310;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field309 + "/a=" + class11.field133 + var3 + "/";
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "286397846"
   )
   protected final Model getModel() {
      return class103.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass159;B)V",
      garbageValue = "-20"
   )
   static final void method879(class159 var0) {
      var0.method3072();
      int var1 = Client.localInteractingIndex;
      Player var2 = class36.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field255 = var1;
      int var3 = var0.method3095(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class5.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method227() << 6);
      var2.pathY[0] = var6 - XClanMember.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method227() << 6);
      WallObject.plane = var2.field277 = var4;
      if(class45.field920[var1] != null) {
         var2.method226(class45.field920[var1]);
      }

      class45.field921 = 0;
      class45.field931[++class45.field921 - 1] = var1;
      class45.field918[var1] = 0;
      class45.field929 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.method3095(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class45.field925[var7] = var11 + (var10 << 14) + (var9 << 28);
            class45.field926[var7] = 0;
            class45.field927[var7] = -1;
            class45.field924[++class45.field929 - 1] = var7;
            class45.field918[var7] = 0;
         }
      }

      var0.method3074();
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "83"
   )
   static final String method880(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }
}
