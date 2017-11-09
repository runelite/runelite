import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("fo")
   @ObfuscatedGetter(
      intValue = -1629260605
   )
   static int field2105;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 969944669
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1246560289
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1502155677
   )
   @Export("height")
   int height;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1692951283
   )
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 251984857
   )
   @Export("y")
   int y;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1535671359
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 22585943
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1088565909
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 147170553
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -544097231
   )
   @Export("drawPriority")
   int drawPriority;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 395226911
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -681483349
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -740352485
   )
   @Export("flags")
   int flags;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([I[IB)V",
      garbageValue = "-86"
   )
   public static void method3003(int[] var0, int[] var1) {
      if(var0 != null && var1 != null) {
         BuildType.field3245 = var0;
         FaceNormal.field2051 = new int[var0.length];
         AbstractByteBuffer.field2513 = new byte[var0.length][][];

         for(int var2 = 0; var2 < BuildType.field3245.length; ++var2) {
            AbstractByteBuffer.field2513[var2] = new byte[var1[var2]][];
         }

      } else {
         BuildType.field3245 = null;
         FaceNormal.field2051 = null;
         AbstractByteBuffer.field2513 = null;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lhy;III)Lcw;",
      garbageValue = "1770880737"
   )
   static Script method3004(class226 var0, int var1, int var2) {
      int var3 = class89.method1797(var1, var0);
      Script var4 = class41.method640(var3, var0);
      if(var4 != null) {
         return var4;
      } else {
         int var5 = var0.field2871 + (var2 + 40000 << 8);
         var4 = class41.method640(var5, var0);
         return var4 != null?var4:null;
      }
   }
}
