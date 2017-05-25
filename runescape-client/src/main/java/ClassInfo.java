import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jc")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("u")
   int[] field3736;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 370131819
   )
   int field3737;
   @ObfuscatedName("t")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("q")
   int[] field3739;
   @ObfuscatedName("g")
   @Export("fields")
   Field[] fields;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1843389735
   )
   int field3741;
   @ObfuscatedName("p")
   @Export("args")
   byte[][][] args;
   @ObfuscatedName("ox")
   @Export("clanMembers")
   static XClanMember[] clanMembers;
   @ObfuscatedName("v")
   int[] field3744;
}
