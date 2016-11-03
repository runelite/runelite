import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class20 extends Node {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 767501003
   )
   int field564;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1623049223
   )
   int field565;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -744803281
   )
   int field566;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1111059239
   )
   int field567;
   @ObfuscatedName("is")
   @ObfuscatedGetter(
      intValue = 2022219301
   )
   static int field569;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "76"
   )
   void method567(int var1, int var2, int var3, int var4) {
      this.field566 = var1;
      this.field565 = var2;
      this.field564 = var3;
      this.field567 = var4;
   }

   class20(int var1, int var2, int var3, int var4) {
      this.field566 = var1;
      this.field565 = var2;
      this.field564 = var3;
      this.field567 = var4;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "301644909"
   )
   static final void method570(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = MessageNode.field800.method4049(var0, 250);
      int var6 = MessageNode.field800.method4050(var0, 250) * 13;
      class82.method1885(var3 - var2, var4 - var2, var2 + var2 + var5, var2 + var2 + var6, 0);
      class82.method1845(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var2 + var6, 16777215);
      MessageNode.field800.method4055(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      ObjectComposition.method834(var3 - var2, var4 - var2, var5 + var2 + var2, var6 + var2 + var2);
      if(var1) {
         try {
            Graphics var7 = VertexNormal.canvas.getGraphics();
            Sequence.bufferProvider.draw(var7, 0, 0);
         } catch (Exception var8) {
            VertexNormal.canvas.repaint();
         }
      } else {
         Buffer.method2597(var3, var4, var5, var6);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "1543500811"
   )
   static final void method571(Actor var0) {
      if(var0.field855 == Client.gameCycle || var0.animation == -1 || var0.actionAnimationDisable != 0 || 1 + var0.field839 > NPC.getAnimation(var0.animation).field1008[var0.actionFrame]) {
         int var1 = var0.field855 - var0.field871;
         int var2 = Client.gameCycle - var0.field871;
         int var3 = var0.field841 * 64 + var0.field867 * 128;
         int var4 = var0.field869 * 128 + var0.field841 * 64;
         int var5 = var0.field829 * 128 + var0.field841 * 64;
         int var6 = var0.field870 * 128 + var0.field841 * 64;
         var0.x = (var2 * var5 + var3 * (var1 - var2)) / var1;
         var0.y = ((var1 - var2) * var4 + var6 * var2) / var1;
      }

      var0.field883 = 0;
      var0.field876 = var0.field873;
      var0.angle = var0.field876;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)I",
      garbageValue = "120"
   )
   public static int method572(String var0) {
      return var0.length() + 2;
   }
}
