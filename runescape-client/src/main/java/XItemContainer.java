import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bl")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("aq")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("gq")
   @ObfuscatedGetter(
      intValue = 487221659
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("i")
   @Export("stackSizes")
   int[] stackSizes;
   @ObfuscatedName("cm")
   static IndexData field765;
   @ObfuscatedName("j")
   static File field767;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1113993497
   )
   static int field768;
   @ObfuscatedName("n")
   @Export("itemContainers")
   static XHashTable itemContainers;
   @ObfuscatedName("p")
   @Export("itemIds")
   int[] itemIds;

   static {
      itemContainers = new XHashTable(32);
   }

   XItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }
}
