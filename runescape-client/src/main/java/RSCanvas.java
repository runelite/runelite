import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("dj")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("j")
   Component field1764;
   @ObfuscatedName("bj")
   static class184 field1765;
   @ObfuscatedName("g")
   static byte[][] field1766;

   RSCanvas(Component var1) {
      this.field1764 = var1;
   }

   public final void paint(Graphics var1) {
      this.field1764.paint(var1);
   }

   public final void update(Graphics var1) {
      this.field1764.update(var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZB)V",
      garbageValue = "53"
   )
   public static void method2137(String var0, boolean var1, boolean var2) {
      class171.method3267(var0, var1, "openjs", var2);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(LActor;B)V",
      garbageValue = "8"
   )
   static final void method2138(Actor var0) {
      if(Client.gameCycle == var0.field647 || var0.animation == -1 || var0.actionAnimationDisable != 0 || 1 + var0.field659 > class168.getAnimation(var0.animation).frameLenghts[var0.actionFrame]) {
         int var1 = var0.field647 - var0.field671;
         int var2 = Client.gameCycle - var0.field671;
         int var3 = var0.field672 * 64 + var0.field650 * 128;
         int var4 = var0.field672 * 64 + var0.field669 * 128;
         int var5 = var0.field672 * 64 + var0.field663 * 128;
         int var6 = var0.field672 * 64 + var0.field670 * 128;
         var0.x = (var2 * var5 + (var1 - var2) * var3) / var1;
         var0.y = (var6 * var2 + var4 * (var1 - var2)) / var1;
      }

      var0.field683 = 0;
      var0.field676 = var0.field673;
      var0.angle = var0.field676;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1292896618"
   )
   static final void method2139(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         class8.field84.field717 = !class8.field84.field717;
         class0.method10();
         if(class8.field84.field717) {
            class30.sendGameMessage(99, "", "Roofs are now all hidden");
         } else {
            class30.sendGameMessage(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.field392 = !Client.field392;
      }

      if(Client.field480 >= 2) {
         if(var0.equalsIgnoreCase("fpson")) {
            Client.field392 = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.field392 = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            class16.method203();
         }

         if(var0.equalsIgnoreCase("errortest") && Client.field381 == 2) {
            throw new RuntimeException();
         }
      }

      Client.secretCipherBuffer1.putOpcode(13);
      Client.secretCipherBuffer1.putByte(var0.length() + 1);
      Client.secretCipherBuffer1.method2822(var0);
   }
}
