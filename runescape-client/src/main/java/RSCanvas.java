import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1038937693
   )
   static int field633;
   @ObfuscatedName("d")
   @Export("component")
   Component component;

   RSCanvas(Component var1) {
      this.component = var1;
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "5"
   )
   public static byte[] method803() {
      byte[] var0 = new byte[24];

      try {
         class155.field2223.seek(0L);
         class155.field2223.read(var0);

         int var1;
         for(var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            ;
         }

         if(var1 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var2 = 0; var2 < 24; ++var2) {
            var0[var2] = -1;
         }
      }

      return var0;
   }
}
