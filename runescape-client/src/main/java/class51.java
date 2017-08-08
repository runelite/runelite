import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class51 implements class104 {
   @ObfuscatedName("cl")
   static boolean field645;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Lcq;"
   )
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ldw;",
      garbageValue = "1736127050"
   )
   public AbstractSoundSystem vmethod1949() {
      return new SourceDataSoundSystem();
   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1087805458"
   )
   static final void method772(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         class83.menuAction(var1, var2, var3, var4, var5, var6, MouseInput.field725, MouseInput.field726);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1863267056"
   )
   public static void method768() {
      CombatInfo2.field3362.reset();
      CombatInfo2.spriteCache.reset();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "120"
   )
   static int method770() {
      return 9;
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-87"
   )
   static void method773(int var0) {
      for(IntegerNode var1 = (IntegerNode)Client.widgetFlags.method3549(); var1 != null; var1 = (IntegerNode)Client.widgetFlags.method3556()) {
         if((long)var0 == (var1.hash >> 48 & 65535L)) {
            var1.unlink();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-114720911"
   )
   static void method775() {
      class91.underlayIds = null;
      class61.overlayIds = null;
      class92.overlayPaths = null;
      class35.overlayRotations = null;
      class61.field748 = null;
      ChatLineBuffer.field1546 = null;
      class61.field756 = null;
      class20.blendedHue = null;
      GroundObject.blendedSaturation = null;
      class33.field473 = null;
      class61.field746 = null;
      class61.field742 = null;
   }
}
