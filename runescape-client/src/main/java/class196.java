import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class196 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 6974649182716079833L
   )
   static long field2587;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1552425260"
   )
   static void method3744() {
      if(class90.Login_isUsernameRemembered && class90.username != null && class90.username.length() > 0) {
         class90.field1386 = 1;
      } else {
         class90.field1386 = 0;
      }

   }

   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "(IZZZI)Ljn;",
      garbageValue = "1062606108"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class167.dat2File != null) {
         var4 = new IndexFile(var0, class167.dat2File, Size.idxFiles[var0], 1000000);
      }

      return new IndexData(var4, class19.indexStore255, var0, var1, var2, var3);
   }
}
