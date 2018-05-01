import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kl")
public abstract class class297 implements Comparator {
   @ObfuscatedName("c")
   static int[][] field3834;
   @ObfuscatedName("e")
   Comparator field3835;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;I)V",
      garbageValue = "-1146777239"
   )
   final void method5340(Comparator var1) {
      if(this.field3835 == null) {
         this.field3835 = var1;
      } else if(this.field3835 instanceof class297) {
         ((class297)this.field3835).method5340(var1);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lkg;Lkg;I)I",
      garbageValue = "-2009192937"
   )
   protected final int method5341(Nameable var1, Nameable var2) {
      return this.field3835 == null?0:this.field3835.compare(var1, var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(Liz;III)V",
      garbageValue = "1294500495"
   )
   static void method5347(Widget var0, int var1, int var2) {
      if(var0.dynamicX == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.dynamicX == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.dynamicX == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.dynamicX == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.dynamicX == 4) {
         var0.relativeX = (var0.originalX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.dynamicY == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.dynamicY == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.dynamicY == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.dynamicY == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.dynamicY == 4) {
         var0.relativeY = (var2 * var0.originalY >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

   }
}
