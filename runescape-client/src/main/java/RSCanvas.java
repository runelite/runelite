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
   @ObfuscatedName("g")
   public static int[] field1748;
   @ObfuscatedName("b")
   static int[] field1749;
   @ObfuscatedName("i")
   Component field1750;
   @ObfuscatedName("cu")
   static class208 field1753;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1700733583"
   )
   public static int method2049(int var0) {
      return var0 >> 11 & 63;
   }

   public final void update(Graphics var1) {
      this.field1750.update(var1);
   }

   public final void paint(Graphics var1) {
      this.field1750.paint(var1);
   }

   RSCanvas(Component var1) {
      this.field1750 = var1;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "73"
   )
   public static int method2052(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
