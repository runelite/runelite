import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public class class94 {
   @ObfuscatedName("p")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("messages")
   static final IterableHashTable messages;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   static final IterableDualNodeQueue field1401;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1636316499
   )
   static int field1402;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("NetCache_responseArchiveBuffer")
   public static Buffer NetCache_responseArchiveBuffer;
   @ObfuscatedName("ao")
   static int[] field1404;

   static {
      chatLineMap = new HashMap();
      messages = new IterableHashTable(1024);
      field1401 = new IterableDualNodeQueue();
      field1402 = 0;
   }
}
