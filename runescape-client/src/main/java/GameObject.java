import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 380351625
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 383061659
   )
   int field1631;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1756737629
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 679097371
   )
   @Export("y")
   int y;
   @ObfuscatedName("r")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1467927381
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1914941195
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -734534917
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 462527967
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1619610445
   )
   @Export("x")
   int x;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -379837671
   )
   int field1641;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 482653527
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1330566451
   )
   @Export("height")
   int height;
   @ObfuscatedName("ij")
   static class38 field1645;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -405243927
   )
   @Export("plane")
   int plane;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1882542095"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(Client.gameState != var0) {
         if(Client.gameState == 0) {
            class13.field143 = null;
            class112.field1780 = null;
            class22.field253 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field406 = 0;
            Client.field335 = 0;
            Client.field336 = 0;
         }

         if(var0 != 20 && var0 != 40 && class157.field2139 != null) {
            class157.field2139.method2113();
            class157.field2139 = null;
         }

         if(Client.gameState == 25) {
            Client.field535 = 0;
            Client.field357 = 0;
            Client.field358 = 1;
            Client.field359 = 0;
            Client.field360 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class31.method654(Projectile.canvas, WallObject.field1581, FileOnDisk.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class31.method654(Projectile.canvas, WallObject.field1581, FileOnDisk.indexSprites, false, 4);
            } else {
               class165.method3198();
            }
         } else {
            class31.method654(Projectile.canvas, WallObject.field1581, FileOnDisk.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;S)V",
      garbageValue = "1536"
   )
   public static void method1958(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "713584469"
   )
   public static void method1959(IndexDataBase var0) {
      FloorUnderlayDefinition.field2822 = var0;
   }
}
