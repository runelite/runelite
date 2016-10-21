import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1475794789
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2096748807
   )
   @Export("x")
   int x;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 598239035
   )
   @Export("y")
   int y;
   @ObfuscatedName("dr")
   @ObfuscatedGetter(
      intValue = 366697215
   )
   static int field1737;
   @ObfuscatedName("v")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("b")
   @Export("top")
   Renderable top;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -184055365
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 37763273
   )
   @Export("height")
   int height;
   @ObfuscatedName("t")
   @Export("bottom")
   Renderable bottom;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BZB)Ljava/lang/Object;",
      garbageValue = "-128"
   )
   public static Object method2235(byte[] var0, boolean var1) {
      if(null == var0) {
         return null;
      } else {
         if(var0.length > 136 && !class128.field2092) {
            try {
               class121 var2 = new class121();
               var2.vmethod2810(var0);
               return var2;
            } catch (Throwable var3) {
               class128.field2092 = true;
            }
         }

         return var0;
      }
   }
}
