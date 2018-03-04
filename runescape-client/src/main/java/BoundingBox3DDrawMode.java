import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("BoundingBox3DDrawMode")
public class BoundingBox3DDrawMode {
   @ObfuscatedName("pg")
   @ObfuscatedGetter(
      intValue = 1955412097
   )
   static int field275;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   @Export("ON_MOUSEOVER")
   public static final BoundingBox3DDrawMode ON_MOUSEOVER;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   @Export("ALWAYS")
   public static final BoundingBox3DDrawMode ALWAYS;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -435531663
   )
   public static int field276;
   @ObfuscatedName("o")
   static int[] field271;
   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "Ldb;"
   )
   static TextureProvider field272;

   static {
      ON_MOUSEOVER = new BoundingBox3DDrawMode();
      ALWAYS = new BoundingBox3DDrawMode();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-592607648"
   )
   @Export("nextPowerOfTwo")
   public static int nextPowerOfTwo(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "1803273881"
   )
   static int method64(int var0, Script var1, boolean var2) {
      if(var0 == 5630) {
         Client.field886 = 250;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1318499227"
   )
   static final void method62() {
      for(int var0 = 0; var0 < class93.playerIndexesCount; ++var0) {
         Player var1 = Client.cachedPlayers[class93.playerIndices[var0]];
         var1.method1141();
      }

      class66.method1081();
      if(WidgetNode.clanMemberManager != null) {
         WidgetNode.clanMemberManager.method5565();
      }

   }
}
