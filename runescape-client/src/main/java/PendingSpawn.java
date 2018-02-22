import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 212103781
   )
   @Export("level")
   int level;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1317420265
   )
   @Export("type")
   int type;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1276615505
   )
   @Export("x")
   int x;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -340310357
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -570938303
   )
   int field1090;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1464866107
   )
   int field1085;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1149348317
   )
   int field1086;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1742407
   )
   @Export("id")
   int id;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1408006351
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1975632781
   )
   int field1084;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 627176435
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -971995335
   )
   @Export("hitpoints")
   int hitpoints;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Ljg;",
      garbageValue = "-192896510"
   )
   public static VarPlayerType method1617(int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
         var1 = new VarPlayerType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarPlayerType.varplayers.put(var1, (long)var0);
         return var1;
      }
   }
}
