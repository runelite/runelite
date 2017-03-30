import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1727123557
   )
   @Export("x")
   int x;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1892917663
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -834189223
   )
   int field1567;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -791089787
   )
   int field1568;
   @ObfuscatedName("l")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1883861491
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -938804493
   )
   int field1572 = 0;
   @ObfuscatedName("pn")
   static class230 field1573;
   @ObfuscatedName("kp")
   static class112 field1574;
   @ObfuscatedName("o")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 47385849
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("bl")
   static IndexData field1581;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   static final void method1930() {
      if(class20.field233 != null) {
         class20.field233.method2113();
         class20.field233 = null;
      }

      class20.method189();
      CombatInfo1.region.method1736();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2346();
      }

      System.gc();
      CollisionData.method2347(2);
      Client.field541 = -1;
      Client.field542 = false;
      class7.method88();
      GameObject.setGameState(10);
   }
}
