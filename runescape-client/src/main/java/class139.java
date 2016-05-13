import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import java.io.IOException;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("ep")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class class139 extends Canvas {
   @ObfuscatedName("s")
   Component field2153;
   @ObfuscatedName("nl")
   static class56 field2154;

   public final void update(Graphics var1) {
      this.field2153.update(var1);
   }

   public final void paint(Graphics var1) {
      this.field2153.paint(var1);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(ZS)V",
      garbageValue = "0"
   )
   static final void method2920(boolean var0) {
      class31.method677();
      ++client.field354;
      if(client.field354 >= 50) {
         client.field354 = 0;
         if(!client.field333 && null != class167.field2697) {
            client.field322.method2737(60);

            try {
               class167.field2697.method2964(client.field322.field2007, 0, client.field322.field2005);
               client.field322.field2005 = 0;
            } catch (IOException var2) {
               client.field333 = true;
            }
         }
      }

   }

   class139(Component var1) {
      this.field2153 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;S)V",
      garbageValue = "-801"
   )
   public static void method2923(class167 var0, class167 var1) {
      class44.field1034 = var0;
      class44.field1023 = var1;
      class44.field1037 = class44.field1034.method3249(3);
   }
}
