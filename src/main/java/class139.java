import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("eo")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class class139 extends Canvas {
   @ObfuscatedName("a")
   Component field2141;
   @ObfuscatedName("ef")
   static class78[] field2142;
   @ObfuscatedName("mm")
   @ObfuscatedGetter(
      intValue = -2101250279
   )
   static int field2143;

   class139(Component var1) {
      this.field2141 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "16776960"
   )
   static String method3046(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   public final void paint(Graphics var1) {
      this.field2141.paint(var1);
   }

   public final void update(Graphics var1) {
      this.field2141.update(var1);
   }
}
