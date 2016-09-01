import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("ci")
   @ObfuscatedGetter(
      intValue = -442208305
   )
   @Export("modelHeight")
   public int modelHeight = 1000;
   @ObfuscatedName("dd")
   static int[] field1505;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "-1904052091"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("ay")
   void vmethod2412(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod2412(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIB)V",
      garbageValue = "-7"
   )
   static void method1945(Player var0, int var1, int var2) {
      if(var1 == var0.animation && var1 != -1) {
         int var3 = class113.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field842 = 0;
            var0.actionAnimationDisable = var2;
            var0.field853 = 0;
         }

         if(var3 == 2) {
            var0.field853 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class113.getAnimation(var1).field1004 >= class113.getAnimation(var0.animation).field1004) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field842 = 0;
         var0.actionAnimationDisable = var2;
         var0.field853 = 0;
         var0.field822 = var0.field871;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Lclass45;",
      garbageValue = "714194156"
   )
   public static class45 method1946(int var0) {
      class45 var1 = (class45)class45.field1015.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class45.field1019.method3290(13, var0);
         var1 = new class45();
         var1.field1023 = var0;
         if(null != var2) {
            var1.method904(new Buffer(var2));
         }

         class45.field1015.put(var1, (long)var0);
         return var1;
      }
   }
}
