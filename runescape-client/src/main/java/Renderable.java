import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = -1486058355
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("lj")
   static class133 field1544;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 16595453
   )
   @Export("modelHeight")
   public int modelHeight = 1000;

   @ObfuscatedName("at")
   void vmethod2338(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(null != var10) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod2338(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "1853658170"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[Lclass156;",
      garbageValue = "-2145942988"
   )
   static class156[] method1945() {
      return new class156[]{class156.field2343, class156.field2345, class156.field2341, class156.field2342};
   }

   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1916865402"
   )
   static final void method1946(String var0) {
      if(!var0.equals("")) {
         Client.field323.method2801(230);
         Client.field323.method2513(ChatMessages.method229(var0));
         Client.field323.method2519(var0);
      }
   }
}
