import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1683817059
   )
   int field2049;
   @ObfuscatedName("e")
   int[] field2050;
   @ObfuscatedName("t")
   int[][] field2052;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -357361923
   )
   static int field2053;
   @ObfuscatedName("o")
   static ModIcon field2055;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 155612475
   )
   int field2057;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "-27182272"
   )
   static void method2575(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class56.field687.startsWith("win") && !var3) {
            class50.method725(var0, 0, "openjs");
            return;
         }

         if(class56.field687.startsWith("mac")) {
            class50.method725(var0, 1, var2);
            return;
         }

         class50.method725(var0, 2, "openjs");
      } else {
         class50.method725(var0, 3, "openjs");
      }

   }

   FrameMap(int var1, byte[] var2) {
      this.field2057 = var1;
      Buffer var3 = new Buffer(var2);
      this.field2049 = var3.readUnsignedByte();
      this.field2050 = new int[this.field2049];
      this.field2052 = new int[this.field2049][];

      int var4;
      for(var4 = 0; var4 < this.field2049; ++var4) {
         this.field2050[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field2049; ++var4) {
         this.field2052[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field2049; ++var4) {
         for(int var5 = 0; var5 < this.field2052[var4].length; ++var5) {
            this.field2052[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1179747000"
   )
   public static int method2576(int var0) {
      var0 = (var0 >>> 1 & 1431655765) + (var0 & 1431655765);
      var0 = (var0 & 858993459) + (var0 >>> 2 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }
}
