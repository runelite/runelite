import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
@Implements("FileSystem")
public class FileSystem extends Node {
   @ObfuscatedName("r")
   public static int[] field3207;
   @ObfuscatedName("ar")
   protected static String field3202;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1856203529
   )
   int field3206;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   @Export("index")
   public IndexFile index;
   @ObfuscatedName("k")
   public byte[] field3203;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("data")
   public IndexData data;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgc;IIB)I",
      garbageValue = "114"
   )
   static int method4214(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }
}
