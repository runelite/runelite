import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
@Implements("MapLabel")
public class MapLabel {
   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("indexCache10")
   static IndexData indexCache10;
   @ObfuscatedName("w")
   @Export("text")
   String text;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1203180175
   )
   int field192;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -270775529
   )
   int field193;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ls;"
   )
   @Export("fontSize")
   Size fontSize;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILs;)V"
   )
   MapLabel(String var1, int var2, int var3, Size var4) {
      this.text = var1;
      this.field192 = var2;
      this.field193 = var3;
      this.fontSize = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1078611233"
   )
   static void method307(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field958[var5] != var0) {
            var2[var4] = World.field958[var5];
            var3[var4] = World.field969[var5];
            ++var4;
         }
      }

      World.field958 = var2;
      World.field969 = var3;
      UrlRequest.method3137(class143.worldList, 0, class143.worldList.length - 1, World.field958, World.field969);
   }
}
