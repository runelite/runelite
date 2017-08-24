import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public class class97 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1227898789
   )
   static int field1534;
   @ObfuscatedName("i")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   static final IterableHashTable field1532;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   static final class202 field1536;

   static {
      chatLineMap = new HashMap();
      field1532 = new IterableHashTable(1024);
      field1536 = new class202();
      field1534 = 0;
   }
}
