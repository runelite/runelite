import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public class class96 {
   @ObfuscatedName("m")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   static final IterableHashTable field1433;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   static final class208 field1427;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1606969191
   )
   static int field1428;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1838596207
   )
   static int field1429;
   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;

   static {
      chatLineMap = new HashMap();
      field1433 = new IterableHashTable(1024);
      field1427 = new class208();
      field1428 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-517583751"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      DynamicObject.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "-103"
   )
   static final String method1906(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }
}
