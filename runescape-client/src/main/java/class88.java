import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("Renderable")
public abstract class class88 extends class207 {
   @ObfuscatedName("lc")
   static class133 field1535;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 907002639
   )
   @Export("modelHeight")
   public int field1536 = 1000;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "-990594109"
   )
   @Export("getModel")
   protected class108 vmethod1992() {
      return null;
   }

   @ObfuscatedName("ai")
   void vmethod2384(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      class108 var10 = this.vmethod1992();
      if(var10 != null) {
         this.field1536 = var10.field1536;
         var10.vmethod2384(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;ZI)V",
      garbageValue = "1235163760"
   )
   public static void method1997(class170 var0, class170 var1, boolean var2) {
      class221.field3212 = var0;
      class42.field943 = var1;
      class42.field978 = var2;
   }
}
