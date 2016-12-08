import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class22 extends class119 {
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = 489833249
   )
   static int field244;
   @ObfuscatedName("iu")
   static Widget field245;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-1652788895"
   )
   public boolean vmethod2239(int var1, int var2, int var3, CollisionData var4) {
      return super.field1871 == var2 && var3 == super.field1865;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-868"
   )
   static void method205(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field696[var5]) {
            var2[var4] = World.field696[var5];
            var3[var4] = World.field675[var5];
            ++var4;
         }
      }

      World.field696 = var2;
      World.field675 = var3;
      class7.method87(World.worldList, 0, World.worldList.length - 1, World.field696, World.field675);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2116407327"
   )
   static void method207(int var0) {
      if(var0 != -1) {
         if(class2.method25(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2288 != null) {
                  class18 var4 = new class18();
                  var4.field193 = var3;
                  var4.field203 = var3.field2288;
                  XItemContainer.method162(var4, 2000000);
               }
            }

         }
      }
   }
}
