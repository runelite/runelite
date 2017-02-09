import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class48 extends CacheableNode {
   @ObfuscatedName("c")
   static int[] field933;
   @ObfuscatedName("y")
   int[] field934;
   @ObfuscatedName("o")
   int[] field935;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -202288423
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("r")
   String[] field937;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1212778097
   )
   int field938;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1010022259
   )
   int field939;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1655120027
   )
   int field941;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1508396129
   )
   int field942;
   @ObfuscatedName("k")
   static NodeCache field944 = new NodeCache(128);

   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1108428937"
   )
   static final void method893(String var0) {
      if(!var0.equals("")) {
         Client.field321.method3195(84);
         Client.field321.method2912(class105.method1999(var0));
         Client.field321.method3097(var0);
      }
   }

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-9005894"
   )
   static boolean method894(Widget var0) {
      if(Client.field486) {
         if(class88.method1872(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "194591067"
   )
   public static boolean method896(int var0) {
      return (var0 & 1) != 0;
   }
}
