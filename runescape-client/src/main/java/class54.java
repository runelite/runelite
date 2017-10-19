import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class54 {
   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "512"
   )
   public static boolean method779(int var0) {
      return var0 == class221.field2824.field2825;
   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1002340331"
   )
   static final void method778(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(WorldMapData.loadWidget(var0)) {
         class64.field807 = null;
         class88.gameDraw(class215.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class64.field807 != null) {
            class88.gameDraw(class64.field807, -1412584499, var1, var2, var3, var4, class43.field593, Friend.field825, var7);
            class64.field807 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field1119[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field1119[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "226214383"
   )
   static void method777() {
      if(Client.spellSelected) {
         Widget var0 = class215.method4064(class56.field696, Client.field1070);
         if(var0 != null && var0.field2719 != null) {
            ScriptEvent var1 = new ScriptEvent();
            var1.widget = var0;
            var1.field849 = var0.field2719;
            class56.method817(var1);
         }

         Client.spellSelected = false;
         class45.method647(var0);
      }
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1185476756"
   )
   static final void method780() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints == -1) {
            var0.delay = 0;
            class114.method2166(var0);
         } else {
            var0.unlink();
         }
      }

   }
}
