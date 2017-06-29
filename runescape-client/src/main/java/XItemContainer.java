import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bm")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("is")
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("w")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("a")
   @Export("stackSizes")
   int[] stackSizes;
   @ObfuscatedName("i")
   @Export("itemContainers")
   static XHashTable itemContainers;
   @ObfuscatedName("y")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;

   static {
      itemContainers = new XHashTable(32);
   }

   XItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("i")
   public static final void method1113(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            class162.method3046(var0 - 1L);
            class162.method3046(1L);
         } else {
            class162.method3046(var0);
         }

      }
   }
}
