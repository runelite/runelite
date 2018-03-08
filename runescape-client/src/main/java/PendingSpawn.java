import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1271334225
   )
   @Export("level")
   int level;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1791403159
   )
   @Export("type")
   int type;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1971824699
   )
   @Export("x")
   int x;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1952681829
   )
   @Export("y")
   int y;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1363990175
   )
   int field1125;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1245381677
   )
   int field1126;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1550544765
   )
   int field1121;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1313820901
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1948648261
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 131457153
   )
   int field1129;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -571366851
   )
   @Export("delay")
   int delay;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1350090127
   )
   @Export("hitpoints")
   int hitpoints;

   PendingSpawn() {
      this.delay = 0;
      this.hitpoints = -1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Ljh;",
      garbageValue = "-1390673728"
   )
   public static class281 method1649(int var0) {
      class281 var1 = (class281)class281.field3573.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class281.field3585.getConfigData(32, var0);
         var1 = new class281();
         if(var2 != null) {
            var1.method4952(new Buffer(var2));
         }

         class281.field3573.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljc;I)V",
      garbageValue = "989690234"
   )
   public static void method1647(IndexDataBase var0) {
      Enum.EnumDefinition_indexCache = var0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "785970621"
   )
   static void method1648(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1210[var5] != var0) {
            var2[var4] = World.field1210[var5];
            var3[var4] = World.field1204[var5];
            ++var4;
         }
      }

      World.field1210 = var2;
      World.field1204 = var3;
      ItemLayer.method2592(World.worldList, 0, World.worldList.length - 1, World.field1210, World.field1204);
   }
}
