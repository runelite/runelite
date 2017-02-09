import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 40754033
   )
   @Export("height")
   int height;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -86230869
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 691719557
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -484814025
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -471364253
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1028189815
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -627130765
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2076095165
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1916379899
   )
   int field1614;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1974480323
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1720341121
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1821318125
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -557654909
   )
   int field1618;
   @ObfuscatedName("w")
   @Export("renderable")
   public Renderable renderable;

   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "544438409"
   )
   static final void method1909(String var0) {
      if(null != class85.clanMembers) {
         Client.field321.method3195(40);
         Client.field321.method2912(class105.method1999(var0));
         Client.field321.method3097(var0);
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "43862053"
   )
   static final void method1910() {
      int[] var0 = class45.field902;

      int var1;
      for(var1 = 0; var1 < class45.field901; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(null != var2 && var2.field606 > 0) {
            --var2.field606;
            if(var2.field606 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field317; ++var1) {
         int var4 = Client.field554[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(var3 != null && var3.field606 > 0) {
            --var3.field606;
            if(var3.field606 == 0) {
               var3.overhead = null;
            }
         }
      }

   }
}
