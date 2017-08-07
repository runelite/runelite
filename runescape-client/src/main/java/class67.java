import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bj")
public class class67 extends class197 {
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -987586929
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1073529787
   )
   int field816;
   @ObfuscatedName("n")
   String field814;
   @ObfuscatedName("g")
   short field818;

   class67(String var1, int var2) {
      this.field816 = (int)(class170.currentTimeMs() / 1000L);
      this.field814 = var1;
      this.field818 = (short)var2;
   }
}
