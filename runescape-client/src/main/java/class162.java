import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class162 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -7794149063651249427L
   )
   static long field2277;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = -1710726819
   )
   static int field2279;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -818203574302375933L
   )
   static long field2280;
   @ObfuscatedName("no")
   @ObfuscatedGetter(
      intValue = 1494643699
   )
   static int field2282;
   @ObfuscatedName("de")
   static byte[][] field2283;

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   static final void method3139() {
      Client.field321.method3195(84);
      Client.field321.method2912(0);
   }

   class162() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "930349307"
   )
   public static void method3141() {
      NPCComposition.field2986.reset();
      NPCComposition.npcModelCache.reset();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-2003821592"
   )
   static String method3142() {
      String var0 = "";

      MessageNode var2;
      for(Iterator var1 = class47.field925.iterator(); var1.hasNext(); var0 = var0 + var2.name + ':' + var2.value + '\n') {
         var2 = (MessageNode)var1.next();
      }

      return var0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1218505904"
   )
   static int method3144() {
      return ++class47.field928 - 1;
   }
}
