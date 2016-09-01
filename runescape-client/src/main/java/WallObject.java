import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("b")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1135857243
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -622223365
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 726605641
   )
   int field1571 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 997254449
   )
   int field1572;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2074012803
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 302451497
   )
   int field1576;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -77923323
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -581608087
   )
   @Export("y")
   int y;
   @ObfuscatedName("l")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("ai")
   static class171 field1585;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1759536787"
   )
   static void method2121(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      class175 var4 = (class175)class174.field2782.method3830(var2);
      if(var4 != null) {
         class174.field2783.method3918(var4);
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "89"
   )
   static void method2122() {
      int var0 = GameEngine.field2255;
      int var1 = GameEngine.field2256;
      int var2 = class47.field1050 - FaceNormal.field1499 - var0;
      int var3 = class112.field1970 - class212.field3175 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field377.method3079();
            int var5 = 0;
            int var6 = 0;
            if(var4 == FaceNormal.field1496) {
               Insets var7 = FaceNormal.field1496.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class112.field1970);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class47.field1050, var1);
            }

            if(var2 > 0) {
               var9.fillRect(class47.field1050 + var5 - var2, var6, var2, class112.field1970);
            }

            if(var3 > 0) {
               var9.fillRect(var5, var6 + class112.field1970 - var3, class47.field1050, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Lclass133;",
      garbageValue = "-1308662202"
   )
   public static class133 method2123(int var0) {
      class133[] var1 = class54.method1095();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class133 var3 = var1[var2];
         if(var3.field2107 == var0) {
            return var3;
         }
      }

      return null;
   }
}
