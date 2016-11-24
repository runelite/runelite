import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("fx")
   @ObfuscatedGetter(
      intValue = 637513739
   )
   static int field223;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -48150117
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 221119997
   )
   @Export("type")
   int type;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 874592105
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   @Export("name")
   String name;
   @ObfuscatedName("w")
   @Export("sender")
   String sender;
   @ObfuscatedName("ab")
   static boolean field229;
   @ObfuscatedName("qx")
   protected static java.awt.Frame field230;
   @ObfuscatedName("r")
   @Export("value")
   String value;
   @ObfuscatedName("rg")
   protected static String field234;
   @ObfuscatedName("g")
   public static short[] field235;

   MessageNode(int var1, String var2, String var3, String var4) {
      int var5 = ++class47.field927 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1015751294"
   )
   void method215(int var1, String var2, String var3, String var4) {
      int var5 = ++class47.field927 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZB)V",
      garbageValue = "-56"
   )
   public static void method217(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class114.field1794.startsWith("win")) {
            class16.method197(var0, 0, "openjs");
         } else if(class114.field1794.startsWith("mac")) {
            class16.method197(var0, 1, "openjs");
         } else {
            class16.method197(var0, 2, "openjs");
         }
      } else {
         class16.method197(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass145;B)V",
      garbageValue = "-41"
   )
   static final void method220(int var0, int var1, int var2, int var3, SpritePixels var4, class145 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapScale + Client.mapAngle & 2047;
         int var8 = class84.field1444[var7];
         int var9 = class84.field1445[var7];
         var8 = 256 * var8 / (256 + Client.mapScaleDelta);
         var9 = 256 * var9 / (256 + Client.mapScaleDelta);
         int var10 = var3 * var8 + var2 * var9 >> 16;
         int var11 = var9 * var3 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         FaceNormal.field1555.method4204(4 + var0 + 94 + var14 - 10, 83 + var1 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class40.method785(var0, var1, var2, var3, var4, var5);
      }

   }
}
