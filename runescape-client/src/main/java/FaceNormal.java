import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1863647629
   )
   @Export("z")
   int z;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1011582913
   )
   @Export("y")
   int y;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1253628583
   )
   @Export("x")
   int x;
   @ObfuscatedName("ic")
   static Widget field1558;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;B)V",
      garbageValue = "-103"
   )
   public static void method1864(String var0, Throwable var1) {
      var1.printStackTrace();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2058202478"
   )
   static final void method1865() {
      int[] var0 = class45.field903;

      int var1;
      for(var1 = 0; var1 < class45.field908; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(null != var2 && var2.field614 > 0) {
            --var2.field614;
            if(var2.field614 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field322; ++var1) {
         int var4 = Client.field323[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(var3 != null && var3.field614 > 0) {
            --var3.field614;
            if(var3.field614 == 0) {
               var3.overhead = null;
            }
         }
      }

   }
}
