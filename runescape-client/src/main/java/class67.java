import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public class class67 extends class196 {
   @ObfuscatedName("p")
   String field809;
   @ObfuscatedName("i")
   short field813;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 511844813
   )
   int field814;

   class67(String var1, int var2) {
      this.field814 = (int)(class134.method2587() / 1000L);
      this.field809 = var1;
      this.field813 = (short)var2;
   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "-1395464820"
   )
   static final void method1064(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.method3622(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.method3608()) {
         if(var0 == var10.level && var1 == var10.x && var10.y == var2 && var10.type == var3) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         class267.method4888(var9);
         Client.pendingSpawns.method3634(var9);
      }

      var9.id = var4;
      var9.field1207 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }
}
