import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
@Implements("Size")
public class Size {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   public static final Size field371;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   public static final Size field363;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Le;"
   )
   public static final Size field368;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Ldy;"
   )
   @Export("idxFiles")
   public static CacheFile[] idxFiles;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1752042203
   )
   static int field369;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "Lfo;"
   )
   static Task field364;
   @ObfuscatedName("d")
   final String field365;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -163371543
   )
   final int field362;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1921369821
   )
   final int field367;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1135391441
   )
   final int field372;

   static {
      field371 = new Size("SMALL", 1, 0, 4);
      field363 = new Size("MEDIUM", 0, 1, 2);
      field368 = new Size("LARGE", 2, 2, 0);
   }

   Size(String var1, int var2, int var3, int var4) {
      this.field365 = var1;
      this.field362 = var2;
      this.field367 = var3;
      this.field372 = var4;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(FB)Z",
      garbageValue = "5"
   )
   boolean method192(float var1) {
      return var1 >= (float)this.field372;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Le;",
      garbageValue = "-1822528271"
   )
   static Size method195(int var0) {
      Size[] var1 = new Size[]{field368, field371, field363};
      Size[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Size var4 = var2[var3];
         if(var0 == var4.field367) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-121"
   )
   static final void method199() {
      Object var10000 = null;
      String var0 = "Your ignore list is full. Max of 100 for free users, and 400 for members";
      class57.sendGameMessage(30, "", var0);
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-537016480"
   )
   static void method198() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.menuBooleanArray[0] = false;
      Client.menuOptionCount = 1;
   }
}
