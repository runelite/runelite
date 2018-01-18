import java.awt.FontMetrics;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public class class96 {
   @ObfuscatedName("n")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   @Export("messages")
   static final IterableHashTable messages;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   static final IterableDualNodeQueue field1424;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -721485145
   )
   static int field1427;
   @ObfuscatedName("ad")
   static FontMetrics field1428;

   static {
      chatLineMap = new HashMap();
      messages = new IterableHashTable(1024);
      field1424 = new IterableDualNodeQueue();
      field1427 = 0;
   }
}
