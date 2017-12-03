import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("Size")
public class Size {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   public static final Size field335;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   public static final Size field333;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lv;"
   )
   public static final Size field334;
   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   @Export("crossSprites")
   static SpritePixels[] crossSprites;
   @ObfuscatedName("jk")
   @ObfuscatedGetter(
      intValue = -557930467
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("k")
   final String field343;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1891351419
   )
   final int field332;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -73299465
   )
   final int field337;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1807549591
   )
   final int field338;

   static {
      field335 = new Size("SMALL", 0, 0, 4);
      field333 = new Size("MEDIUM", 1, 1, 2);
      field334 = new Size("LARGE", 2, 2, 0);
   }

   Size(String var1, int var2, int var3, int var4) {
      this.field343 = var1;
      this.field332 = var2;
      this.field337 = var3;
      this.field338 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(FB)Z",
      garbageValue = "-23"
   )
   boolean method177(float var1) {
      return var1 >= (float)this.field338;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[Lfa;",
      garbageValue = "876332136"
   )
   public static class173[] method173() {
      return new class173[]{class173.field2427, class173.field2428, class173.field2422, class173.field2423, class173.field2424, class173.field2425, class173.field2426, class173.field2421, class173.field2420, class173.field2430};
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1428230951"
   )
   static int method178(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lcp;I)V",
      garbageValue = "-1126597833"
   )
   static void method176(World var0) {
      if(var0.method1518() != Client.isMembers) {
         Client.isMembers = var0.method1518();
         class94.method1760(var0.method1518());
      }

      class11.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      GraphicsObject.port1 = Client.socketType == 0?43594:var0.id + 40000;
      FileOnDisk.port2 = Client.socketType == 0?443:var0.id + 50000;
      class268.myWorldPort = GraphicsObject.port1;
   }
}
