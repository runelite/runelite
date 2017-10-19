import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("p")
   @Export("validInterfaces")
   static boolean[] validInterfaces;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 275421763
   )
   int field3200;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   @Export("index")
   IndexFile index;
   @ObfuscatedName("s")
   byte[] field3197;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   @Export("data")
   IndexData data;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Lio;",
      garbageValue = "247927451"
   )
   public static CombatInfo2 method4185(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field3360.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field3367.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.method4482(new Buffer(var2));
         }

         CombatInfo2.field3360.put(var1, (long)var0);
         return var1;
      }
   }
}
