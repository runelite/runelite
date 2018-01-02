import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public class class133 {
   @ObfuscatedName("a")
   @Export("Viewport_containsMouse")
   public static boolean Viewport_containsMouse;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -730306591
   )
   @Export("Viewport_mouseX")
   public static int Viewport_mouseX;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -671398125
   )
   @Export("Viewport_mouseY")
   public static int Viewport_mouseY;
   @ObfuscatedName("k")
   @Export("Viewport_false0")
   public static boolean Viewport_false0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1417203043
   )
   static int field1884;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1771911547
   )
   static int field1881;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 536676545
   )
   static int field1886;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 12111091
   )
   @Export("Viewport_entityCountAtMouse")
   public static int Viewport_entityCountAtMouse;
   @ObfuscatedName("y")
   @Export("Viewport_entityIdsAtMouse")
   public static int[] Viewport_entityIdsAtMouse;

   static {
      Viewport_containsMouse = false;
      Viewport_mouseX = 0;
      Viewport_mouseY = 0;
      Viewport_false0 = false;
      Viewport_entityCountAtMouse = 0;
      Viewport_entityIdsAtMouse = new int[1000];
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(IIIILks;Lhy;B)V",
      garbageValue = "28"
   )
   @Export("worldToMinimap")
   static final void worldToMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, SpritePixels2 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.field2715 / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         class47.mapedge.method5193(var15 + (var0 + var5.field2715 / 2 - var17 / 2), var5.field2716 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         class37.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}
