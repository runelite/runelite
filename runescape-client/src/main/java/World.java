import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("World")
public class World {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1157284435
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2138339791
   )
   static int field658 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 600151841
   )
   static int field659 = 0;
   @ObfuscatedName("g")
   static int[] field660 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("i")
   static int[] field661 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1630477671
   )
   @Export("location")
   int location;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -797882227
   )
   @Export("id")
   int id;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1935925357
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("j")
   @Export("address")
   String address;
   @ObfuscatedName("q")
   @Export("activity")
   String activity;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1629260139
   )
   @Export("index")
   int index;
   @ObfuscatedName("z")
   @Export("worldList")
   static World[] worldList;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2089647285"
   )
   boolean method619() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "10"
   )
   boolean method620() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1146270391"
   )
   boolean method623() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "854792113"
   )
   boolean method624() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "997400924"
   )
   static void method633(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class141.field2205.startsWith("win") && !var3) {
            class13.method164(var0, 0);
            return;
         }

         if(class141.field2205.startsWith("mac")) {
            class20.method558(var0, 1, var2);
            return;
         }

         class13.method164(var0, 2);
      } else {
         class13.method164(var0, 3);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-119"
   )
   boolean method643() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-25"
   )
   boolean method649() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-984681071"
   )
   static void method664(int var0, int var1, int var2, int var3) {
      Widget var4 = class38.method781(var0, var1);
      if(var4 != null && null != var4.field2819) {
         class0 var5 = new class0();
         var5.field2 = var4;
         var5.field7 = var4.field2819;
         class1.method9(var5, 200000);
      }

      Client.field437 = var3;
      Client.field435 = true;
      XClanMember.field638 = var0;
      Client.field436 = var1;
      class50.field1116 = var2;
      class53.method1101(var4);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-24"
   )
   static void method666() {
      int var0 = GameEngine.field2270;
      int var1 = GameEngine.field2263;
      int var2 = class31.field720 - class159.field2374 - var0;
      int var3 = class146.field2258 - class92.field1643 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field277.method3058();
            int var5 = 0;
            int var6 = 0;
            if(WallObject.field1621 == var4) {
               Insets var7 = WallObject.field1621.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class146.field2258);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class31.field720, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + class31.field720 - var2, var6, var2, class146.field2258);
            }

            if(var3 > 0) {
               var9.fillRect(var5, var6 + class146.field2258 - var3, class31.field720, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }
}
