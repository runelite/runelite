import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("et")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1342979519
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1420885365
   )
   @Export("height")
   int height;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 738968671
   )
   @Export("x")
   int x;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -817930801
   )
   @Export("y")
   int y;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1628553067
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1208197889
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1593201963
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -218677999
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1388335241
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 993335671
   )
   @Export("drawPriority")
   int drawPriority;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -867170549
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -287107299
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2019313501
   )
   @Export("flags")
   int flags;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "874939923"
   )
   @Export("loadClassFromDescriptor")
   static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Liv;B)Z",
      garbageValue = "-55"
   )
   public static boolean method3165(class245 var0) {
      return class245.field2960 == var0 || class245.field2961 == var0 || class245.field2962 == var0 || class245.field2969 == var0 || class245.field2963 == var0 || class245.field2964 == var0 || class245.field2965 == var0 || class245.field2966 == var0;
   }
}
