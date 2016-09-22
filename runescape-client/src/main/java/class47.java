import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class47 extends CacheableNode {
   @ObfuscatedName("d")
   public static NodeCache field1063 = new NodeCache(64);
   @ObfuscatedName("a")
   public static class170 field1064;
   @ObfuscatedName("bl")
   static class171 field1065;
   @ObfuscatedName("dc")
   static int[] field1067;
   @ObfuscatedName("an")
   static SpritePixels[] field1069;
   @ObfuscatedName("v")
   public boolean field1071 = false;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "-12162"
   )
   public void method981(Buffer var1) {
      while(true) {
         int var2 = var1.method2528();
         if(var2 == 0) {
            return;
         }

         this.method983(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1004563159"
   )
   void method983(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field1071 = true;
      }

   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "1897450911"
   )
   static final void method989(int var0, int var1, int var2, boolean var3) {
      if(class93.method2114(var0)) {
         class16.method186(Widget.widgets[var0], -1, var1, var2, var3);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "43"
   )
   public static boolean method991(char var0) {
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         return true;
      } else {
         if(var0 != 0) {
            char[] var1 = class168.field2726;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      }
   }
}
