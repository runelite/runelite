import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 747137507
   )
   @Export("modelHeight")
   public int modelHeight = 1000;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-93"
   )
   static int method1942() {
      return ++class11.field185 - 1;
   }

   @ObfuscatedName("ao")
   void vmethod2370(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(null != var10) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod2370(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1050401255"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "106"
   )
   public static void method1949(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(class140.keyboard);
      var0.addFocusListener(class140.keyboard);
   }
}
