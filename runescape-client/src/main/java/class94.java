import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public class class94 {
   @ObfuscatedName("s")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   @Export("messages")
   static final IterableHashTable messages;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static final IterableDualNodeQueue field1413;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1439843581
   )
   static int field1414;
   @ObfuscatedName("l")
   static int[] field1417;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   static Widget field1418;

   static {
      chatLineMap = new HashMap();
      messages = new IterableHashTable(1024);
      field1413 = new IterableDualNodeQueue();
      field1414 = 0;
   }
}
