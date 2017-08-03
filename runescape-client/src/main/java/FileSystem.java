import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("f")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1053808249
   )
   int field3180;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lfv;"
   )
   @Export("index")
   public IndexFile index;
   @ObfuscatedName("q")
   public byte[] field3181;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("data")
   public IndexData data;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Lip;",
      garbageValue = "1894419434"
   )
   public static class254 method4110(int var0) {
      class254 var1 = (class254)class254.field3392.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class254.field3410.getConfigData(32, var0);
         var1 = new class254();
         if(var2 != null) {
            var1.method4473(new Buffer(var2));
         }

         class254.field3392.put(var1, (long)var0);
         return var1;
      }
   }
}
